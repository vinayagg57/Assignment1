package bigapp.utsav.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import bigapp.utsav.R;
import bigapp.utsav.adapter.DrawerItemClickListenerAdapter;
import bigapp.utsav.fragments.CalendarFestivalListFragment;
import bigapp.utsav.fragments.CalendarFragment;
import bigapp.utsav.fragments.RatingDialogFragment;
import bigapp.utsav.utils.Uiutils;

public class CalendarActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private String[] mPlanetTitles;

    private ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container1, new CalendarFragment()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.container2, new CalendarFestivalListFragment()).commit();

        }
        mPlanetTitles = getResources().getStringArray(R.array.menu_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, mPlanetTitles));



        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        onCalendarClicked();

                        Toast.makeText(CalendarActivity.this, position+"", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        onFestivalListClicked();
                        mDrawerLayout.closeDrawer(mDrawerList);

                        Uiutils.showToast(CalendarActivity.this,""+position);
                        break;
                    case 2:
                        onAartisClicked();
                        mDrawerLayout.closeDrawer(mDrawerList);

                        Uiutils.showToast(CalendarActivity.this,""+position);
                        break;
                    case 3:
                        onRateusClicked();
                        mDrawerLayout.closeDrawer(mDrawerList);

                        Uiutils.showToast(CalendarActivity.this,""+position);
                        break;
                    case 4:
                        onAboutClicked();
                        mDrawerLayout.closeDrawer(mDrawerList);

                        Uiutils.showToast(CalendarActivity.this,""+position);
                        break;
                }
            }



        });

    }


    private void onCalendarClicked() {
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    private void onFestivalListClicked() {
        Intent intent = new Intent(this, FestivalListActivity.class);
        startActivity(intent);

    }
    private void onAartisClicked() {
        Intent intent = new Intent(this, AartisActivity.class);
        startActivity(intent);

    }
    private void onRateusClicked() {
//        Intent intent = new Intent(this, RateUsActivity.class);
//        startActivity(intent);
        RatingDialogFragment  dFragment = new RatingDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        dFragment.show(fm,"RatingdialogFragment");
    }
    private void onAboutClicked() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }



    private void hidekeyBoard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                CalendarActivity.this.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    @Override
    public void onBackPressed() {
        hidekeyBoard();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final int count = fragmentManager.getBackStackEntryCount();
        if (count > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
