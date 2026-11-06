package androidx.compose.ui.platform;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewTranslationCallbackS {
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    private AndroidComposeViewTranslationCallbackS() {
    }

    public final void setViewTranslationCallback(View view) {
        view.setViewTranslationCallback(AndroidComposeViewTranslationCallback.INSTANCE);
    }

    public final void clearViewTranslationCallback(View view) {
        view.clearViewTranslationCallback();
    }
}
