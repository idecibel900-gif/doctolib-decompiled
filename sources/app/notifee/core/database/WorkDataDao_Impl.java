package app.notifee.core.database;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class WorkDataDao_Impl implements WorkDataDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter __insertAdapterOfWorkDataEntity = new EntityInsertAdapter() { // from class: app.notifee.core.database.WorkDataDao_Impl.1
        @Override // androidx.room.EntityInsertAdapter
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `work_data` (`id`,`notification`,`trigger`,`with_alarm_manager`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertAdapter
        public void bind(SQLiteStatement sQLiteStatement, WorkDataEntity workDataEntity) {
            if (workDataEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, workDataEntity.getId());
            }
            if (workDataEntity.getNotification() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindBlob(2, workDataEntity.getNotification());
            }
            if (workDataEntity.getTrigger() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindBlob(3, workDataEntity.getTrigger());
            }
            Integer numValueOf = workDataEntity.getWithAlarmManager() == null ? null : Integer.valueOf(workDataEntity.getWithAlarmManager().booleanValue() ? 1 : 0);
            if (numValueOf == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindLong(4, numValueOf.intValue());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter __updateAdapterOfWorkDataEntity = new EntityDeleteOrUpdateAdapter() { // from class: app.notifee.core.database.WorkDataDao_Impl.2
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        protected String createQuery() {
            return "UPDATE OR REPLACE `work_data` SET `id` = ?,`notification` = ?,`trigger` = ?,`with_alarm_manager` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        public void bind(SQLiteStatement sQLiteStatement, WorkDataEntity workDataEntity) {
            if (workDataEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, workDataEntity.getId());
            }
            if (workDataEntity.getNotification() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindBlob(2, workDataEntity.getNotification());
            }
            if (workDataEntity.getTrigger() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindBlob(3, workDataEntity.getTrigger());
            }
            Integer numValueOf = workDataEntity.getWithAlarmManager() == null ? null : Integer.valueOf(workDataEntity.getWithAlarmManager().booleanValue() ? 1 : 0);
            if (numValueOf == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindLong(4, numValueOf.intValue());
            }
            if (workDataEntity.getId() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindText(5, workDataEntity.getId());
            }
        }
    };

    public WorkDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    @Override // app.notifee.core.database.WorkDataDao
    public void insert(final WorkDataEntity workDataEntity) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insert$0(workDataEntity, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insert$0(WorkDataEntity workDataEntity, SQLiteConnection sQLiteConnection) throws Exception {
        this.__insertAdapterOfWorkDataEntity.insert(sQLiteConnection, workDataEntity);
        return null;
    }

    @Override // app.notifee.core.database.WorkDataDao
    public void update(final WorkDataEntity workDataEntity) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$update$1(workDataEntity, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$update$1(WorkDataEntity workDataEntity, SQLiteConnection sQLiteConnection) throws Exception {
        this.__updateAdapterOfWorkDataEntity.handle(sQLiteConnection, workDataEntity);
        return null;
    }

    @Override // app.notifee.core.database.WorkDataDao
    public WorkDataEntity getWorkDataById(final String str) {
        return (WorkDataEntity) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.$r8$lambda$CQlLahQajaLIUWBabTyhkfDOimU(str, (SQLiteConnection) obj);
            }
        });
    }

    public static /* synthetic */ WorkDataEntity $r8$lambda$CQlLahQajaLIUWBabTyhkfDOimU(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * from work_data WHERE id = ?");
        boolean z = true;
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, DiagnosticsEntry.ID_KEY);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "with_alarm_manager");
            WorkDataEntity workDataEntity = null;
            Boolean boolValueOf = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                byte[] blob = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow2);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                if (numValueOf != null) {
                    if (numValueOf.intValue() == 0) {
                        z = false;
                    }
                    boolValueOf = Boolean.valueOf(z);
                }
                workDataEntity = new WorkDataEntity(text, blob, blob2, boolValueOf);
            }
            sQLiteStatementPrepare.close();
            return workDataEntity;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // app.notifee.core.database.WorkDataDao
    public List getAllWithAlarmManager(final Boolean bool) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.$r8$lambda$ansDMoBUIlQq9jZD4uaSZ69KO_Q(bool, (SQLiteConnection) obj);
            }
        });
    }

    public static /* synthetic */ List $r8$lambda$ansDMoBUIlQq9jZD4uaSZ69KO_Q(Boolean bool, SQLiteConnection sQLiteConnection) {
        Integer numValueOf;
        Boolean boolValueOf;
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM work_data WHERE with_alarm_manager = ?");
        if (bool == null) {
            numValueOf = null;
        } else {
            try {
                numValueOf = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            } finally {
                sQLiteStatementPrepare.close();
            }
        }
        if (numValueOf == null) {
            sQLiteStatementPrepare.bindNull(1);
        } else {
            sQLiteStatementPrepare.bindLong(1, numValueOf.intValue());
        }
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, DiagnosticsEntry.ID_KEY);
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification");
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "with_alarm_manager");
        ArrayList arrayList = new ArrayList();
        while (sQLiteStatementPrepare.step()) {
            String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
            byte[] blob = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow2);
            byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
            Integer numValueOf2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
            if (numValueOf2 == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(numValueOf2.intValue() != 0);
            }
            arrayList.add(new WorkDataEntity(text, blob, blob2, boolValueOf));
        }
        return arrayList;
    }

    @Override // app.notifee.core.database.WorkDataDao
    public List getAll() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.$r8$lambda$1MTGQ8tRdRhIcKD6x5T0e3a5vKU((SQLiteConnection) obj);
            }
        });
    }

    public static /* synthetic */ List $r8$lambda$1MTGQ8tRdRhIcKD6x5T0e3a5vKU(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM work_data");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, DiagnosticsEntry.ID_KEY);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "notification");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trigger");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "with_alarm_manager");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                Boolean boolValueOf = null;
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                byte[] blob = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow2);
                byte[] blob2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getBlob(columnIndexOrThrow3);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                arrayList.add(new WorkDataEntity(text, blob, blob2, boolValueOf));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // app.notifee.core.database.WorkDataDao
    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.$r8$lambda$fwTCgjXnap8YZvbrw3ZgfKqrpss((SQLiteConnection) obj);
            }
        });
    }

    public static /* synthetic */ Object $r8$lambda$fwTCgjXnap8YZvbrw3ZgfKqrpss(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM work_data");
        try {
            sQLiteStatementPrepare.step();
            return null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // app.notifee.core.database.WorkDataDao
    public void deleteById(final String str) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.m2989$r8$lambda$doSdxHEdOwIBLj7CkgYkGKT3hU(str, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$doSdxH-EdOwIBLj7CkgYkGKT3hU, reason: not valid java name */
    public static /* synthetic */ Object m2989$r8$lambda$doSdxHEdOwIBLj7CkgYkGKT3hU(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM work_data WHERE id = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // app.notifee.core.database.WorkDataDao
    public void deleteByIds(final List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM work_data WHERE id in (");
        StringUtil.appendPlaceholders(sb, list == null ? 1 : list.size());
        sb.append(")");
        final String string = sb.toString();
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: app.notifee.core.database.WorkDataDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WorkDataDao_Impl.m2988$r8$lambda$HbHwUj0lomJ9CnIPkfiyGvEmo(string, list, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$HbHwUj0lom-J9CnIPkfi-yGvEmo, reason: not valid java name */
    public static /* synthetic */ Object m2988$r8$lambda$HbHwUj0lomJ9CnIPkfiyGvEmo(String str, List list, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        int i = 1;
        try {
            if (list == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (str2 == null) {
                        sQLiteStatementPrepare.bindNull(i);
                    } else {
                        sQLiteStatementPrepare.bindText(i, str2);
                    }
                    i++;
                }
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    public static List getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
