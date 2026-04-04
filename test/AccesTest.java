import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Acces;
import prog2.model.CamiAsfaltat;
import prog2.model.CamiTerra;
import prog2.model.LlistaAllotjaments;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesTest {

    private Acces acces1;
    private Acces acces2;

    @BeforeEach
    void setUp() {
        // Dos accessos inicials i un allotjament
        acces1 = new Acces("Acces 1", true){
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
        acces2 = new Acces("Acces 2", false){
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals(acces1.getNom(), "Acces 1");
        assertEquals(acces2.getNom(), "Acces 2");
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
        assertTrue(acces1.getAAllotjaments() instanceof LlistaAllotjaments);
    }

    @Test
    void testCamiAsfalt() {
        // AccesAsfalt guarda m2 d'asfalt. CamiAsfalt no té accessibilitat (false)
        CamiAsfaltat cami = new CamiAsfaltat("A1", false, 200);
        assertEquals(200.0, cami.getAsfalt());
        assertFalse(cami.isAccessibilitat());
    }

    @Test
    void testCamiTerra() {
        // AccesTerra guarda longitud en metres. CamiTerra no té accessibilitat (false)
        CamiTerra cami = new CamiTerra("A3", true, 100);
        assertEquals(100.0, cami.getLongitud());
        assertFalse(cami.isAccessibilitat());
    }
}

