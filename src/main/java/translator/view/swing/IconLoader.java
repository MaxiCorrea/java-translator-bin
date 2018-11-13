package translator.view.swing;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class IconLoader {

    private IconLoader() {
        throw new AssertionError("IconLoader is a utility class.");
    }

    static Icon load(String path) {
        return new ImageIcon(IconLoader.class.getClass().getResource(path));
    }

}
