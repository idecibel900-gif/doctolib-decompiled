package expo.modules.updates.launcher;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b.f;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.AssetDao;
import expo.modules.updates.db.dao.UpdateDao;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderFiles;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DatabaseLauncher implements Launcher {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = DatabaseLauncher.class.getSimpleName();
    private String bundleAssetName;
    private final UpdatesConfiguration configuration;
    private final Context context;
    private final FileDownloader fileDownloader;
    private boolean hasLaunched;
    private Exception launchAssetException;
    private String launchAssetFile;
    private UpdateEntity launchedUpdate;
    private final LoaderFiles loaderFiles;
    private Map localAssetFiles;
    private final UpdatesLogger logger;
    private final CoroutineScope scope;
    private final SelectionPolicy selectionPolicy;
    private final boolean shouldCopyEmbeddedAssets;
    private final File updatesDirectory;

    /* JADX INFO: renamed from: expo.modules.updates.launcher.DatabaseLauncher$ensureAssetExists$1, reason: invalid class name */
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
            return DatabaseLauncher.this.ensureAssetExists(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.launcher.DatabaseLauncher$launch$1, reason: invalid class name and case insensitive filesystem */
    static final class C10971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DatabaseLauncher.this.launch(null, this);
        }
    }

    public DatabaseLauncher(Context context, UpdatesConfiguration configuration, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.configuration = configuration;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.scope = scope;
        this.shouldCopyEmbeddedAssets = z;
        this.loaderFiles = new LoaderFiles();
    }

    public /* synthetic */ DatabaseLauncher(Context context, UpdatesConfiguration updatesConfiguration, File file, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger updatesLogger, CoroutineScope coroutineScope, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, file, fileDownloader, selectionPolicy, updatesLogger, coroutineScope, (i & 128) != 0 ? false : z);
    }

    @Override // expo.modules.updates.launcher.Launcher
    public UpdateEntity getLaunchedUpdate() {
        return this.launchedUpdate;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getLaunchAssetFile() {
        return this.launchAssetFile;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getBundleAssetName() {
        return this.bundleAssetName;
    }

    @Override // expo.modules.updates.launcher.Launcher
    /* JADX INFO: renamed from: getLocalAssetFiles */
    public Map mo4981getLocalAssetFiles() {
        return this.localAssetFiles;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public boolean isUsingEmbeddedAssets() {
        return mo4981getLocalAssetFiles() == null;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x01f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x01b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x013e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0164  */
    /* JADX WARN: Code duplicated, block: B:67:0x0190  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x021c  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0221  */
    public final Object launch(UpdatesDatabase updatesDatabase, Continuation continuation) throws Exception {
        C10971 c10971;
        Object obj;
        UpdatesDatabase updatesDatabase2;
        DatabaseLauncher databaseLauncher;
        String str;
        JSONObject jSONObject;
        EmbeddedUpdate embeddedUpdate;
        UpdatesDatabase updatesDatabase3;
        AssetEntity assetEntity;
        List assetEntityList;
        Object next;
        String embeddedAssetFilename;
        Exception exc;
        Map mapEmbeddedAssetFileMap;
        ArrayList arrayList;
        DatabaseLauncher databaseLauncher2;
        Map map;
        Map map2;
        String relativePath;
        AssetEntity assetEntity2;
        File file;
        DatabaseLauncher databaseLauncher3 = this;
        if (continuation instanceof C10971) {
            c10971 = (C10971) continuation;
            int i = c10971.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10971.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10971 = databaseLauncher3.new C10971(continuation);
            }
        } else {
            c10971 = databaseLauncher3.new C10971(continuation);
        }
        C10971 c10972 = c10971;
        Object objAwaitAll = c10972.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10972.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitAll);
            if (databaseLauncher3.hasLaunched) {
                throw new AssertionError("DatabaseLauncher has already started. Create a new instance in order to launch a new version.");
            }
            databaseLauncher3.hasLaunched = true;
            c10972.L$0 = updatesDatabase;
            c10972.L$1 = databaseLauncher3;
            c10972.label = 1;
            Object launchableUpdate = databaseLauncher3.getLaunchableUpdate(updatesDatabase, c10972);
            if (launchableUpdate != coroutine_suspended) {
                obj = launchableUpdate;
                updatesDatabase2 = updatesDatabase;
                databaseLauncher = databaseLauncher3;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            databaseLauncher = (DatabaseLauncher) c10972.L$1;
            UpdatesDatabase updatesDatabase4 = (UpdatesDatabase) c10972.L$0;
            ResultKt.throwOnFailure(objAwaitAll);
            obj = objAwaitAll;
            updatesDatabase2 = updatesDatabase4;
        } else {
            if (i2 == 2) {
                JSONObject jSONObject2 = (JSONObject) c10972.L$3;
                EmbeddedUpdate embeddedUpdate2 = (EmbeddedUpdate) c10972.L$2;
                AssetEntity assetEntity3 = (AssetEntity) c10972.L$1;
                UpdatesDatabase updatesDatabase5 = (UpdatesDatabase) c10972.L$0;
                ResultKt.throwOnFailure(objAwaitAll);
                assetEntity = assetEntity3;
                jSONObject = jSONObject2;
                embeddedUpdate = embeddedUpdate2;
                updatesDatabase3 = updatesDatabase5;
                if (objAwaitAll != null) {
                    databaseLauncher3.launchAssetFile = objAwaitAll.toString();
                    AssetDao assetDao = updatesDatabase3.assetDao();
                    UpdateEntity launchedUpdate = databaseLauncher3.getLaunchedUpdate();
                    Intrinsics.checkNotNull(launchedUpdate);
                    List<AssetEntity> listLoadAssetsForUpdate = assetDao.loadAssetsForUpdate(launchedUpdate.getId());
                    mapEmbeddedAssetFileMap = databaseLauncher3.embeddedAssetFileMap();
                    arrayList = new ArrayList();
                    for (AssetEntity assetEntity4 : listLoadAssetsForUpdate) {
                        if (assetEntity4.getId() != assetEntity.getId() && (relativePath = assetEntity4.getRelativePath()) != null) {
                            if (!AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                                DatabaseLauncher databaseLauncher4 = databaseLauncher3;
                                databaseLauncher3 = databaseLauncher4;
                                Boxing.boxBoolean(arrayList.add(BuildersKt__Builders_commonKt.async$default(databaseLauncher3.scope, null, null, new DatabaseLauncher$launch$2$job$1(databaseLauncher4, assetEntity4, updatesDatabase3, embeddedUpdate, jSONObject, null), 3, null)));
                            } else {
                                mapEmbeddedAssetFileMap.put(assetEntity4, relativePath);
                            }
                        }
                    }
                    c10972.L$0 = mapEmbeddedAssetFileMap;
                    c10972.L$1 = mapEmbeddedAssetFileMap;
                    c10972.L$2 = databaseLauncher3;
                    c10972.L$3 = null;
                    c10972.label = 3;
                    objAwaitAll = AwaitKt.awaitAll(arrayList, c10972);
                    if (objAwaitAll != coroutine_suspended) {
                        databaseLauncher2 = databaseLauncher3;
                        map = mapEmbeddedAssetFileMap;
                        map2 = map;
                    }
                    return coroutine_suspended;
                }
                exc = databaseLauncher3.launchAssetException;
                if (exc != null) {
                    throw exc;
                }
                throw new Exception("Launch asset file was null after download attempt");
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            databaseLauncher2 = (DatabaseLauncher) c10972.L$2;
            map = (Map) c10972.L$1;
            map2 = (Map) c10972.L$0;
            ResultKt.throwOnFailure(objAwaitAll);
        }
        for (Pair pair : (Iterable) objAwaitAll) {
            assetEntity2 = (AssetEntity) pair.getFirst();
            file = (File) pair.getSecond();
            if (file != null) {
                map.put(assetEntity2, Uri.fromFile(file).toString());
            }
        }
        databaseLauncher2.localAssetFiles = map2;
        return Unit.INSTANCE;
        databaseLauncher.launchedUpdate = (UpdateEntity) obj;
        if (databaseLauncher3.getLaunchedUpdate() == null) {
            throw new Exception("No launchable update was found. If this is a generic app, ensure expo-updates is configured correctly.");
        }
        UpdateDao updateDao = updatesDatabase2.updateDao();
        UpdateEntity launchedUpdate2 = databaseLauncher3.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate2);
        updateDao.markUpdateAccessed(launchedUpdate2);
        UpdateEntity launchedUpdate3 = databaseLauncher3.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate3);
        if (launchedUpdate3.getStatus() == UpdateStatus.DEVELOPMENT) {
            return Unit.INSTANCE;
        }
        UpdateDao updateDao2 = updatesDatabase2.updateDao();
        UpdateEntity launchedUpdate4 = databaseLauncher3.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate4);
        AssetEntity assetEntityLoadLaunchAssetForUpdate = updateDao2.loadLaunchAssetForUpdate(launchedUpdate4.getId());
        if (assetEntityLoadLaunchAssetForUpdate == null) {
            UpdateEntity launchedUpdate5 = databaseLauncher3.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate5);
            throw new Exception("Launch asset not found for update. The update row has no launch asset; an interrupted registration in an older version of expo-updates can leave an update in this state, and it is replaced once a newer update is downloaded. Debug info: " + launchedUpdate5.debugInfo());
        }
        if (assetEntityLoadLaunchAssetForUpdate.getRelativePath() == null) {
            UpdateEntity launchedUpdate6 = databaseLauncher3.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate6);
            throw new Exception("Launch asset relative path should not be null. Debug info: " + launchedUpdate6.debugInfo());
        }
        EmbeddedUpdate embeddedUpdate3 = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(databaseLauncher3.context, databaseLauncher3.configuration);
        JSONObject extraHeadersForRemoteAssetRequest = FileDownloader.Companion.getExtraHeadersForRemoteAssetRequest(databaseLauncher3.getLaunchedUpdate(), embeddedUpdate3 != null ? embeddedUpdate3.getUpdateEntity() : null, null);
        if (databaseLauncher3.shouldCopyEmbeddedAssets || embeddedUpdate3 == null || (assetEntityList = embeddedUpdate3.getAssetEntityList()) == null) {
            str = null;
        } else {
            Iterator it = assetEntityList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AssetEntity) next).getKey(), assetEntityLoadLaunchAssetForUpdate.getKey()));
            AssetEntity assetEntity5 = (AssetEntity) next;
            if (assetEntity5 == null || (embeddedAssetFilename = assetEntity5.getEmbeddedAssetFilename()) == null) {
                str = null;
            } else {
                str = "assets://" + embeddedAssetFilename;
            }
        }
        if (str == null) {
            c10972.L$0 = updatesDatabase2;
            c10972.L$1 = assetEntityLoadLaunchAssetForUpdate;
            c10972.L$2 = embeddedUpdate3;
            c10972.L$3 = extraHeadersForRemoteAssetRequest;
            c10972.label = 2;
            Object objEnsureAssetExists = databaseLauncher3.ensureAssetExists(assetEntityLoadLaunchAssetForUpdate, updatesDatabase2, embeddedUpdate3, extraHeadersForRemoteAssetRequest, c10972);
            if (objEnsureAssetExists != coroutine_suspended) {
                assetEntity = assetEntityLoadLaunchAssetForUpdate;
                jSONObject = extraHeadersForRemoteAssetRequest;
                embeddedUpdate = embeddedUpdate3;
                updatesDatabase3 = updatesDatabase2;
                objAwaitAll = objEnsureAssetExists;
            }
            return coroutine_suspended;
        }
        jSONObject = extraHeadersForRemoteAssetRequest;
        embeddedUpdate = embeddedUpdate3;
        updatesDatabase3 = updatesDatabase2;
        objAwaitAll = str;
        assetEntity = assetEntityLoadLaunchAssetForUpdate;
        if (objAwaitAll != null) {
            databaseLauncher3.launchAssetFile = objAwaitAll.toString();
            AssetDao assetDao2 = updatesDatabase3.assetDao();
            UpdateEntity launchedUpdate7 = databaseLauncher3.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate7);
            List<AssetEntity> listLoadAssetsForUpdate2 = assetDao2.loadAssetsForUpdate(launchedUpdate7.getId());
            mapEmbeddedAssetFileMap = databaseLauncher3.embeddedAssetFileMap();
            arrayList = new ArrayList();
            while (r14.hasNext()) {
                if (assetEntity4.getId() != assetEntity.getId()) {
                    if (!AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                        DatabaseLauncher databaseLauncher5 = databaseLauncher3;
                        databaseLauncher3 = databaseLauncher5;
                        Boxing.boxBoolean(arrayList.add(BuildersKt__Builders_commonKt.async$default(databaseLauncher3.scope, null, null, new DatabaseLauncher$launch$2$job$1(databaseLauncher5, assetEntity4, updatesDatabase3, embeddedUpdate, jSONObject, null), 3, null)));
                    } else {
                        mapEmbeddedAssetFileMap.put(assetEntity4, relativePath);
                    }
                }
            }
            c10972.L$0 = mapEmbeddedAssetFileMap;
            c10972.L$1 = mapEmbeddedAssetFileMap;
            c10972.L$2 = databaseLauncher3;
            c10972.L$3 = null;
            c10972.label = 3;
            objAwaitAll = AwaitKt.awaitAll(arrayList, c10972);
            if (objAwaitAll != coroutine_suspended) {
                databaseLauncher2 = databaseLauncher3;
                map = mapEmbeddedAssetFileMap;
                map2 = map;
                while (r2.hasNext()) {
                    assetEntity2 = (AssetEntity) pair.getFirst();
                    file = (File) pair.getSecond();
                    if (file != null) {
                        map.put(assetEntity2, Uri.fromFile(file).toString());
                    }
                }
                databaseLauncher2.localAssetFiles = map2;
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        exc = databaseLauncher3.launchAssetException;
        if (exc != null) {
            throw exc;
        }
        throw new Exception("Launch asset file was null after download attempt");
    }

    public final Object getLaunchableUpdate(UpdatesDatabase updatesDatabase, Continuation continuation) {
        UpdateEntity updateEntity;
        UpdateEntity updateEntity2;
        List<UpdateEntity> listLoadLaunchableUpdatesForScope = updatesDatabase.updateDao().loadLaunchableUpdatesForScope(this.configuration.getScopeKey());
        EmbeddedUpdate originalEmbeddedUpdate = EmbeddedManifestUtils.INSTANCE.getOriginalEmbeddedUpdate(this.context, this.configuration);
        ArrayList arrayList = new ArrayList();
        for (UpdateEntity updateEntity3 : listLoadLaunchableUpdatesForScope) {
            if (updateEntity3.getStatus() == UpdateStatus.EMBEDDED) {
                if (!Intrinsics.areEqual((originalEmbeddedUpdate == null || (updateEntity2 = originalEmbeddedUpdate.getUpdateEntity()) == null) ? null : updateEntity2.getId(), updateEntity3.getId())) {
                }
            }
            if (!this.configuration.getHasEmbeddedUpdate()) {
                if (Intrinsics.areEqual((originalEmbeddedUpdate == null || (updateEntity = originalEmbeddedUpdate.getUpdateEntity()) == null) ? null : updateEntity.getId(), updateEntity3.getId())) {
                }
            }
            if (updateEntity3.getStatus() != UpdateStatus.DEVELOPMENT && updatesDatabase.updateDao().loadLaunchAssetForUpdate(updateEntity3.getId()) == null) {
                UpdatesLogger.warn$default(this.logger, "Skipping launchable update with no launch asset. Debug info: " + updateEntity3.debugInfo(), null, 2, null);
            } else {
                arrayList.add(updateEntity3);
            }
        }
        return this.selectionPolicy.selectUpdateToLaunch(arrayList, ManifestMetadata.INSTANCE.getManifestFilters(updatesDatabase, this.configuration));
    }

    private final Map embeddedAssetFileMap() {
        List<AssetEntity> listEmptyList;
        EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(this.context, this.configuration);
        if (embeddedUpdate == null || (listEmptyList = embeddedUpdate.getAssetEntityList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: embeddedAssets count = " + listEmptyList.size(), null, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AssetEntity assetEntity : listEmptyList) {
            if (!assetEntity.isLaunchAsset()) {
                if (!this.shouldCopyEmbeddedAssets) {
                    String strCreateEmbeddedFilenameForAsset = AndroidResourceAssetUtils.INSTANCE.createEmbeddedFilenameForAsset(assetEntity);
                    if (strCreateEmbeddedFilenameForAsset != null) {
                        assetEntity.setRelativePath(strCreateEmbeddedFilenameForAsset);
                        linkedHashMap.put(assetEntity, strCreateEmbeddedFilenameForAsset);
                        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: " + assetEntity.getKey() + f.a + assetEntity.getType() + " => " + linkedHashMap.get(assetEntity), null, 2, null);
                    } else {
                        Exception exc = new Exception("Missing embedded asset");
                        this.logger.error("embeddedAssetFileMap: no file for " + assetEntity.getKey() + f.a + assetEntity.getType(), exc, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                } else {
                    String strCreateFilenameForAsset = UpdatesUtils.INSTANCE.createFilenameForAsset(assetEntity);
                    assetEntity.setRelativePath(strCreateFilenameForAsset);
                    File file = new File(this.updatesDirectory, strCreateFilenameForAsset);
                    if (!file.exists()) {
                        this.loaderFiles.copyAssetAndGetHash(assetEntity, file, this.context);
                    }
                    if (file.exists()) {
                        linkedHashMap.put(assetEntity, Uri.fromFile(file).toString());
                        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: " + assetEntity.getKey() + f.a + assetEntity.getType() + " => " + linkedHashMap.get(assetEntity), null, 2, null);
                    } else {
                        Exception exc2 = new Exception("Missing embedded asset");
                        this.logger.error("embeddedAssetFileMap: no file for " + assetEntity.getKey() + f.a + assetEntity.getType(), exc2, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0104  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object ensureAssetExists(AssetEntity assetEntity, UpdatesDatabase updatesDatabase, EmbeddedUpdate embeddedUpdate, JSONObject jSONObject, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        UpdatesDatabase updatesDatabase2;
        AssetEntity assetEntity2;
        AssetEntity assetEntity3;
        Exception e;
        Exception exc;
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
        Object objDownloadAsset$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        File file = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDownloadAsset$default);
            File file2 = this.updatesDirectory;
            String relativePath = assetEntity.getRelativePath();
            if (relativePath == null) {
                relativePath = "";
            }
            File file3 = new File(file2, relativePath);
            boolean zExists = file3.exists();
            if (!zExists && embeddedUpdate != null) {
                Iterator it = embeddedUpdate.getAssetEntityList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        assetEntity2 = null;
                        break;
                    }
                    assetEntity2 = (AssetEntity) it.next();
                    if (assetEntity2.getKey() != null && Intrinsics.areEqual(assetEntity2.getKey(), assetEntity.getKey())) {
                        break;
                    }
                }
                if (assetEntity2 != null) {
                    try {
                        if (Arrays.equals(this.loaderFiles.copyAssetAndGetHash(assetEntity2, file3, this.context), assetEntity.getHash())) {
                            zExists = true;
                        }
                    } catch (Exception e2) {
                        this.logger.error("Failed to copy matching embedded asset", e2, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                }
            }
            if (zExists) {
                return file3;
            }
            try {
                FileDownloader fileDownloader = this.fileDownloader;
                File file4 = this.updatesDirectory;
                UpdateEntity launchedUpdate = getLaunchedUpdate();
                anonymousClass2.L$0 = assetEntity;
                updatesDatabase2 = updatesDatabase;
                anonymousClass2.L$1 = updatesDatabase2;
                anonymousClass2.label = 1;
                objDownloadAsset$default = FileDownloader.downloadAsset$default(fileDownloader, assetEntity, file4, jSONObject, launchedUpdate, null, null, anonymousClass2, 32, null);
                if (objDownloadAsset$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e3) {
                e = e3;
                assetEntity3 = assetEntity;
                exc = e;
                this.logger.error("Failed to load asset from disk or network", exc, UpdatesErrorCode.AssetsFailedToLoad);
                if (assetEntity3.isLaunchAsset()) {
                    this.launchAssetException = exc;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            UpdatesDatabase updatesDatabase3 = (UpdatesDatabase) anonymousClass2.L$1;
            assetEntity3 = (AssetEntity) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(objDownloadAsset$default);
                updatesDatabase2 = updatesDatabase3;
            } catch (Exception e4) {
                e = e4;
                exc = e;
                this.logger.error("Failed to load asset from disk or network", exc, UpdatesErrorCode.AssetsFailedToLoad);
                if (assetEntity3.isLaunchAsset()) {
                    this.launchAssetException = exc;
                }
            }
        }
        FileDownloader.AssetDownloadResult assetDownloadResult = (FileDownloader.AssetDownloadResult) objDownloadAsset$default;
        updatesDatabase2.assetDao().updateAsset(assetDownloadResult.getAssetEntity());
        File file5 = this.updatesDirectory;
        String relativePath2 = assetDownloadResult.getAssetEntity().getRelativePath();
        Intrinsics.checkNotNull(relativePath2);
        File file6 = new File(file5, relativePath2);
        if (file6.exists()) {
            file = file6;
        }
        return file;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
