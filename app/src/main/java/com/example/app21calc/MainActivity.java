package com.example.app21calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.String;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_plus,
            btn_sub, btn_mult, btn_dec, btn_eval, btn_sqrt, btn_make_double, btn_make_negative,
            btn_clean, btn_rever;
    private TextView textView;
    private String operation = null;
    private String last_operation = null;
    private double num1 = 0;
    private double num2 = 0;
    private StringBuilder strnum1 = null;
    private StringBuilder strnum2 = null;

    //разработать приложение тестирование на знание арифметики. выводит вопрос и несколько ответов. несколько фрагментов.
    // должна выдать пять вопросов. результат в новом фрагменте. результат в баллов. кнопка с подсказкой.-- открывается вторая активновть "точно ли хотите получить подсказку?" меньше баллов при использовании подсказки.
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        strnum1 = new StringBuilder();
        strnum2 = new StringBuilder();

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn_plus = findViewById(R.id.btn_plus);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mult = findViewById(R.id.btn_mult);
        btn_dec = findViewById(R.id.btn_dec);
        btn_eval = findViewById(R.id.btn_eval);
        btn_sqrt = findViewById(R.id.btn_sqrt);
//        btn_double = findViewById(R.id.btn_double);
        btn_make_double = findViewById(R.id.btn_make_double);
        btn_make_negative = findViewById(R.id.btn_make_negative);
        btn_clean = findViewById(R.id.btn_clean);
        btn_rever = findViewById(R.id.btn_rever);

