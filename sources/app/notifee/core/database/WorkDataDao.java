package app.notifee.core.database;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkDataDao {
    void deleteAll();

    void deleteById(String str);

    void deleteByIds(List list);

    List getAll();

    List getAllWithAlarmManager(Boolean bool);

    WorkDataEntity getWorkDataById(String str);

    void insert(WorkDataEntity workDataEntity);

    void update(WorkDataEntity workDataEntity);
}
