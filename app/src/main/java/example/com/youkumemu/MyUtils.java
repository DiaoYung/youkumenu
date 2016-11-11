package example.com.youkumemu;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by root on 16-11-10.
 */
public class MyUtils {

    public static void startAnimOut(RelativeLayout view) {
        startAnimOut(view,0);
    }

    public static void startAnimIn(RelativeLayout view) {
        RotateAnimation animation = new RotateAnimation(180, 360, view.getWidth()/2, view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        view.startAnimation(animation);

    }

    public static void startAnimOut(RelativeLayout view, long i) {
        RotateAnimation animation = new RotateAnimation(0, 180, view.getWidth()/2, view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(i);
        view.startAnimation(animation);

    }

    public static void startAnimIn(RelativeLayout view, long i) {
        RotateAnimation animation = new RotateAnimation(180, 360, view.getWidth()/2, view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(i);
        view.startAnimation(animation);

    }
}
