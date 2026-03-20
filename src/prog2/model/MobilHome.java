package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;

    //Constructor
    public MobilHome(String nom_, String idAllotjament_, long dies_temp_alta, long dies_temp_baixa,
                     boolean estat, String il_luminacio, String mida, int habitacions,
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
    public String toStringGlobal() {
        return super.toStringCasa() + "Mobil-Home{Terrassa amb barbacoa=" + terrassaBarbacoa + "}";
    }

    //Getters i setters
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }
}

