package com.book.novel.readerartifact.ui.findbook.entity;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.book.novel.readerartifact.HiApplication;
import com.book.novel.readerartifact.R;


/**
 * Created by newbiechen on 17-4-25.
 */

public enum FindType {
    TOP(R.string.nb_fragment_find_top,R.drawable.ic_section_top),
    SORT(R.string.nb_fragment_find_sort,R.drawable.ic_section_sort),
    THEME(R.string.nb_fragment_find_topic,R.drawable.ic_section_topic),
    LISTEN(R.string.nb_fragment_find_listen,R.drawable.ic_section_listen);
    ;
    private String typeName;
    private int iconId;

    private FindType(@StringRes int typeNameId, @DrawableRes int iconId){
        this.typeName = HiApplication.getContext().getResources().getString(typeNameId);
        this.iconId = iconId;
    }

    public String getTypeName(){
        return typeName;
    }

    public int getIconId(){
        return iconId;
    }
}
