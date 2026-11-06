package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"min", "Lkotlin/time/Duration;", "duration1", "duration2", "min-QTBD994", "(JJ)J", "between", "Lkotlin/time/Duration$Companion;", "startTime", "Ljava/util/Date;", "endTime", "(Lkotlin/time/Duration$Companion;Ljava/util/Date;Ljava/util/Date;)J", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DurationExtensionsKt {
    public static final long between(Duration.Companion companion, Date startTime, Date endTime) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        return DurationKt.toDuration(endTime.getTime() - startTime.getTime(), DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: min-QTBD994, reason: not valid java name */
    public static final long m3853minQTBD994(long j, long j2) {
        return Duration.m5400compareToLRDsOJo(j, j2) < 0 ? j : j2;
    }
}
