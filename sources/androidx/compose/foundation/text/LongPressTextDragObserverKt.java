package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes.dex */
public abstract class LongPressTextDragObserverKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ TextDragObserver $observer;
        final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
            super(2, continuation);
            this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
                super(2, continuation);
                this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_detectDownAndDragGesturesWithObserver;
                    TextDragObserver textDragObserver = this.$observer;
                    this.label = 1;
                    if (LongPressTextDragObserverKt.detectPreDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 1, null);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new C00232(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 1, null);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$2, reason: invalid class name and collision with other inner class name */
        static final class C00232 extends SuspendLambda implements Function2 {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00232(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
                super(2, continuation);
                this.$this_detectDownAndDragGesturesWithObserver = pointerInputScope;
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00232(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_detectDownAndDragGesturesWithObserver;
                    TextDragObserver textDragObserver = this.$observer;
                    this.label = 1;
                    if (LongPressTextDragObserverKt.detectDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2(pointerInputScope, textDragObserver, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2, reason: invalid class name and case insensitive filesystem */
    static final class C02122 extends RestrictedSuspendLambda implements Function2 {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02122(TextDragObserver textDragObserver, Continuation continuation) {
            super(2, continuation);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C02122 c02122 = new C02122(this.$observer, continuation);
            c02122.L$0 = obj;
            return c02122;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((C02122) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
        
            if (r14 == r0) goto L17;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005d -> B:18:0x0060). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2c
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r13.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                java.lang.Object r4 = r13.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r14)
                r7 = r13
                goto L60
            L1b:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L23:
                java.lang.Object r1 = r13.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r14)
                r7 = r13
                goto L45
            L2c:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                r4 = r14
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                r13.L$0 = r4
                r13.label = r3
                r5 = 0
                r6 = 0
                r8 = 2
                r9 = 0
                r7 = r13
                java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                if (r14 != r0) goto L44
                goto L5f
            L44:
                r1 = r4
            L45:
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                androidx.compose.foundation.text.TextDragObserver r4 = r7.$observer
                long r5 = r14.m1778getPositionF1C5BW0()
                r4.mo526onDownk4lQ0M(r5)
                r4 = r1
                r1 = r14
            L52:
                r7.L$0 = r4
                r7.L$1 = r1
                r7.label = r2
                r14 = 0
                java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r4, r14, r13, r3, r14)
                if (r14 != r0) goto L60
            L5f:
                return r0
            L60:
                androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
                java.util.List r14 = r14.getChanges()
                int r5 = r14.size()
                r6 = 0
            L6b:
                if (r6 >= r5) goto L8b
                java.lang.Object r8 = r14.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                long r9 = r8.m1776getIdJ3iCeTQ()
                long r11 = r1.m1776getIdJ3iCeTQ()
                boolean r9 = androidx.compose.ui.input.pointer.PointerId.m1769equalsimpl0(r9, r11)
                if (r9 == 0) goto L88
                boolean r8 = r8.getPressed()
                if (r8 == 0) goto L88
                goto L52
            L88:
                int r6 = r6 + 1
                goto L6b
            L8b:
                androidx.compose.foundation.text.TextDragObserver r14 = r7.$observer
                r14.onUp()
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt.C02122.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectPreDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C02122(textDragObserver, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectDragGesturesWithObserver(PointerInputScope pointerInputScope, final TextDragObserver textDragObserver, Continuation continuation) {
        Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(pointerInputScope, new Function1() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt.detectDragGesturesWithObserver.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m493invokek4lQ0M(((Offset) obj).m1232unboximpl());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m493invokek4lQ0M(long j) {
                textDragObserver.mo528onStartk4lQ0M(j);
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt.detectDragGesturesWithObserver.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m494invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m494invoke() {
                textDragObserver.onStop();
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt.detectDragGesturesWithObserver.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m495invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m495invoke() {
                textDragObserver.onCancel();
            }
        }, new Function2() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt.detectDragGesturesWithObserver.5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m496invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m1232unboximpl());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
            public final void m496invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                textDragObserver.mo527onDragk4lQ0M(j);
            }
        }, continuation);
        return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
    }
}
