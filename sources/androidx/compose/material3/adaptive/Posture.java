package androidx.compose.material3.adaptive;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Posture {
    private final List hingeList;
    private final boolean isTabletop;

    public Posture(boolean z, List list) {
        this.isTabletop = z;
        this.hingeList = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Posture)) {
            return false;
        }
        Posture posture = (Posture) obj;
        return this.isTabletop == posture.isTabletop && Intrinsics.areEqual(this.hingeList, posture.hingeList);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isTabletop) * 31) + this.hingeList.hashCode();
    }

    public String toString() {
        return "Posture(isTabletop=" + this.isTabletop + ", hinges=[" + CollectionsKt.joinToString$default(this.hingeList, ", ", null, null, 0, null, null, 62, null) + "])";
    }
}
