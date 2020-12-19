package solidExr.controllers;

import solidExr.interfaces.Appender;
import solidExr.interfaces.AppenderFactory;
import solidExr.interfaces.Layout;
import solidExr.interfaces.LayoutFactory;

public class LayoutCreator implements LayoutFactory {
    @Override
    public Layout produce(String type) {
        Layout layout;
        switch (type) {
            case "SimpleLayout":
                layout = new SimpleLayout();
                break;
            case "XmlLayout":
                layout = new XmlLayout();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return layout;
    }
}
