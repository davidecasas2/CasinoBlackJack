package ppal;

import java.util.Scanner;

import excepciones.SeHaPasadoException;
import excepciones.TieneBlackJackException;
import modelo.Mano;
import modelo.Mazo;

public class Juego {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		Mano jugador = new Mano();
		Mano banca = new Mano();
		
		System.out.println("Baranjando carta...");
		mazo.barajar();
		
		try {
			System.out.println("Repartiendo cartas inciales...");
			jugador.pedirCarta(mazo);
			System.out.println("Jugador: "+jugador);
			
			banca.pedirCarta(mazo);
			System.out.println("Banca: "+banca);
			
			jugador.pedirCarta(mazo);
			System.out.println("Jugador: "+jugador);
			
			banca.pedirCarta(mazo,false);
			System.out.println("Banca: "+banca);
		} catch (SeHaPasadoException | TieneBlackJackException e) {
		}
		
		
		
		Scanner entrada = new Scanner(System.in);
		int opcion=1;
		try {
			while (opcion!=0 && !jugador.finDeJuego()) {
				System.out.println("¿Quieres carta ) (1-Si, 0-NO)");
				opcion  = entrada.nextInt();
				if (opcion!=0) {
					jugador.pedirCarta(mazo);
					System.out.println("Tienes en tu mano \n"+jugador);
				}
			} 
			
			System.out.println("Juega la banca....");
			banca.descubrir();
			System.out.println("cartas de la banca: "+banca);
			try {
				do {
					System.out.println("Pidiendo carta");
					banca.pedirCarta(mazo);
					System.out.println(banca);
				} while (banca.valorMano()<=16);
				
				if (jugador.valorMano()>banca.valorMano()) {
					System.out.println("Jugador gana");
				} else if (jugador.valorMano()==banca.valorMano()) {
					System.out.println("empate");
				} else {
					System.out.println("GAna la banca");
				}
				
			} catch(SeHaPasadoException e) {
				System.out.println("La banca se ha pasado "+banca);
				System.out.println("Gana el jugador");
			} catch (TieneBlackJackException e) {
				System.out.println("La banca gana, tiene blackjack"+banca);
			}
			
			
		}catch(SeHaPasadoException e) {
			System.out.println("TE has pasado "+jugador);
			System.out.println("Gana la banca");
			banca.descubrir();
			System.out.println(banca);
		} catch (TieneBlackJackException e) {
			System.out.println("Tienes BlackJack. Tu ganas "+jugador);
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
