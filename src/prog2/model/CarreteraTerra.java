package prog2.model;

// Classe concreta que representa una carretera de terra dins del càmping
public class CarreteraTerra extends AccesTerra {

    private float amplada; // Amplada de la carretera de terra

    // Constructor: inicialitza nom, estat, longitud i amplada de la carretera
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    // Implementació concreta del mètode abstracte: aquesta carretera sí que és accessible
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    // Afegeix l'amplada a la representació en String del superclasse
    @Override
    public String toString() {
        return super.toString() + ", Amplada: " + this.amplada;
    }
}
