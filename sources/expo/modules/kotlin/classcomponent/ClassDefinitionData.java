package expo.modules.kotlin.classcomponent;

import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassDefinitionData {
    private final SyncFunctionComponent constructor;
    private final boolean isSharedRef;
    private final String name;
    private final ObjectDefinitionData objectDefinition;
    private final Map staticAsyncFunctions;
    private final Map staticSyncFunctions;

    public ClassDefinitionData(String name, SyncFunctionComponent constructor, Map staticSyncFunctions, Map staticAsyncFunctions, ObjectDefinitionData objectDefinition, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(staticSyncFunctions, "staticSyncFunctions");
        Intrinsics.checkNotNullParameter(staticAsyncFunctions, "staticAsyncFunctions");
        Intrinsics.checkNotNullParameter(objectDefinition, "objectDefinition");
        this.name = name;
        this.constructor = constructor;
        this.staticSyncFunctions = staticSyncFunctions;
        this.staticAsyncFunctions = staticAsyncFunctions;
        this.objectDefinition = objectDefinition;
        this.isSharedRef = z;
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final ObjectDefinitionData getObjectDefinition() {
        return this.objectDefinition;
    }

    public final boolean isSharedRef() {
        return this.isSharedRef;
    }

    public final ConcatIterator getStaticFunctions() {
        return new ConcatIterator(this.staticSyncFunctions.values().iterator(), this.staticAsyncFunctions.values().iterator());
    }
}
