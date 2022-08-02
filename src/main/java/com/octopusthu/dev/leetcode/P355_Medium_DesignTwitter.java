package com.octopusthu.dev.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 355. Design Twitter
 *
 * @author octopusthu@gmail.com
 * @date 2022/8/3
 */
public class P355_Medium_DesignTwitter {

    class Twitter {

        private final Map<Integer, Set<Integer>> followees;
        private final List<Integer[]> feeds;

        public Twitter() {
            followees = new HashMap<>();
            feeds = new ArrayList<>();
        }

        public void postTweet(int userId, int tweetId) {
            feeds.add(0, new Integer[]{userId, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> userFollowees = followees.computeIfAbsent(userId, k -> new HashSet<>());
            return feeds.stream()
                .filter(feed -> feed[0] == userId || userFollowees.contains(feed[0]))
                .map(feed -> feed[1])
                .limit(10)
                .collect(Collectors.toList());
        }

        public void follow(int followerId, int followeeId) {
            followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            followees.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
        }
    }

    class TwitterTester {

        private Twitter twitter = null;

        Integer[][] execute(String[] operations, int[][] data) {
            List<Integer[]> result = new ArrayList<>(operations.length);
            for (int i = 0; i < operations.length; i++) {
                result.add(executeOperation(operations[i], data[i]));
            }
            return result.toArray(new Integer[0][0]);
        }

        Integer[] executeOperation(String operation, int[] data) {
            switch (operation) {
                case "Twitter":
                    twitter = new Twitter();
                    return null;
                case "postTweet":
                    twitter.postTweet(data[0], data[1]);
                    return null;
                case "getNewsFeed":
                    return twitter.getNewsFeed(data[0]).toArray(new Integer[0]);
                case "follow":
                    twitter.follow(data[0], data[1]);
                    return null;
                case "unfollow":
                    twitter.unfollow(data[0], data[1]);
                    return null;
                default:
                    throw new RuntimeException("Unknown operation: " + operation);
            }
        }

    }

    @Test
    void testTwitter() {
        TwitterTester tester = new TwitterTester();
        Assertions.assertArrayEquals(
            new Integer[][]{null, null, new Integer[]{5}, null, null, new Integer[]{6, 5}, null, new Integer[]{5}},
            tester.execute(
                new String[]{"Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow",
                    "getNewsFeed"},
                new int[][]{{}, {1, 5}, {1}, {1, 2}, {2, 6}, {1}, {1, 2}, {1}}
            )
        );
    }

}
