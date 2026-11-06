package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes5.dex */
public interface JsonEncoder extends Encoder, CompositeEncoder {
    Json getJson();
}
