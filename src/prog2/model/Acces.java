package prog2.model;

public abstract class Acces implements InAcces {
    private String nom;
    private String accesibilitat;
    private boolean estat;
    private llistaAllotjaments llistaAllotjaments;

    public Acces(String nom, String accesibilitat) {
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = true;
    }
}
