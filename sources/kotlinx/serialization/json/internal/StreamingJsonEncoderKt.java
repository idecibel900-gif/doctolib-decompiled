package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StreamingJsonEncoderKt {
    private static final Set unsignedNumberDescriptors = SetsKt.setOf((Object[]) new SerialDescriptor[]{BuiltinSerializersKt.serializer(UInt.Companion).getDescriptor(), BuiltinSerializersKt.serializer(ULong.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UByte.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UShort.Companion).getDescriptor()});

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }

    public static final boolean isUnquotedLiteral(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && Intrinsics.areEqual(serialDescriptor, JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }
}
