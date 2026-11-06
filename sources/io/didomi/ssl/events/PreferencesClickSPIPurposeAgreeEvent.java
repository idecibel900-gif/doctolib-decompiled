package io.didomi.ssl.events;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/didomi/sdk/events/PreferencesClickSPIPurposeAgreeEvent;", "Lio/didomi/sdk/events/Event;", "purposeId", "", "(Ljava/lang/String;)V", "getPurposeId", "()Ljava/lang/String;", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PreferencesClickSPIPurposeAgreeEvent implements Event {
    private final String purposeId;

    public PreferencesClickSPIPurposeAgreeEvent(String purposeId) {
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        this.purposeId = purposeId;
    }

    public final String getPurposeId() {
        return this.purposeId;
    }
}
