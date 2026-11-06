package expo.modules.fetch;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RequestUtilsKt {
    public static final Headers toHeaders(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builder.add((String) pair.getFirst(), (String) pair.getSecond());
        }
        return builder.build();
    }
}
