package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String identificador;
    private long dies_temp_baixa;
    private long dies_temp_alta;

    //Constructor per tests
    public Allotjament(String nom, String identificador, long dies_temp_alta, long dies_temp_baixa) {
        this.nom = nom;
        this.identificador = identificador;
        this.dies_temp_alta = dies_temp_alta;
        this.dies_temp_baixa = dies_temp_baixa;

    }

    //Constructor per les subclasses
    public Allotjament(String nom, String idAllotjament) {
        this.nom = nom;
        this.identificador = idAllotjament;
    }

    //Getters i setters
    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getId() { return identificador; }

    public void setId(String id) { this.identificador = id; }

    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA)
            return dies_temp_alta;
        else
            return dies_temp_baixa;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.dies_temp_baixa = estadaMinimaBAIXA_;
        this.dies_temp_alta = estadaMinimaALTA_;
    }

    //toString de la superclasse
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: "
                + getEstadaMinima(Temp.ALTA) + ", estada mínima en temp BAIXA: "
                + getEstadaMinima(Temp.BAIXA) + ".";
    }

    //toString per a les subclasses
    public abstract String toStringGlobal();
    //mètode per a les subclasses
    public abstract boolean correcteFuncionament();




}



