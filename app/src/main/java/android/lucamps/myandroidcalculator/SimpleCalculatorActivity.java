package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class SimpleCalculatorActivity extends AppCompatActivity {
    static double textToDouble(final EditText text){
        String temp = text.getText().toString().replace(",",".");
        return Double.parseDouble(temp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        setTitle("Simple Calculator");

        final EditText valueA = findViewById(R.id.editTextFirstValue);
        final EditText valueB = findViewById(R.id.editTextSecondValue);
        final TextView result = findViewById(R.id.textViewResultValue);
        final Button add_bt = findViewById(R.id.buttonAdd);
        final Button sub_bt = findViewById(R.id.buttonSub);
        final Button mult_bt = findViewById(R.id.buttonMult);
        final Button div_bt = findViewById(R.id.buttonDiv);

        add_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) + textToDouble(valueB);
                result.setText(new DecimalFormat("#,##0.####").format(value));
            }
        });
        sub_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) - textToDouble(valueB);
                result.setText(new DecimalFormat("#,##0.####").format(value));
            }
        });
        mult_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) * textToDouble(valueB);
                result.setText(new DecimalFormat("#,##0.####").format(value));
            }
        });
        div_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = textToDouble(valueA) / textToDouble(valueB);
                result.setText(new DecimalFormat("#,##0.####").format(value));
            }
        });

    }
}