package expo.modules.application;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import expo.modules.kotlin.Promise;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationModule$definition$1$8$1 implements InstallReferrerStateListener {
    final /* synthetic */ StringBuilder $installReferrer;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    ApplicationModule$definition$1$8$1(InstallReferrerClient installReferrerClient, StringBuilder sb, Promise promise) {
        this.$referrerClient = installReferrerClient;
        this.$installReferrer = sb;
        this.$promise = promise;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            try {
                this.$installReferrer.append(this.$referrerClient.getInstallReferrer().getInstallReferrer());
                Promise promise = this.$promise;
                String string = this.$installReferrer.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                promise.resolve(string);
            } catch (RemoteException e) {
                this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_REMOTE_EXCEPTION", "RemoteException getting install referrer information. This may happen if the process hosting the remote object is no longer available.", e);
                return;
            }
        } else if (i == 1) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER", "General error retrieving the install referrer: response code " + i, null);
        } else if (i == 2) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_UNAVAILABLE", "The current Play Store app doesn't provide the installation referrer API, or the Play Store may not be installed.", null);
        } else {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER", "General error retrieving the install referrer: response code " + i, null);
        }
        this.$referrerClient.endConnection();
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_SERVICE_DISCONNECTED", "Connection to install referrer service was lost.", null);
    }
}
