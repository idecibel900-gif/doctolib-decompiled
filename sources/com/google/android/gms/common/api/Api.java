package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class Api {
    private final AbstractClientBuilder zaa;
    private final ClientKey zab;
    private final String zac;

    public static abstract class AbstractClientBuilder extends BaseClientBuilder {
        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, obj, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface AnyClient {
    }

    public static class AnyClientKey {
    }

    public interface ApiOptions {
        public static final NoOptions NO_OPTIONS = new NoOptions(null);

        public static final class NoOptions implements ApiOptions {
            /* synthetic */ NoOptions(zaa zaaVar) {
            }
        }
    }

    public static abstract class BaseClientBuilder {
    }

    public interface Client extends AnyClient {
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void disconnect(String str);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set set);

        Set getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class ClientKey extends AnyClientKey {
    }

    public Api(String str, AbstractClientBuilder abstractClientBuilder, ClientKey clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }

    public final AbstractClientBuilder zaa() {
        return this.zaa;
    }

    public final AnyClientKey zab() {
        return this.zab;
    }

    public final String zad() {
        return this.zac;
    }
}
