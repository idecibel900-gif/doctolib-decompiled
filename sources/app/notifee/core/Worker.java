package app.notifee.core;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public class Worker extends ListenableWorker {
    private CallbackToFutureAdapter.Completer mCompleter;

    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        CallbackToFutureAdapter.Completer completer = this.mCompleter;
        if (completer != null) {
            completer.set(ListenableWorker.Result.failure());
        }
        this.mCompleter = null;
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture startWork() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: app.notifee.core.Worker$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.lambda$startWork$0(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$startWork$0(CallbackToFutureAdapter.Completer completer) {
        this.mCompleter = completer;
        String string = getInputData().getString("workType");
        if (string == null) {
            Logger.d("Worker", "received task with no input key type.");
            completer.set(ListenableWorker.Result.success());
            return "Worker.startWork operation cancelled - no input.";
        }
        if (string.equals("app.notifee.core.BlockStateBroadcastReceiver.WORKER")) {
            Logger.d("Worker", "received task with type " + string);
            BlockStateBroadcastReceiver.doWork(getInputData(), completer);
            return "Worker.startWork operation created successfully.";
        }
        if (string.equals("app.notifee.core.NotificationManager.TRIGGER")) {
            NotificationManager.doScheduledWork(getInputData(), completer);
            return "Worker.startWork operation created successfully.";
        }
        Logger.d("Worker", "unknown work type received: " + string);
        completer.set(ListenableWorker.Result.success());
        return "Worker.startWork operation cancelled - unknown work type.";
    }
}
