package main;

import java.util.Scanner;

import models.SieteYMedia;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige a que juego quieres jugar: ");
		int juego = 0;

		do {
			try {
				System.out.println("1. Siete y media");
				juego = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Introduce una opción válida. ");
			}
		} while (juego != 1);
		
		switch (juego) {
		case 1:
			SieteYMedia nuevoJuego = new SieteYMedia();
			nuevoJuego.start();

		}
		sc.close();
	}

}
