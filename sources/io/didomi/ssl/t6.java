package io.didomi.ssl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0000¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/s6;", "Lio/didomi/sdk/kb;", "sdkConfiguration", "", "a", "Ljava/util/Date;", "android_release"}, k = 2, mv = {1, 8, 0})
public final class t6 {
    public static final void a(s6 s6Var, kb sdkConfiguration) {
        Intrinsics.checkNotNullParameter(s6Var, "<this>");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        s6Var.a(0);
        for (Vendor vendor : s6Var.a().values()) {
            vendor.setNamespace("iab");
            vendor.setPurposeIds(lb.a(sdkConfiguration, vendor.getPurposeIds()));
            vendor.setLegIntPurposeIds(lb.a(sdkConfiguration, vendor.getLegIntPurposeIds()));
            vendor.setFlexiblePurposeIds(lb.a(sdkConfiguration, vendor.getFlexiblePurposeIds()));
            int i = Integer.parseInt(vendor.getId());
            if (i > s6Var.f()) {
                s6Var.a(i);
            }
        }
    }

    public static final Date a(s6 s6Var) {
        Intrinsics.checkNotNullParameter(s6Var, "<this>");
        String lastUpdated = s6Var.getLastUpdated();
        if (lastUpdated != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(lastUpdated);
            } catch (ParseException e) {
                Log.e("Error parsing date: " + s6Var.getLastUpdated(), e);
            }
        }
        return null;
    }
}
