package com.orange.odc.tpformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.orange.odc.tpformation.models.Document;

public class DetailActivity extends AppCompatActivity {

    TextView mTvOwner;
    TextView mTvType;
    TextView mTvDescription;
    private Document document = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTvOwner = findViewById(R.id.tv_detail_owner);
        mTvType = findViewById(R.id.tv_detail_type);
        mTvDescription = findViewById(R.id.tv_detail_description);

        Intent intent = getIntent();

        //recuperation du document dans l'intent
        document = intent.getParcelableExtra(DocumentAdapter.DOCUMENT);

        //Mettre à jour les champs du layout
        mTvOwner.setText(document.getmOwner());
        mTvType.setText(document.getmType());
        mTvDescription.setText(document.getmDescription());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.update_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.update_document){
            Intent intent = new Intent(this, InsertActivity.class);
            intent.putExtra(DocumentAdapter.DOCUMENT, document);
            startActivity(intent);
        }
        return true;
    }
}