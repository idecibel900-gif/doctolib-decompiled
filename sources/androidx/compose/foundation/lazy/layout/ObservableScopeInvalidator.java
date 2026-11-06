package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObservableScopeInvalidator {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static MutableState m424constructorimpl(MutableState mutableState) {
        return mutableState;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableState m425constructorimpl$default(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableState = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        }
        return m424constructorimpl(mutableState);
    }

    /* JADX INFO: renamed from: attachToScope-impl, reason: not valid java name */
    public static final void m423attachToScopeimpl(MutableState mutableState) {
        mutableState.getValue();
    }

    /* JADX INFO: renamed from: invalidateScope-impl, reason: not valid java name */
    public static final void m426invalidateScopeimpl(MutableState mutableState) {
        mutableState.setValue(Unit.INSTANCE);
    }
}
