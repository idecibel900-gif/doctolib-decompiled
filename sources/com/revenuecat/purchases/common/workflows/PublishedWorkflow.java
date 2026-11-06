package com.revenuecat.purchases.common.workflows;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.UiConfig$$serializer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.utils.serializers.JsonObjectToMapSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002DCBq\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\u0097\u0001\b\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J(\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019HÁ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b%\u0010$J\u0010\u0010&\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003¢\u0006\u0004\b(\u0010$J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010 J\u0086\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010 J\u0010\u0010-\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010 R \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u00103\u0012\u0004\b6\u00107\u001a\u0004\b5\u0010 R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u00103\u0012\u0004\b9\u00107\u001a\u0004\b8\u0010 R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010:\u001a\u0004\b;\u0010$R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b<\u0010$R \u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010=\u0012\u0004\b?\u00107\u001a\u0004\b>\u0010'R,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010:\u0012\u0004\bA\u00107\u001a\u0004\b@\u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\bB\u0010 ¨\u0006E"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "", "", DiagnosticsEntry.ID_KEY, "displayName", "initialStepId", "", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "steps", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "screens", "Lcom/revenuecat/purchases/UiConfig;", "uiConfig", "metadata", "hash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/revenuecat/purchases/UiConfig;Ljava/util/Map;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/revenuecat/purchases/UiConfig;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/util/Map;", "component5", "component6", "()Lcom/revenuecat/purchases/UiConfig;", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/revenuecat/purchases/UiConfig;Ljava/util/Map;Ljava/lang/String;)Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "toString", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getDisplayName", "getDisplayName$annotations", "()V", "getInitialStepId", "getInitialStepId$annotations", "Ljava/util/Map;", "getSteps", "getScreens", "Lcom/revenuecat/purchases/UiConfig;", "getUiConfig", "getUiConfig$annotations", "getMetadata", "getMetadata$annotations", "getHash", "Companion", "$serializer", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PublishedWorkflow {
    private static final KSerializer[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String displayName;
    private final String hash;
    private final String id;
    private final String initialStepId;
    private final Map<String, Object> metadata;
    private final Map<String, WorkflowScreen> screens;
    private final Map<String, WorkflowStep> steps;
    private final UiConfig uiConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublishedWorkflow copy$default(PublishedWorkflow publishedWorkflow, String str, String str2, String str3, Map map, Map map2, UiConfig uiConfig, Map map3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishedWorkflow.id;
        }
        if ((i & 2) != 0) {
            str2 = publishedWorkflow.displayName;
        }
        if ((i & 4) != 0) {
            str3 = publishedWorkflow.initialStepId;
        }
        if ((i & 8) != 0) {
            map = publishedWorkflow.steps;
        }
        if ((i & 16) != 0) {
            map2 = publishedWorkflow.screens;
        }
        if ((i & 32) != 0) {
            uiConfig = publishedWorkflow.uiConfig;
        }
        if ((i & 64) != 0) {
            map3 = publishedWorkflow.metadata;
        }
        if ((i & 128) != 0) {
            str4 = publishedWorkflow.hash;
        }
        Map map4 = map3;
        String str5 = str4;
        Map map5 = map2;
        UiConfig uiConfig2 = uiConfig;
        return publishedWorkflow.copy(str, str2, str3, map, map5, uiConfig2, map4, str5);
    }

    public static /* synthetic */ void getDisplayName$annotations() {
    }

    public static /* synthetic */ void getInitialStepId$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getUiConfig$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInitialStepId() {
        return this.initialStepId;
    }

    public final Map<String, WorkflowStep> component4() {
        return this.steps;
    }

    public final Map<String, WorkflowScreen> component5() {
        return this.screens;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UiConfig getUiConfig() {
        return this.uiConfig;
    }

    public final Map<String, Object> component7() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    public final PublishedWorkflow copy(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, UiConfig uiConfig, Map<String, ? extends Object> metadata, String hash) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PublishedWorkflow(id, displayName, initialStepId, steps, screens, uiConfig, metadata, hash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishedWorkflow)) {
            return false;
        }
        PublishedWorkflow publishedWorkflow = (PublishedWorkflow) other;
        return Intrinsics.areEqual(this.id, publishedWorkflow.id) && Intrinsics.areEqual(this.displayName, publishedWorkflow.displayName) && Intrinsics.areEqual(this.initialStepId, publishedWorkflow.initialStepId) && Intrinsics.areEqual(this.steps, publishedWorkflow.steps) && Intrinsics.areEqual(this.screens, publishedWorkflow.screens) && Intrinsics.areEqual(this.uiConfig, publishedWorkflow.uiConfig) && Intrinsics.areEqual(this.metadata, publishedWorkflow.metadata) && Intrinsics.areEqual(this.hash, publishedWorkflow.hash);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.initialStepId.hashCode()) * 31) + this.steps.hashCode()) * 31) + this.screens.hashCode()) * 31) + this.uiConfig.hashCode()) * 31) + this.metadata.hashCode()) * 31;
        String str = this.hash;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PublishedWorkflow(id=" + this.id + ", displayName=" + this.displayName + ", initialStepId=" + this.initialStepId + ", steps=" + this.steps + ", screens=" + this.screens + ", uiConfig=" + this.uiConfig + ", metadata=" + this.metadata + ", hash=" + this.hash + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PublishedWorkflow$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, new LinkedHashMapSerializer(stringSerializer, WorkflowStep$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, WorkflowScreen$$serializer.INSTANCE), null, null, null};
    }

    @Deprecated
    public /* synthetic */ PublishedWorkflow(int i, String str, String str2, String str3, Map map, Map map2, UiConfig uiConfig, Map map3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, PublishedWorkflow$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.displayName = str2;
        this.initialStepId = str3;
        this.steps = map;
        this.screens = map2;
        this.uiConfig = uiConfig;
        if ((i & 64) == 0) {
            this.metadata = MapsKt.emptyMap();
        } else {
            this.metadata = map3;
        }
        if ((i & 128) == 0) {
            this.hash = null;
        } else {
            this.hash = str4;
        }
    }

    public PublishedWorkflow(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, UiConfig uiConfig, Map<String, ? extends Object> metadata, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.id = id;
        this.displayName = displayName;
        this.initialStepId = initialStepId;
        this.steps = steps;
        this.screens = screens;
        this.uiConfig = uiConfig;
        this.metadata = metadata;
        this.hash = str;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PublishedWorkflow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.displayName);
        output.encodeStringElement(serialDesc, 2, self.initialStepId);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.steps);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.screens);
        output.encodeSerializableElement(serialDesc, 5, UiConfig$$serializer.INSTANCE, self.uiConfig);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.metadata, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, JsonObjectToMapSerializer.INSTANCE, self.metadata);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.hash == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.hash);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getInitialStepId() {
        return this.initialStepId;
    }

    public final Map<String, WorkflowStep> getSteps() {
        return this.steps;
    }

    public final Map<String, WorkflowScreen> getScreens() {
        return this.screens;
    }

    public final UiConfig getUiConfig() {
        return this.uiConfig;
    }

    public /* synthetic */ PublishedWorkflow(String str, String str2, String str3, Map map, Map map2, UiConfig uiConfig, Map map3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, map, map2, uiConfig, (i & 64) != 0 ? MapsKt.emptyMap() : map3, (i & 128) != 0 ? null : str4);
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getHash() {
        return this.hash;
    }
}
