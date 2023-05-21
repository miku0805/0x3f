package dl;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class qq extends JFrame {
    private JPanel panel;
    private JTextField qqNumField;

    public qq() {
        setTitle("QQ号录入");
        setSize(300, 100);
        setLocationRelativeTo(null);

        panel = new JPanel();
        qqNumField = new JTextField(20);
        qqNumField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();
                if (inputChar<'0' || inputChar>'9') {
                    e.consume();
                }
            }
        });
        panel.add(qqNumField);
        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new qq();
    }
}