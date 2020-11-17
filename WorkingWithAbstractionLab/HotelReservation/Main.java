package WorkingWithAbstractionLab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");


        PriceCalculator priceCalculator
                = new PriceCalculator(Season.valueOf(input[2].toUpperCase())
                , Discount.valueOf(input[3].toUpperCase()), Double.parseDouble(input[0]),
                Integer.parseInt(input[1]));

        System.out.println(String.format("%.2f",priceCalculator.calculatePrice()));
    }
}
