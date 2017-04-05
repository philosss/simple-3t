package me.calzavara.simple3t;

import java.util.HashMap;
import java.util.Map;

class Grid {
	private Signs[][] grid=new Signs[3][3];
	private boolean first_init=true;
	Map<Integer,int[]> map = new HashMap<Integer, int[]>(); 
	
	public void view(boolean demo){
		System.out.println("___________________");
		int k=10;
		for(int i=0; i<3;i++){
			for(int j=0;j<3;j++){
				k--;
				if(first_init){
					map.put(k,new int[]{i,j});
					first_init=true;
				}
				if(j==2){
					if(demo) System.out.println("|  "+k+"  |"); 
					else System.out.println("|  "+(this.grid[i][j] instanceof Signs ? this.grid[i][j].getTipo() : " ")+"  |");
				}else{
					if(demo) System.out.print("|  "+k+"  ");
					else System.out.print("|  "+(this.grid[i][j] instanceof Signs ? this.grid[i][j].getTipo() : " ")+"  ");
				}
			}
		}
		System.out.println("___________________");
	}

	public void write(int position, boolean x_turn) throws OccupiedException, NoSuchCellException{
		if(position>9 || position<1) throw new NoSuchCellException();		
		if(grid[map.get(position)[0]][map.get(position)[1]]==null){
			grid[map.get(position)[0]][map.get(position)[1]]=new Signs(x_turn);
		}else{
			throw new OccupiedException();
		}
	}
	
	public void isThereAWinner() throws HaltException{
	int row,col,diag1,diag2;
		//first is X
		for(int player=0;player<2;player++){
			diag1=0;diag2=0;col=0;row=0;
			for(int i=0;i<3;i++){
				col=0;row=0;
				if(this.grid[i][i]!=null && ((player==0 && this.grid[i][i].getTipoBooleanX()) || (player==1 && !this.grid[i][i].getTipoBooleanX()))){
					diag1++;
					if(i==1) diag2++; 
					
				}

				
				
				for(int j=0;j<3;j++){
					
					if(this.grid[j][i]!=null && ((player==0 && this.grid[j][i].getTipoBooleanX()) || (player==1 && !this.grid[j][i].getTipoBooleanX()))) col++;
					if(this.grid[j][i]!=null && ((player==0 && this.grid[j][i].getTipoBooleanX()) || (player==1 && !this.grid[j][i].getTipoBooleanX()))) row++;
					
					
					if(i==0 && j==2 && this.grid[i][j]!=null && ((player==0 && this.grid[i][j].getTipoBooleanX()) || (player==1 && !this.grid[i][j].getTipoBooleanX()))) diag2++;
					if(i==2 && j==0 && this.grid[i][j]!=null && ((player==0 && this.grid[i][j].getTipoBooleanX()) || (player==1 && !this.grid[i][j].getTipoBooleanX()))) diag2++;
					
				}
				if(col==3||diag2==3||diag1==3||row==3) throw new HaltException(player);
			}
		}
		
	}

}
