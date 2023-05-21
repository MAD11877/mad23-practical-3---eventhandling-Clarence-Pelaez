package sg.edu.np.mad.week3to4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE,"On Create!");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume!");

        EditText etUserName = findViewById(R.id.editTextText);
        EditText etPassword = findViewById(R.id.editTextText2);
        Button loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            String myUsername;
            String myPassword;
            @Override
            public void onClick(View v) {
                Log.v(TITLE,"Login Button Pressed!");
                myUsername = etUserName.getText().toString();
                myPassword = etPassword.getText().toString();

                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("username", myUsername);
                myIntent.putExtra("password",myPassword);
                startActivity(myIntent);
                Log.v(TITLE, "Extracted Username " + myUsername + " Password " + myPassword);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy!");
    }
}