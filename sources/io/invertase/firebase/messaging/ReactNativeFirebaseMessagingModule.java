package io.invertase.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public class ReactNativeFirebaseMessagingModule extends ReactNativeFirebaseModule implements ActivityEventListener {
    private static final String TAG = "Messaging";
    ReadableMap initialNotification;
    private HashMap<String, Boolean> initialNotificationMap;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    ReactNativeFirebaseMessagingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        this.initialNotification = null;
        this.initialNotificationMap = new HashMap<>();
        reactApplicationContext.addActivityEventListener(this);
    }

    private WritableMap popRemoteMessageMapFromMessagingStore(String str) {
        ReactNativeFirebaseMessagingStore messagingStore = ReactNativeFirebaseMessagingStoreHelper.getInstance().getMessagingStore();
        WritableMap firebaseMessageMap = messagingStore.getFirebaseMessageMap(str);
        messagingStore.clearFirebaseMessage(str);
        return firebaseMessageMap;
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        Intent intent;
        WritableMap writableMapRemoteMessageToWritableMap;
        ReadableMap readableMap = this.initialNotification;
        if (readableMap != null) {
            promise.resolve(readableMap);
            this.initialNotification = null;
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && (intent = currentActivity.getIntent()) != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
            if (string == null) {
                string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
            }
            if (string != null && this.initialNotificationMap.get(string) == null) {
                RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
                if (remoteMessage == null) {
                    writableMapRemoteMessageToWritableMap = popRemoteMessageMapFromMessagingStore(string);
                } else {
                    writableMapRemoteMessageToWritableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
                }
                if (writableMapRemoteMessageToWritableMap != null) {
                    promise.resolve(writableMapRemoteMessageToWritableMap);
                    this.initialNotificationMap.put(string, Boolean.TRUE);
                    return;
                }
            }
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setAutoInitEnabled(final Boolean bool, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.m5112$r8$lambda$Su_JoBtVI1vPKsDpXs_UEU6ExU(bool);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5116$r8$lambda$wX48W60_ri_kacQMdOTdTjN58s(promise, task);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$Su_JoBtVI1vPKsDpXs-_UEU6ExU, reason: not valid java name */
    public static /* synthetic */ Object m5112$r8$lambda$Su_JoBtVI1vPKsDpXs_UEU6ExU(Boolean bool) {
        FirebaseMessaging.getInstance().setAutoInitEnabled(bool.booleanValue());
        return null;
    }

    /* JADX INFO: renamed from: $r8$lambda$wX48W60_ri_kacQMd-OTdTjN58s, reason: not valid java name */
    public static /* synthetic */ void m5116$r8$lambda$wX48W60_ri_kacQMdOTdTjN58s(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void isNotificationDelegationEnabled(final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.m5115$r8$lambda$rylxgnkpYCRMqOjRds5wVgtQDI();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5107$r8$lambda$1yqRbzJb6JmcjCBjlUPfHWAxug(promise, task);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$rylxgnkpYCRMqOjRds-5wVgtQDI, reason: not valid java name */
    public static /* synthetic */ Object m5115$r8$lambda$rylxgnkpYCRMqOjRds5wVgtQDI() {
        FirebaseMessaging.getInstance().isNotificationDelegationEnabled();
        return null;
    }

    /* JADX INFO: renamed from: $r8$lambda$1yqRbzJb6Jmcj-CBjlUPfHWAxug, reason: not valid java name */
    public static /* synthetic */ void m5107$r8$lambda$1yqRbzJb6JmcjCBjlUPfHWAxug(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setNotificationDelegationEnabled(final Boolean bool, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.$r8$lambda$jRC0F0Vpvx_FPj7aVG4mC9YxXuI(bool);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda12
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.$r8$lambda$2lGsORhuKwJN6ty15CM4f9q_Oco(promise, task);
            }
        });
    }

    public static /* synthetic */ Object $r8$lambda$jRC0F0Vpvx_FPj7aVG4mC9YxXuI(Boolean bool) {
        FirebaseMessaging.getInstance().setNotificationDelegationEnabled(bool.booleanValue());
        return null;
    }

    public static /* synthetic */ void $r8$lambda$2lGsORhuKwJN6ty15CM4f9q_Oco(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().isNotificationDelegationEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void getToken(String str, String str2, final Promise promise) {
        final FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class);
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.$r8$lambda$xznWx8Qe5brPIpmwNA9_YXk1wMM(firebaseMessaging);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5111$r8$lambda$R4_FWZw26TEnuoucfcuutdDjSY(promise, task);
            }
        });
    }

    public static /* synthetic */ String $r8$lambda$xznWx8Qe5brPIpmwNA9_YXk1wMM(FirebaseMessaging firebaseMessaging) {
        return (String) Tasks.await(firebaseMessaging.getToken());
    }

    /* JADX INFO: renamed from: $r8$lambda$R4_FWZw26TEnuoucfcuutdDjS-Y, reason: not valid java name */
    public static /* synthetic */ void m5111$r8$lambda$R4_FWZw26TEnuoucfcuutdDjSY(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void deleteToken(String str, String str2, final Promise promise) {
        final FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class);
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.m5110$r8$lambda$QTmdlFe7mgX1ikAN0G9sSKnKA0(firebaseMessaging);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda15
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5109$r8$lambda$Ooxc8aJwamK3CwQwnUau1uDxaM(promise, task);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$QTmdl-Fe7mgX1ikAN0G9sSKnKA0, reason: not valid java name */
    public static /* synthetic */ Object m5110$r8$lambda$QTmdlFe7mgX1ikAN0G9sSKnKA0(FirebaseMessaging firebaseMessaging) throws InterruptedException {
        Tasks.await(firebaseMessaging.deleteToken());
        return null;
    }

    /* JADX INFO: renamed from: $r8$lambda$Ooxc8aJwamK3CwQ-wnUau1uDxaM, reason: not valid java name */
    public static /* synthetic */ void m5109$r8$lambda$Ooxc8aJwamK3CwQwnUau1uDxaM(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void hasPermission(final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$hasPermission$10();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.$r8$lambda$WUCN3IucvAtR58eqgFIIPbfygsI(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$hasPermission$10() throws Exception {
        return Boolean.valueOf(NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled());
    }

    public static /* synthetic */ void $r8$lambda$WUCN3IucvAtR58eqgFIIPbfygsI(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Integer.valueOf(((Boolean) task.getResult()).booleanValue() ? 1 : 0));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void sendMessage(final ReadableMap readableMap, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.$r8$lambda$ZypUSXLD7aPOuzbV25G2rC4zgWk(readableMap);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5108$r8$lambda$9Rdi7SRhZSn9zQub4SMMdqEa9M(promise, task);
            }
        });
    }

    public static /* synthetic */ Object $r8$lambda$ZypUSXLD7aPOuzbV25G2rC4zgWk(ReadableMap readableMap) {
        FirebaseMessaging.getInstance().send(ReactNativeFirebaseMessagingSerializer.remoteMessageFromReadableMap(readableMap));
        return null;
    }

    /* JADX INFO: renamed from: $r8$lambda$9-Rdi7SRhZSn9zQub4SMMdqEa9M, reason: not valid java name */
    public static /* synthetic */ void m5108$r8$lambda$9Rdi7SRhZSn9zQub4SMMdqEa9M(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void subscribeToTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5114$r8$lambda$mI6ClKspyKwl2Y6iyRXXAOsvKI(promise, task);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$mI6ClKspyKwl2-Y6iyRXXAOsvKI, reason: not valid java name */
    public static /* synthetic */ void m5114$r8$lambda$mI6ClKspyKwl2Y6iyRXXAOsvKI(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void unsubscribeFromTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.m5113$r8$lambda$THTIcqLnuG8SoS6ZW5JYqWamtM(promise, task);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$THTIcqLnuG8S-oS6ZW5JYqWamtM, reason: not valid java name */
    public static /* synthetic */ void m5113$r8$lambda$THTIcqLnuG8SoS6ZW5JYqWamtM(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDeliveryMetricsExportToBigQuery(final Boolean bool, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseMessagingModule.$r8$lambda$UiL49tSaUPUGjDEcZuh_ZP7cTYc(bool);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseMessagingModule.$r8$lambda$CmkJ_RU5PFJMFhbpOGOepiqCq2o(promise, task);
            }
        });
    }

    public static /* synthetic */ Object $r8$lambda$UiL49tSaUPUGjDEcZuh_ZP7cTYc(Boolean bool) {
        FirebaseMessaging.getInstance().setDeliveryMetricsExportToBigQuery(bool.booleanValue());
        return null;
    }

    public static /* synthetic */ void $r8$lambda$CmkJ_RU5PFJMFhbpOGOepiqCq2o(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("isAutoInitEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        map.put("isDeliveryMetricsExportToBigQueryEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        map.put("isNotificationDelegationEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().isNotificationDelegationEnabled()));
        return map;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        WritableMap writableMapRemoteMessageToWritableMap;
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (string != null) {
            RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
            if (remoteMessage == null) {
                writableMapRemoteMessageToWritableMap = popRemoteMessageMapFromMessagingStore(string);
            } else {
                writableMapRemoteMessageToWritableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
            }
            if (writableMapRemoteMessageToWritableMap != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.merge(writableMapRemoteMessageToWritableMap);
                this.initialNotification = writableNativeMap;
                ReactNativeFirebaseMessagingReceiver.notifications.remove(string);
                ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.remoteMessageMapToEvent(writableMapRemoteMessageToWritableMap, Boolean.TRUE));
            }
        }
    }
}
