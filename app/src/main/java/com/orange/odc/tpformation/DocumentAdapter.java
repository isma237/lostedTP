package com.orange.odc.tpformation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.odc.tpformation.models.Document;

import java.util.ArrayList;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {


    public static final String DOCUMENT = "Document";

    ArrayList<Document> mDocuments;
    LayoutInflater mInflater;
    public DocumentAdapter(Context ctx, ArrayList<Document> documents){
        mDocuments = documents;
        mInflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_document, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document doc = mDocuments.get(position);
        holder.bind(doc);
    }

    @Override
    public int getItemCount() {
        return mDocuments.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvOwner;
        TextView tvType;
        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOwner = itemView.findViewById(R.id.tv_owner);
            tvType = itemView.findViewById(R.id.tv_type);
            itemView.setOnClickListener(this);
        }

        private void bind(Document document) {
            tvOwner.setText(document.getmOwner());
            tvType.setText(document.getmType());
        }

        @Override
        public void onClick(View v) {
            Document document = mDocuments.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra(DOCUMENT, document);
            v.getContext().startActivity(intent);
        }
    }
}
