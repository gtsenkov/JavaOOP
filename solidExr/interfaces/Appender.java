package solidExr.interfaces;

import solidExr.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    ReportLevel getReportLevel();
}
