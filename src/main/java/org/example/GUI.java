package org.example;

import org.example.DataModels.Polynomial;
import org.example.Operations.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    private JLabel title = new JLabel("Polynomial Calculator ");

    private JLabel note = new JLabel("Notă:Introduceți un polinom de forma:ax^n+bx^(n-1)+...(a,b,c,n întregi) ");
    private JTextField firstPolynomial = new JTextField(10);
    private JLabel polynomialtext1 = new JLabel("First Polynomial(P1):");
    private JTextField secondPolynomial = new JTextField(10);
    private JLabel polynomialtext2 = new JLabel("Second Polynomial(P2):");
    private JTextField result = new JTextField(10);
    private JLabel resultLabel = new JLabel("Result:");


    private JButton clearButton = new JButton("Clear");

    private JButton addButton = new JButton("Add");

    private JButton subButton = new JButton("Substract P1-P2");

    private JButton derivButton = new JButton("Derive P1");

    private JButton mulButton = new JButton("Multiplicate");

    private JButton divButton = new JButton("Divide ");

    private JButton integButton = new JButton("Integrate P1");


    public GUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(425, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.orange);

        title.setBounds(140, 0, 200, 50);

        note.setBounds(0,400,400,50);

        polynomialtext1.setBounds(0, 50, 140, 20);
        firstPolynomial.setBounds(150, 50, 200, 20);

        polynomialtext2.setBounds(0, 100, 140, 20);
        secondPolynomial.setBounds(150, 100, 200, 20);

        resultLabel.setBounds(0, 150, 140, 20);
        result.setBounds(150, 150, 200, 20);

        addButton.setBounds(25, 200, 130, 40);
        subButton.setBounds(200, 250, 130, 40);
        divButton.setBounds(25, 300, 130, 40);
        integButton.setBounds(200, 200, 130, 40);
        derivButton.setBounds(25, 250, 130, 40);
        mulButton.setBounds(200, 300, 130, 40);
        clearButton.setBounds(25, 350, 130, 40);


        frame.add(firstPolynomial);
        frame.add(polynomialtext1);
        frame.add(secondPolynomial);
        frame.add(polynomialtext2);
        frame.add(title);
        frame.add(result);
        frame.add(resultLabel);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(divButton);
        frame.add(integButton);
        frame.add(derivButton);
        frame.add(mulButton);
        frame.add(clearButton);
        frame.add(note);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        integButton.addActionListener(this);
        derivButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addButton) {
                Polynomial p1 = new Polynomial(firstPolynomial.getText());
                Polynomial p2 = new Polynomial(secondPolynomial.getText());
                Polynomial res = Operation.additional(p1, p2);
                result.setText(res.toString());
            }

            if (e.getSource() == subButton) {
                Polynomial p1 = new Polynomial(firstPolynomial.getText());
                Polynomial p2 = new Polynomial(secondPolynomial.getText());
                Polynomial res = Operation.substraction(p1, p2);
                result.setText(res.toString());
            }

            if (e.getSource() == derivButton) {
                Polynomial p = new Polynomial(firstPolynomial.getText());
                Polynomial res = Operation.derivative(p);
                result.setText(res.toString());
            }

            if (e.getSource() == integButton) {
                Polynomial p1 = new Polynomial(firstPolynomial.getText());
                Polynomial res = Operation.integrate(p1);
                result.setText(res.toString());
            }

            if (e.getSource() == clearButton) {
                firstPolynomial.setText("");
                secondPolynomial.setText("");
                result.setText("");

            }

            if (e.getSource() == mulButton) {
                Polynomial p1 = new Polynomial(firstPolynomial.getText());
                Polynomial p2 = new Polynomial(secondPolynomial.getText());
                Polynomial res = Operation.multiplication(p1, p2);
                result.setText(res.toString());
            }

            if (e.getSource() == divButton) {
                Polynomial p1 = new Polynomial(firstPolynomial.getText());
                Polynomial p2 = new Polynomial(secondPolynomial.getText());
                Polynomial res = Operation.multiplication(p1, p2);
                result.setText(res.toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

}