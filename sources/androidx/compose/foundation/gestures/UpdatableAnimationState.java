package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class UpdatableAnimationState {
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(AnimationSpec animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082 A[Catch: all -> 0x00ae, PHI: r0 r2 r12 r13 r14
      0x0082: PHI (r0v9 ??) = (r0v3 ??), (r0v15 ??) binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v2 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r12v7 float) = (r12v4 float), (r12v8 float) binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r13v7 kotlin.jvm.functions.Function1) = (r13v4 kotlin.jvm.functions.Function1), (r13v8 kotlin.jvm.functions.Function1) binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0082: PHI (r14v15 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v9 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:30:0x007b, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {all -> 0x00ae, blocks: (B:36:0x00a2, B:31:0x0082, B:33:0x008c), top: B:59:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[Catch: all -> 0x00ae, TryCatch #2 {all -> 0x00ae, blocks: (B:36:0x00a2, B:31:0x0082, B:33:0x008c), top: B:59:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a9 A[PHI: r0 r2 r13 r14
      0x00a9: PHI (r0v4 ??) = (r0v16 ??), (r0v17 ??) binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r2v3 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r13v5 kotlin.jvm.functions.Function1) = (r13v7 kotlin.jvm.functions.Function1), (r13v8 kotlin.jvm.functions.Function1) binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r14v11 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v15 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:32:0x008a, B:38:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:13:0x0034, B:48:0x00d1, B:42:0x00b1, B:45:0x00bc), top: B:55:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2 A[EXC_TOP_SPLITTER, PHI: r0 r2 r12 r13 r14
      0x00a2: PHI (r0v10 ??) = (r0v14 ??), (r0v11 ??) binds: [B:34:0x009f, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v8 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:34:0x009f, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r12v8 float) = (r12v7 float), (r12v13 float) binds: [B:34:0x009f, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r13v8 kotlin.jvm.functions.Function1) = (r13v7 kotlin.jvm.functions.Function1), (r13v15 kotlin.jvm.functions.Function1) binds: [B:34:0x009f, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v15 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v18 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:34:0x009f, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v12, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x009f -> B:59:0x00a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object animateToZero(kotlin.jvm.functions.Function1 r12, kotlin.jvm.functions.Function0 r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }
    }
}
