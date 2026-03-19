package prog2.model;

public abstract class AccesAsfalt extends Acces{

    private float asfalt;

    public AccesAsfalt(String nom, boolean accesibilitat, float asfalt) {
        super(nom, accesibilitat);
        this.asfalt = asfalt;
    }

    public float getAsfalt(){
        return asfalt;
    }

    public void setAsfalt(float asfalt){
        this.asfalt = asfalt;
    }
}
