package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/networking/PostReceiptProductInfo;", "", "shouldConsume", "", "(Ljava/lang/Boolean;)V", "getShouldConsume", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/networking/PostReceiptProductInfo;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostReceiptProductInfo {
    private final Boolean shouldConsume;

    public static /* synthetic */ PostReceiptProductInfo copy$default(PostReceiptProductInfo postReceiptProductInfo, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = postReceiptProductInfo.shouldConsume;
        }
        return postReceiptProductInfo.copy(bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getShouldConsume() {
        return this.shouldConsume;
    }

    public final PostReceiptProductInfo copy(Boolean shouldConsume) {
        return new PostReceiptProductInfo(shouldConsume);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PostReceiptProductInfo) && Intrinsics.areEqual(this.shouldConsume, ((PostReceiptProductInfo) other).shouldConsume);
    }

    public int hashCode() {
        Boolean bool = this.shouldConsume;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "PostReceiptProductInfo(shouldConsume=" + this.shouldConsume + ')';
    }

    public PostReceiptProductInfo(Boolean bool) {
        this.shouldConsume = bool;
    }

    public final Boolean getShouldConsume() {
        return this.shouldConsume;
    }
}
