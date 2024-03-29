package com.example.navigationassessment.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationassessment.Contacts;
import com.example.navigationassessment.ContactsAdapter;
import com.example.navigationassessment.R;

import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        recyclerView = root.findViewById(R.id.recyclerView);

        //creating a list of contacts to display

        List<Contacts> contactsList = new ArrayList<>();

        contactsList.add(new Contacts(" Name: William Mart","Contact: 9852131212",R.drawable.anova));
        contactsList.add(new Contacts(" Name: Jordon Lius","Contact: 9856321025",R.drawable.googles));
        contactsList.add(new Contacts(" Name: Tim Crooke","Contact: 9846235478",R.drawable.happy));
        contactsList.add(new Contacts(" Name: Minke Frankle","Contact: 9856423654",R.drawable.houston));
        contactsList.add(new Contacts(" Name: Stardam Kanter","Contact: 9756841230",R.drawable.iceland));


        ContactsAdapter contactsAdapter = new ContactsAdapter(contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
}