package prog2.model;
import java.io.Serializable;

public abstract class AccesTerra extends Acces implements Serializable {

    private float longitud; // Longitud del camí de terra de l'accés

    // Constructor: inicialitza nom, estat i longitud del camí
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    // Afegeix la informació de la longitud a la representació en String del superclasse
    @Override
    public String toString() {
        return super.toString() + ", Longitud: " + getLongitud();
    }
}