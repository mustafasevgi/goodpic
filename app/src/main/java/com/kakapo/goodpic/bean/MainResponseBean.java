
package com.kakapo.goodpic.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 15/02/16.
 */
public class MainResponseBean {
   @SerializedName("totalHints")
   private int         totalHints;
   @SerializedName("hits")
   private List<Photo> hits;
   @SerializedName("total")
   private long        total;
}
