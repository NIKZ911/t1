package com.t1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class doc_register extends AppCompatActivity {

    private CollectionReference mref;
    private FirebaseAuth mAuth;

    TextView emailid,name,password,d_location,d_address,d_fees,d_timing,d_speciality,d_experience;
    String user_name,email,pass,location,address,timing,speciality,experience;
    Long fees;
    FirebaseFirestore db = FirebaseFirestore.getInstance();




    public void dregister(View view)
    {

        mAuth = FirebaseAuth.getInstance();

        emailid = (TextView) findViewById(R.id.demail);
        name = (TextView) findViewById(R.id.dname);
        d_location = (TextView) findViewById(R.id.dlocation);
        d_address = (TextView) findViewById(R.id.daddress);
        d_experience = (TextView) findViewById(R.id.dxp);
        d_fees = (TextView) findViewById(R.id.dfees);
        d_speciality = (TextView) findViewById(R.id.dtype);
        d_timing = (TextView) findViewById(R.id.dTiming);
        password = (EditText) findViewById(R.id.dpassword);

        mref=db.collection("doctors");


        email = emailid.getText().toString();
        pass  = password.getText().toString();
        user_name = name.getText().toString();
        location =  d_location.getText().toString();
        address =   d_address.getText().toString();

        fees =  Long.valueOf(d_fees.getText().toString());
        timing =  d_timing.getText().toString();
        speciality = d_speciality.getText().toString();
        experience =  d_experience.getText().toString();




        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            FirebaseUser user1 = mAuth.getCurrentUser();
                            String user_uid = user1.getUid();

                            Map<String,Object> data_user = new HashMap<>();
                            data_user.put("name",user_name);
                            data_user.put("UID",user_uid);
                            data_user.put("Type",speciality);
                            data_user.put("Location",location);
                            data_user.put("consultationfees",fees);
                            data_user.put("address",address);
                            data_user.put("timing",timing);
                            data_user.put("xp",experience);
                            data_user.put("Longitude","18.5204");
                            data_user.put("Latitude","73.8567");
                            data_user.put("rating","0"); //Rating is kept 0 as it is an outof range number ;initially rating is not there

                            //Default image incase image is not uploaded
                            data_user.put("imageurl","https://firebasestorage.googleapis.com/v0/b/tproj-e4b28.appspot.com/o/1.jpeg?alt=media&token=37611769-afe3-4a41-ba69-eab247bbaf0e");


                            mref.document(user_uid).set(data_user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {


                                            Log.d("Current","Insertion completed");

                                            Toast.makeText(doc_register.this,"Registration SUCCESS",Toast.LENGTH_LONG);
                                            Intent intent = new Intent(doc_register.this,docgetdetails.class);
                                            startActivity(intent);
                                            finish();


                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                            Log.d("Current","Insertion failed");
                                            Toast.makeText(doc_register.this,"Registration Failed",Toast.LENGTH_LONG);
                                        }
                                    });


                        }

                        else
                        {
                            Toast.makeText(doc_register.this,"REGISTRATION FAILED",Toast.LENGTH_LONG).show();
                            Log.d("Register","USer creation Failed");
                        }
                    }
                });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_register);
    }
}
