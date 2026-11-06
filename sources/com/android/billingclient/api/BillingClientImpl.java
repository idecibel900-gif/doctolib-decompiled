package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.amazon.a.a.o.b;
import com.google.android.gms.internal.play_billing.zzap;
import com.google.android.gms.internal.play_billing.zzbd;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcb;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjr;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzjy;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzu;
import com.revenuecat.purchases.api.BuildConfig;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import io.sentry.SentryOptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private PendingPurchasesParams zzE;
    private boolean zzF;
    private boolean zzG;
    private volatile BillingClientStateListener zzH;
    private ExecutorService zzI;
    private final Long zzJ;
    private zzbo zzK;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzab zzf;
    private Context zzg;
    private zzcz zzh;
    private volatile zzap zzi;
    private volatile zzbw zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzcz zzczVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzjpVarZza.zzy(str2);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(this.zzJ.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        if (zzczVar != null) {
            this.zzh = zzczVar;
        } else {
            this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzab(this.zzg, purchasesUpdatedListener, null, zzbVar, null, null, this.zzh);
        this.zzE = pendingPurchasesParams;
        this.zzG = zzbVar != null;
        this.zzg.getPackageName();
        this.zzF = builder.zza;
    }

    static Future zzK(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaz
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zzc.zzo("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            zzc.zzp("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzL(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzM(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
    }

    public static /* synthetic */ void zzN(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzR(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzT(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
    }

    public static /* synthetic */ void zzV(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zzf() != null) {
            billingClientImpl.zzf.zzf().onPurchasesUpdated(billingResult, null);
        } else {
            zzc.zzo("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    private final /* synthetic */ Object zzaA(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        zzap zzapVar;
        try {
            if (!zzbl(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.zzj;
                zzbs(zzjdVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                zzc.zzo("BillingClient", "Please provide a valid purchase token.");
                zzjd zzjdVar2 = zzjd.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzdc.zzg;
                zzbs(zzjdVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar != null) {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzJ.longValue();
                    int i = zzc.zza;
                    Bundle bundle = new Bundle();
                    zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzapVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzdc.zza(zzc.zzb(bundleZzd, "BillingClient"), zzc.zzk(bundleZzd, "BillingClient")));
                    return null;
                }
                zzaP(acknowledgePurchaseResponseListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzjd zzjdVar3 = zzjd.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzdc.zza;
                zzbs(zzjdVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaP(acknowledgePurchaseResponseListener, zzdc.zzj, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaP(acknowledgePurchaseResponseListener, zzdc.zzh, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzaB(BillingConfigResponseListener billingConfigResponseListener) {
        zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
                zzc.zzo("BillingClient", "Service disconnected.");
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.zzj;
                zzbs(zzjdVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaY(billingConfigResponseListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzJ.longValue();
                    int i = zzc.zza;
                    Bundle bundle = new Bundle();
                    zzc.zzc(bundle, str, str2, jLongValue);
                    zzapVar.zzo(18, packageName, bundle, new zzca(billingConfigResponseListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                zzc.zzo("BillingClient", "Current client doesn't support get billing config.");
                zzjd zzjdVar2 = zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzdc.zzy;
                zzbs(zzjdVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzaY(billingConfigResponseListener, zzdc.zzj, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaY(billingConfigResponseListener, zzdc.zzh, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzaC(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            if (zzapVar == null) {
                zzbb(-1, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzs(12, this.zzg.getPackageName(), bundle, new zzcf(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbb(-1, zzjd.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbb(6, zzjd.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzaD(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaE() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00b1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzaO(com.android.billingclient.api.ConsumeParams r10, com.android.billingclient.api.ConsumeResponseListener r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzaO(com.android.billingclient.api.ConsumeParams, com.android.billingclient.api.ConsumeResponseListener):void");
    }

    private final void zzaP(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzc.zzp("BillingClient", "Error in acknowledge purchase!", exc);
        zzbu(zzjdVar, 3, billingResult, zzcy.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    private final void zzaS(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzjd zzjdVar, String str2, Exception exc) {
        zzc.zzp("BillingClient", str2, exc);
        zzbu(zzjdVar, 4, billingResult, zzcy.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    private final void zzaY(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzc.zzp("BillingClient", "getBillingConfig got an exception.", exc);
        zzbu(zzjdVar, 13, billingResult, zzcy.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    static /* bridge */ /* synthetic */ void zzak(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzD = i >= 27;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    static /* bridge */ /* synthetic */ void zzam(BillingClientImpl billingClientImpl, int i) {
        if (i != 0) {
            billingClientImpl.zzbg(0);
            return;
        }
        synchronized (billingClientImpl.zza) {
            try {
                if (billingClientImpl.zzb == 3) {
                    return;
                }
                billingClientImpl.zzbg(2);
                zzab zzabVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
                if (zzabVar != null) {
                    zzabVar.zzi(billingClientImpl.zzy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzat(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) {
        zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            return zzapVar == null ? zzc.zzd(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return zzc.zze(zzdc.zzj, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e));
        } catch (Exception e2) {
            return zzc.zze(zzdc.zzh, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzau(String str, String str2) {
        zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            return zzapVar == null ? zzc.zzd(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return zzc.zze(zzdc.zzj, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e));
        } catch (Exception e2) {
            return zzc.zze(zzdc.zzh, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzav() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzcg zzaw(BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        zzc.zzp("BillingClient", str, exc);
        zzbu(zzjdVar, 7, billingResult, zzcy.zza(exc));
        return new zzcg(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzax(int i) {
        zzc.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
        zziy zziyVarZza = zzja.zza();
        zziyVarZza.zze(6);
        zzks zzksVarZza = zzku.zza();
        zzksVarZza.zze(true);
        zzksVarZza.zza(i > 0);
        zzksVarZza.zzb(i);
        zziyVarZza.zzd(zzksVarZza);
        zzbe((zzja) zziyVarZza.zzi());
        return zzdc.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzay() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzdc.zzj;
                }
            }
            return zzdc.zzh;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzdc zzaz(final int i) {
        if (this.zzF && !zzbm()) {
            return zzu.zza(new zzr() { // from class: com.android.billingclient.api.zzad
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(zzp zzpVar) {
                    return BillingClientImpl.zzr(this.zza, i, zzpVar);
                }
            });
        }
        zzc.zzn("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzcx.zza(zzdc.zzi);
    }

    private final void zzbb(int i, zzjd zzjdVar, Exception exc) {
        zziw zziwVar;
        zzc.zzp("BillingClient", "showInAppMessages error.", exc);
        zzcz zzczVar = this.zzh;
        String strZza = zzcy.zza(exc);
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(i);
            if (zzjdVar != null) {
                zzjbVarZza.zze(zzjdVar);
            }
            if (strZza != null) {
                zzjbVarZza.zza(strZza);
            }
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(30);
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Throwable th) {
            zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            zziwVar = null;
        }
        zzczVar.zza(zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(zziw zziwVar) {
        try {
            this.zzh.zzb(zziwVar, this.zzm);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbd(zziw zziwVar, long j, boolean z) {
        try {
            this.zzh.zze(zziwVar, this.zzm, j, z);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbe(zzja zzjaVar) {
        try {
            this.zzh.zzg(zzjaVar, this.zzm);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(zzjd zzjdVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzcy.$r8$clinit;
            zziu zziuVar = (zziu) zzcy.zzb(zzjdVar, 6, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED).zzq();
            zzks zzksVarZza = zzku.zza();
            zzksVarZza.zza(i > 0);
            zzksVarZza.zzb(i);
            zziuVar.zze(zzksVarZza);
            zzbc((zziw) zziuVar.zzi());
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbg(int i) {
        synchronized (this.zza) {
            try {
                if (this.zzb == 3) {
                    return;
                }
                zzc.zzn("BillingClient", "Setting clientState from " + zzbn(this.zzb) + " to " + zzbn(i));
                this.zzb = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final synchronized void zzbh() {
        ExecutorService executorService = this.zzI;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzI = null;
        }
    }

    private final void zzbi(BillingClientStateListener billingClientStateListener, int i) {
        zzjd zzjdVar;
        BillingResult billingResultZzax;
        BillingResult billingResult;
        synchronized (this.zza) {
            try {
                if (zzbm()) {
                    billingResultZzax = zzax(i);
                } else {
                    if (this.zzb == 1) {
                        zzc.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
                        zzjd zzjdVar2 = zzjd.BILLING_CLIENT_CONNECTING;
                        billingResult = zzdc.zzd;
                        zzbf(zzjdVar2, billingResult, i);
                    } else if (this.zzb == 3) {
                        zzc.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        zzjd zzjdVar3 = zzjd.BILLING_CLIENT_CLOSED;
                        billingResult = zzdc.zzj;
                        zzbf(zzjdVar3, billingResult, i);
                    } else {
                        zzbg(1);
                        if (i == 0) {
                            this.zzH = billingClientStateListener;
                            i = 0;
                        }
                        zzbj();
                        zzc.zzn("BillingClient", "Starting in-app billing setup.");
                        this.zzj = new zzbw(this, billingClientStateListener, i, null);
                        this.zzj.zzc();
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzjdVar = zzjd.INTENT_SERVICE_NOT_FOUND;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                                    zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                    synchronized (this.zza) {
                                        try {
                                            if (this.zzb == 2) {
                                                billingResultZzax = zzax(i);
                                            } else if (this.zzb != 1) {
                                                zzc.zzo("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                zzjd zzjdVar4 = zzjd.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                                billingResult = zzdc.zzj;
                                                zzbf(zzjdVar4, billingResult, i);
                                            } else {
                                                zzbw zzbwVar = this.zzj;
                                                if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.zzg.bindService(intent2, zzbwVar, 1) : this.zzg.bindService(intent2, 1, zzJ(), zzbwVar)) {
                                                    zzc.zzn("BillingClient", "Service was bonded successfully.");
                                                    billingResultZzax = null;
                                                } else {
                                                    zzjdVar = zzjd.BILLING_SERVICE_BLOCKED;
                                                    zzc.zzo("BillingClient", "Connection to Billing service is blocked.");
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                                zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        }
                        zzbg(0);
                        zzc.zzn("BillingClient", "Billing service unavailable on device.");
                        BillingResult billingResult2 = zzdc.zzb;
                        zzbf(zzjdVar, billingResult2, i);
                        billingResultZzax = billingResult2;
                    }
                    billingResultZzax = billingResult;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (billingResultZzax != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzax);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbj() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                try {
                    this.zzg.unbindService(this.zzj);
                    this.zzi = null;
                    this.zzj = null;
                } catch (Throwable th) {
                    try {
                        zzc.zzp("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzi = null;
                        this.zzj = null;
                    } catch (Throwable th2) {
                        this.zzi = null;
                        this.zzj = null;
                        throw th2;
                    }
                }
            }
        }
    }

    private final boolean zzbk(long j) {
        try {
            BillingResult billingResult = (BillingResult) zzaz(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
            } else {
                zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzc.zzp("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzbm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzbl(long j) {
        com.google.android.gms.internal.play_billing.zzbl zzblVarZzb = com.google.android.gms.internal.play_billing.zzbl.zzb(this.zzK);
        long jZza = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                long jMax = Math.max(0L, jZza);
                if (jMax <= 0) {
                    zzc.zzo("BillingClient", "No time remaining for reconnection attempt.");
                    return zzbm();
                }
                BillingResult billingResult = (BillingResult) zzaz(i).get(jMax, TimeUnit.MILLISECONDS);
                if (billingResult.getResponseCode() == 0) {
                    zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                    return zzbm();
                }
                zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jZza = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS - zzblVarZzb.zza(timeUnit);
                long jPow = ((long) Math.pow(2.0d, i - 1)) * 1000;
                if (jZza < jPow) {
                    zzc.zzo("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return zzbm();
                }
                if (i < 3 && jPow > 0) {
                    try {
                        Thread.sleep(jPow);
                        jZza = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS - zzblVarZzb.zza(timeUnit);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        zzc.zzp("BillingClient", "Error sleeping during reconnection attempt: ", e);
                    }
                }
            } catch (Exception e2) {
                if (e2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                zzc.zzp("BillingClient", "Error during reconnection attempt: ", e2);
            }
        }
        zzc.zzo("BillingClient", "Max retries reached.");
        return zzbm();
    }

    private final boolean zzbm() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private static final String zzbn(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i != 1) {
            return i != 2 ? "CLOSED" : "CONNECTED";
        }
        return "CONNECTING";
    }

    private static final void zzbo(zzjp zzjpVar, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                zzjpVar.zzv((int) (memoryInfo.totalMem / SentryOptions.MAX_EVENT_SIZE_BYTES));
                zzjpVar.zzr(Build.BRAND);
                zzjpVar.zzu(Build.MODEL);
                zzjpVar.zzt(Build.MANUFACTURER);
                zzjpVar.zzs(Build.FINGERPRINT);
            }
        } catch (RuntimeException e) {
            zzc.zzp("BillingClient", "Runtime error while populating device info.", e);
        }
    }

    private final zzdz zzbp(int i, BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        zzbu(zzjdVar, 9, billingResult, zzcy.zza(exc));
        zzc.zzp("BillingClient", str, exc);
        return new zzdz(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x01df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x018c  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:85:0x01fa  */
    public final zzdz zzbq(String str, boolean z, int i) {
        zzap zzapVar;
        int i2;
        int i3;
        Bundle bundleZzi;
        BillingResult billingResultBuild;
        zzjd zzjdVar;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        int i4;
        boolean z2;
        Purchase purchase;
        BillingClientImpl billingClientImpl = this;
        zzc.zzn("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = billingClientImpl.zzp;
        boolean z4 = billingClientImpl.zzw;
        boolean zIsEnabledForOneTimeProducts = billingClientImpl.zzE.isEnabledForOneTimeProducts();
        boolean zIsEnabledForPrepaidPlans = billingClientImpl.zzE.isEnabledForPrepaidPlans();
        long jLongValue = billingClientImpl.zzJ.longValue();
        Bundle bundle = new Bundle();
        zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, jLongValue);
        if (z3 && zIsEnabledForOneTimeProducts) {
            bundle.putBoolean(b.ac, true);
        }
        if (z4 && zIsEnabledForPrepaidPlans) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z) {
            bundle.putBoolean("includeSuspendedSubscriptions", true);
        }
        String string = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzapVar = billingClientImpl.zzi;
                }
                if (zzapVar == null) {
                    return billingClientImpl.zzbp(9, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (z && !billingClientImpl.zzC) {
                    return billingClientImpl.zzbp(9, zzdc.zzw, zzjd.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, "Include suspended subscriptions is not supported", null);
                }
                if (billingClientImpl.zzp) {
                    if (billingClientImpl.zzC) {
                        i3 = 26;
                    } else if (billingClientImpl.zzB) {
                        i3 = 24;
                    } else {
                        if (billingClientImpl.zzw) {
                            i3 = 19;
                        } else {
                            i2 = 9;
                        }
                        bundleZzi = zzapVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                    }
                    i2 = i3;
                    bundleZzi = zzapVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzapVar.zzh(3, billingClientImpl.zzg.getPackageName(), str, string);
                }
                BillingResult billingResult = zzdc.zzh;
                if (bundleZzi == null) {
                    zzc.zzo("BillingClient", String.format("%s got null owned items list", "getPurchase()"));
                    zzjdVar = zzjd.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = zzc.zzb(bundleZzi, "BillingClient");
                    String strZzk = zzc.zzk(bundleZzi, "BillingClient");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(iZzb);
                    builderNewBuilder.setDebugMessage(strZzk);
                    billingResultBuild = builderNewBuilder.build();
                    if (iZzb != 0) {
                        zzc.zzo("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iZzb)));
                        zzjdVar = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList4 == null) {
                            zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_SKUS_LIST;
                        } else if (stringArrayList5 == null) {
                            zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_PURCHASES_LIST;
                        } else if (stringArrayList6 == null) {
                            zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_SIGNATURES_LIST;
                        } else {
                            billingResultBuild = zzdc.zzi;
                            zzjdVar = zzjd.REASON_UNSPECIFIED;
                        }
                    } else {
                        zzc.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                        zzjdVar = zzjd.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (billingResultBuild != zzdc.zzi) {
                        return billingClientImpl.zzbp(9, billingResultBuild, zzjdVar, "Purchase bundle invalid", null);
                    }
                    stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    z2 = false;
                    for (i4 = 0; i4 < stringArrayList2.size(); i4++) {
                        String str2 = stringArrayList2.get(i4);
                        String str3 = stringArrayList3.get(i4);
                        zzc.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                        try {
                            purchase = new Purchase(str2, str3);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                zzc.zzo("BillingClient", "BUG: empty/null token!");
                                z2 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return zzbp(9, zzdc.zzh, zzjd.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    billingClientImpl = this;
                    if (z2) {
                        billingClientImpl.zzbs(zzjd.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    zzc.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                }
                billingResultBuild = billingResult;
                if (billingResultBuild != zzdc.zzi) {
                    return billingClientImpl.zzbp(9, billingResultBuild, zzjdVar, "Purchase bundle invalid", null);
                }
                stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z2 = false;
                while (i4 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i4);
                    String str5 = stringArrayList3.get(i4);
                    zzc.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                    purchase = new Purchase(str4, str5);
                    if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                        zzc.zzo("BillingClient", "BUG: empty/null token!");
                        z2 = true;
                    }
                    arrayList.add(purchase);
                }
                billingClientImpl = this;
                if (z2) {
                    billingClientImpl.zzbs(zzjd.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                zzc.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e2) {
                return zzbp(9, zzdc.zzj, zzjd.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return billingClientImpl.zzbp(9, zzdc.zzh, zzjd.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzdz(zzdc.zzi, arrayList);
    }

    private final void zzbr(BillingResult billingResult, zzjd zzjdVar, int i) {
        zzja zzjaVar = null;
        zziw zziwVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i2 = zzcy.$r8$clinit;
            try {
                zziy zziyVarZza = zzja.zza();
                zziyVarZza.zze(5);
                zzjv zzjvVarZza = zzjy.zza();
                zzjvVarZza.zza(i);
                zziyVarZza.zzb((zzjy) zzjvVarZza.zzi());
                zzjaVar = (zzja) zziyVarZza.zzi();
            } catch (Exception e) {
                zzc.zzp("BillingLogger", "Unable to create logging payload", e);
            }
            zzbe(zzjaVar);
            return;
        }
        int i3 = zzcy.$r8$clinit;
        try {
            zziu zziuVarZza = zziw.zza();
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.getResponseCode());
            zzjbVarZza.zzb(billingResult.getDebugMessage());
            zzjbVarZza.zze(zzjdVar);
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(5);
            zzjv zzjvVarZza2 = zzjy.zza();
            zzjvVarZza2.zza(i);
            zziuVarZza.zzc((zzjy) zzjvVarZza2.zzi());
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Exception e2) {
            zzc.zzp("BillingLogger", "Unable to create logging payload", e2);
        }
        zzbc(zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbs(zzjd zzjdVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzcy.$r8$clinit;
            zzbc(zzcy.zzb(zzjdVar, i, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbt(zzjd zzjdVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcy.$r8$clinit;
            try {
                this.zzh.zzc(zzcy.zzb(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
            } catch (Throwable th) {
                zzc.zzp("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzp("BillingClient", "Unable to log.", th2);
        }
    }

    private final void zzbu(zzjd zzjdVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzcy.$r8$clinit;
            zzbc(zzcy.zzb(zzjdVar, i, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbv(zzjd zzjdVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcy.$r8$clinit;
            zzbd(zzcy.zzb(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbw(zzjd zzjdVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcy.$r8$clinit;
            zzbd(zzcy.zzb(zzjdVar, 2, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbx(int i) {
        try {
            int i2 = zzcy.$r8$clinit;
            zzbe(zzcy.zzc(i, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    static /* bridge */ /* synthetic */ BillingResult zzm(Exception exc) {
        return exc instanceof DeadObjectException ? zzdc.zzj : zzdc.zzh;
    }

    public static /* synthetic */ Object zzr(BillingClientImpl billingClientImpl, int i, zzp zzpVar) {
        billingClientImpl.zzbi(new zzbs(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzs(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) throws Throwable {
        if (billingClientImpl.zzbl(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            billingClientImpl.zzaO(consumeParams, consumeResponseListener);
            return null;
        }
        zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzdc.zzj;
        billingClientImpl.zzbs(zzjdVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        return null;
    }

    public static /* synthetic */ Object zzt(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) {
        if (!billingClientImpl.zzbl(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            billingClientImpl.zzbs(zzjdVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
            return null;
        }
        if (billingClientImpl.zzu) {
            zzcg zzcgVarZzh = billingClientImpl.zzh(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzdc.zza(zzcgVarZzh.zza(), zzcgVarZzh.zzb()), new QueryProductDetailsResult(zzcgVarZzh.zzc(), zzcgVarZzh.zzd()));
            return null;
        }
        zzc.zzo("BillingClient", "Querying product details is not supported.");
        zzjd zzjdVar2 = zzjd.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzdc.zzr;
        billingClientImpl.zzbs(zzjdVar2, 7, billingResult2);
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        return null;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        billingClientImpl.zzaA(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzaC(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object zzw(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        billingClientImpl.zzaB(billingConfigResponseListener);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzu(this.zza, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzR(this.zza, acknowledgePurchaseResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, billingResultZzay);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzay);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzba
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                BillingClientImpl.zzs(this.zza, consumeResponseListener, consumeParams);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: com.android.billingclient.api.zzbb
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzL(this.zza, consumeResponseListener, consumeParams);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, billingResultZzay);
            consumeResponseListener.onConsumeResponse(billingResultZzay, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbx(12);
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    this.zzf.zzh();
                    try {
                        zzc.zzn("BillingClient", "Unbinding from service.");
                        zzbj();
                    } catch (Throwable th) {
                        zzc.zzp("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                    }
                    try {
                        zzbh();
                    } catch (Throwable th2) {
                        try {
                            zzc.zzp("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th2);
                        } catch (Throwable th3) {
                            zzbg(3);
                            this.zzH = null;
                            throw th3;
                        }
                    }
                    zzbg(3);
                    this.zzH = null;
                } else {
                    zzc.zzn("BillingClient", "Unbinding from service.");
                    zzbj();
                    zzbh();
                    zzbg(3);
                    this.zzH = null;
                }
            } catch (Throwable th4) {
                zzc.zzp("BillingClient", "There was an exception while shutting down broadcast manager while ending connection!", th4);
            }
            throw th;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzw(this.zza, billingConfigResponseListener);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzN(this.zza, billingConfigResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, billingResultZzay);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzay, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!zzbk(3000L)) {
            BillingResult billingResult = zzdc.zzj;
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbs(zzjdVar, 5, billingResult);
                return billingResult;
            }
            zzbx(5);
            return billingResult;
        }
        BillingResult billingResult2 = zzdc.zza;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    BillingResult billingResult3 = this.zzl ? zzdc.zzi : zzdc.zzm;
                    zzbr(billingResult3, zzjd.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return billingResult3;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult4 = this.zzs ? zzdc.zzi : zzdc.zzo;
                    zzbr(billingResult4, zzjd.CROSS_APP_NOT_SUPPORTED, 6);
                    return billingResult4;
                }
                break;
            case 97314:
                if (str.equals("bbb")) {
                    BillingResult billingResult5 = this.zzq ? zzdc.zzi : zzdc.zzs;
                    zzbr(billingResult5, zzjd.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return billingResult5;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult6 = this.zzt ? zzdc.zzi : zzdc.zzp;
                    zzbr(billingResult6, zzjd.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return billingResult6;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult7 = this.zzr ? zzdc.zzi : zzdc.zzq;
                    zzbr(billingResult7, zzjd.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return billingResult7;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult8 = this.zzt ? zzdc.zzi : zzdc.zzp;
                    zzbr(billingResult8, zzjd.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return billingResult8;
                }
                break;
            case 101286:
                if (str.equals("fff")) {
                    BillingResult billingResult9 = this.zzu ? zzdc.zzi : zzdc.zzr;
                    zzbr(billingResult9, zzjd.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return billingResult9;
                }
                break;
            case 102279:
                if (str.equals("ggg")) {
                    BillingResult billingResult10 = this.zzv ? zzdc.zzi : zzdc.zzy;
                    zzbr(billingResult10, zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return billingResult10;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult11 = this.zzv ? zzdc.zzi : zzdc.zzz;
                    zzbr(billingResult11, zzjd.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return billingResult11;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult12 = this.zzx ? zzdc.zzi : zzdc.zzB;
                    zzbr(billingResult12, zzjd.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return billingResult12;
                }
                break;
            case 105258:
                if (str.equals("jjj")) {
                    BillingResult billingResult13 = this.zzy ? zzdc.zzi : zzdc.zzC;
                    zzbr(billingResult13, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return billingResult13;
                }
                break;
            case 106251:
                if (str.equals("kkk")) {
                    BillingResult billingResult14 = this.zzB ? zzdc.zzi : zzdc.zzt;
                    zzbr(billingResult14, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, 18);
                    return billingResult14;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult15 = this.zzA ? zzdc.zzi : zzdc.zzu;
                    zzbr(billingResult15, zzjd.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return billingResult15;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    BillingResult billingResult16 = this.zzB ? zzdc.zzi : zzdc.zzv;
                    zzbr(billingResult16, zzjd.AUTO_PAY_NOT_SUPPORTED, 20);
                    return billingResult16;
                }
                break;
            case 109230:
                if (str.equals("nnn")) {
                    BillingResult billingResult17 = this.zzC ? zzdc.zzi : zzdc.zzw;
                    zzbr(billingResult17, zzjd.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return billingResult17;
                }
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    BillingResult billingResult18 = this.zzo ? zzdc.zzi : zzdc.zzn;
                    zzbr(billingResult18, zzjd.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return billingResult18;
                }
                break;
            case 1987365622:
                if (str.equals(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS)) {
                    BillingResult billingResult19 = this.zzk ? zzdc.zzi : zzdc.zzl;
                    zzbr(billingResult19, zzjd.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return billingResult19;
                }
                break;
        }
        zzc.zzo("BillingClient", "Unsupported feature: ".concat(str));
        BillingResult billingResult20 = zzdc.zzx;
        zzbr(billingResult20, zzjd.UNKNOWN_FEATURE, 1);
        return billingResult20;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzF) {
            return true;
        }
        return zzbm();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean zZzd;
        long j;
        String string;
        Future futureZzK;
        ?? r5;
        ?? r6;
        ?? r7;
        zzjd zzjdVarZzb;
        Object obj;
        boolean z;
        int i;
        long jNextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zzf() == null) {
            zzjd zzjdVar = zzjd.MISSING_LISTENER;
            BillingResult billingResult = zzdc.zzD;
            zzbt(zzjdVar, 2, billingResult, jNextLong);
            return billingResult;
        }
        billingFlowParams.getDeveloperBillingOptionParams();
        if (!zzbk(3000L)) {
            zzjd zzjdVar2 = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult2 = zzdc.zzj;
            zzbt(zzjdVar2, 2, billingResult2, jNextLong);
            zzn(billingResult2);
            return billingResult2;
        }
        synchronized (this.zza) {
            try {
                zZzd = this.zzj != null ? this.zzj.zzd() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayListZzj = billingFlowParams.zzj();
        List listZzk = billingFlowParams.zzk();
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(zzcb.zza(arrayListZzj, null));
        BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) zzcb.zza(listZzk, null);
        final String productId = productDetailsParams.zza().getProductId();
        final String productType = productDetailsParams.zza().getProductType();
        if (productType.equals("subs") && !this.zzk) {
            zzc.zzo("BillingClient", "Current client doesn't support subscriptions.");
            zzjd zzjdVar3 = zzjd.SUBSCRIPTIONS_NOT_SUPPORTED;
            BillingResult billingResult3 = zzdc.zzl;
            zzbv(zzjdVar3, 2, billingResult3, jNextLong, zZzd);
            zzn(billingResult3);
            return billingResult3;
        }
        if (billingFlowParams.zzu() && !this.zzn) {
            zzc.zzo("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzjd zzjdVar4 = zzjd.EXTRA_PARAMS_NOT_SUPPORTED;
            BillingResult billingResult4 = zzdc.zzf;
            zzbv(zzjdVar4, 2, billingResult4, jNextLong, zZzd);
            zzn(billingResult4);
            return billingResult4;
        }
        if (arrayListZzj.size() > 1 && !this.zzt) {
            zzc.zzo("BillingClient", "Current client doesn't support multi-item purchases.");
            zzjd zzjdVar5 = zzjd.MULTI_ITEM_NOT_SUPPORTED;
            BillingResult billingResult5 = zzdc.zzp;
            zzbv(zzjdVar5, 2, billingResult5, jNextLong, zZzd);
            zzn(billingResult5);
            return billingResult5;
        }
        if (!listZzk.isEmpty() && !this.zzu) {
            zzc.zzo("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzjd zzjdVar6 = zzjd.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult6 = zzdc.zzr;
            zzbv(zzjdVar6, 2, billingResult6, jNextLong, zZzd);
            zzn(billingResult6);
            return billingResult6;
        }
        BillingResult billingResultZzd = billingFlowParams.zzd();
        if (billingResultZzd != zzdc.zzi) {
            zzbv(zzjd.INVALID_BILLING_FLOW_PARAMS, 2, billingResultZzd, jNextLong, zZzd);
            zzn(billingResultZzd);
            return billingResultZzd;
        }
        boolean z2 = zZzd;
        if (this.zzn) {
            long j2 = jNextLong;
            final Bundle bundleZzf = zzc.zzf(billingFlowParams, this.zzp, this.zzw, this.zzE.isEnabledForOneTimeProducts(), this.zzE.isEnabledForPrepaidPlans(), this.zzG, this.zzc, this.zzd, this.zzJ.longValue(), this.zzg.getPackageName(), j2);
            if (arrayListZzj.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                for (int i2 = 0; i2 < listZzk.size(); i2++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) listZzk.get(i2);
                    ProductDetails productDetailsZza = productDetailsParams2.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    String strZzb = productDetailsParams2.zzb();
                    arrayList4.add(strZzb);
                    String strZzc = productDetailsZza.zzc(strZzb);
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList5.add(strZzc);
                    }
                    if (i2 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i2)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i2)).zza().getProductType());
                    }
                }
                bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList6.isEmpty()) {
                    bundleZzf.putIntegerArrayList("autoPayBalanceThresholdList", arrayList6);
                }
                if (!arrayList3.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundleZzf.putStringArrayList("additionalSkus", arrayList);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it = arrayListZzj.iterator();
                if (it.hasNext()) {
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                    throw null;
                }
                if (!arrayList7.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (arrayListZzj.size() > 1) {
                    ArrayList<String> arrayList8 = new ArrayList<>(arrayListZzj.size() - 1);
                    ArrayList<String> arrayList9 = new ArrayList<>(arrayListZzj.size() - 1);
                    if (1 < arrayListZzj.size()) {
                        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(arrayListZzj.get(1));
                        throw null;
                    }
                    bundleZzf.putStringArrayList("additionalSkus", arrayList8);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList9);
                }
            }
            if (bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                zzjd zzjdVar7 = zzjd.OFFER_ID_TOKEN_NOT_SUPPORTED;
                BillingResult billingResult7 = zzdc.zzq;
                zzbv(zzjdVar7, 2, billingResult7, j2, z2);
                zzn(billingResult7);
                return billingResult7;
            }
            if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                z = false;
            } else {
                bundleZzf.putString("skuPackageName", productDetailsParams.zza().zza());
                z = true;
            }
            if (!TextUtils.isEmpty(null)) {
                bundleZzf.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzc.zzo("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                bundleZzf.putString("proxyPackage", stringExtra);
                try {
                    bundleZzf.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused) {
                    bundleZzf.putString("proxyPackageVersion", "package not found");
                }
            }
            if (this.zzu && !listZzk.isEmpty()) {
                i = 17;
            } else if (this.zzs && z) {
                i = 15;
            } else {
                i = this.zzp ? 9 : 6;
            }
            final int i3 = i;
            string = null;
            final BillingFlowParams billingFlowParams2 = billingFlowParams;
            futureZzK = zzK(new Callable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzat(i3, productId, productType, billingFlowParams2, bundleZzf);
                }
            }, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, null, this.zze, zzJ());
            r5 = billingFlowParams2;
            j = j2;
        } else {
            j = jNextLong;
            string = null;
            futureZzK = zzK(new Callable() { // from class: com.android.billingclient.api.zzag
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzau(productId, productType);
                }
            }, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, null, this.zze, zzJ());
            r5 = jNextLong;
        }
        try {
            if (futureZzK == null) {
                try {
                    zzjd zzjdVar8 = zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                    BillingResult billingResult8 = zzdc.zzc;
                    zzbv(zzjdVar8, 2, billingResult8, j, z2);
                    zzn(billingResult8);
                    return billingResult8;
                } catch (CancellationException e) {
                    e = e;
                    r7 = j;
                    zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar9 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult9 = zzdc.zzk;
                    zzbw(zzjdVar9, 2, billingResult9, zzcy.zza(e), r7, z2);
                    zzn(billingResult9);
                    return billingResult9;
                } catch (TimeoutException e2) {
                    e = e2;
                    r7 = j;
                    zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar10 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult10 = zzdc.zzk;
                    zzbw(zzjdVar10, 2, billingResult10, zzcy.zza(e), r7, z2);
                    zzn(billingResult10);
                    return billingResult10;
                } catch (Exception e3) {
                    e = e3;
                    r6 = j;
                    zzc.zzp("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar11 = zzjd.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult11 = zzdc.zzj;
                    zzbw(zzjdVar11, 2, billingResult11, zzcy.zza(e), r6, z2);
                    zzn(billingResult11);
                    return billingResult11;
                }
            }
            long j3 = j;
            Bundle bundle = (Bundle) futureZzK.get(HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            int iZzb = zzc.zzb(bundle, "BillingClient");
            String strZzk = zzc.zzk(bundle, "BillingClient");
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                intent2.putExtra("billingClientTransactionId", j3);
                intent2.putExtra("wasServiceAutoReconnected", z2);
                activity.startActivity(intent2);
                return zzdc.zzi;
            }
            zzc.zzo("BillingClient", "Unable to buy item, Error response code: " + iZzb);
            BillingResult billingResultZza = zzdc.zza(iZzb, strZzk);
            try {
                if (bundle == null || (obj = bundle.get("LOG_REASON")) == null) {
                    zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
                } else if (obj instanceof Integer) {
                    zzjdVarZzb = zzjd.zzb(((Integer) obj).intValue());
                } else {
                    zzc.zzo("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                    zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
                }
            } catch (Throwable th2) {
                zzc.zzo("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th2.getMessage())));
                zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
            }
            if (zzjdVarZzb == zzjd.REASON_UNSPECIFIED) {
                zzjdVarZzb = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            }
            zzjd zzjdVar12 = zzjdVarZzb;
            if (bundle != null) {
                try {
                    string = bundle.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th3) {
                    zzc.zzo("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th3.getMessage())));
                }
            }
            try {
                zzbw(zzjdVar12, 2, billingResultZza, string, j3, z2);
                zzn(billingResultZza);
                return billingResultZza;
            } catch (CancellationException e4) {
                e = e4;
                r7 = j3;
                z2 = z2;
                zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar13 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult12 = zzdc.zzk;
                zzbw(zzjdVar13, 2, billingResult12, zzcy.zza(e), r7, z2);
                zzn(billingResult12);
                return billingResult12;
            } catch (TimeoutException e5) {
                e = e5;
                r7 = j3;
                z2 = z2;
                zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar14 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult13 = zzdc.zzk;
                zzbw(zzjdVar14, 2, billingResult13, zzcy.zza(e), r7, z2);
                zzn(billingResult13);
                return billingResult13;
            } catch (Exception e6) {
                e = e6;
                r6 = j3;
                z2 = z2;
                zzc.zzp("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar15 = zzjd.LAUNCH_BILLING_FLOW_EXCEPTION;
                BillingResult billingResult14 = zzdc.zzj;
                zzbw(zzjdVar15, 2, billingResult14, zzcy.zza(e), r6, z2);
                zzn(billingResult14);
                return billingResult14;
            }
        } catch (CancellationException e7) {
            e = e7;
            r7 = r5;
        } catch (TimeoutException e8) {
            e = e8;
            r7 = r5;
        } catch (Exception e9) {
            e = e9;
            r6 = r5;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzbf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzt(this.zza, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: com.android.billingclient.api.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzT(this.zza, productDetailsResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, billingResultZzay);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzay, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzK(new zzbm(this, purchasesResponseListener, queryPurchasesParams.zza(), queryPurchasesParams.getIncludeSuspendedSubscriptions()), HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: com.android.billingclient.api.zzbj
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzM(this.zza, purchasesResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, billingResultZzay);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzay, com.google.android.gms.internal.play_billing.zzbw.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzbk(3000L)) {
            zzc.zzo("BillingClient", "Service disconnected.");
            return zzdc.zzj;
        }
        if (!this.zzq) {
            zzc.zzo("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzdc.zzs;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        Handler handler = this.zze;
        final zzbn zzbnVar = new zzbn(this, handler, inAppMessageResponseListener);
        zzK(new Callable() { // from class: com.android.billingclient.api.zzbh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzv(this.zza, bundle, activity, zzbnVar);
                return null;
            }
        }, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, null, handler, zzJ());
        return zzdc.zzi;
    }

    final synchronized ExecutorService zzJ() {
        try {
            if (this.zzI == null) {
                this.zzI = Executors.newFixedThreadPool(zzc.zza, new zzbl(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzI;
    }

    public final void zzao(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzcg zzh(QueryProductDetailsParams queryProductDetailsParams) {
        zzap zzapVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbw zzbwVarZza = queryProductDetailsParams.zza();
        int size = zzbwVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zzbwVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    return zzaw(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.zzw && this.zzE.isEnabledForPrepaidPlans();
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                Bundle bundleZzj = zzapVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), strZzb, bundle, zzc.zzg(str, this.zzd, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z, true, true, true, false, true), this.zzJ.longValue()));
                if (bundleZzj == null) {
                    return zzaw(zzdc.zzA, zzjd.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = zzc.zzb(bundleZzj, "BillingClient");
                    String strZzk = zzc.zzk(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return zzaw(zzdc.zza(6, strZzk), zzjd.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzaw(zzdc.zza(iZzb, strZzk), zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaw(zzdc.zzA, zzjd.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                        zzc.zzn("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e) {
                        return zzaw(zzdc.zza(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (QueryProductDetailsParams.Product product : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.zza()).put("type", product.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                ProductDetails productDetails2 = (ProductDetails) it.next();
                                if (product.zza().equals(productDetails2.getProductId()) && product.zzb().equals(productDetails2.getProductType())) {
                                    break;
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(it2.next());
                            zzc.zzn("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return zzaw(zzdc.zza(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return zzaw(zzdc.zzj, zzjd.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzaw(zzdc.zzh, zzjd.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzcg(0, "", arrayList, arrayList2);
    }

    final zzcz zzk() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzn(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzan
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzV(this.zza, billingResult);
            }
        });
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzbi(billingClientStateListener, 0);
    }

    BillingClientImpl(String str, Context context, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzJ = lValueOf;
        this.zzK = zzbd.zza();
        this.zzc = BuildConfig.BILLING_CLIENT_VERSION;
        String strZzaE = zzaE();
        this.zzd = strZzaE;
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(BuildConfig.BILLING_CLIENT_VERSION);
        if (strZzaE != null) {
            zzjpVarZza.zzy(strZzaE);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        this.zzg.getPackageName();
        this.zzF = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzdo zzdoVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzJ = lValueOf;
        this.zzK = zzbd.zza();
        this.zzc = BuildConfig.BILLING_CLIENT_VERSION;
        String strZzaE = zzaE();
        this.zzd = strZzaE;
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(BuildConfig.BILLING_CLIENT_VERSION);
        if (strZzaE != null) {
            zzjpVarZza.zzy(strZzaE);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzab(this.zzg, null, null, null, null, null, this.zzh);
        this.zzE = pendingPurchasesParams;
        this.zzg.getPackageName();
        this.zzF = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = Long.valueOf(new Random().nextLong());
        this.zzK = zzbd.zza();
        this.zzc = BuildConfig.BILLING_CLIENT_VERSION;
        this.zzd = zzaE();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, null, BuildConfig.BILLING_CLIENT_VERSION, null, builder);
    }
}
