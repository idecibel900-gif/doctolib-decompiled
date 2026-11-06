package com.swmansion.rnscreens.transition;

import android.animation.FloatEvaluator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExternalBoundaryValuesEvaluator extends FloatEvaluator {
    private Number endValueCache;
    private final Function1 endValueProvider;
    private Number startValueCache;
    private final Function1 startValueProvider;

    public ExternalBoundaryValuesEvaluator(Function1 startValueProvider, Function1 endValueProvider) {
        Intrinsics.checkNotNullParameter(startValueProvider, "startValueProvider");
        Intrinsics.checkNotNullParameter(endValueProvider, "endValueProvider");
        this.startValueProvider = startValueProvider;
        this.endValueProvider = endValueProvider;
    }

    private final Number getStartValue(Number number) {
        if (this.startValueCache == null) {
            this.startValueCache = (Number) this.startValueProvider.invoke(number);
        }
        return this.startValueCache;
    }

    private final Number getEndValue(Number number) {
        if (this.endValueCache == null) {
            this.endValueCache = (Number) this.endValueProvider.invoke(number);
        }
        return this.endValueCache;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        Number startValue = getStartValue(number);
        Number endValue = getEndValue(number2);
        if (startValue == null || endValue == null) {
            return null;
        }
        return super.evaluate(f, startValue, endValue);
    }
}
