package com.revenuecat.purchases;

import com.amazon.device.simplesignin.a.a.a;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/CreateSupportTicketResult;", "", a.s, "", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CreateSupportTicketResult {
    private final boolean success;

    public static /* synthetic */ CreateSupportTicketResult copy$default(CreateSupportTicketResult createSupportTicketResult, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = createSupportTicketResult.success;
        }
        return createSupportTicketResult.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final CreateSupportTicketResult copy(boolean success) {
        return new CreateSupportTicketResult(success);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateSupportTicketResult) && this.success == ((CreateSupportTicketResult) other).success;
    }

    public int hashCode() {
        return Boolean.hashCode(this.success);
    }

    public String toString() {
        return "CreateSupportTicketResult(success=" + this.success + ')';
    }

    public CreateSupportTicketResult(boolean z) {
        this.success = z;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
