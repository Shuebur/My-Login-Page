package com.example.myloginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpACtivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText,emailEditText,usernameEditText,passwordEditText;
    private Button signUpbutton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_a_ctivity);
       /* ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Registration Page");*/
      nameEditText=(EditText) findViewById(R.id.nameEditText_id);
      emailEditText=(EditText) findViewById(R.id.emailEditText_id);
       usernameEditText=(EditText) findViewById(R.id.Username_EditText_id);
        passwordEditText=(EditText) findViewById(R.id.SignUpPassword_EDitText);
        signUpbutton=(Button) findViewById(R.id.Button_id);

  userDetails=new UserDetails();
  databaseHelper=new DatabaseHelper(this);

        signUpbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name=  nameEditText.getText().toString();
        String email=  emailEditText.getText().toString();
        String username=  usernameEditText.getText().toString();
        String passsword=  passwordEditText.getText().toString();
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(passsword);

      Long rowId =  databaseHelper.insertData(userDetails);
       if (rowId>0)
       {

    Toast.makeText(getApplicationContext(),"Row"+rowId+"is succesfully inserted",Toast.LENGTH_LONG).show();



}


       else{

    Toast.makeText(getApplicationContext(),"Row insert failed",Toast.LENGTH_LONG).show();

}
    }

}