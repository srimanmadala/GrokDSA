import java.util.*;

class KthLargestNumberInStream {

  public int heapSize;

  public PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2)->n1-n2);

  public KthLargestNumberInStream(int[] nums, int k) {
    // TODO: Write your code here
    this.heapSize = k;
    for(int i=0;i<k;i++)
      minHeap.add(nums[i]);

    for(int i=k;i<nums.length;i++){
      if( nums[i] > minHeap.peek()){
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }


  }

  public int add(int num) {
    // TODO: Write your code here
    this.minHeap.add(num);
    if(this.minHeap.size() > this.heapSize ){
      this.minHeap.poll();
    }
    return minHeap.peek();
  }



  public static void main(String[] args) {
    int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
    KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
    System.out.println("4th largest number is: " + kthLargestNumber.add(6));
    System.out.println("4th largest number is: " + kthLargestNumber.add(13));
    System.out.println("4th largest number is: " + kthLargestNumber.add(4));
  }
}