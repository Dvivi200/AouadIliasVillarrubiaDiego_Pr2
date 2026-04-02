package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping, Serializable {

    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    public Camping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        llistaTasquesManteniment = new LlistaTasquesManteniment();
    }
    @Override
    public String getNomCamping() {
        return nomCamping;
    }

    @Override
    public String llistarAllotjaments(boolean estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    @Override
    public String llistarAccessos(boolean infoEstat) throws ExcepcioCamping {
        return llistaAccessos.llistarAccessos(infoEstat);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, llistaAllotjaments.getAllotjament(idAllotjament), data, dies);

    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        llistaTasquesManteniment.completarTascaManteniment(llistaTasquesManteniment.getTascaManteniment(num));
    }

    @Override
    public int calculaAccessosNoAccessibles() {
        try {
            return llistaAccessos.calculaAccessosNoAccessibles();
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float calculaMetresTerra() {
        try {
            return llistaAccessos.calculaMetresTerra();
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void inicialitzaDadesCamping() {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc1);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc2);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc3);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc4);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc5);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc6);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc7);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc8);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc9);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc10);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc11);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc12);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, 4, 2, true, "100%", mida, connexioElectrica);
        try {
            llistaAllotjaments.afegirAllotjament(ALL1);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, 4, 2, true, "100%", mida, connexioElectrica);
        try {
            llistaAllotjaments.afegirAllotjament(ALL2);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, 7, 4, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        try {
            llistaAllotjaments.afegirAllotjament(ALL3);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, 7, 4, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        try {
            llistaAllotjaments.afegirAllotjament(ALL4);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, 5, 3, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        try {
            llistaAllotjaments.afegirAllotjament(ALL5);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, 5, 3, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        try {
            llistaAllotjaments.afegirAllotjament(ALL6);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti);
        // Usamos try-with-resources para asegurar que se cierren los flujos automáticamente [4]
        try {
            FileOutputStream fos = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Guardamos "this" (la instancia actual del camping) [1, 3]
            oos.writeObject(this);

        } catch (IOException e) {
            // Lanzamos ExcepcioCamping en lugar de RuntimeException [4]
            throw new ExcepcioCamping("Error en guardar les dades al fitxer: " + e.getMessage());
        }
    }

    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        File fitxer = new File(camiOrigen);
        try {
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);
            // Leemos el objeto y hacemos el cast a Camping [5]
            return (Camping) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            // Lanzamos ExcepcioCamping para que la vista lo gestione [4]
            throw new ExcepcioCamping("Error en carregar les dades del fitxer: " + e.getMessage());
        }
    }
}
