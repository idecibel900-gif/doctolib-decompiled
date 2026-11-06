package expo.modules.kotlin.views;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ErrorViewKt {
    public static final boolean isErrorView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view instanceof ErrorView) || (view instanceof ErrorGroupView);
    }
}
