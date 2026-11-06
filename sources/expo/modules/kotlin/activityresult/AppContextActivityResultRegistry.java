package expo.modules.kotlin.activityresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AppContextActivityResultRegistry {
    private final CurrentActivityProvider currentActivityProvider;
    private final Map keyToCallbacksAndContract;
    private final Map keyToInputParam;
    private final Map keyToLifecycleContainers;
    private final Map keyToRequestCode;
    private ArrayList launchedKeys;
    private final Bundle pendingResults;
    private Random random;
    private final Map requestCodeToKey;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppContextActivityResultRegistry(CurrentActivityProvider currentActivityProvider) {
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.currentActivityProvider = currentActivityProvider;
        this.random = new Random();
        this.requestCodeToKey = new HashMap();
        this.keyToRequestCode = new HashMap();
        this.keyToLifecycleContainers = new HashMap();
        this.launchedKeys = new ArrayList();
        this.keyToCallbacksAndContract = new HashMap();
        this.keyToInputParam = new HashMap();
        this.pendingResults = new Bundle();
    }

    private final AppCompatActivity getActivity() {
        Activity currentActivity = this.currentActivityProvider.getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        throw new IllegalArgumentException("Current Activity is not available at the moment");
    }

    public final void onLaunch(int i, AppContextActivityResultContract contract, Serializable input) {
        Bundle bundleExtra;
        int i2;
        Parcelable parcelableExtra;
        final int i3;
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intentCreateIntent = contract.createIntent(getActivity(), input);
        if (intentCreateIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentCreateIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentCreateIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        String action = intentCreateIntent.getAction();
        if (action == null) {
            i2 = i;
        } else {
            int iHashCode = action.hashCode();
            if (iHashCode != -1837081951) {
                if (iHashCode == -591152331 && action.equals("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST")) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelableExtra = (Parcelable) intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", IntentSenderRequest.class);
                    } else {
                        parcelableExtra = intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    }
                    Intrinsics.checkNotNull(parcelableExtra);
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) parcelableExtra;
                    try {
                        i3 = i;
                        try {
                            ActivityCompat.startIntentSenderForResult(getActivity(), intentSenderRequest.getIntentSender(), i3, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (IntentSender.SendIntentException e) {
                            e = e;
                            final IntentSender.SendIntentException sendIntentException = e;
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AppContextActivityResultRegistry.onLaunch$lambda$1(this.f$0, i3, sendIntentException);
                                }
                            });
                            return;
                        }
                    } catch (IntentSender.SendIntentException e2) {
                        e = e2;
                        i3 = i;
                    }
                }
                i2 = i;
            } else {
                i2 = i;
                if (action.equals("androidx.activity.result.contract.action.REQUEST_PERMISSIONS")) {
                    String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.requestPermissions(getActivity(), stringArrayExtra, i2);
                    return;
                }
            }
        }
        ActivityCompat.startActivityForResult(getActivity(), intentCreateIntent, i2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(AppContextActivityResultRegistry appContextActivityResultRegistry, int i, IntentSender.SendIntentException sendIntentException) {
        appContextActivityResultRegistry.dispatchResult(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
    }

    public final AppContextActivityResultLauncher register(final String key, LifecycleOwner lifecycleOwner, AppContextActivityResultContract contract, AppContextActivityResultFallbackCallback fallbackCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.keyToCallbacksAndContract.put(key, new CallbacksAndContract(fallbackCallback, null, contract));
        if (this.keyToRequestCode.get(key) == null) {
            int iGenerateRandomNumber = generateRandomNumber();
            this.requestCodeToKey.put(Integer.valueOf(iGenerateRandomNumber), key);
            this.keyToRequestCode.put(key, Integer.valueOf(iGenerateRandomNumber));
            Unit unit = Unit.INSTANCE;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                AppContextActivityResultRegistry.register$lambda$4(this.f$0, key, lifecycleOwner2, event);
            }
        };
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(lifecycleEventObserver);
        this.keyToLifecycleContainers.put(key, lifecycleContainer);
        return new AppContextActivityResultLauncher(this, key, fallbackCallback) { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register.2
            final /* synthetic */ AppContextActivityResultFallbackCallback $fallbackCallback;
            final /* synthetic */ String $key;
            private final AppContextActivityResultContract contract;
            final /* synthetic */ AppContextActivityResultRegistry this$0;

            {
                this.this$0 = this;
                this.$key = key;
                this.$fallbackCallback = fallbackCallback;
                this.contract = this.$contract;
            }

            @Override // expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
            public void launch(Serializable input, ActivityResultCallback callback) throws Exception {
                Intrinsics.checkNotNullParameter(input, "input");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Integer num = (Integer) this.this$0.keyToRequestCode.get(this.$key);
                if (num != null) {
                    int iIntValue = num.intValue();
                    this.this$0.keyToCallbacksAndContract.put(this.$key, new CallbacksAndContract(this.$fallbackCallback, callback, this.$contract));
                    this.this$0.keyToInputParam.put(this.$key, input);
                    this.this$0.launchedKeys.add(this.$key);
                    try {
                        this.this$0.onLaunch(iIntValue, this.$contract, input);
                        return;
                    } catch (Exception e) {
                        this.this$0.launchedKeys.remove(this.$key);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.$contract + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch()");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$4(AppContextActivityResultRegistry appContextActivityResultRegistry, String str, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            appContextActivityResultRegistry.unregister(str);
            return;
        }
        CallbacksAndContract callbacksAndContract = (CallbacksAndContract) appContextActivityResultRegistry.keyToCallbacksAndContract.get(str);
        if (callbacksAndContract == null) {
            return;
        }
        Bundle bundle = appContextActivityResultRegistry.pendingResults;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, ActivityResult.class);
        } else {
            parcelable = bundle.getParcelable(str);
        }
        ActivityResult activityResult = (ActivityResult) parcelable;
        if (activityResult != null) {
            appContextActivityResultRegistry.pendingResults.remove(str);
            Object obj = appContextActivityResultRegistry.keyToInputParam.get(str);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register");
            Serializable serializable = (Serializable) obj;
            Object result = callbacksAndContract.getContract().parseResult(serializable, activityResult.getResultCode(), activityResult.getData());
            if (callbacksAndContract.getMainCallback() != null) {
                callbacksAndContract.getMainCallback().onActivityResult(result);
            } else {
                callbacksAndContract.getFallbackCallback().onActivityResult(serializable, result);
            }
        }
    }

    public final void persistInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistorAddStringToIntMap = new DataPersistor(context).addStringArrayList("launchedKeys", this.launchedKeys).addStringToIntMap("keyToRequestCode", this.keyToRequestCode);
        Map map = this.keyToInputParam;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (this.launchedKeys.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        dataPersistorAddStringToIntMap.addStringToSerializableMap("keyToParamsForFallbackCallback", linkedHashMap).addBundle("pendingResult", this.pendingResults).addSerializable("random", this.random).persist();
    }

    public final void restoreInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistor = new DataPersistor(context);
        ArrayList arrayListRetrieveStringArrayList = dataPersistor.retrieveStringArrayList("launchedKeys");
        if (arrayListRetrieveStringArrayList != null) {
            this.launchedKeys = arrayListRetrieveStringArrayList;
        }
        Map mapRetrieveStringToSerializableMap = dataPersistor.retrieveStringToSerializableMap("keyToParamsForFallbackCallback");
        if (mapRetrieveStringToSerializableMap != null) {
            this.keyToInputParam.putAll(mapRetrieveStringToSerializableMap);
        }
        Bundle bundleRetrieveBundle = dataPersistor.retrieveBundle("pendingResult");
        if (bundleRetrieveBundle != null) {
            this.pendingResults.putAll(bundleRetrieveBundle);
        }
        Serializable serializableRetrieveSerializable = dataPersistor.retrieveSerializable("random");
        if (serializableRetrieveSerializable != null) {
            this.random = (Random) serializableRetrieveSerializable;
        }
        Map mapRetrieveStringToIntMap = dataPersistor.retrieveStringToIntMap("keyToRequestCode");
        if (mapRetrieveStringToIntMap != null) {
            for (Map.Entry entry : mapRetrieveStringToIntMap.entrySet()) {
                String str = (String) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                this.keyToRequestCode.put(str, Integer.valueOf(iIntValue));
                this.requestCodeToKey.put(Integer.valueOf(iIntValue), str);
            }
        }
    }

    public final void unregister(String key) {
        Parcelable parcelable;
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.launchedKeys.contains(key) && (num = (Integer) this.keyToRequestCode.remove(key)) != null) {
        }
        this.keyToCallbacksAndContract.remove(key);
        if (this.pendingResults.containsKey(key)) {
            Bundle bundle = this.pendingResults;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable(key, ActivityResult.class);
            } else {
                parcelable = bundle.getParcelable(key);
            }
            Objects.toString(parcelable);
            this.pendingResults.remove(key);
        }
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = (String) this.requestCodeToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        doDispatch(str, i2, intent, (CallbacksAndContract) this.keyToCallbacksAndContract.get(str));
        return true;
    }

    private final void doDispatch(String str, int i, Intent intent, CallbacksAndContract callbacksAndContract) {
        Lifecycle lifecycle;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(str);
        Lifecycle.State currentState = (lifecycleContainer == null || (lifecycle = lifecycleContainer.getLifecycle()) == null) ? null : lifecycle.getCurrentState();
        if ((callbacksAndContract != null ? callbacksAndContract.getMainCallback() : null) != null && this.launchedKeys.contains(str)) {
            Object obj = this.keyToInputParam.get(str);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            callbacksAndContract.getMainCallback().onActivityResult(callbacksAndContract.getContract().parseResult((Serializable) obj, i, intent));
            this.launchedKeys.remove(str);
            return;
        }
        if (currentState != null && currentState.isAtLeast(Lifecycle.State.STARTED) && callbacksAndContract != null && this.launchedKeys.contains(str)) {
            Object obj2 = this.keyToInputParam.get(str);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            Serializable serializable = (Serializable) obj2;
            callbacksAndContract.getFallbackCallback().onActivityResult(serializable, callbacksAndContract.getContract().parseResult(serializable, i, intent));
            this.launchedKeys.remove(str);
            return;
        }
        this.pendingResults.putParcelable(str, new ActivityResult(i, intent));
    }

    private final int generateRandomNumber() {
        int iNextInt = this.random.nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!this.requestCodeToKey.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iNextInt = this.random.nextInt(2147418112);
        }
    }

    private static final class CallbacksAndContract {
        private final AppContextActivityResultContract contract;
        private final AppContextActivityResultFallbackCallback fallbackCallback;
        private final ActivityResultCallback mainCallback;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CallbacksAndContract)) {
                return false;
            }
            CallbacksAndContract callbacksAndContract = (CallbacksAndContract) obj;
            return Intrinsics.areEqual(this.fallbackCallback, callbacksAndContract.fallbackCallback) && Intrinsics.areEqual(this.mainCallback, callbacksAndContract.mainCallback) && Intrinsics.areEqual(this.contract, callbacksAndContract.contract);
        }

        public int hashCode() {
            int iHashCode = this.fallbackCallback.hashCode() * 31;
            ActivityResultCallback activityResultCallback = this.mainCallback;
            return ((iHashCode + (activityResultCallback == null ? 0 : activityResultCallback.hashCode())) * 31) + this.contract.hashCode();
        }

        public String toString() {
            return "CallbacksAndContract(fallbackCallback=" + this.fallbackCallback + ", mainCallback=" + this.mainCallback + ", contract=" + this.contract + ")";
        }

        public CallbacksAndContract(AppContextActivityResultFallbackCallback fallbackCallback, ActivityResultCallback activityResultCallback, AppContextActivityResultContract contract) {
            Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.fallbackCallback = fallbackCallback;
            this.mainCallback = activityResultCallback;
            this.contract = contract;
        }

        public final AppContextActivityResultFallbackCallback getFallbackCallback() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback getMainCallback() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract getContract() {
            return this.contract;
        }
    }

    public static final class LifecycleContainer {
        private final Lifecycle lifecycle;
        private final ArrayList observers;

        public LifecycleContainer(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new ArrayList();
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final void addObserver(LifecycleEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.lifecycle.addObserver(observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.removeObserver((LifecycleEventObserver) it.next());
            }
            this.observers.clear();
        }
    }
}
