package com.jesse.learn.algorithm.tmptmp;

public class Palindrome {

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(s.substring(j, j+i))) {
                    ++res;
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }

            i++;
            j--;
        }

        return str.length() % 2 == 1 ?  i == j : i == j+1;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.countSubstrings("aaa"));
    }
}
