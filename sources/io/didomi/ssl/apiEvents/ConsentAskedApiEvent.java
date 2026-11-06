package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.e;
import io.didomi.ssl.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0010\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lio/didomi/sdk/apiEvents/ConsentAskedApiEvent;", "Lio/didomi/sdk/e;", "", "component1", "component2", "", "component3", "Lio/didomi/sdk/apiEvents/User;", "component4", "Lio/didomi/sdk/apiEvents/Source;", "component5", "Lio/didomi/sdk/apiEvents/ConsentAskedApiEventParameters;", "component6", "type", DiagnosticsEntry.TIMESTAMP_KEY, "rate", "user", Constants.ScionAnalytics.PARAM_SOURCE, "parameters", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "getTimestamp", "F", "getRate", "()F", "Lio/didomi/sdk/apiEvents/User;", "getUser", "()Lio/didomi/sdk/apiEvents/User;", "Lio/didomi/sdk/apiEvents/Source;", "getSource", "()Lio/didomi/sdk/apiEvents/Source;", "Lio/didomi/sdk/apiEvents/ConsentAskedApiEventParameters;", "getParameters", "()Lio/didomi/sdk/apiEvents/ConsentAskedApiEventParameters;", "<init>", "(Ljava/lang/String;Ljava/lang/String;FLio/didomi/sdk/apiEvents/User;Lio/didomi/sdk/apiEvents/Source;Lio/didomi/sdk/apiEvents/ConsentAskedApiEventParameters;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ConsentAskedApiEvent implements e {
    private final ConsentAskedApiEventParameters parameters;
    private final float rate;
    private final Source source;
    private final String timestamp;
    private final String type;
    private final User user;

    public ConsentAskedApiEvent(String type, String timestamp, float f, User user, Source source, ConsentAskedApiEventParameters consentAskedApiEventParameters) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(source, "source");
        this.type = type;
        this.timestamp = timestamp;
        this.rate = f;
        this.user = user;
        this.source = source;
        this.parameters = consentAskedApiEventParameters;
    }

    public static /* synthetic */ ConsentAskedApiEvent copy$default(ConsentAskedApiEvent consentAskedApiEvent, String str, String str2, float f, User user, Source source, ConsentAskedApiEventParameters consentAskedApiEventParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consentAskedApiEvent.type;
        }
        if ((i & 2) != 0) {
            str2 = consentAskedApiEvent.timestamp;
        }
        if ((i & 4) != 0) {
            f = consentAskedApiEvent.rate;
        }
        if ((i & 8) != 0) {
            user = consentAskedApiEvent.user;
        }
        if ((i & 16) != 0) {
            source = consentAskedApiEvent.source;
        }
        if ((i & 32) != 0) {
            consentAskedApiEventParameters = consentAskedApiEvent.parameters;
        }
        Source source2 = source;
        ConsentAskedApiEventParameters consentAskedApiEventParameters2 = consentAskedApiEventParameters;
        return consentAskedApiEvent.copy(str, str2, f, user, source2, consentAskedApiEventParameters2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConsentAskedApiEventParameters getParameters() {
        return this.parameters;
    }

    public final ConsentAskedApiEvent copy(String type, String timestamp, float rate, User user, Source source, ConsentAskedApiEventParameters parameters) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(source, "source");
        return new ConsentAskedApiEvent(type, timestamp, rate, user, source, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentAskedApiEvent)) {
            return false;
        }
        ConsentAskedApiEvent consentAskedApiEvent = (ConsentAskedApiEvent) other;
        return Intrinsics.areEqual(this.type, consentAskedApiEvent.type) && Intrinsics.areEqual(this.timestamp, consentAskedApiEvent.timestamp) && Float.compare(this.rate, consentAskedApiEvent.rate) == 0 && Intrinsics.areEqual(this.user, consentAskedApiEvent.user) && Intrinsics.areEqual(this.source, consentAskedApiEvent.source) && Intrinsics.areEqual(this.parameters, consentAskedApiEvent.parameters);
    }

    @Override // io.didomi.ssl.e
    public float getRate() {
        return this.rate;
    }

    public Source getSource() {
        return this.source;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    @Override // io.didomi.ssl.e
    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.type.hashCode() * 31) + this.timestamp.hashCode()) * 31) + Float.hashCode(this.rate)) * 31) + this.user.hashCode()) * 31) + this.source.hashCode()) * 31;
        ConsentAskedApiEventParameters consentAskedApiEventParameters = this.parameters;
        return iHashCode + (consentAskedApiEventParameters == null ? 0 : consentAskedApiEventParameters.hashCode());
    }

    public String toString() {
        return "ConsentAskedApiEvent(type=" + this.type + ", timestamp=" + this.timestamp + ", rate=" + this.rate + ", user=" + this.user + ", source=" + this.source + ", parameters=" + this.parameters + ')';
    }

    /* JADX INFO: renamed from: getParameters, reason: merged with bridge method [inline-methods] */
    public ConsentAskedApiEventParameters m5032getParameters() {
        return this.parameters;
    }

    public /* synthetic */ ConsentAskedApiEvent(String str, String str2, float f, User user, Source source, ConsentAskedApiEventParameters consentAskedApiEventParameters, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "consent.asked" : str, (i & 2) != 0 ? String.valueOf(t1.a.b()) : str2, (i & 4) != 0 ? 0.2f : f, user, source, consentAskedApiEventParameters);
    }
}
