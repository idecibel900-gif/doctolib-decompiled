package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface MutableLongState extends LongState, MutableState {
    @Override // androidx.compose.runtime.LongState
    long getLongValue();

    void setLongValue(long j);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).longValue());
    }

    @Override // androidx.compose.runtime.State
    default Long getValue() {
        return Long.valueOf(getLongValue());
    }

    default void setValue(long j) {
        setLongValue(j);
    }
}
