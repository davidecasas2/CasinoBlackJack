package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Carta.Palo;

/**
 * Clase que modela el mazo de carta, contedrá las 52
 * cartas de la baraja francesa. Usa la clase 
 * @see Carta Carta
 * 
 * <p>@author David Casas</p>
 *
 */
public class Mazo {

	protected List<Carta> cartas;
	
	/**
	 * Constructor sin parámetros de la clase. Genera todas las carta de la 
	 * baraja, las 13 carta de cada palo. Las carta quedan ordenadas por Palo
	 * primero TREBOL, DIAMANTE, CORAZONES, PICAS y luego por número.
	 */
	public Mazo() {

		cartas= new ArrayList<>();
		// recorremos toos los palos y las 13 cartas de cada palo
		for (Palo palo : Palo.values()) {
			for (int i=1;i<=13; i++) {
				Carta c = new Carta(palo,i);
				cartas.add(c);
			}
		}
	}
	
	/**
	 * Método de la clase que baraja las cartas de manera aleatoria
	 */
	public void barajar() {
		Collections.shuffle(cartas);
	}

	
	
	/**
	 * Muestra todas las cartas del mazo. Cada una en una línea
	 * @return String con las cadena del mazo
	 */
	@Override
	public String toString() {
		String texto = "";
		for (Carta carta : cartas) {
			texto = texto + carta + "\n";
		}
		return texto;
	}
	
	/**
	 * Extrae una carta del mazo y la devuelve como parámetro
	 * @return Carta la carta que se encontraba arriba en el mazo
	 */
	public Carta solicitarCarta() {
		Carta c = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return c;
	}
	

	public static void main(String[] args) {
		Mazo m = new Mazo();
		System.out.println(m);
		m.barajar();
		System.out.println(m);
		Carta c = m.solicitarCarta();
		System.out.println("La carta es "+c);
		System.out.println(m);
	}
	
}
