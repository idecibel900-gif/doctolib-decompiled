package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface MutableIntState extends IntState, MutableState {
    @Override // androidx.compose.runtime.IntState
    int getIntValue();

    void setIntValue(int i);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    @Override // androidx.compose.runtime.State
    default Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    default void setValue(int i) {
        setIntValue(i);
    }
}
