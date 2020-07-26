package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        auth = FirebaseAuth.getInstance();

        String txtEmail = email.getText().toString();
        String txtPassword = password.getText().toString();
        if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
            Toast.makeText(this, "Empty ", Toast.LENGTH_SHORT).show();
        }else if (txtPassword.length()<6){
            Toast.makeText(this, "Password is to short", Toast.LENGTH_SHORT).show();
        }else {
            registerUser(txtEmail,txtPassword);
        }

    }

    private void registerUser(String Email, String Password) {
    auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(RegisterActivity.this, "Registration Failed  ", Toast.LENGTH_SHORT).show();
            }

        }
    });

    }

}