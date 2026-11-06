package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface MutableFloatState extends FloatState, MutableState {
    @Override // androidx.compose.runtime.FloatState
    float getFloatValue();

    void setFloatValue(float f);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).floatValue());
    }

    @Override // androidx.compose.runtime.State
    default Float getValue() {
        return Float.valueOf(getFloatValue());
    }

    default void setValue(float f) {
        setFloatValue(f);
    }
}
