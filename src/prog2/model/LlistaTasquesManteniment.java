package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    public LlistaTasquesManteniment(){
        llistaTasquesManteniment = new ArrayList<>();
    }
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        TascaManteniment tasca = new TascaManteniment(num, TascaManteniment.TipusTascaManteniment.valueOf(tipus), allotjament, data, dies);
        llistaTasquesManteniment.add(tasca);
        tasca.getAllotjament().tancarAllotjament(tasca);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        llistaTasquesManteniment.remove(tasca);
        tasca.getAllotjament().obrirAllotjament();
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        StringBuffer llista = new StringBuffer();
        for (TascaManteniment a : llistaTasquesManteniment) {
            llista.append(a.toString()).append("\n");
        }
        if(llista.isEmpty()) throw new ExcepcioCamping("Actualment no hi han tasques de manteniment actives.");
        return llista.toString();
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for(TascaManteniment tasca : llistaTasquesManteniment){
            if(tasca.getNum() == num){
                return tasca;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat cap tasca amb aquest identificador.");
    }
}
