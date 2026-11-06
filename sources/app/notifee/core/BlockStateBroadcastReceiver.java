package app.notifee.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import app.notifee.core.event.BlockStateEvent;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.utility.ObjectUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class BlockStateBroadcastReceiver extends BroadcastReceiver {
    @Keep
    public BlockStateBroadcastReceiver() {
    }

    static void doWork(Data data, final CallbackToFutureAdapter.Completer completer) {
        Logger.v("BlockState", "starting background work");
        final boolean z = data.getBoolean("blocked", false);
        final int i = data.getInt("type", 4);
        final ObjectUtils.TypedCallback typedCallback = new ObjectUtils.TypedCallback() { // from class: app.notifee.core.BlockStateBroadcastReceiver$$ExternalSyntheticLambda0
            @Override // app.notifee.core.utility.ObjectUtils.TypedCallback
            public final void call(Object obj) {
                Bundle bundle = (Bundle) obj;
                EventBus.post(new BlockStateEvent(i, bundle, z, new MethodCallResult() { // from class: app.notifee.core.BlockStateBroadcastReceiver$$ExternalSyntheticLambda2
                    @Override // app.notifee.core.interfaces.MethodCallResult
                    public final void onComplete(Exception exc, Object obj2) {
                        BlockStateBroadcastReceiver.m2970$r8$lambda$9ASmhh578Y1VnKahJzqotSkAu0(completer, exc, (Void) obj2);
                    }
                }));
            }
        };
        if (i == 4) {
            typedCallback.call(null);
            return;
        }
        MethodCallResult<Bundle> methodCallResult = new MethodCallResult() { // from class: app.notifee.core.BlockStateBroadcastReceiver$$ExternalSyntheticLambda1
            @Override // app.notifee.core.interfaces.MethodCallResult
            public final void onComplete(Exception exc, Object obj) {
                BlockStateBroadcastReceiver.$r8$lambda$WFpyJIytpnS1ZBv3uZn6beUMQIg(completer, typedCallback, exc, (Bundle) obj);
            }
        };
        String string = data.getString("channelOrGroupId");
        if (i == 5) {
            Notifee.getInstance().getChannel(string, methodCallResult);
        } else if (i == 6) {
            Notifee.getInstance().getChannelGroup(string, methodCallResult);
        } else {
            Logger.e("BlockState", "unknown block state work type");
            completer.set(ListenableWorker.Result.success());
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9ASmhh578Y1VnKahJz-qotSkAu0, reason: not valid java name */
    public static /* synthetic */ void m2970$r8$lambda$9ASmhh578Y1VnKahJzqotSkAu0(CallbackToFutureAdapter.Completer completer, Exception exc, Void r3) {
        if (exc != null) {
            Logger.e("BlockState", "background work failed with error: ", exc);
            completer.set(ListenableWorker.Result.failure());
        } else {
            Logger.v("BlockState", "background work completed successfully");
            completer.set(ListenableWorker.Result.success());
        }
    }

    public static /* synthetic */ void $r8$lambda$WFpyJIytpnS1ZBv3uZn6beUMQIg(CallbackToFutureAdapter.Completer completer, ObjectUtils.TypedCallback typedCallback, Exception exc, Bundle bundle) {
        if (exc != null) {
            Logger.e("BlockState", "Failed getting channel or channel group bundle, received error: ", exc);
            completer.set(ListenableWorker.Result.success());
        } else {
            typedCallback.call(bundle);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (Build.VERSION.SDK_INT >= 28 && (action = intent.getAction()) != null) {
            if (ContextHolder.getApplicationContext() == null) {
                ContextHolder.setApplicationContext(context.getApplicationContext());
            }
            Data.Builder builder = new Data.Builder();
            builder.putString("workType", "app.notifee.core.BlockStateBroadcastReceiver.WORKER");
            switch (action) {
                case "android.app.action.APP_BLOCK_STATE_CHANGED":
                    builder.putInt("type", 4);
                    break;
                case "android.app.action.NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED":
                    builder.putInt("type", 6);
                    String stringExtra = intent.getStringExtra("android.app.extra.NOTIFICATION_CHANNEL_GROUP_ID");
                    builder.putString("channelOrGroupId", stringExtra);
                    action = action + "." + stringExtra;
                    break;
                case "android.app.action.NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED":
                    builder.putInt("type", 5);
                    String stringExtra2 = intent.getStringExtra("android.app.extra.NOTIFICATION_CHANNEL_ID");
                    builder.putString("channelOrGroupId", stringExtra2);
                    action = action + "." + stringExtra2;
                    break;
                default:
                    Logger.d("BlockState", "unknown intent action received, ignoring.");
                    return;
            }
            builder.putBoolean("blocked", intent.getBooleanExtra("android.app.extra.BLOCKED_STATE", false));
            try {
                WorkManager.getInstance(ContextHolder.getApplicationContext()).enqueueUniqueWork(action, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(Worker.class).setInitialDelay(1L, TimeUnit.SECONDS)).setInputData(builder.build())).build());
            } catch (IllegalStateException e) {
                Logger.e("BlockState", "Error while calling WorkManager.getInstance", (Exception) e);
                if (ContextHolder.getApplicationContext() == null) {
                    Logger.e("BlockState", "Application Context is null");
                }
            }
            Logger.v("BlockState", "scheduled new background work with id " + action);
        }
    }
}
