package me.calzavara.simple3t;

/* UNDER IO */
class IOException extends Exception{	
	public String getWhy() {
		return "Generic IOException";
	}
}
class OccupiedException extends IOException {
	public String getWhy() {
		return "This spot has been already occupied";
	}
}
class NoSuchCellException extends IOException {
	public String getWhy() {
		return "This spot does not exists";
	}
}


class HaltException extends Exception {
	protected String why;
	public final String getWhy() {
		return why;
	}
	public HaltException(){
		this.why="Game aborted";
	}
	public HaltException(int winner){
		this.why="The winner is "+(winner==0 ? 'X' : 'O');
		
		
	}
}
class EvenException extends HaltException {
	
	public EvenException(){
		this.why="There's no winner!";
	}
}