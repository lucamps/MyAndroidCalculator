package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleCalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        setTitle("Simple Calculator");

        final EditText valueA = (EditText) findViewById(R.id.editTextFirstValue);
        final EditText valueB = (EditText) findViewById(R.id.editTextSecondValue);
        final TextView result = (TextView) findViewById(R.id.textViewResultValue);
        final Button add_bt = (Button) findViewById(R.id.buttonAdd);
        final Button sub_bt = (Button) findViewById(R.id.buttonSub);
        final Button mult_bt = (Button) findViewById(R.id.buttonMult);
        final Button div_bt = (Button) findViewById(R.id.buttonDiv);



        add_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) + textToDouble(valueB);
                result.setText(String.valueOf(value));
            }
        });
        sub_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) - textToDouble(valueB);
                result.setText(String.valueOf(value));
            }
        });
        mult_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) * textToDouble(valueB);
                result.setText(String.valueOf(value));
            }
        });
        div_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) / textToDouble(valueB);
                result.setText(String.valueOf(value));
            }
        });

    }

    static double textToDouble(final EditText text){
        String temp = text.getText().toString().replace(",",".");
        return Double.parseDouble(temp);
    }

}