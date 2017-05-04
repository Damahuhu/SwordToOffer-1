//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
public class Solution {
    static public void FindNumsAppearOnce(int [] arr,int num1[] , int num2[]) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
        	temp ^= arr[i]; 
        }
        //����temp�Ķ���������һ��Ϊ1bit��index
        int index = 0;
        while(temp > 0){
        	if((temp & 0x1) == 1){
	        	break;
        	}
        	temp = temp >> 1;
        	index++;
        }
        for(int i = 0; i < arr.length; i++){
        	if(Indexis1bit(arr[i], index) == 1){
        		num1[0] ^= arr[i];
        	}else{
        		num2[0] ^= arr[i];
        	}
        }
    }
    static public int Indexis1bit(int num, int index){
    	
    	for(int i = 0; i < index; i++){
    		num = num >> 1;
    	}
    	int is1bit = (num & 0x1);
    	return is1bit;
    }
    public static void main(String[] args) {
    	int[] arr = {2,4,3,6,3,2,5,5};
    	int[] num1 = {0};
    	int[] num2 = {0};
    	FindNumsAppearOnce(arr, num1, num2);
		System.out.println(num1[0] +" " + num2[0]);
	}
}