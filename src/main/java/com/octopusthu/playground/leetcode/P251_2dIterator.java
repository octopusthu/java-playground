package com.octopusthu.playground.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 2D Iterator with remove()
 * 
 * @author Yu
 *
 */
public class P251_2dIterator implements Iterator<Integer> {
	private Iterator<List<Integer>> row = null;
	private Iterator<Integer> col = null;

	public P251_2dIterator(List<List<Integer>> vector) {
		this.row = vector.iterator();
		if (this.row.hasNext()) {
			this.col = this.row.next().iterator();
		}
	}

	@Override
	public boolean hasNext() {
		if (this.col == null) {
			return false;
		}
		if (this.col.hasNext()) {
			return true;
		}
		while (this.row.hasNext()) {
			this.col = this.row.next().iterator();
			if (this.col.hasNext()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		return this.col.next();
	}

	@Override
	public void remove() {
		this.col.remove();
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(P251_2dIterator.class.getResourceAsStream("P251.txt"));
		String line;
		P251_2dIterator p251;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(line);
			p251 = new P251_2dIterator(convert(line));
			while (p251.hasNext()) {
				System.out.print(p251.next() + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<List<Integer>> convert(String line) throws Exception {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		line = line.trim();
		line = line.substring(1, line.length() - 1).trim();
		int l, r;
		String inner;
		List<Integer> innerList;
		while ((l = line.indexOf("[")) != -1) {
			r = line.indexOf("]");
			if (r == -1) {
				throw new Exception("Bad formcat!");
			}
			inner = line.substring(l + 1, r).trim();
			innerList = new ArrayList<Integer>();
			list.add(innerList);
			if (!inner.isEmpty()) {
				for (String s : inner.split(",")) {
					innerList.add(Integer.parseInt(s));
				}
			}
			line = line.substring(r + 1);
		}
		return list;
	}

}
