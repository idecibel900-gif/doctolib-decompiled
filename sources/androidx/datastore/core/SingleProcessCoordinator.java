package androidx.datastore.core;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes.dex */
public final class SingleProcessCoordinator implements InterProcessCoordinator {
    private final String filePath;
    private final Mutex mutex;
    private final Flow updateNotifications;
    private final AtomicInt version;

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$lock$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SingleProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    static final class C02721 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02721(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SingleProcessCoordinator.this.tryLock(null, this);
        }
    }

    public SingleProcessCoordinator(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.version = new AtomicInt(0);
        this.updateNotifications = FlowKt.flow(new SingleProcessCoordinator$updateNotifications$1(null));
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Flow getUpdateNotifications() {
        return this.updateNotifications;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object lock(Function1 function1, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                anonymousClass1.L$0 = function1;
                anonymousClass1.L$1 = mutex;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) anonymousClass1.L$1;
            Function1 function2 = (Function1) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            function1 = function2;
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            Object objInvoke = function1.invoke(anonymousClass1);
            if (objInvoke != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objInvoke;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object tryLock(Function2 function2, Continuation continuation) throws Throwable {
        C02721 c02721;
        Mutex mutex;
        Throwable th;
        boolean z;
        if (continuation instanceof C02721) {
            c02721 = (C02721) continuation;
            int i = c02721.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02721.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02721 = new C02721(continuation);
            }
        } else {
            c02721 = new C02721(continuation);
        }
        Object obj = c02721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02721.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c02721.Z$0;
            mutex = (Mutex) c02721.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (z) {
                    mutex.unlock(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                    mutex.unlock(null);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        Mutex mutex2 = this.mutex;
        boolean zTryLock = mutex2.tryLock(null);
        try {
            Object objBoxBoolean = Boxing.boxBoolean(zTryLock);
            c02721.L$0 = mutex2;
            c02721.Z$0 = zTryLock;
            c02721.label = 1;
            Object objInvoke = function2.invoke(objBoxBoolean, c02721);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            obj = objInvoke;
            z = zTryLock;
            if (z) {
                mutex.unlock(null);
            }
            return obj;
        } catch (Throwable th3) {
            mutex = mutex2;
            th = th3;
            z = zTryLock;
            if (z) {
                mutex.unlock(null);
            }
            throw th;
        }
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(Continuation continuation) {
        return Boxing.boxInt(this.version.get());
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(Continuation continuation) {
        return Boxing.boxInt(this.version.incrementAndGet());
    }
}
