package com.revenuecat.purchases.google.usecase;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchaseHistoryUseCaseParams;", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "productType", "", "appInBackground", "", "(Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Ljava/lang/String;Z)V", "getAppInBackground", "()Z", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "getDiagnosticsTrackerIfEnabled", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "getProductType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class QueryPurchaseHistoryUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final String productType;

    public static /* synthetic */ QueryPurchaseHistoryUseCaseParams copy$default(QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams, DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dateProvider = queryPurchaseHistoryUseCaseParams.dateProvider;
        }
        if ((i & 2) != 0) {
            diagnosticsTracker = queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        if ((i & 4) != 0) {
            str = queryPurchaseHistoryUseCaseParams.productType;
        }
        if ((i & 8) != 0) {
            z = queryPurchaseHistoryUseCaseParams.appInBackground;
        }
        return queryPurchaseHistoryUseCaseParams.copy(dateProvider, diagnosticsTracker, str, z);
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
    public final String getProductType() {
        return this.productType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final QueryPurchaseHistoryUseCaseParams copy(DateProvider dateProvider, DiagnosticsTracker diagnosticsTrackerIfEnabled, String productType, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new QueryPurchaseHistoryUseCaseParams(dateProvider, diagnosticsTrackerIfEnabled, productType, appInBackground);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryPurchaseHistoryUseCaseParams)) {
            return false;
        }
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams = (QueryPurchaseHistoryUseCaseParams) other;
        return Intrinsics.areEqual(this.dateProvider, queryPurchaseHistoryUseCaseParams.dateProvider) && Intrinsics.areEqual(this.diagnosticsTrackerIfEnabled, queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled) && Intrinsics.areEqual(this.productType, queryPurchaseHistoryUseCaseParams.productType) && this.appInBackground == queryPurchaseHistoryUseCaseParams.appInBackground;
    }

    public int hashCode() {
        int iHashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        return ((((iHashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "QueryPurchaseHistoryUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", productType=" + this.productType + ", appInBackground=" + this.appInBackground + ')';
    }

    public QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String productType, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.dateProvider = dateProvider;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.productType = productType;
        this.appInBackground = z;
    }

    public /* synthetic */ QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultDateProvider() : dateProvider, diagnosticsTracker, str, z);
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final String getProductType() {
        return this.productType;
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }
}
