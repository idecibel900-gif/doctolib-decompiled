package com.revenuecat.purchases;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/DebugEvent;", "", "name", "Lcom/revenuecat/purchases/DebugEventName;", DiagnosticsEntry.PROPERTIES_KEY, "", "", "(Lcom/revenuecat/purchases/DebugEventName;Ljava/util/Map;)V", "getName", "()Lcom/revenuecat/purchases/DebugEventName;", "getProperties", "()Ljava/util/Map;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebugEvent {
    private final DebugEventName name;
    private final Map<String, String> properties;

    public DebugEvent(DebugEventName name, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.name = name;
        this.properties = properties;
    }

    public final DebugEventName getName() {
        return this.name;
    }

    public /* synthetic */ DebugEvent(DebugEventName debugEventName, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(debugEventName, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }
}
