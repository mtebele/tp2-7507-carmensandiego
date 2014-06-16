package carmen.modelo;
import  java.lang.Math;


public class Coordenada {
	// hay que determinar la unidad de posicion que usamos.
	private double longitud;
	private double latitud;
	static final double RADIOTERRESTRE= 6371;

	public Coordenada(double longitud, double latitud) {
		this.longitud = longitud;
		this.latitud = latitud;
	}

	double getLongitud() {
		return longitud;
	}

	

	
	double getLatitud() {
		return latitud;
	}



	int distanciaAOtraCoordenada(Coordenada otraCoord) {  
		double deltaLat = Math.toRadians(otraCoord.getLatitud()-this.getLatitud());  
        double deltaLong = Math.toRadians(otraCoord.getLongitud() -this.getLongitud());  
        double senodeltaLat = Math.sin(deltaLat / 2);  
        double senodeltaLong = Math.sin(deltaLong / 2);  
        double raiz = Math.pow(senodeltaLat, 2) + Math.pow(senodeltaLong, 2) * Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(otraCoord.getLatitud()));  
        double resul = 2 * Math.atan2(Math.sqrt(raiz), Math.sqrt(1 - raiz));  
        double distancia = RADIOTERRESTRE * resul;  
  
        return (int) distancia;
	
	}

	// la formula es esa, estoy casteando a int porque devuelven un double esos operandos, no creo que haya problema en la conversion
	// Lucas: adhiero, que el tiempo se mida en horas.
}
