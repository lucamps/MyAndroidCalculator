package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CompleteCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calculator);
        setTitle("Complete Calculator");

        final Button backspace_bt = (Button) findViewById(R.id.buttonBackspace);
        backspace_bt.setText("<<");

        final Button mult_bt = (Button) findViewById(R.id.buttonMult);
    }
}