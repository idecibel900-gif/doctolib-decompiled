package com.revenuecat.purchases.common.caching;

import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"CUSTOMER_INFO_SCHEMA_VERSION", "", "PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD", "Lkotlin/time/Duration;", "J", "SHARED_PREFERENCES_PREFIX", "", "tokenMapSerializer", "Lkotlinx/serialization/KSerializer;", "", "Lcom/revenuecat/purchases/common/caching/TokenCacheEntry;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    private static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";
    private static final KSerializer tokenMapSerializer;

    static {
        Duration.Companion companion = Duration.Companion;
        PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = DurationKt.toDuration(25, DurationUnit.HOURS);
        tokenMapSerializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), TokenCacheEntry.INSTANCE.serializer());
    }
}
