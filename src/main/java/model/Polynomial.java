package model;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> polynom;
    private int polynDegree;


    public Polynomial() {
        this.polynom = new ArrayList<>();
        this.polynDegree = 0;
    }
    public ArrayList<Monomial> getPolynom() {
        return polynom;
    }

    public void setPolynom(ArrayList<Monomial> polynom) {
        this.polynom = polynom;
    }

    public double getPolynDegree() {
        return polynDegree;
    }

    public void setPolynDegree(int polynDegree) {
        this.polynDegree = polynDegree;
    }

    public void addMonom(Monomial m){
        if(m.getCoeff() == 0)
            return;
        else {
            if(m.getExp() > this.getPolynDegree() ){
                this.polynDegree = m.getExp();
                this.polynom.add(0, m);
            }
            else {
                boolean ok = false;
                int position = 0;
                for(Monomial m2: this.getPolynom()){
                    if(m2.getExp() == m.getExp()){
                        this.getPolynom().set(position, m2.add(m));
                        ok = true;
                        break;
                    }
                    if(m2.getExp() < m.getExp())
                    {
                        break;
                    }
                    position++;

                }
                if(!ok){
                    this.getPolynom().add(position, m);
                }

            }
        }
    }

    public Monomial getFirstNotNull() {

        Monomial notNull = new Monomial();

        for (Monomial m : this.getPolynom()) {
            if (m.getCoeff() != 0) {
                notNull = m;
                break;
            }
        }
        return notNull;

    }


    public String toString() {

        String s = new String();

        int firstCoeff = (int) this.getFirstNotNull().getCoeff();

        for (Monomial mon : this.getPolynom()) {
            s += mon.toString();
        }

        if (firstCoeff > 0)
            return s.substring(1);
        else {
            if (s.equals(""))
                return "0";

            else
                return s;
        }
    }

    public Polynomial addPol(Polynomial p){
        Polynomial sumPolyn = new Polynomial();
        for(Monomial m: this.getPolynom()){
            sumPolyn.addMonom(m);
        }
        for(Monomial m: p.getPolynom()){
            sumPolyn.addMonom(m);
        }
        return sumPolyn;

    }

    public Polynomial subPol(Polynomial p){
        Polynomial subPolyn = new Polynomial();
        for(Monomial m1: this.getPolynom()){
            subPolyn.addMonom(m1);
        }
        for(Monomial m1: p.getPolynom()){
            subPolyn.addMonom(new Monomial(m1.getExp(), -m1.getCoeff()));
        }
        return subPolyn;

    }

    public static Polynomial multiplyPol(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : p1.getPolynom()) {
            for (Monomial m2 : p2.getPolynom()) {
                Monomial rez = m1.multiply(m2);
                result.addMonom(rez);
            }
        }
        return result;
    }



}
