package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {

    public CamiAsfaltat(String nom, boolean estat, float asfalt) {
        super(nom, estat, asfalt);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
