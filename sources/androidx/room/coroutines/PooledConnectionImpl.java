package androidx.room.coroutines;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes.dex */
final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    private final ConnectionElementKey connectionElementKey;
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;
    private volatile boolean isRecycled;
    private final ArrayDeque transactionStack;

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1, reason: invalid class name */
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
            return PooledConnectionImpl.this.beginTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$endTransaction$1, reason: invalid class name and case insensitive filesystem */
    static final class C02791 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PooledConnectionImpl.this.endTransaction(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$transaction$1, reason: invalid class name and case insensitive filesystem */
    static final class C02801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02801(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PooledConnectionImpl.this.transaction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PooledConnectionImpl$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    static final class C02811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02811(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PooledConnectionImpl.this.usePrepared(null, null, this);
        }
    }

    public PooledConnectionImpl(ConnectionElementKey connectionElementKey, ConnectionWithLock delegate, boolean z) {
        Intrinsics.checkNotNullParameter(connectionElementKey, "connectionElementKey");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.connectionElementKey = connectionElementKey;
        this.delegate = delegate;
        this.isReadOnly = z;
        this.transactionStack = new ArrayDeque();
    }

    public final ConnectionElementKey getConnectionElementKey() {
        return this.connectionElementKey;
    }

    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    public Object usePrepared(String str, Function1 function1, Continuation continuation) {
        C02811 c02811;
        Mutex mutex;
        if (continuation instanceof C02811) {
            c02811 = (C02811) continuation;
            int i = c02811.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02811.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02811 = new C02811(continuation);
            }
        } else {
            c02811 = new C02811(continuation);
        }
        Object obj = c02811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02811.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isRecycled) {
                SQLite.throwSQLiteException(21, "Connection is recycled");
                throw new KotlinNothingValueException();
            }
            ConnectionElement connectionElement = (ConnectionElement) c02811.getContext().get(getConnectionElementKey());
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                mutex = this.delegate;
                c02811.L$0 = str;
                c02811.L$1 = function1;
                c02811.L$2 = mutex;
                c02811.label = 1;
                if (mutex.lock(null, c02811) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                throw new KotlinNothingValueException();
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c02811.L$2;
            function1 = (Function1) c02811.L$1;
            String str2 = (String) c02811.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str2;
        }
        try {
            StatementWrapper statementWrapper = new StatementWrapper(this, this.delegate.prepare(str));
            try {
                Object objInvoke = function1.invoke(statementWrapper);
                AutoCloseableKt.closeFinally(statementWrapper, null);
                mutex.unlock(null);
                return objInvoke;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(statementWrapper, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            mutex.unlock(null);
            throw th3;
        }
    }

    public final void markRecycled() throws Exception {
        if (this.isRecycled) {
            return;
        }
        this.isRecycled = true;
        if (this.delegate.inTransaction()) {
            SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
    
        if (endTransaction(false, r0) == r1) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.room.coroutines.PooledConnectionImpl] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.room.Transactor$SQLiteTransactionType] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.room.Transactor$SQLiteTransactionType] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r9, kotlin.jvm.functions.Function2 r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.room.coroutines.PooledConnectionImpl.C02801
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl.C02801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$transaction$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 5
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L61
            if (r2 == r7) goto L58
            if (r2 == r6) goto L4f
            if (r2 == r5) goto L49
            r9 = 4
            if (r2 == r9) goto L49
            if (r2 == r4) goto L3a
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r0.L$1
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: android.database.SQLException -> L47
            goto Laa
        L47:
            r11 = move-exception
            goto La5
        L49:
            java.lang.Object r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            return r9
        L4f:
            int r9 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L55
            goto L87
        L55:
            r9 = move-exception
            r10 = r9
            goto L96
        L58:
            java.lang.Object r9 = r0.L$0
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L73
        L61:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r9 != 0) goto L68
            androidx.room.Transactor$SQLiteTransactionType r9 = androidx.room.Transactor.SQLiteTransactionType.DEFERRED
        L68:
            r0.L$0 = r10
            r0.label = r7
            java.lang.Object r9 = r8.beginTransaction(r9, r0)
            if (r9 != r1) goto L73
            goto La4
        L73:
            androidx.room.coroutines.PooledConnectionImpl$TransactionImpl r9 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl     // Catch: java.lang.Throwable -> L55
            r9.<init>()     // Catch: java.lang.Throwable -> L55
            r11 = 0
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L55
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L55
            r0.label = r6     // Catch: java.lang.Throwable -> L55
            java.lang.Object r11 = r10.invoke(r9, r0)     // Catch: java.lang.Throwable -> L55
            if (r11 != r1) goto L86
            goto La4
        L86:
            r9 = r7
        L87:
            if (r9 == 0) goto L8a
            r3 = r7
        L8a:
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r9 = r8.endTransaction(r3, r0)
            if (r9 != r1) goto L95
            goto La4
        L95:
            return r11
        L96:
            throw r10     // Catch: java.lang.Throwable -> L97
        L97:
            r9 = move-exception
            r0.L$0 = r10     // Catch: android.database.SQLException -> L47
            r0.L$1 = r9     // Catch: android.database.SQLException -> L47
            r0.label = r4     // Catch: android.database.SQLException -> L47
            java.lang.Object r10 = r8.endTransaction(r3, r0)     // Catch: android.database.SQLException -> L47
            if (r10 != r1) goto Laa
        La4:
            return r1
        La5:
            if (r10 == 0) goto Lab
            kotlin.ExceptionsKt.addSuppressed(r10, r11)
        Laa:
            throw r9
        Lab:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.transaction(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object beginTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.delegate;
            anonymousClass1.L$0 = sQLiteTransactionType;
            anonymousClass1.L$1 = mutex;
            anonymousClass1.label = 1;
            if (mutex.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) anonymousClass1.L$1;
            Transactor.SQLiteTransactionType sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            sQLiteTransactionType = sQLiteTransactionType2;
        }
        try {
            int size = this.transactionStack.size();
            if (this.transactionStack.isEmpty()) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                if (i3 == 1) {
                    SQLite.execSQL(this.delegate, "BEGIN DEFERRED TRANSACTION");
                } else if (i3 == 2) {
                    SQLite.execSQL(this.delegate, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    SQLite.execSQL(this.delegate, "BEGIN EXCLUSIVE TRANSACTION");
                }
            } else {
                SQLite.execSQL(this.delegate, "SAVEPOINT '" + size + '\'');
            }
            this.transactionStack.addLast(new TransactionItem(size, false));
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return unit;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object endTransaction(boolean z, Continuation continuation) {
        C02791 c02791;
        Mutex mutex;
        if (continuation instanceof C02791) {
            c02791 = (C02791) continuation;
            int i = c02791.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02791.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02791 = new C02791(continuation);
            }
        } else {
            c02791 = new C02791(continuation);
        }
        Object obj = c02791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02791.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectionWithLock connectionWithLock = this.delegate;
            c02791.L$0 = connectionWithLock;
            c02791.Z$0 = z;
            c02791.label = 1;
            if (connectionWithLock.lock(null, c02791) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = connectionWithLock;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c02791.Z$0;
            mutex = (Mutex) c02791.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.transactionStack.isEmpty()) {
                throw new IllegalStateException("Not in a transaction");
            }
            TransactionItem transactionItem = (TransactionItem) CollectionsKt.removeLast(this.transactionStack);
            if (z && !transactionItem.getShouldRollback()) {
                if (this.transactionStack.isEmpty()) {
                    SQLite.execSQL(this.delegate, "END TRANSACTION");
                } else {
                    SQLite.execSQL(this.delegate, "RELEASE SAVEPOINT '" + transactionItem.getId() + '\'');
                }
            } else if (this.transactionStack.isEmpty()) {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } else {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION TO SAVEPOINT '" + transactionItem.getId() + '\'');
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return unit;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    private static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i, boolean z) {
            this.id = i;
            this.shouldRollback = z;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }
    }

    private final class TransactionImpl implements TransactionScope, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        @Override // androidx.room.PooledConnection
        public Object usePrepared(String str, Function1 function1, Continuation continuation) {
            return PooledConnectionImpl.this.usePrepared(str, function1, continuation);
        }
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(Continuation continuation) {
        if (this.isRecycled) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(getConnectionElementKey());
        if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
            return Boxing.boxBoolean(!this.transactionStack.isEmpty() || this.delegate.inTransaction());
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    public Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        if (this.isRecycled) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        ConnectionElement connectionElement = (ConnectionElement) continuation.getContext().get(getConnectionElementKey());
        if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
            return transaction(sQLiteTransactionType, function2, continuation);
        }
        SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    private final class StatementWrapper implements SQLiteStatement {
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindBlob(int i, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindBlob(i, value);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindLong(int i, long j) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindLong(i, j);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindNull(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindNull(i);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindText(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindText(i, value);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void clearBindings() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.clearBindings();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.close();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(i);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.reset();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (this.this$0.isRecycled) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }
    }
}
