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
        // System.out.println(test.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));

        // 387. First Unique Character in a String
        // System.out.println(test.firstUniqChar("aadadaad"));
        // System.out.println(test.firstUniqChar("leetcode"));
        // System.out.println(test.firstUniqChar("loveleetcode"));
        // System.out.println(test.firstUniqChar("yekbsxznylrwamcaugrqrurvpqybkpfzwbqiysrdnrsnbftvrnszfjbkbmrctjizkjqoxqzddyfnavnhqeblfmzqgsjflghaulbadwqsyuetdelujphmlgtmkoaoijypvcajctbaumeromgejtewbwqptotrorephegyobbstvywljboeihdliknluqdpgampjyjpinxhhqexoctysfdciqjbzilnodzoihihusxluqoayenluziobxiodrfdkinkzzozmxfezfvllpdvogqqtquwcsijwachefspywdgsohqtlquhnoecccgbkrzqcprzmwvygqwddnehhi"));

        // 434. Number of Segments in a String
        // System.out.println(test.countSegments("Hello, my name is John"));
        // System.out.println(test.countSegments(", , , ,        a, eaefa"));

        // 443. String Compression
        // System.out.println(test.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        // System.out.println(test.compress(new char[]{'a'}));
        // System.out.println(test.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));

        // 459. Repeated Substring Pattern
        // System.out.println(test.repeatedSubstringPattern("abab"));
        // System.out.println(test.repeatedSubstringPattern("aba"));
        // System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));

        // 520. Detect Capital
        // System.out.println(test.detectCapitalUse("A"));
        // System.out.println(test.detectCapitalUse("USA"));
        // System.out.println(test.detectCapitalUse("FlaG"));

        // 521. Longest Uncommon Subsequence I
        // System.out.println(test.findLUSlength("", "cdc"));

        // 541. Reverse String II
        // System.out.println(test.reverseStr("abcdefg", 2));
        // System.out.println(test.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));// input

        // 551. Student Attendance Record I
        // System.out.println(test.checkRecord("PPALLP"));
        // System.out.println(test.checkRecord("PPALLL"));

        // 557. Reverse Words in a String III
        // System.out.println(test.reverseWords("Let's take  LeetCode contest "));

        // 606. Construct String from Binary Tree
        // TODO Can be optimized
        // TreeNode606 treeNode606_1_4 = new TreeNode606(4);
        // TreeNode606 treeNode606_1_3 = new TreeNode606(3);
        // TreeNode606 treeNode606_1_2 = new TreeNode606(2);
        // treeNode606_1_2.left = treeNode606_1_4;
        // TreeNode606 treeNode606_1_1 = new TreeNode606(1);
        // treeNode606_1_1.left = treeNode606_1_2;
        // treeNode606_1_1.right = treeNode606_1_3;
        // System.out.println(test.tree2str(treeNode606_1_1));
        //
        // TreeNode606 treeNode606_2_4 = new TreeNode606(4);
        // TreeNode606 treeNode606_2_3 = new TreeNode606(3);
        // TreeNode606 treeNode606_2_2 = new TreeNode606(2);
        // treeNode606_2_2.right = treeNode606_2_4;
        // TreeNode606 treeNode606_2_1 = new TreeNode606(1);
        // treeNode606_2_1.left = treeNode606_2_2;
        // treeNode606_2_1.right = treeNode606_2_3;
        // System.out.println(test.tree2str(treeNode606_2_1));

        // 657. Judge Route Circle
        // System.out.println(test.judgeCircle("UD"));
        // System.out.println(test.judgeCircle("LL"));

        // 680. Valid Palindrome II
        // System.out.println(test.validPalindrome("abcdefghijklmn"));
        // System.out.println(test.validPalindrome("atbbga"));

        // 686. Repeated String Match
        // System.out.println(test.repeatedStringMatch("ab", "abababab"));

        // 696. Count Binary Substrings
        // System.out.println(test.countBinarySubstrings("10101"));
        // System.out.println(test.countBinarySubstrings("00110011"));

        // 788. Rotated Digits
        System.out.println(test.rotatedDigits(0));

        System.out.println("finished!");
    }

    public int rotatedDigits(int N) {
        return 0;
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

    public int countBinarySubstrings(String s) {
        int prevRunLength = 0;
        int curRunLength = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength)
                res++;
        }
        return res;
    }

    public int repeatedStringMatch(String A, String B) {
        if (A.length() < 1 && B.length() < 1) {
            return -1;
        }
        int maxLoop = B.length() / A.length() + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxLoop; i++) {
            sb.append(A);
            if (sb.toString().contains(B)) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean validPalindrome(String s) {
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        for (int k = 0; k < s.length(); k++) {
            int head = 0, tail = s.length() - 1;
            char cHead, cTail;
            while (head < tail) {
                cHead = s.charAt(head);
                cTail = s.charAt(tail);
                if (cHead == cTail) {
                    head++;
                    tail--;
                } else {
                    return isPalindromeV2(s.substring(head, tail)) || isPalindromeV2(s.substring(head + 1, tail + 1));
                }
            }
            return true;
        }
        return false;
    }

    public boolean isPalindromeV2(String s) {
        if (s.isEmpty()) return true;
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head < tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (cHead != cTail)
                return false;
            head++;
            tail--;
        }
        return true;
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return true;
        }
        moves = moves.toUpperCase();
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'U') {
                y++;
            } else if (ch == 'D') {
                y--;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'R') {
                x++;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }

    public String tree2str(TreeNode606 t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    public String reverseWords(String s) {
        int spaceIndex = s.indexOf(" ");
        String result = "";
        while (spaceIndex > -1 || s.length() > 0) {
            String substring = null;
            if (spaceIndex != -1) {
                substring = s.substring(0, spaceIndex);
                s = s.substring(spaceIndex + 1);
                spaceIndex = s.indexOf(" ");
            } else {
                substring = s;
                s = "";
                spaceIndex = -1;
            }
            if (substring.isEmpty()) {
                continue;
            }
            char[] chars = substring.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            for (; i < j; i++, j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            if (!result.isEmpty()) {
                result += " ";
            }
            result += new String(chars);
            System.out.println(substring);
        }
        return result;
    }

    public boolean checkRecord(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int aCounts = 0;
        int lCounts = 0;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('A' == ch) {
                aCounts++;
            } else if ('L' == ch) {
                int tmp = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    char ch1 = s.charAt(j);
                    if ('L' == ch1) {
                        tmp++;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
                lCounts = Math.max(lCounts, tmp);
            }
            if (aCounts > 1 || lCounts > 2) {
                return false;
            }
        }
        return true;
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int step = k;
        if (k > s.length()) {
            step = s.length();
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = step - 1;
        int times = 0;
        while (i < s.length()) {
            times++;
            if (j > s.length()) {
                j = s.length() - 1;
            }
            if (times % 2 != 0) {
                for (; i < j; i++, j--) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
            i = times * step;
            j = i + step - 1;
        }
        return new String(chars);
    }

    public int findLUSlength(String a, String b) {
        if (a.length() > b.length()) {
            return a.length();
        }
        if (b.length() > a.length()) {
            return b.length();
        }
        int length = -1;
        String shortStr = a;
        String longStr = b;
        int tmpLength = -1;
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = i + 1; j <= shortStr.length(); j++) {
                String substring = shortStr.substring(i, j);
                if (longStr.indexOf(substring) > -1) {
                    continue;
                }
                tmpLength = substring.length();
            }
            length = Math.max(length, tmpLength);
            tmpLength = -1;
        }
        return length;
    }

    public boolean detectCapitalUse(String word) {
        if (word == null) {
            return false;
        }
        boolean allCapital = true;
        boolean allNonCapital = true;
        boolean onlyFirstCapital = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                allCapital = false;
                continue;
            }
            if ('A' <= ch && ch <= 'Z') {
                allNonCapital = false;
                if (i > 0) {
                    onlyFirstCapital = false;
                }
                continue;
            }
        }
        return allCapital || allNonCapital || onlyFirstCapital;
    }

    public boolean repeatedSubstringPattern(String s) {
        System.out.println((s + s).substring(1, 2 * s.length() - 1));
        return ((s + s).substring(1, 2 * s.length() - 1).contains(s)) ? true : false;
    }

    public int compress(char[] chars) {
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int count = 1;
            while (true) {
                if (i < chars.length - 1 && chars[i + 1] == chars[i]) {
                    i++;
                    count++;
                    continue;
                }
                break;
            }
            chars[length++] = ch;
            if (count <= 1) {
                continue;
            }
            String countStr = count + "";
            char[] countChars = countStr.toCharArray();
            for (int j = 0; j < countChars.length; j++) {
                chars[length++] = countChars[j];
            }
        }
        return length;
    }

    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] split = s.split(" ");
        int result = split.length;
        for (int i = 0; i < split.length; i++) {
            if (split[i].isEmpty()) {
                result--;
            }
        }
        return result;
    }

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int[] charCounts = new int[26];
        int[] firstCharPos = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (charCounts[ch] == 0)
                firstCharPos[ch] = i + 1;
            charCounts[ch]++;
        }

        int firstUnique = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] == 1)
                firstUnique = Math.min(firstCharPos[i], firstUnique);
        }

        return firstUnique == Integer.MAX_VALUE ? -1 : firstUnique - 1;
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

class TreeNode606 {
    int val;
    TreeNode606 left;
    TreeNode606 right;

    TreeNode606(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
