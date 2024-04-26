import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalcFunc implements ActionListener {
    private JTextField textField;
    private JButton[] num_buttons;
    private JButton[] symbol_buttons;
    private Stack<Character> Infix = new Stack<Character>();
    private Stack<Character> Operators = new Stack<Character>();
    private Stack<Character> Postfix = new Stack<Character>();
    String postfix;


    CalcFunc(JTextField textField, JButton[] num_buttons, JButton[] symbol_buttons) {
        this.textField = textField;
        this.num_buttons = num_buttons;
        this.symbol_buttons = symbol_buttons;
        for (JButton nb : this.num_buttons) {
            nb.addActionListener(this);
        }
        for (JButton sb : this.symbol_buttons) {
            sb.addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton nb : this.num_buttons) {
            if (e.getSource() == nb) {
                this.textField.setText(this.textField.getText().concat(nb.getText()));
            }
        }
        for (JButton sb : this.symbol_buttons) {
            if (e.getSource() == this.symbol_buttons[0]) {
                this.textField.setText("");
                break;
            }
            if (e.getSource() == this.symbol_buttons[9]) {
                System.out.println(this.textField.getText().length());
                postfix = to_postfix(this.textField.getText());
                this.textField.setText("" + postfix);
                postfix="";
                break;
            }
            if (e.getSource() == sb && sb.getText() != "=") {
                this.textField.setText(this.textField.getText().concat(sb.getText()));
            }
        }

    }

    private int precedence(Character c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String to_postfix(String x) {
        Character c;
        String s = "";
//Copy every character to Infix Stack
        for (int i = 0; i < x.length(); i++) {
            Infix.push(x.charAt(i));
        }
// Run the algorithm for Infix to Postfix
        for (Character chr : Infix) {
//Check if the character is a digit
            if (Character.isDigit(chr)) {
                Postfix.push(chr);
            }
//Else do the necessary operators checking
            else {
                if (Operators.empty() || (precedence(chr) > precedence(Operators.peek())) || (chr == '(')) {
                    Operators.push(chr);
                } else if (chr == ')') {
                    while ((c = Operators.peek()) != '(') {
                        Postfix.push(c);
                        Operators.pop();
                    }
                    Operators.pop();
                } else if (precedence(chr) < precedence(Operators.peek())) {
                    while (precedence(chr) < precedence(Operators.peek())) {
                        Postfix.push(Operators.peek());
                        Operators.pop();
                    }
                    Operators.push(chr);
                }
            }
//Print the stacks
            System.out.println("Infix:"+Infix);
            System.out.println("Operators:"+Operators);
            System.out.println("Postfix:"+Postfix);

        }
//Push to Postfix and pop from Operators until operators is empty
        while (!Operators.empty()) {
            Postfix.push(Operators.peek());
            Operators.pop();
        }
        s="";
//Copy Postfix elements to String s
        for (Character character : Postfix) {
            s += character;
        }
//Clear all the stacks
        Infix.clear();
        Postfix.clear();
        Operators.clear();
//Return the String
        return s;
    }
}
