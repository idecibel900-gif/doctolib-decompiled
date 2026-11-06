package expo.modules.kotlin.modules;

import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ModuleDefinitionData {
    private final Map asyncFunctions;
    private final List classData;
    private final Map constants;
    private final Function0 constantsProvider;
    private final Map eventListeners;
    private final EventsDefinition eventsDefinition;
    private final ConcatIterator functions;
    private final String name;
    private final ObjectDefinitionData objectDefinition;
    private final Map properties;
    private final Function2 registerContracts;
    private final Map syncFunctions;
    private final Map viewManagerDefinitions;

    public ModuleDefinitionData(String name, ObjectDefinitionData objectDefinition, Map viewManagerDefinitions, Map eventListeners, Function2 function2, List classData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(objectDefinition, "objectDefinition");
        Intrinsics.checkNotNullParameter(viewManagerDefinitions, "viewManagerDefinitions");
        Intrinsics.checkNotNullParameter(eventListeners, "eventListeners");
        Intrinsics.checkNotNullParameter(classData, "classData");
        this.name = name;
        this.objectDefinition = objectDefinition;
        this.viewManagerDefinitions = viewManagerDefinitions;
        this.eventListeners = eventListeners;
        this.registerContracts = function2;
        this.classData = classData;
        this.constantsProvider = objectDefinition.getLegacyConstantsProvider();
        this.syncFunctions = objectDefinition.getSyncFunctions();
        this.asyncFunctions = objectDefinition.getAsyncFunctions();
        this.eventsDefinition = objectDefinition.getEventsDefinition();
        this.properties = objectDefinition.getProperties();
        this.constants = objectDefinition.getConstants();
        this.functions = objectDefinition.getFunctions();
    }

    public final String getName() {
        return this.name;
    }

    public final ObjectDefinitionData getObjectDefinition() {
        return this.objectDefinition;
    }

    public final Map getViewManagerDefinitions() {
        return this.viewManagerDefinitions;
    }

    public final Map getEventListeners() {
        return this.eventListeners;
    }

    public final Function2 getRegisterContracts() {
        return this.registerContracts;
    }

    public final List getClassData() {
        return this.classData;
    }

    public final Map getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }
}
