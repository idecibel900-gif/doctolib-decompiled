package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarDefaults {
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-551629101, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-shape> (Snackbar.kt:418)");
        }
        Shape value = ShapesKt.getValue(SnackbarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(987938253, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-color> (Snackbar.kt:422)");
        }
        long value = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1021310823, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-contentColor> (Snackbar.kt:426)");
        }
        long value = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getActionColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(743425465, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionColor> (Snackbar.kt:430)");
        }
        long value = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getActionContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1313141593, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionContentColor> (Snackbar.kt:434)");
        }
        long value = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getDismissActionContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-528602817, i, -1, "androidx.compose.material3.SnackbarDefaults.<get-dismissActionContentColor> (Snackbar.kt:438)");
        }
        long value = ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getIconColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }
}
