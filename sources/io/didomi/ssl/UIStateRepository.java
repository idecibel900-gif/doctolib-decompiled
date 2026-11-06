package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.didomi.sdk.fh, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\t\u0010\f¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/fh;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Z", "()Z", "(Z)V", "noticeWasHidden", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UIStateRepository {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private boolean noticeWasHidden;

    public UIStateRepository() {
        this(false, 1, null);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getNoticeWasHidden() {
        return this.noticeWasHidden;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UIStateRepository) && this.noticeWasHidden == ((UIStateRepository) other).noticeWasHidden;
    }

    public int hashCode() {
        boolean z = this.noticeWasHidden;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "UIStateRepository(noticeWasHidden=" + this.noticeWasHidden + ')';
    }

    public UIStateRepository(boolean z) {
        this.noticeWasHidden = z;
    }

    public final void a(boolean z) {
        this.noticeWasHidden = z;
    }

    public /* synthetic */ UIStateRepository(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
