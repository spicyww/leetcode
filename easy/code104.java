//给定一个二叉树 root ，返回其最大深度。
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
// 深度优先
public class code104 {
    public int search(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            int leftHeight = search(root.left);
            int rightHeight = search(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
