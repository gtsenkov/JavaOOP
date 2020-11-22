
package WorkingWithAbstractionExr.GreedyTimes.ToRefactor;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainRefactored {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
//        long gold = 0;
//        long gem = 0;
//        long cash = 0;

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            String itemIs = "";

            if (item.length() == 3) {
                itemIs = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                itemIs = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                itemIs = "Gold";
            }

            if (itemIs.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values)
                    .flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (itemIs) {
                case "Gem":
                    if (!bag.containsKey(itemIs)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        }else {
                            continue;
                        }
                    } else if (bag.get(itemIs).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemIs)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemIs).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemIs)) {
                bag.put((itemIs), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemIs).containsKey(item)) {
                bag.get(itemIs).put(item, 0L);
            }


            bag.get(itemIs).put(item, bag.get(itemIs).get(item) + quantity);
//            if (itemIs.equals("Gold")) {
//                gold += quantity;
//            } else if (itemIs.equals("Gem")) {
//                gem += quantity;
//            } else if (itemIs.equals("Cash")) {
//                cash += quantity;
//            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}