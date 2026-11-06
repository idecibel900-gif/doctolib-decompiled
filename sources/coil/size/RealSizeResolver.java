package coil.size;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RealSizeResolver implements SizeResolver {
    private final Size size;

    public RealSizeResolver(Size size) {
        this.size = size;
    }

    @Override // coil.size.SizeResolver
    public Object size(Continuation continuation) {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RealSizeResolver) && Intrinsics.areEqual(this.size, ((RealSizeResolver) obj).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }
}
