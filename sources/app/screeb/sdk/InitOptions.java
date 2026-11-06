package app.screeb.sdk;

import androidx.annotation.Keep;
import app.screeb.sdk.internal.C0322v;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0003\u0010\t\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u0019¨\u0006#"}, d2 = {"Lapp/screeb/sdk/InitOptions;", "", "", "isDebugMode", "disableMirror", "webViewHardwareLayer", "<init>", "(ZZZ)V", "component1", "()Z", "component2", "component3", "copy", "(ZZZ)Lapp/screeb/sdk/InitOptions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "setDebugMode", "(Z)V", "getDisableMirror", "setDisableMirror", "getWebViewHardwareLayer", "setWebViewHardwareLayer", "replayTelemetry", "getReplayTelemetry$sdk_release", "setReplayTelemetry$sdk_release", "Companion", "app/screeb/sdk/internal/v", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class InitOptions {
    public static final C0322v Companion = new C0322v();
    private boolean disableMirror;
    private boolean isDebugMode;
    private boolean replayTelemetry;
    private boolean webViewHardwareLayer;

    public InitOptions() {
        this(false, false, false, 7, null);
    }

    public InitOptions(boolean z, boolean z2, boolean z3) {
        this.isDebugMode = z;
        this.disableMirror = z2;
        this.webViewHardwareLayer = z3;
    }

    public /* synthetic */ InitOptions(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3);
    }

    public static /* synthetic */ InitOptions copy$default(InitOptions initOptions, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = initOptions.isDebugMode;
        }
        if ((i & 2) != 0) {
            z2 = initOptions.disableMirror;
        }
        if ((i & 4) != 0) {
            z3 = initOptions.webViewHardwareLayer;
        }
        return initOptions.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsDebugMode() {
        return this.isDebugMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDisableMirror() {
        return this.disableMirror;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getWebViewHardwareLayer() {
        return this.webViewHardwareLayer;
    }

    public final InitOptions copy(boolean isDebugMode, boolean disableMirror, boolean webViewHardwareLayer) {
        return new InitOptions(isDebugMode, disableMirror, webViewHardwareLayer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitOptions)) {
            return false;
        }
        InitOptions initOptions = (InitOptions) other;
        return this.isDebugMode == initOptions.isDebugMode && this.disableMirror == initOptions.disableMirror && this.webViewHardwareLayer == initOptions.webViewHardwareLayer;
    }

    public final boolean getDisableMirror() {
        return this.disableMirror;
    }

    /* JADX INFO: renamed from: getReplayTelemetry$sdk_release, reason: from getter */
    public final boolean getReplayTelemetry() {
        return this.replayTelemetry;
    }

    public final boolean getWebViewHardwareLayer() {
        return this.webViewHardwareLayer;
    }

    public int hashCode() {
        return Boolean.hashCode(this.webViewHardwareLayer) + ((Boolean.hashCode(this.disableMirror) + (Boolean.hashCode(this.isDebugMode) * 31)) * 31);
    }

    public final boolean isDebugMode() {
        return this.isDebugMode;
    }

    public final void setDebugMode(boolean z) {
        this.isDebugMode = z;
    }

    public final void setDisableMirror(boolean z) {
        this.disableMirror = z;
    }

    public final void setReplayTelemetry$sdk_release(boolean z) {
        this.replayTelemetry = z;
    }

    public final void setWebViewHardwareLayer(boolean z) {
        this.webViewHardwareLayer = z;
    }

    public String toString() {
        return "InitOptions(isDebugMode=" + this.isDebugMode + ", disableMirror=" + this.disableMirror + ", webViewHardwareLayer=" + this.webViewHardwareLayer + ")";
    }
}
