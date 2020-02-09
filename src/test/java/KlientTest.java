import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KlientTest {

    @Test
    public void shuldCreateNewKlient() {
        //given
        String imie = "Jan";
        String nazwisko = "Kowalski";
        int nrKlienta = 1;
        String pesel = "69051824793";

        //when
        Klient klientExpected = new Klient
                (imie, nazwisko, nrKlienta, pesel);
        //then
        Assert.assertEquals(imie, klientExpected.getImie());
        Assert.assertEquals(nazwisko, klientExpected.getNazwisko());
        Assert.assertEquals(nrKlienta, klientExpected.getNrKlienta());
        Assert.assertEquals(pesel, klientExpected.getPesel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        //when
        Klient klient = new Klient("Jan", "Kowalski"
                , 1, "69051824791");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException2() {
        //when
        Klient klient = new Klient("", ""
                , 1, "69051824798");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCheckPesel() {
        //when
        Klient klient = new Klient("jan", "kowalksi"
                , 1, "69051824798");
        klient.setPesel("69051824790");
    }

    @Test
    public void shouldValidatePesel() {
        //given
        Klient klient = new Klient("jan", "kowalksi"
                , 1, "67041049793");
        klient.setPesel("62051342649");

        //when
        Assert.assertEquals("62051342649", klient.getPesel());
    }

}