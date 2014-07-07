package java_essential_training;

public class Ascii_figure_exer {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i+=2){
			for(int j = 1; j <= (11-i)/2; j++){
				System.out.print('-');
			}
			for(int j = 1; j<=i; j++ ){
				System.out.print(i);
			}
				
			for(int j = 1; j <= (11-i)/2; j++){
				System.out.print('-');
			}
			System.out.println();
		}
		
		
	}
//	-----1-----
//	----333----
//	---55555---
//	--7777777--
//	-999999999-

}
