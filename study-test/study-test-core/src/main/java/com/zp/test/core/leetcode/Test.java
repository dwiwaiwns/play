package com.zp.test.core.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author:zp
 * Date:2018/1/3 0003
 * Description:
 * Category: String
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        // 9.Palindrome Number
        // System.out.println(test.isPalindrome(121));

        // 13.Roman to Integer
        // System.out.println(test.romanToInt("III"));
        // System.out.println(test.romanToInt("IV"));
        // System.out.println(test.romanToInt("IX"));
        // System.out.println(test.romanToInt("LVIII"));
        // System.out.println(test.romanToInt("MCMXCIV"));

        // 14.Longest Common Prefix
        // System.out.println(test.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        // System.out.println(test.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        // System.out.println(test.longestCommonPrefix(new String[]{}));

        // 20.Valid Parentheses
        // System.out.println(test.isValid("{}"));
        // System.out.println(test.isValid("()[]{}"));
        // System.out.println(test.isValid("(]"));
        // System.out.println(test.isValid("([)]"));
        // System.out.println(test.isValid("{[]}"));
        // System.out.println(test.isValid(""));

        // 21.Merge Two Sorted Lists
        // ListNode listNode1_1 = new ListNode(1);
        // ListNode listNode1_2 = new ListNode(2);
        // ListNode listNode1_3 = new ListNode(4);
        // listNode1_2.next = listNode1_3;
        // listNode1_1.next = listNode1_2;
        // ListNode listNode2_1 = new ListNode(1);
        // ListNode listNode2_2 = new ListNode(3);
        // ListNode listNode2_3 = new ListNode(4);
        // listNode2_2.next = listNode2_3;
        // listNode2_1.next = listNode2_2;
        // ListNode listNode = test.mergeTwoLists(listNode1_1, listNode2_1);
        // while (true){
        //     if(listNode == null){
        //         break;
        //     }
        //     System.out.println(listNode.val);
        //     listNode = listNode.next;
        // }

        // 26.Remove Duplicates from Sorted Array
        // System.out.println(test.removeDuplicates(new int[]{1, 1, 2}));
        // System.out.println(test.removeDuplicates(new int[]{1, 2, 2}));
        // System.out.println(test.removeDuplicates(new int[]{1, 2}));
        // System.out.println(test.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

        // 27.Remove Element
        // System.out.println(test.removeElement(new int[]{3, 2, 2, 3}, 3));
        // System.out.println(test.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

        // 28.Implement strStr()
        // System.out.println(test.strStr("hello", "ll"));
        // System.out.println(test.strStr("aaaaa", "bba"));
        // System.out.println(test.strStr("a", "a"));

        // 35.Search Insert Position
        // System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 5));
        // System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 2));
        // System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 7));
        // System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 0));

        // 38.Count and Say
        // System.out.println(test.countAndSayNext("1"));
        // System.out.println(test.countAndSay(1));
        // System.out.println(test.countAndSay(2));
        // System.out.println(test.countAndSay(3));
        // System.out.println(test.countAndSay(4));
        // System.out.println(test.countAndSay(5));
        // System.out.println(test.countAndSay(6));
        // System.out.println(test.countAndSay(7));
        // System.out.println(test.countAndSay(8));
        // System.out.println(test.countAndSay(9));
        // System.out.println(test.countAndSay(10));
        // System.out.println(test.countAndSay(11));
        // System.out.println(test.countAndSay(12));
        // System.out.println(test.countAndSay(13));
        // System.out.println(test.countAndSay(14));
        // System.out.println(test.countAndSay(15));
        // System.out.println(test.countAndSay(16));
        // System.out.println(test.countAndSay(17));

        // category: String
        // 58.Length of Last Word
        // System.out.println(test.lengthOfLastWord("           "));
        // System.out.println(test.lengthOfLastWord("Hello World"));
        // System.out.println(test.lengthOfLastWord("Hello World "));
        // System.out.println(test.lengthOfLastWord("Hello World   "));

        // 67.Add Binary
        // System.out.println(test.addBinary("1", "1"));
        // System.out.println(test.addBinary("11", "1"));
        // System.out.println(test.addBinary("1010", "1011"));

        // 125.Valid Palindrome
        // System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        // System.out.println(test.isPalindrome("A man, a plan, a canal: Panama1"));
        // System.out.println(test.isPalindrome(".,"));
        // System.out.println(test.isPalindrome("race a car"));

        // 344. Reverse String
        // System.out.println(test.reverseString("race a car"));

        // 345. Reverse Vowels of a String
        // System.out.println(test.reverseVowels("hello"));
        // System.out.println(test.reverseVowels("leetcode"));
        // System.out.println(test.reverseVowels("race a car"));

        // 383. Ransom Note
        // System.out.println(test.canConstruct("a", "b"));
        // System.out.println(test.canConstruct("aa", "ab"));
        // System.out.println(test.canConstruct("aa", "aab"));
        System.out.println(test.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));

        System.out.println("finished!");
    }

    public static int romanToInt(String s) {
        Map<String, Integer> mapBase = new HashMap<>();
        mapBase.put("I", 1);
        mapBase.put("V", 5);
        mapBase.put("X", 10);
        mapBase.put("L", 50);
        mapBase.put("C", 100);
        mapBase.put("D", 500);
        mapBase.put("M", 1000);

        Map<String, Integer> mapHeight = new HashMap<>();
        mapHeight.put("IV", 4);
        mapHeight.put("IX", 9);
        mapHeight.put("XL", 40);
        mapHeight.put("XC", 90);
        mapHeight.put("CD", 400);
        mapHeight.put("CM", 900);

        for (String key : mapHeight.keySet()) {
            s = s.replace(key, "+" + mapHeight.get(key) + "+");
        }

        for (String key : mapBase.keySet()) {
            s = s.replace(key, "+" + mapBase.get(key) + "+");
        }
        String[] split = s.split("[+]");
        int result = 0;
        for (String value : split) {
            if (value == null || value.length() <= 0) {
                continue;
            }
            result += Integer.parseInt(value);
        }

        return result;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if ((ransomNote == null && magazine == null) || ransomNote.isEmpty() && magazine.isEmpty()) {
            return true;
        }
        if (magazine == null || ransomNote == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c1 = ransomNote.charAt(i);
            boolean flag = false;
            for (int j = 0; j < magazine.length(); j++) {
                char c2 = magazine.charAt(j);
                if (c1 == c2) {
                    flag = true;
                    magazine = magazine.substring(0, j) + magazine.substring(j + 1);
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private boolean isVowel(char c) {
        if ('a' == c) {
            return true;
        }
        if ('e' == c) {
            return true;
        }
        if ('i' == c) {
            return true;
        }
        if ('o' == c) {
            return true;
        }
        if ('u' == c) {
            return true;
        }
        if ('A' == c) {
            return true;
        }
        if ('E' == c) {
            return true;
        }
        if ('I' == c) {
            return true;
        }
        if ('O' == c) {
            return true;
        }
        if ('U' == c) {
            return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            char c1 = '1';
            boolean flag1 = false;
            while (i <= j) {
                c1 = s.charAt(i);
                if (isVowel(c1)) {
                    flag1 = true;
                    break;
                }
                i++;
            }

            char c2 = '2';
            boolean flag2 = false;
            while (j >= i) {
                c2 = s.charAt(j);
                if (isVowel(c2)) {
                    flag2 = true;
                    break;
                }
                j--;
            }
            if (!flag1 || !flag2) {
                break;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        s = s.toUpperCase();
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            char c1 = '1';
            boolean flag1 = false;
            while (i <= j) {
                c1 = s.charAt(i);
                if (('A' <= c1 && c1 <= 'Z') || ('0' <= c1 && c1 <= '9')) {
                    flag1 = true;
                    break;
                }
                i++;
            }

            char c2 = '2';
            boolean flag2 = false;
            while (j >= i) {
                c2 = s.charAt(j);
                if (('A' <= c2 && c2 <= 'Z') || ('0' <= c2 && c2 <= '9')) {
                    flag2 = true;
                    break;
                }
                j--;
            }
            if (!flag1 && !flag2) {
                break;
            }
            if (flag1 != flag2) {
                return false;
            }
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public String addBinary(String a, String b) {
        if ((a == null || a.isEmpty()) && (b == null || b.isEmpty())) {
            return null;
        }
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int carry = 0;
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        for (; i >= 0 || j >= 0; i--, j--) {
            int v1 = i < 0 ? 0 : Integer.valueOf(a.substring(i, i + 1));
            int v2 = j < 0 ? 0 : Integer.valueOf(b.substring(j, j + 1));
            int v = (v1 + v2 + carry) % 2;
            carry = (v1 + v2 + carry) / 2;
            result = v + result;
        }
        result = carry == 0 ? result : carry + result;
        return result;
    }

    public int lengthOfLastWord(String s) {
        String[] wordArrays = s.split(" ");
        if (wordArrays.length <= 0) {
            return 0;
        }
        return wordArrays[wordArrays.length - 1].length();
    }

    public String countAndSay(int n) {
        int count = 1;
        String result = "1";
        while (count < n) {
            result = countAndSayNext(result);
            count++;
        }
        return result;
    }

    private String countAndSayNext(String preStr) {
        char[] preStrChars = preStr.toCharArray();
        char flag = preStrChars[0];
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < preStrChars.length; i++) {
            if (preStrChars[i] == flag) {
                count++;
                continue;
            }
            sb.append(count);
            sb.append(flag);
            flag = preStrChars[i];
            count = 1;
        }
        sb.append(count);
        sb.append(flag);
        return sb.toString();
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]) {
            return 0;
        }
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                continue;
            }
            index = i + 1;
        }
        return index;
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackChars.length - needleChars.length + 1; i++) {
            if (haystackChars[i] == needleChars[0]) {
                boolean isEqual = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystackChars[i + j] != needleChars[j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                break;
            }
            flag++;
        }
        if (flag == nums.length) {
            return flag;
        }
        for (int i = flag + 1; i < nums.length; i++) {
            if (nums[i] != val) {
                int tmp = nums[flag];
                nums[flag] = nums[i];
                nums[i] = tmp;
                flag++;
            }
        }
        return flag;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int length = 1;
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    length++;
                    if (j != i + 1) {
                        int tmp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = tmp;
                    }
                    break;
                }
            }
        }
        return length;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode lastNode = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (true) {
            if (tmp1 == null || tmp2 == null) {
                break;
            }
            ListNode tmp = null;
            if (tmp1.val <= tmp2.val) {
                tmp = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else {
                tmp = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            }
            if (listNode == null) {
                lastNode = tmp;
                listNode = lastNode;
                continue;
            }
            lastNode.next = tmp;
            lastNode = lastNode.next;
        }
        if (tmp1 == null) {
            while (true) {
                if (tmp2 == null) {
                    break;
                }
                ListNode tmp = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
                if (listNode == null) {
                    lastNode = tmp;
                    listNode = lastNode;
                    continue;
                }
                lastNode.next = tmp;
                lastNode = lastNode.next;
            }
        }
        if (tmp2 == null) {
            while (true) {
                if (tmp1 == null) {
                    break;
                }
                ListNode tmp = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
                if (listNode == null) {
                    lastNode = tmp;
                    listNode = lastNode;
                    continue;
                }
                lastNode.next = tmp;
                lastNode = lastNode.next;
            }
        }
        return listNode;
    }

    public boolean isValid(String s) {
        Map<String, String> matchMap = new HashMap<>();
        matchMap.put("]", "[");
        matchMap.put(")", "(");
        matchMap.put("}", "{");

        Stack<String> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (stack.size() == 0) {
                stack.push(str);
                continue;
            }
            String peek = stack.peek();
            String match = matchMap.get(str);
            if (match != null && peek != null && match.equals(peek)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0 || strs[0].length() <= 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                if ("".equals(result)) {
                    return result;
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int b = x;
        while (true) {
            int tmp = b % 10;
            b = b / 10;

            y = y * 10 + tmp;
            if (b == 0) {
                break;
            }
        }
        if (x == y) {
            return true;
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
