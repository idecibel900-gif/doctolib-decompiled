package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Stroke extends DrawStyle {
    public static final Companion Companion = new Companion(null);
    private static final int DefaultCap = StrokeCap.Companion.m1500getButtKaPHkGw();
    private static final int DefaultJoin = StrokeJoin.Companion.m1508getMiterLxFBmk8();
    private final int cap;
    private final int join;
    private final float miter;
    private final float width;

    public /* synthetic */ Stroke(float f, float f2, int i, int i2, PathEffect pathEffect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, pathEffect);
    }

    public final PathEffect getPathEffect() {
        return null;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getMiter() {
        return this.miter;
    }

    public /* synthetic */ Stroke(float f, float f2, int i, int i2, PathEffect pathEffect, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f, (i3 & 2) != 0 ? 4.0f : f2, (i3 & 4) != 0 ? DefaultCap : i, (i3 & 8) != 0 ? DefaultJoin : i2, (i3 & 16) != 0 ? null : pathEffect, null);
    }

    /* JADX INFO: renamed from: getCap-KaPHkGw, reason: not valid java name */
    public final int m1603getCapKaPHkGw() {
        return this.cap;
    }

    /* JADX INFO: renamed from: getJoin-LxFBmk8, reason: not valid java name */
    public final int m1604getJoinLxFBmk8() {
        return this.join;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDefaultCap-KaPHkGw, reason: not valid java name */
        public final int m1605getDefaultCapKaPHkGw() {
            return Stroke.DefaultCap;
        }
    }

    private Stroke(float f, float f2, int i, int i2, PathEffect pathEffect) {
        super(null);
        this.width = f;
        this.miter = f2;
        this.cap = i;
        this.join = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) obj;
        return this.width == stroke.width && this.miter == stroke.miter && StrokeCap.m1497equalsimpl0(this.cap, stroke.cap) && StrokeJoin.m1504equalsimpl0(this.join, stroke.join) && Intrinsics.areEqual((Object) null, (Object) null);
    }

    public int hashCode() {
        return ((((((Float.hashCode(this.width) * 31) + Float.hashCode(this.miter)) * 31) + StrokeCap.m1498hashCodeimpl(this.cap)) * 31) + StrokeJoin.m1505hashCodeimpl(this.join)) * 31;
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) StrokeCap.m1499toStringimpl(this.cap)) + ", join=" + ((Object) StrokeJoin.m1506toStringimpl(this.join)) + ", pathEffect=" + ((Object) null) + ')';
    }
}
