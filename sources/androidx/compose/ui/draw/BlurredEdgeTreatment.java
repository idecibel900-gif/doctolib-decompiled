package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BlurredEdgeTreatment {
    public static final Companion Companion = new Companion(null);
    private static final Shape Rectangle = m1132constructorimpl(RectangleShapeKt.getRectangleShape());
    private static final Shape Unbounded = m1132constructorimpl(null);
    private final Shape shape;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m1131boximpl(Shape shape) {
        return new BlurredEdgeTreatment(shape);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Shape m1132constructorimpl(Shape shape) {
        return shape;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1133equalsimpl(Shape shape, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && Intrinsics.areEqual(shape, ((BlurredEdgeTreatment) obj).m1136unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1134hashCodeimpl(Shape shape) {
        if (shape == null) {
            return 0;
        }
        return shape.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1135toStringimpl(Shape shape) {
        return "BlurredEdgeTreatment(shape=" + shape + ')';
    }

    public boolean equals(Object obj) {
        return m1133equalsimpl(this.shape, obj);
    }

    public int hashCode() {
        return m1134hashCodeimpl(this.shape);
    }

    public String toString() {
        return m1135toStringimpl(this.shape);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Shape m1136unboximpl() {
        return this.shape;
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape shape) {
        this.shape = shape;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getRectangle---Goahg, reason: not valid java name */
        public final Shape m1137getRectangleGoahg() {
            return BlurredEdgeTreatment.Rectangle;
        }

        /* JADX INFO: renamed from: getUnbounded---Goahg, reason: not valid java name */
        public final Shape m1138getUnboundedGoahg() {
            return BlurredEdgeTreatment.Unbounded;
        }
    }
}
