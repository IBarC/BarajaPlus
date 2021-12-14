package models;

import java.util.Scanner;

public class CPUPlayer extends AbstractPlayer {

	public CPUPlayer(String nombre, double puntos, Mano mano, Mesa mesa) {
		super(nombre, puntos, mano, mesa);
		puntos = 0;
	}

	Scanner sc = new Scanner(System.in);

	@Override
	void jugarTurno() {

		boolean salir = false;
		do { // La cpu juega hasta que saca un 7.5 o menos. Si llega a 6 puntos elige
				// aleatoriamente si sigue jugando o no
			Carta robada = mesa.b.lista_cartas.get(0);
			mesa.b.lista_cartas.remove(0);
			System.out.println("La carta que roba es el " + robada.getNombreCarta());
			mano.lista_cartas.add(robada);
			this.puntos += robada.getValor7ymedia();
			System.out.println("La puntuación de la cpu es de " + this.puntos + " puntos");

			if (this.puntos >= 6) {
				int decisionAl = (int) (Math.random() * 4);
				if (decisionAl == 3) {
					Carta robada2 = mesa.b.lista_cartas.get(0);
					mesa.b.lista_cartas.remove(0);
					System.out.println("La carta que roba es el " + robada2.getNombreCarta());
					mano.lista_cartas.add(robada2);
					this.puntos += robada2.getValor7ymedia();
					System.out.println("La puntuación de la cpu es de " + this.puntos + " puntos");
				} else {
					salir = true;
					System.out.println("El turno de la cpu ha terminado");
				}

				if (this.puntos > 7.5) {
					System.out.println("Lo siento te has pasado de puntos");
					salir = true;
					this.puntos = 0;
				}
			}

		} while (!salir && this.puntos < 7.5);
	}

}
