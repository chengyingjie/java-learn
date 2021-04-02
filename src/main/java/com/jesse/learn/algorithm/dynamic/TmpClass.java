package com.jesse.learn.algorithm.dynamic;

public class TmpClass {

    public String solve (String s, String t) {
        // write code here
        if (s == null || s.length() == 0) return t;
        if (t == null || t.length() == 0) return s;

        String sNew = reverseStr(s);
        String tNew = reverseStr(t);
        if (sNew.length() < tNew.length()) {
            return calculateVal(sNew, tNew);
        }

        return calculateVal(tNew, sNew);
    }

    public static void main(String[] args) {
        char s = 'a' + 3;
//        System.out.println((char)s);

        TmpClass tmp = new TmpClass();
        tmp.solve("733064366","459309139");
    }

    private String calculateVal(String s, String t) {

        StringBuffer res = new StringBuffer();
        int flag = 0;

        for (int i = 0; i < s.length(); i++) {
            int sint = s.charAt(i) - '0';
            int tint = t.charAt(i) - '0';
            int sum = sint + tint + flag;
            res.append(String.valueOf(sum /10));
            flag = flag % 10;
        }

        for (int i = s.length(); i < t.length(); i++) {
            int sum = t.charAt(i) - '0' + flag;
            res.append(String.valueOf(sum /10));
            flag = flag % 10;
        }

        if (flag == 1) {
            res.append("1");
        }

        return res.reverse().toString();
    }

    private String reverseStr(String str) {
        StringBuffer sbuff = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) == '0') {
//                 continue;
//             }

            sbuff.append(str.charAt(i));
        }

        return sbuff.reverse().toString();
    }
}
