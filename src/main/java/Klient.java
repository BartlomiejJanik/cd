import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Klient {

    private String imie;
    private String nazwisko;
    private int nrKlienta;
    private String pesel;

    public void setPesel(String pesel) {
        if(PeselValidator.valid(pesel)) {
            this.pesel = pesel;
        } else {
            throw new IllegalArgumentException("niepoprawny pesel");
        }
    }

    public Klient(String imie, String nazwisko, int nrKlienta
            , String pesel) {
        if(EmptyValidator.valid(imie)) {
            this.imie = imie;
        } else {
            throw new IllegalArgumentException("niepoprawne imie");
        }
        if(EmptyValidator.valid(nazwisko)) {
            this.nazwisko = nazwisko;
        } else {
            throw new IllegalArgumentException("niepoprawne naziwsko");
        }
        this.nrKlienta = nrKlienta;
        if(PeselValidator.valid(pesel)) {
            this.pesel = pesel;
        } else {
            throw new IllegalArgumentException("niepoprawny pesel");
        }
    }

}
