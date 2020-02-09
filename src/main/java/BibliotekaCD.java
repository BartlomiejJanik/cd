
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Getter
@AllArgsConstructor
public class BibliotekaCD {

    private String name;
    private List<PlytaCD> listaCD = new ArrayList<>();


    public void addCD(PlytaCD cd) {
        long count = listaCD.stream().filter(e -> e.getTytul()
                .equals(cd.getTytul())).count();
        if (count == 0) {
            listaCD.add(cd);
        } else {
            System.out.println("Płyta jest na liście");
        }
    }

    public void removeCD(String title) {
        Optional<PlytaCD> cd = listaCD.stream().filter(e -> e.getTytul().equals(title)).findAny();
        if (cd.isPresent()) {
            listaCD.remove(cd.get());
        }
    }

    public static void zapiszNaDysku(BibliotekaCD bibliotekaCD, String nazwaPliku) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwaPliku));
        String nazwaBiblioteki = bibliotekaCD.getName();
        List<PlytaCD> listCD = bibliotekaCD.getListaCD();
        bufferedWriter.write(nazwaBiblioteki);
        bufferedWriter.write("\n");
        for (PlytaCD cd : listCD) {
            bufferedWriter.write(cd.getTytul());
            bufferedWriter.write(";");
            bufferedWriter.write(cd.getAutor());
            bufferedWriter.write(";");
            bufferedWriter.write(String.valueOf(cd.getWolneMiejsce()));
            bufferedWriter.write(";");
            bufferedWriter.write(String.valueOf(cd.getZajeteMiejsce()));
            bufferedWriter.write("#");

            for (Utwor u : cd.getUtwory()) {

                bufferedWriter.write(u.getNazwaUtworu());
                bufferedWriter.write(";");
                bufferedWriter.write(u.getAutorUtworu());
                bufferedWriter.write(";");
                bufferedWriter.write(String.valueOf(u.getDlugoscUtworu()));
                bufferedWriter.write("@");

            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }

    public static BibliotekaCD odczytZDysku(String nazwaPliku) throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File(nazwaPliku));
        boolean czyIstnieje = false;
        BibliotekaCD bibliotekaCD = null;

        while (odczyt.hasNextLine()) {
            String linia = odczyt.nextLine();
            if (!czyIstnieje) {
                bibliotekaCD = new BibliotekaCD(linia, new ArrayList<>());
                czyIstnieje = true;

            } else {
                String[] poPodziale = linia.split("#");
                String plytaCDTeskt = poPodziale[0].trim();
                String[] plytaCDDane = plytaCDTeskt.split(";");

                PlytaCD plytaCD = new PlytaCD(Double.valueOf(plytaCDDane[3]), Double.valueOf(plytaCDDane[2])
                        , plytaCDDane[0], plytaCDDane[1], new ArrayList<>());
                bibliotekaCD.addCD(plytaCD);

                String[] podzialPoUtworach = poPodziale[1].split("@");
                for (String s : podzialPoUtworach) {
                    String[] daneUtworow = s.split(";");

                    Utwor utwor = new Utwor(daneUtworow[0], daneUtworow[1], Double.valueOf(daneUtworow[2]));
                    plytaCD.dodajUtwor(utwor);
                }


            }

        }
        return bibliotekaCD;
    }

}
