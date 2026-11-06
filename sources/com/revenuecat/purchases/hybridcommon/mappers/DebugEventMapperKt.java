package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.DebugEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toMap", "", "", "", "Lcom/revenuecat/purchases/DebugEvent;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DebugEventMapperKt {
    public static final Map<String, Object> toMap(DebugEvent debugEvent) {
        Intrinsics.checkNotNullParameter(debugEvent, "<this>");
        return MapsKt.plus(MapsKt.mapOf(TuplesKt.to("type", debugEvent.getName().name())), debugEvent.getProperties());
    }
}
