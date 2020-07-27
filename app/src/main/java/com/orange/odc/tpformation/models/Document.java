package com.orange.odc.tpformation.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.DocumentId;

public class Document implements Parcelable {
    String mOwner;
    String mDescription;
    String mType;
    @DocumentId private String mId;

    public Document(){}

    public Document(String owner, String description, String type) {
        mOwner = owner;
        mDescription = description;
        mType = type;
    }

    protected Document(Parcel in) {
        mOwner = in.readString();
        mDescription = in.readString();
        mType = in.readString();
        mId = in.readString();
    }

    public static final Creator<Document> CREATOR = new Creator<Document>() {
        @Override
        public Document createFromParcel(Parcel in) {
            return new Document(in);
        }

        @Override
        public Document[] newArray(int size) {
            return new Document[size];
        }
    };

    public String getmOwner() {
        return mOwner;
    }

    public void setmOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mOwner);
        dest.writeString(mDescription);
        dest.writeString(mType);
        dest.writeString(mId);
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}
