package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PrefetchScheduler_androidKt {
    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141871251, i, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:31)");
        }
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new AndroidPrefetchScheduler(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        AndroidPrefetchScheduler androidPrefetchScheduler = (AndroidPrefetchScheduler) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return androidPrefetchScheduler;
    }
}
