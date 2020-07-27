package com.orange.odc.tpformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orange.odc.tpformation.models.Document;

public class InsertActivity extends AppCompatActivity {

    Button btnAddDocument;

    EditText etOwner;
    EditText etDescription;
    EditText etType;

    Document document;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        intent = getIntent();

        document = new Document();
        if(intent.hasExtra(DocumentAdapter.DOCUMENT)){
            document = intent.getParcelableExtra(DocumentAdapter.DOCUMENT);
            setValueForm(document);
        }

        btnAddDocument = findViewById(R.id.btn_add_document);
        btnAddDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValueForm();
                saveDocument();

            }
        });
    }

    private void saveDocument() {
        if(document.getmId() != null){
            Toast.makeText(this, "UPDATE", Toast.LENGTH_LONG).show();
            FirebaseUtil.updateDocument(document);
        }else{
            FirebaseUtil.addDocument(document);
        }
    }

    private void setValueForm(Document document) {
        etOwner = findViewById(R.id.et_owner);
        etDescription = findViewById(R.id.et_description);
        etType = findViewById(R.id.et_type);

        etOwner.setText(document.getmOwner());
        etType.setText(document.getmType());
        etDescription.setText(document.getmDescription());

    }

    private void getValueForm() {
        etOwner = findViewById(R.id.et_owner);
        etDescription = findViewById(R.id.et_description);
        etType = findViewById(R.id.et_type);
        String owner = etOwner.getText().toString();
        String description = etDescription.getText().toString();
        String type = etType.getText().toString();

        document.setmOwner(owner);
        document.setmType(type);
        document.setmDescription(description);
    }
}