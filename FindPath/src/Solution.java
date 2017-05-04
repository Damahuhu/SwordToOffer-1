import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	static ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>> ();
	static Stack<Integer> stack = new Stack<Integer>();
	static int curSum = 0;
	static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length != in.length || pre.length == 0){
        	return null;
        }
        TreeNode tree = new TreeNode(pre[0]);
        int root_index;
        for(root_index = 0; root_index < in.length; root_index++){
        	if(in[root_index] == pre[0]){
        		tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + root_index), Arrays.copyOfRange(in, 0, root_index));
                tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, root_index + 1, in.length), Arrays.copyOfRange(in, root_index + 1, in.length));
                break;
        	}
        }
        return tree;
    }
	static public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		if(root != null){
			stack.add(root.val);
			curSum += root.val;
			boolean isLeaf = root.left == null && root.right == null;
			// �ж��Ƿ�ΪҶ�ڵ�
        	if(isLeaf){
        		//��Ҷ�ڵ�Ļ����ж�·�����Ϊtarget
        		if(curSum == target){
	        		ArrayList<Integer>  list = new ArrayList<Integer> (stack);
	        		result.add(list);
        		}
        	}
        	//����Ҷ�ڵ�Ļ����������ӽڵ�������ӽڵ�
        	else{
	        	if(root.left != null){
	            	FindPath(root.left, target);
	            }
	            if(root.right != null){
	            	FindPath(root.right, target);
	            }
        	}
        	//�ڷ��ظ��ڵ�֮ǰ���ڵ�ǰ·��ɾ����ǰ�ڵ�
			stack.pop();
        	curSum -= root.val;
        	
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] pre = {10,5,4,7,12};
		int[] in = {4,5,7,10,12};
		System.out.println(FindPath(reConstructBinaryTree(pre,in),22));
	}
}
