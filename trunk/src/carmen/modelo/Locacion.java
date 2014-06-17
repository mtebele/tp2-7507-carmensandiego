package carmen.modelo;

import java.util.List;
import java.util.ArrayList;

public class Locacion {

	private Mapa mapa;
	private Ladron ladron;
	private Ciudad ciudadActual;
	private List<Ciudad> ciudadesDestino;

	public Locacion(Mapa mapa, Ciudad ciudadActual, Ladron ladron) {
		this.mapa = mapa;
		this.ladron = ladron;							
		this.ciudadActual = ciudadActual;
		this.ciudadesDestino = new ArrayList<Ciudad>();
	}


	private void generarNuevosDestinos() {
		
		this.ciudadesDestino.clear();
		this.agregarDestino(this.ladron.ciudadActual());
		
		for (int i=0; i<3; i++) {
			Ciudad destino = this.mapa.elegirCiudadAlAzar();
			while ( this.ciudadesDestino.contains(destino) ) {
				destino = this.mapa.elegirCiudadAlAzar();
			}
			this.agregarDestino(destino);
		}

	}
	
	public void viajar(Ciudad destino) {
		
		Ciudad partida = this.ciudadActual;
		this.ciudadActual = destino;
		
		if ( this.estaLadron() ) {
			try {
				this.ladron.escapar();
			} catch (LadronNoHaRobadoException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			this.generarNuevosDestinos();
		} else {
			this.ciudadesDestino.remove(destino);
			this.agregarDestino(partida);
		}
		
	}

	public String interrogar(Local local) {

		if ( this.pasoLadronRecientemente() ) {
			return local.responder();
		}
		return "Lo siento, nunca he visto a esa persona.";
	}

	public void agregarDestino(Ciudad destino) {
		this.ciudadesDestino.add(destino);
	}

	public Ciudad ciudadActual() {
		return this.ciudadActual;
	}

	public boolean pasoLadronRecientemente() {
		return ( this.ladron.ciudadAnterior().equals(this.ciudadActual) );
	}

	public boolean estaLadron() {
		return ( this.ladron.ciudadActual().equals(this.ciudadActual) );
	}
	
	public List<Local> getLocales() {
		return this.ciudadActual.getLocales();
	}
	
	public List<Ciudad> getDestinos() {
		return this.ciudadesDestino;
	}
	
}