package coil.size;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Size {
    public static final Companion Companion = new Companion(null);
    public static final Size ORIGINAL;
    private final Dimension height;
    private final Dimension width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return Intrinsics.areEqual(this.width, size.width) && Intrinsics.areEqual(this.height, size.height);
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }

    public Size(Dimension dimension, Dimension dimension2) {
        this.width = dimension;
        this.height = dimension2;
    }

    public final Dimension getWidth() {
        return this.width;
    }

    public final Dimension getHeight() {
        return this.height;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        ORIGINAL = new Size(undefined, undefined);
    }
}
