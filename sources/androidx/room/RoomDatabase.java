package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelper;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.util.DBUtil;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.driver.SupportSQLiteConnection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public static final Companion Companion = new Companion(null);
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private DatabaseConfiguration configuration;
    private RoomConnectionManager connectionManager;
    private CoroutineScope coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;
    protected List mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private CoroutineContext transactionContext;
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));
    private final ThreadLocal suspendingTransactionContext = new ThreadLocal();
    private final Map typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    public static abstract class PrepackagedDatabaseCallback {
    }

    protected abstract InvalidationTracker createInvalidationTracker();

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime = roomConnectionManager.getSupportOpenHelper$room_runtime();
        if (supportOpenHelper$room_runtime != null) {
            return supportOpenHelper$room_runtime;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTracker");
        return null;
    }

    public final CloseBarrier getCloseBarrier$room_runtime() {
        return this.closeBarrier;
    }

    public final ThreadLocal getSuspendingTransactionContext() {
        return this.suspendingTransactionContext;
    }

    private final boolean isThreadInSuspendingTransaction() {
        CoroutineContext coroutineContext = (CoroutineContext) this.suspendingTransactionContext.get();
        return (coroutineContext != null ? (TransactionElement) coroutineContext.get(TransactionElement.Key) : null) != null;
    }

    public final boolean getUseTempTrackingTable$room_runtime() {
        return this.useTempTrackingTable;
    }

    public final void addTypeConverter$room_runtime(KClass kclass, Object converter) {
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.typeConverters.put(kclass, converter);
    }

    public void init(DatabaseConfiguration configuration) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
        this.useTempTrackingTable = configuration.getUseTempTrackingTable$room_runtime();
        this.connectionManager = createConnectionManager$room_runtime(configuration);
        this.internalTracker = createInvalidationTracker();
        RoomDatabaseKt.validateAutoMigrations(this, configuration);
        RoomDatabaseKt.validateTypeConverters(this, configuration);
        CoroutineContext coroutineContext2 = configuration.queryCoroutineContext;
        CoroutineScope coroutineScope = null;
        if (coroutineContext2 != null) {
            CoroutineContext.Element element = coroutineContext2.get(ContinuationInterceptor.Key);
            Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) element;
            Executor executorAsExecutor = ExecutorsKt.asExecutor(coroutineDispatcher);
            this.internalQueryExecutor = executorAsExecutor;
            if (executorAsExecutor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                executorAsExecutor = null;
            }
            this.internalTransactionExecutor = new TransactionExecutor(executorAsExecutor);
            this.coroutineScope = CoroutineScopeKt.CoroutineScope(configuration.queryCoroutineContext.plus(SupervisorKt.SupervisorJob((Job) configuration.queryCoroutineContext.get(Job.Key))));
            if (inCompatibilityMode()) {
                CoroutineScope coroutineScope2 = this.coroutineScope;
                if (coroutineScope2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    coroutineScope2 = null;
                }
                coroutineContext = coroutineScope2.getCoroutineContext().plus(coroutineDispatcher.limitedParallelism(1));
            } else {
                CoroutineScope coroutineScope3 = this.coroutineScope;
                if (coroutineScope3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    coroutineScope3 = null;
                }
                coroutineContext = coroutineScope3.getCoroutineContext();
            }
            this.transactionContext = coroutineContext;
        } else {
            this.internalQueryExecutor = configuration.queryExecutor;
            this.internalTransactionExecutor = new TransactionExecutor(configuration.transactionExecutor);
            Executor executor = this.internalQueryExecutor;
            if (executor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                executor = null;
            }
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executor).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
            this.coroutineScope = CoroutineScope;
            if (CoroutineScope == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                CoroutineScope = null;
            }
            CoroutineContext coroutineContext3 = CoroutineScope.getCoroutineContext();
            Executor executor2 = this.internalTransactionExecutor;
            if (executor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
                executor2 = null;
            }
            this.transactionContext = coroutineContext3.plus(ExecutorsKt.from(executor2));
        }
        this.allowMainThreadQueries = configuration.allowMainThreadQueries;
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime = roomConnectionManager.getSupportOpenHelper$room_runtime();
        if (supportOpenHelper$room_runtime != null) {
            while (!(supportOpenHelper$room_runtime instanceof PrePackagedCopyOpenHelper)) {
                if (!(supportOpenHelper$room_runtime instanceof DelegatingOpenHelper)) {
                    supportOpenHelper$room_runtime = null;
                    break;
                }
                supportOpenHelper$room_runtime = ((DelegatingOpenHelper) supportOpenHelper$room_runtime).getDelegate();
            }
        } else {
            supportOpenHelper$room_runtime = null;
            break;
        }
        PrePackagedCopyOpenHelper prePackagedCopyOpenHelper = (PrePackagedCopyOpenHelper) supportOpenHelper$room_runtime;
        if (prePackagedCopyOpenHelper != null) {
            prePackagedCopyOpenHelper.setDatabaseConfiguration(configuration);
        }
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager2 = null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime2 = roomConnectionManager2.getSupportOpenHelper$room_runtime();
        if (supportOpenHelper$room_runtime2 != null) {
            while (!(supportOpenHelper$room_runtime2 instanceof AutoClosingRoomOpenHelper)) {
                if (!(supportOpenHelper$room_runtime2 instanceof DelegatingOpenHelper)) {
                    supportOpenHelper$room_runtime2 = null;
                    break;
                }
                supportOpenHelper$room_runtime2 = ((DelegatingOpenHelper) supportOpenHelper$room_runtime2).getDelegate();
            }
        } else {
            supportOpenHelper$room_runtime2 = null;
            break;
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) supportOpenHelper$room_runtime2;
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.getAutoCloser$room_runtime();
            AutoCloser autoCloser$room_runtime = autoClosingRoomOpenHelper.getAutoCloser$room_runtime();
            CoroutineScope coroutineScope4 = this.coroutineScope;
            if (coroutineScope4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            } else {
                coroutineScope = coroutineScope4;
            }
            autoCloser$room_runtime.initCoroutineScope(coroutineScope);
            getInvalidationTracker().setAutoCloser$room_runtime(autoClosingRoomOpenHelper.getAutoCloser$room_runtime());
        }
        if (configuration.multiInstanceInvalidationServiceIntent != null) {
            if (configuration.name == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            getInvalidationTracker().initMultiInstanceInvalidation$room_runtime(configuration.context, configuration.name, configuration.multiInstanceInvalidationServiceIntent);
        }
    }

    public final RoomConnectionManager createConnectionManager$room_runtime(DatabaseConfiguration configuration) {
        RoomOpenDelegate roomOpenDelegate;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        try {
            RoomOpenDelegateMarker roomOpenDelegateMarkerCreateOpenDelegate = createOpenDelegate();
            Intrinsics.checkNotNull(roomOpenDelegateMarkerCreateOpenDelegate, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            roomOpenDelegate = (RoomOpenDelegate) roomOpenDelegateMarkerCreateOpenDelegate;
        } catch (NotImplementedError unused) {
            roomOpenDelegate = null;
        }
        if (roomOpenDelegate == null) {
            return new RoomConnectionManager(configuration, new Function1() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDatabase.createConnectionManager$lambda$2(this.f$0, (DatabaseConfiguration) obj);
                }
            }, new RoomDatabase$createConnectionManager$2(this));
        }
        return new RoomConnectionManager(configuration, roomOpenDelegate, new RoomDatabase$createConnectionManager$3(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper createConnectionManager$lambda$2(RoomDatabase roomDatabase, DatabaseConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return roomDatabase.createOpenHelper(config);
    }

    public List getAutoMigrations(Map autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        throw new NotImplementedError(null, 1, null);
    }

    protected RoomOpenDelegateMarker createOpenDelegate() {
        throw new NotImplementedError(null, 1, null);
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
        return null;
    }

    public final CoroutineContext getQueryContext() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        return coroutineScope.getCoroutineContext();
    }

    public final CoroutineContext getTransactionContext$room_runtime() {
        CoroutineContext coroutineContext = this.transactionContext;
        if (coroutineContext != null) {
            return coroutineContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transactionContext");
        return null;
    }

    protected Map getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    protected Map getRequiredTypeConverterClasses() {
        Set<Map.Entry> setEntrySet = getRequiredTypeConverters().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(JvmClassMappingKt.getKotlinClass((Class) it.next()));
            }
            Pair pair = TuplesKt.to(kotlinClass, arrayList);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public List createAutoMigrations(Map autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(autoMigrationSpecs.size()));
        for (Map.Entry entry : autoMigrationSpecs.entrySet()) {
            linkedHashMap.put(JvmClassMappingKt.getJavaClass((KClass) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    public final Map getRequiredTypeConverterClassesMap$room_runtime() {
        return getRequiredTypeConverterClasses();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    public Set getRequiredAutoMigrationSpecClasses() {
        Set requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(requiredAutoMigrationSpecs, 10));
        Iterator it = requiredAutoMigrationSpecs.iterator();
        while (it.hasNext()) {
            arrayList.add(JvmClassMappingKt.getKotlinClass((Class) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final boolean isOpenInternal$room_runtime() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            SupportSQLiteDatabase delegateDatabase$room_runtime = autoCloser.getDelegateDatabase$room_runtime();
            if (delegateDatabase$room_runtime != null) {
                return delegateDatabase$room_runtime.isOpen();
            }
            return false;
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.isSupportDatabaseOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosed() {
        CoroutineScope coroutineScope = this.coroutineScope;
        RoomConnectionManager roomConnectionManager = null;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        getInvalidationTracker().stop$room_runtime();
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
        } else {
            roomConnectionManager = roomConnectionManager2;
        }
        roomConnectionManager.close();
    }

    public final boolean isMainThread$room_runtime() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (inCompatibilityMode() && !inTransaction() && isThreadInSuspendingTransaction()) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final Object useConnection(boolean z, Function2 function2, Continuation continuation) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.useConnection(z, function2, continuation);
    }

    public final boolean inCompatibilityMode() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.getSupportOpenHelper$room_runtime() != null;
    }

    public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(query, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(query);
    }

    public SupportSQLiteStatement compileStatement(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(sql);
    }

    public void beginTransaction() {
        assertNotMainThread();
        internalBeginTransaction();
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            getInvalidationTracker().syncBlocking$room_runtime();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public void endTransaction() {
        internalEndTransaction();
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        getInvalidationTracker().refreshVersionsAsync();
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runInTransaction$lambda$10(Runnable runnable) {
        runnable.run();
        return Unit.INSTANCE;
    }

    public void runInTransaction(final Runnable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        runInTransaction(new Function0() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RoomDatabase.runInTransaction$lambda$10(body);
            }
        });
    }

    public Object runInTransaction(final Callable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return runInTransaction(new Function0() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return body.call();
            }
        });
    }

    private final Object runInTransaction(final Function0 function0) {
        if (inCompatibilityMode()) {
            beginTransaction();
            try {
                Object objInvoke = function0.invoke();
                setTransactionSuccessful();
                return objInvoke;
            } finally {
                endTransaction();
            }
        }
        return DBUtil.performBlocking(this, false, true, new Function1() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDatabase.runInTransaction$lambda$12(function0, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object runInTransaction$lambda$12(Function0 function0, SQLiteConnection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return function0.invoke();
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        internalInitInvalidationTracker(new SupportSQLiteConnection(db));
    }

    protected final void internalInitInvalidationTracker(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        getInvalidationTracker().internalInit$room_runtime(connection);
    }

    public boolean inTransaction() {
        return isOpenInternal$room_runtime() && getOpenHelper().getWritableDatabase().inTransaction();
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public final JournalMode resolve$room_runtime(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager != null && !activityManager.isLowRamDevice()) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    public static class Builder {
        private boolean allowDestructiveMigrationForAllTables;
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private final List autoMigrationSpecs;
        private final List callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable copyFromInputStream;
        private SQLiteDriver driver;
        private final Function0 factory;
        private boolean inMemoryTrackingTableMode;
        private JournalMode journalMode;
        private final KClass klass;
        private final MigrationContainer migrationContainer;
        private final Set migrationStartAndEndVersions;
        private Set migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private CoroutineContext queryCoroutineContext;
        private Executor queryExecutor;
        private boolean requireMigration;
        private SupportSQLiteOpenHelper.Factory supportOpenHelperFactory;
        private Executor transactionExecutor;
        private final List typeConverters;

        public Builder(Context context, Class klass, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(klass, "klass");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = JvmClassMappingKt.getKotlinClass(klass);
            this.context = context;
            this.name = str;
            this.factory = null;
        }

        public Builder openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
            this.supportOpenHelperFactory = factory;
            return this;
        }

        public Builder addMigrations(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (Migration migration : migrations) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        public Builder allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public Builder setQueryExecutor(Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            if (this.queryCoroutineContext != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.queryExecutor = executor;
            return this;
        }

        public Builder fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public final Builder fallbackToDestructiveMigration(boolean z) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z;
            return this;
        }

        public Builder addCallback(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public RoomDatabase build() {
            SupportSQLiteOpenHelper.Factory prePackagedCopyOpenHelperFactory;
            SupportSQLiteOpenHelper.Factory factory;
            RoomDatabase roomDatabase;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            RoomDatabaseKt.validateMigrationsNotRequired(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            SQLiteDriver sQLiteDriver = this.driver;
            if (sQLiteDriver == null && this.supportOpenHelperFactory == null) {
                prePackagedCopyOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            } else if (sQLiteDriver == null) {
                prePackagedCopyOpenHelperFactory = this.supportOpenHelperFactory;
            } else {
                if (this.supportOpenHelperFactory != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                prePackagedCopyOpenHelperFactory = null;
            }
            boolean z = this.autoCloseTimeout > 0;
            boolean z2 = (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) ? false : true;
            if (prePackagedCopyOpenHelperFactory != null) {
                if (z) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    prePackagedCopyOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(prePackagedCopyOpenHelperFactory, new AutoCloser(j, timeUnit, null, 4, null));
                }
                if (z2) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.copyFromAssetPath;
                    int i = str == null ? 0 : 1;
                    File file = this.copyFromFile;
                    int i2 = file == null ? 0 : 1;
                    Callable callable = this.copyFromInputStream;
                    if (i + i2 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    prePackagedCopyOpenHelperFactory = new PrePackagedCopyOpenHelperFactory(str, file, callable, prePackagedCopyOpenHelperFactory);
                }
                factory = prePackagedCopyOpenHelperFactory;
            } else {
                factory = null;
            }
            if (factory == null) {
                if (z) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z2) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.context;
            String str2 = this.name;
            MigrationContainer migrationContainer = this.migrationContainer;
            List list = this.callbacks;
            boolean z3 = this.allowMainThreadQueries;
            JournalMode journalModeResolve$room_runtime = this.journalMode.resolve$room_runtime(context);
            Executor executor2 = this.queryExecutor;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor3 = this.transactionExecutor;
            if (executor3 != null) {
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, list, z3, journalModeResolve$room_runtime, executor2, executor3, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, null, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
                databaseConfiguration.setUseTempTrackingTable$room_runtime(this.inMemoryTrackingTableMode);
                Function0 function0 = this.factory;
                if (function0 == null || (roomDatabase = (RoomDatabase) function0.invoke()) == null) {
                    roomDatabase = (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(JvmClassMappingKt.getJavaClass(this.klass), null, 2, null);
                }
                roomDatabase.init(databaseConfiguration);
                return roomDatabase;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static class MigrationContainer {
        private final Map migrations = new LinkedHashMap();

        public final void addMigration(Migration migration) {
            Intrinsics.checkNotNullParameter(migration, "migration");
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            Map map = this.migrations;
            Integer numValueOf = Integer.valueOf(i);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Objects.toString(treeMap2.get(Integer.valueOf(i2)));
                migration.toString();
            }
            treeMap2.put(Integer.valueOf(i2), migration);
        }

        public Map getMigrations() {
            return this.migrations;
        }

        public List findMigrationPath(int i, int i2) {
            return MigrationUtil.findMigrationPath(this, i, i2);
        }

        public final boolean contains(int i, int i2) {
            return MigrationUtil.contains(this, i, i2);
        }

        public final Pair getSortedNodes$room_runtime(int i) {
            TreeMap treeMap = (TreeMap) this.migrations.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.to(treeMap, treeMap.keySet());
        }

        public final Pair getSortedDescendingNodes$room_runtime(int i) {
            TreeMap treeMap = (TreeMap) this.migrations.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return TuplesKt.to(treeMap, treeMap.descendingKeySet());
        }

        public void addMigrations(Migration... migrations) {
            Intrinsics.checkNotNullParameter(migrations, "migrations");
            for (Migration migration : migrations) {
                addMigration(migration);
            }
        }
    }

    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void onOpen(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void onCreate(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onCreate(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onDestructiveMigration(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onDestructiveMigration(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onOpen(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onOpen(((SupportSQLiteConnection) connection).getDb());
            }
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
