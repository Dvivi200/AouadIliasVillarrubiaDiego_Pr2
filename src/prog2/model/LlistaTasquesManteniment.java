package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

// Classe que gestiona la llista de tasques de manteniment del càmping
public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> llistaTasquesManteniment; // Llista que conté totes les tasques de manteniment

    // Constructor: inicialitza la llista de tasques
    public LlistaTasquesManteniment(){
        llistaTasquesManteniment = new ArrayList<>();
    }

    // Afegeix una nova tasca de manteniment a la llista
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        TascaManteniment tasca = new TascaManteniment(
                num,
                TascaManteniment.TipusTascaManteniment.valueOf(tipus),
                allotjament,
                data,
                dies
        );
        llistaTasquesManteniment.add(tasca);
    }

    // Marca una tasca com completada: la elimina de la llista i obre l'allotjament associat
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        llistaTasquesManteniment.remove(tasca);
        tasca.getAllotjament().obrirAllotjament(); // Allotjament torna a estar operatiu
    }

    // Retorna un String amb totes les tasques de manteniment
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        StringBuffer llista = new StringBuffer();
        for (TascaManteniment a : llistaTasquesManteniment) {
            llista.append(a.toString()).append("\n");
        }
        return llista.toString();
    }

    // Cerca i retorna una tasca segons el seu número, llençant excepció si no existeix
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