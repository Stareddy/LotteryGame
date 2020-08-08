import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Starter {

    public static List<Long> numbersPerCube = new ArrayList<>();

    public static List<Long> lotteryTicketNumber = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Wie viele Lotterielose möchten Sie spielen?");
        Scanner sc1 = new Scanner(System.in);
        long lotteryTicketCount = sc1.nextLong();

        System.out.println("Wie viele felder möchten Sie spielen?");
        Scanner sc2 = new Scanner(System.in);
        long lotteryTicketCubesCount = sc2.nextLong() + 1;

        for (int upperLoop = 0; upperLoop < lotteryTicketCount; upperLoop++) {
            long leftLimit = 0L;
            long rightLimit = 10L;
            long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            if (lotteryTicketNumber.contains(generatedLong))
                upperLoop = upperLoop - 1;
            else {
                lotteryTicketNumber.add(generatedLong);

                System.out.print("Lotterielosnummer: " + lotteryTicketNumber.get(upperLoop));
                System.out.print("\n");
                for (int loop = 1; loop < lotteryTicketCubesCount; loop++) {
                    for (int i = 1; i < 7; i++) {
                        long leftLimit1 = 1L;
                        long rightLimit1 = 49L;
                        long generatedLong1 = leftLimit1 + (long) (Math.random() * (rightLimit1 - leftLimit1));

                        if (numbersPerCube.contains(generatedLong1))
                            i = i - 1;
                        else {
                            numbersPerCube.add(generatedLong1);
                        }
                    }
                    List<Long> list = numbersPerCube.stream().sorted().collect(Collectors.toList());
                    System.out.print("Feld Nummer: " + loop + " -> Zahlen: " + list);
                    numbersPerCube.clear();
                    System.out.print("\n" + "---------------------------------------------------" + "\n");
                }
                System.out.print("\n");
            }
        }
        System.out.println("Anzahl der Spiellose: " + lotteryTicketNumber.size());
    }
}
