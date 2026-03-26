package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.accesibilitat = isAccessibilitat();
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    public String getNom(){
        return nom;
    }

    public abstract boolean isAccessibilitat();

    public boolean getEstat(){
        return estat;
    }

    public LlistaAllotjaments getAAllotjaments(){
        return llistaAllotjaments;
    }

    public void tancarAcces(){
        accesibilitat = false;
    }

    public void obrirAcces(){
        accesibilitat = true;
    }

    public void afegirAllotjament(Allotjament allotjament){
        try {
            llistaAllotjaments.afegirAllotjament(allotjament);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return "Nom: " + nom + ", Accesible: " + accesibilitat + ", Estat: " + estat;
    }

}
