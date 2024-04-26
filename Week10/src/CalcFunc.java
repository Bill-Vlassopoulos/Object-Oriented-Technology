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
    Character[] operators = {'+', '-', '*', '^', '/'};
    String postfix, result;


    CalcFunc(JTextField textField, JButton[] num_buttons, JButton[] symbol_buttons) {
        this.textField = textField;
        this.num_buttons = num_buttons;
        this.symbol_buttons = symbol_buttons;
//We add actionListeners to all the buttons
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
                result = calculate_postfix(postfix);
                this.textField.setText("" + result);
                result = "";
                postfix = "";
                break;
            }
            if (e.getSource() == sb && sb.getText() != "=") {
                this.textField.setText(this.textField.getText().concat(sb.getText()));
            }
        }

    }

    //Method that checks the precedence of the operators
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

    //Method that converts Infix to Postfix and returns the result as a string
    public String to_postfix(String x) {
        Character c;
        String s = "";
//Copy every character to Infix Stack
        for (int i = 0; i < x.length(); i++) {
            if (Character.isDigit(x.charAt(i)) || x.charAt(i) == '.' || x.charAt(i) == '(')
                Infix.push(x.charAt(i));
            else {
                Infix.push(' ');
                Infix.push(x.charAt(i));
            }
        }
// Run the algorithm for Infix to Postfix
        for (Character chr : Infix) {
//Check if the character is a digit
            if (Character.isDigit(chr) || chr == '.' || chr == ' ') {
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
            System.out.println("Infix:" + Infix);
            System.out.println("Operators:" + Operators);
            System.out.println("Postfix:" + Postfix);
            System.out.println("");

        }
//Push to Postfix and pop from Operators until Operators is empty
        while (!Operators.empty()) {
            Postfix.push(Operators.peek());
            Operators.pop();
        }
        s = "";
//Copy Postfix elements to String s
        for (Character character : Postfix) {
            s += character;
        }
//Clear all the stacks

//Return the String
        return s;
    }

    //Method that converts Postfix to the final result
    public String calculate_postfix(String x) {
        Stack<Character> final_res = new Stack<>();
        String[] num = {"", ""};
        String res = new String();
        for (Character c : Postfix) {
            if (Character.isDigit(c) || c == '.' || c == ' ') {
                final_res.push(c);
            } else {
                for (int i = 0; i < 2; i++) {
                    while (!final_res.empty() && final_res.peek() != ' ') {
                        num[i] += final_res.pop();
                        System.out.println(num[i]);
                    }
                    if (!final_res.empty()) {
                        final_res.pop();
                    }
                }
                final_res.push(' ');
                res = evaluate(c, Double.parseDouble(num[0]), Double.parseDouble(num[1]));
                for (int i = 0; i < res.length(); i++) {
                    final_res.push(res.charAt(i));
                }
                res = "";
            }
        }
        for (Character c : final_res) {
            res += c;
        }
        Infix.clear();
        Postfix.clear();
        Operators.clear();
        final_res.clear();
        return res;
    }

    public String evaluate(Character oprt, Double num1, Double num2) {
        String result = new String();
        switch (oprt) {
            case '+':
                result = Double.toString(num1 + num2);
                break;
            case '-':
                result = Double.toString(num1 - num2);
                break;
            case '*':
                result = Double.toString(num1 * num2);
                break;
            case '/':
                result = Double.toString(num1 / num2);
                break;
            case '^':
                result = Double.toString(num1.intValue() ^ num2.intValue());
                break;

        }
        return result;
    }
}
