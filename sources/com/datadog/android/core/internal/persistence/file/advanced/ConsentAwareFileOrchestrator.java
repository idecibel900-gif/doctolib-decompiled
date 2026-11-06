package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.NoOpFileOrchestrator;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ConsentAwareFileOrchestrator implements FileOrchestrator, TrackingConsentProviderCallback {
    public static final Companion Companion = new Companion(null);
    private static final FileOrchestrator NO_OP_ORCHESTRATOR = new NoOpFileOrchestrator();
    private final DataMigrator dataMigrator;
    private volatile FileOrchestrator delegateOrchestrator;
    private final ExecutorService executorService;
    private final FileOrchestrator grantedOrchestrator;
    private final InternalLogger internalLogger;
    private final FileOrchestrator pendingOrchestrator;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        return null;
    }

    public ConsentAwareFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator pendingOrchestrator, FileOrchestrator grantedOrchestrator, DataMigrator dataMigrator, ExecutorService executorService, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(pendingOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(grantedOrchestrator, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.pendingOrchestrator = pendingOrchestrator;
        this.grantedOrchestrator = grantedOrchestrator;
        this.dataMigrator = dataMigrator;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        handleConsentChange(null, consentProvider.getConsent());
        consentProvider.registerCallback(this);
    }

    public final FileOrchestrator getPendingOrchestrator$dd_sdk_android_core_release() {
        return this.pendingOrchestrator;
    }

    public final FileOrchestrator getGrantedOrchestrator$dd_sdk_android_core_release() {
        return this.grantedOrchestrator;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(boolean z) {
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.getWritableFile(z);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        return this.grantedOrchestrator.getReadableFile(excludeFiles);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getAllFiles() {
        return CollectionsKt.plus((Collection) this.pendingOrchestrator.getAllFiles(), (Iterable) this.grantedOrchestrator.getAllFiles());
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getFlushableFiles() {
        return this.grantedOrchestrator.getFlushableFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.getMetadataFile(file);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.decrementAndGetPendingFilesCount();
    }

    @Override // com.datadog.android.privacy.TrackingConsentProviderCallback
    public void onConsentUpdated(TrackingConsent previousConsent, TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(previousConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        handleConsentChange(previousConsent, newConsent);
    }

    private final void handleConsentChange(final TrackingConsent trackingConsent, final TrackingConsent trackingConsent2) {
        final FileOrchestrator fileOrchestratorResolveDelegateOrchestrator = resolveDelegateOrchestrator(trackingConsent);
        final FileOrchestrator fileOrchestratorResolveDelegateOrchestrator2 = resolveDelegateOrchestrator(trackingConsent2);
        ConcurrencyExtKt.executeSafe(this.executorService, "Data migration", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileOrchestrator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConsentAwareFileOrchestrator.handleConsentChange$lambda$0(this.f$0, trackingConsent, fileOrchestratorResolveDelegateOrchestrator, trackingConsent2, fileOrchestratorResolveDelegateOrchestrator2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleConsentChange$lambda$0(ConsentAwareFileOrchestrator this$0, TrackingConsent trackingConsent, FileOrchestrator previousOrchestrator, TrackingConsent newConsent, FileOrchestrator newOrchestrator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(previousOrchestrator, "$previousOrchestrator");
        Intrinsics.checkNotNullParameter(newConsent, "$newConsent");
        Intrinsics.checkNotNullParameter(newOrchestrator, "$newOrchestrator");
        this$0.dataMigrator.migrateData(trackingConsent, previousOrchestrator, newConsent, newOrchestrator);
        this$0.delegateOrchestrator = newOrchestrator;
    }

    private final FileOrchestrator resolveDelegateOrchestrator(TrackingConsent trackingConsent) {
        int i = trackingConsent == null ? -1 : WhenMappings.$EnumSwitchMapping$0[trackingConsent.ordinal()];
        if (i == -1 || i == 1) {
            return this.pendingOrchestrator;
        }
        if (i == 2) {
            return this.grantedOrchestrator;
        }
        if (i == 3) {
            return NO_OP_ORCHESTRATOR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
