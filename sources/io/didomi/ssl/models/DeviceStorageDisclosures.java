package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\fJ\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/models/DeviceStorageDisclosures;", "", "internalDisclosures", "", "Lio/didomi/sdk/models/DeviceStorageDisclosure;", "(Ljava/util/List;)V", "disclosuresList", "getDisclosuresList", "()Ljava/util/List;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "isValid", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeviceStorageDisclosures {

    @SerializedName("disclosures")
    private final List<DeviceStorageDisclosure> internalDisclosures;

    public DeviceStorageDisclosures(List<DeviceStorageDisclosure> list) {
        this.internalDisclosures = list;
    }

    private final List<DeviceStorageDisclosure> component1() {
        return this.internalDisclosures;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceStorageDisclosures copy$default(DeviceStorageDisclosures deviceStorageDisclosures, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceStorageDisclosures.internalDisclosures;
        }
        return deviceStorageDisclosures.copy(list);
    }

    public final DeviceStorageDisclosures copy(List<DeviceStorageDisclosure> internalDisclosures) {
        return new DeviceStorageDisclosures(internalDisclosures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeviceStorageDisclosures) && Intrinsics.areEqual(this.internalDisclosures, ((DeviceStorageDisclosures) other).internalDisclosures);
    }

    public final List<DeviceStorageDisclosure> getDisclosuresList() {
        List<DeviceStorageDisclosure> list = this.internalDisclosures;
        if (list != null) {
            return CollectionsKt.filterNotNull(list);
        }
        return null;
    }

    public int hashCode() {
        List<DeviceStorageDisclosure> list = this.internalDisclosures;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final boolean isValid() {
        List<DeviceStorageDisclosure> disclosuresList = getDisclosuresList();
        if (disclosuresList == null || disclosuresList.isEmpty()) {
            return true;
        }
        Iterator<T> it = disclosuresList.iterator();
        while (it.hasNext()) {
            if (!((DeviceStorageDisclosure) it.next()).isValid()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "DeviceStorageDisclosures(internalDisclosures=" + this.internalDisclosures + ')';
    }
}
