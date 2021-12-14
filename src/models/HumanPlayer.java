package models;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

	public HumanPlayer(String nombre, double puntos, Mano mano, Mesa mesa) {
		super(nombre, puntos, mano, mesa);
		puntos = 0;
	}

	Scanner sc = new Scanner(System.in);

	@Override
	void jugarTurno() {
		boolean salir = false;
		int opc = 0;
		do { // Juega el turno hasta que el jugador se planta o se pasa de puntuaci�n
			try {
				System.out.println("�Qu� quieres hacer?:\n1. Coger carta\n2. Plantarse");
				opc = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Elige una opci�n v�lida por favor");
			}

			switch (opc) {
			case 1:
				Carta robada = mesa.b.lista_cartas.get(0);
				mesa.b.lista_cartas.remove(0);
				System.out.println("Tu carta es el " + robada.getNombreCarta());
				mano.lista_cartas.add(robada);
				this.puntos += robada.getValor7ymedia();
				System.out.println("Tu puntuaci�n es de " + this.puntos + " puntos");
				break;

			case 2:
				salir = true;
				System.out.println("El turno del jugador " + this.nombre + " ha terminado.");
				break;
			}

			if (this.puntos > 7.5) {
				System.out.println("Lo siento te has pasado de puntos");
				salir = true;
				this.puntos = 0;
			}

		} while (!salir);

	}

}
