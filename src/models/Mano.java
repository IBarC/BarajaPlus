package models;

import java.util.Scanner;

public class Mano extends Baraja {

	/**
	 * Imprime todas las cartas en la mano
	 */
	public void listarCartas() {
		for (int i = 0; i < lista_cartas.size(); i++) {
			System.out.println(lista_cartas.get(i));
		}
	}

	/**
	 * Lista las cartas y permite elegir una
	 * 
	 * @return la carta elegida
	 */
	public Carta elegirCarta() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < lista_cartas.size(); i++) {
			Carta c = lista_cartas.get(i);
			System.out.print("|| " + i + ". " + c.getNombreCarta() + " || ");
		}
		System.out.println();
		System.out.println("Elige una carta:");
		int ncarta = Integer.parseInt(sc.nextLine());
		Carta x = new Carta(ncarta);
		sc.close();
		return x;
	}
}
