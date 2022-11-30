package com.altimetrik.subsets;

import java.util.*;
import java.util.stream.Collectors;


public class KParenthesis{

    public static void main(String[] args) {
        generateCombinations(3);
    }
    public static ArrayList<String> generateCombinations(int n) {
		
        // Your code will replace this placeholder return statement
        
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> data = new ArrayList<>();
        if(n == 0)
		    return result;

            generateCombinationsRec(n,0,0,data,result);

            return result;


	}


public static void generateCombinationsRec(int n,int opencount, int closecount,
ArrayList<Character> data,ArrayList<String> result) {
//when opencount < n add (
    //when closedcount < opencount add )
    //opencount == n == closedcount parenthesis are balanced..
if(opencount >= n && closecount >= n){
    System.out.println("Before:::::::"+data.toString());
    String value = data.stream().map(String::valueOf).collect(Collectors.joining());
    System.out.println("After:::::::"+value);
    result.add(value);
    return;
}

if(opencount < n){
    data.add('(');
    generateCombinationsRec( n, opencount+1,  closecount, data, result);
    data.remove(data.size() - 1);
}


if(closecount < opencount){
    data.add(')');
    generateCombinationsRec( n, opencount,  closecount+1, data, result);
    data.remove(data.size() - 1);
}


}



}