package com.kakapo.goodpic.bean;

import com.google.gson.annotations.SerializedName;
import com.kakapo.goodpic.model.Photo;

import java.util.List;

/**
 * Created by mustafasevgi on 15/02/16.
 */
public class MainResponseBean {
    @SerializedName("totalHints")
    private int totalHints;
    @SerializedName("hits")
    private List<Photo> hits;
    @SerializedName("total")
    private long total;

    public int getTotalHints() {
        return totalHints;
    }

    public void setTotalHints(int totalHints) {
        this.totalHints = totalHints;
    }

    public List<Photo> getHits() {
        return hits;
    }

    public void setHits(List<Photo> hits) {
        this.hits = hits;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
