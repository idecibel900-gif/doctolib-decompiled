package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static List filterIsInstance(Iterable iterable, Class klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), klass);
    }

    public static final Collection filterIsInstanceTo(Iterable iterable, Collection destination, Class klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static void reverse(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }
}
