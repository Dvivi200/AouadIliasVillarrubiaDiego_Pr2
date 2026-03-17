package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{

    private String nom;
    private ArrayList<Allotjament> allotjament;
    private ArrayList<Client> clients;
    private LlistaReserves reserves;

    //Constructor
    public Camping(String nom){
        this.nom = nom;
        this.allotjament = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new LlistaReserves();
    }

    //Getters
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return reserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjament;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    //Getters del numero d'elements als atributs
    @Override
    public int getNumAllotjaments() {
        if (allotjament.isEmpty()){
            return 0;
        }
        else{
            return allotjament.size();
        }
    }

    @Override
    public int getNumReserves() {
        return reserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        if (clients.isEmpty()){
            return 0;
        }
        else{
            return clients.size();
        }
    }

    //Mètode per afegir clients a la classe
    @Override
    public void afegirClient(String nom_, String dni_) {
        clients.add(new Client(nom_,dni_));

    }

    //Mètode per afegir allotjaments a la classe
    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        allotjament.add(new Parcela(nom_, idAllotjament_, metres, connexioElectrica));
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        allotjament.add(new Bungalow(nom_, idAllotjament_, mida, habitacions,placesPersones, placesParquing, terrassa, tv,aireFred));
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        allotjament.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions,placesPersones, placesParquing, terrassa, tv,aireFred, serveisExtra, codiWifi));
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        allotjament.add(new Glamping(nom_, idAllotjament_, mida, habitacions,placesPersones, material, casaMascota));
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        allotjament.add(new MobilHome(nom_, idAllotjament_, mida, habitacions,placesPersones,terrassaBarbacoa));
    }
    //Mètodes de suport
    private Allotjament buscarAllotjament(String id_) {
        for (Allotjament allotjament : this.allotjament) {
            if (id_.equals(allotjament.getId())){
                return allotjament;
            }
        }
        return null;
    }

    private Client buscarClient(String dni_) {
        for (Client client : clients) {
            if (dni_.equals(client.getDni())){
                return client;
            }
        }
        return null;
    }

    //Mètode per afegir reserves a la classe
    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);
        if(allotjament != null && client != null){
            reserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
            System.out.println("Allotjament amb identificador " + id_ + " reservat pel client amb DNI " + dni_
            + " del " + dataEntrada + " al " + dataSortida + ".");
        }
        else if(allotjament == null)
            throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
        else
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        for(Allotjament allotjament : this.allotjament){
            if(allotjament.correcteFuncionament()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Allotjament e_minima = this.allotjament.getFirst();
        long estada = e_minima.getEstadaMinima(temp);
        for(Allotjament allotjament : this.allotjament){
            long min = allotjament.getEstadaMinima(temp);
            if(min <= estada){
                estada = min;
                e_minima = allotjament;
            }
        }
        return e_minima;
    }


    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        if(mes > 3 && mes < 9)
            return InAllotjament.Temp.ALTA;
        else if(mes < 3 || mes > 9)
            return InAllotjament.Temp.BAIXA;
        else if(mes == 3){
            if(dia >= 21)
                return InAllotjament.Temp.ALTA;
            else return InAllotjament.Temp.BAIXA;
        }
        else{
            if(dia <= 20)
                return InAllotjament.Temp.ALTA;
            else return InAllotjament.Temp.BAIXA;
        }
    }

}
