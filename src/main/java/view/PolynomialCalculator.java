package view;

import model.PolynCalcModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PolynomialCalculator extends JFrame{
    private JTextField FirstPolynomialTextField1 = new JTextField();
    private JTextField SecondPolynomialTextField2 = new JTextField() ;

    private JButton differentiateButton = new JButton("Derive");
    private JButton integrateButton = new JButton("Integrate");
    private JButton multiplyButton = new JButton("Multiply");
    private JButton subtractButton = new JButton("Subtract");
    private JButton addButton = new JButton("Add");
    private JButton divideButton = new JButton("Divide");
    private JButton clearButton = new JButton("Clear");
    private JTextField ResultTextField3 = new JTextField();
    private JLabel instructionsLabel = new JLabel();

    private PolynCalcModel polM;

    public PolynomialCalculator(PolynCalcModel model){
        this.setMinimumSize(new Dimension(500, 300));
        polM = model;
        polM.setValue(PolynCalcModel.init_val);

        ResultTextField3.setText(polM.getValue());
        ResultTextField3.setEditable(false);

        Font font = new Font("Times New Roman", Font.PLAIN, 10);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));


        JPanel firstLabel = new JPanel();
        firstLabel.add(new JLabel("First polynomial"));
        content.add(firstLabel);

        content.add(FirstPolynomialTextField1);

        JPanel secondLabel = new JPanel();
        secondLabel.add(new JLabel("Second polynomial"));
        content.add(secondLabel);

        content.add(SecondPolynomialTextField2);

        JPanel buttons1 = new JPanel();
        JPanel buttons2 = new JPanel();

        buttons1.setLayout(new FlowLayout());
        buttons1.add(addButton);
        buttons1.add(Box.createHorizontalStrut(30));
        buttons1.add(subtractButton);
        buttons1.add(Box.createHorizontalStrut(30));
        buttons1.add(multiplyButton);

        buttons2.setLayout(new FlowLayout());
        buttons2.add(divideButton);
        buttons2.add(Box.createHorizontalStrut(25));
        buttons2.add(differentiateButton);
        buttons2.add(Box.createHorizontalStrut(30));
        buttons2.add(integrateButton);

        JPanel singleBtn = new JPanel();
        singleBtn.add(clearButton);

        content.add(singleBtn);

        content.add(new JLabel("Result"));
        content.add(ResultTextField3);

        content.add(buttons1);
        content.add(buttons2);

        instructionsLabel = new JLabel("NOTE : input the operands as follows :ax^n + bx^(n-1) + ... + yx^1 + z (a,b,n.. integers)                                           ");
        instructionsLabel.setFont(font);
        instructionsLabel.setBounds(-500,10,10,100);
        content.add(instructionsLabel);

        this.setContentPane(content);

        this.pack();
        this.setTitle("Polynomial Calculator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() {
        FirstPolynomialTextField1.setText(PolynCalcModel.init_val);
        SecondPolynomialTextField2.setText(PolynCalcModel.init_val);
        ResultTextField3.setText("");
    }

    public String getUserInputFirstPolynomial() {
        return FirstPolynomialTextField1.getText();
    }

    public String getUserInputSecondPolynomial() {
        return SecondPolynomialTextField2.getText();
    }

    public void setResult(String result) {
        ResultTextField3.setText(result);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void addMultiplyListener(ActionListener mal) {
        multiplyButton.addActionListener(mal);
    }


    public void addSumListener(ActionListener mal) {
        addButton.addActionListener(mal);
    }

    public void addSubListener(ActionListener mal) {
        subtractButton.addActionListener(mal);
    }


    public void addClearListener(ActionListener mal) {
        clearButton.addActionListener(mal);
    }

    public void setSecondPolynomialTextField2(boolean b) {
        SecondPolynomialTextField2.setEditable(b);
    }



}

