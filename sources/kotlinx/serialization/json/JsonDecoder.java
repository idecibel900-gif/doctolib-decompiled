package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: loaded from: classes5.dex */
public interface JsonDecoder extends Decoder, CompositeDecoder {
    JsonElement decodeJsonElement();

    Json getJson();
}
