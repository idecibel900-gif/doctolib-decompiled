package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface RememberObserver {
    void onAbandoned();

    void onForgotten();

    void onRemembered();
}
