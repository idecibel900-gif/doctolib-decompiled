package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/e;", "", "a", "", "hex", "", "android_release"}, k = 2, mv = {1, 8, 0})
public final class f {
    public static final boolean a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        String id = eVar.getUser().getId();
        double rate = eVar.getRate();
        try {
            if (id.length() == 36 && !Intrinsics.areEqual(id, "00000000-0000-0000-0000-000000000000") && rate > 0.0d && rate <= 1.0d) {
                String strSubstring = id.substring(id.length() - 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (((double) a(strSubstring)) / 255.0d <= rate) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("Error while checking user UUID in API event", e);
            return true;
        }
    }

    private static final int a(String str) {
        return Integer.parseInt(str, CharsKt.checkRadix(16));
    }
}
