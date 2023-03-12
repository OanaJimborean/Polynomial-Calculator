package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class PolynUtilModel {

    public Polynomial parsePolynomial(String input) throws Exception {

        Polynomial res = new Polynomial();
        PolynUtilModel util = new PolynUtilModel();

        input = input.replaceAll(" ", "");
        String[] monomArray = util.divideString(input);
        for (String monom : monomArray) {
            Monomial m;
            try {
                if (!monom.equals("")) {
                    if (monom.charAt(0) == '-') {
                        m = util.matchPattern(monom.substring(1));
                        m.setCoeff(-m.getCoeff());
                    } else {

                        m = util.matchPattern(monom);
                    }

                    res.addMonom(m);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "The input is invalid. Provide valide data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                throw new Exception("");
            }
        }
        return res;
    }


    private String[] divideString(String input) {
        input = input.replaceAll("-", "+-");
        String[] monomArray = input.split("(\\+)");

        return monomArray;
    }

    private Monomial matchPattern(String s) throws Exception {
        String pattern[] = new String[7];

        pattern[0] = "(^\\d+)(\\*)(x)(\\^)(\\d+$)";
        pattern[1] = "(^\\d+)(x)(\\^)(\\d+$)";
        pattern[2] = "(^x)(\\^)(\\d+$)";
        pattern[3] = "(^\\d+)(\\*)(x$)";
        pattern[4] = "(^\\d+)(x$)";
        pattern[5] = "(^x$)";
        pattern[6] = "(^\\d+$)";

        int i = 0;
        Pattern pattern1 = Pattern.compile(pattern[0]);
        Matcher match = pattern1.matcher(s);
        for (i = 0; i < 7; i++) {
            pattern1 = Pattern.compile(pattern[i]);
            match = pattern1.matcher(s);
            if (match.find()) {
                break;
            }
        }
        Monomial newM = new Monomial();
        if (i >= 7) {
            throw new Exception("The input is invalid. Provide valid data!");
        } else {
            switch (i) {
                case 0:
                    newM.setExp(Integer.parseInt(match.group(5)));
                    newM.setCoeff(Integer.parseInt(match.group(1)));
                    break;
                case 1:
                    newM.setExp(Integer.parseInt(match.group(4)));
                    newM.setCoeff(Integer.parseInt(match.group(1)));
                    break;
                case 2:
                    newM.setExp(Integer.parseInt(match.group(3)));
                    newM.setCoeff(1);
                    break;
                case 3:
                    newM.setExp(1);
                    newM.setCoeff(Integer.parseInt(match.group(1)));
                    break;

                case 4:
                    newM.setExp(1);
                    newM.setCoeff(1);
                    break;
                case 5:
                    newM.setExp(1);
                    newM.setCoeff(Integer.parseInt(match.group(1)));
                    break;
                case 6:
                    newM.setExp(0);
                    newM.setCoeff(Integer.parseInt(match.group(1)));
                    break;
            }

        }
        return newM;
    }}

