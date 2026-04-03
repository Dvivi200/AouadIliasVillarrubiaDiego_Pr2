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
        llistaAccessos.add(acc);
    }

    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

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

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

        for (Acces acces : llistaAccessos) {

            acces.tancarAcces(); // primer tanquem tots

            if (acces.getAAllotjaments().containsAllotjamentOperatiu()) {
                acces.obrirAcces();
            }
        }
    }

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

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {

        float total = 0;

        for (Acces a : llistaAccessos) {
            if (a instanceof AccesTerra) {
                total += ((AccesTerra) a).getLongitud();
            }
        }

        return total;
    }
}