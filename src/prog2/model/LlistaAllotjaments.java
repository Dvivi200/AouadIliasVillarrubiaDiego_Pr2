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

        for (Allotjament a : llistaAllotjaments) {
            if (a.getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Ja existeix un allotjament amb aquest id");
            }
        }

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

        String res = "";

        for (Allotjament a : llistaAllotjaments) {
            if (a.isOperatiu() == estat) {
                res += a.toString() + "\n";
            }
        }

        if (res.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb aquest estat");
        }

        return res;
    }

    // Comprova si hi ha almenys un allotjament operatiu
    @Override
    public boolean containsAllotjamentOperatiu() {

        for (Allotjament a : llistaAllotjaments) {
            if (a.isOperatiu()) return true;
        }

        return false;
    }

    // Comprova si la llista conté un allotjament concret
    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }

    // Retorna un allotjament segons el seu id, llençant excepció si no es troba
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {

        for (Allotjament a : llistaAllotjaments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }

        throw new ExcepcioCamping("Allotjament no trobat");
    }
}