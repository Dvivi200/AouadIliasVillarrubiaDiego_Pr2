package prog2.model;

import prog2.vista.ExcepcioCamping;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accesibilitat; // Indica si l'accés és accessible (definit a les subclases)
    private boolean estat; // Estat actual de l'accés: obert (true) o tancat (false)
    private LlistaAllotjaments llistaAllotjaments; // Llista d'allotjaments associats a aquest accés

    // Constructor principal: inicialitza nom, estat i la llista d'allotjaments
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.accesibilitat = isAccessibilitat(); // Valor definit per la subclasse concreta
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    // Mètode abstracte: cada subclasse defineix si és accessible
    public abstract boolean isAccessibilitat();

    public boolean getEstat(){
        return estat;
    }

    // Retorna la llista d'allotjaments associats
    public LlistaAllotjaments getAAllotjaments(){
        return llistaAllotjaments;
    }

    // Canvia l'estat de l'accés a tancat
    public void tancarAcces(){
        estat = false;
    }

    // Canvia l'estat de l'accés a obert
    public void obrirAcces(){
        estat = true;
    }

    // Afegeix un allotjament a la llista i captura possibles excepcions
    public void afegirAllotjament(Allotjament allotjament){
        try {
            llistaAllotjaments.afegirAllotjament(allotjament);
        } catch (ExcepcioCamping e) {

        }
    }

    // Representació en String de l'objecte Acces
    public String toString(){
        return "Nom: " + nom + ", Accesible: " + accesibilitat + ", Estat: " + estat;
    }

    @Override
    public String getNom() {
        return nom;
    }
}