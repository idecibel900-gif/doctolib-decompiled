package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TreeJsonEncoderKt {
    public static final JsonElement writeJson(Json json, Object obj, SerializationStrategy serializer) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new JsonTreeEncoder(json, new Function1() { // from class: kotlinx.serialization.json.internal.TreeJsonEncoderKt$writeJson$encoder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((JsonElement) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(JsonElement it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ref$ObjectRef.element = it;
            }
        }).encodeSerializableValue(serializer, obj);
        Object obj2 = ref$ObjectRef.element;
        if (obj2 != null) {
            return (JsonElement) obj2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRequiresTopLevelTag(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.getKind() instanceof PrimitiveKind) || serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE;
    }
}
