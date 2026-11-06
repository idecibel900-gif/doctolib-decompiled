package app.screeb.sdk.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0304h {
    public final String a;
    public final ArrayList b;

    public C0304h(String channelId, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.a = channelId;
        this.b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0304h)) {
            return false;
        }
        C0304h c0304h = (C0304h) obj;
        return Intrinsics.areEqual(this.a, c0304h.a) && Intrinsics.areEqual(this.b, c0304h.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        ArrayList arrayList = this.b;
        return iHashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        return "Action(channelId=" + this.a + ", command=" + this.b + ")";
    }
}
