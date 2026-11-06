package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.semantics.Role;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public class ClickableNode extends AbstractClickableNode {
    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, str, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object clickPointerInput(PointerInputScope pointerInputScope, Continuation continuation) {
        return clickPointerInput$suspendImpl(this, pointerInputScope, continuation);
    }

    private ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0) {
        super(mutableInteractionSource, indicationNodeFactory, z, str, role, function0, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableNode$clickPointerInput$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m140invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m1232unboximpl(), (Continuation) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m140invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = ClickableNode.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pressGestureScope;
            anonymousClass2.J$0 = j;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                if (ClickableNode.this.getEnabled()) {
                    ClickableNode clickableNode = ClickableNode.this;
                    this.label = 1;
                    if (clickableNode.m101handlePressInteractiond4ec7I(pressGestureScope, j, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    static /* synthetic */ Object clickPointerInput$suspendImpl(ClickableNode clickableNode, PointerInputScope pointerInputScope, Continuation continuation) {
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, clickableNode.new AnonymousClass2(null), new Function1() { // from class: androidx.compose.foundation.ClickableNode.clickPointerInput.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m141invokek4lQ0M(((Offset) obj).m1232unboximpl());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m141invokek4lQ0M(long j) {
                if (ClickableNode.this.getEnabled()) {
                    ClickableNode.this.getOnClick().invoke();
                }
            }
        }, continuation);
        return objDetectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: update-QzZPfjk, reason: not valid java name */
    public final void m139updateQzZPfjk(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0) {
        m105updateCommonQzZPfjk(mutableInteractionSource, indicationNodeFactory, z, str, role, function0);
    }
}
