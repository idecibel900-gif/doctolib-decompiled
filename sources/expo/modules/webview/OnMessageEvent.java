package expo.modules.webview;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lexpo/modules/webview/OnMessageEvent;", "Lexpo/modules/kotlin/records/Record;", b.S, "", "url", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getUrl$annotations", "getUrl", "getData$annotations", "getData", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OnMessageEvent implements Record {
    private final String data;
    private final String title;
    private final String url;

    public static /* synthetic */ OnMessageEvent copy$default(OnMessageEvent onMessageEvent, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onMessageEvent.title;
        }
        if ((i & 2) != 0) {
            str2 = onMessageEvent.url;
        }
        if ((i & 4) != 0) {
            str3 = onMessageEvent.data;
        }
        return onMessageEvent.copy(str, str2, str3);
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final OnMessageEvent copy(String title, String url, String data) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        return new OnMessageEvent(title, url, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnMessageEvent)) {
            return false;
        }
        OnMessageEvent onMessageEvent = (OnMessageEvent) other;
        return Intrinsics.areEqual(this.title, onMessageEvent.title) && Intrinsics.areEqual(this.url, onMessageEvent.url) && Intrinsics.areEqual(this.data, onMessageEvent.data);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.url.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "OnMessageEvent(title=" + this.title + ", url=" + this.url + ", data=" + this.data + ")";
    }

    public OnMessageEvent(String title, String url, String data) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        this.title = title;
        this.url = url;
        this.data = data;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getData() {
        return this.data;
    }
}
