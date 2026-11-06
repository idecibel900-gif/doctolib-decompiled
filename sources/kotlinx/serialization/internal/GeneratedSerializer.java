package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public interface GeneratedSerializer extends KSerializer {
    KSerializer[] childSerializers();

    KSerializer[] typeParametersSerializers();

    public static final class DefaultImpls {
        public static KSerializer[] typeParametersSerializers(GeneratedSerializer generatedSerializer) {
            return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
        }
    }
}
