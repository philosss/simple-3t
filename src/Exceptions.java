

/* UNDER IO */
class IOException extends Exception{	
	private static final long serialVersionUID = 1L;

	public String getWhy() {
		return "Generic IOException";
	}
}
class OccupiedException extends IOException {
	private static final long serialVersionUID = 1L;

	public String getWhy() {
		return "This spot has been already occupied";
	}
}
class NoSuchCellException extends IOException {
	private static final long serialVersionUID = 1L;
	public String getWhy() {
		return "This spot does not exists";
	}
}


class HaltException extends Exception {
	private static final long serialVersionUID = 1L;
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
	private static final long serialVersionUID = 1L;
	public EvenException(){
		this.why="There's no winner!";
	}
}