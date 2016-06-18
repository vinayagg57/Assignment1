package bigapp.utsav.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bigapp.utsav.R;
import bigapp.utsav.utils.Uiutils;

public class RatingDialogFragment extends DialogFragment implements View.OnTouchListener, View.OnClickListener {
    int rating = 0;
    private ImageView mRatingImv1, mRatingImv2, mRatingImv3, mRatingImv4, mRatingImv5;
    private TextView mFeedBackBtn;
    private TextView mHeaderTv;
    private LinearLayout mRatingLayout, mFeedbackLayout;
    private ImageView mSelectedRating;
    private int selectedRatingId = -1;

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.MagicxDialogFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_rating_dialog, container, false);

            mHeaderTv = (TextView) rootView.findViewById(R.id.rating_tv_header);
            mRatingLayout = (LinearLayout) rootView.findViewById(R.id.rating_layout_rating);
            mFeedbackLayout = (LinearLayout) rootView.findViewById(R.id.rating_layout_feedback);

            mSelectedRating = (ImageView) rootView.findViewById(R.id.rating_imv_selectedrating);
            mRatingImv1 = (ImageView) rootView.findViewById(R.id.rating_imv_rating1);
            mRatingImv2 = (ImageView) rootView.findViewById(R.id.rating_imv_rating2);
            mRatingImv3 = (ImageView) rootView.findViewById(R.id.rating_imv_rating3);
            mRatingImv4 = (ImageView) rootView.findViewById(R.id.rating_imv_rating4);
            mRatingImv5 = (ImageView) rootView.findViewById(R.id.rating_imv_rating5);


            mRatingImv1.setOnTouchListener(this);
            mRatingImv2.setOnTouchListener(this);
            mRatingImv3.setOnTouchListener(this);
            mRatingImv4.setOnTouchListener(this);
            mRatingImv5.setOnTouchListener(this);
            mFeedBackBtn = (TextView) rootView.findViewById(R.id.rating_btn_feedback);
            rootView.findViewById(R.id.rating_btn_rating).setOnClickListener(this);


            mFeedBackBtn.setOnClickListener(this);

            return rootView;
        }

    public void showFeedbackLayout() {
        setFeedbackText();
        int rating = 0;
        switch (selectedRatingId) {
            case R.id.rating_imv_rating1:
                rating = 1;
                mSelectedRating.setImageResource(R.drawable.selected_rating_1);
                break;
            case R.id.rating_imv_rating2:
                rating = 2;
                mSelectedRating.setImageResource(R.drawable.selected_rating_2);
                break;
            case R.id.rating_imv_rating3:
                rating = 3;
                mSelectedRating.setImageResource(R.drawable.selected_rating_3);
                break;
            case R.id.rating_imv_rating4:
                rating = 4;
                mSelectedRating.setImageResource(R.drawable.selected_rating_4);
                break;
            case R.id.rating_imv_rating5:
                rating = 5;
                mSelectedRating.setImageResource(R.drawable.selected_rating_5);
                break;
        }
        mFeedbackLayout.setVisibility(View.VISIBLE);
        mRatingLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            switch (v.getId()) {
                case R.id.rating_imv_rating1:
                case R.id.rating_imv_rating2:
                case R.id.rating_imv_rating3:
                case R.id.rating_imv_rating4:
                case R.id.rating_imv_rating5:
                    selectedRatingId = v.getId();
                    showFeedbackLayout();
                    break;


            }
            return true;
        }
        return false;
    }

    private void setFeedbackText() {
        switch (selectedRatingId) {
            case R.id.rating_imv_rating1:
            case R.id.rating_imv_rating2:
            case R.id.rating_imv_rating3:
                mHeaderTv.setText("Tell us what went wrong &amp; we will make it up to you");
                mFeedBackBtn.setText("Feedback");
                break;
            case R.id.rating_imv_rating4:
            case R.id.rating_imv_rating5:
                mHeaderTv.setText("Thanks for loving us, mind rating us on Play Store.");
                mFeedBackBtn.setText("Feedback");
                break;
        }
    }

    private void handleFeedbackClick() {
        switch (selectedRatingId) {
            case R.id.rating_imv_rating1:
                rating = 1;
                break;
            case R.id.rating_imv_rating2:
                rating = 2;
                break;
            case R.id.rating_imv_rating3:
                rating = 3;
                break;
            case R.id.rating_imv_rating4:
                rating = 4;
                break;
            case R.id.rating_imv_rating5:
                rating = 5;
                break;
        }
//        UiUtil.getPreference().setRating(rating);
//        if (rating > 0 && rating < 4) {
//            AppEventTracker.logEvent("ratings_givefeedbackclicked");
//            UiUtil.getPreference().setRatingStatusTutorial(true);
//            launchEmailIntent(getActivity(), UiUtil.getString(R.string.feedback), UiUtil.getPreference().getMobile());
//        } else {
//            UiUtil.getPreference().setRatingStatusTutorial(true);
//            AppEventTracker.logEvent("ratings_playstoreclicked ");
//            launchPlayStore();
//        }
        dismiss();
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rating_btn_rating:
                //showing rating dialog delay by 24 hrs or 86400000 millisec
                dismiss();
                break;
            case R.id.rating_btn_feedback:
                handleFeedbackClick();

                break;


        }
    }

}
