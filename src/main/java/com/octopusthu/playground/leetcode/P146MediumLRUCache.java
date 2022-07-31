package com.octopusthu.playground.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This solution is NOT thread-safe.
 *
 * @author octopusthu@gmail.com
 */
public class P146MediumLRUCache {

  static class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache;
    private final ArrayList<Integer> usage;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.cache = new HashMap<>(this.capacity);
      this.usage = new ArrayList<>(this.capacity);
    }

    public int get(int key) {

      /* 1. Get from the cache */
      Integer value = this.cache.get(key);
      if (value == null) {
        return -1;
      }

      /* 2. Update the usage list */
      this.use(key);

      /* 3. Return value */
      return value;
    }

    public void put(int key, int value) {

      /* 1. If the cache WOULD BE full, evict from the head of the usage list */
      if (this.cache.size() == this.capacity && !this.cache.containsKey(key)) {
        this.evict(key);
      }

      /* 2. Cache it */
      this.cache.put(key, value);

      /* 3. Put it at the tail of the usage list */
      this.use(key);
    }

    private void use(int key) {
      if (this.usage.isEmpty() || !this.usage.get(this.usage.size() - 1).equals(key)) {
        this.usage.add(key);
      }
    }

    private void evict(Integer avoid) {
      Integer key;
      do {
        key = this.usage.remove(0);
      } while (!this.cache.containsKey(key) || this.usage.contains(key) || key.equals(avoid));
      this.cache.remove(key);
    }
  }

  static class P146MediumLRUCacheTest {

    static class LRUCacheTester {

      static Integer[] test(String[] instructions, int[][] data) {
        Integer[] output = new Integer[instructions.length];
        LRUCache lruCache = null;
        for (int i = 0; i < instructions.length; i++) {
          switch (instructions[i]) {
            case "LRUCache":
              lruCache = new LRUCache(data[i][0]);
              output[i] = null;
              break;
            case "put":
              lruCache.put(data[i][0], data[i][1]);
              output[i] = null;
              break;
            case "get":
              output[i] = lruCache.get(data[i][0]);
              break;
            default:
          }
        }
        return output;
      }
    }

    @Test
    void testLRUCache() {
      Assertions.assertArrayEquals(
        new Integer[]{null, null, null, 1, null, -1, null, -1, 3, 4},
        LRUCacheTester.test(
          new String[]{"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
          new int[][]{{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}}));

      Assertions.assertArrayEquals(
        new Integer[]{null, null, null, null, null, 4, 3, 2, -1, null, -1, 2, 3, -1, 5},
        LRUCacheTester.test(
          new String[]{"LRUCache", "put", "put", "put", "put", "get", "get", "get", "get", "put", "get", "get", "get", "get", "get"},
          new int[][]{{3}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {4}, {3}, {2}, {1}, {5, 5}, {1}, {2}, {3}, {4}, {5}}));
    }
  }

}
