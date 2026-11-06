package expo.modules.webview;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lexpo/modules/webview/DomWebViewSource;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "<init>", "(Ljava/lang/String;)V", "getUri$annotations", "()V", "getUri", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DomWebViewSource implements Record {
    private final String uri;

    public static /* synthetic */ DomWebViewSource copy$default(DomWebViewSource domWebViewSource, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = domWebViewSource.uri;
        }
        return domWebViewSource.copy(str);
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    public final DomWebViewSource copy(String uri) {
        return new DomWebViewSource(uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DomWebViewSource) && Intrinsics.areEqual(this.uri, ((DomWebViewSource) other).uri);
    }

    public int hashCode() {
        String str = this.uri;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "DomWebViewSource(uri=" + this.uri + ")";
    }

    public DomWebViewSource(String str) {
        this.uri = str;
    }

    public final String getUri() {
        return this.uri;
    }
}
