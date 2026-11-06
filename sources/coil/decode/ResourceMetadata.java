package coil.decode;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceMetadata extends ImageSource.Metadata {
    private final int density;
    private final String packageName;
    private final int resId;

    public final int getDensity() {
        return this.density;
    }

    public ResourceMetadata(String str, int i, int i2) {
        this.packageName = str;
        this.resId = i;
        this.density = i2;
    }
}
