package it.epicode.eccezioni.esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Esercizio2 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio2.class);

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Inserisci i km percorsi (oppure 0 per terminare): ");
                double km = scanner.nextDouble();
                if (km == 0) {
                    logger.info("Programma terminato.");
                    break;
                }

                System.out.println("Inserisci i litri consumati: ");
                double litri = scanner.nextDouble();
                if (litri == 0) {
                    throw new ArithmeticException("Divisione per zero non consentita!");
                }

                double consumo = km / litri;
                logger.info("Calcolato consumo: {} km/l", consumo);
                System.out.printf("Consumo: %.2f km/l%n", consumo);

            } catch (ArithmeticException e) {
                logger.error("Errore: Divisione per zero!", e);
                System.out.println("Errore: Divisione per zero!");
            } catch (InputMismatchException e) {
                logger.error("Input non valido!", e);
                System.out.println("Errore: Devi inserire un numero.");
                scanner.next();
            }
        }
    }
}