package com.kunal.strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
//        subseqAscii("", "abc");
        System.out.println(subseqAsciiRet("", "abc"));
    }

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }
    
    static ArrayList<String> ans = new ArrayList<>();    // A static variable 
    static ArrayList<String> subSeqList(String p, String up) {
        if (up.isEmpty()) {
            ans.add(p);    // add String p to ans ArrayList
            return ans;    // return ans
        }

        char ch = up.charAt(0);
        subSeqList(p + ch, up.substring(1));
        subSeqList(p, up.substring(1));
        return ans;
    }
    
    static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(p + ch, up.substring(1));
        ArrayList<String> right = subseqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch+0), up.substring(1));
    }

    static ArrayList<String> subseqAsciiRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAsciiRet(p + ch, up.substring(1));
        ArrayList<String> second = subseqAsciiRet(p, up.substring(1));
        ArrayList<String> third = subseqAsciiRet(p + (ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
