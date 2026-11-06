package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.driver.SupportSQLiteConnection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase);

    default void onPostMigrate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (connection instanceof SupportSQLiteConnection) {
            onPostMigrate(((SupportSQLiteConnection) connection).getDb());
        }
    }
}
