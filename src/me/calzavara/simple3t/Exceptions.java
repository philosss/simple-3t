package me.calzavara.simple3t;

class OccupiedException extends Exception {
	private String why="La cella è già occupata";
	public String getWhy() {
		return why;
	}
}
class NoSuchCellException extends Exception {
	private String why="La cella selezionata non esiste";
	public String getWhy() {
		return why;
	}
}
class HaltException extends Exception {
	private String why="Game aborted";
	public String getWhy() {
		return why;
	}
}
