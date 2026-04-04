package prog2.model;
import java.io.Serializable;

// Classe concreta que representa un camí asfaltat dins del càmping
public class CamiAsfaltat extends AccesAsfalt implements Serializable {

    // Constructor: inicialitza nom, estat i quantitat d'asfalt
    public CamiAsfaltat(String nom, boolean estat, float asfalt) {
        super(nom, estat, asfalt);
    }

    // Implementació concreta del mètode abstracte: aquest tipus de camí no és accessible
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}