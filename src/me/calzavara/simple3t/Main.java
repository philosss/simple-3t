package me.calzavara.simple3t;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		System.out.println("Welcome to the Simple Tic Tac Toe!");
		Grid grid=new Grid();
		System.out.println("The grid is ready. First user has the X. Use the numbers to place a sign on the spot that you prefer");
		grid.view(true);
		System.out.println("First user has the X. Use the numbers to place a sign on the spot that you prefer");
		System.out.println("Press 0 to exit");
		int position;
		boolean x_turn=true;
		boolean halt=false;
		for(int i=0;i<9 && !halt;i++){
			if(i%2==0){
				System.out.print("X's turn: ");
			}else{
				System.out.print("O's turn: ");
			}
			Scanner sc = new Scanner(System.in);
			position= sc.nextInt();
			
			try{
				if(position==0){
					throw new HaltException();
				}else{
					try{
						grid.write(position, x_turn);
						grid.view(false);
					}catch(NoSuchCellException e){
						System.out.println(e.getWhy());
						i--;
					}catch(OccupiedException e){
						System.out.println(e.getWhy());
						i--;
					}
				}
			}catch(HaltException e){
				System.out.println(e.getWhy());
				halt=true;
			}	
		}
		System.out.println("Bye bye!");
	}
	
}
