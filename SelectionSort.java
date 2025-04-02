/* Angenommen, man hat eine unübersichtliche Sammlung von IT-Serviceverträgen (235) im PDF-Format 
  und soll diese in chronologisch aufsteigender Reihenfolge sortieren. */

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VertragsSortierung {

    public static void main(String[] args) {
        int anzahlVertraege = 235;

        // Verträge mit Zufallsdaten generieren
        String[] vertraege = generiereVertragsnamen(anzahlVertraege);

        System.out.println("🔍 Vor dem Sortieren:");
        printArray(vertraege);

        // Sortieren mit Selection Sort
        selectionSort(vertraege);

        System.out.println("\n✅ Nach dem Sortieren:");
        printArray(vertraege);
    }

    // Selection Sort nach Datum im Dateinamen
    public static void selectionSort(String[] array) {
        int n = array.length;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;

            for (int j = i + 1; j < n; j++) {
                try {
                    Date date1 = format.parse(array[j].substring(8, 18));
                    Date date2 = format.parse(array[indexMin].substring(8, 18));

                    if (date1.before(date2)) {
                        indexMin = j;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Tauschen
            String temp = array[i];
            array[i] = array[indexMin];
            array[indexMin] = temp;
        }
    }

    // Zufällige Vertragsdateinamen im Format Vertrag_YYYY-MM-DD.pdf erzeugen
    public static String[] generiereVertragsnamen(int n) {
        String[] vertragsliste = new String[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int jahr = 2020 + rand.nextInt(5);        // 2020 bis 2024
            int monat = 1 + rand.nextInt(12);         // 1 bis 12
            int tag = 1 + rand.nextInt(28);           // 1 bis 28 (einfachheitshalber)

            // Formatierung des Datums mit führenden Nullen
            String datum = String.format("%04d-%02d-%02d", jahr, monat, tag);

            vertragsliste[i] = "Vertrag_" + datum + ".pdf";
        }

        return vertragsliste;
    }

    // Ausgabe des Arrays
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
