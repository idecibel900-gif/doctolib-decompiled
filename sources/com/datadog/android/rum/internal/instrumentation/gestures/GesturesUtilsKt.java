package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.datadog.android.internal.utils.NumberExtKt;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GesturesUtilsKt {
    public static final String resolveViewTargetName(InteractionPredicate interactionPredicate, ViewTarget target) {
        String strResolveTargetName;
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(target, "target");
        View view = (View) target.getViewRef().get();
        if (view != null && (strResolveTargetName = resolveTargetName(interactionPredicate, view)) != null) {
            return strResolveTargetName;
        }
        target.getNode();
        return "";
    }

    public static final String resolveTargetName(InteractionPredicate interactionPredicate, Object target) {
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(target, "target");
        String targetName = interactionPredicate.getTargetName(target);
        return (targetName == null || targetName.length() == 0) ? "" : targetName;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    public static final String resourceIdName(Context context, int i) {
        String resourceEntryName;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                if (resources != null) {
                    resourceEntryName = resources.getResourceEntryName(i);
                } else {
                    resourceEntryName = null;
                }
            } catch (Resources.NotFoundException unused) {
                return idAsStringHexa(i);
            }
        } else {
            resourceEntryName = null;
        }
        return resourceEntryName == null ? idAsStringHexa(i) : resourceEntryName;
    }

    public static final String targetClassName(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        String canonicalName = view.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    private static final String idAsStringHexa(int i) {
        return "0x" + NumberExtKt.toHexString(i);
    }
}
