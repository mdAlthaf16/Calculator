package com.conversion.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.conversion.Formula;
import com.conversion.MainActivity;
import com.conversion.R;

import java.lang.reflect.Field;


public class SNF_Fragment extends Fragment implements View.OnClickListener {

    View view;
    android.widget.Button one, two, three, four, five, six, seven, eight, nine, zero, dot, allClear, clear, equalTo, button;

    String getButtonText, modifiedText;

    TextView credentialValueTextView, textOne, textTwo, textOneEditText, textTwoEditText, displayResultTextView;

    String STATE_TEM_VOLUME_1 = "", STATE_TEM_VOLUME_2 = "";

    int clickCount = 0;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_s_n_f, container, false);

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
        allClear = view.findViewById(R.id.allClearBtn);
        clear = view.findViewById(R.id.clearBnt);
        equalTo = view.findViewById(R.id.equalBtn);

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

        credentialValueTextView = view.findViewById(R.id.credentialValueTextView);
        textOne = view.findViewById(R.id.textOne);
        textTwo = view.findViewById(R.id.textTwo);

        textOneEditText = view.findViewById(R.id.textOneEditText);
        textTwoEditText = view.findViewById(R.id.textTwoEditText);
        displayResultTextView = view.findViewById(R.id.displayResultTextView);


        credentialValueTextView.setText("CLR");

        textOne.setText("CLR");
        textTwo.setText("FAT");



        textOneEditText.setOnClickListener(v -> {

            onResume();
            credentialValueTextView.setText("CLR");

        });

        textTwoEditText.setOnClickListener(v -> {


            onResume();
            credentialValueTextView.setText("FAT");

        });

        equalTo.setOnClickListener(v -> {

            onResume();

            if (!textOneEditText.getText().toString().isEmpty() && !textTwoEditText.getText().toString().isEmpty()) {

                // calculate snf

                Formula formula = new Formula();
                String snfResult = String.valueOf(formula.snfCalculate(textOneEditText.getText().toString(), textTwoEditText.getText().toString(), STATE_TEM_VOLUME_1, STATE_TEM_VOLUME_2));


                // calculate total solid
                String tsResult = String.valueOf(formula.totalSolid(snfResult, textTwoEditText.getText().toString()));

                // display result

                displayResultTextView.setText(textOneEditText.getText().toString() + " % CLR\n\n" + textTwoEditText.getText().toString() + " % FAT\n\n" + snfResult + " % SNF <--\n\n" + tsResult + " % Total Solid");


            } else if (!textOneEditText.getText().toString().isEmpty()) {

                // to clear final text when enter is clicked
                credentialValueTextView.setText("FAT");
                equalTo.setText("=");

            } else {

                Toast.makeText(getActivity(), "Enter CLR", Toast.LENGTH_SHORT).show();
            }

            if (equalTo.getText().equals("=")) {

                clickCount++;

                if (clickCount >= 2) {

                    if (textTwoEditText.getText().toString().isEmpty()) {

                        Toast.makeText(getActivity(), "Enter FAT", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        allClear.setOnClickListener(v -> {

            onResume();

            clickCount = 0;

            credentialValueTextView.setText("CLR");
            displayResultTextView.setText("");
            textOneEditText.setText("");
            textTwoEditText.setText("");
            getButtonText = "";
            equalTo.setText("-->");


        });

        clear.setOnClickListener(v -> {


            if (!textOneEditText.getText().toString().isEmpty() || !textTwoEditText.getText().toString().isEmpty()) {


                if (credentialValueTextView.getText().toString().equals("CLR")) {


                    // to prevent indexOutOfBondException error
                    if (textOneEditText.getText().toString().length() != 0) {

                        modifiedText = modifiedText.substring(0, modifiedText.length() - 1);
                        textOneEditText.setText(modifiedText);
                    }
                }

                if (credentialValueTextView.getText().toString().equals("FAT")) {

                    // to prevent indexOutOfBondException error
                    if (textTwoEditText.getText().toString().length() != 0) {

                        modifiedText = modifiedText.substring(0, modifiedText.length() - 1);
                        textTwoEditText.setText(modifiedText);

                    }
                }

            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {

        button = (Button) v;
        getButtonText = (String) button.getText();

        onResume();

        if (credentialValueTextView.getText().toString().equals("CLR")) {

            // display numbers into clr field
            modifiedText = textOneEditText.getText().toString();
            modifiedText = modifiedText + getButtonText;
            textOneEditText.setText(modifiedText);

        }

        if (credentialValueTextView.getText().toString().equals("FAT")) {

            // display numbers into fat filed
            modifiedText = textTwoEditText.getText().toString();
            modifiedText = modifiedText + getButtonText;
            textTwoEditText.setText(modifiedText);


        }

    }


    @Override
    public void onResume() {
        super.onResume();

        STATE_TEM_VOLUME_1 = MainActivity.STATE_TEM_VOLUME_1;
        STATE_TEM_VOLUME_2 = MainActivity.STATE_TEM_VOLUME_2;
    }

}