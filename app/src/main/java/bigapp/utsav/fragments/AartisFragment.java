package bigapp.utsav.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import bigapp.utsav.R;

public class AartisFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_aartis, container, false);
   Itemview(rootView);
        return rootView;
    }
    public void Itemview(View rootView)
    {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar_aartis);
        super.setToolbar(toolbar, "Aartis", true);

    }


}
