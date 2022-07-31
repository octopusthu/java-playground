package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * This solution is NOT thread-safe.
 *
 * @author octopusthu@gmail.com
 */
public class P460HardLFUCache {

  static class LFUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache;
    private final Map<Integer, Integer> keyFrequency;
    private final Map<Integer, List<Integer>> frequencyKeys;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      this.cache = new HashMap<>(this.capacity);
      this.keyFrequency = new HashMap<>(this.capacity);
      this.frequencyKeys = new HashMap<>(this.capacity);
    }

    public int get(int key) {

      /* 1. Get from the cache */
      Integer value = this.cache.get(key);
      if (value == null) {
        return -1;
      }

      /* 2. Update usage */
      this.use(key);

      /* 3. Return value */
      return value;
    }

    public void put(int key, int value) {

      if (this.capacity == 0) {
        return;
      }

      /* 1. If the cache WOULD BE full, evict an element */
      if (this.cache.size() == this.capacity && !this.cache.containsKey(key)) {
        this.evict(key);
      }

      /* 2. Cache it */
      this.cache.put(key, value);

      /* 3. Update usage */
      this.use(key);
    }

    private void use(int key) {
      Integer frequency = this.keyFrequency.get(key);
      if (frequency == null) {
        frequency = 0;
      }
      this.keyFrequency.put(key, ++frequency);
      List<Integer> keys = this.frequencyKeys.computeIfAbsent(frequency, k -> new ArrayList<>());
      if (keys.isEmpty() || !keys.get(keys.size() - 1).equals(key)) {
        keys.add(key);
      }
    }

    private void evict(Integer avoid) {
      int frequency = 0;
      List<Integer> list = null;
      Integer key = null;
      do {
        if (list == null) {
          frequency++;
          list = this.frequencyKeys.get(frequency);
        }
        if (list == null || list.isEmpty()) {
          list = null;
        } else {
          key = list.remove(0);
        }
      } while (key == null || list == null || !this.cache.containsKey(key) || list.contains(key) || key.equals(avoid) || this.keyFrequency.get(key) != frequency);
      this.cache.remove(key);
      this.keyFrequency.remove(key);
    }
  }

  static class P146MediumLFUCacheTest {

    static class LFUCacheTester {

      static Integer[] test(int[][] data) {
        Integer[] output = new Integer[data.length];
        LFUCache lfuCache = new LFUCache(data[0][0]);
        output[0] = null;
        for (int i = 1; i < data.length; i++) {
          if (data[i].length == 2) {
            lfuCache.put(data[i][0], data[i][1]);
            output[i] = null;
            continue;
          }
          if (data[i].length == 1) {
            output[i] = lfuCache.get(data[i][0]);
            continue;
          }
          throw new IllegalArgumentException("Invalid input data[" + i + "]: " + Arrays.toString(data[i]));
        }
        return output;
      }
    }

    @Test
    void testLFUCache() {
      Assertions.assertArrayEquals(
        new Integer[]{
          null, null, null, 1, null, -1, 3, null, -1, 3, 4},
        LFUCacheTester.test(new int[][]{
          {2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {3}, {4, 4}, {1}, {3}, {4}}));

      Assertions.assertArrayEquals(
        new Integer[]{
          null, null, 1, 1, null, null, 1},
        LFUCacheTester.test(new int[][]{
          {1}, {1, 1}, {1}, {1}, {1, 1}, {1, 1}, {1}}));

      Assertions.assertArrayEquals(
        new Integer[]{
          null, null, -1},
        LFUCacheTester.test(new int[][]{
          {0}, {0, 0}, {0}}));
    }
  }

}
