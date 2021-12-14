package models;

public abstract class AbstractPlayer {
	
	protected String nombre;
	protected double puntos;
	public Mano mano = new Mano();
	protected Mesa mesa = new Mesa();
	
	public AbstractPlayer(String nombre, double puntos, Mano mano, Mesa mesa) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.mano = mano;
		this.mesa = mesa;
	}
	
	/**
	 * Juega el turno de un jugadors
	 */
	abstract void jugarTurno();
}
