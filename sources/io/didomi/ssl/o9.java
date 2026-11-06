package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/o9;", "", "", "getId", "()J", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/o9$a;", "a", "()Lio/didomi/sdk/o9$a;", "type", "", "b", "()Z", "preventListAccessibilityAnnouncement", "android_release"}, k = 1, mv = {1, 8, 0})
public interface o9 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lio/didomi/sdk/o9$a;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "c", "d", "e", "f", "g", "h", "android_release"}, k = 1, mv = {1, 8, 0})
    public enum a {
        AdditionalDataProcessing,
        BulkAction,
        Category,
        CategoryHeader,
        Header,
        Purpose,
        SensitivePersonalInfoButton,
        VendorButton
    }

    a a();

    boolean b();

    long getId();
}
