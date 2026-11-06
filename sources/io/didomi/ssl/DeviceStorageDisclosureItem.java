package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.w1, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/w1;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "J", "b", "()J", DiagnosticsEntry.ID_KEY, "Ljava/lang/String;", "c", "()Ljava/lang/String;", b.S, b.c, "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DeviceStorageDisclosureItem {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final long id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String title;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String description;

    public DeviceStorageDisclosureItem(long j, String title, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = j;
        this.title = title;
        this.description = description;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceStorageDisclosureItem)) {
            return false;
        }
        DeviceStorageDisclosureItem deviceStorageDisclosureItem = (DeviceStorageDisclosureItem) other;
        return this.id == deviceStorageDisclosureItem.id && Intrinsics.areEqual(this.title, deviceStorageDisclosureItem.title) && Intrinsics.areEqual(this.description, deviceStorageDisclosureItem.description);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "DeviceStorageDisclosureItem(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ')';
    }
}