//        btn0.setOnClickListener(this);
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        btn5.setOnClickListener(this);
//        btn6.setOnClickListener(this);
//        btn7.setOnClickListener(this);
//        btn8.setOnClickListener(this);
//        btn9.setOnClickListener(this);
//
//        btn_plus.setOnClickListener(this);
//        btn_sub.setOnClickListener(this);
//        btn_mult.setOnClickListener(this);
//        btn_dec.setOnClickListener(this);
//        btn_eval.setOnClickListener(this);
//        btn_sqrt.setOnClickListener(this);
//        btn_make_negative.setOnClickListener(this);
//        btn_make_double.setOnClickListener(this);
//        btn_clean.setOnClickListener(this);
//        btn_rever.setOnClickListener(this);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn0.getText());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn1.getText());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn2.getText());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn3.getText());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn4.getText());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn5.getText());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn6.getText());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn7.getText());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn8.getText());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digit((String) btn9.getText());
            }
        });


        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("+");
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("-");
            }
        });
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("*");
            }
        });
        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("/");
            }
        });
        btn_eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("=");
            }
        });
        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("sqrt");
            }
        });
        btn_make_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("neg");
            }
        });
        btn_make_double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction(",");
            }
        });
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("C");
            }
        });
        btn_rever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction("rev");
            }
        });

    }

    private void add_digit(String number) {
        try {
            double tmp = Double.parseDouble(strnum1.toString());
            if (Double.isNaN(tmp) || !Double.isFinite(tmp)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("catch");
            make_clean();
        }
        if (operation == null) {
            if (!strnum1.toString().isEmpty())
                if (Double.parseDouble(strnum1.toString()) == 0 && !strnum1.toString().contains(".") || strnum1.toString().contains(Double.toString(num1)))
                    strnum1.delete(0, strnum1.length());
            strnum1.append(number);
        } else {
            if (!strnum2.toString().isEmpty())
                if (Double.parseDouble(strnum2.toString()) == 0 && !strnum2.toString().contains("."))
                    strnum2.delete(0, strnum2.length());
            strnum2.append(number);
        }

        update_string();
    }

    private double eval() {
        double result = 0;
        try {
            switch (operation) {
                case "-":
                    result = num1 - num2;
                    break;
                case "+":
                    result = num1 + num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;

                    break;
            }
        } catch (NullPointerException e) {

        }
        return result;
    }

    private void transaction(String transaction) {
        switch (transaction) {
            case "+":
            case "-":
            case "*":
            case "/":
                add_operation(transaction);
                break;
            case "C":
                make_clean();
                strnum1.append("0");
                update_string();
                break;
            case "rev":
                make_rev();
                break;
            case ",":
                make_double();
                break;
            case "neg":
                make_negative();
                break;
            case "=":
                make_eval();
                break;
            case "sqrt":
                make_sqrt();
                break;
        }
    }

    private void make_sqrt() {
        if (operation == null) {
            if (strnum1.toString().isEmpty())
                strnum1.append(0);
            num1 = Math.sqrt(Double.parseDouble(strnum1.toString()));
            make_clean();
            strnum1.append(num1);
        } else {
            if (!strnum2.toString().isEmpty()) {
                num2 = Math.sqrt(Double.parseDouble(strnum2.toString()));
                strnum2.delete(0, strnum2.length());
                strnum2.append(num2);
                make_eval();
            } else
                operation = null;
        }
        update_string();
    }

    private void make_eval() {
        try {
            num1 = Double.parseDouble(strnum1.toString());
            num2 = Double.parseDouble(strnum2.toString());
        } catch (NumberFormatException e) {
            operation = last_operation;
        } finally {

            num1 = eval();
            make_clean();
            strnum1.append(num1);
            update_string();
        }
    }

    private void make_clean() {
        strnum2.delete(0, strnum2.length());
        strnum1.delete(0, strnum1.length());
        last_operation = operation;
        operation = null;
//        System.out.println("str1 " + strnum1);
//        System.out.println("str2 " + strnum2);
    }

    private void make_negative() {
//        String[] tmp = split_tv();
//        int size = tmp.length;
//        if (size == 4) {
//            num2 = Double.parseDouble(tmp[3]);
//            change_string(num1 + operation + num2);
//        } else {
//            if (size == 3) {
//                if (tmp[0].isEmpty()) {
//                    num2 = Double.parseDouble(tmp[2]);
//                    num2 *= -1;
//                    change_string(num1 + operation + num2);
//                } else {
//                    num2 = Double.parseDouble(tmp[2]);
//                    change_string(num1 + operation + num2);
//                }
//            } else {
//                if (size == 2) {
//                    if (tmp[0].isEmpty()) {
//                        num1 = Double.parseDouble(tmp[1]);
//                        change_string(num1 + (operation != null ? operation : ""));
//                    } else {
//                        num2 = Double.parseDouble(tmp[1]);
//                        num2 *= -1;
//                        change_string(num1 + operation + num2);
//                    }
//                }
//                if (size == 1) {
//                    num1 = Double.parseDouble(tmp[0]);
//                    num1 *= -1;
//                    change_string(num1 + (operation != null ? operation : ""));
//                }
//            }
//        }
        if (operation == null) {
            if (!strnum1.toString().isEmpty()) {
                if (strnum1.charAt(0) == '-')
                    strnum1.delete(0, 1);
                else
                    strnum1.insert(0, '-');
            }
        } else {
            if (!strnum2.toString().isEmpty()) {
                if (strnum2.charAt(0) == '-')
                    strnum2.delete(0, 1);
                else
                    strnum2.insert(0, '-');
            }
        }
        update_string();
    }

    private void make_double() {
        if (operation == null) {
            if (!strnum1.toString().contains(".")) {
                if (strnum1.toString().isEmpty())
                    strnum1.append('0');
                strnum1.append(".");
            }
        } else {
            if (!strnum2.toString().contains(".")) {
                if (strnum2.toString().isEmpty())
                    strnum2.append('0');
                strnum2.append(".");
            }
        }
        update_string();
    }

    private void make_rev() {
        if (!strnum1.toString().isEmpty()) {
            num1 = 1 / Double.parseDouble(strnum1.toString());
            make_clean();
            strnum1.append(Double.toString(num1));
            update_string();
        }
    }

    private void add_operation(String operate) {
        if (operation != null && !strnum2.toString().isEmpty())
            make_eval();
        operation = operate;
        update_string();
    }

    private void update_string() {
        textView.setText(strnum1.toString() + (operation == null ? "" : operation + strnum2.toString()));

    }

}
