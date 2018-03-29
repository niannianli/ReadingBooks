package com.readingbooks.li.readingbooks;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{

    private int id;
    private String name;
    private String author;

    public Book(int id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    //getters
    public int getId() { return id; }
    public String getName() {return name; }
    public String getAuthor() {return author; }

    //write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags){
        //write all properties to the parcle
            dest.writeString(author);
            dest.writeString(name);
            dest.writeInt(id);
    }

    //constructor used for parcel
    public Book(Parcel parcel){
        //read and set saved values from parcel
        author = parcel.readString();
        name = parcel.readString();
        id = parcel.readInt();
    }

    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>(){

        @Override
        public Book createFromParcel(Parcel parcel) {
            return new Book(parcel);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }
}