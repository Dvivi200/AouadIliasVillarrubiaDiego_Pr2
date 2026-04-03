package prog2.model;

public abstract class Acces implements InAcces {

    protected String nom;
    protected boolean estat; // true = obert
    protected LlistaAllotjaments allotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new LlistaAllotjaments();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        try {
            allotjaments.afegirAllotjament(allotjament);
        } catch (Exception e) {
            // no fem res
        }
    }

    @Override
    public void tancarAcces() {
        estat = false;
    }

    @Override
    public void obrirAcces() {
        estat = true;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public boolean getEstat() {
        return estat;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return allotjaments;
    }

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Nom: " + nom +
                ", Obert: " + estat +
                ", Accessibilitat: " + isAccessibilitat();
    }
}