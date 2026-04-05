import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class CampingTest {
    private Camping camp;

    // Inicialitza un càmping amb dades de prova abans de cada test
    @BeforeEach
    public void inicialitzar() {
        camp = new Camping("Green");
        camp.inicialitzaDadesCamping();
    }

    // Comprova que el nom del càmping és correcte
    @Test
    public void testNomCamping() {
        assertEquals("Green", camp.getNomCamping());
    }

    // Comprova que es poden llistar tots els allotjaments (operatius i no)
    @Test
    public void testLlistarTotsAllotjaments() throws ExcepcioCamping {
        String resultat = camp.llistarAllotjaments(true) + camp.llistarAllotjaments(false);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que hi ha allotjaments operatius
    @Test
    public void testLlistarOperatius() throws ExcepcioCamping {
        String resultat = camp.llistarAllotjaments(true);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que es poden obtenir accessos oberts
    @Test
    public void testAccessosOberts() throws ExcepcioCamping {
        String resultat = camp.llistarAccessos(true);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que es pot afegir una tasca correctament
    @Test
    public void testAfegirTasca() throws ExcepcioCamping {
        camp.afegirTascaManteniment(1, "Reparacio", "ALL1", "2024-03-25", 4);
        String resultat = camp.llistarTasquesManteniment();
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que es llença excepció si l'allotjament no existeix
    @Test
    public void testAfegirTascaAllotjamentIncorrecte() {
        assertThrows(ExcepcioCamping.class, () -> {
            camp.afegirTascaManteniment(1, "Reparacio", "ALL99", "2024-03-25", 4);
        });
    }

    // Comprova que en completar una tasca desapareix de la llista
    @Test
    public void testCompletarTasca() throws ExcepcioCamping {
        camp.afegirTascaManteniment(1, "Reparacio", "ALL1", "2024-03-25", 4);
        camp.completarTascaManteniment(1);

        // Després de completar-la, la llista hauria d'estar buida i llençar excepció
        assertThrows(ExcepcioCamping.class, () -> {
            camp.llistarTasquesManteniment();
        });
    }

    // Comprova el càlcul d'accessos no accessibles (camins)
    @Test
    public void testAccessosNoAccessibles() throws ExcepcioCamping {
        // Segons dades inicials: 6 accessos no accessibles
        assertEquals(6, camp.calculaAccessosNoAccessibles());
    }

    // Comprova la suma total de metres dels accessos de terra
    @Test
    public void testMetresTerra() throws ExcepcioCamping {
        // Suma esperada segons dades inicials
        assertEquals(1630, camp.calculaMetresTerra());
    }
}