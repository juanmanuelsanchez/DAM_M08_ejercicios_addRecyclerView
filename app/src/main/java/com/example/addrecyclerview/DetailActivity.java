package com.example.addrecyclerview;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //String itemId = getIntent().getExtras().getString(MiAdaptador.ITEM_ID_KEY);
        String item = getIntent().getExtras().getString("nombre");
        Toast.makeText(this, "Received item: " + item, Toast.LENGTH_LONG).show();

    }
}
