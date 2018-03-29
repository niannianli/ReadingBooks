package com.readingbooks.li.readingbooks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Arrays;

public class BookList1Fragment extends Fragment {

    public static final String[] BookList =
            {"Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7",
                    "Book8", "Book9", "Book10", "Book11", "Book12", "Book13", "Book14",
                    "Book15", "Book16", "Book17", "Book18", "Book19", "Book20",
                    "Book21", "Book22", "Book23", "Book24", "Book25", "Book26",
                    "Book27", "Book28", "Book29", "Book30", "Book31", "Book32",
                    "Book33", "Book34", "Book35", "Book36", "Book37", "Book38",
                    "Book39", "Book40"
            };

    List bookList = Arrays.asList(BookList);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.booklist, container, false);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        rv.setAdapter(new RecyclerViewAdapter(bookList));

        return rv;
    }
}
