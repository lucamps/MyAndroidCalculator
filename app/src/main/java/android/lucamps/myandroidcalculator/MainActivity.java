package android.lucamps.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSimple(View view) {
        Intent it = new Intent(this,SimpleCalculatorActivity.class);
        startActivity(it);
    }

    public void toComplete(View view) {
        Intent it = new Intent(this,CompleteCalculatorActivity.class);
        startActivity(it);
    }
}