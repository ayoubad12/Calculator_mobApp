package ma.enset.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //when you get a result. click and click on another operator you can make
    //some operation with that result and another number and get that result again.
//    public boolean lock = true ;

    public double num1;
    public double num2;
    public int operator ;
    public TextView textViewResult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=0 ;
        num2=0  ;
        operator=1;
        textViewResult = findViewById(R.id.textResult);
        textViewResult.setText("0");


        System.out.println("** on Create **");
    }

    public void numberClick(View view){
        // Cast the view to a Button
        Button button = (Button) view;

        // Get the text of the button
        String buttonText = button.getText().toString();
//        if(Double.parseDouble(textViewResult.getText().toString()) == 0)
        if(textViewResult.getText().toString().equals("0"))
            textViewResult.setText( buttonText );
        else
            textViewResult.setText( textViewResult.getText() + buttonText );

    }

    public void add(View view){

            operator = 1;
            num1 = Double.parseDouble(textViewResult.getText().toString());
            textViewResult.setText("0");

    }
    public void subtraction(View view){

            operator = 2;
            num1 = Double.parseDouble(textViewResult.getText().toString());
            textViewResult.setText("0");

    }
    public void multiplication(View view){

            operator = 3;
            num1 = Double.parseDouble(textViewResult.getText().toString());
            textViewResult.setText("0");

    }
    public void division(View view){

            operator = 4;
            num1 = Double.parseDouble(textViewResult.getText().toString());
            textViewResult.setText("0");

    }


    public void calculer(View view){
        num2 = Double.parseDouble(textViewResult.getText().toString());
        double epsilon = 0.000001; // Define a small epsilon value for comparison

        if(operator==1){
            //my first incorrect approach
//            num1 = num1+num2;
//            if((num1*10) % 10 == 0){
//                textViewResult.setText(String.valueOf((int) num1));
//            }else{
//                textViewResult.setText(String.valueOf(num1));
//            }
            num1 = num1 + num2;
            if (Math.abs((num1 * 10) % 10) < epsilon) {
                textViewResult.setText(String.valueOf((int) num1));
            } else {
                textViewResult.setText(String.valueOf(num1));
            }
        }
        if(operator==2) {
            num1 = num1 - num2;
            if (Math.abs((num1 * 10) % 10) < epsilon) {
                textViewResult.setText(String.valueOf((int) num1));
            } else {
                textViewResult.setText(String.valueOf(num1));
            }
        }
        if(operator==3) {
            num1 = num1 * num2;
            if (Math.abs((num1 * 10) % 10) < epsilon) {
                textViewResult.setText(String.valueOf((int) num1));
            } else {
                textViewResult.setText(String.valueOf(num1));
            }
        }
        if(operator==4){
            if(num2==0)
                showAlert();
            else {
                num1 = num1 / num2;
                if (Math.abs((num1 * 10) % 10) < epsilon) {
                    textViewResult.setText(String.valueOf((int) num1));
                } else {
                    textViewResult.setText(String.valueOf(num1));
                }
            }
        }
    }

    public void clear(View view){
        num1=0 ;
        num2=0;
        operator=1 ;
        textViewResult.setText("0");
    }

    private void showAlert() {
        // Create an AlertDialog.Builder instance
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the message for the alert dialog
        builder.setMessage("can't divide by zero");

        // Add a button to the dialog with a click listener that dismisses the dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

//    public void calculer (View view) {
//        double a=Double.parseDouble(editText1.getText().toString());
//        double b=Double.parseDouble(editText2.getText().toString());
//        textViewR.setText(String.valueOf(d: a+b));
//    }


}