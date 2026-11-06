package kotlinx.serialization.modules;

import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SerializersModuleKt {
    private static final SerializersModule EmptySerializersModule = new SerialModuleImpl(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());

    public static final SerializersModule getEmptySerializersModule() {
        return EmptySerializersModule;
    }
}
