package expo.modules.updates.loader;

import android.net.Uri;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import expo.modules.manifests.core.Manifest;
import expo.modules.structuredheaders.Dictionary;
import expo.modules.structuredheaders.OuterList;
import expo.modules.structuredheaders.StringItem;
import expo.modules.updates.BSPatch;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.codesigning.CodeSigningConfiguration;
import expo.modules.updates.codesigning.ExpoProjectInformation;
import expo.modules.updates.codesigning.SignatureValidationResult;
import expo.modules.updates.codesigning.ValidationResult;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.ResponsePartHeaderData;
import expo.modules.updates.manifest.ResponsePartInfo;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.manifest.UpdateFactory;
import expo.modules.updates.selectionpolicy.SelectionPolicies;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartReader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.brotli.BrotliInterceptor;
import okio.BufferedSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class FileDownloader {
    public static final Companion Companion = new Companion(null);
    private Function3 applyPatch;
    private OkHttpClient client;
    private final UpdatesConfiguration configuration;
    private final UpdatesDatabase database;
    private final String easClientID;
    private final File filesDirectory;
    private final UpdatesLogger logger;

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$downloadAsset$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return FileDownloader.this.downloadAsset(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$downloadRemoteUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C10981 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10981(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return FileDownloader.this.downloadRemoteUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$fallbackBundleDownload$1, reason: invalid class name and case insensitive filesystem */
    static final class C10991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10991(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return FileDownloader.this.fallbackBundleDownload(null, null, null, null, null, this);
        }
    }

    public FileDownloader(File filesDirectory, String easClientID, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        Intrinsics.checkNotNullParameter(easClientID, "easClientID");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        this.filesDirectory = filesDirectory;
        this.easClientID = easClientID;
        this.configuration = configuration;
        this.logger = logger;
        this.database = database;
        OkHttpClient.Builder builderCache = new OkHttpClient.Builder().cache(getCache());
        long jMax = Math.max(configuration.getLaunchWaitMs(), 10000L);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.client = builderCache.connectTimeout(jMax, timeUnit).readTimeout(Math.max(configuration.getLaunchWaitMs(), 10000L), timeUnit).addInterceptor(BrotliInterceptor.INSTANCE).build();
        this.applyPatch = new Function3() { // from class: expo.modules.updates.loader.FileDownloader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Integer.valueOf(FileDownloader.applyPatch$lambda$10((String) obj, (String) obj2, (String) obj3));
            }
        };
    }

    public static final class FileDownloadResult {
        private final File file;
        private final byte[] hash;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileDownloadResult)) {
                return false;
            }
            FileDownloadResult fileDownloadResult = (FileDownloadResult) obj;
            return Intrinsics.areEqual(this.file, fileDownloadResult.file) && Intrinsics.areEqual(this.hash, fileDownloadResult.hash);
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + Arrays.hashCode(this.hash);
        }

        public String toString() {
            return "FileDownloadResult(file=" + this.file + ", hash=" + Arrays.toString(this.hash) + ")";
        }

        public FileDownloadResult(File file, byte[] hash) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(hash, "hash");
            this.file = file;
            this.hash = hash;
        }

        public final byte[] getHash() {
            return this.hash;
        }
    }

    public static final class AssetDownloadResult {
        private final AssetEntity assetEntity;
        private final boolean isNew;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssetDownloadResult)) {
                return false;
            }
            AssetDownloadResult assetDownloadResult = (AssetDownloadResult) obj;
            return Intrinsics.areEqual(this.assetEntity, assetDownloadResult.assetEntity) && this.isNew == assetDownloadResult.isNew;
        }

        public int hashCode() {
            return (this.assetEntity.hashCode() * 31) + Boolean.hashCode(this.isNew);
        }

        public String toString() {
            return "AssetDownloadResult(assetEntity=" + this.assetEntity + ", isNew=" + this.isNew + ")";
        }

        public AssetDownloadResult(AssetEntity assetEntity, boolean z) {
            Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
            this.assetEntity = assetEntity;
            this.isNew = z;
        }

        public final AssetEntity getAssetEntity() {
            return this.assetEntity;
        }

        public final boolean isNew() {
            return this.isNew;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8571. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(expo.modules.updates.db.entity.AssetEntity r20, org.json.JSONObject r21, okhttp3.Request r22, java.lang.String r23, java.io.File r24, java.io.File r25, expo.modules.updates.loader.FileDownloadProgressListener r26, boolean r27, expo.modules.updates.db.entity.UpdateEntity r28, expo.modules.updates.db.entity.UpdateEntity r29, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instruction units count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.FileDownloader.downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(expo.modules.updates.db.entity.AssetEntity, org.json.JSONObject, okhttp3.Request, java.lang.String, java.io.File, java.io.File, expo.modules.updates.loader.FileDownloadProgressListener, boolean, expo.modules.updates.db.entity.UpdateEntity, expo.modules.updates.db.entity.UpdateEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fallbackBundleDownload(AssetEntity assetEntity, JSONObject jSONObject, FileDownloadProgressListener fileDownloadProgressListener, File file, String str, Continuation continuation) throws IOException {
        C10991 c10991;
        Request requestCreateRequestForAsset;
        if (continuation instanceof C10991) {
            c10991 = (C10991) continuation;
            int i = c10991.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10991.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10991 = new C10991(continuation);
            }
        } else {
            c10991 = new C10991(continuation);
        }
        Object objDownloadData = c10991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10991.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDownloadData);
            requestCreateRequestForAsset = createRequestForAsset(assetEntity, jSONObject, this.configuration, false);
            c10991.L$0 = file;
            c10991.L$1 = str;
            c10991.L$2 = requestCreateRequestForAsset;
            c10991.label = 1;
            objDownloadData = downloadData(requestCreateRequestForAsset, fileDownloadProgressListener, c10991);
            if (objDownloadData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            requestCreateRequestForAsset = (Request) c10991.L$2;
            str = (String) c10991.L$1;
            file = (File) c10991.L$0;
            ResultKt.throwOnFailure(objDownloadData);
        }
        Response response = (Response) objDownloadData;
        try {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                throw new IOException("Fallback asset download response from " + requestCreateRequestForAsset.url() + " had no body");
            }
            try {
                if (!response.isSuccessful()) {
                    throw new IOException(responseBodyBody.string());
                }
                InputStream inputStreamByteStream = responseBodyBody.byteStream();
                try {
                    byte[] bArrVerifySHA256AndWriteToFile = UpdatesUtils.INSTANCE.verifySHA256AndWriteToFile(inputStreamByteStream, file, str);
                    CloseableKt.closeFinally(inputStreamByteStream, null);
                    CloseableKt.closeFinally(responseBodyBody, null);
                    CloseableKt.closeFinally(response, null);
                    return bArrVerifySHA256AndWriteToFile;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamByteStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(responseBodyBody, th3);
                    throw th4;
                }
            }
            try {
                throw th;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(response, th);
                throw th5;
            }
        } catch (Throwable th6) {
            throw th6;
        }
    }

    private static final class PatchResponseMetadata {
        private final String expoBaseUpdateId;
        private final boolean hasImBsdiff;
        private final int statusCode;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PatchResponseMetadata)) {
                return false;
            }
            PatchResponseMetadata patchResponseMetadata = (PatchResponseMetadata) obj;
            return this.hasImBsdiff == patchResponseMetadata.hasImBsdiff && this.statusCode == patchResponseMetadata.statusCode && Intrinsics.areEqual(this.expoBaseUpdateId, patchResponseMetadata.expoBaseUpdateId);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.hasImBsdiff) * 31) + Integer.hashCode(this.statusCode)) * 31;
            String str = this.expoBaseUpdateId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "PatchResponseMetadata(hasImBsdiff=" + this.hasImBsdiff + ", statusCode=" + this.statusCode + ", expoBaseUpdateId=" + this.expoBaseUpdateId + ")";
        }

        public PatchResponseMetadata(boolean z, int i, String str) {
            this.hasImBsdiff = z;
            this.statusCode = i;
            this.expoBaseUpdateId = str;
        }

        public final boolean getHasImBsdiff() {
            return this.hasImBsdiff;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getExpoBaseUpdateId() {
            return this.expoBaseUpdateId;
        }
    }

    private final PatchResponseMetadata parsePatchResponseMetadata(Response response) {
        List listSplit$default;
        String strHeader$default = Response.header$default(response, "im", null, 2, null);
        boolean z = false;
        if (strHeader$default != null && (listSplit$default = StringsKt.split$default((CharSequence) strHeader$default, new char[]{','}, false, 0, 6, (Object) null)) != null) {
            List list = listSplit$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((String) it.next()).toString());
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.equals((String) it2.next(), "bsdiff", true)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        int iCode = response.code();
        if (z || iCode == 226) {
            return new PatchResponseMetadata(z, iCode, Response.header$default(response, "expo-base-update-id", null, 2, null));
        }
        return null;
    }

    private final boolean validatePatchResponseMetadata(PatchResponseMetadata patchResponseMetadata, UpdateEntity updateEntity) {
        String lowerCase;
        UUID id;
        String string;
        String lowerCase2 = null;
        if (updateEntity == null || (id = updateEntity.getId()) == null || (string = id.toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        String expoBaseUpdateId = patchResponseMetadata.getExpoBaseUpdateId();
        if (expoBaseUpdateId != null) {
            lowerCase2 = expoBaseUpdateId.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        }
        if ((patchResponseMetadata.getHasImBsdiff() || patchResponseMetadata.getStatusCode() == 226) && lowerCase2 != null) {
            return lowerCase == null || Intrinsics.areEqual(lowerCase2, lowerCase);
        }
        return false;
    }

    private final byte[] applyPatchAndVerify(AssetEntity assetEntity, ResponseBody responseBody, File file, File file2, UpdateEntity updateEntity, UpdateEntity updateEntity2, String str) {
        UUID id;
        return applyHermesDiff$expo_updates_release(prepareAssetForDiff$expo_updates_release(assetEntity, responseBody, file2, updateEntity).getBaseFile(), responseBody, file, str, assetEntity, (updateEntity2 == null || (id = updateEntity2.getId()) == null) ? null : id.toString());
    }

    public static final class LaunchAssetContext {
        private final File baseFile;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LaunchAssetContext) && Intrinsics.areEqual(this.baseFile, ((LaunchAssetContext) obj).baseFile);
        }

        public int hashCode() {
            return this.baseFile.hashCode();
        }

        public String toString() {
            return "LaunchAssetContext(baseFile=" + this.baseFile + ")";
        }

        public LaunchAssetContext(File baseFile) {
            Intrinsics.checkNotNullParameter(baseFile, "baseFile");
            this.baseFile = baseFile;
        }

        public final File getBaseFile() {
            return this.baseFile;
        }
    }

    private final Object downloadData(Request request, FileDownloadProgressListener fileDownloadProgressListener, Continuation continuation) {
        ResponseBody responseBodyBody;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final Call callNewCall = this.client.newCall(request);
        cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: expo.modules.updates.loader.FileDownloader$downloadData$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                callNewCall.cancel();
            }
        });
        try {
            Response responseExecute = callNewCall.execute();
            Response responseBuild = null;
            if (fileDownloadProgressListener != null && (responseBodyBody = responseExecute.body()) != null) {
                responseBuild = responseExecute.newBuilder().body(new FileDownloadProgressResponseBody(responseBodyBody, fileDownloadProgressListener)).build();
            }
            Result.Companion companion = Result.Companion;
            if (responseBuild != null) {
                responseExecute = responseBuild;
            }
            cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(responseExecute));
        } catch (Exception e) {
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(e)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final LaunchAssetContext prepareAssetForDiff$expo_updates_release(AssetEntity asset, ResponseBody responseBody, File updatesDirectory, UpdateEntity launchedUpdate) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(launchedUpdate, "launchedUpdate");
        try {
            return preparePatchBaseAsset(asset, updatesDirectory, launchedUpdate);
        } catch (Exception e) {
            responseBody.close();
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException("Failed to prepare asset for diff", e);
        }
    }

    private final LaunchAssetContext preparePatchBaseAsset(AssetEntity assetEntity, File file, UpdateEntity updateEntity) throws IOException {
        String base64Url;
        if (!assetEntity.isLaunchAsset()) {
            throw new IOException("Received patch for non-launch asset " + assetEntity.getKey());
        }
        UUID id = updateEntity.getId();
        AssetEntity assetEntityLoadLaunchAssetForUpdate = this.database.updateDao().loadLaunchAssetForUpdate(id);
        if (assetEntityLoadLaunchAssetForUpdate == null) {
            throw new IOException("Launch asset not found for current update " + id);
        }
        String relativePath = assetEntityLoadLaunchAssetForUpdate.getRelativePath();
        if (relativePath == null) {
            throw new IOException("Launch asset for update " + id + " is missing a relative path");
        }
        File file2 = new File(file, relativePath);
        if (!file2.exists()) {
            throw new IOException("Base asset " + file2 + " is missing; cannot apply patch");
        }
        try {
            UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
            base64Url = updatesUtils.toBase64Url(updatesUtils.sha256(file2));
        } catch (Exception unused) {
            base64Url = null;
        }
        String expectedHash = assetEntityLoadLaunchAssetForUpdate.getExpectedHash();
        if (expectedHash != null && base64Url != null && !Intrinsics.areEqual(expectedHash, base64Url)) {
            this.logger.warn("Asset hash mismatch for update " + id + "; expected=" + expectedHash + " actual=" + base64Url, UpdatesErrorCode.AssetsFailedToLoad, id.toString(), assetEntity.getKey());
            throw new IOException("Asset hash mismatch for update " + id + "; expected=" + expectedHash + " actual=" + base64Url);
        }
        return new LaunchAssetContext(file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int applyPatch$lambda$10(String baseFilePath, String newFilePath, String patchFilePath) {
        Intrinsics.checkNotNullParameter(baseFilePath, "baseFilePath");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(patchFilePath, "patchFilePath");
        return BSPatch.applyPatch(baseFilePath, newFilePath, patchFilePath);
    }

    public final byte[] applyHermesDiff$expo_updates_release(File baseFile, ResponseBody diffBody, File destination, String str, AssetEntity asset, String str2) {
        Intrinsics.checkNotNullParameter(baseFile, "baseFile");
        Intrinsics.checkNotNullParameter(diffBody, "diffBody");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(asset, "asset");
        File file = new File(destination.getAbsolutePath() + ".patch");
        File file2 = new File(destination.getAbsolutePath() + ".patched");
        try {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                File parentFile2 = file2.getParentFile();
                if (parentFile2 != null) {
                    parentFile2.mkdirs();
                }
                InputStream inputStreamByteStream = diffBody.byteStream();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        ByteStreamsKt.copyTo$default(inputStreamByteStream, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStreamByteStream, null);
                        Function3 function3 = this.applyPatch;
                        String absolutePath = baseFile.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        String absolutePath2 = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                        String absolutePath3 = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
                        int iIntValue = ((Number) function3.invoke(absolutePath, absolutePath2, absolutePath3)).intValue();
                        if (iIntValue != 0) {
                            throw new IOException("BSPatch exited with code " + iIntValue + " while applying patch");
                        }
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        try {
                            byte[] bArrVerifySHA256AndWriteToFile = UpdatesUtils.INSTANCE.verifySHA256AndWriteToFile(fileInputStream, destination, str);
                            this.logger.info("Applied diff for asset " + asset.getKey(), UpdatesErrorCode.None, str2, asset.getKey());
                            CloseableKt.closeFinally(fileInputStream, null);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            return bArrVerifySHA256AndWriteToFile;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(fileInputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(fileOutputStream, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(inputStreamByteStream, th5);
                        throw th6;
                    }
                }
            } catch (Exception e) {
                IOException iOException = e instanceof IOException ? (IOException) e : null;
                if (iOException == null) {
                    iOException = new IOException("Failed to apply patch", e);
                }
                this.logger.error("Failed to apply patch for asset " + asset.getKey(), iOException, UpdatesErrorCode.AssetsFailedToLoad);
                throw iOException;
            }
        } catch (Throwable th7) {
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            throw th7;
        }
    }

    public final UpdateResponse parseRemoteUpdateResponse$expo_updates_release(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        Headers headers = response.headers();
        ResponseHeaderData responseHeaderData = new ResponseHeaderData(headers.get("expo-protocol-version"), headers.get("expo-server-defined-headers"), headers.get("expo-manifest-filters"));
        ResponseBody responseBodyBody = response.body();
        if (response.code() == 204 || responseBodyBody == null) {
            if (responseHeaderData.getProtocolVersion() != null && responseHeaderData.getProtocolVersion().intValue() > 0) {
                return new UpdateResponse(responseHeaderData, null, null);
            }
            IOException iOException = new IOException("Empty body");
            this.logger.error("Invalid update response", iOException, UpdatesErrorCode.UpdateFailedToLoad);
            throw new IOException("Invalid update response", iOException);
        }
        MediaType mediaType = responseBodyBody.get$contentType();
        if (Intrinsics.areEqual(mediaType != null ? mediaType.type() : null, "multipart")) {
            return parseMultipartRemoteUpdateResponse(response, responseBodyBody, responseHeaderData);
        }
        ResponsePartHeaderData responsePartHeaderData = new ResponsePartHeaderData(headers.get("expo-signature"));
        ResponseBody responseBodyBody2 = response.body();
        Intrinsics.checkNotNull(responseBodyBody2);
        return new UpdateResponse(responseHeaderData, parseManifest(new ResponsePartInfo(responseHeaderData, responsePartHeaderData, responseBodyBody2.string()), null, null), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final UpdateResponse parseMultipartRemoteUpdateResponse(Response response, ResponseBody responseBody, ResponseHeaderData responseHeaderData) throws IOException {
        Pair pair;
        String utf8;
        String utf9;
        Pair pair2;
        String contentDispositionNameParameter;
        JSONObject jSONObject;
        if (response.peekBody(1L).bytes().length != 0) {
            try {
                MultipartReader multipartReader = new MultipartReader(responseBody);
                pair = null;
                utf8 = null;
                utf9 = null;
                pair2 = null;
                while (true) {
                    try {
                        MultipartReader.Part partNextPart = multipartReader.nextPart();
                        if (partNextPart == null) {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(multipartReader, null);
                        } else {
                            try {
                                Headers headers = partNextPart.getHeaders();
                                BufferedSource bufferedSourceBody = partNextPart.getBody();
                                String str = headers.get("content-disposition");
                                if (str != null && (contentDispositionNameParameter = UpdatesUtils.INSTANCE.parseContentDispositionNameParameter(str)) != null) {
                                    switch (contentDispositionNameParameter.hashCode()) {
                                        case -1809421292:
                                            if (contentDispositionNameParameter.equals("extensions")) {
                                                utf8 = bufferedSourceBody.readUtf8();
                                            }
                                            break;
                                        case -1044926951:
                                            if (contentDispositionNameParameter.equals("certificate_chain")) {
                                                utf9 = bufferedSourceBody.readUtf8();
                                            }
                                            break;
                                        case -962590641:
                                            if (contentDispositionNameParameter.equals("directive")) {
                                                pair2 = new Pair(bufferedSourceBody.readUtf8(), headers);
                                            }
                                            break;
                                        case 130625071:
                                            if (contentDispositionNameParameter.equals("manifest")) {
                                                pair = new Pair(bufferedSourceBody.readUtf8(), headers);
                                            }
                                            break;
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(partNextPart, null);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(partNextPart, th);
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(multipartReader, th3);
                            throw th4;
                        }
                    }
                    this.logger.error("Error while reading multipart remote update response", e, UpdatesErrorCode.UpdateFailedToLoad);
                    throw new IOException("Error while reading multipart remote update response", e);
                }
            } catch (Exception e) {
                this.logger.error("Error while reading multipart remote update response", e, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Error while reading multipart remote update response", e);
            }
        }
        pair = null;
        utf8 = null;
        utf9 = null;
        pair2 = null;
        if (utf8 != null) {
            try {
                jSONObject = new JSONObject(utf8);
            } catch (Exception e2) {
                this.logger.error("Failed to parse multipart remote update extensions part", e2, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to parse multipart remote update extensions part", e2);
            }
        } else {
            jSONObject = null;
        }
        if (this.configuration.getEnableExpoUpdatesProtocolV0CompatibilityMode() && pair == null) {
            IOException iOException = new IOException("Multipart response missing manifest part. Manifest is required in version 0 of the expo-updates protocol. This may be due to the response being for a different protocol version.");
            this.logger.error("Invalid update response", iOException, UpdatesErrorCode.UpdateFailedToLoad);
            throw new IOException("Invalid update response", iOException);
        }
        ResponsePartInfo responsePartInfo = pair != null ? new ResponsePartInfo(responseHeaderData, new ResponsePartHeaderData(((Headers) pair.getSecond()).get("expo-signature")), (String) pair.getFirst()) : null;
        ResponsePartInfo responsePartInfo2 = (this.configuration.getEnableExpoUpdatesProtocolV0CompatibilityMode() || pair2 == null) ? null : new ResponsePartInfo(responseHeaderData, new ResponsePartHeaderData(((Headers) pair2.getSecond()).get("expo-signature")), (String) pair2.getFirst());
        return new UpdateResponse(responseHeaderData, responsePartInfo != null ? parseManifest(responsePartInfo, jSONObject, utf9) : null, responsePartInfo2 != null ? parseDirective(responsePartInfo2, utf9) : null);
    }

    private final UpdateResponsePart.DirectiveUpdateResponsePart parseDirective(ResponsePartInfo responsePartInfo, String str) throws IOException {
        String body = responsePartInfo.getBody();
        try {
            CodeSigningConfiguration codeSigningConfiguration = this.configuration.getCodeSigningConfiguration();
            if (codeSigningConfiguration != null) {
                String signature = responsePartInfo.getResponsePartHeaderData().getSignature();
                byte[] bytes = body.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SignatureValidationResult signatureValidationResultValidateSignature = codeSigningConfiguration.validateSignature(signature, bytes, str);
                if (signatureValidationResultValidateSignature.getValidationResult() == ValidationResult.INVALID) {
                    throw new IOException("Incorrect signature");
                }
                if (signatureValidationResultValidateSignature.getValidationResult() != ValidationResult.SKIPPED) {
                    UpdateDirective updateDirectiveFromJSONString = UpdateDirective.Companion.fromJSONString(body);
                    ExpoProjectInformation expoProjectInformation = signatureValidationResultValidateSignature.getExpoProjectInformation();
                    if (expoProjectInformation != null) {
                        String projectId = expoProjectInformation.getProjectId();
                        SigningInfo signingInfo = updateDirectiveFromJSONString.getSigningInfo();
                        if (!Intrinsics.areEqual(projectId, signingInfo != null ? signingInfo.getEasProjectId() : null) || !Intrinsics.areEqual(expoProjectInformation.getScopeKey(), updateDirectiveFromJSONString.getSigningInfo().getScopeKey())) {
                            throw new CertificateException("Code signing certificate project ID or scope key does not match project ID or scope key in response part");
                        }
                    }
                }
            }
            return new UpdateResponsePart.DirectiveUpdateResponsePart(UpdateDirective.Companion.fromJSONString(body));
        } catch (Exception e) {
            this.logger.error("Code signing verification failed for directive", e, UpdatesErrorCode.UpdateCodeSigningError);
            throw new IOException("Code signing verification failed for directive", e);
        }
    }

    private final UpdateResponsePart.ManifestUpdateResponsePart parseManifest(ResponsePartInfo responsePartInfo, JSONObject jSONObject, String str) {
        return checkCodeSigningAndCreateManifest(responsePartInfo.getBody(), new JSONObject(responsePartInfo.getBody()), responsePartInfo.getResponseHeaderData(), responsePartInfo.getResponsePartHeaderData(), jSONObject, str, this.configuration, this.logger);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0059 A[Catch: Exception -> 0x006a, TryCatch #1 {Exception -> 0x006a, blocks: (B:24:0x0051, B:26:0x0059, B:28:0x0063, B:34:0x006f, B:35:0x007e, B:36:0x007f, B:21:0x004a), top: B:44:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #1 {Exception -> 0x006a, blocks: (B:24:0x0051, B:26:0x0059, B:28:0x0063, B:34:0x006f, B:35:0x007e, B:36:0x007f, B:21:0x004a), top: B:44:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object downloadRemoteUpdate(JSONObject jSONObject, Continuation continuation) throws IOException {
        C10981 c10981;
        FileDownloader fileDownloader;
        Exception exc;
        Response response;
        ResponseBody responseBodyBody;
        String strString;
        if (continuation instanceof C10981) {
            c10981 = (C10981) continuation;
            int i = c10981.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10981.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10981 = new C10981(continuation);
            }
        } else {
            c10981 = new C10981(continuation);
        }
        C10981 c10982 = c10981;
        Object objDownloadData$default = c10982.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10982.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(objDownloadData$default);
                fileDownloader = this;
                response = (Response) objDownloadData$default;
                if (!response.isSuccessful()) {
                    responseBodyBody = response.body();
                    if (responseBodyBody != null || (strString = responseBodyBody.string()) == null) {
                        strString = "Unknown error";
                    }
                    IOException iOException = new IOException(strString);
                    fileDownloader.logger.error("Remote update request not successful", iOException, UpdatesErrorCode.UpdateFailedToLoad);
                    throw new IOException("Remote update request not successful", iOException);
                }
                return parseRemoteUpdateResponse$expo_updates_release(response);
            } catch (Exception e) {
                exc = e;
                fileDownloader = this;
                fileDownloader.logger.error("Failed to download remote update", exc, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to download remote update", exc);
            }
        }
        ResultKt.throwOnFailure(objDownloadData$default);
        try {
            Request requestCreateRequestForRemoteUpdate = createRequestForRemoteUpdate(jSONObject, this.configuration, this.logger);
            c10982.label = 1;
            fileDownloader = this;
            try {
                objDownloadData$default = downloadData$default(fileDownloader, requestCreateRequestForRemoteUpdate, null, c10982, 2, null);
                if (objDownloadData$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                response = (Response) objDownloadData$default;
                if (!response.isSuccessful()) {
                    responseBodyBody = response.body();
                    if (responseBodyBody != null) {
                        strString = "Unknown error";
                    } else {
                        strString = "Unknown error";
                    }
                    IOException iOException2 = new IOException(strString);
                    fileDownloader.logger.error("Remote update request not successful", iOException2, UpdatesErrorCode.UpdateFailedToLoad);
                    throw new IOException("Remote update request not successful", iOException2);
                }
                return parseRemoteUpdateResponse$expo_updates_release(response);
            } catch (Exception e2) {
                e = e2;
                exc = e;
                fileDownloader.logger.error("Failed to download remote update", exc, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to download remote update", exc);
            }
        } catch (Exception e3) {
            e = e3;
            fileDownloader = this;
        }
    }

    public static /* synthetic */ Object downloadAsset$default(FileDownloader fileDownloader, AssetEntity assetEntity, File file, JSONObject jSONObject, UpdateEntity updateEntity, UpdateEntity updateEntity2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 32) != 0) {
            function1 = null;
        }
        return fileDownloader.downloadAsset(assetEntity, file, jSONObject, updateEntity, updateEntity2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object downloadAsset(AssetEntity assetEntity, File file, JSONObject jSONObject, UpdateEntity updateEntity, UpdateEntity updateEntity2, final Function1 function1, Continuation continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        String str;
        AssetEntity assetEntity2 = assetEntity;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release);
                if (assetEntity2.getUrl() == null) {
                    String str2 = "Failed to download asset " + assetEntity.getKey();
                    Exception exc = new Exception("Asset missing URL");
                    this.logger.error(str2, exc, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str2, exc);
                }
                UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
                String strCreateFilenameForAsset = updatesUtils.createFilenameForAsset(assetEntity2);
                if (!updatesUtils.isSafeFilename(strCreateFilenameForAsset)) {
                    String str3 = "Failed to download asset " + assetEntity.getKey();
                    IOException iOException = new IOException("Asset filename \"" + strCreateFilenameForAsset + "\" would resolve outside the updates directory");
                    this.logger.error(str3, iOException, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str3, iOException);
                }
                File file2 = new File(file, strCreateFilenameForAsset);
                if (file2.exists()) {
                    assetEntity2.setRelativePath(strCreateFilenameForAsset);
                    return new AssetDownloadResult(assetEntity2, false);
                }
                boolean z = (!assetEntity2.isLaunchAsset() || updateEntity == null || updateEntity2 == null || Intrinsics.areEqual(updateEntity.getId(), updateEntity2.getId())) ? false : true;
                try {
                    Request requestCreateRequestForAsset = createRequestForAsset(assetEntity2, jSONObject, this.configuration, z);
                    String expectedHash = assetEntity2.getExpectedHash();
                    FileDownloadProgressListener fileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0 = function1 != null ? new FileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0(new Function1() { // from class: expo.modules.updates.loader.FileDownloader$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FileDownloader.downloadAsset$lambda$24$lambda$23(function1, ((Double) obj).doubleValue());
                        }
                    }) : null;
                    anonymousClass2.L$0 = assetEntity2;
                    anonymousClass2.L$1 = strCreateFilenameForAsset;
                    anonymousClass2.label = 1;
                    str = strCreateFilenameForAsset;
                    objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release = downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(assetEntity2, jSONObject, requestCreateRequestForAsset, expectedHash, file2, file, fileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0, z, updateEntity, updateEntity2, anonymousClass2);
                    if (objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    assetEntity2 = assetEntity;
                } catch (Exception e) {
                    e = e;
                    assetEntity2 = assetEntity;
                    String str4 = "Failed to download asset " + assetEntity2.getKey();
                    this.logger.error(str4, e, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str4, e);
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) anonymousClass2.L$1;
                assetEntity2 = (AssetEntity) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release);
            }
            assetEntity2.setDownloadTime(new Date());
            assetEntity2.setRelativePath(str);
            assetEntity2.setHash(((FileDownloadResult) objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release).getHash());
            return new AssetDownloadResult(assetEntity2, true);
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadAsset$lambda$24$lambda$23(Function1 function1, double d) {
        function1.invoke(Double.valueOf(d));
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object downloadData$default(FileDownloader fileDownloader, Request request, FileDownloadProgressListener fileDownloadProgressListener, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDownloadProgressListener = null;
        }
        return fileDownloader.downloadData(request, fileDownloadProgressListener, continuation);
    }

    private final Cache getCache() {
        return new Cache(getCacheDirectory(), 52428800);
    }

    private final File getCacheDirectory() {
        return new File(this.filesDirectory, "okhttp");
    }

    public final Request createRequestForAsset(AssetEntity assetEntity, JSONObject extraHeaders, UpdatesConfiguration configuration, boolean z) {
        Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Request.Builder builder = new Request.Builder();
        Uri url = assetEntity.getUrl();
        Intrinsics.checkNotNull(url);
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Request.Builder builderHeader = addHeadersFromJSONObject(addHeadersFromJSONObject(builder.url(string), assetEntity.getExtraRequestHeaders()), extraHeaders).header("Expo-Platform", "android").header("Expo-Protocol-Version", "1").header("Expo-API-Version", "1").header("Expo-Updates-Environment", "BARE").header("EAS-Client-ID", this.easClientID);
        boolean z2 = z && assetEntity.isLaunchAsset() && configuration.getEnableBsdiffPatchSupport();
        extraHeaders.optString("Expo-Current-Update-ID", "");
        extraHeaders.optString("Expo-Requested-Update-ID", "");
        builderHeader.header("Accept", "*/*");
        if (z2) {
            builderHeader.header("A-IM", "bsdiff");
        } else {
            builderHeader.removeHeader("A-IM");
        }
        for (Map.Entry entry : configuration.getRequestHeaders().entrySet()) {
            builderHeader.header((String) entry.getKey(), (String) entry.getValue());
        }
        return builderHeader.build();
    }

    private final UpdateResponsePart.ManifestUpdateResponsePart checkCodeSigningAndCreateManifest(String str, JSONObject jSONObject, ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, JSONObject jSONObject2, String str2, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger) throws Exception {
        jSONObject.put("isVerified", false);
        try {
            CodeSigningConfiguration codeSigningConfiguration = updatesConfiguration.getCodeSigningConfiguration();
            if (codeSigningConfiguration != null) {
                String signature = responsePartHeaderData.getSignature();
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SignatureValidationResult signatureValidationResultValidateSignature = codeSigningConfiguration.validateSignature(signature, bytes, str2);
                if (signatureValidationResultValidateSignature.getValidationResult() == ValidationResult.INVALID) {
                    throw new IOException("Incorrect signature");
                }
                if (signatureValidationResultValidateSignature.getValidationResult() != ValidationResult.SKIPPED) {
                    Manifest manifest = UpdateFactory.INSTANCE.getUpdate(jSONObject, responseHeaderData, jSONObject2, updatesConfiguration).getManifest();
                    ExpoProjectInformation expoProjectInformation = signatureValidationResultValidateSignature.getExpoProjectInformation();
                    if (expoProjectInformation != null && (!Intrinsics.areEqual(expoProjectInformation.getProjectId(), manifest.getEASProjectID()) || !Intrinsics.areEqual(expoProjectInformation.getScopeKey(), manifest.getScopeKey()))) {
                        throw new CertificateException("Code signing certificate project ID or scope key does not match project ID or scope key in response");
                    }
                    UpdatesLogger.info$default(updatesLogger, "Manifest code signing signature verified successfully", null, 2, null);
                    jSONObject.put("isVerified", true);
                }
            }
            Update update = UpdateFactory.INSTANCE.getUpdate(jSONObject, responseHeaderData, jSONObject2, updatesConfiguration);
            SelectionPolicies selectionPolicies = SelectionPolicies.INSTANCE;
            UpdateEntity updateEntity = update.getUpdateEntity();
            Intrinsics.checkNotNull(updateEntity);
            if (!selectionPolicies.matchesFilters(updateEntity, responseHeaderData.getManifestFilters())) {
                throw new Exception("Manifest filters do not match manifest content for downloaded manifest");
            }
            return new UpdateResponsePart.ManifestUpdateResponsePart(update);
        } catch (Exception e) {
            updatesLogger.error("Code signing verification failed for manifest", e, UpdatesErrorCode.UpdateCodeSigningError);
            throw new IOException("Code signing verification failed for manifest", e);
        }
    }

    private final Request.Builder addHeadersFromJSONObject(Request.Builder builder, JSONObject jSONObject) throws JSONException {
        Object jSONObject2;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            for (String str : SequencesKt.asSequence(itKeys)) {
                Intrinsics.checkNotNull(str);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    jSONObject2 = jSONObject.getString(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jSONObject2 = Double.valueOf(jSONObject.getDouble(str));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jSONObject2 = Integer.valueOf(jSONObject.getInt(str));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jSONObject2 = Long.valueOf(jSONObject.getLong(str));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jSONObject2 = Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    jSONObject2 = jSONObject.getJSONArray(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject2 = jSONObject.getJSONObject(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                } else {
                    jSONObject2 = jSONObject.get(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                }
                builder.header(str, jSONObject2.toString());
            }
        }
        return builder;
    }

    public final Request createRequestForRemoteUpdate(JSONObject jSONObject, UpdatesConfiguration configuration, UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Request.Builder builder = new Request.Builder();
        String string = configuration.getUpdateUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Request.Builder builderHeader = addHeadersFromJSONObject(builder.url(string), jSONObject).header("Accept", "multipart/mixed,application/expo+json,application/json").header("Expo-Platform", "android").header("Expo-Protocol-Version", "1").header("Expo-API-Version", "1").header("Expo-Updates-Environment", "BARE").header("Expo-JSON-Error", b.af).header("EAS-Client-ID", this.easClientID);
        String runtimeVersionRaw = configuration.getRuntimeVersionRaw();
        if (runtimeVersionRaw != null && runtimeVersionRaw.length() != 0) {
            builderHeader.header("Expo-Runtime-Version", runtimeVersionRaw);
        }
        String strConsumeErrorLog = NoDatabaseLauncher.Companion.consumeErrorLog(this.filesDirectory, logger);
        if (strConsumeErrorLog != null) {
            String strSubstring = strConsumeErrorLog.substring(0, Math.min(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, strConsumeErrorLog.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            builderHeader.header("Expo-Fatal-Error", strSubstring);
        }
        for (Map.Entry entry : configuration.getRequestHeaders().entrySet()) {
            builderHeader.header((String) entry.getKey(), (String) entry.getValue());
        }
        CodeSigningConfiguration codeSigningConfiguration = configuration.getCodeSigningConfiguration();
        if (codeSigningConfiguration != null) {
            builderHeader.header("expo-expect-signature", codeSigningConfiguration.getAcceptSignatureHeader());
        }
        return builderHeader.build();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject getExtraHeadersForRemoteUpdateRequest(UpdatesDatabase database, UpdatesConfiguration configuration, UpdateEntity updateEntity, UpdateEntity updateEntity2) throws JSONException {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            JSONObject serverDefinedHeaders = ManifestMetadata.getServerDefinedHeaders(database, configuration);
            if (serverDefinedHeaders == null) {
                serverDefinedHeaders = new JSONObject();
            }
            Map extraParams = ManifestMetadata.INSTANCE.getExtraParams(database, configuration);
            if (extraParams != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(extraParams.size()));
                for (Map.Entry entry : extraParams.entrySet()) {
                    linkedHashMap.put(entry.getKey(), StringItem.valueOf((String) entry.getValue()));
                }
                serverDefinedHeaders.put("Expo-Extra-Params", Dictionary.valueOf(linkedHashMap).serialize());
            }
            if (updateEntity != null) {
                String string = updateEntity.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                serverDefinedHeaders.put("Expo-Current-Update-ID", lowerCase);
            }
            if (updateEntity2 != null) {
                String string2 = updateEntity2.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                serverDefinedHeaders.put("Expo-Embedded-Update-ID", lowerCase2);
            }
            List listLoadRecentUpdateIdsWithFailedLaunch = database.updateDao().loadRecentUpdateIdsWithFailedLaunch();
            if (!listLoadRecentUpdateIdsWithFailedLaunch.isEmpty()) {
                List list = listLoadRecentUpdateIdsWithFailedLaunch;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringItem.valueOf(((UUID) it.next()).toString()));
                }
                serverDefinedHeaders.put("Expo-Recent-Failed-Update-IDs", OuterList.valueOf(arrayList).serialize());
            }
            return serverDefinedHeaders;
        }

        public final JSONObject getExtraHeadersForRemoteAssetRequest(UpdateEntity updateEntity, UpdateEntity updateEntity2, UpdateEntity updateEntity3) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (updateEntity != null) {
                String string = updateEntity.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                jSONObject.put("Expo-Current-Update-ID", lowerCase);
            }
            if (updateEntity2 != null) {
                String string2 = updateEntity2.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                jSONObject.put("Expo-Embedded-Update-ID", lowerCase2);
            }
            if (updateEntity3 != null) {
                String string3 = updateEntity3.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                String lowerCase3 = string3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                jSONObject.put("Expo-Requested-Update-ID", lowerCase3);
            }
            return jSONObject;
        }
    }
}
