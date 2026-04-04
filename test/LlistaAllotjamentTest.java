import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.model.Parcela;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LlistaAllotjamentsTest {

    @Test
    void testFiltrarOperatius() throws ExcepcioCamping {
        LlistaAllotjaments llista = new LlistaAllotjaments();
        Allotjament all1 = new Parcela("ALL1", "Nord", 2, 4, true, "100%", 33, true);
        Allotjament all2 = new Parcela("ALL2", "Sud", 2, 4, true, "50%", 10, false);

        llista.afegirAllotjament(all1);
        llista.afegirAllotjament(all2);

        // Cambiamos el estado de un objeto
        all1.setEstat(false);

        String resultado = llista.llistarAllotjaments(true);
        assertTrue(resultado.contains("ALL2"));
        assertFalse(resultado.contains("ALL1"));
    }
}
