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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/margelo/nitro/unistyles/Insets;", "", "top", "", "bottom", "left", "right", "ime", "<init>", "(DDDDD)V", "getTop", "()D", "getBottom", "getLeft", "getRight", "getIme", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Insets {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @DoNotStrip
    @Keep
    private final double bottom;

    @DoNotStrip
    @Keep
    private final double ime;

    @DoNotStrip
    @Keep
    private final double left;

    @DoNotStrip
    @Keep
    private final double right;

    @DoNotStrip
    @Keep
    private final double top;

    public static /* synthetic */ Insets copy$default(Insets insets, double d, double d2, double d3, double d4, double d5, int i, Object obj) {
        if ((i & 1) != 0) {
            d = insets.top;
        }
        double d6 = d;
        if ((i & 2) != 0) {
            d2 = insets.bottom;
        }
        return insets.copy(d6, d2, (i & 4) != 0 ? insets.left : d3, (i & 8) != 0 ? insets.right : d4, (i & 16) != 0 ? insets.ime : d5);
    }

    @DoNotStrip
    @Keep
    private static final Insets fromCpp(double d, double d2, double d3, double d4, double d5) {
        return INSTANCE.fromCpp(d, d2, d3, d4, d5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getIme() {
        return this.ime;
    }

    public final Insets copy(double top, double bottom, double left, double right, double ime) {
        return new Insets(top, bottom, left, right, ime);
    }

    public String toString() {
        return "Insets(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", ime=" + this.ime + ")";
    }

    public Insets(double d, double d2, double d3, double d4, double d5) {
        this.top = d;
        this.bottom = d2;
        this.left = d3;
        this.right = d4;
        this.ime = d5;
    }

    public final double getTop() {
        return this.top;
    }

    public final double getBottom() {
        return this.bottom;
    }

    public final double getLeft() {
        return this.left;
    }

    public final double getRight() {
        return this.right;
    }

    public final double getIme() {
        return this.ime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Insets)) {
            return false;
        }
        Insets insets = (Insets) other;
        return Objects.deepEquals(Double.valueOf(this.top), Double.valueOf(insets.top)) && Objects.deepEquals(Double.valueOf(this.bottom), Double.valueOf(insets.bottom)) && Objects.deepEquals(Double.valueOf(this.left), Double.valueOf(insets.left)) && Objects.deepEquals(Double.valueOf(this.right), Double.valueOf(insets.right)) && Objects.deepEquals(Double.valueOf(this.ime), Double.valueOf(insets.ime));
    }

    public int hashCode() {
        return ArraysKt.contentDeepHashCode(new Object[]{Double.valueOf(this.top), Double.valueOf(this.bottom), Double.valueOf(this.left), Double.valueOf(this.right), Double.valueOf(this.ime)});
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0003¨\u0006\f"}, d2 = {"Lcom/margelo/nitro/unistyles/Insets$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/unistyles/Insets;", "top", "", "bottom", "left", "right", "ime", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DoNotStrip
        @Keep
        public final Insets fromCpp(double top, double bottom, double left, double right, double ime) {
            return new Insets(top, bottom, left, right, ime);
        }
    }
}
