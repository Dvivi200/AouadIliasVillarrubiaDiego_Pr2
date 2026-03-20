package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    //Constructor
    public Glamping(String nom_, String idAllotjament_, long dies_temp_alta, long dies_temp_baixa,
                    boolean estat, String il_luminacio, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom_, idAllotjament_, dies_temp_alta, dies_temp_baixa, estat, il_luminacio, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;

    }

    //Funcionament correcte si te casa per mascota
    @Override
    public boolean correcteFuncionament() {
        return isCasaMascota();
    }

    //toString de la subclasse
    @Override
    public String toStringGlobal() {
        return super.toStringCasa() + "Glamping{Material=" + material + ", casa per mascota=" + casaMascota + "}";
    }

    //Getters i setters
    public String getMaterial() { return material; }

    public void setMaterial(String material) { this.material = material; }

    public boolean isCasaMascota() { return casaMascota; }

    public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }
}

