package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class WordCount {

    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private JButton button;
    private JLabel label;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new WordCount();
            }
        });
    }

    public WordCount() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        frame.add(panel_1, BorderLayout.SOUTH);

        button = new JButton("Count Words");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        panel_1.add(button);

        label = new JLabel("Total words: ");
        panel_1.add(label);

        frame.setVisible(true);
    }

    private void countWords() {
        String input = textArea.getText();
        if (input.isEmpty()) {
            label.setText("Total words: ");
            return;
        }
        String[] words = input.split("\\s+");
        label.setText("Total words: " + words.length);
    }
}
