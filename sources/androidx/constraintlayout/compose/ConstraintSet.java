package androidx.constraintlayout.compose;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ConstraintSet {
    void applyTo(State state, List list);

    default boolean isDirty(List list) {
        return true;
    }
}
