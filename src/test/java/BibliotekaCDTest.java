import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotekaCDTest {



    @Test
    public void shouldAddCD() {
        //given
        PlytaCD cd1 = new PlytaCD(500, 300, "Bbb", "Aaa", new ArrayList<>());

        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        //when
        biblioteka.addCD(cd1);

        //then
        Assert.assertEquals(1, biblioteka.getListaCD().size());
    }

    @Test
    public void shouldRemoveCD() {
        //given
        PlytaCD cd1 = new PlytaCD(500, 300, "Ccc", "Aaa", new ArrayList<>());
        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        biblioteka.addCD(cd1);
        Assert.assertEquals(1, biblioteka.getListaCD().size());
        //when
        biblioteka.removeCD("Aaa");
        //then
        Assert.assertFalse(biblioteka.getListaCD().isEmpty());
    }
    @Test
    public void shouldWriteToFile() throws IOException {
        //given
        Utwor utwor = new Utwor("Trooper","Iron Maiden",2.5);
        Utwor utwor2 = new Utwor("Fly","Iron Maiden",4.2);
        Utwor utwor3 = new Utwor("Scare","Iron Maiden",3.5);

        PlytaCD cd1 = new PlytaCD(500, 300, "Aaa", "Bbb", new ArrayList<>());
        PlytaCD cd2 = new PlytaCD(500, 300, "Ccc", "Ddd", new ArrayList<>());
        BibliotekaCD biblioteka = new BibliotekaCD("Biblioteka", new ArrayList<>());
        biblioteka.addCD(cd1);
        biblioteka.addCD(cd2);
        cd1.dodajUtwor(utwor);
        cd1.dodajUtwor(utwor2);
        cd2.dodajUtwor(utwor3);
        //when
        BibliotekaCD.zapiszNaDysku(biblioteka,"ZapisanaBiblioteka.txt");

        //then
    }
    @Test
    public void shouldReadLine() throws FileNotFoundException {
        //given
        String nazwaPliku = "ZapisanaBiblioteka.txt";

        //when
        BibliotekaCD bibliotekaCD = BibliotekaCD.odczytZDysku(nazwaPliku);

        //then
        Assert.assertEquals("Biblioteka",bibliotekaCD.getName());
        Assert.assertEquals(2,bibliotekaCD.getListaCD().size());
        Assert.assertEquals(2,bibliotekaCD.getListaCD().get(0).getUtwory().size());
        Assert.assertEquals(1,bibliotekaCD.getListaCD().get(1).getUtwory().size());
    }


}