package prog2.model;
import java.io.Serializable;

public class BungalowPremium extends Bungalow implements Serializable {
    private boolean serveisExtra;
    private String codiWifi;

    //Constructor
    public BungalowPremium(String nom, String identificador, long dies_temp_alta, long dies_temp_baixa,
                           boolean estat, String il_luminacio, float mida, int habitacions, int placesPersones,
                           int placesParking, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi) {
        super(nom, identificador, dies_temp_alta, dies_temp_baixa, estat, il_luminacio, mida,
                habitacions, placesPersones, placesParking, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;

    }

    //Funcionament correcte si te aire fred i codiWifi entre 8 i 16 caracters
    @Override
    public boolean correcteFuncionament() {
        return isAireFred() && getCodiWifi().matches("(\\w{8,16})");
    }

    //toString de la subclasse
    @Override
    public String toString() {
        return super.toString() + "Bungalow Premium{serveis Extra=" + serveisExtra + ", Codi Wifi=" + codiWifi + "}. ";
    }

    //Getters i setters
    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }
}

