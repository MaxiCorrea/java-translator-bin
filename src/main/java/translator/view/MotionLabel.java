package translator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MotionLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    static final Icon MINI_ICON = IconLoader.load(IconLocations.MINI_ICON);
    static final Icon CLOSE_ICON = IconLoader.load(IconLocations.CLOSE_ICON);

    private Point p1;
    private Point p2;
    private JLabel mini;
    private JLabel close;
    private JFrame mainFrame;

    public MotionLabel(JFrame mainFrame) {
        super(mainFrame.getTitle(), JLabel.LEFT);
        this.mainFrame = mainFrame;
        mainFrame.setTitle(mainFrame.getTitle());
        setForeground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(getLabelMini());
        add(getLabelClose());
        setPreferredSize(new Dimension(900, 40));
        addMouseListener();
        addMouseMotionListener();
    }

    private void addMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                p1 = new Point(e.getX(), e.getY());
            }
        });
    }

    private void addMouseMotionListener() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                p2 = MouseInfo.getPointerInfo().getLocation();
                mainFrame.setLocation(p2.x - p1.x, p2.y - p1.y);
            }
        });
    }

    JLabel getLabelClose() {
        if (close == null) {
            close = new JLabel();
            close.setIcon(CLOSE_ICON);
            close.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    closeFrame();
                    System.exit(0);
                }
            });
        }
        return close;
    }

    void closeFrame() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    JLabel getLabelMini() {
        if (mini == null) {
            mini = new JLabel();
            mini.setIcon(MINI_ICON);
            mini.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    iconifiedFrame();
                }
            });
        }
        return mini;
    }

    void iconifiedFrame() {
        mainFrame.setState(JFrame.ICONIFIED);
    }

}
