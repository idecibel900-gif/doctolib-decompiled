package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.persistence.NoOpPersistenceStrategy;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractStorage implements Storage, TrackingConsentProviderCallback {
    private final ConsentProvider consentProvider;
    private final ExecutorService executorService;
    private final String featureName;
    private final Lazy grantedPersistenceStrategy$delegate;
    private final InternalLogger internalLogger;
    private final PersistenceStrategy notGrantedPersistenceStrategy;
    private final Lazy pendingPersistenceStrategy$delegate;
    private final String sdkCoreId;
    private final FeatureStorageConfiguration storageConfiguration;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final PersistenceStrategy.Factory getPersistenceStrategyFactory$dd_sdk_android_core_release() {
        return null;
    }

    public AbstractStorage(String str, String featureName, PersistenceStrategy.Factory persistenceStrategyFactory, ExecutorService executorService, InternalLogger internalLogger, FeatureStorageConfiguration storageConfiguration, ConsentProvider consentProvider) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(persistenceStrategyFactory, "persistenceStrategyFactory");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(storageConfiguration, "storageConfiguration");
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        this.sdkCoreId = str;
        this.featureName = featureName;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        this.storageConfiguration = storageConfiguration;
        this.consentProvider = consentProvider;
        this.grantedPersistenceStrategy$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$grantedPersistenceStrategy$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PersistenceStrategy invoke() {
                this.this$0.getPersistenceStrategyFactory$dd_sdk_android_core_release();
                String sdkCoreId$dd_sdk_android_core_release = this.this$0.getSdkCoreId$dd_sdk_android_core_release();
                String str2 = this.this$0.featureName;
                TrackingConsent trackingConsent = TrackingConsent.GRANTED;
                StringBuilder sb = new StringBuilder();
                sb.append(sdkCoreId$dd_sdk_android_core_release);
                sb.append("/");
                sb.append(str2);
                sb.append("/");
                sb.append(trackingConsent);
                this.this$0.getStorageConfiguration$dd_sdk_android_core_release().getMaxItemsPerBatch();
                this.this$0.getStorageConfiguration$dd_sdk_android_core_release().getMaxBatchSize();
                throw null;
            }
        });
        this.pendingPersistenceStrategy$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$pendingPersistenceStrategy$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PersistenceStrategy invoke() {
                this.this$0.getPersistenceStrategyFactory$dd_sdk_android_core_release();
                String sdkCoreId$dd_sdk_android_core_release = this.this$0.getSdkCoreId$dd_sdk_android_core_release();
                String str2 = this.this$0.featureName;
                TrackingConsent trackingConsent = TrackingConsent.PENDING;
                StringBuilder sb = new StringBuilder();
                sb.append(sdkCoreId$dd_sdk_android_core_release);
                sb.append("/");
                sb.append(str2);
                sb.append("/");
                sb.append(trackingConsent);
                this.this$0.getStorageConfiguration$dd_sdk_android_core_release().getMaxItemsPerBatch();
                this.this$0.getStorageConfiguration$dd_sdk_android_core_release().getMaxBatchSize();
                throw null;
            }
        });
        this.notGrantedPersistenceStrategy = new NoOpPersistenceStrategy();
        consentProvider.registerCallback(this);
    }

    public final String getSdkCoreId$dd_sdk_android_core_release() {
        return this.sdkCoreId;
    }

    public final FeatureStorageConfiguration getStorageConfiguration$dd_sdk_android_core_release() {
        return this.storageConfiguration;
    }

    private final PersistenceStrategy getGrantedPersistenceStrategy() {
        return (PersistenceStrategy) this.grantedPersistenceStrategy$delegate.getValue();
    }

    private final PersistenceStrategy getPendingPersistenceStrategy() {
        return (PersistenceStrategy) this.pendingPersistenceStrategy$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void writeCurrentBatch(DatadogContext datadogContext, boolean z, final Function1 callback) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data write", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStorage.writeCurrentBatch$lambda$0(this.f$0, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeCurrentBatch$lambda$0(AbstractStorage this$0, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final PersistenceStrategy persistenceStrategyResolvePersistenceStrategy = this$0.resolvePersistenceStrategy();
        callback.invoke(new EventBatchWriter() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$writeCurrentBatch$1$writer$1
            @Override // com.datadog.android.api.storage.EventBatchWriter
            public boolean write(RawBatchEvent event, byte[] bArr, EventType eventType) {
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                return persistenceStrategyResolvePersistenceStrategy.write(event, bArr, eventType);
            }
        });
    }

    private final PersistenceStrategy resolvePersistenceStrategy() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.consentProvider.getConsent().ordinal()];
        if (i == 1) {
            return getGrantedPersistenceStrategy();
        }
        if (i == 2) {
            return getPendingPersistenceStrategy();
        }
        if (i == 3) {
            return this.notGrantedPersistenceStrategy;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public BatchData readNextBatch() {
        getGrantedPersistenceStrategy().lockAndReadNext();
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean z) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
        if (z) {
            getGrantedPersistenceStrategy().unlockAndDelete(batchId.getId());
        } else {
            getGrantedPersistenceStrategy().unlockAndKeep(batchId.getId());
        }
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void dropAll() {
        ConcurrencyExtKt.executeSafe(this.executorService, "Data drop", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStorage.dropAll$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dropAll$lambda$2(AbstractStorage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGrantedPersistenceStrategy().dropAll();
        this$0.getPendingPersistenceStrategy().dropAll();
    }

    @Override // com.datadog.android.privacy.TrackingConsentProviderCallback
    public void onConsentUpdated(final TrackingConsent previousConsent, final TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(previousConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data migration", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStorage.onConsentUpdated$lambda$3(previousConsent, newConsent, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConsentUpdated$lambda$3(TrackingConsent previousConsent, TrackingConsent newConsent, AbstractStorage this$0) {
        Intrinsics.checkNotNullParameter(previousConsent, "$previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "$newConsent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (previousConsent == TrackingConsent.PENDING) {
            int i = WhenMappings.$EnumSwitchMapping$0[newConsent.ordinal()];
            if (i == 1) {
                this$0.getPendingPersistenceStrategy().migrateData(this$0.getGrantedPersistenceStrategy());
            } else {
                if (i != 3) {
                    return;
                }
                this$0.getPendingPersistenceStrategy().dropAll();
            }
        }
    }
}
