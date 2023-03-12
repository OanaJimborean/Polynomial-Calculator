package controller;

import model.PolynCalcModel;
import view.PolynomialCalculator;
import java.awt.event.*;

public class Controller {
    private PolynCalcModel Pmodel;
    private PolynomialCalculator Pview;

    public Controller(PolynCalcModel model, PolynomialCalculator view) {

        Pmodel = model;
        Pview = view;
        view.addMultiplyListener(new MultiplyListener()) ;
        view.addSumListener(new SumListener());
        view.addSubListener(new SubListener());
        view.addClearListener(new ClearListener());
    }

    class SumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstPolyn = "";
            String secondPolyn = "";
            try {
                firstPolyn = Pview.getUserInputFirstPolynomial();
                secondPolyn = Pview.getUserInputSecondPolynomial();

                Pmodel.addition(firstPolyn, secondPolyn);

                Pview.setResult(Pmodel.getValue());
                Pview.setSecondPolynomialTextField2(true);

            } catch (Exception err) {
                Pview.showError(err.getMessage());

            }
        }
    }
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstPolyn = "";
            String secondPolyn = "";
            try {
                firstPolyn = Pview.getUserInputFirstPolynomial();
                secondPolyn = Pview.getUserInputSecondPolynomial();

                Pmodel.subtraction(firstPolyn, secondPolyn);
                Pview.setResult(Pmodel.getValue());
                Pview.setSecondPolynomialTextField2(true);

            } catch (Exception err) {
                Pview.showError(err.getMessage());

            }
        }
    }
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstPolyn = "";
            String secondPolyn = "";
            try {
                firstPolyn = Pview.getUserInputFirstPolynomial();
                secondPolyn = Pview.getUserInputSecondPolynomial();

                Pmodel.multiplication(firstPolyn, secondPolyn);

                Pview.setResult(Pmodel.getValue());

                Pview.setSecondPolynomialTextField2(true);

            } catch (Exception err) {
                Pview.showError(err.getMessage());

            }
        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Pview.reset();
            Pmodel.reset();
            Pview.setSecondPolynomialTextField2(true);
        }
    }

}
