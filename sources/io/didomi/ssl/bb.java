package io.didomi.ssl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import androidx.preference.PreferenceManager;
import com.adjust.sdk.Constants;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import io.didomi.ssl.functionalinterfaces.DidomiCallable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 72\u00020\u0001:\u0001\u0005B)\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0012J*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0012J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0012J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0012J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0012J \u0010\u0005\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0012J \u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0012J \u0010\u000b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0012J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0012J \u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0012J\b\u0010\u0005\u001a\u00020\rH\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0010\u001a\u00020\u0006H\u0017J\b\u0010\u0012\u001a\u00020\u0011H\u0017J \u0010\u0005\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0017J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR!\u0010$\u001a\u00020\u001f8VX\u0097\u0084\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b\u000b\u0010!R\u001c\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\u0015\u001a\n &*\u0004\u0018\u00010\u00140\u00148\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\n &*\u0004\u0018\u00010\u00040\u00048\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00068"}, d2 = {"Lio/didomi/sdk/bb;", "Lio/didomi/sdk/h0;", "Lio/didomi/sdk/ab;", "remoteFile", "", "a", "", "cacheDate", "startTime", "", "retryOnFailure", "b", "cacheFilePath", "", "afterError", "Ljava/io/File;", "d", "", "c", "content", "Landroid/content/res/AssetManager;", "assetManager", "Lio/didomi/sdk/g0;", "Lio/didomi/sdk/g0;", "connectivityHelper", "Lio/didomi/sdk/o6;", "Lio/didomi/sdk/o6;", "httpRequestHelper", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lio/didomi/sdk/Didomi;", "Lkotlin/Lazy;", "()Lio/didomi/sdk/Didomi;", "getDidomi$annotations", "()V", "didomi", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "e", "Landroid/content/SharedPreferences;", "sharedPreferences", "f", "Landroid/content/res/AssetManager;", "g", "Ljava/lang/String;", "cacheFilesPath", "Ljava/lang/Object;", "h", "Ljava/lang/Object;", "connectivityBlocker", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lio/didomi/sdk/g0;Lio/didomi/sdk/o6;Lkotlinx/coroutines/CoroutineDispatcher;)V", "i", "android_release"}, k = 1, mv = {1, 8, 0})
public class bb implements h0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g0 connectivityHelper;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final o6 httpRequestHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy didomi;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final AssetManager assetManager;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String cacheFilesPath;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Object connectivityBlocker;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/Didomi;", "a", "()Lio/didomi/sdk/Didomi;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Didomi invoke() {
            return Didomi.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"io/didomi/sdk/bb$c", "Lio/didomi/sdk/r6;", "", "response", "", "a", "b", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements r6 {
        final /* synthetic */ RemoteFile a;
        final /* synthetic */ boolean b;
        final /* synthetic */ bb c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        c(RemoteFile abVar, boolean z, bb bbVar, long j, long j2) {
            this.a = abVar;
            this.b = z;
            this.c = bbVar;
            this.d = j;
            this.e = j2;
        }

        @Override // io.didomi.ssl.r6
        public void a(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (StringsKt.isBlank(response)) {
                return;
            }
            if (this.a.getValidateRemoteFileAsJSON()) {
                try {
                    new JSONObject(response);
                } catch (JSONException e) {
                    Log.e("Unable to parse the remote file " + this.a.getRemoteFileURL() + " as valid JSON", e);
                    return;
                }
            }
            this.a.a(response);
        }

        @Override // io.didomi.ssl.r6
        public void b(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Log.e$default("Unable to download the remote file " + this.a.getRemoteFileURL() + ": " + response, null, 2, null);
            if (this.b) {
                this.c.b(this.a, this.d, this.e);
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "io.didomi.sdk.remote.RemoteFilesHelper$requestCacheUpdateWhenReady$1$1", f = "RemoteFilesHelper.kt", l = {}, m = "invokeSuspend")
    static final class d extends SuspendLambda implements Function2 {
        int a;
        final /* synthetic */ RemoteFile b;
        final /* synthetic */ bb c;
        final /* synthetic */ String d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(RemoteFile abVar, bb bbVar, String str, long j, Continuation continuation) {
            super(2, continuation);
            this.b = abVar;
            this.c = bbVar;
            this.d = str;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(true);
            this.c.a(this.d, this.b, this.e);
            return Unit.INSTANCE;
        }
    }

    public bb(Context context, g0 connectivityHelper, o6 httpRequestHelper, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(connectivityHelper, "connectivityHelper");
        Intrinsics.checkNotNullParameter(httpRequestHelper, "httpRequestHelper");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.connectivityHelper = connectivityHelper;
        this.httpRequestHelper = httpRequestHelper;
        this.coroutineDispatcher = coroutineDispatcher;
        this.didomi = LazyKt.lazy(b.a);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.assetManager = context.getAssets();
        this.cacheFilesPath = context.getFilesDir().getAbsolutePath();
        this.connectivityBlocker = new Object();
    }

    public Didomi b() {
        return (Didomi) this.didomi.getValue();
    }

    public int c() {
        return 5;
    }

    public long d() {
        return HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS;
    }

    public String b(RemoteFile remoteFile) {
        bb bbVar;
        RemoteFile abVar;
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        String strF = remoteFile.getRemoteFileURL();
        if (strF == null || StringsKt.isBlank(strF)) {
            AssetManager assetManager = this.assetManager;
            Intrinsics.checkNotNullExpressionValue(assetManager, "assetManager");
            return a(assetManager, remoteFile);
        }
        String strA = a(remoteFile);
        if (remoteFile.j()) {
            c(strA, remoteFile);
            bbVar = this;
            abVar = remoteFile;
        } else {
            bbVar = this;
            abVar = remoteFile;
            String strA2 = bbVar.a(abVar, 0L, 0L, false);
            if (strA2 != null) {
                return strA2;
            }
        }
        String strB = b(strA, abVar);
        if (strB != null) {
            return strB;
        }
        AssetManager assetManager2 = bbVar.assetManager;
        Intrinsics.checkNotNullExpressionValue(assetManager2, "assetManager");
        return a(assetManager2, abVar);
    }

    public void c(String cacheFilePath, RemoteFile remoteFile) {
        Intrinsics.checkNotNullParameter(cacheFilePath, "cacheFilePath");
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        if (remoteFile.k() && remoteFile.j()) {
            File fileA = a(cacheFilePath, remoteFile);
            long j = 0;
            if (fileA == null || !fileA.canRead()) {
                Log.e$default("Cache file is not readable (" + cacheFilePath + ')', null, 2, null);
            } else {
                j = this.sharedPreferences.getLong(remoteFile.getCacheFileDateKey(), 0L);
                if ((System.currentTimeMillis() - j) / ((long) 1000) < remoteFile.getCacheFileExpirationInSeconds()) {
                    return;
                }
            }
            if (b(remoteFile, cacheFilePath)) {
                a(cacheFilePath, remoteFile, j);
            } else {
                b(cacheFilePath, remoteFile, j);
            }
        }
    }

    @Override // io.didomi.ssl.h0
    public void a() {
        synchronized (this.connectivityBlocker) {
            this.connectivityHelper.b(this);
            this.connectivityBlocker.notify();
            Unit unit = Unit.INSTANCE;
        }
    }

    public File a(String cacheFilePath, RemoteFile remoteFile) {
        Intrinsics.checkNotNullParameter(cacheFilePath, "cacheFilePath");
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        if (!remoteFile.j()) {
            return null;
        }
        File file = new File(cacheFilePath);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public void a(String cacheFilePath, RemoteFile remoteFile, String content) {
        Intrinsics.checkNotNullParameter(cacheFilePath, "cacheFilePath");
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        Intrinsics.checkNotNullParameter(content, "content");
        if (remoteFile.j()) {
            FilesKt.writeText$default(new File(cacheFilePath), content, null, 2, null);
            this.sharedPreferences.edit().putLong(remoteFile.getCacheFileDateKey(), System.currentTimeMillis()).apply();
        }
    }

    public String a(AssetManager assetManager, RemoteFile remoteFile) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        String strD = remoteFile.getFallbackFilePathInAssets();
        if (strD == null || StringsKt.isBlank(strD)) {
            Log.d$default("No fallback available", null, 2, null);
            return null;
        }
        try {
            InputStream inputStreamOpen = assetManager.open(strD);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "assetManager.open(fallbackFilePath)");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
            try {
                String text = TextStreamsKt.readText(inputStreamReader);
                CloseableKt.closeFinally(inputStreamReader, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamReader, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            Log.e("Unable to read the content of the file assets/" + strD, e);
            return null;
        }
    }

    public String b(String cacheFilePath, RemoteFile remoteFile) {
        Intrinsics.checkNotNullParameter(cacheFilePath, "cacheFilePath");
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        File fileA = a(cacheFilePath, remoteFile);
        if (fileA != null) {
            return FilesKt.readText$default(fileA, null, 1, null);
        }
        return null;
    }

    private long b(RemoteFile remoteFile, long startTime) {
        return remoteFile.getUpdateTimeout() - (System.currentTimeMillis() - startTime);
    }

    private void b(final String cacheFilePath, final RemoteFile remoteFile, final long cacheDate) {
        try {
            b().onReady(new DidomiCallable() { // from class: io.didomi.sdk.bb$$ExternalSyntheticLambda0
                @Override // io.didomi.ssl.functionalinterfaces.DidomiCallable
                public final void call() {
                    bb.a(this.f$0, remoteFile, cacheFilePath, cacheDate);
                }
            });
        } catch (Exception e) {
            Log.e("Error while requesting cache refresh: " + e.getMessage(), e);
        }
    }

    public String a(RemoteFile remoteFile, long cacheDate) {
        Intrinsics.checkNotNullParameter(remoteFile, "remoteFile");
        return a(remoteFile, cacheDate, 0L, remoteFile.m());
    }

    private String a(RemoteFile remoteFile) {
        return this.cacheFilesPath + File.separator + remoteFile.getCacheFileName();
    }

    private String a(RemoteFile remoteFile, long cacheDate, long startTime, boolean retryOnFailure) {
        String strF = remoteFile.getRemoteFileURL();
        if (strF != null && !StringsKt.isBlank(strF)) {
            long jCurrentTimeMillis = startTime > 0 ? startTime : System.currentTimeMillis();
            if (!this.connectivityHelper.c()) {
                if (retryOnFailure) {
                    return a(remoteFile, cacheDate, jCurrentTimeMillis);
                }
                return null;
            }
            boolean zI = remoteFile.getIsBlockUntilUpdated();
            int iMin = Constants.CONNECTION_TIMEOUT_VERIFY;
            if (!zI && remoteFile.getUpdateTimeout() != 0) {
                iMin = Math.min((int) b(remoteFile, jCurrentTimeMillis), Constants.CONNECTION_TIMEOUT_VERIFY);
            }
            int i = iMin;
            if (i < 0) {
                return null;
            }
            this.httpRequestHelper.a(strF, new c(remoteFile, retryOnFailure, this, cacheDate, jCurrentTimeMillis), i, cacheDate);
            String strE = remoteFile.getRemoteFileContent();
            if (strE != null && !StringsKt.isBlank(strE)) {
                return remoteFile.getRemoteFileContent();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemoteFile remoteFile, long cacheDate, long startTime) {
        for (int i = 0; remoteFile.getRemoteFileContent() == null && i < c() && a(remoteFile, startTime, true); i++) {
            try {
                Thread.sleep(d());
            } catch (InterruptedException e) {
                Log.e("Error while waiting to update cache", e);
            }
            Log.d$default("Retrying to update cache after " + (System.currentTimeMillis() - startTime) + "ms", null, 2, null);
            a(remoteFile, cacheDate, startTime, false);
        }
        String strE = remoteFile.getRemoteFileContent();
        if ((strE == null || StringsKt.isBlank(strE)) && !remoteFile.getIsBlockUntilUpdated()) {
            b(a(remoteFile), remoteFile, cacheDate);
        }
    }

    private boolean b(RemoteFile remoteFile, String cacheFilePath) {
        if (remoteFile.getIsUpdateCacheImmediately()) {
            return true;
        }
        if (remoteFile.getUpdateTimeout() != 0 || remoteFile.getIsBlockUntilUpdated()) {
            return a(remoteFile, cacheFilePath);
        }
        return false;
    }

    private String a(RemoteFile remoteFile, long cacheDate, long startTime) {
        long jG = remoteFile.getUpdateTimeout();
        long jB = (remoteFile.getIsBlockUntilUpdated() || jG <= 0) ? 0L : b(remoteFile, startTime);
        if (jB >= 0) {
            synchronized (this.connectivityBlocker) {
                try {
                    if (!this.connectivityHelper.c()) {
                        try {
                            this.connectivityHelper.a(this);
                            if (jB > 0) {
                                this.connectivityBlocker.wait(jB);
                            } else {
                                this.connectivityBlocker.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            this.connectivityHelper.b(this);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        String strA = a(remoteFile);
        if (a(remoteFile, startTime, false)) {
            Log.d$default("Connection retrieved, trying to update cache after " + (System.currentTimeMillis() - startTime) + "ms", null, 2, null);
            a(remoteFile, cacheDate, startTime, jG > System.currentTimeMillis() - startTime);
        }
        String strE = remoteFile.getRemoteFileContent();
        if (strE == null || StringsKt.isBlank(strE)) {
            if (remoteFile.getIsBlockUntilUpdated()) {
                return null;
            }
            b(strA, remoteFile, cacheDate);
            return null;
        }
        return remoteFile.getRemoteFileContent();
    }

    private boolean a(RemoteFile remoteFile, String cacheFilePath) {
        return remoteFile.j() && a(cacheFilePath, remoteFile) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String cacheFilePath, RemoteFile remoteFile, long cacheDate) {
        String strA = a(remoteFile, cacheDate);
        if (strA == null || StringsKt.isBlank(strA)) {
            Log.d$default("No remote content to update for " + remoteFile.getRemoteFileURL(), null, 2, null);
            return;
        }
        a(cacheFilePath, remoteFile, strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bb this$0, RemoteFile remoteFile, String cacheFilePath, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(remoteFile, "$remoteFile");
        Intrinsics.checkNotNullParameter(cacheFilePath, "$cacheFilePath");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this$0.coroutineDispatcher), null, null, new d(remoteFile, this$0, cacheFilePath, j, null), 3, null);
    }

    private boolean a(RemoteFile remoteFile, long startTime, boolean afterError) {
        return remoteFile.getIsBlockUntilUpdated() || b(remoteFile, startTime) > (afterError ? d() : 0L);
    }
}
