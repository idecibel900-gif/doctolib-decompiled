package io.didomi.ssl.events;

import androidx.annotation.Keep;
import com.amazon.a.a.o.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lio/didomi/sdk/events/ErrorEvent;", "Lio/didomi/sdk/events/Event;", b.f, "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ErrorEvent implements Event {
    private String errorMessage;

    public ErrorEvent(String str) {
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
