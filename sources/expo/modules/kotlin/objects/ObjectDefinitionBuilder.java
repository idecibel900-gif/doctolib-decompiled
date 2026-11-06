package expo.modules.kotlin.objects;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import expo.modules.kotlin.EnumExtensionsKt;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ObjectDefinitionBuilder {
    private final TypeConverterProvider converters;
    private EventsDefinition eventsDefinition;
    private Function0 legacyConstantsProvider = new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MapsKt.emptyMap();
        }
    };
    private Map syncFunctions = new LinkedHashMap();
    private Map syncFunctionBuilder = new LinkedHashMap();
    private Map asyncFunctions = new LinkedHashMap();
    private Map asyncFunctionBuilders = new LinkedHashMap();
    private Map properties = new LinkedHashMap();
    private Map constants = new LinkedHashMap();
    private final List eventObservers = new ArrayList();

    public ObjectDefinitionBuilder(TypeConverterProvider typeConverterProvider) {
        this.converters = typeConverterProvider;
    }

    public final TypeConverterProvider getConverters() {
        return this.converters;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final void setEventsDefinition(EventsDefinition eventsDefinition) {
        this.eventsDefinition = eventsDefinition;
    }

    public final Map getSyncFunctions() {
        return this.syncFunctions;
    }

    public final Map getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final Map getProperties() {
        return this.properties;
    }

    public final Map getConstants() {
        return this.constants;
    }

    public final ObjectDefinitionData buildObject() {
        AsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent;
        for (final EventObservingDefinition.Type type : EventObservingDefinition.Type.getEntries()) {
            if (!this.asyncFunctions.containsKey(type.getValue())) {
                String value = type.getValue();
                if (Intrinsics.areEqual(String.class, Promise.class)) {
                    asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(value, new AnyType[0], new Function2() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$1
                        /* JADX WARN: Multi-variable type inference failed */
                        public final void invoke(Object[] objArr, Promise promise) {
                            Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                            Intrinsics.checkNotNullParameter(promise, "promise");
                            String str = (String) promise;
                            Iterator it = this.this$0.eventObservers.iterator();
                            while (it.hasNext()) {
                                ((EventObservingDefinition) it.next()).invokedIfNeed(type, str);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Object[]) obj, (Promise) obj2);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    TypeConverterProvider converters = getConverters();
                    AnyType anyType = (AnyType) AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), Boolean.FALSE));
                    if (anyType == null) {
                        anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
                            }
                        }), converters);
                    }
                    AnyType[] anyTypeArr = {anyType};
                    Function1 function1 = new Function1() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object[] objArr) {
                            Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                            String str = (String) objArr[0];
                            Iterator it = this.this$0.eventObservers.iterator();
                            while (it.hasNext()) {
                                ((EventObservingDefinition) it.next()).invokedIfNeed(type, str);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                        stringAsyncFunctionComponent = new IntAsyncFunctionComponent(value, anyTypeArr, function1);
                    } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        stringAsyncFunctionComponent = new BoolAsyncFunctionComponent(value, anyTypeArr, function1);
                    } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent(value, anyTypeArr, function1);
                    } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                        stringAsyncFunctionComponent = new FloatAsyncFunctionComponent(value, anyTypeArr, function1);
                    } else {
                        stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent(value, anyTypeArr, function1) : new UntypedAsyncFunctionComponent(value, anyTypeArr, function1);
                    }
                    asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent;
                }
                getAsyncFunctions().put(value, asyncFunctionWithPromiseComponent);
            }
        }
        Map map = this.asyncFunctions;
        Map map2 = this.asyncFunctionBuilders;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map mutableMap = MapsKt.toMutableMap(MapsKt.plus(map, linkedHashMap));
        Function0 function0 = this.legacyConstantsProvider;
        Map map3 = this.syncFunctions;
        Map map4 = this.syncFunctionBuilder;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        Iterator it = map4.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            entry2.getKey();
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(entry2.getValue());
            throw null;
        }
        Map mapPlus = MapsKt.plus(map3, linkedHashMap2);
        EventsDefinition eventsDefinition = this.eventsDefinition;
        Map map5 = this.properties;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
        for (Map.Entry entry3 : map5.entrySet()) {
            linkedHashMap3.put(entry3.getKey(), ((PropertyComponentBuilder) entry3.getValue()).build());
        }
        Map map6 = this.constants;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map6.size()));
        for (Map.Entry entry4 : map6.entrySet()) {
            linkedHashMap4.put(entry4.getKey(), ((ConstantComponentBuilder) entry4.getValue()).build());
        }
        return new ObjectDefinitionData(function0, mapPlus, mutableMap, eventsDefinition, linkedHashMap3, linkedHashMap4);
    }

    public final void Constants(Function0 legacyConstantsProvider) {
        Intrinsics.checkNotNullParameter(legacyConstantsProvider, "legacyConstantsProvider");
        this.legacyConstantsProvider = legacyConstantsProvider;
    }

    public final AsyncFunctionBuilder AsyncFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(name, this.converters);
        this.asyncFunctionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final void Events(String... events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.eventsDefinition = new EventsDefinition((String[]) ArraysKt.asList(events).toArray(new String[0]));
    }

    public final void OnStartObserving(String eventName, Function0 body) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StartObserving, new EventObservingDefinition.SelectedEventFiler(eventName), body));
    }

    public final void OnStartObserving(Enum r2, Function0 body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        Intrinsics.checkNotNullParameter(body, "body");
        OnStartObserving(EnumExtensionsKt.convertToString(r2), body);
    }

    public final void OnStopObserving(String eventName, Function0 body) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StopObserving, new EventObservingDefinition.SelectedEventFiler(eventName), body));
    }

    public final void OnStopObserving(Enum r2, Function0 body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        Intrinsics.checkNotNullParameter(body, "body");
        OnStopObserving(EnumExtensionsKt.convertToString(r2), body);
    }
}
