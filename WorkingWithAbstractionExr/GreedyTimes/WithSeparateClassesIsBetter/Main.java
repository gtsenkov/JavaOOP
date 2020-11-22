
package WorkingWithAbstractionExr.GreedyTimes.WithSeparateClassesIsBetter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");


        Bag bag = new Bag(capacity);


        for (int i = 0; i < input.length; i += 2) {
            String itemName = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            bag.fillBag(itemName, quantity);

        }
        System.out.println(Gold.getTotalGold());
        System.out.println(Gem.getTotalGems());
        System.out.println(Cash.getTotalCash());
        System.out.println();
        System.out.printf("");

        //.getClass.getSimpleName can give me MainTypeName = ClassName

//        for (var x : bag.entrySet()) {
//            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
//
//            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));
//
//            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
//
//        }
    }
}