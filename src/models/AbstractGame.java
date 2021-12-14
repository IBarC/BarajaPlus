package models;

import java.util.ArrayList;

public abstract class AbstractGame {
	// Los métodos abstractos son necesarios implementarlos en las clases hijas

	protected boolean finished;
	protected ArrayList<AbstractPlayer> jugadores = new ArrayList<AbstractPlayer>();
	protected Mesa mesa = new Mesa();
	protected int ronda;

	/**
	 * Da la bienvenida al juego
	 */
	protected abstract void bienvenida();

	/**
	 * Despliega un menú con las opciones del juego
	 */
	protected abstract void menuPrincipal();

	/**
	 * Pasa de turno al siguiente jugador
	 * @return el turno del otro jugador
	 */
	protected abstract AbstractPlayer nextTurno();

	/**
	 * Emplieza el juego
	 */
	protected abstract void start();

	/**
	 * Baraja la baraja de la mesa.
	 */
	public void barajar() {
		ArrayList<Carta> nueva_lista_c = new ArrayList<Carta>();
		int tamanio = this.mesa.b.lista_cartas.size();

		for (int i = 0; i < tamanio; i++) {
			int aleatorio = (int) (Math.random() * this.mesa.b.lista_cartas.size());
			nueva_lista_c.add(mesa.b.lista_cartas.get(aleatorio));
			this.mesa.b.lista_cartas.remove(aleatorio);
		}

		this.mesa.b.lista_cartas = nueva_lista_c;
	}

	/**
	 * Recoge todas las cartas en la mano de los jugadores
	 */
	public void finish() { // Recorre todos los jugadores y recoge todas sus cartas y las añade a la baraja
		for (int i = 0; i < jugadores.size(); i++) {
			Mano manoj = jugadores.get(i).mano;

			while (manoj.lista_cartas.size() > 0) {
				Carta c = manoj.lista_cartas.get(0);
				this.mesa.b.InsertarCartaPrincipio(c);
				manoj.lista_cartas.remove(c);
			}
		}
	}
}
