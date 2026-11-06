package androidx.compose.ui.platform;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ViewRootForInspector {
    default AbstractComposeView getSubCompositionView() {
        return null;
    }

    default View getViewRoot() {
        return null;
    }
}
