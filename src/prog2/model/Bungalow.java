package prog2.model;

public class Bungalow extends Casa{
    private int placesParking;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    //Constructor
    public Bungalow(String nom, String identificador, long dies_temp_alta, long dies_temp_baixa,
                    boolean estat, String il_luminacio, float mida, int habitacions, int placesPersones,
                    int placesParking, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, identificador, dies_temp_alta, dies_temp_baixa, estat, il_luminacio, mida, habitacions, placesPersones);
        this.placesParking = placesParking;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    //Funcionament correcte si te aire fred
    @Override
    public boolean correcteFuncionament() {
        return isAireFred();
    }

    //toString de la subclasse
    @Override
    public String toString() {
        return super.toString() + "Bungalow{places de Parking=" + placesParking + ", terrassa="
                + terrassa + ", tv=" + tv + ", aire fred=" + aireFred + "}";
    }

    //Getters i setters
    public int getPlacesParking() { return placesParking; }

    public void setPlacesParking(int placesParking) { this.placesParking = placesParking; }

    public boolean isTerrassa() { return terrassa; }

    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }

    public boolean isTv() { return tv; }

    public void setTv(boolean tv) { this.tv = tv; }

    public boolean isAireFred() { return aireFred; }

    public void setAireFred(boolean aireFred) { this.aireFred = aireFred; }


}

