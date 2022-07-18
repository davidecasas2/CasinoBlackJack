package modelo;

public class Carta {

	enum Palo {
		TREBOL, DIAMANTE, CORAZONES, PICAS
	};
	
	private Palo palo;
	private int num;
	
	
	public Carta(Palo palo, int num) {
		this.palo = palo;
		if (num>=1 && num <=13) {
			this.num = num;
		}
	}

	public Palo getPalo() {
		return palo;
	}

	public int getNum() {
		return num;
	}
	
	public int getValor() {
		if (this.num==1) {
			return 11;
		} else if(this.num>10) {
			return 10;
		} else {
			return this.num;
		}
	}
	
	public String mostrarNumero() {
		if(this.num==1) {
			return "AS";
		} else if(this.num==11) {
			return "J";
		} else if(this.num==12) {
			return "Q";
		} else if (this.num==13) {
			return "K";
		} else {
			return Integer.toString(num);
		}
	}

	@Override
	public String toString() {
		return "[ " +this.mostrarNumero() + " - "+ this.palo + "]";
	}
}
