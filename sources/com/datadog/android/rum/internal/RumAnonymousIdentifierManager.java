package com.datadog.android.rum.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumAnonymousIdentifierManager {
    public static final Companion Companion = new Companion(null);
    private final FeatureSdkCore core;
    private final DataStoreHandler dataStore;

    public RumAnonymousIdentifierManager(DataStoreHandler dataStore, FeatureSdkCore core) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(core, "core");
        this.dataStore = dataStore;
        this.core = core;
    }

    public final void manageAnonymousId(boolean z) {
        if (z) {
            handleAnonymousIdTracking(this.dataStore, this.core);
        } else {
            clearAnonymousId(this.dataStore, this.core);
        }
    }

    private final void handleAnonymousIdTracking(final DataStoreHandler dataStoreHandler, final FeatureSdkCore featureSdkCore) {
        dataStoreHandler.value("anonymous_id_key", null, new AnonymousIdentifierReadCallback(new Function1() { // from class: com.datadog.android.rum.internal.RumAnonymousIdentifierManager.handleAnonymousIdTracking.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((UUID) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(UUID uuid) {
                if (uuid == null) {
                    RumAnonymousIdentifierManager.this.createAndStoreAnonymousId(dataStoreHandler, featureSdkCore);
                } else {
                    featureSdkCore.setAnonymousId(uuid);
                }
            }
        }), new AnonymousIdentifierDeserializer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndStoreAnonymousId(DataStoreHandler dataStoreHandler, FeatureSdkCore featureSdkCore) {
        UUID newAnonymousId = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(newAnonymousId, "newAnonymousId");
        dataStoreHandler.setValue("anonymous_id_key", newAnonymousId, 0, null, new AnonymousIdentifierSerializer());
        featureSdkCore.setAnonymousId(newAnonymousId);
    }

    private final void clearAnonymousId(DataStoreHandler dataStoreHandler, FeatureSdkCore featureSdkCore) {
        DataStoreHandler.DefaultImpls.removeValue$default(dataStoreHandler, "anonymous_id_key", null, 2, null);
        featureSdkCore.setAnonymousId(null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
