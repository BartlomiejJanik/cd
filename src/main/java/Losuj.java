import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Losuj {

    public static void main(String[] args) {
        List<String> persons = Arrays.asList(
                //"Barbara Sanecka-Sieńko",
                //"Bartłomiej Janik",
                //"Bartosz Nizioł",
                "Grzegorz Rzeźnik",
                "Jakub Sarna",
                //"Karolina Zaborska",
                //"Marta Kuśpit",
                "Mateusz Łukasik"
                //"Michał Suchodolski",
                //"Paulina Anna Wierzchowska",
                //"Paweł Dziechciaruk",
                //"Piotr Bojczewski",
                //"Piotr Malicki",
                //"Piotr Szlęzak"
                //"Robert Pilczuk",
                //"Robert Lewicki"
        );
        Collections.shuffle(persons);
        System.out.println(persons.get(0));
    }

}
