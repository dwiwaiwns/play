package com.zp.test.core.leetcode;

/**
 * Author:zp
 * Date:2018/1/3 0003
 * Description:
 */
public class Test {

    /*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example:

    Input: "babad"

    Output: "bab"

    Note: "aba" is also a valid answer.
            Example:

    Input: "cbbd"

    Output: "bb"
    */

    public static void main(String[] args) {
        // int a = (1 + 3) / 2;
        // System.out.println(a);
        // System.out.println(new Test().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        // System.out.println(new Test().findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Test().longestPalindrome("babad"));
        System.out.println(new Test().longestPalindrome("cbbd"));
        System.out.println(new Test().longestPalindrome("ccc"));
        System.out.println(new Test().longestPalindrome("abcda"));
    }

    public String longestPalindrome(String s) {
        String longestString = new String();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String tmp1 = s.substring(i + 1);
            int next = tmp1.lastIndexOf(c);
            if (next == -1) {
                continue;
            }
            String tmp2 = s.substring(i, i + 1 + next + 1);
            boolean isPalindrome = true;
            for (int j = 0; j < tmp2.length() / 2; j++) {
                int index = tmp2.length() - 1 - j;
                if (tmp2.charAt(j) != tmp2.charAt(index)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome) {
                tmp2 = longestPalindrome(s.substring(i, i + 1 + next));
            }
            if (tmp2.length() >= longestString.length()) {
                longestString = new String(tmp2);
            }
        }
        if (longestString.length() == 0) {
            longestString = s.substring(0, 1);
        }
        return longestString;
    }

}
