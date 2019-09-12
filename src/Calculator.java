import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author wesle
 */
public class Calculator implements ActionListener {
    private static final JFrame FRAME = new JFrame("Simple Calculator");
    private static final JTextField FIRST_TEXT_FIELD = new JTextField(12);
    private static final JTextField SECOND_TEXT_FIELD = new JTextField(12);
    private static final JTextField RESULT_TEXT_FIELD = new JTextField(12);
    private static final JButton ADD = new JButton("ADD");
    private static final JButton SUBTRACT = new JButton("SUBTRACT");
    private static final JButton MULTIPLY = new JButton("MULTIPLY");
    private static final JButton DIVIDE = new JButton("DIVIDE");
    private static final JButton RESET = new JButton("RESET");
    private static final JButton QUIT = new JButton("QUIT");
    
    public static void main(String[] args) {
        simpleCalculator();
    }
    
    public static void simpleCalculator() {
        
        final JLabel firstNumber = new JLabel("First Number:     ");
        final JLabel secondNumber = new JLabel("Second Number:");
        final JLabel result = new JLabel("Result:  ");
        
        JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        content.setPreferredSize(new Dimension(300,320));
        content.add(firstNumber);
        content.add(FIRST_TEXT_FIELD);
        content.add(secondNumber);
        content.add(SECOND_TEXT_FIELD);
        content.add(result);
        content.add(RESULT_TEXT_FIELD);
        
        // To position buttons
        ADD.setPreferredSize(SUBTRACT.getPreferredSize());
        MULTIPLY.setPreferredSize(SUBTRACT.getPreferredSize());
        DIVIDE.setPreferredSize(SUBTRACT.getPreferredSize());
        RESET.setPreferredSize(SUBTRACT.getPreferredSize());
        QUIT.setPreferredSize(SUBTRACT.getPreferredSize());
        content.add(ADD);
        content.add(SUBTRACT);
        content.add(MULTIPLY);
        content.add(DIVIDE);
        content.add(RESET);
        content.add(QUIT);
        
        RESULT_TEXT_FIELD.setEditable(false);
        FRAME.setResizable(false);
        FRAME.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        FRAME.setContentPane(content);
        FRAME.pack();
        FRAME.setVisible(true);
        
        Calculator calc = new Calculator();
        ADD.addActionListener(calc);
        SUBTRACT.addActionListener(calc);
        MULTIPLY.addActionListener(calc);
        DIVIDE.addActionListener(calc);
        RESET.addActionListener(calc);
        QUIT.addActionListener(calc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double a;
        double b;
        double result;
        
        // TODO: adding events
        if (e.getSource() == ADD) {
            a = Double.parseDouble(FIRST_TEXT_FIELD.getText());
            b = Double.parseDouble(SECOND_TEXT_FIELD.getText());
            result = a + b;
            RESULT_TEXT_FIELD.setText(Double.toString(result));
        }
        if (e.getSource() == SUBTRACT) {
            a = Double.parseDouble(FIRST_TEXT_FIELD.getText());
            b = Double.parseDouble(SECOND_TEXT_FIELD.getText());
            result = a - b;
            RESULT_TEXT_FIELD.setText(Double.toString(result));
        }
        if (e.getSource() == MULTIPLY) {
            a = Double.parseDouble(FIRST_TEXT_FIELD.getText());
            b = Double.parseDouble(SECOND_TEXT_FIELD.getText());
            result = a * b;
            RESULT_TEXT_FIELD.setText(Double.toString(result));
        }
        if (e.getSource() == DIVIDE) {
            a = Double.parseDouble(FIRST_TEXT_FIELD.getText());
            b = Double.parseDouble(SECOND_TEXT_FIELD.getText());
            result = a / b;
            RESULT_TEXT_FIELD.setText(Double.toString(result));
        }
        if (e.getSource() == RESET) {
            FIRST_TEXT_FIELD.setText("");
            SECOND_TEXT_FIELD.setText("");
            RESULT_TEXT_FIELD.setText("");
        }
        if (e.getSource() == QUIT) {
            // To make an option pane message when closing.
            JOptionPane.showMessageDialog(FRAME, 
                        "This will terminate the program!");
            System.exit(0);
        }
    }
}
