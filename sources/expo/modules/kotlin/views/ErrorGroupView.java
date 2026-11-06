package expo.modules.kotlin.views;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorGroupView extends ViewGroup {
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorGroupView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
