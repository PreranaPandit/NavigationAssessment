package com.example.navigationassessment.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationassessment.R;

public class SlideshowFragment extends Fragment implements View.OnClickListener {

    private SlideshowViewModel slideshowViewModel;
    //references
    private EditText etPrincipal;
    private EditText etTime;
    private EditText etRate;
    private Button btnCalculate;
    private TextView tvResult;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //data binding
        etPrincipal = root.findViewById(R.id.etPrincipal);
        etRate = root.findViewById(R.id.etRate);
        etTime = root.findViewById(R.id.etTime);
        btnCalculate = root.findViewById(R.id.btnCalculateInterest);
        tvResult = root.findViewById(R.id.tvInterest);

        btnCalculate.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {

        int principal = Integer.parseInt(etPrincipal.getText().toString());
        float time = Float.parseFloat(etTime.getText().toString());
        int rate = Integer.parseInt(etRate.getText().toString());

        float simpleInterest;

        simpleInterest = (principal * time * rate) / 100;

        tvResult.setText("Simple Interest is : "+simpleInterest);

    }
}