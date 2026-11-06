package androidx.room.util;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SQLiteConnectionUtil {
    public static final int getTotalChangedRows(SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("SELECT changes()");
        try {
            sQLiteStatementPrepare.step();
            int i = (int) sQLiteStatementPrepare.getLong(0);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }
}
