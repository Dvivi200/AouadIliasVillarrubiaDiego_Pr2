import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaTasquesMantenimentTest {
    private LlistaTasquesManteniment llistaTasques;
    private Parcela parc;
    private Bungalow bung;

    // Inicialització de dades abans de cada test
    @BeforeEach
    public void inicialitzar() {
        llistaTasques = new LlistaTasquesManteniment();
        parc = new Parcela("Parcel·la Nord", "ALL1", 4, 3, true, "100%", 64, true);
        bung = new Bungalow("Bungalow Nord", "ALL3", 5, 1, true, "100%", 22, 2, 4, 1, true, true, true);
    }

    // Comprova que es pot afegir una tasca correctament
    @Test
    public void testAfegirTasca() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        TascaManteniment t = llistaTasques.getTascaManteniment(1);
        assertEquals(1, t.getNum());
    }

    // Comprova que no es poden afegir tasques duplicades
    @Test
    public void testAfegirTascaDuplicada() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        assertThrows(ExcepcioCamping.class, () -> {
            llistaTasques.afegirTascaManteniment(2, "Neteja", parc, "2024-03-26", 2);
        });
    }

    // Comprova que el tipus de tasca sigui vàlid
    @Test
    public void testTipusInvalid() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaTasques.afegirTascaManteniment(1, "TipusInvalid", parc, "2024-03-25", 4);
        });
    }

    // Comprova que l'allotjament passa a no operatiu en afegir una tasca
    @Test
    public void testAllotjamentNoOperatiu() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        assertFalse(parc.isOperatiu());
    }

    // Comprova el canvi d'il·luminació en afegir la tasca
    @Test
    public void testIluminacioReduida() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        assertEquals("50%", parc.getIluminacio());
    }

    // Comprova que completar una tasca fa l'allotjament operatiu
    @Test
    public void testCompletarTasca() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        TascaManteniment t = llistaTasques.getTascaManteniment(1);
        llistaTasques.completarTascaManteniment(t);
        assertTrue(parc.isOperatiu());
    }

    // Comprova que la il·luminació es restaura en completar
    @Test
    public void testIluminacioRestaurada() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parc, "2024-03-25", 4);
        TascaManteniment t = llistaTasques.getTascaManteniment(1);
        llistaTasques.completarTascaManteniment(t);
        assertEquals("100%", parc.getIluminacio());
    }

    // Comprova que no es pot obtenir una tasca inexistent
    @Test
    public void testGetTascaInexistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaTasques.getTascaManteniment(99);
        });
    }

    // Comprova el comportament quan no hi ha tasques
    @Test
    public void testLlistaBuida() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaTasques.llistarTasquesManteniment();
        });
    }
}