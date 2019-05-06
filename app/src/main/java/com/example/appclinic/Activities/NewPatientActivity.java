package com.example.appclinic.Activities;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appclinic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class NewPatientActivity extends AppCompatActivity {

    Uri pickedImgUri;
    private EditText Fname, Lname, Card, Phone;
    private Button regBtn;
    private FirebaseAuth mAuth;
    private ProgressBar loadingProgress;
    String [] SPINNERLIST = {"Male", "Female"};
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpatient);

        databaseReference = FirebaseDatabase.getInstance().getReference("patient");

        Fname = (EditText)findViewById(R.id.regFname);
        Lname = (EditText)findViewById(R.id.regLname);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter <>(this,
                android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner=(MaterialBetterSpinner)findViewById(R.id.regGender);
        betterSpinner.setAdapter(arrayAdapter);

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




     if( patientFname.isEmpty() || patientLname.isEmpty() || patientCard.isEmpty()  || patientPhone.isEmpty() ) {

         showMessage("Please Verify all fields") ;

     }
     else {

         String id = databaseReference.push().getKey();
         Patient patient = new Patient(id,patientFname,patientLname, patientCard,patientPhone);
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

