package com.sabit.interview.third_longest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * take the array of strings stored in strArr 
 * and return the third largest word within it. 
 * So for example: if strArr is ["hello", "world", "before", "all"] 
 * your output should be world because "before" is 6 letters long, and "hello" and "world" are both 5, 
 * but the output should be world because it appeared as the last 5 letter word in the array. 
 * If strArr was ["hello", "world", "after", "all"] the output should be after 
 * because the first three words are all 5 letters long, so return the last one. 
 * The array will have at least three strings and each string will only contain letters.
 */
public class ThirdLongest {
	public static void main(String[] args) {

		thirdLongest(new String[] { "hello", "world", "before", "all" });

		thirdLongest(new String[] { "asds", "sasdfgs", "asdsd", "asdsda", "hello", "world", "before", "all" });

		thirdLongest(new String[] { "hello", "world", "before", "all", "hello", "world", "before", "all" });

		thirdLongest(new String[] { "444", "44", "4", "1", "11", "22", "2", "33", "111", "3", "222" });
	}

	public static void thirdLongest(String[] strings) {

		System.out.println("Input : " + String.join(", ", strings));
		
		if (strings == null || strings.length < 3)
			return;

		String result = null;

		// sort algorithm needs to improve
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// Compare by length first
				int result = Integer.compare(s2.length(), s1.length());
				// If lengths are equal, bigger index comes first
				if (result == 0) {
					return Integer.compare(Arrays.asList(strings).indexOf(s2), Arrays.asList(strings).indexOf(s1));
				}
				return result;
			}
		});

		for (int i = 2; i >= 0; i--) {
			// if last of array, or last of same size return
			if (i == 0 || strings[i].length() != strings[i - 1].length()) {
				result = strings[i];
				break;
			}

		}

		System.out.println("Sorted: " + String.join(", ", strings));
		System.out.println("Out: " + result);
	}

}
