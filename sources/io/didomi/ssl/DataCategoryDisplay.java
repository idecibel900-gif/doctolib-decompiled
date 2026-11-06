package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.k1, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/k1;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", b.S, b.c, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DataCategoryDisplay {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String title;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String description;

    public DataCategoryDisplay(String title, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.title = title;
        this.description = description;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCategoryDisplay)) {
            return false;
        }
        DataCategoryDisplay dataCategoryDisplay = (DataCategoryDisplay) other;
        return Intrinsics.areEqual(this.title, dataCategoryDisplay.title) && Intrinsics.areEqual(this.description, dataCategoryDisplay.description);
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        return "DataCategoryDisplay(title=" + this.title + ", description=" + this.description + ')';
    }
}
