package java_fundation_exer;
import java.util.Scanner;
public class A_game_of_RoshamBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Rock Paper Scissors. I, Computer, "
				+ "will be your opponent.");
		
		Scanner console = new Scanner(System.in);
		String username = get_username(console);
		
		System.out.println("All right " + username + ". How many rounds "
				+ "would you like to play? ");
		
		int game_rounds = get_rounds(console);
		
		play_RoshamBo(username,game_rounds,console);		
	}
	
	public static String get_username(Scanner name_input) {
		System.out.print("Please type in your name and press return: ");
		String name = name_input.next();
		System.out.println("Welcome " + name + ".");
		return name;
	}
	
	public static int get_rounds(Scanner round_input){
		System.out.print("Enter the number of rounds you want to "
				+ "play and press return: ");
		int num = round_input.nextInt();
		round_input.nextLine();  //to advance the Scanner past the end of line character
		return num;
	}
	
	public static void play_RoshamBo(String user, int rounds, Scanner input){
		int pc_won = 0;
		int user_won = 0;
		int draws = 0;
		int user_int;
		int pc_int;
		String user_choice;
		String pc_Choice;
		RandomPlayer pc = new RandomPlayer();

		for(int i = 0; i < rounds; i ++){
			System.out.println();
			System.out.println("Round " + (int)(i+1) + ".");
			System.out.println(user + ", please enter your choice for this round.");
			System.out.print("1 for rock, 2 for paper, and 3 for scissors: ");
			
			user_int = input.nextInt();
			input.nextLine();
			pc_int = pc.play();
			
			user_choice = actual_choice(user_int);
			pc_Choice = actual_choice(pc_int);
			System.out.println("Computer picked " + pc_Choice + ", " + user + 
					" picked " + user_choice + ".");
			System.out.println();
			
			if (pc_int == user_int){
				System.out.println("This round is a draw.");
				draws +=1;
			}
			else{
				if (pc_int == 2 && user_int ==1){
					System.out.println("Paper covers rock. I win.");
					pc_won += 1;
				}					
				if (pc_int == 1 && user_int ==2){
					System.out.println("Paper covers rock. you win.");
					user_won += 1;
				}					
				if (pc_int == 3 && user_int ==2){
					System.out.println("Scissors cut paper. I win.");
					pc_won += 1;
				}					
				if (pc_int == 2 && user_int ==3){
					System.out.println("Scissors cut paper. you win.");
					user_won += 1;
				}					
				if (pc_int == 1 && user_int ==3){
					System.out.println("Rock breaks scissors. I win.");
					pc_won += 1;
				}					
				if (pc_int == 3 && user_int ==1){
					System.out.println("Rock breaks scissors. you win.");
					user_won += 1;
				}					
			}			
		}
		System.out.println();
		System.out.println("Number of games of Rock Paper Scissors: " + rounds);
		System.out.println("Number of times Computer won: " + pc_won);
		System.out.println("Number of times " + user + " won: " + user_won);
		System.out.println("Number of draws: " + draws);

		if (pc_won > user_won)
			System.out.println("I, Computer, am a master at Rock, Paper, Scissors.");
		if (pc_won < user_won)
			System.out.println("You are a master at Rock, Paper, Scissors.");
		else
			System.out.println("We are evenly matched at this game.");
	}
	
	public static String actual_choice(int num){
		if (num == 1)
			return "rock";
		else if (num == 2)
			return "paper";
		else
			return "scissors";
	}
}
