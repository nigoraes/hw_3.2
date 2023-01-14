package com.example.hw_32;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private TextView tvZero;
    private Button btnPlusOne;
    private Button btnMinusOne;
    private Button btnReset;
    private Integer counter;

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    private final View.OnClickListener onClickListener = view -> {
        switch (view.getId()) {
            case R.id.btn_minus_one:
                counter--;
                tvZero.setText(Integer.toString(counter));
                break;
            case R.id.btn_plus_one:
                counter++;
                tvZero.setText(Integer.toString(counter));
                break;
            case R.id.btn_cancellation:
                initCounter();
                break;
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        initCounter();
    }

    @SuppressLint("SetTextI18n")
    private void initCounter() {
        counter = 0;
        tvZero.setText(Integer.toString(counter));
    }

    private void initListener() {
        btnMinusOne.setOnClickListener(onClickListener);
        btnPlusOne.setOnClickListener(onClickListener);
        btnReset.setOnClickListener(onClickListener);
    }


    private void initView() {
        tvZero = requireActivity().findViewById(R.id.tv_zero);
        btnMinusOne = requireActivity().findViewById(R.id.btn_minus_one);
        btnPlusOne = requireActivity().findViewById(R.id.btn_plus_one);
        btnReset = requireActivity().findViewById(R.id.btn_cancellation);
    }

}