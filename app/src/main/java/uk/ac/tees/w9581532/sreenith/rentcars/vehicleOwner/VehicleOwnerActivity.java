package uk.ac.tees.w9581532.sreenith.rentcars.vehicleOwner;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import uk.ac.tees.w9581532.sreenith.rentcars.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

// this is a page handles whether the vehicle owner has already added a vehicle or not
public class VehicleOwnerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_owner);

        Intent emailIntent = getIntent();
        String email = emailIntent.getStringExtra("email");

        //updates the database with the new records if the conditions are met
        FirebaseFirestore.getInstance().collection("users").document(email).get()
        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.getString("vehicle") == null) {
                        Intent intent = new Intent(getApplicationContext(), VehicleOwnerAddVehicleActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), VehicleOwnerAddedActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}