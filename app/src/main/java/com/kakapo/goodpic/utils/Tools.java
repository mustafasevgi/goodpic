package com.kakapo.goodpic.utils;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class Tools {
    public static int getStatusBarHeight(BaseActivity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static Drawable getCurrentWallpaper(BaseActivity activity) {
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        return wallpaperDrawable;
    }

    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float pxToDp(int px, Context context) {
        float ht_px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
        return ht_px;
    }

    public static int getToolbarHeight(Context context) {
        // toolbar height+statusbar height
        int toolbarHeight = (int) context.getResources().getDimension(R.dimen.toolbar_height);
        return toolbarHeight;
    }

    public static void storeImage(Bitmap image, BaseActivity activity) {
        File pictureFile = getOutputMediaFile(activity);
        if (pictureFile == null) {
            Log.d("", "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("", "Error accessing file: " + e.getMessage());
        }
    }

    private static File getOutputMediaFile(BaseActivity activity) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory() + "/GoodPic/" + activity.getApplicationContext()
                .getPackageName() + "/Files");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdir();
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName = "MI_" + timeStamp + ".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }
}
