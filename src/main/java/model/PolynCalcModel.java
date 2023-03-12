package model;

public class PolynCalcModel {

    public static final String init_val = "";
    private String p_total;

    public void reset() {
        p_total = new String(PolynCalcModel.init_val);
    }

    public PolynCalcModel() {
        reset();
    }

    public String getP_total() {
        return p_total;
    }


    public void setP_total(String p_total) {
        this.p_total = p_total;
    }


    public void setValue(String value) {
        p_total = new String(value);
    }


    public String getValue() {
        return p_total;
    }

    public void addition(String poly1, String poly2) {
        PolynUtilModel util = new PolynUtilModel();
        try {
            Polynomial polyn1 = util.parsePolynomial(poly1);
            Polynomial polyn2 = util.parsePolynomial(poly2);

            Polynomial result = polyn1.addPol(polyn2);

            p_total = "" + result.toString();
        } catch (Exception e) {
            p_total = "";
        }
    }

    public void subtraction(String Poly1, String Poly2) {
        PolynUtilModel util = new PolynUtilModel();
        try {
            Polynomial polyn1 = util.parsePolynomial(Poly1);
            Polynomial polyn2 = util.parsePolynomial(Poly2);

            Polynomial result = polyn1.subPol(polyn2);

            p_total = "" + result.toString();
        } catch (Exception e) {
            p_total = "";
        }
    }

    public void multiplication(String Poly1, String Poly2) {
        PolynUtilModel util = new PolynUtilModel();
        try {
            Polynomial polyn1 = util.parsePolynomial(Poly1);
            Polynomial polyn2 = util.parsePolynomial(Poly2);

            Polynomial result = Polynomial.multiplyPol(polyn1, polyn2);

            p_total = "" + result.toString();
        } catch (Exception e) {
            p_total = "";
        }
    }

}
