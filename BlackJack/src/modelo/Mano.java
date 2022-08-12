package modelo;

import java.util.ArrayList;

import excepciones.SeHaPasadoException;
import excepciones.TieneBlackJackException;

/**
 * Clase Mano quie representa las carta que tiene en 
 * su mano un Jugador. La clase extiende de Mazo
 * <p>@author David Casas</p>
 *
 */
public class Mano extends Mazo {

	/**
	 * Constructor sin parámetros que crea una mano 
	 * de cartas vacía.
	 */
	public Mano() {
		this.cartas = new ArrayList<>();
	}
	
	/**
	 * Método que calcula el valor de Blackjack que comtiene la mano 
	 * de cartas. Se basa en la suma de los valores de cada carta de la
	 * mano
	 * @see Carta#getValor() getValor
	 * @return int con el valor de la mano o 0 si no hay cartas en la mano
	 */
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma=suma+carta.getValor();
		}
		return suma;
	}
	/**
	 * Igual que el método valorMano, pero sólo calcula el valor de 
	 * las cartas que son visibles. 
	 * @see Mano#valorMano() valorMano
	 * @return int con el valor de las cartas visibles de la mano o cero
	 *         si ninguna carta es visible o no hay cartas en la mano
	 */
	public int valorManoVisibles() {
		int suma=0;
		for (Carta carta : cartas) {
			if (carta.isVisible()) {
				suma=suma+carta.getValor();
			}
		}
		return suma;
	}
	/**
	 * Método que hace visibles todas las cartas de la mano
	 * @see Carta#setVisible(boolean) setVisible(boolean)
	 */
	public void descubrir() {
		for (Carta carta : cartas) {
			carta.setVisible(true);
		}
	}
	
	/**
	 * Método que detemina si el juego del blackjack ha acabado o no.
	 * El juego finaliza si el valor de la mano es superior a 21
	 * 
	 * @return booelan true si el valor de la mano es superior a 21
	 *         y false en caso contrario
	 */
	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
		//return valorMano()>=21;
	}

	@Override
	/**
	 * Muestra la puntuación del valor de la mano de las cartas visibles
	 * çtambién muestra las cartas de la mano.
	 */
	public String toString() {
		return "Valor de la mano:" + valorManoVisibles() + "\n"
	    + super.toString();
	}
	
	/**
	 * Método que solicita una carta al Mazo pasado como parámetro 
	 * para incluirla en la mano.
	 *
	 * @param m Mazo del cual se solicita la carta
	 * @throws SeHaPasadoException Se lanza esta excepción cuando el 
	 *         valor de la mano sobrepasa 21
	 * @throws TieneBlackJackException Se lanza esta excepción cuando el 
	 *         valor de la mano alcanza el valor de 21
	 */
	public void pedirCarta(Mazo m) 
			throws SeHaPasadoException, TieneBlackJackException {
		if (valorMano()>21) {
			throw new SeHaPasadoException("se ha pasado");
		}
		if (valorMano()==21) {
			throw new TieneBlackJackException();
		}
		
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
		
		if (valorMano()>21) {
			throw new SeHaPasadoException("se ha pasado");
		}
		if (valorMano()==21) {
			throw new TieneBlackJackException();
		}
	}
	
	/**
	 * Método que pie una carta al Mazo pasado como parámetro
	 * estableciendo si la carta será visible o no
	 * @param m Mazodel que se solicita la carta
	 * @param visible boolean true si la carta solcitada es visible y 
	 *        false en caso contrario
	 */
	public void pedirCarta(Mazo m, boolean visible) {
		if (!finDeJuego()) {
			Carta c = m.solicitarCarta();
			c.setVisible(visible);
			this.cartas.add(c);
		}
	}
	
	

	
}
