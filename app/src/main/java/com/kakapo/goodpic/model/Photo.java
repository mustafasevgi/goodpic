
package com.kakapo.goodpic.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mustafasevgi on 15/02/16.
 */
public class Photo {
   @SerializedName("previewHeight")
   private int    previewHeight;
   @SerializedName("largeImageURL")
   private String largeImageURL;
   @SerializedName("fullHDURL")
   private String fullHDURL;
   @SerializedName("webformatHeight")
   private int    webformatHeight;
   @SerializedName("webformatWidth")
   private int    webformatWidth;
   @SerializedName("previewURL")
   private String previewURL;
   @SerializedName("imageWidth")
   private int    imageWidth;
   @SerializedName("user_id")
   private int    userId;
   @SerializedName("imageURL")
   private String imageURL;
   @SerializedName("userImageURL")
   private String userImageURL;
   @SerializedName("webformatURL")
   private String webformatURL;
   @SerializedName("id_hash")
   private String idHash;
   @SerializedName("type")
   private String type;
   @SerializedName("user")
   private String user;

   public int getPreviewHeight() {
      return previewHeight;
   }

   public void setPreviewHeight(int previewHeight) {
      this.previewHeight = previewHeight;
   }

   public String getLargeImageURL() {
      return largeImageURL;
   }

   public void setLargeImageURL(String largeImageURL) {
      this.largeImageURL = largeImageURL;
   }

   public String getFullHDURL() {
      return fullHDURL;
   }

   public void setFullHDURL(String fullHDURL) {
      this.fullHDURL = fullHDURL;
   }

   public int getWebformatHeight() {
      return webformatHeight;
   }

   public void setWebformatHeight(int webformatHeight) {
      this.webformatHeight = webformatHeight;
   }

   public int getWebformatWidth() {
      return webformatWidth;
   }

   public void setWebformatWidth(int webformatWidth) {
      this.webformatWidth = webformatWidth;
   }

   public String getPreviewURL() {
      return previewURL;
   }

   public void setPreviewURL(String previewURL) {
      this.previewURL = previewURL;
   }

   public int getImageWidth() {
      return imageWidth;
   }

   public void setImageWidth(int imageWidth) {
      this.imageWidth = imageWidth;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getImageURL() {
      return imageURL;
   }

   public void setImageURL(String imageURL) {
      this.imageURL = imageURL;
   }

   public String getUserImageURL() {
      return userImageURL;
   }

   public void setUserImageURL(String userImageURL) {
      this.userImageURL = userImageURL;
   }

   public String getWebformatURL() {
      return webformatURL;
   }

   public void setWebformatURL(String webformatURL) {
      this.webformatURL = webformatURL;
   }

   public String getIdHash() {
      return idHash;
   }

   public void setIdHash(String idHash) {
      this.idHash = idHash;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }
}
