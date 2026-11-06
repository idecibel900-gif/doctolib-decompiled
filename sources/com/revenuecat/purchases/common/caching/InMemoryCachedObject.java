package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "T", "", "lastUpdatedAt", "Ljava/util/Date;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Ljava/util/Date;Lcom/revenuecat/purchases/common/DateProvider;)V", "cachedInstance", "getCachedInstance", "()Ljava/lang/Object;", "setCachedInstance", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getLastUpdatedAt$purchases_defaultsBc8Release", "()Ljava/util/Date;", "setLastUpdatedAt$purchases_defaultsBc8Release", "(Ljava/util/Date;)V", "cacheInstance", "", "instance", "clearCache", "clearCacheTimestamp", "updateCacheTimestamp", "date", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InMemoryCachedObject<T> {
    private T cachedInstance;
    private final DateProvider dateProvider;
    private Date lastUpdatedAt;

    /* JADX WARN: Multi-variable type inference failed */
    public InMemoryCachedObject() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public InMemoryCachedObject(Date date, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.lastUpdatedAt = date;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: renamed from: getLastUpdatedAt$purchases_defaultsBc8Release, reason: from getter */
    public final Date getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final void setLastUpdatedAt$purchases_defaultsBc8Release(Date date) {
        this.lastUpdatedAt = date;
    }

    public /* synthetic */ InMemoryCachedObject(Date date, DateProvider dateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : date, (i & 2) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    public final T getCachedInstance() {
        return this.cachedInstance;
    }

    public final void setCachedInstance(T t) {
        this.cachedInstance = t;
    }

    public final void clearCacheTimestamp() {
        this.lastUpdatedAt = null;
    }

    public final void clearCache() {
        clearCacheTimestamp();
        this.cachedInstance = null;
    }

    public final void cacheInstance(T instance) {
        this.cachedInstance = instance;
        this.lastUpdatedAt = this.dateProvider.getNow();
    }

    public final void updateCacheTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.lastUpdatedAt = date;
    }
}
