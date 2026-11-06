package expo.modules.kotlin.objects;

import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.events.EventsDefinition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectDefinitionData {
    private final Map asyncFunctions;
    private final Map constants;
    private final EventsDefinition eventsDefinition;
    private final Function0 legacyConstantsProvider;
    private final Map properties;
    private final Map syncFunctions;

    public ObjectDefinitionData(Function0 legacyConstantsProvider, Map syncFunctions, Map asyncFunctions, EventsDefinition eventsDefinition, Map properties, Map constants) {
        Intrinsics.checkNotNullParameter(legacyConstantsProvider, "legacyConstantsProvider");
        Intrinsics.checkNotNullParameter(syncFunctions, "syncFunctions");
        Intrinsics.checkNotNullParameter(asyncFunctions, "asyncFunctions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.legacyConstantsProvider = legacyConstantsProvider;
        this.syncFunctions = syncFunctions;
        this.asyncFunctions = asyncFunctions;
        this.eventsDefinition = eventsDefinition;
        this.properties = properties;
        this.constants = constants;
    }

    public final Function0 getLegacyConstantsProvider() {
        return this.legacyConstantsProvider;
    }

    public final Map getSyncFunctions() {
        return this.syncFunctions;
    }

    public final Map getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final Map getProperties() {
        return this.properties;
    }

    public final Map getConstants() {
        return this.constants;
    }

    public final ConcatIterator getFunctions() {
        return new ConcatIterator(this.syncFunctions.values().iterator(), this.asyncFunctions.values().iterator());
    }

    public final ObjectDefinitionData plus(final ObjectDefinitionData objectDefinitionData) {
        if (objectDefinitionData == null) {
            return this;
        }
        Function0 function0 = new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ObjectDefinitionData.plus$lambda$0(this.f$0, objectDefinitionData);
            }
        };
        Map mapPlus = MapsKt.plus(this.syncFunctions, objectDefinitionData.syncFunctions);
        Map mapPlus2 = MapsKt.plus(this.asyncFunctions, objectDefinitionData.asyncFunctions);
        EventsDefinition eventsDefinition = this.eventsDefinition;
        return new ObjectDefinitionData(function0, mapPlus, mapPlus2, eventsDefinition != null ? eventsDefinition.plus(objectDefinitionData.eventsDefinition) : null, MapsKt.plus(this.properties, objectDefinitionData.properties), MapsKt.plus(this.constants, objectDefinitionData.constants));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map plus$lambda$0(ObjectDefinitionData objectDefinitionData, ObjectDefinitionData objectDefinitionData2) {
        return MapsKt.plus((Map) objectDefinitionData.legacyConstantsProvider.invoke(), (Map) objectDefinitionData2.legacyConstantsProvider.invoke());
    }
}
