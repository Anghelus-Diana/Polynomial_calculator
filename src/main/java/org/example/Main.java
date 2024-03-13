package org.example;
import org.example.DataModels.Polynomial;
import org.example.Operations.Operation;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Polynomial polinom1=new Polynomial("5x+12x^2-16x^3");
        Polynomial polinom2=new Polynomial("2x-7x^2+7");
        //Operation.divison(polinom1,polinom2);

        GUI interfata=new GUI();

    }
}