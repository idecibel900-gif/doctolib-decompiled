package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
final class MutableScatterMultiMap {
    private final MutableScatterMap map;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MutableScatterMultiMap m1071boximpl(MutableScatterMap mutableScatterMap) {
        return new MutableScatterMultiMap(mutableScatterMap);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static MutableScatterMap m1072constructorimpl(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1073equalsimpl(MutableScatterMap mutableScatterMap, Object obj) {
        return (obj instanceof MutableScatterMultiMap) && Intrinsics.areEqual(mutableScatterMap, ((MutableScatterMultiMap) obj).m1078unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1074hashCodeimpl(MutableScatterMap mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1077toStringimpl(MutableScatterMap mutableScatterMap) {
        return "MutableScatterMultiMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m1073equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m1074hashCodeimpl(this.map);
    }

    public String toString() {
        return m1077toStringimpl(this.map);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ MutableScatterMap m1078unboximpl() {
        return this.map;
    }

    private /* synthetic */ MutableScatterMultiMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final Object m1075popimpl(MutableScatterMap mutableScatterMap, Object obj) {
        Object obj2 = mutableScatterMap.get(obj);
        if (obj2 == null) {
            return null;
        }
        if (TypeIntrinsics.isMutableList(obj2)) {
            List listAsMutableList = TypeIntrinsics.asMutableList(obj2);
            Object objRemove = listAsMutableList.remove(0);
            if (listAsMutableList.isEmpty()) {
                mutableScatterMap.remove(obj);
            }
            obj2 = objRemove;
        } else {
            mutableScatterMap.remove(obj);
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return obj2;
    }

    /* JADX INFO: renamed from: put-impl, reason: not valid java name */
    public static final void m1076putimpl(MutableScatterMap mutableScatterMap, Object obj, Object obj2) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(obj);
        boolean z = iFindInsertIndex < 0;
        Object obj3 = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj3 != null) {
            if (TypeIntrinsics.isMutableList(obj3)) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List listAsMutableList = TypeIntrinsics.asMutableList(obj3);
                listAsMutableList.add(obj2);
                obj2 = listAsMutableList;
            } else {
                obj2 = CollectionsKt.mutableListOf(obj3, obj2);
            }
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = obj;
            mutableScatterMap.values[i] = obj2;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = obj2;
    }
}
