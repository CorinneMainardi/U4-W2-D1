package it.epicode.eccezioni.esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);

    public void run() {
        int[] array = new int[5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        logger.info("Array iniziale generato");

        while (true) {
            try {
                System.out.println("Inserisci l'indice (0-4) da aggiornare (oppure 0 per terminare): ");
                int indice = scanner.nextInt();
                if (indice == 0) {
                    logger.info("Programma terminato dall'utente.");
                    break;
                }

                System.out.println("Inserisci il nuovo valore: ");
                int valore = scanner.nextInt();

                array[indice] = valore;
                logger.debug("Aggiornato indice {} con valore {}", indice, valore);
                stampaArray(array);

            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("Indice fuori dai limiti!", e);
                System.out.println("Errore: Indice fuori dai limiti!");
            } catch (InputMismatchException e) {
                logger.error("Input non valido!", e);
                System.out.println("Errore: Devi inserire un numero.");
                scanner.next();
            }
        }
    }

    private void stampaArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}