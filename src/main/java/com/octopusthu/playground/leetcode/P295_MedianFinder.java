package com.octopusthu.playground.leetcode;

import java.util.ArrayList;

public class P295_MedianFinder {
	@SuppressWarnings("serial")
	class Heap extends ArrayList<Integer> {
		boolean max;

		Heap(boolean max) {
			super();
			this.max = max;
		}

		int extract() {
			int top = get(0);
			set(0, remove(size() - 1));
			heapify();
			return top;
		}

		void insert(int num) {
			add(num);
			int index = size() - 1;
			int parentIndex = parentIndex(index);
			while (index > 0 && !compare(get(parentIndex), get(index))) {
				swap(index, parentIndex);
				index = parentIndex;
				parentIndex = parentIndex(index);
			}
		}

		private void heapify() {
			heapify(0);
		}

		private void heapify(int index) {
			int leftIndex = leftIndex(index);
			if (leftIndex > size() - 1) {
				return;
			}
			int upperIndex = index;
			if (!compare(get(index), get(leftIndex))) {
				upperIndex = leftIndex;
			}
			int rightIndex = rightIndex(index);
			if (rightIndex <= size() - 1 && !compare(get(upperIndex), get(rightIndex))) {
				upperIndex = rightIndex;
			}
			if (upperIndex != index) {
				swap(index, upperIndex);
				heapify(upperIndex);
			}
		}

		private int parentIndex(int index) {
			return ((int) (Math.floor(((double) (index + 1)) / 2))) - 1;
		}

		private int leftIndex(int index) {
			return ((index + 1) * 2) - 1;
		}

		private int rightIndex(int index) {
			return leftIndex(index) + 1;
		}

		private boolean compare(int upper, int lower) {
			return max ? upper >= lower : upper <= lower;
		}

		private void swap(int i, int j) {
			int tmp = get(i);
			set(i, get(j));
			set(j, tmp);
		}
	}

	Integer median = null;
	Heap left = new Heap(true);
	Heap right = new Heap(false);

	public void addNum(int num) {

		// the first
		if (median == null && left.isEmpty() && right.isEmpty()) {
			median = num;
			return;
		}

		Heap heap = left;
		if (num > findMedian()) {
			heap = right;
		}
		heap.insert(num);
		if (median == null) {
			median = heap.extract();
		} else {
			other(heap).insert(median);
			median = null;
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		return median != null ? median : ((double) (left.get(0) + right.get(0))) / 2;
	}

	private Heap other(Heap heap) {
		return heap == left ? right : left;
	}

	@Override
	public String toString() {
		return null;
	}

	public static void main(String[] args) {
		// Your MedianFinder object will be instantiated and called as such:
		P295_MedianFinder mf = new P295_MedianFinder();
		mf.addNum(-1);
		System.out.println(mf.toString());
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		System.out.println(mf.toString());
		System.out.println(mf.findMedian());
		mf.addNum(-3);
		System.out.println(mf.toString());
		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.toString());
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.toString());
		System.out.println(mf.findMedian());
	}

}
