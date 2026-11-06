package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001BU\u00120\u0010\u0006\u001a,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJd\u0010\u0010\u001a\u00020\u000022\b\u0002\u0010\u0006\u001a,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aRA\u0010\u0006\u001a,\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", "", "Lkotlin/Function4;", "", "Lkotlin/Function0;", "", "onSubmit", "onCancel", "onClose", "<init>", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "component1", "()Lkotlin/jvm/functions/Function4;", "component2", "()Lkotlin/jvm/functions/Function0;", "component3", "copy", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function4;", "getOnSubmit", "Lkotlin/jvm/functions/Function0;", "getOnCancel", "getOnClose", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CreateSupportTicketData {
    public static final int $stable = 0;
    private final Function0 onCancel;
    private final Function0 onClose;
    private final Function4 onSubmit;

    public static /* synthetic */ CreateSupportTicketData copy$default(CreateSupportTicketData createSupportTicketData, Function4 function4, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function4 = createSupportTicketData.onSubmit;
        }
        if ((i & 2) != 0) {
            function0 = createSupportTicketData.onCancel;
        }
        if ((i & 4) != 0) {
            function1 = createSupportTicketData.onClose;
        }
        return createSupportTicketData.copy(function4, function0, function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Function4 getOnSubmit() {
        return this.onSubmit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Function0 getOnCancel() {
        return this.onCancel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Function0 getOnClose() {
        return this.onClose;
    }

    public final CreateSupportTicketData copy(Function4 onSubmit, Function0 onCancel, Function0 onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        return new CreateSupportTicketData(onSubmit, onCancel, onClose);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateSupportTicketData)) {
            return false;
        }
        CreateSupportTicketData createSupportTicketData = (CreateSupportTicketData) other;
        return Intrinsics.areEqual(this.onSubmit, createSupportTicketData.onSubmit) && Intrinsics.areEqual(this.onCancel, createSupportTicketData.onCancel) && Intrinsics.areEqual(this.onClose, createSupportTicketData.onClose);
    }

    public int hashCode() {
        return (((this.onSubmit.hashCode() * 31) + this.onCancel.hashCode()) * 31) + this.onClose.hashCode();
    }

    public String toString() {
        return "CreateSupportTicketData(onSubmit=" + this.onSubmit + ", onCancel=" + this.onCancel + ", onClose=" + this.onClose + ')';
    }

    public CreateSupportTicketData(Function4 onSubmit, Function0 onCancel, Function0 onClose) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.onSubmit = onSubmit;
        this.onCancel = onCancel;
        this.onClose = onClose;
    }

    public final /* synthetic */ Function4 getOnSubmit() {
        return this.onSubmit;
    }

    public final /* synthetic */ Function0 getOnCancel() {
        return this.onCancel;
    }

    public final /* synthetic */ Function0 getOnClose() {
        return this.onClose;
    }
}
