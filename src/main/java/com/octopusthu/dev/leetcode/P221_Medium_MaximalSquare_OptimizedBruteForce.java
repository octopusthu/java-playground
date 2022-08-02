package com.octopusthu.dev.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * LeetCode 221. Maximal Square
 *
 * @author octopusthu@gmail.com
 * @date 2022/7/26
 */
public class P221_Medium_MaximalSquare_OptimizedBruteForce {

    public int maximalSquare(char[][] matrix) {

        // 正方形解的边长，初始值为0
        int currentSolution = 0;

        // 矩阵宽
        int length = getLength(matrix);

        // 矩阵高
        int height = getHeight(matrix);

        // 带优化的矩阵遍历
        for (int x = 0; x < length; x++) {

            // 当前横坐标与矩阵最右侧的距离已经不足以超过当前解，不需要再向右遍历了
            if (length - x <= currentSolution) {
                break;
            }

            for (int y = 0; y < height; y++) {

                // 当前纵坐标与矩阵最底部的距离已经不足以超过当前解，不需要再向下遍历了
                if (height - y <= currentSolution) {
                    break;
                }

                // 从坐标 (x, y) 开始向右、向下寻找最大正方形的边长
                int solution = recursiveSearch(matrix, length, height, x, y, x, y);

                // 如果找到了更优解，则更新当前解
                if (solution > currentSolution) {
                    currentSolution = solution;
                }
            }
        }

        return currentSolution * currentSolution;
    }

    /**
     * 矩阵 <code>matrix</code> 中以坐标 (startingX, startingY) 为起始点向右、向下寻找到的最大正方形的边长
     *
     * @param matrix 矩阵
     * @param length 矩阵宽
     * @param height 矩阵高
     * @param startingX 起始点横坐标
     * @param startingY 起始点纵坐标
     * @param x 当前横坐标
     * @param y 当前纵坐标
     * @return 最大正方形的边长
     */
    private int recursiveSearch(char[][] matrix, int length, int height, int startingX, int startingY, int x, int y) {

        // 如果当前点不为 '1'，则当前点不是解的一部分，上次递归的结果是最终解
        if (matrix[y][x] != '1') {
            return x - startingX;
        }

        // 沿当前点向左、向上扫描，直到横、纵坐标到达起始点（即扫描本次递归后正方形解新增的底边和右侧边）
        // 如果有任意点不为 '1'，则当前点不是解的一部分，上次递归的结果是最终解
        for (int i = 0; i < x - startingX; i++) {
            if (matrix[y][startingX + i] != '1' || matrix[startingY + i][x] != '1') {
                return x - startingX;
            }
        }

        // 当前点是解的一部分，但是不能再向右下方推进了，当前解就是最终解
        if (x == length - 1 || y == height - 1) {
            return x - startingX + 1;
        }

        // 向右下方递归推进，直到找到最终解
        return recursiveSearch(matrix, length, height, startingX, startingY, x + 1, y + 1);
    }

    private int getLength(char[][] matrix) {
        return getHeight(matrix) == 0 ? 0 : matrix[0].length;
    }

    private int getHeight(char[][] matrix) {
        return matrix.length;
    }

    @Test
    void testMaximalSquare() {
        Assertions.assertEquals(
            4,
            maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
            })
        );
        Assertions.assertEquals(
            1,
            maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
            })
        );
        Assertions.assertEquals(
            0,
            maximalSquare(new char[][]{
                {'0'}
            })
        );
        Assertions.assertEquals(
            1,
            maximalSquare(new char[][]{
                {'0', '1'}
            })
        );
        Assertions.assertEquals(
            1,
            maximalSquare(new char[][]{
                {'1'},
                {'0'}
            })
        );
    }

}
