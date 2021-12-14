package models;

import java.util.ArrayList;

public class Baraja {

	protected ArrayList<Carta> lista_cartas = new ArrayList<Carta>();

	/**
	 * Crea una baraja vacía
	 */
	public Baraja() {
		super();
	}

	/**
	 * Crea una baraja a partir del tipo que la queremos (sencilla o doble)
	 * 
	 * @param tipobaraja
	 */
	public Baraja(int tipobaraja) {
		super();

		if (tipobaraja == 1) {
			for (int i = 0; i < 40; i++) {
				this.lista_cartas.add(new Carta(i + 1));
			}
		} else {
			for (int i = 0; i < 80; i++) {
				this.lista_cartas.add(new Carta(i + 1));
			}
		}
	}

	/**
	 * Crea una baraja a partir del tipo que la queremos (simple o doble) y la
	 * baraja si queremos
	 * 
	 * @param tipobaraja int
	 * @param barajar    booleano
	 */
	public Baraja(int tipobaraja, boolean barajar) {
		super();

		if (tipobaraja == 1) {
			for (int i = 0; i < 40; i++) {
				lista_cartas.add(new Carta(i + 1));
			}
		} else if (tipobaraja == 2) {
			for (int i = 0; i < 80; i++) {
				lista_cartas.add(new Carta(i + 1));
			}
		}

		if (barajar) {
			barajar();
		}
	}

	/**
	 * Devuelve la lista de cartas
	 * 
	 * @return
	 */
	public ArrayList<Carta> getLista_cartas() {
		return lista_cartas;
	}

	/**
	 * Baraja las cartas dentro de la barja
	 * 
	 * @return la baraja barajada
	 */
	public ArrayList<Carta> barajar() {
		ArrayList<Carta> nueva_lista_c = new ArrayList<Carta>();
		int tamanio = lista_cartas.size();

		for (int i = 0; i < tamanio; i++) {
			int aleatorio = (int) (Math.random() * this.lista_cartas.size());
			nueva_lista_c.add(this.lista_cartas.remove(aleatorio));
		}

		this.lista_cartas = nueva_lista_c;

		return lista_cartas;
	}

	/**
	 * Corta la baraja por donde se indique
	 * 
	 * @param posicion
	 * @return la carta que se ve si se corta
	 */
	public String cortar(int posicion) {
		String cartacortada = lista_cartas.get(posicion).getNombreCarta();
		return cartacortada;
	}

	/**
	 * Quita una carta aleatoria de la baraja
	 * 
	 * @return la carta robada
	 */
	public Carta robar() {
		int aleatorio = (int) (Math.random() * lista_cartas.size());
		Carta robada = lista_cartas.get(aleatorio);
		return robada;
	}

	/**
	 * Añade una carta al final de la baraja
	 * 
	 * @param id_carta
	 */
	public void InsertarCartaFinal(int id_carta) {
		this.lista_cartas.add(lista_cartas.get(id_carta));
	}

	/**
	 * Añade una carta al principio de la baraja
	 * 
	 * @param id_carta
	 */
	public void InsertarCartaPrincipio(int id_carta) {
		for (int i = 1; i < lista_cartas.size(); i++) {
			Carta c = lista_cartas.get(i);
			lista_cartas.set(i + 1, c);
		}
		lista_cartas.add(0, lista_cartas.get(id_carta));
	}

	/**
	 * Inserta una carta dada al final de la baraja
	 * 
	 * @param c
	 */
	public void InsertaCartaFinal(Carta c) {
		this.lista_cartas.add(c);
	}

	/**
	 * Inserta una carta dada al principio de la baraja
	 * 
	 * @param c
	 */
	public void InsertarCartaPrincipio(Carta c) {
		for (int i = 1; i < lista_cartas.size(); i++) {
			Carta a = lista_cartas.get(i);
			lista_cartas.set(i + 1, a);
		}
		lista_cartas.add(0, c);
	}

	/**
	 * Devuelve el número de cartas que tiene la baraja
	 * 
	 * @return
	 */
	public int getNumeroCartas() {
		int nCartas = lista_cartas.size();
		return nCartas;
	}

	/**
	 * Indica si la baraja esta vacia o tiene cartas
	 * 
	 * @return true si no tiene cartas
	 */
	public boolean isVacia() {
		boolean vacia;
		if (lista_cartas.size() == 0) {
			vacia = true;
		} else {
			vacia = false;
		}
		return vacia;
	}
}
