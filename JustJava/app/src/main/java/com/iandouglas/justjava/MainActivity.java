package com.iandouglas.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int numberOfCoffees = 0;
    int pricePerCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message = "Thanks for your order!";
        displayMessage(message);
    }

    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        updateDisplay();
    }

    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        if (numberOfCoffees < 0) {
            numberOfCoffees = 0;
        }
        updateDisplay();
    }

    private void updateDisplay() {
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * pricePerCoffee);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.thanks_text_view);
        priceTextView.setText(message);
    }

}