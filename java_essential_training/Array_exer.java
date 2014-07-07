package java_essential_training;

public class Array_exer {

	public static void main(String[] args) {
		int n = 669260267;
		int[] counts = new int[10];
		while (n > 0) {
		    // pluck off a digit and add to proper counter
		    int digit = n % 10;
		    counts[digit]++;
		    n = n / 10;
		    
		int[][] mat =new int[3][4];
		mat[0][0] = -1;
		
		int[][] jagged = new int[3][];
		jagged[0] = new int[2];
		jagged[1] = new int[4];
		jagged[2] = new int[3];
		
		int[][] triangle = new int[11][];
		fillIn(triangle);
		print(triangle);
		}
	}
		
	public static void fillIn(int[][] triangle) {
			for (int i = 0; i < triangle.length; i++) {
				triangle[i] = new int[i + 1];
				triangle[i][0] = 1;
				triangle[i][i] = 1;
				for (int j = 1; j < i; j++) {
					triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]);
				}
			}
	}
	
	public static void print(int[][] triangle) {
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				System.out.print(triangle[i][j] + " ");
			}
			System.out.println();
		}
	}
}
