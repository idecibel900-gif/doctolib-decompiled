package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private long containerSize;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState redrawSignal;
    private boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Modifier drawGlowOverscrollModifier;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m1393toArgb8_81llA(overscrollConfiguration.m162getGlowColor0d7_KjU()));
        this.edgeEffectWrapper = edgeEffectWrapper;
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m1267getZeroNHjbRc();
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        } else {
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, edgeEffectWrapper, overscrollConfiguration, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = modifierPointerInput.then(drawGlowOverscrollModifier);
    }

    public final MutableState getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0107  */
    /* JADX WARN: Code duplicated, block: B:52:0x010c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:55:0x0118  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo112applyToScrollRhakbz0(long j, int i, Function1 function1) {
        float fM106pullBottomk4lQ0M;
        boolean z;
        boolean z2;
        if (Size.m1263isEmptyimpl(this.containerSize)) {
            return ((Offset) function1.invoke(Offset.m1214boximpl(j))).m1232unboximpl();
        }
        boolean z3 = true;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        float fM108pullRightk4lQ0M = 0.0f;
        if (Offset.m1224getYimpl(j) == 0.0f) {
            fM106pullBottomk4lQ0M = 0.0f;
        } else if (this.edgeEffectWrapper.isTopStretched()) {
            fM106pullBottomk4lQ0M = m109pullTopk4lQ0M(j);
            if (!this.edgeEffectWrapper.isTopStretched()) {
                this.edgeEffectWrapper.getOrCreateTopEffect().onRelease();
            }
        } else if (this.edgeEffectWrapper.isBottomStretched()) {
            fM106pullBottomk4lQ0M = m106pullBottomk4lQ0M(j);
            if (!this.edgeEffectWrapper.isBottomStretched()) {
                this.edgeEffectWrapper.getOrCreateBottomEffect().onRelease();
            }
        } else {
            fM106pullBottomk4lQ0M = 0.0f;
        }
        if (Offset.m1223getXimpl(j) != 0.0f) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                fM108pullRightk4lQ0M = m107pullLeftk4lQ0M(j);
                if (!this.edgeEffectWrapper.isLeftStretched()) {
                    this.edgeEffectWrapper.getOrCreateLeftEffect().onRelease();
                }
            } else if (this.edgeEffectWrapper.isRightStretched()) {
                fM108pullRightk4lQ0M = m108pullRightk4lQ0M(j);
                if (!this.edgeEffectWrapper.isRightStretched()) {
                    this.edgeEffectWrapper.getOrCreateRightEffect().onRelease();
                }
            }
        }
        long jOffset = OffsetKt.Offset(fM108pullRightk4lQ0M, fM106pullBottomk4lQ0M);
        if (!Offset.m1220equalsimpl0(jOffset, Offset.Companion.m1235getZeroF1C5BW0())) {
            invalidateOverscroll$foundation_release();
        }
        long jM1227minusMKHz9U = Offset.m1227minusMKHz9U(j, jOffset);
        long jM1232unboximpl = ((Offset) function1.invoke(Offset.m1214boximpl(jM1227minusMKHz9U))).m1232unboximpl();
        long jM1227minusMKHz9U2 = Offset.m1227minusMKHz9U(jM1227minusMKHz9U, jM1232unboximpl);
        boolean z4 = false;
        if (NestedScrollSource.m1737equalsimpl0(i, NestedScrollSource.Companion.m1739getUserInputWNlRxjI())) {
            if (Offset.m1223getXimpl(jM1227minusMKHz9U2) > 0.5f) {
                m107pullLeftk4lQ0M(jM1227minusMKHz9U2);
            } else {
                if (Offset.m1223getXimpl(jM1227minusMKHz9U2) < -0.5f) {
                    m108pullRightk4lQ0M(jM1227minusMKHz9U2);
                } else {
                    z = false;
                }
                if (Offset.m1224getYimpl(jM1227minusMKHz9U2) > 0.5f) {
                    m109pullTopk4lQ0M(jM1227minusMKHz9U2);
                } else {
                    if (Offset.m1224getYimpl(jM1227minusMKHz9U2) < -0.5f) {
                        m106pullBottomk4lQ0M(jM1227minusMKHz9U2);
                    } else {
                        z2 = false;
                    }
                    if (!z && !z2) {
                        z3 = false;
                    }
                    z4 = z3;
                }
                z2 = true;
                if (!z) {
                    z3 = false;
                }
                z4 = z3;
            }
            z = true;
            if (Offset.m1224getYimpl(jM1227minusMKHz9U2) > 0.5f) {
                m109pullTopk4lQ0M(jM1227minusMKHz9U2);
            } else {
                if (Offset.m1224getYimpl(jM1227minusMKHz9U2) < -0.5f) {
                    m106pullBottomk4lQ0M(jM1227minusMKHz9U2);
                } else {
                    z2 = false;
                }
                if (!z) {
                    z3 = false;
                }
                z4 = z3;
            }
            z2 = true;
            if (!z) {
                z3 = false;
            }
            z4 = z3;
        }
        if (m110releaseOppositeOverscrollk4lQ0M(j) || z4) {
            invalidateOverscroll$foundation_release();
        }
        return Offset.m1228plusMKHz9U(jOffset, jM1232unboximpl);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x013e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0152  */
    /* JADX WARN: Code duplicated, block: B:57:0x015a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0176  */
    /* JADX WARN: Code duplicated, block: B:61:0x018a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0192  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r13.invoke(r11, r0) == r1) goto L50;
     */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo111applyToFlingBMRW4eQ(long r11, kotlin.jvm.functions.Function2 r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo111applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m107pullLeftk4lQ0M(Offset.Companion.m1235getZeroF1C5BW0());
            z = true;
        } else {
            z = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m108pullRightk4lQ0M(Offset.Companion.m1235getZeroF1C5BW0());
            z = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m109pullTopk4lQ0M(Offset.Companion.m1235getZeroF1C5BW0());
            z = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z;
        }
        m106pullBottomk4lQ0M(Offset.Companion.m1235getZeroF1C5BW0());
        return true;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m114updateSizeuvyYCjk$foundation_release(long j) {
        boolean zM1258equalsimpl0 = Size.m1258equalsimpl0(this.containerSize, Size.Companion.m1267getZeroNHjbRc());
        boolean zM1258equalsimpl1 = Size.m1258equalsimpl0(j, this.containerSize);
        this.containerSize = j;
        if (!zM1258equalsimpl1) {
            this.edgeEffectWrapper.m152setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1261getWidthimpl(j)), MathKt.roundToInt(Size.m1259getHeightimpl(j))));
        }
        if (zM1258equalsimpl0 || zM1258equalsimpl1) {
            return;
        }
        invalidateOverscroll$foundation_release();
        animateToRelease();
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m113displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long jM1232unboximpl = offset != null ? offset.m1232unboximpl() : SizeKt.m1268getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m1223getXimpl(jM1232unboximpl) / Size.m1261getWidthimpl(this.containerSize), Offset.m1224getYimpl(jM1232unboximpl) / Size.m1259getHeightimpl(this.containerSize));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToRelease() {
        boolean zIsFinished;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m110releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m1223getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m1223getXimpl(j));
            z = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m1223getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m1223getXimpl(j));
            z = z || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m1224getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m1224getYimpl(j));
            z = z || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m1224getYimpl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m1224getYimpl(j));
        return z || !this.edgeEffectWrapper.isBottomAnimating();
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m109pullTopk4lQ0M(long j) {
        float fM1223getXimpl = Offset.m1223getXimpl(m113displacementF1C5BW0$foundation_release());
        float fM1224getYimpl = Offset.m1224getYimpl(j) / Size.m1259getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateTopEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateTopEffect, fM1224getYimpl, fM1223getXimpl) * Size.m1259getHeightimpl(this.containerSize) : Offset.m1224getYimpl(j);
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m106pullBottomk4lQ0M(long j) {
        float fM1223getXimpl = Offset.m1223getXimpl(m113displacementF1C5BW0$foundation_release());
        float fM1224getYimpl = Offset.m1224getYimpl(j) / Size.m1259getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateBottomEffect, -fM1224getYimpl, 1 - fM1223getXimpl)) * Size.m1259getHeightimpl(this.containerSize) : Offset.m1224getYimpl(j);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m107pullLeftk4lQ0M(long j) {
        float fM1224getYimpl = Offset.m1224getYimpl(m113displacementF1C5BW0$foundation_release());
        float fM1223getXimpl = Offset.m1223getXimpl(j) / Size.m1261getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateLeftEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateLeftEffect, fM1223getXimpl, 1 - fM1224getYimpl) * Size.m1261getWidthimpl(this.containerSize) : Offset.m1223getXimpl(j);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m108pullRightk4lQ0M(long j) {
        float fM1224getYimpl = Offset.m1224getYimpl(m113displacementF1C5BW0$foundation_release());
        float fM1223getXimpl = Offset.m1223getXimpl(j) / Size.m1261getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateRightEffect, -fM1223getXimpl, fM1224getYimpl)) * Size.m1261getWidthimpl(this.containerSize) : Offset.m1223getXimpl(j);
    }
}
