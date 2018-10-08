package com.example.android.mycalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener{
    private enum OPERATIOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }


    TextView txtCalculate;
    TextView txtResult;

    // Instance Variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATIOR currentOperator;
    private int CalculatorsResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNumber="";
        CalculatorsResult=0;
        calculationString="";
        txtCalculate = findViewById(R.id.txtCalculator);
        txtResult = findViewById(R.id.txtResult);
        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSubtract).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);

    }
    @Override
    public void onClick(View V){

        switch (V.getId())   {
            case R.id.btnEqual : OperatorIsTapped(OPERATIOR.EQUAL);
                break;
            case R.id.btn7: NumberIsTapped(7);
                break;
            case R.id.btn8 : NumberIsTapped(8);
                break;
            case R.id.btn9: NumberIsTapped(9);
                break;
            case R.id.btnPlus: OperatorIsTapped(OPERATIOR.PLUS);
                                calculationString+=" + ";
                break;
            case R.id.btn4: NumberIsTapped(4);
                break;
            case R.id.btn5: NumberIsTapped(5);
                break;

            case R.id.btn6: NumberIsTapped(6);
                break;
            case R.id.btnSubtract: OperatorIsTapped(OPERATIOR.SUBTRACT);
                calculationString+=" - ";
                break;
            case R.id.btn1: NumberIsTapped(1);
                break;
            case R.id.btn2: NumberIsTapped(2);
                break;
            case R.id.btn3: NumberIsTapped(3);
                break;
            case R.id.btnMultiply: OperatorIsTapped(OPERATIOR.MULTIPLY);
                calculationString+=" * ";
                break;
            case R.id.btnClear: ClearTapped();
                break;
            case R.id.btn0: NumberIsTapped(0);
                break;
            case R.id.btnDivide: OperatorIsTapped(OPERATIOR.DIVIDE);
                    calculationString+=" / ";
                break;

        }
        txtCalculate.setText(calculationString);

    }
    private void NumberIsTapped(int TappedNumber){
        currentNumber=currentNumber+String.valueOf(TappedNumber);
        txtResult.setText(currentNumber);
        calculationString=currentNumber;
        txtCalculate.setText(calculationString);
    }

    private void OperatorIsTapped(OPERATIOR TappedOperator){
        if(currentOperator!=null  ){
            if(currentNumber!=""){
                stringNumberAtRight=currentNumber;
                currentNumber="";


                switch (currentOperator){
                    case PLUS:
                        CalculatorsResult=Integer.parseInt(stringNumberAtLeft)+
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case SUBTRACT:
                        CalculatorsResult=Integer.parseInt(stringNumberAtLeft)-
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        CalculatorsResult=Integer.parseInt(stringNumberAtLeft)*
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        CalculatorsResult=Integer.parseInt(stringNumberAtLeft)/
                                Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft=String.valueOf(CalculatorsResult);
                txtResult.setText(stringNumberAtLeft);
                calculationString=stringNumberAtLeft;

            }

        }else {
            stringNumberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=TappedOperator;
    }
    private void ClearTapped(){
        stringNumberAtLeft="";
        stringNumberAtRight="";
        currentNumber="";
        calculationString="0";
        CalculatorsResult=0;
        txtResult.setText("0");
        currentOperator=null;

    }

}
