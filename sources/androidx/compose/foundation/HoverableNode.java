package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes.dex */
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction$Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return HoverableNode.this.emitEnter(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1, reason: invalid class name and case insensitive filesystem */
    static final class C01821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01821(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return HoverableNode.this.emitExit(this);
        }
    }

    public HoverableNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public final void updateInteractionSource(MutableInteractionSource mutableInteractionSource) {
        if (Intrinsics.areEqual(this.interactionSource, mutableInteractionSource)) {
            return;
        }
        tryEmitExit();
        this.interactionSource = mutableInteractionSource;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo103onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (pointerEventPass == PointerEventPass.Main) {
            int iM1751getType7fucELk = pointerEvent.m1751getType7fucELk();
            PointerEventType.Companion companion = PointerEventType.Companion;
            if (PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1757getEnter7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1758getExit7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        tryEmitExit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitEnter(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        HoverableNode hoverableNode;
        HoverInteraction$Enter hoverInteraction$Enter;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.hoverInteraction == null) {
                HoverInteraction$Enter hoverInteraction$Enter2 = new HoverInteraction$Enter();
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = hoverInteraction$Enter2;
                anonymousClass1.label = 1;
                if (mutableInteractionSource.emit(hoverInteraction$Enter2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hoverableNode = this;
                hoverInteraction$Enter = hoverInteraction$Enter2;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        hoverInteraction$Enter = (HoverInteraction$Enter) anonymousClass1.L$1;
        hoverableNode = (HoverableNode) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        hoverableNode.hoverInteraction = hoverInteraction$Enter;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitExit(Continuation continuation) {
        C01821 c01821;
        HoverableNode hoverableNode;
        if (continuation instanceof C01821) {
            c01821 = (C01821) continuation;
            int i = c01821.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c01821.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c01821 = new C01821(continuation);
            }
        } else {
            c01821 = new C01821(continuation);
        }
        Object obj = c01821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01821.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter);
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                c01821.L$0 = this;
                c01821.label = 1;
                if (mutableInteractionSource.emit(hoverInteraction$Exit, c01821) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hoverableNode = this;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        hoverableNode = (HoverableNode) c01821.L$0;
        ResultKt.throwOnFailure(obj);
        hoverableNode.hoverInteraction = null;
        return Unit.INSTANCE;
    }

    private final void tryEmitExit() {
        HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
        if (hoverInteraction$Enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            this.hoverInteraction = null;
        }
    }
}
