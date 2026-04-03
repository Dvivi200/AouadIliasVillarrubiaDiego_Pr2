package prog2.model;

// Classe que representa una tasca de manteniment d'un allotjament
public class TascaManteniment implements InTascaManteniment {

    private int num; // Identificador únic de la tasca
    private Allotjament allotjament; // Allotjament associat a la tasca
    private String data; // Data d'inici de la tasca
    private TipusTascaManteniment tipus; // Tipus de tasca
    private int dies; // Durada de la tasca en dies

    // Constructor: inicialitza tots els atributs de la tasca
    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies){
        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    // Enum amb els tipus de tasques possibles
    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };

    // Getters i setters dels atributs
    @Override
    public int getNum() {
        return num;
    }

    @Override
    public TipusTascaManteniment getTipus() {
        return tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    @Override
    public void setNum(int num_) {
        this.num = num_;
    }

    @Override
    public void setTipus(TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setData(String data_) {
        this.data = data_;
    }

    @Override
    public void setDies(int dies_) {
        this.dies = dies_;
    }

    // Representació en String de la tasca de manteniment
    public String toString(){
        return "Numero de tasca: " + num + ", tipus de tasca: " + tipus + ", allotjament de la tasca: " +
                allotjament + ", data: " + data + ", durada de la tasca: " + dies + ". ";
    }

    // Retorna la il·luminació de l'allotjament associat a la tasca
    @Override
    public String getIluminacioAllotjament() {
        return allotjament.getIluminacio();
    }
}