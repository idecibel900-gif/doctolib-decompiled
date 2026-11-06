package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u001c\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\f\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0004¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/s6;", "", "", "getVersion", "()I", DiagnosticsEntry.VERSION_KEY, "", "getLastUpdated", "()Ljava/lang/String;", "lastUpdated", "", "Lio/didomi/sdk/Vendor;", "a", "()Ljava/util/Map;", Didomi.VIEW_VENDORS, "Lio/didomi/sdk/e7;", "c", Didomi.VIEW_PURPOSES, "g", "features", "d", "specialPurposes", "b", "specialFeatures", "e", "dataCategories", "f", "(I)V", "maxVendorId", "getTcfPolicyVersion", "tcfPolicyVersion", "android_release"}, k = 1, mv = {1, 8, 0})
public interface s6 {
    Map<String, Vendor> a();

    void a(int i);

    Map<String, InternalPurpose> b();

    Map<String, InternalPurpose> c();

    Map<String, InternalPurpose> d();

    Map<String, InternalPurpose> e();

    int f();

    Map<String, InternalPurpose> g();

    String getLastUpdated();

    int getTcfPolicyVersion();

    int getVersion();
}
