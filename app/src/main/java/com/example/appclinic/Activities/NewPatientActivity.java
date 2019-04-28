package com.example.appclinic.Activities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.appclinic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewPatientActivity extends AppCompatActivity {

    Uri pickedImgUri;
    private EditText Fname, Lname, Card, Phone;
    private Button regBtn;
    private FirebaseAuth mAuth;
    private ProgressBar loadingProgress;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpatient);

        databaseReference = FirebaseDatabase.getInstance().getReference("patient");

        Fname = (EditText)findViewById(R.id.regFname);
        Lname = (EditText)findViewById(R.id.regLname);
        Card = (EditText)findViewById(R.id.regCard);
        Phone = (EditText)findViewById(R.id.regPhone);
        regBtn = (Button)findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                addNewPatient();
            }

        });

    }

 public void addNewPatient(){
        String patientFname = Fname.getText().toString();
        String patientLname = Lname.getText().toString();
        String patientCard =  Card.getText().toString();
        String patientPhone = Phone.getText().toString();

     if( patientFname.isEmpty() || patientLname.isEmpty() || patientCard.isEmpty()  || patientPhone.isEmpty()) {

         showMessage("Please Verify all fields") ;

     }
     else {

         String id = databaseReference.push().getKey();
         Patient patient = new Patient(id,patientFname,patientLname,patientCard,patientPhone);
         databaseReference.child("clinic").setValue(patient);

         regBtn.setVisibility(View.VISIBLE);
         loadingProgress.setVisibility(View.INVISIBLE);
         Fname.setText("");
         Lname.setText("");
         Card.setText("");
         Phone.setText("");
     }
    }

    // simple method to show toast message
    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}

