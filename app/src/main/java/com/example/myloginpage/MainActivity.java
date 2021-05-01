package com.example.myloginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signInButton,signupButton;
    private EditText usernameEditText,passwordEditText;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     signInButton=(Button) findViewById(R.id.SignInbutton_id);
     signupButton=(Button)findViewById(R.id.SignUpButonaButton_id);
        databaseHelper = new DatabaseHelper (this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


usernameEditText=(EditText) findViewById(R.id.username_id);
passwordEditText=(EditText) findViewById(R.id.PasswordEditText_id);
    signInButton.setOnClickListener(this);
    signupButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
      String username=  usernameEditText.getText().toString();
      String password=  passwordEditText.getText().toString();
        if( view.getId()==R.id.SignInbutton_id){
            Boolean result = databaseHelper.findPassword(username,password);

            if (result==true){

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                startActivity(intent);

            }
            else{

                Toast.makeText(getApplicationContext(),"Username or password didn't match",Toast.LENGTH_LONG).show();

            }

}
else if(view.getId()==R.id.SignUpButonaButton_id){
    Intent intent=new Intent(MainActivity.this,SignUpACtivity.class);
startActivity(intent);

}

    }
}