package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/apiEvents/UIActionApiEventParameters;", "Lio/didomi/sdk/i;", "", "component1", "action", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UIActionApiEventParameters implements i {

    @SerializedName("action")
    private final String action;

    public UIActionApiEventParameters(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
    }

    public static /* synthetic */ UIActionApiEventParameters copy$default(UIActionApiEventParameters uIActionApiEventParameters, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uIActionApiEventParameters.action;
        }
        return uIActionApiEventParameters.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final UIActionApiEventParameters copy(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new UIActionApiEventParameters(action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UIActionApiEventParameters) && Intrinsics.areEqual(this.action, ((UIActionApiEventParameters) other).action);
    }

    public final String getAction() {
        return this.action;
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    public String toString() {
        return "UIActionApiEventParameters(action=" + this.action + ')';
    }
}
