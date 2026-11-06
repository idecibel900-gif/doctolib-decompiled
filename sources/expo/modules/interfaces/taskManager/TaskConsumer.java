package expo.modules.interfaces.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TaskConsumer {
    public static int VERSION;
    private WeakReference<Context> mContextRef;
    private TaskManagerUtilsInterface mTaskManagerUtils;

    public boolean canReceiveCustomBroadcast(String str) {
        return false;
    }

    public boolean didCancelJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    protected TaskManagerUtilsInterface getTaskManagerUtils() {
        return null;
    }

    public void setOptions(Map map) {
    }

    public TaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        this.mContextRef = new WeakReference<>(context);
    }

    protected Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
