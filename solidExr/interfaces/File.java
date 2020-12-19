package solidExr.interfaces;

import solidExr.enums.ReportLevel;

public interface File {
    void write(String text);

    int getSize();
}
