package com.kakapo.goodpic.view;

import com.kakapo.goodpic.model.Photo;

import java.util.List;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface MainView extends BaseView {
    void setItems(List<Photo> list);

    void emptyMode();
}
