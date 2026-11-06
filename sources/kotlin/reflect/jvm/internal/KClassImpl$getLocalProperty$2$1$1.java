package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class KClassImpl$getLocalProperty$2$1$1 extends FunctionReferenceImpl implements Function2 {
    public static final KClassImpl$getLocalProperty$2$1$1 INSTANCE = new KClassImpl$getLocalProperty$2$1$1();

    KClassImpl$getLocalProperty$2$1$1() {
        super(2, MemberDeserializer.class, "loadProperty", "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final PropertyDescriptor invoke(MemberDeserializer p0, ProtoBuf$Property p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return p0.loadProperty(p1);
    }
}
