package prog2.model;

public abstract class AccesAsfalt extends Acces{

    private float asfalt; // Quantitat d'asfalt de l'accés (per exemple metres quadrats o gruix)

    // Constructor: inicialitza nom, estat i la quantitat d'asfalt
    public AccesAsfalt(String nom, boolean estat, float asfalt) {
        super(nom, estat);
        this.asfalt = asfalt;
    }

    public float getAsfalt(){
        return asfalt;
    }

    public void setAsfalt(float asfalt){
        this.asfalt = asfalt;
    }

    // Afegeix la informació de l'asfalt a la representació en String del superclasse
    @Override
    public String toString() {
        return super.toString() + ", Asfalt: " + getAsfalt();
    }

}
