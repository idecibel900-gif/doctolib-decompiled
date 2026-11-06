package expo.modules.updates.launcher;

import android.content.Context;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.logging.UpdatesLogger;
import java.io.File;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class NoDatabaseLauncher implements Launcher {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = NoDatabaseLauncher.class.getSimpleName();
    private final String bundleAssetName;
    private final Context context;
    private final boolean isUsingEmbeddedAssets;
    private final Void launchAssetFile;
    private final Void launchedUpdate;
    private final Void localAssetFiles;
    private final UpdatesLogger logger;

    public NoDatabaseLauncher(Context context, UpdatesLogger logger, Exception exc, CoroutineScope launcherScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(launcherScope, "launcherScope");
        this.context = context;
        this.logger = logger;
        this.bundleAssetName = "index.android.bundle";
        this.isUsingEmbeddedAssets = true;
        if (exc != null) {
            BuildersKt__Builders_commonKt.launch$default(launcherScope, null, null, new AnonymousClass1(exc, null), 3, null);
        }
    }

    @Override // expo.modules.updates.launcher.Launcher
    public /* bridge */ /* synthetic */ String getLaunchAssetFile() {
        return (String) m4979getLaunchAssetFile();
    }

    @Override // expo.modules.updates.launcher.Launcher
    public /* bridge */ /* synthetic */ UpdateEntity getLaunchedUpdate() {
        return (UpdateEntity) m4980getLaunchedUpdate();
    }

    @Override // expo.modules.updates.launcher.Launcher
    /* JADX INFO: renamed from: getLocalAssetFiles, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo4981getLocalAssetFiles() {
        return (Map) getLocalAssetFiles();
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getBundleAssetName() {
        return this.bundleAssetName;
    }

    /* JADX INFO: renamed from: getLaunchedUpdate, reason: collision with other method in class */
    public Void m4980getLaunchedUpdate() {
        return this.launchedUpdate;
    }

    /* JADX INFO: renamed from: getLaunchAssetFile, reason: collision with other method in class */
    public Void m4979getLaunchAssetFile() {
        return this.launchAssetFile;
    }

    public Void getLocalAssetFiles() {
        return this.localAssetFiles;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public boolean isUsingEmbeddedAssets() {
        return this.isUsingEmbeddedAssets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeErrorToLog(Exception exc) {
        try {
            FilesKt.appendText(new File(this.context.getFilesDir(), "expo-error.log"), exc.toString(), Charsets.UTF_8);
        } catch (Exception e) {
            UpdatesLogger.error$default(this.logger, "Failed to write fatal error to log", e, null, 4, null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String consumeErrorLog(File filesDir, UpdatesLogger logger) {
            Intrinsics.checkNotNullParameter(filesDir, "filesDir");
            Intrinsics.checkNotNullParameter(logger, "logger");
            try {
                File file = new File(filesDir, "expo-error.log");
                if (!file.exists()) {
                    return null;
                }
                String text = FilesKt.readText(file, Charsets.UTF_8);
                file.delete();
                return text;
            } catch (Exception e) {
                UpdatesLogger.error$default(logger, "Failed to read error log", e, null, 4, null);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.launcher.NoDatabaseLauncher$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Exception $fatalException;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Exception exc, Continuation continuation) {
            super(2, continuation);
            this.$fatalException = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return NoDatabaseLauncher.this.new AnonymousClass1(this.$fatalException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NoDatabaseLauncher.this.writeErrorToLog(this.$fatalException);
            return Unit.INSTANCE;
        }
    }
}
