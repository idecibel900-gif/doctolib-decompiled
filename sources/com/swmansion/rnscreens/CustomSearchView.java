package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CustomSearchView extends SearchView {
    private final FragmentBackPressOverrider backPressOverrider;
    private OnBackPressedCallback onBackPressedCallback;
    private SearchView.OnCloseListener onCloseListener;
    private View.OnClickListener onSearchClickedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSearchView(Context context, Fragment fragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.swmansion.rnscreens.CustomSearchView$onBackPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.setIconified(true);
            }
        };
        this.onBackPressedCallback = onBackPressedCallback;
        this.backPressOverrider = new FragmentBackPressOverrider(fragment, onBackPressedCallback);
        super.setOnSearchClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.CustomSearchView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomSearchView._init_$lambda$0(this.f$0, view);
            }
        });
        super.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.swmansion.rnscreens.CustomSearchView$$ExternalSyntheticLambda1
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return CustomSearchView._init_$lambda$1(this.f$0);
            }
        });
        setMaxWidth(Integer.MAX_VALUE);
    }

    public final void setOverrideBackAction(boolean z) {
        this.backPressOverrider.setOverrideBackAction(z);
    }

    public final boolean getOverrideBackAction() {
        return this.backPressOverrider.getOverrideBackAction();
    }

    public final void focus() {
        setIconified(false);
        requestFocusFromTouch();
    }

    public final void clearText() {
        setQuery("", false);
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        setQuery(text, false);
    }

    public final void cancelSearch() {
        clearText();
        setIconified(true);
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setOnCloseListener(SearchView.OnCloseListener onCloseListener) {
        this.onCloseListener = onCloseListener;
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.onSearchClickedListener = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isIconified()) {
            return;
        }
        this.backPressOverrider.maybeAddBackCallback();
    }

    @Override // androidx.appcompat.widget.SearchView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.backPressOverrider.removeBackCallbackIfAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CustomSearchView customSearchView, View view) {
        View.OnClickListener onClickListener = customSearchView.onSearchClickedListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        customSearchView.backPressOverrider.maybeAddBackCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(CustomSearchView customSearchView) {
        SearchView.OnCloseListener onCloseListener = customSearchView.onCloseListener;
        boolean zOnClose = onCloseListener != null ? onCloseListener.onClose() : false;
        customSearchView.backPressOverrider.removeBackCallbackIfAdded();
        return zOnClose;
    }
}
