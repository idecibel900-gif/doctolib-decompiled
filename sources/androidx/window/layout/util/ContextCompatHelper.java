package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextCompatHelper {
    public static final ContextCompatHelper INSTANCE = new ContextCompatHelper();

    private ContextCompatHelper() {
    }

    public final Context unwrapUiContext$window_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService)) {
                return baseContext;
            }
            ContextWrapper contextWrapper = (ContextWrapper) baseContext;
            if (contextWrapper.getBaseContext() == null) {
                return baseContext;
            }
            baseContext = contextWrapper.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "iterator.baseContext");
        }
        throw new IllegalArgumentException("Context " + context + " is not a UiContext");
    }
}
