package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

// Classe que gestiona una llista d'allotjaments dins del càmping
public class LlistaAllotjaments implements InLlistaAllotjaments {

    private ArrayList<Allotjament> llistaAllotjaments; // Llista que conté tots els allotjaments

    // Constructor: inicialitza la llista d'allotjaments
    LlistaAllotjaments(){
        llistaAllotjaments = new ArrayList<>();
    }

    // Afegeix un allotjament a la llista, llençant excepció si és null
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) throw new ExcepcioCamping("No s'ha pogut afegir cap allotjament");
        llistaAllotjaments.add(allotjament);
    }

    // Buida la llista d'allotjaments
    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    // Retorna un String amb els allotjaments que tenen l'estat indicat
    @Override
    public String llistarAllotjaments(boolean estat) throws ExcepcioCamping {
        StringBuffer llista = new StringBuffer();
        for (Allotjament a : llistaAllotjaments) {
            if(a.isOperatiu() == estat) llista.append(a.toString()).append("\n");
        }
        if(llista.isEmpty()) throw new ExcepcioCamping("No hi ha allotjaments amb l'estat demanat");
        return llista.toString();
    }

    // Comprova si hi ha almenys un allotjament operatiu
    @Override
    public boolean containsAllotjamentOperatiu() {
        boolean op = false;

        for(int i = 0; i < llistaAllotjaments.size() && !op; i++){
            if(llistaAllotjaments.get(i).isOperatiu())
                op = true;
        }

        return op;
    }

    // Comprova si la llista conté un allotjament concret
    @Override
    public boolean contains(Allotjament allotjament) {
        for(Allotjament all : llistaAllotjaments){
            if(all.equals(allotjament))
                return true;
        }
        return false;
    }

    // Retorna un allotjament segons el seu id, llençant excepció si no es troba
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for(Allotjament allotjament : llistaAllotjaments){
            if(allotjament.getId().equals(id))
                return allotjament;
        }
        throw new ExcepcioCamping("Allotjament no trobat");
    }
}