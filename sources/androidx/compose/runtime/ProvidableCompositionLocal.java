package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProvidableCompositionLocal extends CompositionLocal {
    public abstract ProvidedValue defaultProvidedValue$runtime_release(Object obj);

    public ProvidableCompositionLocal(Function0 function0) {
        super(function0, null);
    }

    public final ProvidedValue provides(Object obj) {
        return defaultProvidedValue$runtime_release(obj);
    }

    public final ProvidedValue providesDefault(Object obj) {
        return defaultProvidedValue$runtime_release(obj).ifNotAlreadyProvided$runtime_release();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034 A[PHI: r5
      0x0034: PHI (r5v2 androidx.compose.runtime.ValueHolder) = (r5v5 androidx.compose.runtime.ValueHolder), (r5v6 androidx.compose.runtime.ValueHolder) binds: [B:17:0x0044, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.runtime.CompositionLocal
    public ValueHolder updatedStateOf$runtime_release(ProvidedValue providedValue, ValueHolder valueHolder) {
        ComputedValueHolder computedValueHolder;
        ValueHolder valueHolder2;
        StaticValueHolder staticValueHolder;
        DynamicValueHolder dynamicValueHolder;
        ValueHolder valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        valueHolder3 = null;
        if (valueHolder instanceof DynamicValueHolder) {
            if (providedValue.isDynamic$runtime_release()) {
                dynamicValueHolder = (DynamicValueHolder) valueHolder;
                dynamicValueHolder.getState().setValue(providedValue.getEffectiveValue$runtime_release());
            }
        } else if (valueHolder instanceof StaticValueHolder) {
            if (providedValue.isStatic$runtime_release()) {
                staticValueHolder = (StaticValueHolder) valueHolder;
                if (Intrinsics.areEqual(providedValue.getEffectiveValue$runtime_release(), staticValueHolder.getValue())) {
                    valueHolder2 = computedValueHolder;
                    valueHolder2 = staticValueHolder;
                    valueHolder3 = valueHolder2;
                }
            }
        } else if (valueHolder instanceof ComputedValueHolder) {
            computedValueHolder = (ComputedValueHolder) valueHolder;
            if (providedValue.getCompute$runtime_release() == computedValueHolder.getCompute()) {
                valueHolder2 = computedValueHolder;
                valueHolder2 = staticValueHolder;
                valueHolder3 = valueHolder2;
            }
        }
        if (valueHolder3 == null) {
            valueHolder3 = dynamicValueHolder;
            return valueHolderOf(providedValue);
        }
        valueHolder3 = dynamicValueHolder;
        return valueHolder3;
    }

    private final ValueHolder valueHolderOf(ProvidedValue providedValue) {
        if (providedValue.isDynamic$runtime_release()) {
            MutableState state$runtime_release = providedValue.getState$runtime_release();
            if (state$runtime_release == null) {
                Object value = providedValue.getValue();
                SnapshotMutationPolicy mutationPolicy$runtime_release = providedValue.getMutationPolicy$runtime_release();
                if (mutationPolicy$runtime_release == null) {
                    mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
                }
                state$runtime_release = SnapshotStateKt.mutableStateOf(value, mutationPolicy$runtime_release);
            }
            return new DynamicValueHolder(state$runtime_release);
        }
        if (providedValue.getCompute$runtime_release() != null) {
            return new ComputedValueHolder(providedValue.getCompute$runtime_release());
        }
        return providedValue.getState$runtime_release() != null ? new DynamicValueHolder(providedValue.getState$runtime_release()) : new StaticValueHolder(providedValue.getEffectiveValue$runtime_release());
    }
}
