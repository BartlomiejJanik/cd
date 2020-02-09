import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class PlytaCD {

    private double zajeteMiejsce;
    private double wolneMiejsce;
    private String tytul;
    private String autor;
    private List<Utwor> utwory = new ArrayList<Utwor>();

    public void dodajUtwor(final Utwor utwor) {
        long count = utwory.stream().filter(e -> e.getNazwaUtworu()
                .equals(utwor.getNazwaUtworu())).count();
        if (count == 0) {
            utwory.add(utwor);
        } else {
            System.out.println("Taki utwor juz zsotal dodany");
        }
    }

}
