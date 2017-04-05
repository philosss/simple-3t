

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		System.out.print("Welcome to the Simple Tic Tac Toe!");
		Grid grid=new Grid();
		System.out.println("The grid is ready.");
		System.out.println("First user has the X. Press anytime 0 to abort the game");
		System.out.print("Ready? press any key to continue...");
		try {
			System.in.read();
		} catch (java.io.IOException e1) {
			e1.printStackTrace();
		}
		for(int p=0;p<30;p++) System.out.println();
		int position;
		grid.view(true);
		boolean x_turn=true;
		boolean halt=false;
		for(int i=0;i<9 && !halt;i++){
			if(i%2==0){
				System.out.print("X's turn: ");
			}else{
				System.out.print("O's turn: ");
			}
			
			position= new Scanner(System.in).nextInt();
			
			try{
				if(position==0){
					throw new HaltException();
				}else{
					try{
						for(int p=0;p<30;p++) System.out.println();
						grid.write(position, x_turn);
						x_turn=!x_turn;
						grid.isThereAWinner();
					}catch(IOException e){
						for(int p=0;p<30;p++) System.out.println();
						System.out.println();
						System.out.println(e.getWhy());
						i--;
					}finally{
						grid.view(true);
						grid.view(false);
					}
				}
				if(i==8) throw new EvenException();
			}catch(HaltException e){
				System.out.println(e.getWhy());
				halt=true;
			}	
		}
	}
	
}
