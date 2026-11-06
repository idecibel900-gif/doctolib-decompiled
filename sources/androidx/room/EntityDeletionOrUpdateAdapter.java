package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter extends SharedSQLiteStatement {
    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public final int handle(Object obj) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, obj);
            return supportSQLiteStatementAcquire.executeUpdateDelete();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final int handleMultiple(Iterable entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator it = entities.iterator();
            int iExecuteUpdateDelete = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                iExecuteUpdateDelete += supportSQLiteStatementAcquire.executeUpdateDelete();
            }
            release(supportSQLiteStatementAcquire);
            return iExecuteUpdateDelete;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }
}
