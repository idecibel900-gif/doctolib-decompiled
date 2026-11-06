package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.graphics.Color;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "", "Gradient", "Solid", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Gradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Solid;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ColorStyle {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Solid;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "constructor-impl", "(J)J", "getColor-0d7_KjU", "()J", "J", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Solid implements ColorStyle {
        private final /* synthetic */ long color;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Solid m4126boximpl(long j) {
            return new Solid(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m4127constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m4128equalsimpl(long j, Object obj) {
            return (obj instanceof Solid) && Color.m1367equalsimpl0(j, ((Solid) obj).m4133unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4129equalsimpl0(long j, long j2) {
            return Color.m1367equalsimpl0(j, j2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m4130hashCodeimpl(long j) {
            return Color.m1373hashCodeimpl(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m4131toStringimpl(long j) {
            return "Solid(color=" + ((Object) Color.m1374toStringimpl(j)) + ')';
        }

        public boolean equals(Object obj) {
            return m4128equalsimpl(this.color, obj);
        }

        public int hashCode() {
            return m4130hashCodeimpl(this.color);
        }

        public String toString() {
            return m4131toStringimpl(this.color);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m4133unboximpl() {
            return this.color;
        }

        private /* synthetic */ Solid(long j) {
            this.color = j;
        }

        /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
        public final long getColor() {
            return this.color;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle$Gradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "brush", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "constructor-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "getBrush", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)I", "toString", "", "toString-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;)Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Gradient implements ColorStyle {
        private final /* synthetic */ GradientBrush brush;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Gradient m4119boximpl(GradientBrush gradientBrush) {
            return new Gradient(gradientBrush);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static GradientBrush m4120constructorimpl(GradientBrush brush) {
            Intrinsics.checkNotNullParameter(brush, "brush");
            return brush;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m4121equalsimpl(GradientBrush gradientBrush, Object obj) {
            return (obj instanceof Gradient) && Intrinsics.areEqual(gradientBrush, ((Gradient) obj).m4125unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4122equalsimpl0(GradientBrush gradientBrush, GradientBrush gradientBrush2) {
            return Intrinsics.areEqual(gradientBrush, gradientBrush2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m4123hashCodeimpl(GradientBrush gradientBrush) {
            return gradientBrush.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m4124toStringimpl(GradientBrush gradientBrush) {
            return "Gradient(brush=" + gradientBrush + ')';
        }

        public boolean equals(Object obj) {
            return m4121equalsimpl(this.brush, obj);
        }

        public int hashCode() {
            return m4123hashCodeimpl(this.brush);
        }

        public String toString() {
            return m4124toStringimpl(this.brush);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ GradientBrush m4125unboximpl() {
            return this.brush;
        }

        private /* synthetic */ Gradient(GradientBrush gradientBrush) {
            this.brush = gradientBrush;
        }

        public final GradientBrush getBrush() {
            return this.brush;
        }
    }
}
