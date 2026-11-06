package app.screeb.sdk.internal;

import com.adjust.sdk.Constants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0306i {
    public static C0304h a(String str, String str2, String str3, String str4) {
        String strReplace$default;
        Map mapEmptyMap;
        ArrayList arrayListArrayListOf = null;
        if (str == null || !StringsKt.startsWith$default(str, "screeb-", false, 2, (Object) null) || str2 == null || (strReplace$default = StringsKt.replace$default(str2, "screeb-", "", false, 4, (Object) null)) == null || strReplace$default.length() == 0) {
            return null;
        }
        if (str4 == null || str4.length() == 0) {
            mapEmptyMap = MapsKt.emptyMap();
        } else {
            List listSplit$default = StringsKt.split$default((CharSequence) str4, new String[]{"&"}, false, 0, 6, (Object) null);
            mapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10)), 16));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{com.amazon.a.a.o.b.f.b}, false, 2, 2, (Object) null);
                Pair pair = TuplesKt.to(a((String) listSplit$default2.get(0)), listSplit$default2.size() == 2 ? a((String) listSplit$default2.get(1)) : "");
                mapEmptyMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        if (Intrinsics.areEqual(str3, "editor")) {
            String str5 = (String) mapEmptyMap.get("token");
            if (str5 != null) {
                arrayListArrayListOf = CollectionsKt.arrayListOf("editor.start", str5);
            }
        } else if (Intrinsics.areEqual(str3, "inspector")) {
            arrayListArrayListOf = CollectionsKt.arrayListOf("inspector.open");
        }
        return new C0304h(strReplace$default, arrayListArrayListOf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String a(String str) {
        try {
            String strDecode = URLDecoder.decode(StringsKt.replace$default(str, "+", "%2B", false, 4, (Object) null), Constants.ENCODING);
            Intrinsics.checkNotNull(strDecode);
            return strDecode;
        } catch (Exception unused) {
            return str;
        }
    }
}
