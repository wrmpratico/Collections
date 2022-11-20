package Set;/* Avec des informations suivantes sur mes séries préférées,
creez un ensemble et commandez cet ensemble en affichant :
(nom - genre - durée de l'épisode);

Série 01 = Nom : Breaking Bad, Genre : Drame, dureeEpisode : 68
Série 02 = Nom : Dark, Genre : Science-Fiction, dureeEpisode : 68
Série 03 = Nom : The Office, Genre : Sitcom, dureeEpisode : 40
 */

import java.util.*;

public class SortSetExample {
    public static void main(String[] args) {

        System.out.println("*--\tOrdre aléatoire\t--*");
        Set<Serie> mesSeries = new HashSet<>() {{
            add(new Serie("Breaking Bad", "Drame", 68));   
            add(new Serie("Dark", "Science-Fiction", 68));   
            add(new Serie("The Office", "Sitcom", 40));   
        }};
        for (Serie serie: mesSeries) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());

        System.out.println("*--\tOrdre d'insertion\t--*");
        Set<Serie> mesSeries1 = new LinkedHashSet<>() {{
            add(new Serie("Breaking Bad", "Drame", 68));
            add(new Serie("Dark", "Science-Fiction", 68));
            add(new Serie("The Office", "Sitcom", 40));
        }};
        for (Serie serie: mesSeries1) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());

        System.out.println("*--\tOrdre naturel (DureeEpisode)\t--*");
        Set<Serie> mesSeries2 = new TreeSet<>(mesSeries1);
        for (Serie serie: mesSeries2) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());

        System.out.println("*--\tOrdre naturel Nom/Genre/DureeEpisode\t--*");
        Set<Serie> mesSeries3 = new TreeSet<>(new ComparatorNomGenreDureeEpisode());
        mesSeries3.addAll(mesSeries);
        for (Serie serie: mesSeries3) System.out.println(serie.getNom() + " - " +
                serie.getGenre() + " - " + serie.getDureeEpisode());

    }
}

class Serie implements  Comparable <Serie> {
    private String nom;
    private String genre;
    private Integer dureeEpisode;

    public Serie(String nom, String genre, Integer dureeEpisode) {
        this.nom = nom;
        this.genre = genre;
        this.dureeEpisode = dureeEpisode;
    }

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getDureeEpisode() {
        return dureeEpisode;
    }

    @Override
    public String toString() {
        return "{" +
                "nom='" + nom + '\'' +
                ", genre='" + genre + '\'' +
                ", dureeEpisode=" + dureeEpisode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nom, serie.nom) && Objects.equals(genre, serie.genre) && Objects.equals(dureeEpisode, serie.dureeEpisode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, genre, dureeEpisode);
    }

    @Override
    public int compareTo(Serie serie) {
        int dureeEpisode = Integer.compare(this.getDureeEpisode(), serie.dureeEpisode);
        if (dureeEpisode != 0) return dureeEpisode;

        return this.getGenre().compareTo(serie.getGenre());
    }
}

class ComparatorNomGenreDureeEpisode implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nom = s1.getNom().compareTo(s2.getNom());
        if (nom != 0) return nom;

        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre != 0) return genre;

        return Integer.compare(s1.getDureeEpisode(), s2.getDureeEpisode());
    }
}