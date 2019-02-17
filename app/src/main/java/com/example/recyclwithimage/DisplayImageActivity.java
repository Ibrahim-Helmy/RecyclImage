package com.example.recyclwithimage;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayImageActivity extends AppCompatActivity {
ImageView imageView;
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        Toolbar toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView=findViewById(R.id.imageView_id);
        title=findViewById(R.id.title_view_id);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent.hasExtra("i")){

            Image i = intent.getExtras().getParcelable("i");

            imageView.setImageResource(i.getImage());
            title.setText(i.getTitle());
        }else {

            Toast.makeText(this, "what...", Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view) {

startActivity(new Intent(DisplayImageActivity.this,FinalActivity.class));
    }
}
