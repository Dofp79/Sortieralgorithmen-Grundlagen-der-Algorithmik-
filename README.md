Sortieralgorithmen – Grundlagen der Algorithmik

Dieses Repository enthält einfache und klassische Implementierungen grundlegender Sortieralgorithmen in Java.
Es dient als Lern- und Übungsmaterial für Studierende, Entwicklerinnen und Entwickler sowie alle Interessierten an Algorithmik und Datenstrukturen.

---

Enthaltene Algorithmen:

- Bubble Sort
  Komplexität (Worst Case): O(n²)
  Eigenschaften: Sehr einfach, ineffizient

- Insertion Sort
  Komplexität (Worst Case): O(n²)
  Eigenschaften: Gut für kleine oder fast sortierte Daten

- Selection Sort
  Komplexität (Worst Case): O(n²)
  Eigenschaften: Immer gleiche Anzahl von Vergleichen

- Merge Sort
  Komplexität (Worst Case): O(n log n)
  Eigenschaften: Stabil, teilt die Daten rekursiv

- Quick Sort
  Komplexität (ø Durchschnitt: O(n log n), Worst Case: O(n²)
  Eigenschaften: Sehr schnell im Durchschnitt, nicht stabil

---

Projektstruktur:

/Sortieralgorithmen-Grundlagen-der-Algorithmik
 ├── BubbleSort.java
 ├── InsertionSort.java
 ├── MergeSort.java
 ├── QuickSort.java
 ├── SelectionSort.java
 └── README.txt

---

Wie du die Algorithmen ausprobierst:

1. Repository klonen:
   git clone https://github.com/DEINUSERNAME/Sortieralgorithmen-Grundlagen-der-Algorithmik.git

2. Java-Datei kompilieren:
   javac BubbleSort.java

3. Ausführen:
   java BubbleSort

(Alle Java-Dateien enthalten eine main()-Methode zum direkten Starten.)

---

Lernziele:

- Verständnis für Vergleiche, Tauschoperationen und Rekursion
- Analyse von Laufzeiten und Komplexität
- Vergleich von stabilen und instabilen Algorithmen
- Einsatzbereiche je nach Problemstellung (kleine Listen vs. große Datenmengen)

---

Optionale Erweiterungen:

- Implementiere weitere Algorithmen wie HeapSort, ShellSort, CountingSort
- Zeitmessungen einbauen (z. B. mit System.nanoTime())
- Sortierprozesse grafisch visualisieren (z. B. mit JavaFX)

---

Lizenz:

Dieses Projekt steht unter der MIT-Lizenz – freie Verwendung für Lern- und Lehrzwecke.

---

Autor:
Dofp79
