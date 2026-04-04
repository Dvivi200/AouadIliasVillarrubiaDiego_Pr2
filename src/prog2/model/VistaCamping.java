package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExempleMenu;
import prog2.vista.Menu;

import java.util.Scanner;

// Classe que gestiona la vista i interacció amb l'usuari del càmping
public class VistaCamping {
    private String nom; // Nom del càmping
    private Camping camping; // Objecte model que conté tota la informació del càmping

    // Enum amb les opcions del menú principal
    public enum OpcionsMenu {
        LLISTAR_TOTS, LLISTAR_OPERATIUS, LLISTAR_NO_OPERATIUS,
        LLISTAR_ACC_OBERTS, LLISTAR_ACC_TANCATS, LLISTAR_TASQUES,
        AFEGIR_TASCA, COMPLETAR_TASCA,
        ACCES_SENSE_VEHICLE, METRES_TERRA,
        GUARDAR, RECUPERAR, SORTIR
    }

    // Constructor: inicialitza el nom i crea un objecte Camping amb dades inicials
    public VistaCamping(String nom) {
        this.nom = nom;
        this.camping = new Camping(nom);
        camping.inicialitzaDadesCamping(); // Omple el càmping amb dades d'exemple
    }

    // Mètode principal que gestiona el bucle del menú i les interaccions
    public void gestioCamping() {

        Scanner sc = new Scanner(System.in);

        // 1. Creació del menú amb totes les opcions
        Menu<OpcionsMenu> menu = new Menu<>("Menú Principal Càmping Green", OpcionsMenu.values());

        // 2. Descripcions de cada opció del menú
        String[] desc = {
                "Llistar tots els allotjaments", "Llistar allotjaments operatius", "Llistar allotjaments no operatius",
                "Llistar accessos oberts", "Llistar accessos tancats", "Llistar tasques de manteniment actives",
                "Afegir una tasca de manteniment", "Completar una tasca de manteniment",
                "Calcular accessos sense vehicle", "Calcular metres de terra",
                "Guardar dades del càmping", "Recuperar dades del càmping", "Sortir de l'aplicació"
        };
        menu.setDescripcions(desc);

        OpcionsMenu opcio = null;
        do {
            try {
                menu.mostrarMenu(); // Mostra el menú
                opcio = menu.getOpcio(sc); // Llegeix l'opció escollida

                switch (opcio) {
                    case LLISTAR_TOTS:
                        System.out.println(camping.llistarAllotjaments(true));
                        System.out.println(camping.llistarAllotjaments(false));
                        break;
                    case LLISTAR_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments(true));
                        break;
                    case LLISTAR_NO_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments(false));
                        break;
                    case LLISTAR_ACC_OBERTS:
                        System.out.println(camping.llistarAccessos(true));
                        break;
                    case LLISTAR_ACC_TANCATS:
                        System.out.println(camping.llistarAccessos(false));
                        break;
                    case LLISTAR_TASQUES:
                        System.out.println(camping.llistarTasquesManteniment());
                        break;

                    case AFEGIR_TASCA:
                        // Sol·licita les dades necessàries per crear una tasca
                        System.out.print("Número de tasca: ");
                        int numT = sc.nextInt();
                        sc.nextLine();
                        System.out.print("ID allotjament (nom): ");
                        String idA = sc.nextLine();
                        System.out.print("Tipus (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies previstos: ");
                        int dies = sc.nextInt();
                        sc.nextLine();

                        camping.afegirTascaManteniment(numT, tipus, idA, data, dies);
                        System.out.println("Tasca afegida correctament.");
                        break;

                    case COMPLETAR_TASCA:
                        // Mostra les tasques abans de demanar el número
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Introdueix el número de la tasca a completar: ");
                        int idCompletar = sc.nextInt();
                        sc.nextLine();
                        camping.completarTascaManteniment(idCompletar); // [11]
                        System.out.println("Tasca completada correctament.");
                        break;

                    case ACCES_SENSE_VEHICLE:
                        // Mostra el nombre d'accessos no accessibles
                        System.out.println("Número total d'accessos sense vehicle: " + camping.calculaAccessosNoAccessibles());
                        break;

                    case METRES_TERRA:
                        // Mostra la suma total de metres dels accessos de terra
                        System.out.println("Suma total de metres dels accessos de terra: " + camping.calculaMetresTerra());
                        break;

                    case GUARDAR:
                        // Sol·licita el fitxer i guarda les dades del càmping
                        System.out.print("Indica el nom del fitxer on guardar (ex: camping.dat): ");
                        camping.save(sc.nextLine());
                        System.out.println("Dades guardades.");
                        break;

                    case RECUPERAR:
                        // Sol·licita el fitxer i recupera les dades del càmping
                        System.out.print("Indica el nom del fitxer a carregar: ");
                        this.camping = Camping.load(sc.nextLine());
                        System.out.println("Dades recuperades.");
                        break;

                    case SORTIR:
                        System.out.println("Sortint de l'aplicació...");
                        break;

                    default:
                        break;
                }
            } catch (ExcepcioCamping e) {
                System.out.println("ERROR EN EL CÀMPING: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Has d'introduir un número vàlid per als camps numèrics.");
            } catch (Exception e) {
                System.out.println("ERROR INESPERAT: " + e.getMessage());
            }
        } while (opcio != OpcionsMenu.SORTIR); // Continua fins que l'usuari tria SORTIR
    }
}