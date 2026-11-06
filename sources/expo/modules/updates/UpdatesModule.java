package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.KClassExtensionsKt;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.updates.events.IUpdatesEventManagerObserver;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.reloadscreen.ReloadScreenOptions;
import expo.modules.updates.statemachine.UpdatesStateContext;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lexpo/modules/updates/UpdatesModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "<init>", "()V", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "getLogger", "()Lexpo/modules/updates/logging/UpdatesLogger;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onStateMachineContextEvent", "", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "Companion", "UpdatesConfigurationOverrideParam", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdatesModule extends Module implements IUpdatesEventManagerObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = UpdatesModule.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdatesLogger getLogger() {
        File filesDir = getContext().getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        return new UpdatesLogger(filesDir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions$ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions$ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ArrayList arrayList;
        BaseAsyncFunctionComponent stringAsyncFunctionComponent;
        BaseAsyncFunctionComponent asyncFunctionWithPromiseComponent;
        List parameters;
        Object next;
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExpoUpdates");
            KFunction fastPrimaryConstructor = KClassExtensionsKt.getFastPrimaryConstructor(Reflection.getOrCreateKotlinClass(UpdatesJSEvent.class));
            if (fastPrimaryConstructor == null || (parameters = fastPrimaryConstructor.getParameters()) == null || parameters.size() != 1) {
                UpdatesJSEvent[] updatesJSEventArrValues = UpdatesJSEvent.values();
                arrayList = new ArrayList(updatesJSEventArrValues.length);
                for (UpdatesJSEvent updatesJSEvent : updatesJSEventArrValues) {
                    arrayList.add(updatesJSEvent.name());
                }
            } else {
                String name = ((KParameter) CollectionsKt.first(fastPrimaryConstructor.getParameters())).getName();
                Iterator it = KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(UpdatesJSEvent.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KProperty1) next).getName(), name));
                KProperty1 kProperty1 = (KProperty1) next;
                if (kProperty1 == null) {
                    throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
                }
                if (!Intrinsics.areEqual(kProperty1.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
                    throw new IllegalArgumentException("The enum parameter has to be a string.");
                }
                UpdatesJSEvent[] updatesJSEventArrValues2 = UpdatesJSEvent.values();
                arrayList = new ArrayList(updatesJSEventArrValues2.length);
                for (UpdatesJSEvent updatesJSEvent2 : updatesJSEventArrValues2) {
                    Object obj = kProperty1.get(updatesJSEvent2);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add((String) obj);
                }
            }
            moduleDefinitionBuilder.setEventsDefinition(new EventsDefinition((String[]) arrayList.toArray(new String[0])));
            moduleDefinitionBuilder.Constants(new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map invoke() {
                    File filesDir = this.this$0.getContext().getFilesDir();
                    Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
                    new UpdatesLogger(filesDir).info("UpdatesModule: getConstants called", UpdatesErrorCode.None);
                    return UpdatesController.getInstance().getConstantsForModule().toModuleConstantsMap();
                }
            });
            UpdatesJSEvent updatesJSEvent3 = UpdatesJSEvent.StateChange;
            moduleDefinitionBuilder.OnStartObserving(updatesJSEvent3, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4971invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4971invoke() {
                    UpdatesController.INSTANCE.setUpdatesEventManagerObserver$expo_updates_release(new WeakReference(this.this$0));
                }
            });
            moduleDefinitionBuilder.OnStopObserving(updatesJSEvent3, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$1$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4972invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4972invoke() {
                    UpdatesController.INSTANCE.removeUpdatesEventManagerObserver$expo_updates_release();
                }
            });
            Map eventListeners = moduleDefinitionBuilder.getEventListeners();
            EventName eventName = EventName.MODULE_DESTROY;
            eventListeners.put(eventName, new BasicEventListener(eventName, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4973invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4973invoke() {
                    UpdatesController.INSTANCE.removeUpdatesEventManagerObserver$expo_updates_release();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("reload");
            String name2 = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class);
            Boolean bool = Boolean.TRUE;
            AnyType anyType = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, bool));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class), true, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(ReloadScreenOptions.class);
                    }
                }), converters);
            }
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, new AnyType[]{anyType}, new UpdatesModule$definition$lambda$18$$inlined$Coroutine$2(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("checkForUpdateAsync");
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction2.getName(), new AnyType[0], new UpdatesModule$definition$lambda$18$$inlined$Coroutine$3(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("fetchUpdateAsync");
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction3.getName(), new AnyType[0], new UpdatesModule$definition$lambda$18$$inlined$Coroutine$4(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("getExtraParamsAsync");
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction4.getName(), new AnyType[0], new UpdatesModule$definition$lambda$18$$inlined$Coroutine$5(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("setExtraParamAsync");
            String name3 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction5.getConverters();
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            Boolean bool2 = Boolean.FALSE;
            AnyType anyType2 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass2, bool2));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Coroutine$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            AnyType anyType3 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Coroutine$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters2);
            }
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, new AnyType[]{anyType2, anyType3}, new UpdatesModule$definition$lambda$18$$inlined$Coroutine$8(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("readLogEntriesAsync");
            String name4 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType anyType4 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r3), bool2));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Long.class), false, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Coroutine$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Long.TYPE);
                    }
                }), converters3);
            }
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name4, new AnyType[]{anyType4}, new UpdatesModule$definition$lambda$18$$inlined$Coroutine$10(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("clearLogEntriesAsync");
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction7.getName(), new AnyType[0], new UpdatesModule$definition$lambda$18$$inlined$Coroutine$11(null, this)));
            TypeConverterProvider converters4 = moduleDefinitionBuilder.getConverters();
            AnyType anyType5 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r2), bool));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(UpdatesConfigurationOverrideParam.class), true, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(UpdatesModule.UpdatesConfigurationOverrideParam.class);
                    }
                }), converters4);
            }
            AnyType[] anyTypeArr = {anyType5};
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = (ReturnType) returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType);
            }
            moduleDefinitionBuilder.getSyncFunctions().put("setUpdateURLAndRequestHeadersOverride", new SyncFunctionComponent("setUpdateURLAndRequestHeadersOverride", anyTypeArr, returnType, new Function1() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    UpdatesModule.UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam = (UpdatesModule.UpdatesConfigurationOverrideParam) objArr[0];
                    UpdatesController.getInstance().setUpdateURLAndRequestHeadersOverride(updatesConfigurationOverrideParam != null ? updatesConfigurationOverrideParam.toUpdatesConfigurationOverride() : null);
                    return Unit.INSTANCE;
                }
            }));
            TypeConverterProvider converters5 = moduleDefinitionBuilder.getConverters();
            AnyType anyType6 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r0), bool));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        KTypeProjection.Companion companion = KTypeProjection.Companion;
                        return Reflection.nullableTypeOf(Map.class, companion.invariant(Reflection.typeOf(String.class)), companion.invariant(Reflection.typeOf(String.class)));
                    }
                }), converters5);
            }
            AnyType[] anyTypeArr2 = {anyType6};
            ReturnType returnType2 = (ReturnType) returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType2);
            }
            moduleDefinitionBuilder.getSyncFunctions().put("setUpdateRequestHeadersOverride", new SyncFunctionComponent("setUpdateRequestHeadersOverride", anyTypeArr2, returnType2, new Function1() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    UpdatesController.getInstance().setUpdateRequestHeadersOverride((Map) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            if (Intrinsics.areEqual(ReloadScreenOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("showReloadScreen", new AnyType[0], new Function2() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Object[]) obj2, (Promise) obj3);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters6 = moduleDefinitionBuilder.getConverters();
                AnyType anyType7 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class), bool));
                if (anyType7 == null) {
                    anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class), true, new Function0() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(ReloadScreenOptions.class);
                        }
                    }), converters6);
                }
                AnyType[] anyTypeArr3 = {anyType7};
                Function1 function1 = new Function1() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent = new IntAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1);
                } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1);
                } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1);
                } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                    stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1);
                } else {
                    stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1) : new UntypedAsyncFunctionComponent("showReloadScreen", anyTypeArr3, function1);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("showReloadScreen", asyncFunctionWithPromiseComponent);
            Queues queues = Queues.MAIN;
            asyncFunctionWithPromiseComponent.runOnQueue(queues);
            UntypedAsyncFunctionComponent untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("hideReloadScreen", new AnyType[0], new Function1() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$18$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hideReloadScreen", untypedAsyncFunctionComponent);
            untypedAsyncFunctionComponent.runOnQueue(queues);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object readLogEntries$expo_updates_release(File file, long j, Continuation continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new UpdatesModule$Companion$readLogEntries$2(file, j, null), continuation);
        }

        public final Object clearLogEntries$expo_updates_release(File file, Function1 function1, Continuation continuation) {
            new UpdatesLogReader(file).purgeLogEntries(new Date(), function1);
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.updates.events.IUpdatesEventManagerObserver
    public void onStateMachineContextEvent(UpdatesStateContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UpdatesJSEvent updatesJSEvent = UpdatesJSEvent.StateChange;
        Bundle bundle = new Bundle();
        bundle.putBundle("context", context.getBundle());
        Unit unit = Unit.INSTANCE;
        sendEvent(updatesJSEvent, bundle);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lexpo/modules/updates/UpdatesModule$UpdatesConfigurationOverrideParam;", "Lexpo/modules/kotlin/records/Record;", "updateUrl", "Landroid/net/Uri;", "requestHeaders", "", "", "<init>", "(Landroid/net/Uri;Ljava/util/Map;)V", "getUpdateUrl$annotations", "()V", "getUpdateUrl", "()Landroid/net/Uri;", "getRequestHeaders$annotations", "getRequestHeaders", "()Ljava/util/Map;", "toUpdatesConfigurationOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class UpdatesConfigurationOverrideParam implements Record {
        private final Map<String, String> requestHeaders;
        private final Uri updateUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdatesConfigurationOverrideParam copy$default(UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam, Uri uri, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = updatesConfigurationOverrideParam.updateUrl;
            }
            if ((i & 2) != 0) {
                map = updatesConfigurationOverrideParam.requestHeaders;
            }
            return updatesConfigurationOverrideParam.copy(uri, map);
        }

        @Field
        public static /* synthetic */ void getRequestHeaders$annotations() {
        }

        @Field
        public static /* synthetic */ void getUpdateUrl$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUpdateUrl() {
            return this.updateUrl;
        }

        public final Map<String, String> component2() {
            return this.requestHeaders;
        }

        public final UpdatesConfigurationOverrideParam copy(Uri updateUrl, Map<String, String> requestHeaders) {
            Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            return new UpdatesConfigurationOverrideParam(updateUrl, requestHeaders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatesConfigurationOverrideParam)) {
                return false;
            }
            UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam = (UpdatesConfigurationOverrideParam) other;
            return Intrinsics.areEqual(this.updateUrl, updatesConfigurationOverrideParam.updateUrl) && Intrinsics.areEqual(this.requestHeaders, updatesConfigurationOverrideParam.requestHeaders);
        }

        public int hashCode() {
            return (this.updateUrl.hashCode() * 31) + this.requestHeaders.hashCode();
        }

        public String toString() {
            return "UpdatesConfigurationOverrideParam(updateUrl=" + this.updateUrl + ", requestHeaders=" + this.requestHeaders + ")";
        }

        public UpdatesConfigurationOverrideParam(Uri updateUrl, Map<String, String> requestHeaders) {
            Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.updateUrl = updateUrl;
            this.requestHeaders = requestHeaders;
        }

        public final Uri getUpdateUrl() {
            return this.updateUrl;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public final UpdatesConfigurationOverride toUpdatesConfigurationOverride() {
            return new UpdatesConfigurationOverride(this.updateUrl, this.requestHeaders);
        }
    }
}
