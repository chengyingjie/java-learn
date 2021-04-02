package com.jesse.learn.algorithm.tmptmp;

import java.util.ArrayList;
import java.util.List;

public class Workbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        return backtrack(s, wordDict);

    }

    private boolean backtrack(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                if (backtrack(s.substring(i), wordDict)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Workbreak workbreak = new Workbreak();
        String s = "leetcode";
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        System.out.println(workbreak.wordBreak(s, words));
    }
}
