package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import com.opentok.android.PublisherKit;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/margelo/nitro/unistyles/Dimensions;", "", "width", "", "height", "<init>", "(DD)V", "getWidth", "()D", "getHeight", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "component1", "component2", "copy", "toString", "", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Dimensions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @DoNotStrip
    @Keep
    private final double height;

    @DoNotStrip
    @Keep
    private final double width;

    public static /* synthetic */ Dimensions copy$default(Dimensions dimensions, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = dimensions.width;
        }
        if ((i & 2) != 0) {
            d2 = dimensions.height;
        }
        return dimensions.copy(d, d2);
    }

    @DoNotStrip
    @Keep
    private static final Dimensions fromCpp(double d, double d2) {
        return INSTANCE.fromCpp(d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final Dimensions copy(double width, double height) {
        return new Dimensions(width, height);
    }

    public String toString() {
        return "Dimensions(width=" + this.width + ", height=" + this.height + ")";
    }

    public Dimensions(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dimensions)) {
            return false;
        }
        Dimensions dimensions = (Dimensions) other;
        return Objects.deepEquals(Double.valueOf(this.width), Double.valueOf(dimensions.width)) && Objects.deepEquals(Double.valueOf(this.height), Double.valueOf(dimensions.height));
    }

    public int hashCode() {
        return ArraysKt.contentDeepHashCode(new Object[]{Double.valueOf(this.width), Double.valueOf(this.height)});
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003¨\u0006\t"}, d2 = {"Lcom/margelo/nitro/unistyles/Dimensions$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/unistyles/Dimensions;", "width", "", "height", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DoNotStrip
        @Keep
        public final Dimensions fromCpp(double width, double height) {
            return new Dimensions(width, height);
        }
    }
}
