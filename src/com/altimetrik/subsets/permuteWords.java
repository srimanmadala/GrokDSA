package com.altimetrik.subsets;

import java.util.*;
public class permuteWords{
    public static ArrayList<String> permuteWord(String word) {

        // Your code will replace this placeholder return statement
        ArrayList<String> result = new ArrayList<>();
        permuteWordRec(word,0,result);
        return result;
    }


    public static void permuteWordRec(String word,int curentIndex,ArrayList<String> result) {

        if(curentIndex == word.length()-1 ){
            result.add(word);
            return;
        }

        for(int i=curentIndex;i<word.length();i++){
            char[] ch = swap(word,i,curentIndex);
            permuteWordRec(String.valueOf(ch),curentIndex+1,result);
            swap(word,i,curentIndex);
        }

    }

    public static char[] swap(String word,int i,int j){
        char[] ch = word.toCharArray(); 
        char chtemp = ch[i];
        ch[i] = ch[j];
        ch[j] = chtemp;
        return ch;
    }
}