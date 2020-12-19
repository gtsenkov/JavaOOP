package solidExr.controllers;

import solidExr.enums.ReportLevel;
import solidExr.interfaces.Appender;
import solidExr.interfaces.AppenderFactory;
import solidExr.interfaces.Layout;

public class AppenderCreator implements AppenderFactory {
    @Override
    public Appender produce(String type, ReportLevel reportLevel, Layout layout) {
        Appender appender;
         switch (type) {
            case "ConsoleAppender":
                appender = new ConsoleAppender(reportLevel, layout);
                break;
             case "FileAppender":
                 appender = new FileAppender(reportLevel, layout);
                 break;
             default:
                 throw new IllegalStateException("Unexpected value: " + type);
         }
        return appender;
    }
}
