package bigapp.utsav.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import bigapp.utsav.model.Festival;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by nitikaaggarwal on 14/06/16.
 */
public class Uiutils {
    public static void showToast(Activity activity, String message) {

        if (activity == null || activity.isFinishing()) {
            return;
        }
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showDialogFragment(Activity activity, Fragment fragment, String tag) {

        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            FragmentTransaction ft = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
            ft.add(fragment, tag);
            ft.commitAllowingStateLoss();
        }
    }

    public static String getOrderFirstCharacter(Festival festival) {
        String firstLetter = "X";
        if (festival == null) {
            firstLetter = "X";
        } else if ((festival.getTitle() != null)) {
            firstLetter = String.valueOf(festival.getTitle().toString().substring(0, 1));
        }
        return firstLetter;
    }

    public static Drawable getTextDrawable(String text, @DimenRes int width, @DimenRes int height) {
        int widthPixcel = getDimension(width);
        int heightPixcel = getDimension(height);
        TextDrawable.IBuilder mDrawableBuilder = TextDrawable.builder()
                .beginConfig()
                .width(widthPixcel)
                .height(heightPixcel)
                .endConfig()
                .round();
        ColorGenerator mColorGenerator = ColorGenerator.ALPHA;
        return mDrawableBuilder.build(text.toUpperCase(), mColorGenerator.getAlphabeticalColor(text));
    }
    public static int getDimension(@DimenRes int dimen) {
        int pixelValue = 0;
        try {
            pixelValue = 24;
        } catch (Resources.NotFoundException exception) {
            pixelValue = 0;
        }
        return pixelValue;
    }
}
