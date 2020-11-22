
package WorkingWithAbstractionExr.GreedyTimes.GeneralClassTrial;

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

            if (bag.fillBag(itemName)) {
                continue;
            }

            Item item = new Item(itemName, quantity);

            if (item.getCanNotBeAdded()) {
                continue;
            }

            if (bag.getConsistency().containsKey(item.getMainType())) {
                if (bag.getCapacity() < item.getAbsoluteTotalQuantity() + item.getSubQuantity()) {
                    continue;
                }

                if (bag.getConsistency().containsKey(item.getMainType())) {
                    bag.getItems().add(item);
                }
                bag.getConsistency().put(bag.getMainType(), bag.getItems());

            }



        }
        System.out.println();
        System.out.printf("");

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