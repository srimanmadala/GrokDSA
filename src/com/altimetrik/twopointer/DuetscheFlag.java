package com.altimetrik.twopointer;

import java.util.Arrays;

public class DuetscheFlag {


    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,2,1,0};
        //int[] arr = new int[]{2, 2, 0, 1, 2, 0};
        duetscheFlagSolution(arr);
        duetscheFlagSolutionAux(arr);
    }

    public static void duetscheFlagSolution(int[] arr){

        int low = 0;
        int high = arr.length - 1;

        for(int i=0;i<=high;){
            if(arr[i] == 0){
                swap(arr,i,low);
                low++;
                i++;
            }else if(arr[i] == 2){
                swap(arr,i,high);
                high--;

            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void duetscheFlagSolutionAux(int[] arr){


       int[] aux = new int[arr.length];
       int low = 0,i=0; int high = arr.length - 1;
       int auxPos = 0;
       while(i < arr.length){
           if(arr[i] == 0){
               aux[auxPos] = arr[i];
               low++;
               auxPos++;
           }
           if(arr[i] == 2){
               aux[high--] = arr[i];
           }
           i++;
       }


        for(int k=0;k<arr.length;k++){
            if(arr[k] == 1){
                aux[auxPos++] = arr[k];
            }
        }
        System.out.println(Arrays.toString(aux));
    }


    public static  void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
