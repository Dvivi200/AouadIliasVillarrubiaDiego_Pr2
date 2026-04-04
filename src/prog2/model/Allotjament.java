package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String identificador;
    private long dies_temp_baixa;
    private long dies_temp_alta;
    private boolean estat;
    private String il_luminacio;


    //Constructor per les subclasses
    public Allotjament(String nom, String idAllotjament, long dies_temp_alta, long dies_temp_baixa, boolean estat, String il_luminacio) {
        this.nom = nom;
        this.identificador = idAllotjament;
        this.dies_temp_alta = dies_temp_alta;
        this.dies_temp_baixa = dies_temp_baixa;
        this.estat = estat;
        this.il_luminacio = il_luminacio;
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

    public boolean isOperatiu() {
        return estat;
    }

    public void setEstat(boolean estat) {this.estat = estat;}

    public void tancarAllotjament(TascaManteniment tasca){
        this.estat = false;
        this.il_luminacio = tasca.getIluminacioAllotjament();
    }

    public void obrirAllotjament(){
        this.estat = true;
        this.il_luminacio = "100%";
    }

    //toString de la superclasse
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: "
                + getEstadaMinima(Temp.ALTA) + ", estada mínima en temp BAIXA: "
                + getEstadaMinima(Temp.BAIXA) + ". ";
    }

    //mètode per a les subclasses
    public abstract boolean correcteFuncionament();

    public String getIluminacio() {
        return il_luminacio;
    }

    public void setIluminacio(String il_luminacio) {
        this.il_luminacio = il_luminacio;
    }

}




