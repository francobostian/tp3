package tp3vemos;

import java.util.Observable;

public class Jugador extends Observable implements Runnable {

    private String nombre;
    private Carta carta;
    private Repartidor repartidor;
    private int val;

    public Jugador(String nombre, Carta carta) {
	super();
	this.nombre = nombre;
	this.carta = carta;
    }

    public Jugador(String nombre, Repartidor repartidor) {
	super();
	this.nombre = nombre;
	this.repartidor = repartidor;
    }

    public Jugador(String nombre) {
	super();
	this.nombre = nombre;
    }

    public Jugador(String nombre, int val) {
	super();
	this.nombre = nombre;
	this.val = val;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public Carta getCarta() {
	return carta;
    }

    public void setCarta(Carta carta) {

	this.carta = carta;

    }

    public int getVal() {
	return val;
    }

    public void setVal(int val) {
	this.val = val;
    }

    @Override
    public void run() {

	while (!repartidor.getMazo().getMazo().isEmpty()) {

	    val = val + 0;

	    setCarta(repartidor.getMazo().getCarta());
	    this.val++;
	    this.setChanged();
	    this.notifyObservers();

	    try {

		Thread.sleep(150);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

	// repartidor.getPuntos(nombre, val);
	// repartidor.getGanador(nombre, val);
    }

    public String mostrarGanador() {
	return "El ganador es: " + nombre + "! con " + val + " puntos";
    }

}
