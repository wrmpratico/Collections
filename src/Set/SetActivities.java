package Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetActivities {

    public static void main(String[] args) {

        Set<Serie> mesSeries = new HashSet<>() {{
            add(new Serie("Dark", "Science-Fiction", 68));
            add(new Serie("Breaking Bad", "Drame", 68));
            add(new Serie("The Office", "Sitcom", 40));
        }};

        System.out.println("*--\tOrdre des Genres\t--*");
        Set<Serie> mesSeries4 = new TreeSet<>(new ComparatorGenre());
        mesSeries4.addAll(mesSeries);
        for (Serie serie: mesSeries4) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());


        System.out.println("*--\tOrdre Durée Episode\t--*");
        Set<Serie> mesSeries5 = new TreeSet<>(new ComparatorDureeEpisode());
        mesSeries5.addAll(mesSeries);
        for (Serie serie: mesSeries5) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());

    }

}

class ComparatorGenre implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre != 0);
        return genre;
    }
}

class ComparatorDureeEpisode implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int dureeEpisode = Integer.compare(s1.getDureeEpisode(), s2.getDureeEpisode());
        if (dureeEpisode != 0) return dureeEpisode;

        int nom = s1.getNom().compareTo(s2.getNom());
        if (nom != 0) return nom;

        int genre = s1.getGenre().compareTo(s2.getGenre());
        return genre;
    }
}