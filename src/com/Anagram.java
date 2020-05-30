package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    public void findAllAnagrams(String from, String find){
        List<Integer> result = new ArrayList<>();
        int[] findHash = prepareHash(find);

        int left=0, right=find.length();
        while(right <= from.length()){
            String temp = from.substring(left, right);
            int[] tempCharCount = prepareHash(temp);
//            System.out.println(left+"----"+temp +"-----"+Arrays.toString(tempCharCount));
            if(Arrays.equals(findHash, tempCharCount)){
                result.add(left);
            }
            left++;
            right++;
        }
        System.out.println(result.stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    public int[] prepareHash(String str){
        int[] charCount = new int[26];
        for(char c : str.toCharArray()){
            charCount[c - 'a']++;
        }
        return charCount;
    }

    public static void main(String[] args) {
        Anagram obj = new Anagram();
        obj.findAllAnagrams("abcbcdhdhbbcabdcba", "abcb");

    }
}
