package prog2.model;

public class Parcela extends Allotjament {
    private float metres;
    private boolean connexioElectrica;

    //Constructor
    public Parcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        super(nom_, idAllotjament_);
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    //Getters i setters
    public float getMida() { return metres; }

    public void setMida(float metres) { this.metres = metres; }

    public boolean isConnexioElectrica() { return this.connexioElectrica; }

    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }

    //Funcionament correcte si te connexio elèctrica
    public boolean correcteFuncionament() { return isConnexioElectrica(); }

    //toString de la subclasse
    @Override
    public String toStringGlobal() {
        return super.toString() + " Parcela{mida=" + getMida() +
                ", connexioElectrica=" + isConnexioElectrica() + "}";
    }
}
