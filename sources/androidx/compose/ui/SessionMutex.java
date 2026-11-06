package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public abstract class SessionMutex {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static AtomicReference m1121constructorimpl(AtomicReference atomicReference) {
        return atomicReference;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static AtomicReference m1120constructorimpl() {
        return m1121constructorimpl(new AtomicReference(null));
    }

    /* JADX INFO: renamed from: getCurrentSession-impl, reason: not valid java name */
    public static final Object m1122getCurrentSessionimpl(AtomicReference atomicReference) {
        Session session = (Session) atomicReference.get();
        if (session != null) {
            return session.getValue();
        }
        return null;
    }

    /* JADX INFO: renamed from: withSessionCancellingPrevious-impl, reason: not valid java name */
    public static final Object m1123withSessionCancellingPreviousimpl(AtomicReference atomicReference, Function1 function1, Function2 function2, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Session {
        private final Job job;
        private final Object value;

        public Session(Job job, Object obj) {
            this.job = job;
            this.value = obj;
        }

        public final Job getJob() {
            return this.job;
        }

        public final Object getValue() {
            return this.value;
        }
    }
}
