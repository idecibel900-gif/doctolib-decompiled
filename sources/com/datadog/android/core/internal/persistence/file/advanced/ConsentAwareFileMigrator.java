package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ConsentAwareFileMigrator implements DataMigrator {
    private final FileMover fileMover;
    private final InternalLogger internalLogger;

    public ConsentAwareFileMigrator(FileMover fileMover, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.advanced.DataMigrator
    public void migrateData(TrackingConsent trackingConsent, FileOrchestrator previousFileOrchestrator, TrackingConsent newState, FileOrchestrator newFileOrchestrator) {
        Intrinsics.checkNotNullParameter(previousFileOrchestrator, "previousFileOrchestrator");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(newFileOrchestrator, "newFileOrchestrator");
        resolveMigrationOperation(trackingConsent, newState, previousFileOrchestrator, newFileOrchestrator).run();
    }

    private final DataMigrationOperation resolveMigrationOperation(final TrackingConsent trackingConsent, final TrackingConsent trackingConsent2, FileOrchestrator fileOrchestrator, FileOrchestrator fileOrchestrator2) {
        boolean zAreEqual;
        Pair pair = TuplesKt.to(trackingConsent, trackingConsent2);
        TrackingConsent trackingConsent3 = TrackingConsent.PENDING;
        if (Intrinsics.areEqual(pair, TuplesKt.to(null, trackingConsent3)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(null, TrackingConsent.GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(null, TrackingConsent.NOT_GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent3, TrackingConsent.NOT_GRANTED))) {
            return new WipeDataMigrationOperation(fileOrchestrator.getRootDir(), this.fileMover, this.internalLogger);
        }
        TrackingConsent trackingConsent4 = TrackingConsent.GRANTED;
        if (Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent4, trackingConsent3)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.NOT_GRANTED, trackingConsent3))) {
            return new WipeDataMigrationOperation(fileOrchestrator2.getRootDir(), this.fileMover, this.internalLogger);
        }
        if (Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent3, trackingConsent4))) {
            return new MoveDataMigrationOperation(fileOrchestrator.getRootDir(), fileOrchestrator2.getRootDir(), this.fileMover, this.internalLogger);
        }
        if (Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent3, trackingConsent3)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent4, trackingConsent4)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent4, TrackingConsent.NOT_GRANTED))) {
            zAreEqual = true;
        } else {
            TrackingConsent trackingConsent5 = TrackingConsent.NOT_GRANTED;
            zAreEqual = Intrinsics.areEqual(pair, TuplesKt.to(trackingConsent5, trackingConsent5));
        }
        if (zAreEqual ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.NOT_GRANTED, trackingConsent4))) {
            return new NoOpDataMigrationOperation();
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator.resolveMigrationOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unexpected consent migration from " + trackingConsent + " to " + trackingConsent2;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return new NoOpDataMigrationOperation();
    }
}
