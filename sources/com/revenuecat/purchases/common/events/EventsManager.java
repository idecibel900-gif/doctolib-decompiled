package com.revenuecat.purchases.common.events;

import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.DebugEvent;
import com.revenuecat.purchases.DebugEventListener;
import com.revenuecat.purchases.DebugEventName;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.RateLimiter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001HB\u0087\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012<\u0010\u0015\u001a8\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0012\u0012\u0004\u0012\u00020\u00110\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010\u001bJ\u0017\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070%H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%H\u0002¢\u0006\u0004\b(\u0010'J'\u0010*\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00104R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00104R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00105R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00106RJ\u0010\u0015\u001a8\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0012\u0012\u0004\u0012\u00020\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00107R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00108R.\u0010;\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u0001098F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010E\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00148B@BX\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00148B@BX\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010F¨\u0006I"}, d2 = {"Lcom/revenuecat/purchases/common/events/EventsManager;", "", "Ljava/util/UUID;", "appSessionID", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "legacyEventsFileHelper", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "fileHelper", "Lcom/revenuecat/purchases/identity/IdentityManager;", "identityManager", "Lcom/revenuecat/purchases/common/Dispatcher;", "eventsDispatcher", "Lkotlin/Function4;", "Lcom/revenuecat/purchases/common/events/EventsRequest;", "Lcom/revenuecat/purchases/common/Delay;", "Lkotlin/Function0;", "", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "postEvents", "Lcom/revenuecat/purchases/utils/RateLimiter;", "priorityFlushRateLimiter", "<init>", "(Ljava/util/UUID;Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/common/Dispatcher;Lkotlin/jvm/functions/Function4;Lcom/revenuecat/purchases/utils/RateLimiter;)V", "checkFileSizeAndClearIfNeeded", "()V", "", "batchNumber", "delay", "flushNextBatch", "(ILcom/revenuecat/purchases/common/Delay;)V", "performPriorityFlush", "onFlushComplete", "startPendingPriorityFlushIfNeeded", "flushLegacyEvents", "", "getStoredEvents", "()Ljava/util/List;", "getLegacyPaywallsStoredEvents", "command", "enqueue", "(Lcom/revenuecat/purchases/common/Delay;Lkotlin/jvm/functions/Function0;)V", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "event", "track", "(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V", "flushEvents", "(Lcom/revenuecat/purchases/common/Delay;)V", "appSessionID$1", "Ljava/util/UUID;", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/identity/IdentityManager;", "Lcom/revenuecat/purchases/common/Dispatcher;", "Lkotlin/jvm/functions/Function4;", "Lcom/revenuecat/purchases/utils/RateLimiter;", "Lcom/revenuecat/purchases/DebugEventListener;", "value", "debugEventListener", "Lcom/revenuecat/purchases/DebugEventListener;", "getDebugEventListener", "()Lcom/revenuecat/purchases/DebugEventListener;", "setDebugEventListener", "(Lcom/revenuecat/purchases/DebugEventListener;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "flushInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<set-?>", "pendingPriorityFlush", "Z", "legacyFlushTriggered", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EventsManager {
    public static final String AD_EVENTS_FILE_PATH = "RevenueCat/event_store/ad_event_store.jsonl";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EVENTS_FILE_PATH_NEW = "RevenueCat/event_store/event_store.jsonl";
    public static final int EVENTS_TO_CLEAR_ON_LIMIT = 50;
    public static final double FILE_SIZE_LIMIT_KB = 2048.0d;
    private static final int FLUSH_COUNT = 50;
    private static final int MAX_FLUSH_BATCHES = 10;
    private static final String PAYWALL_EVENTS_FILE_PATH = "RevenueCat/paywall_event_store/paywall_event_store.jsonl";
    private static final UUID appSessionID;
    private static final Json json;

    /* JADX INFO: renamed from: appSessionID$1, reason: from kotlin metadata */
    private final UUID appSessionID;
    private DebugEventListener debugEventListener;
    private final Dispatcher eventsDispatcher;
    private final EventsFileHelper<BackendStoredEvent> fileHelper;
    private AtomicBoolean flushInProgress;
    private final IdentityManager identityManager;
    private final EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper;
    private boolean legacyFlushTriggered;
    private boolean pendingPriorityFlush;
    private final Function4 postEvents;
    private final RateLimiter priorityFlushRateLimiter;

    public EventsManager(UUID appSessionID2, EventsFileHelper<PaywallStoredEvent> eventsFileHelper, EventsFileHelper<BackendStoredEvent> fileHelper, IdentityManager identityManager, Dispatcher eventsDispatcher, Function4 postEvents, RateLimiter priorityFlushRateLimiter) {
        Intrinsics.checkNotNullParameter(appSessionID2, "appSessionID");
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(postEvents, "postEvents");
        Intrinsics.checkNotNullParameter(priorityFlushRateLimiter, "priorityFlushRateLimiter");
        this.appSessionID = appSessionID2;
        this.legacyEventsFileHelper = eventsFileHelper;
        this.fileHelper = fileHelper;
        this.identityManager = identityManager;
        this.eventsDispatcher = eventsDispatcher;
        this.postEvents = postEvents;
        this.priorityFlushRateLimiter = priorityFlushRateLimiter;
        this.flushInProgress = new AtomicBoolean(false);
    }

    public /* synthetic */ EventsManager(UUID uuid, EventsFileHelper eventsFileHelper, EventsFileHelper eventsFileHelper2, IdentityManager identityManager, Dispatcher dispatcher, Function4 function4, RateLimiter rateLimiter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        uuid = (i & 1) != 0 ? appSessionID : uuid;
        if ((i & 64) != 0) {
            Duration.Companion companion = Duration.Companion;
            rateLimiter = new RateLimiter(5, DurationKt.toDuration(60, DurationUnit.SECONDS), null);
        }
        this(uuid, eventsFileHelper, eventsFileHelper2, identityManager, dispatcher, function4, rateLimiter);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/events/EventsManager$Companion;", "", "()V", "AD_EVENTS_FILE_PATH", "", "EVENTS_FILE_PATH_NEW", "EVENTS_TO_CLEAR_ON_LIMIT", "", "getEVENTS_TO_CLEAR_ON_LIMIT$annotations", "FILE_SIZE_LIMIT_KB", "", "getFILE_SIZE_LIMIT_KB$annotations", "FLUSH_COUNT", "MAX_FLUSH_BATCHES", "PAYWALL_EVENTS_FILE_PATH", "appSessionID", "Ljava/util/UUID;", "getAppSessionID$purchases_defaultsBc8Release", "()Ljava/util/UUID;", "json", "Lkotlinx/serialization/json/Json;", "getJson$annotations", "adEvents", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "backendEvents", "paywalls", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEVENTS_TO_CLEAR_ON_LIMIT$annotations() {
        }

        public static /* synthetic */ void getFILE_SIZE_LIMIT_KB$annotations() {
        }

        private static /* synthetic */ void getJson$annotations() {
        }

        private Companion() {
        }

        public final UUID getAppSessionID$purchases_defaultsBc8Release() {
            return EventsManager.appSessionID;
        }

        public final EventsFileHelper<BackendStoredEvent> backendEvents(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.EVENTS_FILE_PATH_NEW, new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$backendEvents$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(BackendStoredEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    return EventsManager.json.encodeToString(BackendStoredEvent.INSTANCE.serializer(), event);
                }
            }, new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$backendEvents$2
                @Override // kotlin.jvm.functions.Function1
                public final BackendStoredEvent invoke(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    return (BackendStoredEvent) EventsManager.json.decodeFromString(BackendStoredEvent.INSTANCE.serializer(), jsonString);
                }
            });
        }

        public final EventsFileHelper<BackendStoredEvent> adEvents(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.AD_EVENTS_FILE_PATH, new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$adEvents$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(BackendStoredEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    return EventsManager.json.encodeToString(BackendStoredEvent.INSTANCE.serializer(), event);
                }
            }, new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$adEvents$2
                @Override // kotlin.jvm.functions.Function1
                public final BackendStoredEvent invoke(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    return (BackendStoredEvent) EventsManager.json.decodeFromString(BackendStoredEvent.INSTANCE.serializer(), jsonString);
                }
            });
        }

        public final EventsFileHelper<PaywallStoredEvent> paywalls(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.PAYWALL_EVENTS_FILE_PATH, EventsManager$Companion$paywalls$1.INSTANCE, new EventsManager$Companion$paywalls$2(PaywallStoredEvent.INSTANCE));
        }
    }

    static {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        appSessionID = uuidRandomUUID;
        json = JsonKt.Json$default(null, new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$json$1
            public final void invoke(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
                PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(BackendStoredEvent.class), null);
                polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendStoredEvent.CustomerCenter.class), BackendStoredEvent.CustomerCenter.INSTANCE.serializer());
                polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendStoredEvent.Paywalls.class), BackendStoredEvent.Paywalls.INSTANCE.serializer());
                polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendStoredEvent.Ad.class), BackendStoredEvent.Ad.INSTANCE.serializer());
                polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendStoredEvent.CustomPaywall.class), BackendStoredEvent.CustomPaywall.INSTANCE.serializer());
                polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
                Json.setSerializersModule(serializersModuleBuilder.build());
                Json.setExplicitNulls(false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JsonBuilder) obj);
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    public final synchronized DebugEventListener getDebugEventListener() {
        return this.debugEventListener;
    }

    public final synchronized void setDebugEventListener(final DebugEventListener debugEventListener) {
        try {
            this.debugEventListener = debugEventListener;
            this.fileHelper.setDebugEventCallback(debugEventListener != null ? new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager$debugEventListener$callback$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DebugEvent) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(DebugEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    debugEventListener.onDebugEventReceived(event);
                }
            } : null);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFileSizeAndClearIfNeeded() {
        if (this.fileHelper.fileSizeInKB() >= 2048.0d) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Event store size limit reached. Clearing oldest events to free up space.");
            }
            this.fileHelper.clear(50);
            DebugEventListener debugEventListener = this.debugEventListener;
            if (debugEventListener != null) {
                debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FILE_SIZE_LIMIT_REACHED, null, 2, null));
            }
        }
    }

    public final synchronized void track(final FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enqueue$default(this, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.track.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3882invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3882invoke() {
                BackendStoredEvent backendStoredEvent;
                FeatureEvent featureEvent = event;
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                Config config = Config.INSTANCE;
                if (config.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Tracking event: " + featureEvent);
                }
                FeatureEvent featureEvent2 = event;
                if (featureEvent2 instanceof PaywallEvent) {
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((PaywallEvent) featureEvent2, this.identityManager.getCurrentAppUserID());
                } else if (featureEvent2 instanceof CustomerCenterImpressionEvent) {
                    String currentAppUserID = this.identityManager.getCurrentAppUserID();
                    String string = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterImpressionEvent) featureEvent2, currentAppUserID, string);
                } else if (featureEvent2 instanceof CustomerCenterSurveyOptionChosenEvent) {
                    String currentAppUserID2 = this.identityManager.getCurrentAppUserID();
                    String string2 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterSurveyOptionChosenEvent) featureEvent2, currentAppUserID2, string2);
                } else if (featureEvent2 instanceof AdEvent.Displayed) {
                    String currentAppUserID3 = this.identityManager.getCurrentAppUserID();
                    String string3 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Displayed) featureEvent2, currentAppUserID3, string3);
                } else if (featureEvent2 instanceof AdEvent.Open) {
                    String currentAppUserID4 = this.identityManager.getCurrentAppUserID();
                    String string4 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string4, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Open) featureEvent2, currentAppUserID4, string4);
                } else if (featureEvent2 instanceof AdEvent.Revenue) {
                    String currentAppUserID5 = this.identityManager.getCurrentAppUserID();
                    String string5 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string5, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Revenue) featureEvent2, currentAppUserID5, string5);
                } else if (featureEvent2 instanceof AdEvent.Loaded) {
                    String currentAppUserID6 = this.identityManager.getCurrentAppUserID();
                    String string6 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string6, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Loaded) featureEvent2, currentAppUserID6, string6);
                } else if (featureEvent2 instanceof AdEvent.FailedToLoad) {
                    String currentAppUserID7 = this.identityManager.getCurrentAppUserID();
                    String string7 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string7, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.FailedToLoad) featureEvent2, currentAppUserID7, string7);
                } else if (featureEvent2 instanceof CustomPaywallEvent.Impression) {
                    String currentAppUserID8 = this.identityManager.getCurrentAppUserID();
                    String string8 = this.appSessionID.toString();
                    Intrinsics.checkNotNullExpressionValue(string8, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomPaywallEvent.Impression) featureEvent2, currentAppUserID8, string8);
                } else {
                    backendStoredEvent = null;
                }
                if (backendStoredEvent != null) {
                    this.checkFileSizeAndClearIfNeeded();
                    this.fileHelper.appendEvent(backendStoredEvent);
                    if (event.isPriorityEvent()) {
                        this.performPriorityFlush();
                        return;
                    }
                    return;
                }
                FeatureEvent featureEvent3 = event;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (config.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), "Backend event not implemented for: " + featureEvent3);
                }
            }
        }, 1, null);
    }

    public static /* synthetic */ void flushEvents$default(EventsManager eventsManager, Delay delay, int i, Object obj) {
        if ((i & 1) != 0) {
            delay = Delay.DEFAULT;
        }
        eventsManager.flushEvents(delay);
    }

    public final synchronized void flushEvents(final Delay delay) {
        Intrinsics.checkNotNullParameter(delay, "delay");
        enqueue$default(this, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushEvents.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3874invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3874invoke() {
                if (EventsManager.this.flushInProgress.getAndSet(true)) {
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Flush already in progress.");
                        return;
                    }
                    return;
                }
                DebugEventListener debugEventListener = EventsManager.this.getDebugEventListener();
                if (debugEventListener != null) {
                    debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_STARTED, null, 2, null));
                }
                EventsManager.this.flushNextBatch(1, delay);
                if (EventsManager.this.legacyFlushTriggered) {
                    return;
                }
                EventsManager.this.legacyFlushTriggered = true;
                EventsManager.this.flushLegacyEvents();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushNextBatch(final int batchNumber, final Delay delay) {
        DebugEventListener debugEventListener;
        if (batchNumber > 10) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Reached maximum number of flush batches (10). Stopping flush.");
            }
            onFlushComplete();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final List<BackendStoredEvent> storedEvents = getStoredEvents();
        List listFilterNotNull = CollectionsKt.filterNotNull(storedEvents);
        if (listFilterNotNull.isEmpty()) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No new events to sync.");
            }
            if (batchNumber == 1 && (debugEventListener = this.debugEventListener) != null) {
                debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_SKIPPED_NO_EVENTS, null, 2, null));
            }
            onFlushComplete();
            return;
        }
        LogLevel logLevel3 = LogLevel.VERBOSE;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "New event flush (batch " + batchNumber + "): posting " + listFilterNotNull.size() + " events.");
        }
        Function4 function4 = this.postEvents;
        List list = listFilterNotNull;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent) it.next()));
        }
        function4.invoke(new EventsRequest(arrayList), delay, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3879invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3879invoke() {
                int i = batchNumber;
                LogLevel logLevel4 = LogLevel.VERBOSE;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "New event flush (batch " + i + "): success.");
                }
                DebugEventListener debugEventListener2 = EventsManager.this.getDebugEventListener();
                if (debugEventListener2 != null) {
                    debugEventListener2.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_COMPLETED, MapsKt.mapOf(TuplesKt.to("batch_number", String.valueOf(batchNumber)), TuplesKt.to("elapsed_millis", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
                }
                final EventsManager eventsManager = EventsManager.this;
                final List<BackendStoredEvent> list2 = storedEvents;
                final int i2 = batchNumber;
                final Delay delay2 = delay;
                EventsManager.enqueue$default(eventsManager, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.5.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3880invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m3880invoke() {
                        eventsManager.fileHelper.clear(list2.size());
                        eventsManager.flushNextBatch(i2 + 1, delay2);
                    }
                }, 1, null);
            }
        }, new Function2() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError error, final boolean z) {
                Intrinsics.checkNotNullParameter(error, "error");
                int i = batchNumber;
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "New event flush (batch " + i + ") error: " + error + b.a, null);
                DebugEventListener debugEventListener2 = EventsManager.this.getDebugEventListener();
                if (debugEventListener2 != null) {
                    DebugEventName debugEventName = DebugEventName.FLUSH_ERROR;
                    Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                    mapCreateMapBuilder.put("errorCode", error.getCode().name());
                    String underlyingErrorMessage = error.getUnderlyingErrorMessage();
                    if (underlyingErrorMessage != null) {
                        mapCreateMapBuilder.put("underlyingErrorMessage", StringsKt.take(underlyingErrorMessage, 80));
                    }
                    Unit unit = Unit.INSTANCE;
                    debugEventListener2.onDebugEventReceived(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
                }
                final EventsManager eventsManager = EventsManager.this;
                final List<BackendStoredEvent> list2 = storedEvents;
                EventsManager.enqueue$default(eventsManager, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.6.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3881invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m3881invoke() {
                        if (z) {
                            eventsManager.fileHelper.clear(list2.size());
                        }
                        eventsManager.onFlushComplete();
                    }
                }, 1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performPriorityFlush() {
        this.pendingPriorityFlush = true;
        if (this.flushInProgress.get()) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Flush in progress. Queuing priority flush.");
                return;
            }
            return;
        }
        startPendingPriorityFlushIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFlushComplete() {
        this.flushInProgress.set(false);
        startPendingPriorityFlushIfNeeded();
    }

    private final void startPendingPriorityFlushIfNeeded() {
        if (this.pendingPriorityFlush) {
            this.pendingPriorityFlush = false;
            if (!this.priorityFlushRateLimiter.shouldProceed()) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Priority flush rate limited. Skipping.");
                    return;
                }
                return;
            }
            if (this.flushInProgress.getAndSet(true)) {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Flush in progress. Queuing priority flush.");
                }
                this.pendingPriorityFlush = true;
                return;
            }
            LogLevel logLevel3 = LogLevel.DEBUG;
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Starting priority flush.");
            }
            flushNextBatch(1, Delay.NONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushLegacyEvents() {
        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper = this.legacyEventsFileHelper;
        if (eventsFileHelper == null) {
            return;
        }
        enqueue$default(this, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3875invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3875invoke() {
                final List legacyPaywallsStoredEvents = EventsManager.this.getLegacyPaywallsStoredEvents();
                List listFilterNotNull = CollectionsKt.filterNotNull(legacyPaywallsStoredEvents);
                List list = listFilterNotNull;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BackendStoredEvent.Paywalls(((PaywallStoredEvent) it.next()).toBackendEvent()));
                }
                if (listFilterNotNull.isEmpty()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "No legacy events to sync. Skipping legacy flush.");
                        return;
                    }
                    return;
                }
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Legacy event flush: posting " + arrayList.size() + " events.");
                }
                Function4 function4 = EventsManager.this.postEvents;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent.Paywalls) it2.next()));
                }
                EventsRequest eventsRequest = new EventsRequest(arrayList2);
                Delay delay = Delay.LONG;
                final EventsManager eventsManager = EventsManager.this;
                final EventsFileHelper<PaywallStoredEvent> eventsFileHelper2 = eventsFileHelper;
                Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m3876invoke() {
                        LogLevel logLevel3 = LogLevel.VERBOSE;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Legacy event flush: success.");
                        }
                        EventsManager eventsManager2 = eventsManager;
                        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper3 = eventsFileHelper2;
                        final List<PaywallStoredEvent> list2 = legacyPaywallsStoredEvents;
                        EventsManager.enqueue$default(eventsManager2, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3877invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m3877invoke() {
                                eventsFileHelper3.clear(list2.size());
                            }
                        }, 1, null);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3876invoke();
                        return Unit.INSTANCE;
                    }
                };
                final EventsManager eventsManager2 = EventsManager.this;
                final EventsFileHelper<PaywallStoredEvent> eventsFileHelper3 = eventsFileHelper;
                function4.invoke(eventsRequest, delay, function0, new Function2() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final void invoke(PurchasesError error, final boolean z) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Legacy event flush error: " + error + b.a, null);
                        EventsManager eventsManager3 = eventsManager2;
                        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper4 = eventsFileHelper3;
                        final List<PaywallStoredEvent> list2 = legacyPaywallsStoredEvents;
                        EventsManager.enqueue$default(eventsManager3, null, new Function0() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3878invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m3878invoke() {
                                if (z) {
                                    eventsFileHelper4.clear(list2.size());
                                }
                            }
                        }, 1, null);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                        return Unit.INSTANCE;
                    }
                });
            }
        }, 1, null);
    }

    private final List<BackendStoredEvent> getStoredEvents() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = CollectionsKt.emptyList();
        this.fileHelper.readFile(new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager.getStoredEvents.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Sequence) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Sequence sequence) {
                Intrinsics.checkNotNullParameter(sequence, "sequence");
                ref$ObjectRef.element = SequencesKt.toList(SequencesKt.take(sequence, 50));
            }
        });
        return (List) ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PaywallStoredEvent> getLegacyPaywallsStoredEvents() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = CollectionsKt.emptyList();
        EventsFileHelper<PaywallStoredEvent> eventsFileHelper = this.legacyEventsFileHelper;
        if (eventsFileHelper != null) {
            eventsFileHelper.readFile(new Function1() { // from class: com.revenuecat.purchases.common.events.EventsManager.getLegacyPaywallsStoredEvents.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Sequence) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Sequence sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    ref$ObjectRef.element = SequencesKt.toList(SequencesKt.take(sequence, 50));
                }
            });
        }
        return (List) ref$ObjectRef.element;
    }

    static /* synthetic */ void enqueue$default(EventsManager eventsManager, Delay delay, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            delay = Delay.NONE;
        }
        eventsManager.enqueue(delay, function0);
    }

    private final void enqueue(Delay delay, final Function0 command) {
        this.eventsDispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.common.events.EventsManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, delay);
    }
}
