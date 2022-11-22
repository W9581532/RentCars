package uk.ac.tees.w9581532.sreenith.rentcars.customer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import uk.ac.tees.w9581532.sreenith.rentcars.R;

//this is the list view custom component
public class ViewVehiclesActivityCustomListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_vehicles_custom_list_view);
    }
}