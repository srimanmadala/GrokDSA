package com.altimetrik.binarysearch;

class NextLetter {

  public static char searchNextLetter(char[] letters, char key) {
    // TODO: Write your code here

     if( key > letters[letters.length-1] )
      return letters[0];

      int left = 0;
      int right = letters.length - 1;
      
      while(left <= right){
        
        int mid = left + (right - left) / 2;

          if(key < letters[mid]){
            right = mid - 1;
          }else { // >= still move start pointer to mid+1 even for exact match
            left = mid + 1;
          }
       
      }

     

      return letters[left%letters.length]; //since it is circular
    
  }

  public static void main(String[] args) {
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
  }
}