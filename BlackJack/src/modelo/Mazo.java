package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Carta.Palo;


public class Mazo {

	protected List<Carta> cartas;
	
	public Mazo() {
		
		cartas= new ArrayList<>();
		for (Palo palo : Palo.values()) {
			for (int i=1;i<=13; i++) {
				Carta c = new Carta(palo,i);
				cartas.add(c);
			}
		}
	}
	
	public void barajar() {
		Collections.shuffle(cartas);
	}

	
	@Override
	public String toString() {
		String texto = "";
		for (Carta carta : cartas) {
			texto = texto + carta + "\n";
		}
		return texto;
	}
	
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
