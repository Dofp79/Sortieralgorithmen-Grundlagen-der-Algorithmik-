/* Merge Sort ist ein rekursiver Sortieralgorithmus, der eine Liste in zwei Teile teilt, jeden Teil sortiert und anschließend wieder zusammenfügt (mergt).
Dies geschieht rekursiv, bis jede Teilliste nur noch ein Element enthält. Dann beginnt das Merging (Zusammenführen).*/

// Als Beispiel nehmen wir unsere realistische Analogie: Vertragskataster

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSort {

    public static void main(String[] args) {
        // Simulierte Vertragsliste
        String[] vertraege = {
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2021-05-18.pdf",
            "Vertrag_2022-03-01.pdf",
            "Vertrag_2021-12-05.pdf",
            "Vertrag_2023-11-30.pdf",
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2024-05-18.pdf",
            "Vertrag_2022-03-01.pdf",
            "Vertrag_2021-02-05.pdf",
            "Vertrag_2022-11-30.pdf",
            "Vertrag_2019-01-10.pdf",
            "Vertrag_2021-02-18.pdf",
            "Vertrag_2017-03-01.pdf",
            "Vertrag_2025-01-05.pdf",
            "Vertrag_2022-10-30.pdf",
            "Vertrag_2023-03-10.pdf",
            "Vertrag_2021-06-18.pdf",
            "Vertrag_2022-03-02.pdf",
            "Vertrag_2020-12-16.pdf",
            "Vertrag_2022-11-23.pdf",
            "Vertrag_2023-01-09.pdf",
            "Vertrag_2021-05-17.pdf",
            "Vertrag_2022-03-01.pdf",
            "Vertrag_2020-12-05.pdf",
            "Vertrag_2022-11-30.pdf",
            "Vertrag_2023-01-10.pdf",
            "Vertrag_2021-05-18.pdf",
            "Vertrag_2022-03-01.pdf",
            "Vertrag_2020-09-05.pdf",
            "Vertrag_2022-08-30.pdf"

        };

        System.out.println("Vor dem Sortieren:");
        printArray(vertraege);

        // Merge Sort anwenden
        mergeSort(vertraege, 0, vertraege.length - 1);

        System.out.println("\n Nach dem Sortieren:");
        printArray(vertraege);
    }

    // Merge Sort Algorithmus
    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            // Mitte berechnen
            int mid = (left + right) / 2;

            // Linke und rechte Hälfte rekursiv sortieren
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Und zusammenführen (merge)
            merge(arr, left, mid, right);
        }
    }

    // Methode zum Zusammenführen (Mergen) zweier sortierter Teillisten
    public static void merge(String[] arr, int left, int mid, int right) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Länge der Teillisten
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporäre Arrays erstellen
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Füllen der linken und rechten Teilliste
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge-Vorgang
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            try {
                Date d1 = sdf.parse(L[i].substring(8, 18));
                Date d2 = sdf.parse(R[j].substring(8, 18));

                // Vergleich: Welches Datum ist kleiner?
                if (d1.compareTo(d2) <= 0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Reste aus der linken Liste (falls vorhanden)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Reste aus der rechten Liste (falls vorhanden)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Ausgabe der Vertragsliste
    public static void printArray(String[] array) {
        for (String vertrag : array) {
            System.out.println(vertrag);
        }
    }
}
// „Merge Sort teilt das Problem in Hälften und löst es rekursiv – sortiert schnell und 
// stabil, auch bei großen Datenmengen.“
