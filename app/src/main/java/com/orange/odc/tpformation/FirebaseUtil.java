package com.orange.odc.tpformation;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.orange.odc.tpformation.models.Document;

public class FirebaseUtil {

    public static FirebaseFirestore mFirebaseFirestore;
    public static final String COLLECTION = "documents";
    public static CollectionReference mReference;
    private static FirebaseUtil firebaseUtil;

    private FirebaseUtil(){};

    //Create firestore reference collection
    public static  CollectionReference getFirestoreReference(String ref){
        if(mReference == null) {
            //Je vais créer la reference
            firebaseUtil = new FirebaseUtil();
            mFirebaseFirestore = FirebaseFirestore.getInstance();
            mReference = mFirebaseFirestore.collection(ref);
            return mReference;
        }
        return mReference;
    }


    //Push data to firestore
    public static void addDocument(Document document){
        CollectionReference reference = getFirestoreReference(COLLECTION);
        reference.add(document)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("ADD_DOC", documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }


    public static void updateDocument(Document document) {
        CollectionReference reference = getFirestoreReference(COLLECTION);
        reference.document(document.getmId())
                .set(document)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("UPDATE", "Update OKay");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
