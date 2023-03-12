package main;
import model.PolynCalcModel;
import controller.Controller;
import view.PolynomialCalculator;


public class Main {
    public static void main(String[] args){

        PolynCalcModel model = new PolynCalcModel();
        PolynomialCalculator view = new PolynomialCalculator(model);
        Controller controller = new Controller(model, view);

        view.setVisible(true);




}
}
