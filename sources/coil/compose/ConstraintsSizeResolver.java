package coil.compose;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import coil.size.Size;
import coil.size.SizeResolver;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    private final MutableStateFlow _constraints = StateFlowKt.MutableStateFlow(Constraints.m2519boximpl(UtilsKt.getZeroConstraints()));

    @Override // coil.size.SizeResolver
    public Object size(Continuation continuation) {
        final MutableStateFlow mutableStateFlow = this._constraints;
        return FlowKt.first(new Flow() { // from class: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= LinearLayoutManager.INVALID_OFFSET;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Size sizeM3009toSizeOrNullBRTryo0 = AsyncImageKt.m3009toSizeOrNullBRTryo0(((Constraints) obj).m2536unboximpl());
                        if (sizeM3009toSizeOrNullBRTryo0 != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(sizeM3009toSizeOrNullBRTryo0, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, continuation);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo32measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        this._constraints.setValue(Constraints.m2519boximpl(j));
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: coil.compose.ConstraintsSizeResolver$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
