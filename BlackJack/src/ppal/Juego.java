package ppal;

import java.util.Scanner;

import modelo.Mano;
import modelo.Mazo;

public class Juego {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		Mano jugador = new Mano();
		
		System.out.println("Baranjando carta...");
		mazo.barajar();
		
		Scanner entrada = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("¿Quieres carta ) (1-Si, 0-NO)");
			opcion  = entrada.nextInt();
			if (opcion ==1) {
				jugador.pedirCarta(mazo);
				System.out.println("Tienes en tu mano \n"+jugador);
			} 
		} while (opcion!=0 && !jugador.finDeJuego());
		
		Mano banca = new Mano();
		System.out.println("Juega la banca....");
		
		if (jugador.valorMano()>21){
			System.out.println("Gana la banca");
		} else {
			do {
				System.out.println("Pidiendo carta");
				banca.pedirCarta(mazo);
				System.out.println(banca);
			} while (banca.valorMano()<=16);
			
			if (jugador.valorMano()>banca.valorMano() || banca.valorMano()>21) {
				System.out.println("Enhorabuena has ganado: "+jugador);
			} else if (jugador.valorMano()==banca.valorMano()){
				System.out.println("Empate");
				System.out.println("Jugador: "+jugador);
				System.out.println("Banca: " + banca);
			}else {
				System.out.println("Gana la banca: "+banca);
			}
		}
		
		
		
		
		
		
		
		
		/*System.out.println("Fin de juego. Tu mano es\n"+jugador);
	
		if (jugador.valorMano()==21) {
			System.out.println("CAmpeón. Has conseguido Blackjack(21)");
		} else if (jugador.valorMano()>21) {
			System.out.println("Te has pasado");
		} else {
			System.out.println("Te has plantado con "+jugador.valorMano());
		}
		
		System.out.println("juega responsablemente");*/
		

	}

}
