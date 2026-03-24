package prog2.model;

public class VistaCamping {
    private String nom;
    private Camping camping;

    public VistaCamping(String nom) {
        this.nom = nom;
        this.camping = new Camping(nom);
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {

    }
}
