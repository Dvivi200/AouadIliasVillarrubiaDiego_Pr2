package prog2.model;

// Classe concreta que representa una carretera asfaltada dins del càmping
public class CarreteraAsfaltada extends AccesAsfalt {

    private float pes_maxim; // Pes màxim suportat per la carretera (per vehicles)

    // Constructor: inicialitza nom, estat, asfalt i pes màxim
    public CarreteraAsfaltada(String nom, boolean estat, float asfalt, float pes_maxim) {
        super(nom, estat, asfalt);
        this.pes_maxim = pes_maxim;
    }

    public float getPes_maxim() {
        return pes_maxim;
    }

    public void setPes_maxim(float pes_maxim) {
        this.pes_maxim = pes_maxim;
    }

    // Implementació concreta del mètode abstracte: aquesta carretera sí que és accessible
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    // Afegeix el pes màxim a la representació en String del superclasse
    @Override
    public String toString() {
        return super.toString() + ", Pes màxim: " + this.pes_maxim;
    }

}