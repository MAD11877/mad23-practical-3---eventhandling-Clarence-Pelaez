package sg.edu.np.mad.week3to4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    final String title = "Main Activity 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(title,"Create");

        Intent myRecyIntent = getIntent();
        String myRecyPassword;
        String myRecyUsername;

        myRecyUsername = myRecyIntent.getStringExtra("username");
        myRecyPassword = myRecyIntent.getStringExtra("password");
        startCountdown();

        Log.v(title,"Recy Username: " + myRecyUsername + " Password: " + myRecyPassword);
    }

    private int generateOTP(){
        Random ran = new Random();
        int myNumber = ran.nextInt(999999);
        return myNumber;
    }

    CountDownTimer myCountDown;

    private void startCountdown(){
        TextView otpText = findViewById(R.id.textView5);
        otpText.setText("Hi, your OTP is " + generateOTP());

        myCountDown = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                Log.v(title,"Seconds Countdown" + l/1000);
                Toast.makeText(getApplicationContext(),"Your OTP will expire in " + l/1000 + "secs", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Log.v(title, "Finished");
                myCountDown.cancel();
                queryOTP();
            }
        };
        myCountDown.start();
    }

    private void queryOTP(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("OTP Expired");
        builder.setMessage("Your OTP has expired! Do you want a new OTP?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startCountdown();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myCountDown.cancel();
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}