import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Parcela;
import prog2.model.TascaManteniment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static prog2.model.TascaManteniment.TipusTascaManteniment;

public class TascaMantenimentTest {
    private TascaManteniment tasca;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Suposant que Allotjament té un constructor bàsic
        allotjament = new Parcela("Allotjament Test", "ID001", 4, 2,true,  "100%", 50,  true);
        tasca = new TascaManteniment(1, TipusTascaManteniment.Reparacio, allotjament, "2024-03-25", 4);
    }

    @Test
    void testConstructor() {
        assertEquals(1, tasca.getNum());
        assertEquals(TipusTascaManteniment.Reparacio, tasca.getTipus());
        assertEquals(allotjament, tasca.getAllotjament());
        assertEquals("2024-03-25", tasca.getData());
        assertEquals(4, tasca.getDies());
    }
}
