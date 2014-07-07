package java_fundation_exer;

public class Ascii_complex_figure {
	public static final int SIZE = 3;
	
	public static void writeChars( int x, int y){
		for(int m = x; m<= y; m++){
			System.out.print(" ");
		}
	}
	
	public static void topcover(){
		writeChars(1,4*SIZE+2);
		for(int i = 1; i <= SIZE*2-1; i++){
			System.out.print("*");			
		}
		System.out.println();
	}
	
	public static void top(){
		for(int j = 1; j <= (SIZE-1)*2; j++){
			writeChars(1,4*SIZE+2);
			for(int i = 1; i <= (SIZE*2-1); i++){
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public static void body(){
		for(int i = 1;  i<= (SIZE*SIZE+1); i++){
			writeChars(1,4*SIZE);
			for(int j =1; j<=(2*(SIZE+1)+1);j++){
				System.out.print("~");
			}
			System.out.println();
			writeChars(1,4*SIZE);
			System.out.print("|");
			for(int k = 1; k <= SIZE; k++){
				System.out.print("-O");
			}
			System.out.print("-|");
			System.out.println();
		}
	}
	
	public static void base(){
		for (int i=1; i <= (SIZE/2+1); i++){
			for(int j=i; j <= SIZE/2; j++){
				System.out.print("   ");
			}
			System.out.print("/");
			int counter = 5;
			for (int m = 2; m <= SIZE; m++){
				if (m%2 == 0){
					counter += 2;
				}
				else{
					counter += 5;
				}
			}
			for(int k = 1; k <=counter+(i-1)*3; k++ ){
				System.out.print("\"'");
			}			
			System.out.print("\"\\");
			System.out.println();
		}
		
	}
	
	public static void bottom(){
		for(int i = 1;  i<= SIZE; i++){
			System.out.print("/");
			for(int j =1; j<=5*SIZE;j++){
				System.out.print("\"O");
			}
			System.out.print("\"\\");
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		topcover();
		top();
		topcover();
		body();
		base();
		bottom();
		
	}
}
