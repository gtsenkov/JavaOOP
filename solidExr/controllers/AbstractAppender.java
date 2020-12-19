package solidExr.controllers;

import solidExr.enums.ReportLevel;
import solidExr.interfaces.Appender;
import solidExr.interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private ReportLevel reportLevel;
    private Layout layout;
    private int appendsCount;

    public AbstractAppender(ReportLevel reportLevel, Layout layout) {
        this.reportLevel = reportLevel;
        this.layout = layout;
    }

    public AbstractAppender(Layout layout) {
        this(ReportLevel.INFO, layout);
    }

    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Appender type: ");
        builder.append(this.getType())
                .append(", Layout type: ")
                .append(this.layout.getType())
                .append(", ")
                .append(String.format("Report level: %s, ", this.getReportLevel().toString()))
                .append("Messages appended: ")
                .append(this.appendsCount);

        return builder.toString();
    }

    protected void incrementAppendsCount() {
        this.appendsCount++;
    }
}
