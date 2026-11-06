package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static Set emptySet() {
        return EmptySet.INSTANCE;
    }

    public static Set setOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toSet(elements);
    }

    public static Set mutableSetOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }

    public static HashSet hashSetOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.toCollection(elements, new HashSet(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }

    public static LinkedHashSet linkedSetOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }

    public static Set setOfNotNull(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet());
    }

    public static final Set optimizeReadOnlySet(Set set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : SetsKt__SetsJVMKt.setOf(set.iterator().next());
        }
        return emptySet();
    }
}
