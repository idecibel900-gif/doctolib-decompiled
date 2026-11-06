package androidx.room;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntityInsertAdapter {
    protected abstract void bind(SQLiteStatement sQLiteStatement, Object obj);

    protected abstract String createQuery();

    public final void insert(SQLiteConnection connection, Object obj) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (obj == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, obj);
            sQLiteStatementPrepare.step();
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
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
