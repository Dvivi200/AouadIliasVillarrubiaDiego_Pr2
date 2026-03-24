package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {

    private ArrayList<Acces> llistaAccessos;

    public LlistaAccessos() {
        llistaAccessos = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (acc == null) throw new ExcepcioCamping("No s'ha pogut afegir cap acces");
        llistaAccessos.add(acc);
    }

    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuffer llista = new StringBuffer();
        for (Acces a : llistaAccessos) {
            if(a.getEstat() == estat) llista.append(a.toString()).append("\n");
        }
        if(llista.isEmpty()) throw new ExcepcioCamping("No hi ha accessos amb l'estat demanat");
        return llista.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int comptador = 0;
        for(Acces acc : llistaAccessos){
            if(!acc.isAccessibilitat()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0;
        for(Acces acc : llistaAccessos){
            if(acc instanceof AccesTerra){
                metres += ((AccesTerra) acc).getLongitud();
            }
        }
        return metres;
    }
}
