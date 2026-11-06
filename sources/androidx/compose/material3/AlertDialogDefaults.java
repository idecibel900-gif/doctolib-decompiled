package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogDefaults {
    public static final AlertDialogDefaults INSTANCE = new AlertDialogDefaults();
    private static final float TonalElevation = Dp.m2551constructorimpl(0);

    private AlertDialogDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-952504159, i, -1, "androidx.compose.material3.AlertDialogDefaults.<get-shape> (AlertDialog.kt:207)");
        }
        Shape value = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(616766901, i, -1, "androidx.compose.material3.AlertDialogDefaults.<get-containerColor> (AlertDialog.kt:211)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getIconContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1646653461, i, -1, "androidx.compose.material3.AlertDialogDefaults.<get-iconContentColor> (AlertDialog.kt:215)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getIconColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getTitleContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(247083549, i, -1, "androidx.compose.material3.AlertDialogDefaults.<get-titleContentColor> (AlertDialog.kt:219)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getHeadlineColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final long getTextContentColor(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1729845653, i, -1, "androidx.compose.material3.AlertDialogDefaults.<get-textContentColor> (AlertDialog.kt:223)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getSupportingTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m689getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }
}
