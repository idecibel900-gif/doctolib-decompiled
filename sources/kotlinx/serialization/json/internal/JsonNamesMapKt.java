package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key JsonDeserializationNamesKey = new DescriptorSchemaCache.Key();
    private static final DescriptorSchemaCache.Key JsonSerializationNamesKey = new DescriptorSchemaCache.Key();

    public static final DescriptorSchemaCache.Key getJsonDeserializationNamesKey() {
        return JsonDeserializationNamesKey;
    }

    private static final void buildDeserializationNamesMap$putOrThrow(Map map, SerialDescriptor serialDescriptor, String str, int i) {
        if (map.containsKey(str)) {
            throw new JsonException("The suggested name '" + str + "' for property " + serialDescriptor.getElementName(i) + " is already one of the names for property " + serialDescriptor.getElementName(((Number) MapsKt.getValue(map, str)).intValue()) + " in " + serialDescriptor);
        }
        map.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map buildDeserializationNamesMap(SerialDescriptor serialDescriptor, Json json) {
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        namingStrategy(serialDescriptor, json);
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            List elementAnnotations = serialDescriptor.getElementAnnotations(i);
            ArrayList arrayList = new ArrayList();
            for (Object obj : elementAnnotations) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull((List) arrayList);
            if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                for (String str : strArrNames) {
                    buildDeserializationNamesMap$putOrThrow(linkedHashMap, serialDescriptor, str, i);
                }
            }
        }
        return linkedHashMap.isEmpty() ? MapsKt.emptyMap() : linkedHashMap;
    }

    public static final Map deserializationNamesMap(final Json json, final SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.getSchemaCache(json).getOrPut(descriptor, JsonDeserializationNamesKey, new Function0() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt.deserializationNamesMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map invoke() {
                return JsonNamesMapKt.buildDeserializationNamesMap(descriptor, json);
            }
        });
    }

    public static final String getJsonElementName(SerialDescriptor serialDescriptor, Json json, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        namingStrategy(serialDescriptor, json);
        return serialDescriptor.getElementName(i);
    }

    public static final JsonNamingStrategy namingStrategy(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE)) {
            json.getConfiguration().getNamingStrategy();
        }
        return null;
    }

    private static final int getJsonNameIndex$getJsonNameIndexSlowPath(Json json, SerialDescriptor serialDescriptor, String str) {
        Integer num = (Integer) deserializationNamesMap(json, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String name) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        namingStrategy(serialDescriptor, json);
        int elementIndex = serialDescriptor.getElementIndex(name);
        return (elementIndex == -3 && json.getConfiguration().getUseAlternativeNames()) ? getJsonNameIndex$getJsonNameIndexSlowPath(json, serialDescriptor, name) : elementIndex;
    }

    public static /* synthetic */ int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, name);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
    }
}
