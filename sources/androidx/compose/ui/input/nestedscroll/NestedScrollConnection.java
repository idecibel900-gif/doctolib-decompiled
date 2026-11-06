package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    default Object mo237onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return m1729onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    default Object mo1731onPreFlingQWom1Mo(long j, Continuation continuation) {
        return m1730onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    default long mo433onPreScrollOzD1aCk(long j, int i) {
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    default long mo238onPostScrollDzOQY0M(long j, long j2, int i) {
        return Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m1730onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, Continuation continuation) {
        return Velocity.m2642boximpl(Velocity.Companion.m2656getZero9UxMQ8M());
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m1729onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation continuation) {
        return Velocity.m2642boximpl(Velocity.Companion.m2656getZero9UxMQ8M());
    }
}
