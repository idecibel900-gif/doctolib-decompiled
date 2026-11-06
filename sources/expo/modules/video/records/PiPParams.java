package expo.modules.video.records;

import android.graphics.Rect;
import android.util.Rational;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class PiPParams {
    private final Rational aspectRatio;
    private final boolean autoEnter;
    private final boolean blocksAppFromEntering;
    private final boolean canEnter;
    private final Rect rectHint;
    private final boolean willEnter;

    public static /* synthetic */ PiPParams copy$default(PiPParams piPParams, boolean z, boolean z2, boolean z3, boolean z4, Rational rational, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            z = piPParams.autoEnter;
        }
        if ((i & 2) != 0) {
            z2 = piPParams.canEnter;
        }
        if ((i & 4) != 0) {
            z3 = piPParams.willEnter;
        }
        if ((i & 8) != 0) {
            z4 = piPParams.blocksAppFromEntering;
        }
        if ((i & 16) != 0) {
            rational = piPParams.aspectRatio;
        }
        if ((i & 32) != 0) {
            rect = piPParams.rectHint;
        }
        Rational rational2 = rational;
        Rect rect2 = rect;
        return piPParams.copy(z, z2, z3, z4, rational2, rect2);
    }

    public final PiPParams copy(boolean z, boolean z2, boolean z3, boolean z4, Rational rational, Rect rectHint) {
        Intrinsics.checkNotNullParameter(rectHint, "rectHint");
        return new PiPParams(z, z2, z3, z4, rational, rectHint);
    }

    public String toString() {
        return "PiPParams(autoEnter=" + this.autoEnter + ", canEnter=" + this.canEnter + ", willEnter=" + this.willEnter + ", blocksAppFromEntering=" + this.blocksAppFromEntering + ", aspectRatio=" + this.aspectRatio + ", rectHint=" + this.rectHint + ")";
    }

    public PiPParams(boolean z, boolean z2, boolean z3, boolean z4, Rational rational, Rect rectHint) {
        Intrinsics.checkNotNullParameter(rectHint, "rectHint");
        this.autoEnter = z;
        this.canEnter = z2;
        this.willEnter = z3;
        this.blocksAppFromEntering = z4;
        this.aspectRatio = rational;
        this.rectHint = rectHint;
    }

    public final boolean getAutoEnter() {
        return this.autoEnter;
    }

    public final boolean getCanEnter() {
        return this.canEnter;
    }

    public final boolean getWillEnter() {
        return this.willEnter;
    }

    public final boolean getBlocksAppFromEntering() {
        return this.blocksAppFromEntering;
    }

    public /* synthetic */ PiPParams(boolean z, boolean z2, boolean z3, boolean z4, Rational rational, Rect rect, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? new Rational(16, 9) : rational, (i & 32) != 0 ? new Rect(0, 0, 0, 0) : rect);
    }

    public final Rational getAspectRatio() {
        return this.aspectRatio;
    }

    public final Rect getRectHint() {
        return this.rectHint;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PiPParams)) {
            return false;
        }
        PiPParams piPParams = (PiPParams) obj;
        return this.canEnter == piPParams.canEnter && this.willEnter == piPParams.willEnter && this.autoEnter == piPParams.autoEnter && this.blocksAppFromEntering == piPParams.blocksAppFromEntering && Intrinsics.areEqual(this.aspectRatio, piPParams.aspectRatio) && Intrinsics.areEqual(this.rectHint, piPParams.rectHint);
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.autoEnter) * 31) + Boolean.hashCode(this.canEnter)) * 31) + Boolean.hashCode(this.blocksAppFromEntering)) * 31;
        Rational rational = this.aspectRatio;
        return iHashCode + (rational != null ? rational.hashCode() : 0);
    }
}
