package app.screeb.sdk;

import android.view.View;
import app.screeb.sdk.internal.o0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"screebId", "", "Landroid/view/View;", DiagnosticsEntry.ID_KEY, "", "screebMaskText", "screebNoCapture", "sdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ScreebViewKt {
    public static final void screebId(View view, String id) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        view.setTag(R$id.screeb_id, id);
    }

    public static final void screebMaskText(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        o0.d(view);
    }

    public static final void screebNoCapture(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        o0.c(view);
    }
}
