package com.conversion.Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new SNF_Fragment();
            case 1:
                return new CLR_Fragment();
            case 2:
                return new WEIGHT_Fragment();
            default:
                return new SNF_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
