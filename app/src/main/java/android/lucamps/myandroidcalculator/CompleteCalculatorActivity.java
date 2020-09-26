package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CompleteCalculatorActivity extends AppCompatActivity {
    boolean previousWasANumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        final double value = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calculator);
        setTitle("Complete Calculator");

        final EditText display = (EditText) findViewById(R.id.editTextDisplay);

        final Button num0 = (Button) findViewById(R.id.button0);
        final Button num1 = (Button) findViewById(R.id.button1);
        final Button num2 = (Button) findViewById(R.id.button2);
        final Button num3 = (Button) findViewById(R.id.button3);
        final Button num4 = (Button) findViewById(R.id.button4);
        final Button num5 = (Button) findViewById(R.id.button5);
        final Button num6 = (Button) findViewById(R.id.button6);
        final Button num7 = (Button) findViewById(R.id.button7);
        final Button num8 = (Button) findViewById(R.id.button8);
        final Button num9 = (Button) findViewById(R.id.button9);

        final Button dot_bt = (Button) findViewById(R.id.buttonDot);
        final Button add_bt = (Button) findViewById(R.id.buttonAdd);
        final Button sub_bt = (Button) findViewById(R.id.buttonSub);
        final Button mult_bt = (Button) findViewById(R.id.buttonMult);
        final Button div_bt = (Button) findViewById(R.id.buttonDiv);
        final Button equal_bt = (Button) findViewById(R.id.buttonEqual);
        final Button clear_bt = (Button) findViewById(R.id.buttonClear);
        final Button backspace_bt = (Button) findViewById(R.id.buttonBackspace);
        backspace_bt.setText("<<");

        num0.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(0));
                else
                    display.setText(display.getText().toString() + 0);
                previousWasANumber = true;
            }
        });
        num1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(1));
                else
                    display.setText(display.getText().toString() + 1);
                previousWasANumber = true;
            }
        });
        num2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(2));
                else
                    display.setText(display.getText().toString() + 2);
                previousWasANumber = true;
            }
        });
        num3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(3));
                else
                    display.setText(display.getText().toString() + 3);
                previousWasANumber = true;
            }
        });
        num4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(4));
                else
                    display.setText(display.getText().toString() + 4);
                previousWasANumber = true;
            }
        });
        num5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(5));
                else
                    display.setText(display.getText().toString() + 5);
                previousWasANumber = true;
            }
        });
        num6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(6));
                else
                    display.setText(display.getText().toString() + 6);
                previousWasANumber = true;
            }
        });
        num7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(7));
                else
                    display.setText(display.getText().toString() + 7);
                previousWasANumber = true;
            }
        });
        num8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(8));
                else
                    display.setText(display.getText().toString() + 8);
                previousWasANumber = true;
            }
        });
        num9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!previousWasANumber)
                    display.setText(String.valueOf(9));
                else
                    display.setText(display.getText().toString() + 9);
                previousWasANumber = true;
            }
        });

        add_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(previousWasANumber){
                    display.setText(display.getText().toString() + '+');
                    previousWasANumber = false;
                }
            }
        });
    }

}