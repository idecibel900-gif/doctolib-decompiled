package androidx.compose.ui.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringResources_androidKt {
    public static final String stringResource(int i, Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1223887937, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = Resources_androidKt.resources(composer, 0).getString(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }
}
