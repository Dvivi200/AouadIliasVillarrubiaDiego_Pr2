package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

// Classe que gestiona una llista d'accessos del càmping
public class LlistaAccessos implements InLlistaAccessos {

    private ArrayList<Acces> llistaAccessos; // Llista que conté tots els accessos

    // Constructor: inicialitza la llista d'accessos
    public LlistaAccessos() {
        llistaAccessos = new ArrayList<>();
    }

    // Afegeix un accés a la llista, llençant excepció si és null
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        llistaAccessos.add(acc);
    }

    // Buida la llista d'accessos
    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

    // Retorna un String amb els accessos que tenen l'estat indicat
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {

        String res = "";

        for (Acces a : llistaAccessos) {
            if (a.getEstat() == estat) {
                res += a.toString() + "\n";
            }
        }

        if (res.isEmpty()) {
            throw new ExcepcioCamping("No hi ha accessos amb aquest estat");
        }

        return res;
    }

    // Actualitza l'estat de tots els accessos segons si tenen allotjaments operatius
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for(Acces a : llistaAccessos) {
            a.tancarAcces(); // Primer es tanca l'accés
            if(a.getAAllotjaments().containsAllotjamentOperatiu()){
                a.obrirAcces(); // S'obre només si hi ha allotjaments operatius
            }
        }
    }

    // Calcula el nombre d'accessos no accessibles
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {

        int count = 0;

        for (Acces a : llistaAccessos) {
            if (!a.isAccessibilitat()) {
                count++;
            }
        }

        return count;
    }

    // Calcula el total de metres de camins de terra
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0;
        for(Acces acc : llistaAccessos){
            if(acc instanceof AccesTerra){ // Només es compten els accessos de terra
                metres += ((AccesTerra) acc).getLongitud();
            }
        }

        return total;
    }
}