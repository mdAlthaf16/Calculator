package com.conversion.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.conversion.R;

public class WEIGHT_Fragment extends Fragment implements View.OnClickListener {

    View view;
    TextView displayValue, milkValue;

    RadioButton litre, kg, clear;

    android.widget.Button one, two, three, four, five, six, seven, eight, nine, zero, dot,clearLastText, button;
    String getButtonText, finalText = "";

    double d_finalText, conversionValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_w_e_i_g_h_t, container, false);

        displayValue = view.findViewById(R.id.display_values);
        milkValue = view.findViewById(R.id.milk_value);

        litre = view.findViewById(R.id.litter);
        kg = view.findViewById(R.id.kg);
        clear = view.findViewById(R.id.clear);

        // buttons
        zero = view.findViewById(R.id.num0);
        one = view.findViewById(R.id.num1);
        two = view.findViewById(R.id.num2);
        three = view.findViewById(R.id.num3);
        four = view.findViewById(R.id.num4);
        five = view.findViewById(R.id.num5);
        six = view.findViewById(R.id.num6);
        seven = view.findViewById(R.id.num7);
        eight = view.findViewById(R.id.num8);
        nine = view.findViewById(R.id.num9);
        dot = view.findViewById(R.id.dotBtn);
        clearLastText = view.findViewById(R.id.clearLastText);

        // click listeners..
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        dot.setOnClickListener(this);

        radioButtonClicks();
        clearLastText.setOnClickListener(v -> {

            if (!milkValue.getText().toString().isEmpty()) {

                finalText = finalText.substring(0, finalText.length() - 1);
                milkValue.setText(finalText);
            }
        });
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {


        button = (Button) v;
        getButtonText = button.getText().toString();
        finalText = finalText + getButtonText;
        milkValue.setText(finalText);


    }

    @SuppressLint("SetTextI18n")
    public void radioButtonClicks() {

            litre.setOnClickListener(v -> {

                if (!milkValue.getText().toString().isEmpty()) {

                    d_finalText = Double.parseDouble(milkValue.getText().toString());
                    conversionValue = d_finalText / 1.03;
                    displayValue.setText(conversionValue + " Litre");

                } else {

                    Toast.makeText(getActivity(), "Enter Litre", Toast.LENGTH_SHORT).show();
                }
            });
            kg.setOnClickListener(v -> {

                if (!milkValue.getText().toString().isEmpty()) {

                    d_finalText = Double.parseDouble(milkValue.getText().toString());
                    conversionValue = d_finalText * 1.03;
                    displayValue.setText(conversionValue + " Kg");

                } else {
                    Toast.makeText(getActivity(), "Enter kg", Toast.LENGTH_SHORT).show();
                }
            });
            clear.setOnClickListener(v -> {

                finalText = "";
                displayValue.setText("");
                milkValue.setText("");

            });


    }
}