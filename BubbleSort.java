// Algorithmus: Bubble Sort
// Komplexität (Durchschnitt): O(n²) 
// Besonderheit: Einfach, aber langsam
/* Bubble Sort	O(n²)	Einfach, aber langsam
Stell wir uns vor, in einer medizinischen Studie mit Kindern gibt es mehrere Kinder mit unterschiedlichen Größen und sie müssen nach Größe sortiert werden - vom kleinsten zum größten.
Bei der BubbleSort ( Blasensortierung ) werden immer zwei Kinder nebeneinander verglichen, und wenn das linke größer ist als das rechte, werden sie getauscht.
Dieser Vorgang wird so lange wiederholt, bis niemand mehr den Platz tauschen muss. */

public class BubbleSortBeispiel {

    public static void main(String[] args) {

        // Ein Array mit unsortierten Ganzzahlen – stell dir vor, es sind die Körpergrößen von Kindern in cm
        int[] groessen = {140, 114, 152, 130, 125, 142, 127, 151, 130, 127, 142, 128, 151, 136, 121};

        System.out.println("Vor dem Sortieren:");
        printArray(groessen); // Ausgabe des ursprünglichen Arrays

        // Aufruf der Methode, um das Array mit Bubble Sort zu sortieren
        bubbleSort(groessen);

        System.out.println("\nNach dem Sortieren:");
        printArray(groessen); // Ausgabe des sortierten Arrays
    }

    // Methode zur Implementierung des Bubble Sort-Algorithmus
    public static void bubbleSort(int[] array) {

        int n = array.length; // Länge des Arrays (Anzahl der Kinder)

        // Äußere Schleife: Wiederholt den Sortiervorgang n-1 mal
        for (int i = 0; i < n - 1; i++) {

            // Innere Schleife: Vergleicht benachbarte Elemente und tauscht sie ggf.
            for (int j = 0; j < n - 1 - i; j++) {

                // Wenn das linke Kind größer ist als das rechte, tauschen sie Plätze
                if (array[j] > array[j + 1]) {

                    // Temporäre Variable, um den Tausch durchzuführen
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            // Nach jeder äußeren Iteration ist das größte Element am Ende
        }
    }

    // Hilfsmethode zur Ausgabe eines Arrays
    public static void printArray(int[] array) {
        for (int wert : array) {
            System.out.print(wert + " ");
        }
        System.out.println();
    }
}
