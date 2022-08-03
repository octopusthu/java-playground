package com.octopusthu.dev.leetcode;

import com.octopusthu.dev.leetcode.P355_Medium_DesignTwitter.Twitter;
import com.octopusthu.dev.leetcode.P355_Medium_DesignTwitter.TwitterTester;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 355. Design Twitter (Optimized)
 *
 * @author octopusthu@gmail.com
 * @date 2022/8/3
 */
public class P355_Medium_DesignTwitter_Optimized {

    static class OptimizedTwitter implements Twitter {

        public OptimizedTwitter() {
        }

        public void postTweet(int userId, int tweetId) {
        }

        public List<Integer> getNewsFeed(int userId) {
            return null;
        }

        public void follow(int followerId, int followeeId) {
        }

        public void unfollow(int followerId, int followeeId) {
        }
    }

    @Test
    void testTwitter() {
        TwitterTester.test(new OptimizedTwitter());
    }

}
