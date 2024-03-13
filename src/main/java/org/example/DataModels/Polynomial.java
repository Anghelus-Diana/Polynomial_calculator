package org.example.DataModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Polynomial {

    public HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();

    public Polynomial() {
        hashMap.put(0, 0.0);
    }

    public Polynomial(String text) throws NumberFormatException {
        //Parsam stringul
        if (text.charAt(0) != '-' && text.charAt(0) != '+')
            text = "+" + text;
        text = text.toLowerCase();
        String[] monomialArray = text.split("(?=[+-])");

        for (String monom : monomialArray) {
            //Gasim exponentul
            int exp = 0;
            int intIndex = monom.indexOf("x^");
            if (intIndex != -1) {
                if (intIndex != monom.indexOf("x"))
                    throw new NumberFormatException();
                exp = Integer.parseInt(monom.substring(intIndex + 2));
            } else {
                intIndex = monom.indexOf("x");
                if (intIndex != -1) {
                    if (monom.substring(intIndex).length() > 1)
                        throw new NumberFormatException();
                    exp = 1;
                }
            }

            //Gasim coeficientul
            double number = 0;
            int iend = monom.indexOf("x");
            if (iend != -1) {
                String subString = monom.substring(0, iend);
                if (subString.length() == 1) {
                    if (subString.charAt(0) == '-')
                        number = -1.0;
                    else if (subString.charAt(0) == '+')
                        number = 1.0;
                    else
                        throw new NumberFormatException();
                } else
                    number = Integer.parseInt(subString);

            } else if (iend == -1) {
                number = Integer.parseInt(monom);
            }
            if (hashMap.keySet().contains(exp))
                throw new NumberFormatException();
            hashMap.put(exp, number);
        }
    }

    public String toString() {
        String result = "";

        List<Integer> exponents = new ArrayList<>();

        for (int exponent : hashMap.keySet())
            exponents.add(exponent);
        Collections.sort(exponents, Collections.reverseOrder());

        boolean isFirst = true;
        for (Integer exponent : exponents) {
            Double coefficient = hashMap.get(exponent);
            if (coefficient != 0.0) {
                if (!isFirst && coefficient > 0.0) {
                    result += "+";
                }
                if (coefficient != -1.0 && coefficient != 1.0 || exponent == 0) {
                    result += String.format("%.2g", coefficient);
                } else {
                    if (coefficient == -1.0)
                        result += "-";
                }
                if (exponent > 0) {
                    result += "x";
                    if (exponent > 1) {
                        result += "^" + exponent;
                    }
                }
                isFirst = false;
            }
        }
        if (result.length() == 0)
            result = "0";
        return result;
    }
}




