import javax.swing.*;
import java.awt.*;

public class CalcGUI extends JFrame {
    private JPanel txt_panel;
    private JTextField textField;
    private JPanel buttons_panel;
    int find = 7;
    CalcFunc cf;
    Color pink = new Color(0xFFFC848E, true);
    Color lightpink = new Color(0xFFBBBB);
    Color orange = new Color(0xF09204);
    JButton[] num_buttons = new JButton[10];
    JButton[] symbol_buttons = new JButton[10];
    String[] symbols = {"C", "(", ")", "/", "*", "-", "+", "="};

    CalcGUI() {
        setLayout(new BorderLayout(0, 0));
        txt_panel = new JPanel();
        textField = new JTextField(29);
        txt_panel.add(textField);
        add(txt_panel, BorderLayout.NORTH);
        buttons_panel = new JPanel();
        buttons_panel.setLayout(new GridLayout(5, 4));
        for (int i = 0; i < 10; i++) {
            num_buttons[i] = new JButton("" + i);
        }

        for (int i = 0; i < 4; i++) {
            symbol_buttons[i] = new JButton("" + symbols[i]);
            buttons_panel.add(symbol_buttons[i]);
        }

        for (int j = 4; j < 7; j++) {
            for (int k = 0; k < 3; k++) {
                buttons_panel.add(num_buttons[find++]);
            }
            find -= 6;
            symbol_buttons[j] = new JButton("" + symbols[j]);
            buttons_panel.add(symbol_buttons[j]);
        }
        buttons_panel.add(num_buttons[0]);
        symbol_buttons[7] = new JButton(".");
        buttons_panel.add(symbol_buttons[7]);
        symbol_buttons[8] = new JButton("^");
        buttons_panel.add(symbol_buttons[8]);
        symbol_buttons[9] = new JButton("=");
        buttons_panel.add(symbol_buttons[9]);
        add(buttons_panel);
        for (JButton x : num_buttons) {
            x.setBackground(lightpink);
            x.setBorder(BorderFactory.createLineBorder(lightpink));
            x.setOpaque(true);
            x.setFont(new Font("Product-Sans", Font.BOLD, 20));
        }


        for (JButton x : symbol_buttons) {
            x.setBackground(pink);
            x.setBorder(BorderFactory.createLineBorder(pink));
            x.setOpaque(true);
            x.setFont(new Font("Product-Sans", Font.BOLD, 20));
        }

        symbol_buttons[7].setBackground(lightpink);
        symbol_buttons[7].setBorder(BorderFactory.createLineBorder(lightpink));
        symbol_buttons[8].setBackground(lightpink);
        symbol_buttons[8].setBorder(BorderFactory.createLineBorder(lightpink));
        symbol_buttons[9].setBackground(orange);
        symbol_buttons[9].setBorder(BorderFactory.createLineBorder(orange));

        cf=new CalcFunc(textField,num_buttons,symbol_buttons);

        setVisible(true);
        setTitle("[ECE_Y325] Week 9");
        setSize(350, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}
