
package com.kakapo.goodpic.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

/**
 * Created by mustafasevgi on 21/02/16.
 */
public class FileUtils {

   public static String saveBitmapToFile(Context context, Bitmap bmp) {
      File mAppBaseDir;
      if (isExternalStorageWritable())
         mAppBaseDir = new File(Environment.getExternalStorageDirectory(), "good");
      else
         mAppBaseDir = new File(context.getFilesDir().getParent()).getAbsoluteFile();

      if (!mAppBaseDir.exists()) {
         mAppBaseDir.mkdirs();
      }
      File imageDir = new File(mAppBaseDir, "Profile");
      if (!imageDir.exists())
         imageDir.mkdirs();
      File file = new File(imageDir + "/" + "profile.png");
      if (file.exists()) {
         file.delete();
      }
      try {
         writeBytesToFile(file, bitmapToByte(bmp));
         return file.getAbsolutePath();
      }
      catch (IOException e) {
         // show alert for retry choose photo
         e.printStackTrace();
      }
      return "";
   }

   public static byte[] bitmapToByte(Bitmap bitmapFinally) {
      ByteArrayOutputStream stream = new ByteArrayOutputStream();
      bitmapFinally.compress(Bitmap.CompressFormat.PNG, 100, stream);
      byte[] byteArray = stream.toByteArray();
      return byteArray;
   }

   public static void writeBytesToFile(File file, byte[] bytes) throws IOException {
      BufferedOutputStream bos = null;

      try {
         FileOutputStream fos = new FileOutputStream(file.getPath());
         bos = new BufferedOutputStream(fos);
         bos.write(bytes);
      }
      catch (Exception e) {
         Log.e("", e.getMessage());
      }
      finally {
         if (bos != null) {
            try {
               bos.flush();
               bos.close();
            }
            catch (Exception e) {
               Log.e("", e.getMessage());
            }
         }
      }
   }

   public static boolean isExternalStorageWritable() {
      final String state = Environment.getExternalStorageState();
      return Environment.MEDIA_MOUNTED.equals(state);
   }

   public static Bitmap getBitmapFromLocalPath(String path, int sampleSize) {
      try {
         BitmapFactory.Options options = new BitmapFactory.Options();
         options.inSampleSize = sampleSize;
         return BitmapFactory.decodeFile(path);
      }
      catch (Exception e) {
         // Logger.e(e.toString());
      }

      return null;
   }

   public static byte[] readFile(File file) throws IOException {
      // Open file
      RandomAccessFile f = new RandomAccessFile(file, "r");
      try {
         // Get and check length
         long longlength = f.length();
         int length = (int) longlength;
         if (length != longlength)
            throw new IOException("File size >= 2 GB");
         // Read file and return data
         byte[] data = new byte[length];
         f.readFully(data);
         return data;
      }
      finally {
         f.close();
      }
   }
}
