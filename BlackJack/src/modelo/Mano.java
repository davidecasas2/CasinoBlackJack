package modelo;

import java.util.ArrayList;

import excepciones.SeHaPasadoException;
import excepciones.TieneBlackJackException;

public class Mano extends Mazo {

	public Mano() {
		this.cartas = new ArrayList<>();
	}
	
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma=suma+carta.getValor();
		}
		return suma;
	}
	
	public int valorManoVisibles() {
		int suma=0;
		for (Carta carta : cartas) {
			if (carta.isVisible()) {
				suma=suma+carta.getValor();
			}
		}
		return suma;
	}
	
	public void descubrir() {
		for (Carta carta : cartas) {
			carta.setVisible(true);
		}
	}
	
	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
		//return valorMano()>=21;
	}

	@Override
	public String toString() {
		return "Valor de la mano:" + valorManoVisibles() + "\n"+ super.toString();
	}
	
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
	public void pedirCarta(Mazo m, boolean visible) {
		if (!finDeJuego()) {
			Carta c = m.solicitarCarta();
			c.setVisible(visible);
			this.cartas.add(c);
		}
	}
	
	

	
}
