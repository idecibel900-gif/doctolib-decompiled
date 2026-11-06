package expo.modules.updates.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import expo.modules.updates.db.dao.AssetDao;
import expo.modules.updates.db.dao.JSONDataDao;
import expo.modules.updates.db.dao.UpdateDao;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lexpo/modules/updates/db/UpdatesDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "updateDao", "Lexpo/modules/updates/db/dao/UpdateDao;", "assetDao", "Lexpo/modules/updates/db/dao/AssetDao;", "jsonDataDao", "Lexpo/modules/updates/db/dao/JSONDataDao;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UpdatesDatabase extends RoomDatabase {
    private static volatile UpdatesDatabase INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Migration MIGRATION_4_5 = new UpdatesDatabase$Companion$MIGRATION_4_5$1();
    private static final Migration MIGRATION_5_6 = new UpdatesDatabase$Companion$MIGRATION_5_6$1();
    private static final Migration MIGRATION_6_7 = new UpdatesDatabase$Companion$MIGRATION_6_7$1();
    private static final Migration MIGRATION_7_8 = new UpdatesDatabase$Companion$MIGRATION_7_8$1();
    private static final Migration MIGRATION_8_9 = new UpdatesDatabase$Companion$MIGRATION_8_9$1();
    private static final Migration MIGRATION_9_10 = new UpdatesDatabase$Companion$MIGRATION_9_10$1();
    private static final Migration MIGRATION_10_11 = new UpdatesDatabase$Companion$MIGRATION_10_11$1();
    private static final Migration MIGRATION_11_12 = new UpdatesDatabase$Companion$MIGRATION_11_12$1();
    private static final Migration MIGRATION_12_13 = new UpdatesDatabase$Companion$MIGRATION_12_13$1();

    public abstract AssetDao assetDao();

    public abstract JSONDataDao jsonDataDao();

    public abstract UpdateDao updateDao();

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdatesDatabase getInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
            UpdatesDatabase updatesDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            UpdatesDatabase updatesDatabase2 = UpdatesDatabase.INSTANCE;
            if (updatesDatabase2 != null) {
                return updatesDatabase2;
            }
            synchronized (this) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    RoomDatabase.Builder builderDatabaseBuilder = Room.databaseBuilder(applicationContext, UpdatesDatabase.class, "updates.db");
                    if (coroutineDispatcher != null) {
                        builderDatabaseBuilder.setQueryExecutor(ExecutorsKt.asExecutor(coroutineDispatcher));
                    }
                    Companion companion = UpdatesDatabase.INSTANCE;
                    updatesDatabase = (UpdatesDatabase) builderDatabaseBuilder.addMigrations(companion.getMIGRATION_4_5(), companion.getMIGRATION_5_6(), companion.getMIGRATION_6_7(), companion.getMIGRATION_7_8(), companion.getMIGRATION_8_9(), companion.getMIGRATION_9_10(), companion.getMIGRATION_10_11(), companion.getMIGRATION_11_12(), companion.getMIGRATION_12_13()).allowMainThreadQueries().fallbackToDestructiveMigration().build();
                    UpdatesDatabase.INSTANCE = updatesDatabase;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return updatesDatabase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runInTransaction(SupportSQLiteDatabase supportSQLiteDatabase, Function1 function1) {
            supportSQLiteDatabase.beginTransaction();
            try {
                function1.invoke(supportSQLiteDatabase);
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runInTransactionWithForeignKeysOff(SupportSQLiteDatabase supportSQLiteDatabase, Function1 function1) {
            try {
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys=OFF");
                runInTransaction(supportSQLiteDatabase, function1);
            } finally {
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
            }
        }

        public final Migration getMIGRATION_4_5() {
            return UpdatesDatabase.MIGRATION_4_5;
        }

        public final Migration getMIGRATION_5_6() {
            return UpdatesDatabase.MIGRATION_5_6;
        }

        public final Migration getMIGRATION_6_7() {
            return UpdatesDatabase.MIGRATION_6_7;
        }

        public final Migration getMIGRATION_7_8() {
            return UpdatesDatabase.MIGRATION_7_8;
        }

        public final Migration getMIGRATION_8_9() {
            return UpdatesDatabase.MIGRATION_8_9;
        }

        public final Migration getMIGRATION_9_10() {
            return UpdatesDatabase.MIGRATION_9_10;
        }

        public final Migration getMIGRATION_10_11() {
            return UpdatesDatabase.MIGRATION_10_11;
        }

        public final Migration getMIGRATION_11_12() {
            return UpdatesDatabase.MIGRATION_11_12;
        }

        public final Migration getMIGRATION_12_13() {
            return UpdatesDatabase.MIGRATION_12_13;
        }
    }
}
