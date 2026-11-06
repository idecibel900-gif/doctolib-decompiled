package expo.modules.updates.loader;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.UpdateDao;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;

/* JADX INFO: loaded from: classes5.dex */
public final class RemoteLoader extends Loader {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = RemoteLoader.class.getSimpleName();
    private final UpdateEntity launchedUpdate;
    private final LoaderFiles loaderFiles;
    private final FileDownloader mFileDownloader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, FileDownloader mFileDownloader, File updatesDirectory, UpdateEntity updateEntity, LoaderFiles loaderFiles, CoroutineScope scope) {
        super(context, configuration, logger, database, updatesDirectory, loaderFiles, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(mFileDownloader, "mFileDownloader");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(loaderFiles, "loaderFiles");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.mFileDownloader = mFileDownloader;
        this.launchedUpdate = updateEntity;
        this.loaderFiles = loaderFiles;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RemoteLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, FileDownloader fileDownloader, File updatesDirectory, UpdateEntity updateEntity, CoroutineScope scope) {
        this(context, configuration, logger, database, fileDownloader, updatesDirectory, updateEntity, new LoaderFiles(), scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadRemoteUpdate(UpdatesDatabase updatesDatabase, UpdatesConfiguration updatesConfiguration, Continuation continuation) {
        Update embeddedUpdate = this.loaderFiles.readEmbeddedUpdate(getContext(), updatesConfiguration);
        return this.mFileDownloader.downloadRemoteUpdate(FileDownloader.Companion.getExtraHeadersForRemoteUpdateRequest(updatesDatabase, updatesConfiguration, this.launchedUpdate, embeddedUpdate != null ? embeddedUpdate.getUpdateEntity() : null), continuation);
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadAsset(final AssetEntity assetEntity, File file, UpdatesConfiguration updatesConfiguration, UpdateEntity updateEntity, UpdateEntity updateEntity2, Continuation continuation) throws JSONException {
        return this.mFileDownloader.downloadAsset(assetEntity, file, FileDownloader.Companion.getExtraHeadersForRemoteAssetRequest(this.launchedUpdate, updateEntity2, updateEntity), this.launchedUpdate, updateEntity, new Function1() { // from class: expo.modules.updates.loader.RemoteLoader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteLoader.loadAsset$lambda$0(this.f$0, assetEntity, ((Double) obj).doubleValue());
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadAsset$lambda$0(RemoteLoader remoteLoader, AssetEntity assetEntity, double d) {
        remoteLoader.assetLoadProgressListener(assetEntity, d);
        return Unit.INSTANCE;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0016  */
        public final Object processSuccessLoaderResult(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, SelectionPolicy selectionPolicy, File file, UpdateEntity updateEntity, Loader.LoaderResult loaderResult, Continuation continuation) {
            RemoteLoader$Companion$processSuccessLoaderResult$1 remoteLoader$Companion$processSuccessLoaderResult$1;
            if (continuation instanceof RemoteLoader$Companion$processSuccessLoaderResult$1) {
                remoteLoader$Companion$processSuccessLoaderResult$1 = (RemoteLoader$Companion$processSuccessLoaderResult$1) continuation;
                int i = remoteLoader$Companion$processSuccessLoaderResult$1.label;
                if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                    remoteLoader$Companion$processSuccessLoaderResult$1.label = i - LinearLayoutManager.INVALID_OFFSET;
                } else {
                    remoteLoader$Companion$processSuccessLoaderResult$1 = new RemoteLoader$Companion$processSuccessLoaderResult$1(this, continuation);
                }
            } else {
                remoteLoader$Companion$processSuccessLoaderResult$1 = new RemoteLoader$Companion$processSuccessLoaderResult$1(this, continuation);
            }
            RemoteLoader$Companion$processSuccessLoaderResult$1 remoteLoader$Companion$processSuccessLoaderResult$2 = remoteLoader$Companion$processSuccessLoaderResult$1;
            Object objProcessRollBackToEmbeddedDirective = remoteLoader$Companion$processSuccessLoaderResult$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = remoteLoader$Companion$processSuccessLoaderResult$2.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objProcessRollBackToEmbeddedDirective);
                UpdateEntity updateEntity2 = loaderResult.getUpdateEntity();
                UpdateDirective updateDirective = loaderResult.getUpdateDirective();
                if (updateDirective != null && (updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective)) {
                    remoteLoader$Companion$processSuccessLoaderResult$2.label = 1;
                    objProcessRollBackToEmbeddedDirective = processRollBackToEmbeddedDirective(context, updatesConfiguration, updatesLogger, updatesDatabase, selectionPolicy, file, updateEntity, (UpdateDirective.RollBackToEmbeddedUpdateDirective) updateDirective, remoteLoader$Companion$processSuccessLoaderResult$2);
                    if (objProcessRollBackToEmbeddedDirective == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return new ProcessSuccessLoaderResult(updateEntity2, false);
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objProcessRollBackToEmbeddedDirective);
            }
            return new ProcessSuccessLoaderResult(null, ((Boolean) objProcessRollBackToEmbeddedDirective).booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        public final Object processRollBackToEmbeddedDirective(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, SelectionPolicy selectionPolicy, File file, UpdateEntity updateEntity, UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective, Continuation continuation) {
            RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 remoteLoader$Companion$processRollBackToEmbeddedDirective$1;
            UpdatesLogger updatesLogger2;
            Exception exc;
            UpdatesLogger updatesLogger3;
            UpdatesDatabase updatesDatabase2;
            UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective2;
            if (continuation instanceof RemoteLoader$Companion$processRollBackToEmbeddedDirective$1) {
                remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = (RemoteLoader$Companion$processRollBackToEmbeddedDirective$1) continuation;
                int i = remoteLoader$Companion$processRollBackToEmbeddedDirective$1.label;
                if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                    remoteLoader$Companion$processRollBackToEmbeddedDirective$1.label = i - LinearLayoutManager.INVALID_OFFSET;
                } else {
                    remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = new RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(this, continuation);
                }
            } else {
                remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = new RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(this, continuation);
            }
            RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 remoteLoader$Companion$processRollBackToEmbeddedDirective$2 = remoteLoader$Companion$processRollBackToEmbeddedDirective$1;
            Object objLoad = remoteLoader$Companion$processRollBackToEmbeddedDirective$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = remoteLoader$Companion$processRollBackToEmbeddedDirective$2.label;
            boolean z = false;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objLoad);
                if (!updatesConfiguration.getHasEmbeddedUpdate()) {
                    return Boxing.boxBoolean(false);
                }
                EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(context, updatesConfiguration);
                Intrinsics.checkNotNull(embeddedUpdate);
                UpdateEntity updateEntity2 = embeddedUpdate.getUpdateEntity();
                if (!selectionPolicy.shouldLoadRollBackToEmbeddedDirective(rollBackToEmbeddedUpdateDirective, updateEntity2, updateEntity, ManifestMetadata.INSTANCE.getManifestFilters(updatesDatabase, updatesConfiguration))) {
                    return Boxing.boxBoolean(false);
                }
                updateEntity2.setCommitTime(rollBackToEmbeddedUpdateDirective.getCommitTime());
                try {
                    updatesLogger2 = updatesLogger;
                    try {
                        EmbeddedLoader embeddedLoader = new EmbeddedLoader(context, updatesConfiguration, updatesLogger2, updatesDatabase, file, (CoroutineScope) null, 32, (DefaultConstructorMarker) null);
                        Function1 function1 = new Function1() { // from class: expo.modules.updates.loader.RemoteLoader$Companion$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RemoteLoader.Companion.processRollBackToEmbeddedDirective$lambda$0((UpdateResponse) obj);
                            }
                        };
                        updatesLogger2 = updatesLogger;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$0 = updatesLogger2;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$1 = updatesDatabase;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$2 = rollBackToEmbeddedUpdateDirective;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.label = 1;
                        objLoad = embeddedLoader.load(function1, remoteLoader$Companion$processRollBackToEmbeddedDirective$2);
                        if (objLoad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        updatesLogger3 = updatesLogger2;
                        updatesDatabase2 = updatesDatabase;
                        rollBackToEmbeddedUpdateDirective2 = rollBackToEmbeddedUpdateDirective;
                    } catch (Exception e) {
                        e = e;
                        exc = e;
                        updatesLogger2.error("Embedded update erroneously null when applying roll back to embedded directive", exc, UpdatesErrorCode.UpdateFailedToLoad);
                    }
                } catch (Exception e2) {
                    e = e2;
                    updatesLogger2 = updatesLogger;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rollBackToEmbeddedUpdateDirective2 = (UpdateDirective.RollBackToEmbeddedUpdateDirective) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$2;
                updatesDatabase2 = (UpdatesDatabase) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$1;
                updatesLogger3 = (UpdatesLogger) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$0;
                try {
                    ResultKt.throwOnFailure(objLoad);
                } catch (Exception e3) {
                    exc = e3;
                    updatesLogger2 = updatesLogger3;
                    updatesLogger2.error("Embedded update erroneously null when applying roll back to embedded directive", exc, UpdatesErrorCode.UpdateFailedToLoad);
                }
            }
            UpdateEntity updateEntity3 = ((Loader.LoaderResult) objLoad).getUpdateEntity();
            UpdateDao updateDao = updatesDatabase2.updateDao();
            Intrinsics.checkNotNull(updateEntity3);
            updateDao.setUpdateCommitTime(updateEntity3, rollBackToEmbeddedUpdateDirective2.getCommitTime());
            z = true;
            return Boxing.boxBoolean(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Loader.OnUpdateResponseLoadedResult processRollBackToEmbeddedDirective$lambda$0(UpdateResponse it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Loader.OnUpdateResponseLoadedResult(true);
        }
    }
}
