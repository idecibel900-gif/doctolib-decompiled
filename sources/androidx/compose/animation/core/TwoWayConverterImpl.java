package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class TwoWayConverterImpl implements TwoWayConverter {
    private final Function1 convertFromVector;
    private final Function1 convertToVector;

    public TwoWayConverterImpl(Function1 function1, Function1 function2) {
        this.convertToVector = function1;
        this.convertFromVector = function2;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 getConvertToVector() {
        return this.convertToVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 getConvertFromVector() {
        return this.convertFromVector;
    }
}
