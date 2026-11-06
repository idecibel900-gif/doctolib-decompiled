package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseGmsClient {
    private volatile String zzA;
    zzs zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private zze zzu;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zze = new Feature[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    private volatile String zzk = null;
    private final Object zzp = new Object();
    private final Object zzq = new Object();
    private final ArrayList zzt = new ArrayList();
    private int zzv = 1;
    private ConnectionResult zzC = null;
    private boolean zzD = false;
    private volatile zzj zzE = null;
    protected AtomicInteger zzd = new AtomicInteger(0);

    public interface BaseConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        final /* synthetic */ BaseGmsClient zza;

        public LegacyClientCallbackAdapter(BaseGmsClient baseGmsClient) {
            java.util.Objects.requireNonNull(baseGmsClient);
            this.zza = baseGmsClient;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = this.zza;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else {
                BaseGmsClient baseGmsClient2 = this.zza;
                if (baseGmsClient2.zzl() != null) {
                    baseGmsClient2.zzl().onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    private final void zzp(int i, IInterface iInterface) {
        zzs zzsVar;
        Preconditions.checkArgument((i == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.zzn;
                        String strZza = this.zza.zza();
                        Preconditions.checkNotNull(strZza);
                        gmsClientSupervisor.zzb(strZza, this.zza.zzb(), 4225, zzeVar, zza(), this.zza.zzc());
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzsVar = this.zza) != null) {
                        new StringBuilder(String.valueOf(zzsVar.zza()).length() + 70 + String.valueOf(zzsVar.zzb()).length());
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String strZza2 = this.zza.zza();
                        Preconditions.checkNotNull(strZza2);
                        gmsClientSupervisor2.zzb(strZza2, this.zza.zzb(), 4225, zzeVar2, zza(), this.zza.zzc());
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    zzs zzsVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzs(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new zzs(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = zzsVar2;
                    if (zzsVar2.zzc() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zza())));
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String strZza3 = this.zza.zza();
                    Preconditions.checkNotNull(strZza3);
                    ConnectionResult connectionResultZza = gmsClientSupervisor3.zza(new zzn(strZza3, this.zza.zzb(), 4225, this.zza.zzc()), zzeVar3, zza(), getBindServiceExecutor());
                    if (!connectionResultZza.isSuccess()) {
                        new StringBuilder(String.valueOf(this.zza.zza()).length() + 34 + String.valueOf(this.zza.zzb()).length());
                        int errorCode = connectionResultZza.getErrorCode() == -1 ? 16 : connectionResultZza.getErrorCode();
                        if (connectionResultZza.getResolution() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", connectionResultZza.getResolution());
                        }
                        zzb(errorCode, bundle, this.zzd.get());
                    }
                } else if (i == 4) {
                    Preconditions.checkNotNull(iInterface);
                    onConnectedLocked(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    protected abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        ArrayList arrayList = this.zzt;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((zzc) arrayList.get(i)).zzf();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    protected boolean enableLocalFallback() {
        return false;
    }

    public abstract Account getAccount();

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzj zzjVar = this.zzE;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzb;
    }

    protected abstract Executor getBindServiceExecutor();

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        zzs zzsVar;
        if (!isConnected() || (zzsVar = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzsVar.zzb();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public abstract int getMinApkVersion();

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = Build.VERSION.SDK_INT < 31 ? this.zzA : this.zzA;
        int i = this.zzy;
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i, i2, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzj = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzj = getAccount();
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzo = true;
        }
        try {
            try {
                synchronized (this.zzq) {
                    try {
                        IGmsServiceBroker iGmsServiceBroker = this.zzr;
                        if (iGmsServiceBroker != null) {
                            iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                onPostInitHandler(8, null, null, this.zzd.get());
            }
        } catch (DeadObjectException unused2) {
            triggerConnectionSuspended(3);
        } catch (SecurityException e) {
            throw e;
        }
    }

    protected abstract Set getScopes();

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                IInterface iInterface2 = this.zzs;
                Preconditions.checkNotNull(iInterface2, "Client is connected but service is null");
                iInterface = iInterface2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    protected abstract String getServiceDescriptor();

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzj zzjVar = this.zzE;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzd;
    }

    protected boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    protected void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    protected void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    protected void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzf zzfVar = new zzf(this, i, iBinder, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, zzfVar));
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i) {
        int i2 = this.zzd.get();
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, i2, i));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    protected final void zzb(int i, Bundle bundle, int i2) {
        zzg zzgVar = new zzg(this, i, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, zzgVar));
    }

    final /* synthetic */ void zzc(zzj zzjVar) {
        this.zzE = zzjVar;
        if (usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.zzd;
            RootTelemetryConfigManager.getInstance().zza(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    final /* synthetic */ void zzd(int i, IInterface iInterface) {
        zzp(i, null);
    }

    final /* synthetic */ boolean zze(int i, int i2, IInterface iInterface) {
        synchronized (this.zzp) {
            try {
                if (this.zzv != i) {
                    return false;
                }
                zzp(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void zzf(int i) {
        int i2;
        int i3;
        synchronized (this.zzp) {
            i2 = this.zzv;
        }
        if (i2 == 3) {
            this.zzD = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(i3, this.zzd.get(), 16));
    }

    final /* synthetic */ boolean zzg() {
        if (this.zzD || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    final /* synthetic */ Object zzh() {
        return this.zzq;
    }

    final /* synthetic */ void zzi(IGmsServiceBroker iGmsServiceBroker) {
        this.zzr = iGmsServiceBroker;
    }

    final /* synthetic */ ArrayList zzj() {
        return this.zzt;
    }

    final /* synthetic */ BaseConnectionCallbacks zzk() {
        return this.zzw;
    }

    final /* synthetic */ BaseOnConnectionFailedListener zzl() {
        return this.zzx;
    }

    final /* synthetic */ ConnectionResult zzm() {
        return this.zzC;
    }

    final /* synthetic */ void zzn(ConnectionResult connectionResult) {
        this.zzC = connectionResult;
    }

    final /* synthetic */ boolean zzo() {
        return this.zzD;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }
}
