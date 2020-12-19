package solidExr.interfaces;

import solidExr.enums.ReportLevel;

public interface AppenderFactory {
    Appender produce(String type, ReportLevel reportLevel, Layout layout);

}
