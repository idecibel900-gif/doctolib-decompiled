package com.swmansion.rnscreens;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SearchViewFormatter {
    private Integer defaultTextColor;
    private Drawable defaultTintBackground;
    private SearchView searchView;

    public SearchViewFormatter(SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        this.searchView = searchView;
    }

    private final EditText getSearchEditText() {
        View viewFindViewById = this.searchView.findViewById(R$id.search_src_text);
        if (viewFindViewById instanceof EditText) {
            return (EditText) viewFindViewById;
        }
        return null;
    }

    private final View getSearchTextPlate() {
        return this.searchView.findViewById(R$id.search_plate);
    }

    private final ImageView getSearchIcon() {
        return (ImageView) this.searchView.findViewById(R$id.search_button);
    }

    private final ImageView getSearchCloseIcon() {
        return (ImageView) this.searchView.findViewById(R$id.search_close_btn);
    }

    public final void setTextColor(Integer num) {
        EditText searchEditText;
        ColorStateList textColors;
        Integer num2 = this.defaultTextColor;
        if (num == null) {
            if (num2 == null || (searchEditText = getSearchEditText()) == null) {
                return;
            }
            searchEditText.setTextColor(num2.intValue());
            return;
        }
        if (num2 == null) {
            EditText searchEditText2 = getSearchEditText();
            this.defaultTextColor = (searchEditText2 == null || (textColors = searchEditText2.getTextColors()) == null) ? null : Integer.valueOf(textColors.getDefaultColor());
        }
        EditText searchEditText3 = getSearchEditText();
        if (searchEditText3 != null) {
            searchEditText3.setTextColor(num.intValue());
        }
    }

    public final void setTintColor(Integer num) {
        Drawable drawable = this.defaultTintBackground;
        if (num != null) {
            if (drawable == null) {
                this.defaultTintBackground = getSearchTextPlate().getBackground();
            }
            getSearchTextPlate().setBackgroundColor(num.intValue());
        } else if (drawable != null) {
            getSearchTextPlate().setBackground(drawable);
        }
    }

    public final void setHeaderIconColor(Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            getSearchIcon().setColorFilter(iIntValue);
            getSearchCloseIcon().setColorFilter(iIntValue);
        }
    }

    public final void setHintTextColor(Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            EditText searchEditText = getSearchEditText();
            if (searchEditText != null) {
                searchEditText.setHintTextColor(iIntValue);
            }
        }
    }

    public final void setPlaceholder(String placeholder, boolean z) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        if (z) {
            this.searchView.setQueryHint(placeholder);
            return;
        }
        EditText searchEditText = getSearchEditText();
        if (searchEditText != null) {
            searchEditText.setHint(placeholder);
        }
    }
}
