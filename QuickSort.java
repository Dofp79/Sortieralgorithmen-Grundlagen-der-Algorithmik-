/* Quick Sort ist ein schneller, rekursiver Algorithmus, der auf dem 
"Teile-und-herrsche"-Prinzip basiert – ähnlich wie Merge Sort, aber anders im Ablauf.
Dabei wird ein sogenanntes „Pivot-Element“ gewählt.
Alles, was kleiner ist, kommt nach links – alles größer nach rechts.
Danach wird rekursiv in den Teilstücken weiter sortiert. */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {
        // Liste mit Vertragsdateien (ungeordnet)
        String[] vertraege = {
            "Vertrag_2023-11-10.pdf",
            "Vertrag_2021-10-18.pdf",
            "Vertrag_2022-09-01.pdf",
            "Vertrag_2020-08-05.pdf",
            "Vertrag_2022-07-30.pdf",
            "Vertrag_2023-06-10.pdf",
            "Vertrag_2021-05-18.pdf",
            "Vertrag_2022-04-01.pdf",
            "Vertrag_2020-03-05.pdf",
            "Vertrag_2022-02-30.pdf",
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2021-12-17.pdf",
            "Vertrag_2022-08-11.pdf",
            "Vertrag_2020-09-15.pdf",
            "Vertrag_2022-10-10.pdf",
            "Vertrag_2023-11-11.pdf",
            "Vertrag_2021-12-18.pdf",
            "Vertrag_2022-12-01.pdf",
            "Vertrag_2020-12-05.pdf",
            "Vertrag_2022-11-30.pdf",
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2021-05-18.pdf",
            "Vertrag_2022-03-02.pdf",
            "Vertrag_2020-12-03.pdf",
            "Vertrag_2022-11-21.pdf",
            "Vertrag_2023-01-20.pdf",
            "Vertrag_2021-05-19.pdf",
            "Vertrag_2022-03-18.pdf",
            "Vertrag_2020-12-17.pdf",
            "Vertrag_2022-11-16.pdf"

        };

        System.out.println(" Vor dem Sortieren:");
        printArray(vertraege);

        // Quick Sort aufrufen
        quickSort(vertraege, 0, vertraege.length - 1);

        System.out.println("\n Nach dem Sortieren:");
        printArray(vertraege);
    }

    // Quick Sort Hauptfunktion (rekursiv)
    public static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            // Index des Pivot-Elements
            int pi = partition(array, low, high);

            // Linke und rechte Teilliste rekursiv sortieren
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partitioniert das Array nach dem Pivot-Prinzip
    public static int partition(String[] array, int low, int high) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String pivot = array[high]; // Pivot ist das letzte Element

        int i = (low - 1); // Trennindex für kleinere Elemente

        for (int j = low; j < high; j++) {
            try {
                // Datum aus Vertrag extrahieren
                Date dateJ = sdf.parse(array[j].substring(8, 18));
                Date datePivot = sdf.parse(pivot.substring(8, 18));

                // Wenn aktuelles Datum <= Pivot → nach links tauschen
                if (dateJ.compareTo(datePivot) <= 0) {
                    i++;
                    // Elemente tauschen
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Pivot an die korrekte Position bringen
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Neue Position des Pivot
    }

    // Ausgabe der Vertragsliste
    public static void printArray(String[] array) {
        for (String vertrag : array) {
            System.out.println(vertrag);
        }
    }
}
//„Quick Sort sortiert blitzschnell, indem es ein Pivot-Element wählt, alles links/rechts teilt und rekursiv //sortiert – schnell, aber nicht stabil.“
