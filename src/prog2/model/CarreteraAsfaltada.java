package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {

    private float pes_maxim;

    public CarreteraAsfaltada(String nom, boolean accesibilitat, float asfalt, float pes_maxim) {
        super(nom, accesibilitat, asfalt);
        this.pes_maxim = pes_maxim;
    }

    public float getPes_maxim() {
        return pes_maxim;
    }

    public void setPes_maxim(float pes_maxim) {
        this.pes_maxim = pes_maxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

}