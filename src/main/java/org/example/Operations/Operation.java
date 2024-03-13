package org.example.Operations;

import org.example.DataModels.Polynomial;

import java.util.*;

public class Operation {


    public static Polynomial additional(Polynomial x, Polynomial y) {
        Polynomial z = new Polynomial();
        for (int exp1 : x.hashMap.keySet()) {
            int k = 0;
            for (int exp2 : y.hashMap.keySet())
                if (exp1 == exp2) {
                    k++;
                    double rez = x.hashMap.get(exp1) + y.hashMap.get(exp2);
                    z.hashMap.put(exp1, rez);
                }
            if (k == 0) {
                z.hashMap.put(exp1, x.hashMap.get(exp1));
            }
        }
        for (int exp2 : y.hashMap.keySet()) {
            int ok = 0;
            for (int exp1 : x.hashMap.keySet()) {
                if (exp1 == exp2)
                    ok++;
            }
            if (ok == 0) {
                z.hashMap.put(exp2, y.hashMap.get(exp2));
            }
        }
        return z;
    }

    public static Polynomial substraction(Polynomial x, Polynomial y) {
        Polynomial z = new Polynomial();
        for (int exp1 : x.hashMap.keySet()) {
            int k = 0;
            for (int exp2 : y.hashMap.keySet())
                if (exp1 == exp2) {
                    k++;
                    double rez = x.hashMap.get(exp1) - y.hashMap.get(exp2);
                    z.hashMap.put(exp1, rez);
                }
            if (k == 0) {
                z.hashMap.put(exp1, x.hashMap.get(exp1));
            }
        }
        for (int exp2 : y.hashMap.keySet()) {
            int ok = 0;
            for (int exp1 : x.hashMap.keySet()) {
                if (exp1 == exp2)
                    ok++;
            }
            if (ok == 0) {
                z.hashMap.put(exp2, -y.hashMap.get(exp2));
            }
        }
        return z;
    }

    public static Polynomial derivative(Polynomial x) {
        double coef = 0;
        Polynomial z = new Polynomial();
        for (int exp : x.hashMap.keySet()) {
            if (exp == 0)
                z.hashMap.put(exp, (double) 0);
            else {
                coef = x.hashMap.get(exp) * exp;
                z.hashMap.put(exp - 1, coef);
            }
        }
        return z;

    }

    public static Polynomial integrate(Polynomial x) {
        Polynomial z = new Polynomial();
        for (int exp : x.hashMap.keySet()) {
            if (exp == 0) {
                double coef = x.hashMap.get(exp);
                z.hashMap.put(1, coef);
            }
            else {
                double coef = x.hashMap.get(exp);
                z.hashMap.put(exp + 1, coef / (exp + 1));
            }
        }
        return z;
    }

    public static Polynomial multiplication(Polynomial x, Polynomial y) {

        List<Integer> exponents1 = new ArrayList<>();

        for (int exponent : x.hashMap.keySet())
            exponents1.add(exponent);
        Collections.sort(exponents1, Collections.reverseOrder());

        List<Integer> exponents2 = new ArrayList<>();

        for (int exponent : y.hashMap.keySet())
            exponents2.add(exponent);
        Collections.sort(exponents2, Collections.reverseOrder());

        Polynomial z1 = new Polynomial();
        Polynomial z2 = new Polynomial();
        int exp = 0;
        double coef = 0.;
        for (int exp1 : x.hashMap.keySet()) {
            z1 = new Polynomial();
            for (int exp2 : y.hashMap.keySet()) {
                if (exp1 == 0 && exp2 != 0) {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    z1.hashMap.put(exp2, coef);
                } else if (exp2 == 0 && exp1 != 0) {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    z1.hashMap.put(exp1, coef);
                } else {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    exp = exp1 + exp2;
                    z1.hashMap.put(exp, coef);
                }
            }
            z2 = Operation.additional(z1, z2);
        }
        return z2;
    }
    public static Polynomial divion(Polynomial x, Polynomial y) {
        Polynomial z1 = new Polynomial();
        Polynomial z2 = new Polynomial();
        int exp = 0;
        double coef = 0.;
        for (int exp1 : x.hashMap.keySet()) {
            z1 = new Polynomial();
            for (int exp2 : y.hashMap.keySet()) {
                if (exp1 == 0 && exp2 != 0) {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    z1.hashMap.put(exp2, coef);
                } else if (exp2 == 0 && exp1 != 0) {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    z1.hashMap.put(exp1, coef);
                } else {
                    coef = x.hashMap.get(exp1) * y.hashMap.get(exp2);
                    exp = exp1 + exp2;
                    z1.hashMap.put(exp, coef);
                }
            }
            z2 = Operation.additional(z1, z2);
        }
        return z2;
    }

}

