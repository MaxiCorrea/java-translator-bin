package translator.view;

import translator.controller.Controller;

import javax.swing.*;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

import java.awt.*;

public class ViewImpl extends JFrame implements View {

    private static final String TITLE_APP = "Translation of Binary to Text";
    private static final int W_FRAME = 900;
    private static final int H_FRAME = 500;

    private JTextArea textArea;
    private JButton toBinaryButton;
    private JButton toAnciiButton;

    public ViewImpl() {
        super(TITLE_APP);
        setSize(W_FRAME, H_FRAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addNorthPane();
        addCenterPane();
        addSouthPane();
    }

    private void addNorthPane() {

    }

    private void addCenterPane() {
        JPanel pane = new JPanel();
        textArea = new JTextArea();
        int width = W_FRAME -20;
        int height = H_FRAME -20;
        Dimension size = new Dimension(width,height);
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
        toBinaryButton = new JButton("Text to Binary");
        pane.add(toBinaryButton);
        toAnciiButton = new JButton("Binary to Text");
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