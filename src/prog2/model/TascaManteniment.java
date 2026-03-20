package prog2.model;

public class TascaManteniment implements InTascaManteniment {

    private int num;
    private Allotjament allotjament;
    private String data;
    private TipusTascaManteniment tipus;
    private int dies;

    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies){
        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
    @Override
    public int getNum() {
        return num;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
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
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
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

    public String toString(){
        return "";
    }

    @Override
    public String getIluminacioAllotjament() {
        return allotjament.getIluminacio();
    }
}
