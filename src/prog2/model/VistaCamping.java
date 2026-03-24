package prog2.model;

public class VistaCamping {
    private String nom;
    private Camping camping;

    public VistaCamping(String nom) {
        this.nom = nom;
        camping = new Camping();
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {

    }
}
