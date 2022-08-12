package modelo;

/**
 * 
 * 
 * 
 * Clase que modela una carta de la baraja. La carta tendrá
 * un número y un palo y representará una carta de la baraja
 * francesa con los palos diamantes, picas, corazones y rombos.
 * Los números de la baraja van desde el 1 (AS) hasta el 10
 * la J, Q y K.
 * 
 * @author David Casas
 */
public class Carta {

	/**
	 * Tipo enumerado que representa al palo de la carta
	 * Toma los valores TREBOL, DIAMANTE, CORAZONES o
	 */
	enum Palo {
		TREBOL, DIAMANTE, CORAZONES, PICAS
	};
	
	private Palo palo;
	private int num;
	private boolean visible;
	
	/**
	 * Constructor parametrizado que crea una carta visible dado
	 * el palo y número de la carta
	 * @param palo Palo el palo de carta(TREBOL, DIAMANTE, CORAZONES, PICAS)
	 * @param num int El número de la carta. Debe ser un número comprendido
	 *        entre 1 y 13
	 */
	public Carta(Palo palo, int num) {
		this.palo = palo;
		if (num>=1 && num <=13) {
			this.num = num;
		}
		this.visible=true;
	}

	/**
	 * Constructor parametrizado que crear una carta dado un palo, un número
	 * e indicando si la carta debe estar visible o no.
	 * @param palo Palo el palo de carta(TREBOL, DIAMANTE, CORAZONES, PICAS)
	 * @param num int El número de la carta. Debe ser un número comprendido
	 *        entre 1 y 13
	 * @param visible boolean true si la carta se muestra o false en caso 
	 *        contrario
	 */
	public Carta(Palo palo, int num, boolean visible) {
		this.palo = palo;
		if (num>=1 && num <=13) {
			this.num = num;
		}
		this.visible=visible;
	}
	
	/**
	 * Método accesor que devuelve el palo de una carta
	 * @return Palo con el palo de la carta
	 */
	public Palo getPalo() {
		return palo;
	}

	/**
	 * Método accesor que devuelve el número de una carta
	 * @return int con el numero de la carta (comprendido entre 1 y 13)
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * Método accesor que devuelve verdadero si la carta se muestra a los
	 * jugadores
	 * @return boolean true si la carta es visible, false en caso contrario
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Método de establecimiento que cambia la visibilidad de la carta
	 * @param visible boolean true para mostrarla, false en caso contrario
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Método que devuelve el valor de una carta en el juego del blackjack
	 * según la siguiente informacion:
	 * <table>
	 *     <tr>
	 *     		<th>Carta</th>
	 *     		<th>Valor</th>
	 *     </tr>
	 *     <tr>
	 *     		<td>As</td>
	 *     		<td>1</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>2</td>
	 *     		<td>2</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>3</td>
	 *     		<td>3</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>4</td>
	 *     		<td>4</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>5</td>
	 *     		<td>5</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>6</td>
	 *     		<td>6</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>7</td>
	 *     		<td>7</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>8</td>
	 *     		<td>8</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>9</td>
	 *     		<td>9</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>10</td>
	 *     		<td>10</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>J</td>
	 *     		<td>10</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>Q</td>
	 *     		<td>10</td>
	 *     </tr>
	 *     <tr>
	 *     		<td>K</td>
	 *     		<td>10</td>
	 *     </tr>
	 *     <captio>Valores que toman las cartas</caption>
	 * </table>
	 * @return int con el valor de la carta
	 */
	public int getValor() {
		if (this.num==1) {
			return 11;
		} else if(this.num>10) {
			return 10;
		} else {
			return this.num;
		}
	}
	
	/**
	 * Muestra el número de la carta (AS, 1,2,3...,J,Q,K)
	 * @return String con la representación de la carta
	 */
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
	/**
	 * Muestra la carta en el modo [ Palo - Número ]
	 * @return String con la representación de la carta
	 */
	public String toString() {
		if (this.visible) {
			return "[ " +this.mostrarNumero() + " - "+ this.palo + "]";
		} else {
			return "[ Carta no visible ]";
		}
	}
}
