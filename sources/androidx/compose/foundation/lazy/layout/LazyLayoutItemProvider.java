package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;

/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutItemProvider {
    void Item(int i, Object obj, Composer composer, int i2);

    default Object getContentType(int i) {
        return null;
    }

    int getIndex(Object obj);

    int getItemCount();

    Object getKey(int i);
}
