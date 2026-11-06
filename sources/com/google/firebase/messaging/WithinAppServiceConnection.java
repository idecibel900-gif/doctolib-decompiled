package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class WithinAppServiceConnection implements ServiceConnection {
    private WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();

        BindRequest(Intent intent) {
            this.intent = intent;
        }

        void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WithinAppServiceConnection.BindRequest.m3555$r8$lambda$hKs5bTLffofgXyuUxvS59KUCk(this.f$0);
                }
            }, 20L, TimeUnit.SECONDS);
            getTask().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        /* JADX INFO: renamed from: $r8$lambda$hKs5bTLff-ofgXyu-UxvS59KUCk, reason: not valid java name */
        public static /* synthetic */ void m3555$r8$lambda$hKs5bTLffofgXyuUxvS59KUCk(BindRequest bindRequest) {
            bindRequest.intent.getAction();
            bindRequest.finish();
        }

        Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }
    }

    WithinAppServiceConnection(Context context, String str) {
        this(context, str, createScheduledThreadPoolExecutor());
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static ScheduledThreadPoolExecutor createScheduledThreadPoolExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService;
    }

    synchronized Task<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    private synchronized void flushQueue() {
        while (!this.intentQueue.isEmpty()) {
            try {
                WithinAppServiceBinder withinAppServiceBinder = this.binder;
                if (withinAppServiceBinder != null && withinAppServiceBinder.isBinderAlive()) {
                    this.binder.send(this.intentQueue.poll());
                } else {
                    startConnectionIfNeeded();
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startConnectionIfNeeded() {
        if (this.connectionInProgress) {
            return;
        }
        this.connectionInProgress = true;
        try {
            if (ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
                return;
            }
        } catch (SecurityException unused) {
        }
        this.connectionInProgress = false;
        finishAllInQueue();
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Objects.toString(componentName);
            }
            this.connectionInProgress = false;
            if (!(iBinder instanceof WithinAppServiceBinder)) {
                Objects.toString(iBinder);
                finishAllInQueue();
            } else {
                this.binder = (WithinAppServiceBinder) iBinder;
                flushQueue();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Objects.toString(componentName);
        }
        flushQueue();
    }
}
