import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaAccessosTest {
    private LlistaAccessos llistaAcc;
    private CamiAsfaltat camiA;
    private CarreteraAsfaltada carreteraA;
    private CamiTerra camiT;
    private CarreteraTerra carreteraT;
    private Parcela parc;

    // Inicialitza la llista amb diferents tipus d'accessos
    @BeforeEach
    public void inicialitzar() throws ExcepcioCamping {
        llistaAcc = new LlistaAccessos();
        camiA = new CamiAsfaltat("A1", true, 200);
        carreteraA = new CarreteraAsfaltada("A2", true, 800, 10000);
        camiT = new CamiTerra("A3", true, 100);
        carreteraT = new CarreteraTerra("A4", true, 200, 3);
        parc = new Parcela("Parcel·la Nord", "ALL1", 5, 4, true, "100%", 200, true);

        llistaAcc.afegirAcces(camiA);
        llistaAcc.afegirAcces(carreteraA);
        llistaAcc.afegirAcces(camiT);
        llistaAcc.afegirAcces(carreteraT);
    }

    // Comprova que es poden llistar accessos oberts
    @Test
    public void testAccessosOberts() throws ExcepcioCamping {
        String resultat = llistaAcc.llistarAccessos(true);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que si no hi ha accessos tancats es llença excepció
    @Test
    public void testAccessosTancats() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAcc.llistarAccessos(false);
        });
    }

    // Comprova el nombre d'accessos no accessibles (camins)
    @Test
    public void testNumAccessosNoAccessibles() throws ExcepcioCamping {
        // camiA i camiT no són accessibles → 2
        assertEquals(2, llistaAcc.calculaAccessosNoAccessibles());
    }

    // Comprova el càlcul de metres totals de terra
    @Test
    public void testMetresTotalsTerra() throws ExcepcioCamping {
        // camiT (100) + carreteraT (200) = 300
        assertEquals(300, llistaAcc.calculaMetresTerra());
    }

    // Comprova l'actualització de l'estat dels accessos segons allotjaments
    @Test
    public void testActualitzarEstatAccessos() throws ExcepcioCamping {
        camiA.afegirAllotjament(parc);

        // Es crea una tasca que fa que l'allotjament deixi d'estar operatiu
        TascaManteniment t = new TascaManteniment(
                1,
                TascaManteniment.TipusTascaManteniment.Reparacio,
                parc,
                "2024-03-25",
                4
        );
        parc.tancarAllotjament(t);

        llistaAcc.actualitzaEstatAccessos();

        // L'accés hauria d'estar tancat perquè no hi ha allotjaments operatius
        assertFalse(camiA.getEstat());
    }

    // Comprova que buidar la llista elimina tots els accessos
    @Test
    public void testBuidarLlista() {
        llistaAcc.buidar();

        assertThrows(ExcepcioCamping.class, () -> {
            llistaAcc.llistarAccessos(true);
        });
    }
}