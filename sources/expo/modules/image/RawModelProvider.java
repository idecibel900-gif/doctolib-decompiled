package expo.modules.image;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RawModelProvider implements GlideModelProvider {
    private final String data;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RawModelProvider) && Intrinsics.areEqual(this.data, ((RawModelProvider) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "RawModelProvider(data=" + this.data + ")";
    }

    public RawModelProvider(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // expo.modules.image.GlideModelProvider
    public String getGlideModel() {
        return this.data;
    }
}
