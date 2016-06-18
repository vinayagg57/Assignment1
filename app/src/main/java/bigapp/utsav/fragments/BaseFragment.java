package bigapp.utsav.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bigapp.utsav.R;

public class BaseFragment extends Fragment {

TextView mTitleTv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    public void setToolbar(Toolbar toolbar, String title, boolean isBackEnable) {


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        mTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_title);
//        if (isBackEnable) {
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        } else {
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
//        }
        setToolBarTitle(title);
    }

    protected void setToolBarTitle(String title) {
        if (title != null || mTitleTv != null) {
            mTitleTv.setText(title);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 1) {
                    fm.popBackStack();
                    return true;
                } else {
                    getActivity().finish();
                    return true;
                }
        }


        return super.onOptionsItemSelected(item);
    }
}
