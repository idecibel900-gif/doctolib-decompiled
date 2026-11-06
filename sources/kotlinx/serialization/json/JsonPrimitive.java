package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "isString", "", "()Z", "toString", "Companion", "Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonNull;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class JsonPrimitive extends JsonElement {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ JsonPrimitive(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getContent();

    public abstract boolean isString();

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return JsonPrimitiveSerializer.INSTANCE;
        }
    }

    private JsonPrimitive() {
        super(null);
    }

    public String toString() {
        return getContent();
    }
}
