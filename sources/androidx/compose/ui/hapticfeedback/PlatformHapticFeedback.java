package androidx.compose.ui.hapticfeedback;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo1674performHapticFeedbackCdsT49E(int i) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m1676equalsimpl0(i, companion.m1677getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m1676equalsimpl0(i, companion.m1678getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
