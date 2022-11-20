package List;

/* Avec des informations suivantes qui concerne mes chats, créez une liste
et triez cette liste en affichant :
(prénom - âge - couleur);

Chat 01 = prénom: Jon, âge: 18, couleur: noir
Chat 02 = prénom: Simba, âge: 06, couleur: bringé
Chat 03 = prénom: Jon, âge: 12, couleur: jaune
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListExample {
    public static void main(String[] args) {

        List<Chat> mesChats = new ArrayList<>(){{
            add(new Chat("Jon", 18, "noir"));
            add(new Chat("Simba", 6, "bringé"));
            add(new Chat("Jon", 12, "jaune"));
        }};

        System.out.println("--\tOrdre d'Insertion\t---");
        System.out.println(mesChats);

        System.out.println("--\tOrdre aleatoire\t---");
        Collections.shuffle(mesChats);
        System.out.println(mesChats);

        System.out.println("--\tOrdre naturale (Prénom)\t---");
        Collections.sort(mesChats);
        System.out.println(mesChats);

        System.out.println("--\tOrdre d'Âge");
        Collections.sort(mesChats, new ComparatorAge());
//        mesChats.sort(new ComparatorAge());
        System.out.println(mesChats);

        System.out.println("--\tOrdre de Couleur\t---");
//        Collections.sort(mesChats, new ComparatorCouleur());
        mesChats.sort(new ComparatorCouleur());
        System.out.println(mesChats);

        System.out.println("--\tOrdre Prénom/Couleur/Âge\t---");
//        Collections.sort(mesChats, new ComparatorPrénomCouleurÂge());
        mesChats.sort(new ComparatorPrénomCouleurÂge());
        System.out.println(mesChats);
    }
}

class Chat implements Comparable<Chat>{
    private String prénom;
    private Integer âge;
    private String couleur;

    public Chat(String prénom, Integer âge, String couleur) {
        this.prénom = prénom;
        this.âge = âge;
        this.couleur = couleur;
    }

    public String getPrénom() {
        return prénom;
    }

    public Integer getÂge() {
        return âge;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "{" +
                "prénom='" + prénom + '\'' +
                ", âge=" + âge +
                ", couleur='" + couleur + '\'' +
                '}';
    }

    @Override
    public int compareTo(Chat chat) {
        return this.getPrénom().compareToIgnoreCase(chat.getPrénom());
    }
}

class ComparatorAge implements Comparator<Chat> {
    @Override
    public int compare(Chat c1, Chat c2) {
        return Integer.compare(c1.getÂge(), c2.getÂge());
    }
}
class ComparatorCouleur implements Comparator<Chat> {

    @Override
    public int compare(Chat c1, Chat c2) {
        return c1.getCouleur().compareToIgnoreCase(c2.getCouleur());
    }
}
class ComparatorPrénomCouleurÂge implements Comparator<Chat> {

    @Override
    public int compare(Chat c1, Chat c2) {
        int prenom = c1.getPrénom().compareToIgnoreCase(c2.getPrénom());
        if (prenom != 0) return prenom;

        int couleur = c1.getCouleur().compareTo(c2.getCouleur());
        if (couleur != 0) return couleur;

        return Integer.compare(c1.getÂge(), c2.getÂge());
    }
}