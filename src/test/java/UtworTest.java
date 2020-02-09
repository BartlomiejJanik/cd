import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtworTest {


    @Test
    public void shouldCreateUtwor() {
        //given
        String nazwaUtworu = "AllHopeIsGone";
        String autorUtworu = "Slipknot";
        double dlugoscUtworu = 4.5;

        //when
        Utwor utwor = new Utwor(nazwaUtworu, autorUtworu, dlugoscUtworu);

        //then
        Assert.assertEquals(nazwaUtworu, utwor.getNazwaUtworu());
        Assert.assertEquals(autorUtworu, utwor.getAutorUtworu());
        Assert.assertEquals(Double.valueOf(dlugoscUtworu),
                Double.valueOf(utwor.getDlugoscUtworu())
        );
    }

}