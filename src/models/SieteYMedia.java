package models;

import java.util.ArrayList;

import java.util.Scanner;

public class SieteYMedia extends AbstractGame {
	public Scanner sc = new Scanner(System.in);
	ArrayList<HumanPlayer> jugadores = new ArrayList<HumanPlayer>();
	Mesa mesaNueva = new Mesa();
	Baraja barajaAUsar = mesaNueva.b;
	CPUPlayer cpu = new CPUPlayer("cpu", 0, null, mesaNueva);
	HumanPlayer j1 = new HumanPlayer("j1", 0, null, mesaNueva);
	HumanPlayer j2 = new HumanPlayer("j2", 0, null, mesaNueva);
	boolean jugCPU = false;

	@Override
	protected void bienvenida() {
		System.out.println("----BIENVENIDO AL JUEGO DE LAS 7 Y MEDIA----");
	}

	@Override
	protected void menuPrincipal() {

		barajaAUsar.barajar();

		int tipoJug = 0;
		boolean opVal = true;
		do {
			opVal = true;
			try {
				System.out.println(
						"¿Qué tipo de jugadores habrá?:\n1. Solo jugadores físicos (2 vs 2)\n2. Solo máquina\n3. Jugador físico vs máquina");
				tipoJug = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				opVal = false;
				System.out.println("Introduce una opción válida. ");
			}
			
			if(tipoJug !=1 && tipoJug !=2 && tipoJug !=3) {
				opVal=false;
				System.out.println("Elige una de las opciones de arriba");
			}
			
		} while (!opVal);

		switch (tipoJug) {
		case 1:
			boolean opV=true;
			int nJug = 0;
			do {
				opV=true;
				try {
					System.out.println("¿1 o 2 jugadores?: ");
					nJug = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					opV = false;
					System.out.println("Introduce una opción válida. ");
				}
				if(nJug !=1 && nJug !=2) {
					opVal=false;
					System.out.println("Elige una de las opciones de arriba");
				}
			} while (!opV);

			if (nJug >= 1) {
				jugadores.add(j1);
				j1.mano = new Mano();
			}
			if (nJug == 2) {
				jugadores.add(j2);
				j2.mano = new Mano();
			}
			break;

		case 2:
			cpu.mano = new Mano();
			break;

		case 3:
			jugadores.add(j1);
			j1.mano = new Mano();
			cpu.mano = new Mano();
			this.jugCPU = true;
			break;
		}
	}

	@Override
	protected AbstractPlayer nextTurno() {
		return null;
	}

	@Override
	public void start() {
		bienvenida();
		menuPrincipal();

		if (jugadores.size() == 2) {
			System.out.println("Turno del jugador " + j1.nombre);
			j1.jugarTurno();
			System.out.println("Turno del jugador " + j2.nombre);
			j2.jugarTurno();
			if (j1.puntos > j2.puntos) {
				System.out.println("El ganador es " + j1.nombre);
			} else if (j2.puntos > j1.puntos) {
				System.out.println("El ganador es " + j2.nombre);
			} else {
				System.out.println("Ha habido un empate :o");
			}
		}
		if (jugadores.size() == 1) {
			System.out.println("Turno del jugador " + j1.nombre);
			j1.jugarTurno();
			if (jugCPU) {
				System.out.println("Turno de la cpu");
				cpu.jugarTurno();
			}
			if (j1.puntos > cpu.puntos) {
				System.out.println("El ganador es " + j1.nombre);
			} else if (cpu.puntos > j1.puntos) {
				System.out.println("El ganador es " + cpu.nombre);
			} else {
				System.out.println("Ha habido un empate :o");
			}
		}
		if (jugadores.size()==0) {
			cpu.jugarTurno();
		}
	}

}
