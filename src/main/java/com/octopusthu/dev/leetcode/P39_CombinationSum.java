package com.octopusthu.dev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P39_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> soln = new ArrayList<List<Integer>>();
		int len = candidates.length;
		if (candidates == null || len == 0) {
			return soln;
		}
		this.sort(candidates);
		this.findSolution(candidates, len, target, soln, new ArrayList<Integer>(), 0);
		return soln;
	}

	private void findSolution(int[] sorted, int len, int target, List<List<Integer>> soln, List<Integer> tmpSoln,
			int pointer) {
		int toAdd;
		List<Integer> newSoln;
		for (int i = pointer; i < len; i++) {
			toAdd = sorted[i];
			if (toAdd > target) {
				return;
			}
			if (toAdd == target) {
				tmpSoln.add(toAdd);
				soln.add(tmpSoln);
				return;
			}
			newSoln = new ArrayList<Integer>(tmpSoln);
			newSoln.add(toAdd);
			this.findSolution(sorted, len, target - toAdd, soln, newSoln, i);
		}
	}

	private void quickSort(int[] arr, int p, int r) {
		if (p >= r) {
			return;
		}
		if (arr == null | arr.length <= 1) {
			return;
		}
		int pivot = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, r);
		this.quickSort(arr, p, i);
		this.quickSort(arr, i + 2, r);
	}

	private void swap(int[] arr, int a, int b) {
		if (a == b) {
			return;
		}
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private void sort(int[] candidates) {
		// Arrays.sort(candidates);
		// return cadidates;

		this.quickSort(candidates, 0, candidates.length - 1);
	}

	public static void main(String[] args) {
		P39_CombinationSum p39 = new P39_CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		// int[] candidates = { 7, 2, 3, 1, 6 };
		// int target = 7;
		// int[] candidates = { 1, 2 };
		// int target = 3;
		for (int i : candidates) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(target);
		System.out.println(p39.combinationSum(candidates, target));
	}

}
