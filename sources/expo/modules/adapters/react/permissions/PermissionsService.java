package expo.modules.adapters.react.permissions;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class PermissionsService implements InternalModule, Permissions, LifecycleEventListener {
    private final Context context;
    private ActivityProvider mActivityProvider;
    private PermissionsResponseListener mAskAsyncListener;
    private String[] mAskAsyncRequestedPermissions;
    private SharedPreferences mAskedPermissionsCache;
    private PermissionsResponseListener mCurrentPermissionListener;
    private final Queue mPendingPermissionCalls;
    private boolean mWriteSettingsPermissionBeingAsked;

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    public PermissionsService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mPendingPermissionCalls = new LinkedList();
    }

    private final boolean didAsk(String str) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    private final void addToAskedPermissionsCache(String[] strArr) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : strArr) {
            editorEdit.putBoolean(str, true);
        }
        editorEdit.commit();
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List getExportedInterfaces() {
        return CollectionsKt.listOf(Permissions.class);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onCreate(ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (activityProvider == null) {
            throw new IllegalStateException("Couldn't find implementation for ActivityProvider.");
        }
        this.mActivityProvider = activityProvider;
        ((UIManager) moduleRegistry.getModule(UIManager.class)).registerLifecycleEventListener(this);
        this.mAskedPermissionsCache = this.context.getApplicationContext().getSharedPreferences("expo.modules.permissions.asked", 0);
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissionsWithPromise(final Promise promise, String... permissions) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        getPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda3
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.getPermissionsWithPromise$lambda$6(promise, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissionsWithPromise(final Promise promise, final String... permissions) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        askForPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda0
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.askForPermissionsWithPromise$lambda$7(this.f$0, promise, permissions, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissionsWithPromise$lambda$7(PermissionsService permissionsService, Promise promise, String[] strArr, Map map) {
        permissionsService.getPermissionsWithPromise(promise, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissions(final PermissionsResponseListener responseListener, String... permissions) {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (permissions.length == 0) {
            responseListener.onResult(new LinkedHashMap());
            return;
        }
        if (ArraysKt.contains(permissions, "android.permission.WRITE_SETTINGS")) {
            List mutableList = ArraysKt.toMutableList(permissions);
            mutableList.remove("android.permission.WRITE_SETTINGS");
            String[] strArr = (String[]) mutableList.toArray(new String[0]);
            PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda1
                @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
                public final void onResult(Map map) {
                    PermissionsService.askForPermissions$lambda$10(this.f$0, responseListener, map);
                }
            };
            if (!hasWriteSettingsPermission()) {
                if (this.mAskAsyncListener != null) {
                    throw new IllegalStateException("Another permissions request is in progress. Await the old request and then try again.");
                }
                this.mAskAsyncListener = permissionsResponseListener;
                this.mAskAsyncRequestedPermissions = strArr;
                addToAskedPermissionsCache(new String[]{"android.permission.WRITE_SETTINGS"});
                askForWriteSettingsPermissionFirst();
                return;
            }
            if (strArr.length == 0) {
                permissionsResponseListener.onResult(new LinkedHashMap());
                return;
            } else {
                askForManifestPermissions(strArr, permissionsResponseListener);
                return;
            }
        }
        askForManifestPermissions(permissions, responseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissions$lambda$10(PermissionsService permissionsService, PermissionsResponseListener permissionsResponseListener, Map map) {
        int i = permissionsService.hasWriteSettingsPermission() ? 0 : -1;
        Intrinsics.checkNotNull(map);
        map.put("android.permission.WRITE_SETTINGS", permissionsService.getPermissionResponseFromNativeResponse("android.permission.WRITE_SETTINGS", i));
        permissionsResponseListener.onResult(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPermissionsWithPromise$lambda$6(Promise promise, Map permissionsMap) {
        boolean z;
        boolean z2;
        String status;
        Intrinsics.checkNotNullParameter(permissionsMap, "permissionsMap");
        boolean z3 = false;
        if (!permissionsMap.isEmpty()) {
            Iterator it = permissionsMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((PermissionsResponse) ((Map.Entry) it.next()).getValue()).getStatus() != PermissionsStatus.GRANTED) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (permissionsMap.isEmpty()) {
            z2 = false;
        } else {
            if (!permissionsMap.isEmpty()) {
                Iterator it2 = permissionsMap.entrySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PermissionsResponse) ((Map.Entry) it2.next()).getValue()).getStatus() != PermissionsStatus.DENIED) {
                            z2 = false;
                        }
                    }
                }
            }
            z2 = true;
        }
        if (!permissionsMap.isEmpty()) {
            Iterator it3 = permissionsMap.entrySet().iterator();
            do {
                if (!it3.hasNext()) {
                    z3 = true;
                    break;
                }
            } while (((PermissionsResponse) ((Map.Entry) it3.next()).getValue()).getCanAskAgain());
        } else {
            z3 = true;
            break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("expires", "never");
        if (z) {
            status = PermissionsStatus.GRANTED.getStatus();
        } else if (z2) {
            status = PermissionsStatus.DENIED.getStatus();
        } else {
            status = PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", status);
        bundle.putBoolean("canAskAgain", z3);
        bundle.putBoolean("granted", z);
        promise.resolve(bundle);
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean isPermissionPresentInManifest(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                Intrinsics.checkNotNull(strArr);
                return ArraysKt.contains(strArr, permission);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private final boolean isPermissionGranted(String str) {
        if (Intrinsics.areEqual(str, "android.permission.WRITE_SETTINGS")) {
            return hasWriteSettingsPermission();
        }
        return getManifestPermission(str) == 0;
    }

    private final int getManifestPermission(String str) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null && (currentActivity instanceof PermissionAwareActivity)) {
            return ContextCompat.checkSelfPermission(currentActivity, str);
        }
        return getManifestPermissionFromContext(str);
    }

    protected int getManifestPermissionFromContext(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(this.context, permission);
    }

    private final boolean canAskAgain(String str) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        return (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null || !ActivityCompat.shouldShowRequestPermissionRationale(currentActivity, str)) ? false : true;
    }

    private final Map parseNativeResult(String[] strArr, int[] iArr) {
        HashMap map = new HashMap();
        for (Pair pair : ArraysKt.zip(iArr, strArr)) {
            int iIntValue = ((Number) pair.getFirst()).intValue();
            String str = (String) pair.getSecond();
            map.put(str, getPermissionResponseFromNativeResponse(str, iIntValue));
        }
        return map;
    }

    private final PermissionsResponse getPermissionResponseFromNativeResponse(String str, int i) {
        PermissionsStatus permissionsStatus;
        if (i == 0) {
            permissionsStatus = PermissionsStatus.GRANTED;
        } else {
            permissionsStatus = didAsk(str) ? PermissionsStatus.DENIED : PermissionsStatus.UNDETERMINED;
        }
        return new PermissionsResponse(permissionsStatus, permissionsStatus == PermissionsStatus.DENIED ? canAskAgain(str) : true);
    }

    protected void askForManifestPermissions(String[] permissions, PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        delegateRequestToActivity((String[]) Arrays.copyOf(permissions, permissions.length), listener);
    }

    protected final void delegateRequestToActivity(String[] permissions, PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        addToAskedPermissionsCache(permissions);
        ActivityProvider activityProvider = this.mActivityProvider;
        ComponentCallbacks2 currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity instanceof PermissionAwareActivity) {
            synchronized (this) {
                try {
                    if (this.mCurrentPermissionListener != null) {
                        this.mPendingPermissionCalls.add(TuplesKt.to(permissions, listener));
                    } else {
                        this.mCurrentPermissionListener = listener;
                        ((PermissionAwareActivity) currentActivity).requestPermissions(permissions, 13, createListenerWithPendingPermissionsRequest());
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        int length = permissions.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = -1;
        }
        listener.onResult(parseNativeResult(permissions, iArr));
    }

    private final PermissionListener createListenerWithPendingPermissionsRequest() {
        return new PermissionListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda2
            @Override // com.facebook.react.modules.core.PermissionListener
            public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                return PermissionsService.createListenerWithPendingPermissionsRequest$lambda$21(this.f$0, i, strArr, iArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createListenerWithPendingPermissionsRequest$lambda$21(PermissionsService permissionsService, int i, String[] receivePermissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(receivePermissions, "receivePermissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i != 13) {
            return false;
        }
        synchronized (permissionsService) {
            try {
                PermissionsResponseListener permissionsResponseListener = permissionsService.mCurrentPermissionListener;
                if (permissionsResponseListener == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                permissionsResponseListener.onResult(permissionsService.parseNativeResult(receivePermissions, grantResults));
                permissionsService.mCurrentPermissionListener = null;
                Pair pair = (Pair) permissionsService.mPendingPermissionCalls.poll();
                if (pair != null) {
                    ActivityProvider activityProvider = permissionsService.mActivityProvider;
                    Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
                    PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
                    if (permissionAwareActivity == null) {
                        PermissionsResponseListener permissionsResponseListener2 = (PermissionsResponseListener) pair.getSecond();
                        String[] strArr = (String[]) pair.getFirst();
                        int length = ((Object[]) pair.getFirst()).length;
                        int[] iArr = new int[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = -1;
                        }
                        permissionsResponseListener2.onResult(permissionsService.parseNativeResult(strArr, iArr));
                        for (Pair pair2 : permissionsService.mPendingPermissionCalls) {
                            PermissionsResponseListener permissionsResponseListener3 = (PermissionsResponseListener) pair2.getSecond();
                            String[] strArr2 = (String[]) pair2.getFirst();
                            int length2 = ((Object[]) pair2.getFirst()).length;
                            int[] iArr2 = new int[length2];
                            for (int i3 = 0; i3 < length2; i3++) {
                                iArr2[i3] = -1;
                            }
                            permissionsResponseListener3.onResult(permissionsService.parseNativeResult(strArr2, iArr2));
                        }
                        permissionsService.mPendingPermissionCalls.clear();
                    } else {
                        permissionsService.mCurrentPermissionListener = (PermissionsResponseListener) pair.getSecond();
                        permissionAwareActivity.requestPermissions((String[]) pair.getFirst(), 13, permissionsService.createListenerWithPendingPermissionsRequest());
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void askForWriteSettingsPermissionFirst() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        intent.addFlags(268435456);
        this.mWriteSettingsPermissionBeingAsked = true;
        this.context.startActivity(intent);
    }

    private final boolean hasWriteSettingsPermission() {
        return Settings.System.canWrite(this.context.getApplicationContext());
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        if (this.mWriteSettingsPermissionBeingAsked) {
            this.mWriteSettingsPermissionBeingAsked = false;
            PermissionsResponseListener permissionsResponseListener = this.mAskAsyncListener;
            Intrinsics.checkNotNull(permissionsResponseListener);
            String[] strArr = this.mAskAsyncRequestedPermissions;
            Intrinsics.checkNotNull(strArr);
            this.mAskAsyncListener = null;
            this.mAskAsyncRequestedPermissions = null;
            if (!(strArr.length == 0)) {
                askForManifestPermissions(strArr, permissionsResponseListener);
            } else {
                permissionsResponseListener.onResult(new LinkedHashMap());
            }
        }
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissions(PermissionsResponseListener responseListener, String... permissions) {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList(permissions.length);
        for (String str : permissions) {
            arrayList.add(Integer.valueOf(isPermissionGranted(str) ? 0 : -1));
        }
        responseListener.onResult(parseNativeResult(permissions, CollectionsKt.toIntArray(arrayList)));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean hasGrantedPermissions(String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        for (String str : permissions) {
            if (!isPermissionGranted(str)) {
                return false;
            }
        }
        return true;
    }
}
