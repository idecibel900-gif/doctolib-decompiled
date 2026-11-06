package com.revenuecat.purchases.google.usecase;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchasesUseCaseParams;", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "appInBackground", "", "(Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Z)V", "getAppInBackground", "()Z", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "getDiagnosticsTrackerIfEnabled", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class QueryPurchasesUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;

    public static /* synthetic */ QueryPurchasesUseCaseParams copy$default(QueryPurchasesUseCaseParams queryPurchasesUseCaseParams, DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dateProvider = queryPurchasesUseCaseParams.dateProvider;
        }
        if ((i & 2) != 0) {
            diagnosticsTracker = queryPurchasesUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        if ((i & 4) != 0) {
            z = queryPurchasesUseCaseParams.appInBackground;
        }
        return queryPurchasesUseCaseParams.copy(dateProvider, diagnosticsTracker, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final QueryPurchasesUseCaseParams copy(DateProvider dateProvider, DiagnosticsTracker diagnosticsTrackerIfEnabled, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        return new QueryPurchasesUseCaseParams(dateProvider, diagnosticsTrackerIfEnabled, appInBackground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryPurchasesUseCaseParams)) {
            return false;
        }
        QueryPurchasesUseCaseParams queryPurchasesUseCaseParams = (QueryPurchasesUseCaseParams) other;
        return Intrinsics.areEqual(this.dateProvider, queryPurchasesUseCaseParams.dateProvider) && Intrinsics.areEqual(this.diagnosticsTrackerIfEnabled, queryPurchasesUseCaseParams.diagnosticsTrackerIfEnabled) && this.appInBackground == queryPurchasesUseCaseParams.appInBackground;
    }

    public int hashCode() {
        int iHashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        return ((iHashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "QueryPurchasesUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", appInBackground=" + this.appInBackground + ')';
    }

    public QueryPurchasesUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.dateProvider = dateProvider;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.appInBackground = z;
    }

    public /* synthetic */ QueryPurchasesUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultDateProvider() : dateProvider, diagnosticsTracker, z);
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }
}
