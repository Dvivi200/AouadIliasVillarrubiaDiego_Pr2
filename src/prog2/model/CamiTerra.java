package prog2.model;
import java.io.Serializable;

// Classe concreta que representa un camí de terra dins del càmping
public class CamiTerra extends AccesTerra implements Serializable {

    // Constructor: inicialitza nom, estat i longitud del camí
    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
    }

    // Implementació concreta del mètode abstracte: aquest camí no és accessible
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}