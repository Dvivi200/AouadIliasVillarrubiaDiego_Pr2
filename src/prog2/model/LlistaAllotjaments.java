package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {

    private ArrayList<Allotjament> llista;

    public LlistaAllotjaments() {
        llista = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        for (Allotjament a : llista) {
            if (a.getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Ja existeix un allotjament amb aquest id");
            }
        }

        llista.add(allotjament);
    }

    @Override
    public void buidar() {
        llista.clear();
    }

    @Override
    public String llistarAllotjaments(boolean estat) throws ExcepcioCamping {

        String res = "";

        for (Allotjament a : llista) {
            if (a.isOperatiu() == estat) {
                res += a.toString() + "\n";
            }
        }

        if (res.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb aquest estat");
        }

        return res;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {

        for (Allotjament a : llista) {
            if (a.isOperatiu()) return true;
        }

        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return llista.contains(allotjament);
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {

        for (Allotjament a : llista) {
            if (a.getId().equals(id)) {
                return a;
            }
        }

        throw new ExcepcioCamping("Allotjament no trobat");
    }

    public ArrayList<Allotjament> getLlista() {
        return llista;
    }
}