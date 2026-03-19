package prog2.model;

public class CamiAsfalt extends AccesAsfalt {

    public CamiAsfalt(String nom, boolean accesibilitat, float asfalt) {
        super(nom, accesibilitat, asfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
