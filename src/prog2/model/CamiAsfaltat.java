package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {

    public CamiAsfaltat(String nom, boolean accesibilitat, float asfalt) {
        super(nom, accesibilitat, asfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
