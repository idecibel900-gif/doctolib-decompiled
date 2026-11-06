package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagData;", "", "eTag", "", "lastRefreshTime", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getETag", "()Ljava/lang/String;", "getLastRefreshTime", "()Ljava/util/Date;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ETagData {
    private final String eTag;
    private final Date lastRefreshTime;

    public static /* synthetic */ ETagData copy$default(ETagData eTagData, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eTagData.eTag;
        }
        if ((i & 2) != 0) {
            date = eTagData.lastRefreshTime;
        }
        return eTagData.copy(str, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getETag() {
        return this.eTag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    public final ETagData copy(String eTag, Date lastRefreshTime) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        return new ETagData(eTag, lastRefreshTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ETagData)) {
            return false;
        }
        ETagData eTagData = (ETagData) other;
        return Intrinsics.areEqual(this.eTag, eTagData.eTag) && Intrinsics.areEqual(this.lastRefreshTime, eTagData.lastRefreshTime);
    }

    public int hashCode() {
        int iHashCode = this.eTag.hashCode() * 31;
        Date date = this.lastRefreshTime;
        return iHashCode + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "ETagData(eTag=" + this.eTag + ", lastRefreshTime=" + this.lastRefreshTime + ')';
    }

    public ETagData(String eTag, Date date) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        this.eTag = eTag;
        this.lastRefreshTime = date;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final Date getLastRefreshTime() {
        return this.lastRefreshTime;
    }
}
