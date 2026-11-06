package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class PointerInteropUtils_androidKt {
    /* JADX INFO: renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m1792toMotionEventScoped4ec7I(PointerEvent pointerEvent, long j, Function1 function1) {
        m1793toMotionEventScopeubNVwUQ(pointerEvent, j, function1, false);
    }

    /* JADX INFO: renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m1791toCancelMotionEventScoped4ec7I(PointerEvent pointerEvent, long j, Function1 function1) {
        m1793toMotionEventScopeubNVwUQ(pointerEvent, j, function1, true);
    }

    public static final void emptyCancelMotionEventScope(long j, Function1 function1) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        function1.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX INFO: renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m1793toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j, Function1 function1, boolean z) {
        MotionEvent motionEvent$ui_release = pointerEvent.getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.");
        }
        int action = motionEvent$ui_release.getAction();
        if (z) {
            motionEvent$ui_release.setAction(3);
        }
        motionEvent$ui_release.offsetLocation(-Offset.m1223getXimpl(j), -Offset.m1224getYimpl(j));
        function1.invoke(motionEvent$ui_release);
        motionEvent$ui_release.offsetLocation(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j));
        motionEvent$ui_release.setAction(action);
    }
}
