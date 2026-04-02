package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExempleMenu;
import prog2.vista.Menu;

import java.util.Scanner;

public class VistaCamping {
    private String nom;
    private Camping camping;
    public enum OpcionsMenu {
        LLISTAR_TOTS, LLISTAR_OPERATIUS, LLISTAR_NO_OPERATIUS,
        LLISTAR_ACC_OBERTS, LLISTAR_ACC_TANCATS, LLISTAR_TASQUES,
        AFEGIR_TASCA, COMPLETAR_TASCA,
        ACCES_SENSE_VEHICLE, METRES_TERRA,
        GUARDAR, RECUPERAR, SORTIR
    }

    public VistaCamping(String nom) {
        this.nom = nom;
        this.camping = new Camping(nom);
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {

        Scanner sc = new Scanner(System.in);

        // 1. Creación del objeto Menu con las 13 opciones obligatorias [1, 5]
        Menu<OpcionsMenu> menu = new Menu<>("Menú Principal Càmping Green", OpcionsMenu.values());

        // 2. Definición de las descripciones del menú [5]
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
            // 3. Gestión de errores mediante try-catch en la vista [7, 8]
            try {
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);

                switch (opcio) {
                    case LLISTAR_TOTS:
                        System.out.println(camping.llistarAllotjaments(true));
                        System.out.println(camping.llistarAllotjaments(false));// Todos los prints en la vista [7]
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
                        // 4. Solicitar datos específicos según el requisito 7 [2]
                        System.out.print("Número de tasca: ");
                        int numT = Integer.parseInt(sc.nextLine());
                        System.out.print("ID allotjament (nom): ");
                        String idA = sc.nextLine();
                        System.out.print("Tipus (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies previstos: ");
                        int dies = Integer.parseInt(sc.nextLine());

                        // Llamada al modelo para añadir la tarea [9, 10]
                        camping.afegirTascaManteniment(numT, tipus, idA, data, dies);
                        System.out.println("Tasca afegida correctament.");
                        break;

                    case COMPLETAR_TASCA:
                        // 5. Requisito 8: Listar tareas antes de pedir el número [2]
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Introdueix el número de la tasca a completar: ");
                        int idCompletar = Integer.parseInt(sc.nextLine());
                        camping.completarTascaManteniment(idCompletar); // [11]
                        System.out.println("Tasca completada correctament.");
                        break;

                    case ACCES_SENSE_VEHICLE:
                        // Requisito 9 [3]
                        System.out.println("Número total d'accessos sense vehicle: " + camping.calculaAccessosNoAccessibles());
                        break;

                    case METRES_TERRA:
                        // Requisito 10 [3]
                        System.out.println("Suma total de metres dels accessos de terra: " + camping.calculaMetresTerra());
                        break;

                    case GUARDAR:
                        // Requisito 11: Persistencia [3, 12]
                        System.out.print("Indica el nom del fitxer on guardar (ex: camping.dat): ");
                        camping.save(sc.nextLine());
                        System.out.println("Dades guardades.");
                        break;

                    case RECUPERAR:
                        // Requisito 12: Recuperar mediante método estático [3, 13]
                        System.out.print("Indica el nom del fitxer a carregar: ");
                        this.camping = Camping.load(sc.nextLine());
                        System.out.println("Dades recuperades.");
                        break;

                    case SORTIR:
                        System.out.println("Sortint de l'aplicació...");
                        break;
                }
            } catch (ExcepcioCamping e) {
                // Captura de errores específicos del modelo (ej. alojamiento con tarea activa) [8]
                System.out.println("ERROR EN EL CÀMPING: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Has d'introduir un número vàlid per als camps numèrics.");
            } catch (Exception e) {
                System.out.println("ERROR INESPERAT: " + e.getMessage());
            }
        } while (opcio != OpcionsMenu.SORTIR); // El bucle continúa hasta elegir la opción 13 [4, 5]
    }
}
