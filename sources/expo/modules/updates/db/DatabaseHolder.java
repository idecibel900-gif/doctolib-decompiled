package expo.modules.updates.db;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DatabaseHolder {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = DatabaseHolder.class.getSimpleName();
    private final UpdatesDatabase database;
    private final UpdatesDatabase mDatabase;
    private final Mutex mutex;

    /* JADX INFO: renamed from: expo.modules.updates.db.DatabaseHolder$withDatabase$1, reason: invalid class name */
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
            return DatabaseHolder.this.withDatabase(null, this);
        }
    }

    public DatabaseHolder(UpdatesDatabase mDatabase) {
        Intrinsics.checkNotNullParameter(mDatabase, "mDatabase");
        this.mDatabase = mDatabase;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.database = (UpdatesDatabase) BuildersKt__BuildersKt.runBlocking$default(null, new DatabaseHolder$database$1(this, null), 1, null);
    }

    public final UpdatesDatabase getDatabase() {
        return this.database;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object withDatabase(Function2 function2, Continuation continuation) throws Throwable {
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
                anonymousClass1.L$0 = function2;
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
            Function2 function3 = (Function2) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            function2 = function3;
            UpdatesDatabase updatesDatabase = this.mDatabase;
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            Object objInvoke = function2.invoke(updatesDatabase, anonymousClass1);
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

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
