package Set;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {

        System.out.println("Créez un ensemble et ajoutez les notes : ");
        Set<Double> notes = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notes.toString());

//        System.out.println("Afficher la position de la note 5.0 : ");
//        lorsque on travaille avec Set, il n'est pas possible de rechercher en fonction de la position

//        System.out.println("Ajoutez la note 8.0 dans la position 4 à la liste : ");
//        Il n'est pas possible de travailler avec des positions dans un Set

//        System.out.println("Remplacer la note 5.0 par la note 6.0 : ");
//        Il n'est pas possible de remplacer n'importe quoi avec la méthode Set

        System.out.println("Assurez-vous que la note 5.0 est dans l'ensemble : " + notes.contains(5.0));

//        System.out.println("Afficher la troisième note ajoutée : ");
//        Il n'est pas posible parce qu'on n'est pas la méthode "Get" pour passer l'indice et apparaît la note

        System.out.println("Afficher la note la plus basse : " + Collections.min(notes));

        System.out.println("Afficher la note la plus élevé : " + Collections.max(notes));

        Iterator<Double> iterator = notes.iterator();
        Double somme = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            somme += next;
        }
        System.out.println("Afficher la somme des valeurs : " + somme);

        System.out.println("Afficher la moyenne de tous les notes : " + (somme/notes.size()));

        System.out.println("Supprimer la note 0.0 : ");
        notes.remove(0d);
        System.out.println(notes);

//        System.out.println("Supprimer la note qui est dans la position 0 : ");

        System.out.println("Supprimer toutes les notes inférieures à 7.0 et afficher la liste : ");
        Iterator<Double> iterator1 = notes.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notes);

        System.out.println("Afficher toutes les notes dans l'ordre dans lequel elles ont été saisies : ");
//        Si on souhaite travailler avec ce type d'ordre, on n'est doit pas utiliser le HashSet,
//        on doit travailler avec le LinkedHashSet
        Set<Double> notes2 = new LinkedHashSet<>();
        notes2.add(7d);
        notes2.add(8.5);
        notes2.add(9.3);
        notes2.add(5d);
        notes2.add(7d);
        notes2.add(0d);
        notes2.add(3.6);
        System.out.println(notes2);

        System.out.println("Afficher toutes les notes par ordre croissant : ");
//        Il faut utiliser l'implémentation TreeSet, parce qu'elle s'organise selon l'ordre naturel
//        des éléments
        Set<Double> notes3 = new TreeSet<>(notes2);
        System.out.println(notes3);

        System.out.println("Supprimer l'ensemble 1 entier : ");
        notes.clear();

        System.out.println("Vérifier si l'ensemble 1 est supprimé : " + notes.isEmpty());
        System.out.println("Vérifier si l'ensemble 2 est supprimé : " + notes2.isEmpty());
        System.out.println("Vérifier si l'ensemble 3 est supprimé : " + notes3.isEmpty());

    }
}
