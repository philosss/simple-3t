

public class Signs {
	private char tipo;
	public Signs(boolean x_turn){
		if(x_turn){
			this.tipo='X';
		}else{
			this.tipo='O';
		}
		
	}
	public char getTipo() {
		return tipo;
	}
	public boolean getTipoBooleanX() {
		return tipo=='X' ? true : false; 
	}
}
