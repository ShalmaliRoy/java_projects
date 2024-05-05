package com.data.structure;

import java.util.*;

public class FormTreeFromPreOrder {
    TreeNode root;
    TreeNode head;
    public void inOrder(TreeNode current){
        if(current==null)
            return;
        System.out.print("-> "+current.val);
        inOrder(current.left);
        inOrder(current.right);
    }
    public void preOrder(TreeNode current){
        if(current==null)
            return;
        preOrder(current.left);
        System.out.print("-> "+
                current.val);

        preOrder(current.right);
    }
    private static class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int item){
            this.val=item;
        }
    }

    private static class NodeIndicator{
        public int data;
        public boolean isLeftNode;
        public boolean isRightNode;

        public Integer parent;

        public NodeIndicator(int data, boolean isLeftNode, boolean isRightNode,Integer parent) {
            this.data = data;
            this.isLeftNode = isLeftNode;
            this.isRightNode = isRightNode;
            this.parent=parent;
        }

        public NodeIndicator(int data,int parent){
            this.data=data;
            this.parent=parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeIndicator that = (NodeIndicator) o;
            return data == that.data && parent == that.parent ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, parent);
        }
    }

    public TreeNode buildTree(int[] preorder,int[] inorder){
        Map<NodeIndicator,TreeNode> map=new LinkedHashMap<>();

        root=new TreeNode(preorder[0]);
        NodeIndicator nodeIndicator=new NodeIndicator(root.val,false,false,null);
        map.put(nodeIndicator,root);
        Set<Integer> set=new HashSet();
        Map<Integer,TreeNode> parentMap=new LinkedHashMap<>();
        parentMap.put(root.val,root);

        TreeNode node=new TreeNode(preorder[0]);
        for(int i=1;i< preorder.length;i++){
            set.add(preorder[i-1]);
                NodeIndicator nodeIndicator1= determineParent(inorder,preorder[i],preorder[i-1],set,preorder);
            node=parentMap.get(nodeIndicator1.parent);
            if(nodeIndicator1.isLeftNode) {
                if(node!=null) {
                    node.left = new TreeNode(preorder[i]);
                    parentMap.put(nodeIndicator1.data, node.left);
                    node = node.left;
                }

                map.put(new NodeIndicator(preorder[i], nodeIndicator1.isLeftNode, nodeIndicator1.isRightNode, nodeIndicator1.parent), new TreeNode(preorder[i]));
            }else{
                if(node!=null) {
                    node.right = new TreeNode(preorder[i]);
                    parentMap.put(nodeIndicator1.data, node.right);
                    node = node.right;
                }

                map.put(new NodeIndicator(preorder[i], nodeIndicator1.isLeftNode, nodeIndicator1.isRightNode, nodeIndicator1.parent), new TreeNode(preorder[i]));

            }

            }
        return root=parentMap.get(root.val);
    }

    public void inOrderCheck(TreeNode current){
        if(current==null)
            return;
        System.out.print("-> "+current.val);
        inOrderCheck(current.left);
        inOrderCheck(current.right);
    }
    private NodeIndicator determineParent(int[] inOrderArray,int no,int prevNo,Set<Integer> set,int[] preOderArray){
        NodeIndicator nodeIndicator=null;
        int itemPosition=0;
        int rootPosition=0;
        int parentItem=0;
        Queue<Integer> queue=new ArrayDeque();
        boolean isNumberFound=false;
        for(int i=0;i< inOrderArray.length;i++){

            if(no==inOrderArray[i]) {
                itemPosition = i;
                if(!isNumberFound)
                    isNumberFound=true;
                else
                    isNumberFound=false;
            }
            if(isNumberFound)
                queue.add(inOrderArray[i]);
            if(prevNo==inOrderArray[i]) {
                rootPosition = i;
                if(!isNumberFound)
                    isNumberFound=true;
                else
                    isNumberFound=false;
            }

            if(!queue.isEmpty()) {
                int elements = queue.poll();
                if (set.contains(elements))
                    parentItem = elements;
            }
        }
       /* if(no==preOderArray.length-1)
            parentItem=inOrderArray[inOrderArray.length-2];*/

        if(itemPosition<rootPosition){
            nodeIndicator=new NodeIndicator(no,true,false,parentItem);
        }
        if(itemPosition>rootPosition){
            nodeIndicator=new NodeIndicator(no,false,true,parentItem);
        }
        return nodeIndicator;
    }

    public static void main(String ...args){
        FormTreeFromPreOrder tree=new FormTreeFromPreOrder();
       // int[] inOrderArray={8,4,9,2, 5,1,6,3,7};
        //int[] preOrderArray={1,2,4,8,9,5,3,6,7};
       //int[] inOrderArray={8,4,9,2,5,1,6,3,7};
       //int[] preOrderArray={1,2,4,8,9,5,3,6,7};
        int[] inOrderArray={2,3,1};
       int[] preOrderArray={1,2,3};
       // int[] preOrderArray={3,9,20,15,7};
        //int[] inOrderArray={9,3,15,20,7};
        TreeNode head= tree.buildTree(preOrderArray,inOrderArray);
       tree.inOrderCheck(head);
    }
}
