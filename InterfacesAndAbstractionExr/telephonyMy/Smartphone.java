package InterfacesAndAbstractionExr.telephonyMy;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            boolean isCorrect = true;
            for (int i = 0; i < url.length(); i++) {
                char current = url.charAt(i);
                if (Character.isDigit(current)) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                builder.append("Browsing: ").append(url).append("!");
            } else {
                builder.append("Invalid URL!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            boolean isCorrect = true;
            for (int i = 0; i < number.length(); i++) {
                char current = number.charAt(i);
                if (!Character.isDigit(current)) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                builder.append("Calling... ").append(number);
            } else {
                builder.append("Invalid number!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
