package com.example.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class OrderActivity extends Activity {
    int numberOfCoffees=0;

    private int mQuantity = 0;
    private int mTotalPrice = 0;

    private static final int SMALL_PRICE = 5;
    private static final int MEDIUM_PRICE = 6;
    private static final int LARGE_PRICE = 7;

    private static final String TEA_SIZE_SMALL = "Small ($5/cup)";
    private static final String TEA_SIZE_MEDIUM = "Medium ($6/cup)";
    private static final String TEA_SIZE_LARGE = "Large ($7/cup)";

    private String mMilkType;
    private String mSugarType;
    private String mTeaName = "";

    private String mSize;

    public final static String EXTRA_TOTAL_PRICE = "com.example.android.teatime.EXTRA_TOTAL_PRICE";
    public final static String EXTRA_TEA_NAME = "com.example.android.teatime.EXTRA_TEA_NAME";
    public final static String EXTRA_SIZE = "com.example.android.teatime.EXTRA_SIZE";
    public final static String EXTRA_MILK_TYPE = "com.example.android.teatime.EXTRA_MILK_TYPE";
    public final static String EXTRA_SUGAR_TYPE = "com.example.android.teatime.EXTRA_SUGAR_TYPE";
    public final static String EXTRA_QUANTITY = "com.example.android.teatime.EXTRA_QUANTITY";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quantity_picker);
    }
    public void increment(View view) {
       numberOfCoffees=  numberOfCoffees+1;
        display(numberOfCoffees);

    }

    public void submit(View view) {
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*5);

    }

    private void display(int i) {
        TextView tv_value= findViewById(R.id.tv_value);
        tv_value.setText(""+ i);
    }
    private void displayPrice(int number) {
        String message ="Total number of coffee is equal "+ numberOfCoffees+"And total bill is  "+ 10*numberOfCoffees;
        displayMessage(message);


    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void decrement(View view) {
        numberOfCoffees= numberOfCoffees-1;
        display(numberOfCoffees);
    }
}
