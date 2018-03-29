package com.readingbooks.li.readingbooks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new DividerDecoration(getActivity(), DividerDecoration.VERTICAL_LIST));

        return recyclerView;

    }

}