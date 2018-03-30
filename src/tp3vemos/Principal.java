package tp3vemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

    public static void main(String[] args) {

	Mazo mazo = new Mazo();
	Repartidor r = new Repartidor(mazo);

	Jugador j1 = new Jugador("Franco", r);
	Jugador j2 = new Jugador("Leandro", r);
	Jugador j3 = new Jugador("Nico", r);
	Jugador j4 = new Jugador("Riquelme", r);
	j1.addObserver(r);
	j2.addObserver(r);
	j3.addObserver(r);
	j4.addObserver(r);

	Thread t = new Thread(j1);
	t.start();
	Thread t1 = new Thread(j2);
	t1.start();
	Thread t2 = new Thread(j3);
	t2.start();
	Thread t3 = new Thread(j4);
	t3.start();

	ArrayList<Jugador> j = new ArrayList<>();
	j.add(j1);
	j.add(j2);
	j.add(j3);
	j.add(j4);

	try {
	    t.join();
	    t1.join();
	    t2.join();
	    t3.join();
	    resultados(j);
	    Jugador ganador = ganador(j);
	    System.out.println(ganador.mostrarGanador());
	    cargarGanador(ganador.getNombre(), ganador.getVal());
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void resultados(ArrayList<Jugador> j) {

	for (Iterator iterator = j.iterator(); iterator.hasNext();) {
	    Jugador jugador = (Jugador) iterator.next();
	    System.out.println("jugador " + jugador.getNombre() + " tiene " + jugador.getVal());

	}

    }

    public static Jugador ganador(ArrayList<Jugador> j) {

	int max = 0;
	String nombre = null;
	Jugador gana = new Jugador(nombre, max);
	for (int i = 0; i < j.size(); i++) {
	    if (j.get(i).getVal() > max) {
		max = j.get(i).getVal();
		nombre = j.get(i).getNombre();
	    }
	}
	gana.setNombre(nombre);
	gana.setVal(max);

	return gana;
    }

    public static void cargarGanador(String nombre, int puntos) {
	try {
	    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "");
	    PreparedStatement stmt = miConexion
		    .prepareStatement("INSERT INTO ganadores(nombre, puntaje) VALUES (?, ?)");

	    stmt.setString(1, nombre);
	    stmt.setLong(2, puntos);

	    stmt.executeUpdate();
	    // Statement statement = miConexion.createStatement();

	    // ResultSet miResultset = statement.executeQuery("INSERT INTO
	    // ganadores (nombre, puntaje) VALUES (?, ?");
	    // INSERT INTO ganadores (nombre, puntaje) VALUES ('Cardinal', 4006"
	    // SELECT * FROM GANADORES
	    // while (miResultset.next()) {
	    // System.out.println(miResultset.getString("nombre") + " " +
	    // miResultset.getString("puntaje"));
	    // }
	} catch (SQLException e1) {
	    System.out.println("No hay conexion");
	    e1.printStackTrace();
	}
    }

}
