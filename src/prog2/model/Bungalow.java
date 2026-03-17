package prog2.model;

public class Bungalow extends Casa{
    private int placesParking;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    //Constructor
    public Bungalow(String nom, String identificador, String mida, int habitacions, int placesPersones, int placesParking, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, identificador, mida, habitacions, placesPersones);
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
    public String toStringGlobal() {
        return super.toStringCasa() + "Bungalow{places de Parking=" + placesParking + ", terrassa="
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

