package it.epicode.eccezioni.esercizio0;

public class DebugExercise {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            System.out.println("Index: " + i + ", Value: " + numbers[i] + ", Sum: " + sum);
        }

        System.out.println("Final Sum: " + sum);
    }
}