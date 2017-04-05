package me.calzavara.simple3t;

class Grid {
	Signs[][] grid=new Signs[3][3];
	
	public void view(boolean demo){
		System.out.println("___________________");
		int k=0;
		for(int i=0; i<3;i++){
			for(int j=0;j<3;j++){
				k++;
				if(j==2){
					if(demo) System.out.println("|  "+k+"  |");
					else System.out.print("|  "+grid[i][j]+"  ");
				}else{
					if(demo) System.out.print("|  "+k+"  ");
					else System.out.print("|  "+grid[i][j]+"  ");
				}
			}
		}
		System.out.println("___________________");
	}

	public void write(int position, boolean x_turn) throws OccupiedException, NoSuchCellException{
		int x=0,y=0;
		switch(position){
		case 1:
			y=0;
			break;
		case 2:
			y=1;
			break;
		case 3:
			y=2;
			break;
		case 4:
			x=1;y=0;
			break;
		case 5:
			x=1;y=1;
			break;
		case 6:
			x=1;y=2;
			break;
		case 7:
			x=2;y=0;
			break;
		case 8:
			x=2;y=1;
			break;
		case 9:
			x=2;y=2;
			break;	
		default:
			throw new NoSuchCellException();
		}
		if(grid[x][y]==null){
			grid[x][y]=new Signs(x_turn);
		}else{
			throw new OccupiedException();
		}
	}

}
