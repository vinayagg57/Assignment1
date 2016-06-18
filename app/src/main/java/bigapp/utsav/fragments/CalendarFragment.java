package bigapp.utsav.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import bigapp.utsav.R;


public class CalendarFragment extends BaseFragment {
private CalendarView calendarView;
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
ItemView(rootView);
        return rootView;

    }

public void ItemView(View rootView)
{
    Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar_calendar);
    super.setToolbar(toolbar, "Calendar", true);
    refreshDrawer(toolbar);

    calendarView = (CalendarView) rootView.findViewById(R.id.calendar_view);

    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

        @Override
        public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {


            Toast.makeText(getActivity(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
        }
    });
}
    public void refreshDrawer(Toolbar toolbar) {

        mDrawerToggle = new ActionBarDrawerToggle(this.getActivity(), mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }

}
