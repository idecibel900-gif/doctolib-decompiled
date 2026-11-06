package coil.size;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SizeResolvers {
    public static final SizeResolver create(Size size) {
        return new RealSizeResolver(size);
    }
}
