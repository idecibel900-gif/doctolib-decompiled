package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: loaded from: classes5.dex */
final class JsonPrimitiveEncoder extends AbstractJsonTreeEncoder {
    private JsonElement content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveEncoder(Json json, Function1 nodeConsumer) {
        super(json, nodeConsumer, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(nodeConsumer, "nodeConsumer");
        pushTag("primitive");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void putElement(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        if (key != "primitive") {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
        }
        if (this.content != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.content = element;
        getNodeConsumer().invoke(element);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public JsonElement getCurrent() {
        JsonElement jsonElement = this.content;
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
    }
}
