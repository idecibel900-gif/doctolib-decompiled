package coil.target;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public interface Target {
    default void onError(Drawable drawable) {
    }

    default void onStart(Drawable drawable) {
    }

    default void onSuccess(Drawable drawable) {
    }
}
