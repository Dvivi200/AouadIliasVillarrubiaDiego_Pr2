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
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        boolean op = false;
        int i = 0;

        while(!op){
            if(llistaAllotjaments.get(i).isOperatiu())
                op = true;
            else
                i++;
        }
        return op;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
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
