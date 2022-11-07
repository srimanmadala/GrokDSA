package com.altimetrik.dfs;

class TreeDiameter {

  public static int diameter = 0;

  public static int findDiameter(TreeNode root) {
    // TODO: Write your code here

    calculateHeight(root);
    
    return diameter;
  }


  public static int calculateHeight(TreeNode root){

    if(root == null)
      return 0;

     int leftHeight = calculateHeight(root.left);
     int rightHeight = calculateHeight(root.right);

     if(leftHeight != 0 && rightHeight != 0){
        int currentDiameter = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter,currentDiameter);
     }


     return Math.max(leftHeight,rightHeight) + 1;

  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    root.left.left = null;
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    root.right.left.right.left = new TreeNode(10);
    root.right.right.left.left = new TreeNode(11);
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
  }
}
