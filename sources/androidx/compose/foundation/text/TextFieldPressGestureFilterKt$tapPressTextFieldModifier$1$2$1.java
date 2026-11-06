package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State $onTapState;
    final /* synthetic */ MutableState $pressedInteraction;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(CoroutineScope coroutineScope, MutableState mutableState, MutableInteractionSource mutableInteractionSource, State state, Continuation continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$pressedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
        this.$onTapState = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, continuation);
        textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.L$0 = obj;
        return textFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
            final State state = this.$onTapState;
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m544invokek4lQ0M(((Offset) obj2).m1232unboximpl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m544invokek4lQ0M(long j) {
                    ((Function1) state.getValue()).invoke(Offset.m1214boximpl(j));
                }
            };
            this.label = 1;
            if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, anonymousClass1, function1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState $pressedInteraction;
        final /* synthetic */ CoroutineScope $scope;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, MutableState mutableState, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
            super(3, continuation);
            this.$scope = coroutineScope;
            this.$pressedInteraction = mutableState;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m543invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m1232unboximpl(), (Continuation) obj3);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m543invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, continuation);
            anonymousClass1.L$0 = pressGestureScope;
            anonymousClass1.J$0 = j;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00241 extends SuspendLambda implements Function2 {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ long $it;
            final /* synthetic */ MutableState $pressedInteraction;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00241(MutableState mutableState, long j, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$it = j;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00241(this.$pressedInteraction, this.$it, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:22:0x005a  */
            /* JADX WARN: Code duplicated, block: B:25:0x0065  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                MutableState mutableState;
                MutableState mutableState2;
                PressInteraction.Press press;
                MutableInteractionSource mutableInteractionSource;
                PressInteraction.Press press2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Press press3 = (PressInteraction.Press) this.$pressedInteraction.getValue();
                    if (press3 != null) {
                        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                        mutableState = this.$pressedInteraction;
                        PressInteraction.Cancel cancel = new PressInteraction.Cancel(press3);
                        if (mutableInteractionSource2 != null) {
                            this.L$0 = mutableState;
                            this.label = 1;
                            if (mutableInteractionSource2.emit(cancel, this) != coroutine_suspended) {
                                mutableState2 = mutableState;
                            }
                        } else {
                            mutableState.setValue(null);
                            press = new PressInteraction.Press(this.$it, null);
                            mutableInteractionSource = this.$interactionSource;
                            if (mutableInteractionSource != null) {
                                this.L$0 = press;
                                this.label = 2;
                                if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
                                    press2 = press;
                                    press = press2;
                                }
                            }
                            this.$pressedInteraction.setValue(press);
                            return Unit.INSTANCE;
                        }
                    } else {
                        press = new PressInteraction.Press(this.$it, null);
                        mutableInteractionSource = this.$interactionSource;
                        if (mutableInteractionSource != null) {
                            this.L$0 = press;
                            this.label = 2;
                            if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
                                press2 = press;
                                press = press2;
                            }
                        }
                        this.$pressedInteraction.setValue(press);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    mutableState2 = (MutableState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    press2 = (PressInteraction.Press) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                press = press2;
                this.$pressedInteraction.setValue(press);
                return Unit.INSTANCE;
                mutableState = mutableState2;
                mutableState.setValue(null);
                press = new PressInteraction.Press(this.$it, null);
                mutableInteractionSource = this.$interactionSource;
                if (mutableInteractionSource != null) {
                    this.L$0 = press;
                    this.label = 2;
                    if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
                        press2 = press;
                        press = press2;
                    }
                    return coroutine_suspended;
                }
                this.$pressedInteraction.setValue(press);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new C00241(this.$pressedInteraction, this.J$0, this.$interactionSource, null), 3, null);
                this.label = 1;
                obj = pressGestureScope.tryAwaitRelease(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2 {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState $pressedInteraction;
            final /* synthetic */ boolean $success;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MutableState mutableState, boolean z, MutableInteractionSource mutableInteractionSource, Continuation continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$success = z;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.$pressedInteraction, this.$success, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                MutableState mutableState;
                Interaction cancel;
                MutableState mutableState2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Press press = (PressInteraction.Press) this.$pressedInteraction.getValue();
                    if (press != null) {
                        boolean z = this.$success;
                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                        mutableState = this.$pressedInteraction;
                        if (z) {
                            cancel = new PressInteraction.Release(press);
                        } else {
                            cancel = new PressInteraction.Cancel(press);
                        }
                        if (mutableInteractionSource != null) {
                            this.L$0 = mutableState;
                            this.label = 1;
                            if (mutableInteractionSource.emit(cancel, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutableState2 = mutableState;
                        }
                        mutableState.setValue(null);
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState2 = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableState = mutableState2;
                mutableState.setValue(null);
                return Unit.INSTANCE;
            }
        }
    }
}
