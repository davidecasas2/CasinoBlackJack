package modelo;

public class Carta {

	enum Palo {
		TREBOL, DIAMANTE, CORAZONES, PICAS
	};
	
	private Palo palo;
	private int num;
	private boolean visible;
	
	
	public Carta(Palo palo, int num) {
		this.palo = palo;
		if (num>=1 && num <=13) {
			this.num = num;
		}
		this.visible=true;
	}

	public Carta(Palo palo, int num, boolean visible) {
		this.palo = palo;
		if (num>=1 && num <=13) {
			this.num = num;
		}
		this.visible=visible;
	}
	
	public Palo getPalo() {
		return palo;
	}

	public int getNum() {
		return num;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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
		if (this.visible) {
			return "[ " +this.mostrarNumero() + " - "+ this.palo + "]";
		} else {
			return "[ Carta no visible ]";
		}
	}
}
