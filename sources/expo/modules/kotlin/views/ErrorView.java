package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorView extends View {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
