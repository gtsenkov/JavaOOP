package solidExr;

import solidExr.controllers.AppenderCreator;
import solidExr.controllers.ConsoleAppender;
import solidExr.controllers.LayoutCreator;
import solidExr.controllers.SimpleLayout;
import solidExr.enums.ReportLevel;
import solidExr.interfaces.Appender;
import solidExr.interfaces.AppenderFactory;
import solidExr.interfaces.Layout;
import solidExr.interfaces.LayoutFactory;
import solidExr.logger.Logger;
import solidExr.logger.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        AppenderFactory appenderFactory = new AppenderCreator();
        LayoutFactory layoutFactory = new LayoutCreator();

        Logger logger = new MessageLogger();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            ReportLevel reportLevel = tokens.length == 3
                ? ReportLevel.valueOf(tokens[2].toUpperCase())
                : ReportLevel.INFO;

            Appender appender = appenderFactory.produce(tokens[0], reportLevel, layoutFactory.produce(tokens[1]));

            logger.addAppender(appender);
        }

        String input = scan.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String date = tokens[1];
            String message = tokens[2];

            switch (reportLevel) {
                case INFO:
                    logger.logInfo(date, message);
                    break;
                case WARNING:
                    logger.logWarning(date, message);
                    break;
                case ERROR:
                    logger.logError(date, message);
                    break;
                case CRITICAL:
                    logger.logCritical(date, message);
                    break;
                case FATAL:
                    logger.logFatal(date, message);
                    break;
                default:
                    throw new IllegalStateException("Unknown enum value for " + reportLevel);
            }

            input = scan.nextLine();
        }

        System.out.println(logger.toString());
    }
}
