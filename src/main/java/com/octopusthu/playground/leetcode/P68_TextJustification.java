package com.octopusthu.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 *
 */
public class P68_TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ret = new ArrayList<String>();
		int total = words.length;
		if (words == null || total == 0) {
			return ret;
		}

		String word = words[0];
		int rowLen = word.length();
		// if (rowLen > maxWidth) {
		// throw new Exception("Word length is more than maxWidth: " + word);
		// }
		List<String> row = new ArrayList<String>();
		row.add(word);
		int slots = 0;
		int extras = maxWidth - rowLen;

		int len;

		for (int i = 1; i < total; i++) {
			word = words[i];
			len = word.length();
			if (len + 1 > extras) {
				ret.add(this.justify(row, slots, extras));
				row = new ArrayList<String>();
				row.add(words[i]);
				rowLen = len;
				slots = 0;
			} else {
				row.add(" ");
				row.add(word);
				rowLen += len + 1;
				slots++;
			}
			extras = maxWidth - rowLen;
		}

		ret.add(this.leftJustify(row, extras));

		return ret;
	}

	private String justify(List<String> row, int slots, int extras) {
		if (slots == 0) {
			return this.leftJustify(row, extras);
		}

		int base = (int) Math.floor((double) extras / (double) slots);
		int mod = extras % slots;
		int toAdd;
		int index;
		for (int i = 0; i < slots; i++) {
			index = (i + 1) * 2 - 1;
			toAdd = base;
			if (mod > 0) {
				toAdd++;
				mod--;
			}
			row.set(index, this.addSpaces(" ", toAdd));
		}
		return this.listToString(row);
	}

	private String leftJustify(List<String> row, int extras) {
		row.add(this.addSpaces("", extras));
		return this.listToString(row);
	}

	private String addSpaces(String str, int cnt) {
		for (int j = 0; j < cnt; j++) {
			str += " ";
		}
		return str;
	}

	private String listToString(List<String> row) {
		String ret = "";
		for (String str : row) {
			ret += str;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		P68_TextJustification p68 = new P68_TextJustification();
		// String[] words = { "" };
		// String[] words = { "This", "is", "an", "example", "of", "text",
		// "justification." };
		String[] words = { "What", "must", "be", "shall", "be." };
		int maxWidth = 12;
		System.out.println(p68.fullJustify(words, maxWidth));
	}

}
