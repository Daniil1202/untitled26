
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    static Random random;
    static Map<Integer, Boolean> res1;
    static Map<Integer, Boolean> res2;
    static int doorsNumber;
    static int attempts;


    public static void main(String[] args) {
        random = new Random();
        res1 = new HashMap<>();
        res2 = new HashMap<>();
        doorsNumber = 3;
        attempts = 1000;

        for (int i = 0; i < attempts; i++) {
            trails(i);

        }
        int win = 0;
        for (Map.Entry<Integer, Boolean> entry : res1.entrySet()) {
            if (entry.getValue()) {
                win++;
            }

        }
        System.out.println("\n статистика выигрышей для игрока, изменяющего свой выбор :");
        System.out.println("Количество побед : " + win + " раз(а) из " + attempts + " попыток");


        win = 0;
        for (Map.Entry<Integer, Boolean> entry : res2.entrySet()) {
            if (entry.getValue()) {
                win++;
            }
        }
        System.out.println("\n Статистика выигрышей для игрока, изменяющего свой выбор:");
        System.out.println("Количество побед: " + win + " раз(а) из " + attempts + " попыток.");

    }

    private static void trails(int numRound) {
        int success = random.nextInt(doorsNumber);
        int firstChoice = random.nextInt(doorsNumber);
        int freeOpenDoor = -1;
        int secondChoice = -1;

        for (int i = 0; i < doorsNumber; i++) {
            if (i != success && i != firstChoice) {
                freeOpenDoor = i;
            }

        }
        for (int i = 0; i < doorsNumber; i++) {
            if (i != freeOpenDoor && i != firstChoice) {
                secondChoice = firstChoice;

            }
        }
        res1.put(numRound, success == secondChoice);

        for (int i = 0; i < doorsNumber; i++) {
            if (i != freeOpenDoor && i != firstChoice) {
                secondChoice = i;

            }

        }
        res2.put(numRound, success == secondChoice);
    }
}