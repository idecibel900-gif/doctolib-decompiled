package androidx.fragment.app;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewKt {
    public static final Fragment findFragment(View view) {
        return FragmentManager.findFragment(view);
    }
}
