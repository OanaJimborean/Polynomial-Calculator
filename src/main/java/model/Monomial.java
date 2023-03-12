package model;


public class Monomial {
    private int exp;
    private double coeff;

    public Monomial(int exp, double coeff){
        this.coeff = coeff;
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public Monomial() {
        this.exp = 0;
        this.coeff = 0;
    }

    public Monomial add(Monomial m) {
        return new Monomial(m.getExp(), this.getCoeff() + m.getCoeff());
    }

    public Monomial sub(Monomial m) {
        return new Monomial(m.getExp(), this.coeff - m.getCoeff());

    }

    public Monomial multiply(Monomial m) {
        return new Monomial(this.getExp() + m.getExp(), this.getCoeff() * m.getCoeff());

    }



    public String toString() {
        String mon = new String();
        if (this.getCoeff() == 0)
            return "";
        else {
            if (this.getExp() == 0) {
                if (this.getCoeff() < 0)
                    mon += this.getCoeff();
                else
                    mon = "+" + this.getCoeff();
            } else {
                if (this.getExp() == 1) {
                    if (this.getCoeff() == 1) {
                        mon = "+x";
                    } else {
                        if (this.getCoeff() == -1)
                            mon = "-x";
                        else {
                            if (this.getCoeff() < 0)
                                mon = this.getCoeff() + "x";
                            else
                                mon = "+" + this.getCoeff() + "x";
                        }
                    }
                } else {
                    if (this.getCoeff() == 1) {
                        mon = "+x^" + this.getExp();
                    } else {
                        if (this.getCoeff() == -1) {
                            mon = "-x^" + this.getExp();
                        } else {
                            if (this.getCoeff() < 0)
                                mon = this.getCoeff() + "x^" + this.getExp();
                            else
                                mon = "+" + this.getCoeff() + "x^" + this.getExp();
                        }
                    }
                }

            }
            return mon;
        }
    }
}
