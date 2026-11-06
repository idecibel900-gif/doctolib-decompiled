package expo.modules.webbrowser;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import expo.modules.core.interfaces.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class CustomTabsConnectionHelper extends CustomTabsServiceConnection {
    private final DeferredClientActionsQueue clientActions;
    private final Context context;
    private String currentPackageName;
    private final DeferredClientActionsQueue sessionActions;

    public CustomTabsConnectionHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.clientActions = new DeferredClientActionsQueue();
        this.sessionActions = new DeferredClientActionsQueue();
    }

    public final void destroy() {
        clearConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmUp$lambda$0(CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.warmup(0L);
    }

    public final void warmUp(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.clientActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda0
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.warmUp$lambda$0((CustomTabsClient) obj);
            }
        });
        ensureConnection(packageName);
    }

    public final void mayInitWithUrl(String packageName, final Uri uri) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.sessionActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda1
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.mayInitWithUrl$lambda$1(uri, (CustomTabsSession) obj);
            }
        });
        ensureConnection(packageName);
        ensureSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mayInitWithUrl$lambda$1(Uri uri, CustomTabsSession customTabsSession) {
        if (customTabsSession != null) {
            customTabsSession.mayLaunchUrl(uri, null, null);
        }
    }

    public final boolean coolDown(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!isConnectionStarted(packageName)) {
            return false;
        }
        clearConnection();
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            clearConnection();
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(client, "client");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            this.clientActions.setClient(client);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            clearConnection();
        }
    }

    private final void ensureSession() {
        if (this.sessionActions.hasClient()) {
            return;
        }
        this.clientActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda2
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.ensureSession$lambda$2(this.f$0, (CustomTabsClient) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureSession$lambda$2(CustomTabsConnectionHelper customTabsConnectionHelper, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        customTabsConnectionHelper.sessionActions.setClient(client.newSession(null));
    }

    private final void ensureConnection(String str) {
        String str2 = this.currentPackageName;
        if (str2 != null && !Intrinsics.areEqual(str2, str)) {
            clearConnection();
        }
        if (isConnectionStarted(str)) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(this.context, str, this);
        this.currentPackageName = str;
    }

    private final boolean isConnectionStarted(String str) {
        return Intrinsics.areEqual(str, this.currentPackageName);
    }

    private final void clearConnection() {
        if (this.currentPackageName != null) {
            this.context.unbindService(this);
        }
        this.currentPackageName = null;
        this.clientActions.clear();
        this.sessionActions.clear();
    }
}
