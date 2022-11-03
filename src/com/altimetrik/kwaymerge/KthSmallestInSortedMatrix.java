package com.altimetrik.kwaymerge;

import java.util.*;

class KthSmallestInSortedMatrix {

  public static int findKthSmallest(int[][] matrix, int k) {
    // TODO: Write your code here
    PriorityQueue<MetaInfo> queue = new PriorityQueue<>((a,b)->
    matrix[a.rowIndex][a.colIndex] - matrix[b.rowIndex][b.colIndex]);

    for(int i=0;i<matrix.length;i++){
        queue.add(new MetaInfo(i,0));
    }

    int resultCnt = 0,result=-1;
    while(!queue.isEmpty()){
        MetaInfo info = queue.poll();
        int columIndex = info.colIndex; 
        result = matrix[info.rowIndex][columIndex];
        resultCnt++;
        if(resultCnt == k)
          break;
        //rowIndex++;
        columIndex++;
        if(columIndex < matrix[0].length){
          queue.add(new MetaInfo(info.rowIndex,columIndex));
        }


    }
    return result;
  }

  public static void main(String[] args) {
    int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}

class MetaInfo{
  int rowIndex;
  int colIndex;
  
  
   MetaInfo(int rowIndex,int colIndex){
     this.rowIndex = rowIndex;
     this.colIndex = colIndex;
     
   }

}