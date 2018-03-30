package tp3vemos;

import java.util.Observable;
import java.util.Observer;

public class Repartidor implements Observer {

    private Mazo mazo;

    public Repartidor(Mazo mazo) {
	super();
	this.mazo = mazo;

    }

    @Override
    public synchronized void update(Observable jugador, Object j) {
	try {
	    Thread.sleep(150);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Jugador jugadorNuevo = (Jugador) jugador;

	if (jugadorNuevo.getCarta() != null) {
	    System.out.println("el jugador " + jugadorNuevo.getNombre() + " guarda la " + jugadorNuevo.getCarta());

	} else {
	    System.out.println("error");
	    // System.exit(0);
	}

    }

    public Mazo getMazo() {
	return mazo;
    }

    public void setMazo(Mazo mazo) {
	this.mazo = mazo;
    }

}
