/* Stellen wir uns ein Vertragskataster (Verzeichnis aller IT-Serviceverträge) vor.
Die Verträge sind dort unsortiert als PDF-Dateien abgelegt, z.B:

Vertrag_2023-01-10.pdf, Vertrag_2021-05-18.pdf, Vertrag_2022-03-01.pdf Nun sollen alle Verträge nach Datum sortiert werden - manuell, so wie man Spielkarten sortiert:

Was macht Insertion Sort?
Man nimmt einen Vertrag nach dem anderen und fügt ihn an der richtigen Stelle in die bereits sortierten Verträge ein.
So entsteht Schritt für Schritt eine sortierte Liste - genau wie beim Kartensortieren. */

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertionSort {

    public static void main(String[] args) {
        // Simulierter Vertragskataster mit zufällig unsortierten Vertragsdaten
        String[] vertraege = {
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2021-05-18.pdf",
            "Vertrag_2020-03-01.pdf",
            "Vertrag_2020-11-05.pdf",
            "Vertrag_2022-11-20.pdf",
            "Vertrag_2023-01-13.pdf",
            "Vertrag_2021-05-11.pdf",
            "Vertrag_2022-03-21.pdf",
            "Vertrag_2020-09-05.pdf",
            "Vertrag_2022-01-30.pdf"          
        };

        System.out.println("Vor dem Sortieren:");
        printArray(vertraege);

        // Sortieren der Verträge mit Insertion Sort
        insertionSort(vertraege);

        System.out.println("\n Nach dem Sortieren:");
        printArray(vertraege);
    }

    // Insertion Sort Algorithmus für Vertrags-Strings (nach Datum im Namen)
    public static void insertionSort(String[] array) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Beginne ab dem zweiten Element (i=1), da das erste als "sortiert" gilt
        for (int i = 1; i < array.length; i++) {
            String aktuellerVertrag = array[i];
            int j = i - 1;

            try {
                // Datum des aktuellen Vertrags extrahieren
                Date aktuellesDatum = sdf.parse(aktuellerVertrag.substring(8, 18));

                // Suche den korrekten Platz für den aktuellen Vertrag
                while (j >= 0) {
                    Date vergleichsDatum = sdf.parse(array[j].substring(8, 18));

                    // Wenn das Datum in der sortierten Liste größer ist → verschiebe nach rechts
                    if (vergleichsDatum.after(aktuellesDatum)) {
                        array[j + 1] = array[j];
                        j--;
                    } else {
                        break; // Passende Position gefunden
                    }
                }

                // Füge den Vertrag an der passenden Stelle ein
                array[j + 1] = aktuellerVertrag;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Methode zur Ausgabe der Vertragsliste
    public static void printArray(String[] array) {
        for (String vertrag : array) {
            System.out.println(vertrag);
        }
    }
}
