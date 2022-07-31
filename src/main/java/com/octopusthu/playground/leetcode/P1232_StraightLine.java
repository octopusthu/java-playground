package com.octopusthu.playground.leetcode;

public class P1232_StraightLine {
  public boolean checkStraightLine(int[][] coordinates) {

    /*
      ax+by+c=0
      ax0+by0+c=0
      ax1+by1+c=0

      =>
      (coordinates[i][0]-coordinates[i+1][0])/(coordinates[i][1]-coordinates[i+1][1])
      ==
      (coordinates[i+1][0]-coordinates[i+2][0])/(coordinates[i+1][1]-coordinates[i+2][1])

      =>
      (coordinates[i][0]-coordinates[i+1][0])*(coordinates[i+1][1]-coordinates[i+2][1])
      ==
      (coordinates[i][1]-coordinates[i+1][1])*(coordinates[i+1][0]-coordinates[i+2][0])
     */

    if (coordinates.length == 2) {
      return true;
    }

    for (int i = 0; i < coordinates.length - 2; i++) {
      if ((coordinates[i][0] - coordinates[i + 1][0]) * (coordinates[i + 1][1] - coordinates[i + 2][1])
        !=
        (coordinates[i][1] - coordinates[i + 1][1]) * (coordinates[i + 1][0] - coordinates[i + 2][0])) {
        return false;
      }
    }
    return true;
  }
}
