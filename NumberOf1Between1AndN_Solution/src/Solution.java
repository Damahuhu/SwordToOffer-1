public class Solution {
	/*
       ����:
        �����λ��1Ϊ����:   �����λ����0, 1, �� >=2 �������: 
        case 1: n=3141092, a= 31410, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 ��.
        case 2: n=3141192, a= 31411, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 + (92+1) ��. 
        case 3: n=3141592, a= 31415, b=92. �����λ��1�ĸ���Ӧ��Ϊ (3141+1) *100 ��. 
        ����������������� һ����ʽ����:
        (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
    */
	static public int NumberOf1Between1AndN_Solution(int n) {
		int ones = 0;
    	for(int m = 1; m <= n; m = m * 10){
    		int big = n / m; 
    		int sma = n % m;
    		ones += (big + 8)/10 * m;
    		if(big % 10 == 1) ones += sma + 1;
    	}
    	return ones;
    }
    public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(10));
	}
}