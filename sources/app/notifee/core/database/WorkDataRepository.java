package app.notifee.core.database;

import android.content.Context;
import android.os.Bundle;
import app.notifee.core.model.NotificationModel;
import app.notifee.core.utility.ObjectUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class WorkDataRepository {
    private static WorkDataRepository mInstance;
    private final ListeningExecutorService mExecutor = NotifeeCoreDatabase.databaseWriteListeningExecutor;
    private final WorkDataDao mWorkDataDao;

    public static WorkDataRepository getInstance(Context context) {
        WorkDataRepository workDataRepository;
        synchronized (WorkDataRepository.class) {
            try {
                if (mInstance == null) {
                    mInstance = new WorkDataRepository(context);
                }
                workDataRepository = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workDataRepository;
    }

    public WorkDataRepository(Context context) {
        this.mWorkDataDao = NotifeeCoreDatabase.getDatabase(context).workDao();
    }

    private ListenableFuture submitWrite(Runnable runnable) {
        return this.mExecutor.submit(runnable, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$insert$0(WorkDataEntity workDataEntity) {
        this.mWorkDataDao.insert(workDataEntity);
    }

    public ListenableFuture insert(final WorkDataEntity workDataEntity) {
        return submitWrite(new Runnable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$insert$0(workDataEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WorkDataEntity lambda$getWorkDataById$1(String str) {
        return this.mWorkDataDao.getWorkDataById(str);
    }

    public ListenableFuture getWorkDataById(final String str) {
        return this.mExecutor.submit(new Callable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getWorkDataById$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getAllWithAlarmManager$2(Boolean bool) {
        return this.mWorkDataDao.getAllWithAlarmManager(bool);
    }

    public ListenableFuture getAllWithAlarmManager(final Boolean bool) {
        return this.mExecutor.submit(new Callable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getAllWithAlarmManager$2(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getAll$3() {
        return this.mWorkDataDao.getAll();
    }

    public ListenableFuture getAll() {
        return this.mExecutor.submit(new Callable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getAll$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteById$4(String str) {
        this.mWorkDataDao.deleteById(str);
    }

    public ListenableFuture deleteById(final String str) {
        return submitWrite(new Runnable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteById$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteByIds$5(List list) {
        this.mWorkDataDao.deleteByIds(list);
    }

    public ListenableFuture deleteByIds(final List list) {
        return submitWrite(new Runnable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteByIds$5(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAll$6() {
        this.mWorkDataDao.deleteAll();
    }

    public ListenableFuture deleteAll() {
        return submitWrite(new Runnable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteAll$6();
            }
        });
    }

    public static ListenableFuture insertTriggerNotification(Context context, NotificationModel notificationModel, Bundle bundle, Boolean bool) {
        return getInstance(context).insert(new WorkDataEntity(notificationModel.getId(), ObjectUtils.bundleToBytes(notificationModel.toBundle()), ObjectUtils.bundleToBytes(bundle), bool));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$7(WorkDataEntity workDataEntity) {
        this.mWorkDataDao.update(workDataEntity);
    }

    public ListenableFuture update(final WorkDataEntity workDataEntity) {
        return submitWrite(new Runnable() { // from class: app.notifee.core.database.WorkDataRepository$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$update$7(workDataEntity);
            }
        });
    }
}
