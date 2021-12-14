package models;

public class Carta {

	private int numero; // numero del 1 al 10 que nos representa el numero de la carta
	private int palo; // numero que nos representa el palo

	/**
	 * Crea una carta
	 * 
	 * @param numero numero de la carta
	 * @param palo   palo de la baraja española
	 */
	public Carta(int numero, int palo) { // Nos crea una carta
		super();
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * Codigo para representar una carta
	 * 
	 * @param id numero entre 1 y 40 si es una baraja simple u 80 si es doble
	 */
	public Carta(int id) {
		super();
		if (id > 0 && id <= 80) {
			if (id == 0) {
				this.numero = 0;
				this.palo = 0;
			} else if (id % 10 == 0) {
				this.numero = 10;
				this.palo = (id / 10) - 1;
			} else {
				this.numero = id % 10;
				this.palo = id / 10;
			}

		} else {
			System.out.println(
					"El numero introducido para la carta no es válido. Tiene que ser entre 1 y 40 si la baraja es simple o 80 si es doble, ambos incluidos.");
		}
	}

	/**
	 * Genera el numero de la carta
	 * 
	 * @return valor del número
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Genera el palo de la carta
	 * 
	 * @return valor del palo 0-3
	 */
	public int getPalo() {
		return palo;
	}

	/**
	 * Crea el Id de la carta
	 * 
	 * @return valor del id de la carta
	 */
	public int getId() {
		int id = this.palo * 10 + this.numero;
		return id;
	}

	/**
	 * Genera un string con el nombre del número
	 * 
	 * @return nombre del número
	 */
	public String getNombreNumero() {
		String nombreNum = "";

		switch (this.numero) {
		case 1:
			nombreNum = "as";
			break;
		case 2:
			nombreNum = "dos";
			break;
		case 3:
			nombreNum = "tres";
			break;
		case 4:
			nombreNum = "cuatro";
			break;
		case 5:
			nombreNum = "cinco";
			break;
		case 6:
			nombreNum = "seis";
			break;
		case 7:
			nombreNum = "siete";
			break;
		case 8:
			nombreNum = "sota";
			break;
		case 9:
			nombreNum = "caballo";
			break;
		case 10:
			nombreNum = "rey";
			break;
		case 0:
			nombreNum = "rey";
			break;
		}
		return nombreNum;
	}

	/**
	 * Genera un string con el palo de la carta
	 * 
	 * @return nombre del palo
	 */
	public String getNombrePalo() {
		String nombrePalo = "";

		switch (this.palo) {
		case 0:
			nombrePalo = "oros";
			break;
		case 1:
			nombrePalo = "espadas";
			break;
		case 2:
			nombrePalo = "copas";
			break;
		case 3:
			nombrePalo = "bastos";
			break;
		}
		return nombrePalo;
	}

	/**
	 * Genera un string con el nombre completo de la carta
	 * 
	 * @return nombre de la carta
	 */
	public String getNombreCarta() {
		String nombreCarta = getNombreNumero() + " de " + getNombrePalo();
		return nombreCarta;
	}

	/**
	 * Genera el valor de las cartas en el juego del tute
	 * 
	 * @return el valor de la carta
	 */
	public int getValorTute() {
		int valorTute = 0;
		switch (this.numero) {
		case 1:
			valorTute = 11;
			break;
		case 3:
			valorTute = 10;
			break;
		case 8:
			valorTute = 2;
			break;
		case 9:
			valorTute = 3;
			break;
		case 10:
			valorTute = 4;
			break;
		}
		return valorTute;
	}

	/**
	 * Genera el valor de las cartas en el juego Mus
	 * 
	 * @return el valor de la carta
	 */
	public int getValorMus() {
		int valorMus = this.numero;
		if (this.numero == 1 || this.numero == 2) {
			valorMus = 1;
		} else if (this.numero == 3 || this.numero == 8 || this.numero == 9 || this.numero == 10) {
			valorMus = 10;
		}
		return valorMus;
	}

	/**
	 * Genera el valor de las cartas en el juego 7 y media
	 * 
	 * @return el valor de la carta
	 */
	public double getValor7ymedia() {
		double valor = this.numero;
		if (this.numero == 8 || this.numero == 9 || this.numero == 10) {
			valor = 0.5;
		}
		return valor;
	}
}
