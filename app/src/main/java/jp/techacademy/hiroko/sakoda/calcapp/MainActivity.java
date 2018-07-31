package jp.techacademy.hiroko.sakoda.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
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

        firstStr = editText1.getText().toString();
        secondStr = editText2.getText().toString();

        try{

            if ((firstStr.length() == 0)||(secondStr.length() == 0)){

                showSnackBar(v, "数値が入力されていません。数値を入力してください");

            }else{

                firstNum = Double.parseDouble(firstStr);
                secondNum = Double.parseDouble(secondStr);
                Double resultNum;

                if (v.getId() == R.id.button1) {
                    resultNum = firstNum + secondNum;
                    goToSecond(resultNum);
                }else if (v.getId() == R.id.button2) {
                    resultNum = firstNum - secondNum;
                    goToSecond(resultNum);
                }else if (v.getId() == R.id.button3) {
                    resultNum = firstNum * secondNum;
                    goToSecond(resultNum);
                }else{
                    if (secondNum == 0){

                        showSnackBar(v, "０以外の数値で割ってください");

                    }else{
                        resultNum = firstNum / secondNum;
                        goToSecond(resultNum);
                    }
                }
            }

        }catch (NumberFormatException e) {

            showSnackBar(v, "数値を正しく入力してください");
        }
    }

    private void showSnackBar(View v, String str){
        Snackbar.make(v, str, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    private  void goToSecond(Double resultNum){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE", resultNum);
        startActivity(intent);
    }
}
