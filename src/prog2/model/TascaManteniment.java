package prog2.model;

public class TascaManteniment implements InTascaManteniment {

    public enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }

    private int num;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;

    public TascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) {
        this.num = num;
        this.tipus = TipusTascaManteniment.valueOf(tipus);
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    @Override public int getNum() { return num; }
    @Override public TipusTascaManteniment getTipus() { return tipus; }
    @Override public Allotjament getAllotjament() { return allotjament; }
    @Override public String getData() { return data; }
    @Override public int getDies() { return dies; }

    @Override public void setNum(int num_) { num = num_; }
    @Override public void setTipus(TipusTascaManteniment tipus_) { tipus = tipus_; }
    @Override public void setAllotjament(Allotjament a) { allotjament = a; }
    @Override public void setData(String d) { data = d; }
    @Override public void setDies(int d) { dies = d; }

    @Override
    public String getIluminacioAllotjament() {
        switch (tipus) {
            case Reparacio: return "50%";
            case Neteja: return "100%";
            case RevisioTecnica: return "50%";
            case Desinfeccio: return "0%";
        }
        return "100%";
    }

    public String toString()
    {
        return "Nº de tasca: " + num + ", tipus: " + tipus + ", allotjament: " + allotjament + ", data" + data + ",  dies previstos: " + dies + ".";
    }
}