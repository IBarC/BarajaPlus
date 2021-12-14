package models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	Baraja b = new Baraja(1, true);

	/**
	 * Roba una carta de la baraja
	 * 
	 * @return
	 */
	public Carta robarCartaDeBaraja() {
		Carta c = b.lista_cartas.get(0);
		b.lista_cartas.remove(c);
		return c;
	}

	/**
	 * Roba un cierto número de cartas de la baraja de la mesa
	 * 
	 * @param n número de cartas que se roban
	 * @return un array con las cartas robadas
	 */
	public List<Carta> robarVariasCartas(int n) {
		List<Carta> mascartas = new ArrayList<Carta>();

		for (int i = 0; i < n; i++) {
			Carta c = b.lista_cartas.get(0);
			mascartas.add(c);
			b.lista_cartas.remove(c);
		}

		return mascartas;
	}

	void addCartaABaraja(Carta c) {
		b.lista_cartas.add(c);
	}
}
