package app.notifee.core.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NotifeeCoreDatabase extends RoomDatabase {
    private static volatile NotifeeCoreDatabase INSTANCE;
    static final Migration MIGRATION_1_2;
    static final ExecutorService databaseWriteExecutor;
    static final ListeningExecutorService databaseWriteListeningExecutor;

    public abstract WorkDataDao workDao();

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        databaseWriteExecutor = executorServiceNewCachedThreadPool;
        databaseWriteListeningExecutor = MoreExecutors.listeningDecorator(executorServiceNewCachedThreadPool);
        MIGRATION_1_2 = new Migration(1, 2) { // from class: app.notifee.core.database.NotifeeCoreDatabase.1
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("ALTER TABLE work_data ADD COLUMN with_alarm_manager INTEGER NOT NULL DEFAULT 0");
            }
        };
    }

    static NotifeeCoreDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (NotifeeCoreDatabase.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = (NotifeeCoreDatabase) Room.databaseBuilder(context.getApplicationContext(), NotifeeCoreDatabase.class, "notifee_core_database").addMigrations(MIGRATION_1_2).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return INSTANCE;
    }
}
