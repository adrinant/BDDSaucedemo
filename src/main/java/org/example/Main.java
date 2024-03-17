package org.example;

import org.checkerframework.checker.units.qual.C;
import org.example.pageObject.CheckoutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

import static org.example.BasePage.driver;

public class Main {

    public static void main(String[] args) {

        double subtotal = 39.98;
        double taxPercentage = 0.08; // 8%
        double taxAmount = subtotal * taxPercentage;

        DecimalFormat df = new DecimalFormat("#.##");
        double roundedTaxAmount = Double.parseDouble(df.format(taxAmount));

        System.out.println(roundedTaxAmount);

        double total = subtotal + roundedTaxAmount;
        System.out.println(total);

        String totalString = "Total: $" + total;
        System.out.println(totalString);
    }

}
