import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlytaCDTest {

    @Test
    public void shouldCreateNewCD() {
        //given
        double zajeteMiejsce = 555.32;
        double wolneMiejsce = 123.44;
        String tytul = "AllHopeIsGone";
        String autor = "Slipknot";
        List<Utwor> utwory = new ArrayList<Utwor>();

        //when
        PlytaCD plytaCD = new PlytaCD
                (zajeteMiejsce, wolneMiejsce, tytul, autor, utwory);

        //then
        Assert.assertEquals(Double.valueOf(zajeteMiejsce)
                , Double.valueOf(plytaCD.getZajeteMiejsce()));

        Assert.assertEquals(Double.valueOf(wolneMiejsce)
                , Double.valueOf(plytaCD.getWolneMiejsce()));

        Assert.assertEquals(tytul, plytaCD.getTytul());
        Assert.assertEquals(autor, plytaCD.getAutor());
        Assert.assertEquals(utwory, plytaCD.getUtwory());
    }

    @Test
    public void shouldAddUtwor() {
        //given
        Utwor utwor = new Utwor
                ("AllHopeIsGone", "Slipknot", 3.5);
        PlytaCD plytaCD = new PlytaCD
                (222.22, 333.33, "AllHopeIsGone"
                        , "Slipknot", new ArrayList<>());
        //when
        plytaCD.dodajUtwor(utwor);
        //then
        Assert.assertFalse(plytaCD.getUtwory().isEmpty());
        Assert.assertTrue(plytaCD.getUtwory().contains(utwor));
    }

    @Test
    public void shouldGiveMessageAndAddOne() {
        //given
        Utwor utwor = new Utwor
                ("AllHopeIsGone", "Slipknot", 3.5);
        Utwor utwor2 = new Utwor
                ("AllHopeIsGone", "Eminem", 4.3);

        PlytaCD plytaCD = new PlytaCD
                (222.22, 333.33, "AllHopeIsGone"
                        , "Slipknot", new ArrayList<>());
        //when
        plytaCD.dodajUtwor(utwor);
        plytaCD.dodajUtwor(utwor2);

        //then
        Assert.assertEquals(1, plytaCD.getUtwory().size());
    }

}