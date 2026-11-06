package io.didomi.ssl.config.app;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u001b"}, d2 = {"Lio/didomi/sdk/config/app/SyncConfiguration;", "", "", "component1", "", "component2", "component3", "enabled", "timeout", "frequency", "copy", "", "toString", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "Z", "getEnabled", "()Z", "I", "getTimeout", "()I", "getFrequency", "<init>", "(ZII)V", "Companion", "a", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SyncConfiguration {
    public static final int DEFAULT_FREQUENCY = 86400;
    public static final int DEFAULT_TIMEOUT = 3000;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("frequency")
    private final int frequency;

    @SerializedName("timeout")
    private final int timeout;

    public SyncConfiguration() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ SyncConfiguration copy$default(SyncConfiguration syncConfiguration, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = syncConfiguration.enabled;
        }
        if ((i3 & 2) != 0) {
            i = syncConfiguration.timeout;
        }
        if ((i3 & 4) != 0) {
            i2 = syncConfiguration.frequency;
        }
        return syncConfiguration.copy(z, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFrequency() {
        return this.frequency;
    }

    public final SyncConfiguration copy(boolean enabled, int timeout, int frequency) {
        return new SyncConfiguration(enabled, timeout, frequency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncConfiguration)) {
            return false;
        }
        SyncConfiguration syncConfiguration = (SyncConfiguration) other;
        return this.enabled == syncConfiguration.enabled && this.timeout == syncConfiguration.timeout && this.frequency == syncConfiguration.frequency;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Integer.hashCode(this.timeout)) * 31) + Integer.hashCode(this.frequency);
    }

    public String toString() {
        return "SyncConfiguration(enabled=" + this.enabled + ", timeout=" + this.timeout + ", frequency=" + this.frequency + ')';
    }

    public SyncConfiguration(boolean z, int i, int i2) {
        this.enabled = z;
        this.timeout = i;
        this.frequency = i2;
    }

    public /* synthetic */ SyncConfiguration(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? DEFAULT_TIMEOUT : i, (i3 & 4) != 0 ? DEFAULT_FREQUENCY : i2);
    }
}
