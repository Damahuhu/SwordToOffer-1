
import java.util.Stack;
 
/*˼·����һ��ջdata�������ݣ�������һ��ջmin����������ջ��С����
���磬data��������ջ��5,  4,  3, 8, 10, 11, 12, 1
       ��min������ջ��5,  4,  3��no,no, no, no, 1
 
no����˴β���ջ
ÿ����ջ��ʱ�������ջ��Ԫ�ر�min�е�ջ��Ԫ��С���������ջ��������ջ��
 */
public class Solution {
	static Stack<Integer> data = new Stack<Integer>();
	static Stack<Integer> min = new Stack<Integer>();
    static public void push(int node) {
       data.add(node);
       if(min.isEmpty()){
    	   min.add(node);
       }else if(min.peek() > node){
    	   min.add(node);
       }else{
    	   min.add(min.peek());
       }
    }
     
    static public void pop() {
    	if(data.size() > 0 && min.size() > 0){
	        data.pop();
	        min.pop();
    	}
    }
     
    static public int top() {
        return data.peek();
    }
     
    static public int min() {
    	System.out.println(min.peek());
        return min.peek();
    }
    public static void main(String[] args) {
		push(3);
		min();
		push(4);
		min();
		push(2);
		min();
		push(3);
		min();
	}
}