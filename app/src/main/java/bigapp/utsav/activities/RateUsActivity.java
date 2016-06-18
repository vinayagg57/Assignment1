package bigapp.utsav.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bigapp.utsav.R;
import bigapp.utsav.fragments.CalendarFragment;
import bigapp.utsav.fragments.RatingDialogFragment;

public class RateUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        if (savedInstanceState == null) {
     //       getSupportFragmentManager().beginTransaction().add(R.id.container, new RatingDialogFragment()).commit();
        }
    }
    @Override
    public void onBackPressed() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final int count = fragmentManager.getBackStackEntryCount();
        if (count > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
