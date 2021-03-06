package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CompleteCalculatorActivity extends AppCompatActivity {
    boolean previousWasANumber = false; //variable created to avoid invalid symbols in the expression (like 1+-2).
    boolean dotOnOperation = false; //variable created to avoid invalid dots in the expression (like 1.0.1).
    boolean alreadyHadCalculation = false;
    String[] operation;

    boolean isANumber(char a){
        return a >= '0' && a <= '9';
    }

    //method to check the input validation to get the answer.
    boolean validInput(EditText display){
        String[] noSignals;
        noSignals = display.getText().toString().split("\\+|\\*|/|-");
        if(noSignals.length > 1 && !noSignals[0].equals(""))
            return true;
        else if (noSignals[0].equals("") && noSignals.length > 2)
            return true;
        return false;
    }

    //Gets the answer of what appears on the display
    void getAnswer(EditText display){
        if(validInput(display)) {
            String temp = display.getText().toString();

            //Finding the operation of sentence
            char op;
            boolean isNegative = false;
            if (temp.indexOf('+') != -1)
                op = '+';
            else if (temp.indexOf('-') != -1 && temp.indexOf('-') != 0)
                op = '-';
            else if (temp.indexOf('*') != -1)
                op = '*';
            else if (temp.indexOf('/') != -1)
                op = '/';
            else
                op = 'N';

            //special case: negative number on beginning
            if (temp.indexOf('-') == 0) {
                isNegative = true;
                if (temp.indexOf('-', temp.indexOf('-') + 1) != -1) { //if '-' occurs twice
                    op = '-';
                    Log.d("DEBUG_CALCULATOR", "SPECIAL CASE: " + temp.indexOf('-', temp.indexOf('-') + 1));
                }
            }

            //splitting the content of the display
            operation = temp.split("\\+|\\*|/|-");
            int i = 0;
            for (String a : operation) {
                Log.i("DEBUG_CALCULATOR", "Operation[" + i + "] = " + a);
                i++;
            }
            Log.i("DEBUG_CALCULATOR", "Operation symbol: " + op);

            //Getting the initial values for the answer
            double answer;
            double secondNumber;
            if (isNegative) {
                answer = -Double.parseDouble(operation[1]);
                secondNumber = Double.parseDouble(operation[2]);
            } else {
                answer = Double.parseDouble(operation[0]);
                secondNumber = Double.parseDouble(operation[1]);
            }

            Log.d("DEBUG_CALCULATOR", "first number: " + answer + ", second number: " + secondNumber);

            //Calculating the answer
            switch (op) {
                case '+':
                    answer += secondNumber;
                    break;
                case '-':
                    answer -= secondNumber;
                    break;
                case '*':
                    answer *= secondNumber;
                    break;
                case '/':
                    answer /= secondNumber;
                    break;
            }
            display.setText(String.valueOf(answer));
            previousWasANumber = true;
            alreadyHadCalculation = false;
            dotOnOperation = (String.valueOf(answer).indexOf('.') != -1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calculator);
        this.setTitle(R.string.completeCalculator);

        final EditText display = findViewById(R.id.editTextDisplay);

        final Button num0 = findViewById(R.id.button0);
        final Button num1 = findViewById(R.id.button1);
        final Button num2 = findViewById(R.id.button2);
        final Button num3 = findViewById(R.id.button3);
        final Button num4 = findViewById(R.id.button4);
        final Button num5 = findViewById(R.id.button5);
        final Button num6 = findViewById(R.id.button6);
        final Button num7 = findViewById(R.id.button7);
        final Button num8 = findViewById(R.id.button8);
        final Button num9 = findViewById(R.id.button9);

        final Button dot_bt = findViewById(R.id.buttonDot);
        final Button add_bt = findViewById(R.id.buttonAdd);
        final Button sub_bt = findViewById(R.id.buttonSub);
        final Button mult_bt = findViewById(R.id.buttonMult);
        final Button div_bt = findViewById(R.id.buttonDiv);
        final Button equal_bt = findViewById(R.id.buttonEqual);
        final Button clear_bt = findViewById(R.id.buttonClear);
        final Button backspace_bt = findViewById(R.id.buttonBackspace);
        backspace_bt.setText("<<");

        num0.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 0);
                previousWasANumber = true;
            }
        });
        num1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 1);
                previousWasANumber = true;
            }
        });
        num2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 2);
                previousWasANumber = true;
            }
        });
        num3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 3);
                previousWasANumber = true;
            }
        });
        num4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 4);
                previousWasANumber = true;
            }
        });
        num5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 5);
                previousWasANumber = true;
            }
        });
        num6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 6);
                previousWasANumber = true;
            }
        });
        num7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 7);
                previousWasANumber = true;
            }
        });
        num8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 8);
                previousWasANumber = true;
            }
        });
        num9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText().toString() + 9);
                previousWasANumber = true;
            }
        });

        add_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (previousWasANumber) {
                    if (alreadyHadCalculation) {
                        getAnswer(display);
                        display.setText(display.getText().toString() + '+');
                    }
                    else
                        display.setText(display.getText().toString() + "+");

                    previousWasANumber = false;
                    dotOnOperation = false;
                    alreadyHadCalculation = true;
                }
            }
        });

        sub_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (previousWasANumber) {
                    if (alreadyHadCalculation) {
                        getAnswer(display);
                        display.setText(display.getText().toString() + '-');
                    }
                    else
                        display.setText(display.getText().toString() + "-");

                    previousWasANumber = false;
                    dotOnOperation = false;
                    alreadyHadCalculation = true;
                }
            }
        });

        mult_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (previousWasANumber) {
                    if (alreadyHadCalculation) {
                        getAnswer(display);
                        display.setText(display.getText().toString() + '*');
                    }
                    else
                        display.setText(display.getText().toString() + "*");

                    previousWasANumber = false;
                    dotOnOperation = false;
                    alreadyHadCalculation = true;
                }
            }
        });

        div_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (previousWasANumber) {
                    if (alreadyHadCalculation) {
                        getAnswer(display);
                        display.setText(display.getText().toString() + '/');
                    }
                    else
                        display.setText(display.getText().toString() + "/");

                    previousWasANumber = false;
                    dotOnOperation = false;
                    alreadyHadCalculation = true;
                }
            }
        });

        dot_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(previousWasANumber && !dotOnOperation){
                    display.setText(display.getText().toString() + '.');
                    previousWasANumber = false;
                    dotOnOperation = true;
                }
            }
        });

        clear_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                previousWasANumber = false;
                dotOnOperation = false;
            }
        });

        backspace_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!display.getText().toString().equals("") && display.getText().toString().length() > 1) {
                    String temp = display.getText().toString();
                    String txt = "";

                    //avoiding two points in the same operation
                    if(temp.charAt(temp.length()-1) == '.')
                        dotOnOperation = false;

                    for (int i = 0; i < temp.length() - 1; i++)
                        txt += temp.charAt(i);

                    previousWasANumber = isANumber(txt.charAt(txt.length() - 1));
                    display.setText(txt);
                }
                else {
                    display.setText("");
                    previousWasANumber = false;
                    dotOnOperation = false;
                }

                Log.d("DEBUG_CALCULATOR", "The last digit is a number?: " + previousWasANumber);
            }
        });

        equal_bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(display);
            }
        });

    }

}