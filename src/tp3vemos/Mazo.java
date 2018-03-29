package tp3vemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {

    private List<Carta> mazo;

    public Mazo() {
	super();
	mazo = new ArrayList<>();

	for (int i = 1; i < 13; i++) {
	    mazo.add(new Carta("basto", i));
	    mazo.add(new Carta("oro", i));
	    mazo.add(new Carta("espada", i));
	    mazo.add(new Carta("copa", i));

	    Collections.shuffle(mazo);

	}

    }

    public List<Carta> getMazo() {
	return mazo;
    }

    public void setMazo(List<Carta> mazo) {
	this.mazo = mazo;
    }

    @Override
    public String toString() {
	return "Mazo [mazo=" + mazo + "]";
    }

    public synchronized Carta getCarta() {
	if (!mazo.isEmpty()) {

	    return mazo.remove(mazo.size() - 1);
	} else {
	    return null;
	}
    }
}
