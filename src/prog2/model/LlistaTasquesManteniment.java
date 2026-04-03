package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> llista;

    public LlistaTasquesManteniment() {
        llista = new ArrayList<>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        for (TascaManteniment t : llista) {
            if (t.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("Ja existeix una tasca per aquest allotjament");
            }
        }

        TascaManteniment t = new TascaManteniment(num, tipus, allotjament, data, dies);

        allotjament.tancarAllotjament(t);

        llista.add(t);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

        if (!llista.contains(tasca)) {
            throw new ExcepcioCamping("Tasca no trobada");
        }

        tasca.getAllotjament().obrirAllotjament();

        llista.remove(tasca);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {

        if (llista.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques");
        }

        String res = "";
        for (TascaManteniment t : llista) {
            res += t.toString() + "\n";
        }

        return res;
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {

        for (TascaManteniment t : llista) {
            if (t.getNum() == num) return t;
        }

        throw new ExcepcioCamping("Tasca no trobada");
    }
}