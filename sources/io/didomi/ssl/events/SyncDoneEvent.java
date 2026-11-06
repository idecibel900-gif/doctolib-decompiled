package io.didomi.ssl.events;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lio/didomi/sdk/events/SyncDoneEvent;", "Lio/didomi/sdk/events/Event;", "organizationUserId", "", "(Ljava/lang/String;)V", "getOrganizationUserId", "()Ljava/lang/String;", "setOrganizationUserId", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SyncDoneEvent implements Event {
    private String organizationUserId;

    public SyncDoneEvent(String str) {
        this.organizationUserId = str;
    }

    public final String getOrganizationUserId() {
        return this.organizationUserId;
    }

    public final void setOrganizationUserId(String str) {
        this.organizationUserId = str;
    }
}
