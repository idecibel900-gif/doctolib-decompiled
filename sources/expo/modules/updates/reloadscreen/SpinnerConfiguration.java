package expo.modules.updates.reloadscreen;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SpinnerConfiguration {
    private final int color;
    private final boolean enabled;
    private final SpinnerSize size;

    public static /* synthetic */ SpinnerConfiguration copy$default(SpinnerConfiguration spinnerConfiguration, boolean z, int i, SpinnerSize spinnerSize, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = spinnerConfiguration.enabled;
        }
        if ((i2 & 2) != 0) {
            i = spinnerConfiguration.color;
        }
        if ((i2 & 4) != 0) {
            spinnerSize = spinnerConfiguration.size;
        }
        return spinnerConfiguration.copy(z, i, spinnerSize);
    }

    public final SpinnerConfiguration copy(boolean z, int i, SpinnerSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new SpinnerConfiguration(z, i, size);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpinnerConfiguration)) {
            return false;
        }
        SpinnerConfiguration spinnerConfiguration = (SpinnerConfiguration) obj;
        return this.enabled == spinnerConfiguration.enabled && this.color == spinnerConfiguration.color && this.size == spinnerConfiguration.size;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enabled) * 31) + Integer.hashCode(this.color)) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "SpinnerConfiguration(enabled=" + this.enabled + ", color=" + this.color + ", size=" + this.size + ")";
    }

    public SpinnerConfiguration(boolean z, int i, SpinnerSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.enabled = z;
        this.color = i;
        this.size = size;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getColor() {
        return this.color;
    }

    public final SpinnerSize getSize() {
        return this.size;
    }
}
