
package com.altimetrik.dp;

class PartitionSet {

    public boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        if (sum % 2 != 0)
            return false;

        return canPartitionRec(num, 0, sum / 2);
    }

    public  boolean canPartitionRec(int[] num, int index, int sum) {

        if (sum == 0)
            return true;

        if (num.length == 0 || index >= num.length)
            return false;

        return num[index] <= sum &&
            (canPartitionRec(num, index + 1, sum - num[index] ) || canPartitionRec(num, index + 1, sum));


    }


    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

}