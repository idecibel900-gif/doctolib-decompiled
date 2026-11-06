package expo.modules.updates.reloadscreen;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "Lexpo/modules/kotlin/records/Record;", "enabled", "", "color", "", "size", "Lexpo/modules/updates/reloadscreen/SpinnerSize;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lexpo/modules/updates/reloadscreen/SpinnerSize;)V", "getEnabled$annotations", "()V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getColor$annotations", "getColor", "()Ljava/lang/String;", "getSize$annotations", "getSize", "()Lexpo/modules/updates/reloadscreen/SpinnerSize;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lexpo/modules/updates/reloadscreen/SpinnerSize;)Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SpinnerOptions implements Record {
    private final String color;
    private final Boolean enabled;
    private final SpinnerSize size;

    public SpinnerOptions() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SpinnerOptions copy$default(SpinnerOptions spinnerOptions, Boolean bool, String str, SpinnerSize spinnerSize, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = spinnerOptions.enabled;
        }
        if ((i & 2) != 0) {
            str = spinnerOptions.color;
        }
        if ((i & 4) != 0) {
            spinnerSize = spinnerOptions.size;
        }
        return spinnerOptions.copy(bool, str, spinnerSize);
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SpinnerSize getSize() {
        return this.size;
    }

    public final SpinnerOptions copy(Boolean enabled, String color, SpinnerSize size) {
        return new SpinnerOptions(enabled, color, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpinnerOptions)) {
            return false;
        }
        SpinnerOptions spinnerOptions = (SpinnerOptions) other;
        return Intrinsics.areEqual(this.enabled, spinnerOptions.enabled) && Intrinsics.areEqual(this.color, spinnerOptions.color) && this.size == spinnerOptions.size;
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.color;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        SpinnerSize spinnerSize = this.size;
        return iHashCode2 + (spinnerSize != null ? spinnerSize.hashCode() : 0);
    }

    public String toString() {
        return "SpinnerOptions(enabled=" + this.enabled + ", color=" + this.color + ", size=" + this.size + ")";
    }

    public SpinnerOptions(Boolean bool, String str, SpinnerSize spinnerSize) {
        this.enabled = bool;
        this.color = str;
        this.size = spinnerSize;
    }

    public /* synthetic */ SpinnerOptions(Boolean bool, String str, SpinnerSize spinnerSize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : spinnerSize);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getColor() {
        return this.color;
    }

    public final SpinnerSize getSize() {
        return this.size;
    }
}
