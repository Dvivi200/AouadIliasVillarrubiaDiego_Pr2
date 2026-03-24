package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments{

    private ArrayList<Allotjament> llistaAllotjaments;

    LlistaAllotjaments(){
        llistaAllotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) throw new ExcepcioCamping("No s'ha pogut afegir cap allotjament");
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(boolean estat) throws ExcepcioCamping {
        StringBuffer llista = new StringBuffer();
        for (Allotjament a : llistaAllotjaments) {
            if(a.isOperatiu() == estat) llista.append(a.toString()).append("\n");
        }
        if(llista.isEmpty()) throw new ExcepcioCamping("No hi ha allotjaments amb l'estat demanat");
        return llista.toString();
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        boolean op = false;

        for(int i = 0; i < llistaAllotjaments.size() && !op; i++){
            if(llistaAllotjaments.get(i).isOperatiu())
                op = true;
        }

        return op;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for(Allotjament all : llistaAllotjaments){
            if(all.equals(allotjament))
                return true;
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for(Allotjament allotjament : llistaAllotjaments){
            if(allotjament.getId().equals(id))
                return allotjament;
        }
        throw new ExcepcioCamping("Allotjament no trobat");
    }
}
