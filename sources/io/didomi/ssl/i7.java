package io.didomi.ssl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\u0006\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J \u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¨\u0006\r"}, d2 = {"Lio/didomi/sdk/i7;", "", "", "", "list", "prefix", "a", "", "Lio/didomi/sdk/m1;", "dataProcessings", "b", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class i7 {
    public static final i7 a = new i7();

    private i7() {
    }

    static /* synthetic */ String a(i7 i7Var, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "•";
        }
        return i7Var.a(list, str);
    }

    public static /* synthetic */ String b(i7 i7Var, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "•";
        }
        return i7Var.b(list, str);
    }

    public final String a(Collection<? extends m1> dataProcessings) {
        Intrinsics.checkNotNullParameter(dataProcessings, "dataProcessings");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dataProcessings, 10));
        Iterator<T> it = dataProcessings.iterator();
        while (it.hasNext()) {
            arrayList.add(((m1) it.next()).getName());
        }
        return a(this, arrayList, null, 2, null);
    }

    public final String b(List<String> list, String prefix) {
        List<String> list2;
        Intrinsics.checkNotNullParameter(list, "list");
        if (prefix != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(prefix + ' ' + ((String) it.next()));
            }
            list2 = arrayList;
        } else {
            list2 = list;
        }
        return CollectionsKt.joinToString$default(list2, "\n", null, null, 0, null, null, 62, null);
    }

    private final String a(List<String> list, String prefix) {
        if (prefix != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(prefix + ' ' + ((String) it.next()));
            }
            list = arrayList;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.sorted(list), "\n", null, null, 0, null, null, 62, null);
    }
}
