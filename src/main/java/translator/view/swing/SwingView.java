package translator.view.swing;

import translator.controller.Controller;
import translator.view.View;

import javax.swing.*;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

import java.awt.*;

public class SwingView extends JFrame implements View {

    private static final String TITLE_APP = "  Translation of Binary to Text";
    private static final int W_FRAME = 900;
    private static final int H_FRAME = 500;

    private JTextArea textArea;
    private JButton toBinaryButton;
    private JButton toAnciiButton;

    public SwingView() {
        super(TITLE_APP);
        setSize(W_FRAME, H_FRAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addNorthPane();
        addCenterPane();
        addSouthPane();
        setUndecorated(true);
    }

    private void addNorthPane() {
        JPanel pane = new JPanel();
        pane.setBackground(Color.BLUE);
        pane.add(new MotionLabel(this));
        add(pane,BorderLayout.NORTH);
    }

    private void addCenterPane() {
        JPanel pane = new JPanel();
        textArea = new JTextArea();
        int width = W_FRAME -40;
        int height = H_FRAME -30;
        Dimension size = new Dimension(width,height);
        Font font = textArea.getFont();
        textArea.setFont(font.deriveFont(24f));
        textArea.setPreferredSize(size);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        pane.add(textArea);
        JScrollPane scroll = new JScrollPane(pane);
        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);
    }

    private void addSouthPane() {
        JPanel pane = new JPanel();
        pane.setBackground(Color.BLUE);
        toBinaryButton = new JButton("Text to Binary");
        toBinaryButton.setBackground(Color.WHITE);
        toBinaryButton.setBorderPainted(false);
        toBinaryButton.setFocusPainted(false);
        toBinaryButton.setForeground(Color.BLUE);
        pane.add(toBinaryButton);
        toAnciiButton = new JButton("Binary to Text");
        toAnciiButton.setBackground(Color.WHITE);
        toAnciiButton.setForeground(Color.BLUE);
        toAnciiButton.setBorderPainted(false);
        toAnciiButton.setFocusPainted(false);
        pane.add(toAnciiButton);
        add(pane , BorderLayout.SOUTH);
    }

    @Override
    public void setController(Controller controller) {
        toBinaryButton.addActionListener((event) -> {
            controller.translateToBinaryAction();
        });
        toAnciiButton.addActionListener((event) -> {
            controller.translateToASCIIAction();
        });
    }

    @Override
    public String getText() {
        return textArea.getText();
    }

    @Override
    public void showResult(String result) {
        textArea.setText(result);
    }

    @Override
    public void open() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

}