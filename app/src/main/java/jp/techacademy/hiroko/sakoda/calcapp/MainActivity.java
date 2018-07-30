package jp.techacademy.hiroko.sakoda.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    double firstNum;
    double secondNum;
    String firstStr;
    String secondStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button1.setText("＋");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button2.setText("−");

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button3.setText("×️");

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button4.setText("÷");

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        TextView textView = (TextView) findViewById(R.id.textView);
        firstStr = editText1.getText().toString();
        secondStr = editText2.getText().toString();

//        nullでは反応しない
//        if (firstStr == null)  {
//            Log.d("UI_PARTS", "firstStr==null" + firstStr);
//        }

        if ((firstStr.length() == 0)||(secondStr.length() == 0)){

            //textView.setText("数値を入力してください");
            Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else{

            textView.setText("");

            firstNum = Double.parseDouble(firstStr);
            secondNum = Double.parseDouble(secondStr);
            Double resultNum;

            if (v.getId() == R.id.button1) {
                resultNum = firstNum + secondNum;
            }else if (v.getId() == R.id.button2) {
                resultNum = firstNum - secondNum;
            }else if (v.getId() == R.id.button3) {
                resultNum = firstNum * secondNum;
            }else{
                resultNum = firstNum / secondNum;
            }

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE", resultNum);
            startActivity(intent);
        }
    }
}
