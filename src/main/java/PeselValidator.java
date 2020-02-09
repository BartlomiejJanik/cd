import java.util.Arrays;
import java.util.List;

/**
 * Rozważmy PESEL osoby urodzonej 8 lipca 1902 roku,
 * płci żeńskiej (parzysta końcówka numeru z serii – 0362).
 * Czyli mamy wówczas 0207080362. Teraz kolejne cyfry należy
 * przemnożyć przez odpowiednie wagi i dodać do siebie.
 * 0*1 + 2*3 + 0*7 + 7*9 + 0*1 + 8*3 + 0*7 + 3*9 + 6*1 + 2*3
 * = 0 + 6 + 0 + 63 + 0 + 24 + 0 + 27 + 6 + 6 = 132
 * Wynik dzielimy modulo przez 10.
 * 132 mod 10 = 2
 * A następnie odejmujemy od 10
 * 10 - 2 = 8.
 * I wynik dzielimy znów modulo 10
 * 8 mod 10 = 8
 * Cyfra kontrolna to 8, zatem nasz prawidłowy numer PESEL to:
 * 02070803628
 */
public class PeselValidator {

    public static boolean valid(String pesel) {
        if(pesel == null) {
            return false;
        }
        if(pesel.length() != 11) {
            return false;
        }
        List<Character> znaki = Arrays.asList('1', '2', '3', '4', '5', '6'
                , '7', '8', '9', '0');
        char[] peselZnaki = pesel.toCharArray();

        for (int i = 0; i < pesel.length(); i++) {
            if(!znaki.contains(peselZnaki[i])) {
                return false;
            }
        }

        int[] ints = new int[11];
        for (int i = 0; i < 11; i++) {
            ints[i] = Integer.parseInt(String.valueOf(peselZnaki[i]));
        }

        int suma;
        suma = ints[0] + ints[1] * 3 + ints[2] * 7 + ints[3] * 9
                + ints[4] + ints[5] * 3 + ints[6] * 7 + ints[7] * 9
                + ints[8] + ints[9] * 3;

        suma = suma % 10;
        suma = 10 - suma;
        suma = suma % 10;

        return suma == ints[10];
    }



}



