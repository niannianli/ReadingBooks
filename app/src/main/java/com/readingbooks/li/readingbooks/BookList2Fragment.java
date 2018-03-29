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

public class BookList2Fragment extends Fragment {

    public static final String[] BookList =
            {"Book100", "Book99", "Book98", "Book97", "Book96", "Book95", "Book94",
                    "Book93", "Book92", "Book91", "Book90"};

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
