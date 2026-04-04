package prog2.model;
import java.io.Serializable;

public class MobilHome extends Casa implements Serializable {
    private boolean terrassaBarbacoa;

    //Constructor
    public MobilHome(String nom_, String idAllotjament_, long dies_temp_alta, long dies_temp_baixa,
                     boolean estat, String il_luminacio, float mida, int habitacions,
                     int placesPersones, boolean terrassaBarbacoa) {
        super(nom_, idAllotjament_, dies_temp_alta, dies_temp_baixa, estat, il_luminacio, mida, habitacions,placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    //Funcionament correcte si te terrassa amb barbacoa
    @Override
    public boolean correcteFuncionament() {
        return isTerrassaBarbacoa();
    }

    //toString de la subclasse
    @Override
    public String toString() {
        return super.toString() + "Mobil-Home{Terrassa amb barbacoa=" + terrassaBarbacoa + "}";
    }

    //Getters i setters
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }
}

