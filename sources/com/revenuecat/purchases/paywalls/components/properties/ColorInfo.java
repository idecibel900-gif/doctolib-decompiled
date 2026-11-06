package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00032\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "", "Alias", "Companion", "Gradient", "Hex", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Hex;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ColorInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", Reflection.getOrCreateKotlinClass(ColorInfo.class), new KClass[]{Reflection.getOrCreateKotlinClass(Alias.class), Reflection.getOrCreateKotlinClass(Gradient.Linear.class), Reflection.getOrCreateKotlinClass(Gradient.Radial.class), Reflection.getOrCreateKotlinClass(Hex.class)}, new KSerializer[]{ColorInfo$Alias$$serializer.INSTANCE, ColorInfo$Gradient$Linear$$serializer.INSTANCE, ColorInfo$Gradient$Radial$$serializer.INSTANCE, ColorInfo$Hex$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013HÁ\u0001¢\u0006\u0002\b\u0014R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Hex;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "seen1", "", "value", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(I)V", "getValue$annotations", "()V", "getValue", "()I", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Hex implements ColorInfo {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        public static /* synthetic */ void getValue$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Hex) && this.value == ((Hex) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "Hex(value=" + this.value + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Hex$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Hex;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return ColorInfo$Hex$$serializer.INSTANCE;
            }
        }

        public Hex(int i) {
            this.value = i;
        }

        @Deprecated
        public /* synthetic */ Hex(int i, int i2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ColorInfo$Hex$$serializer.INSTANCE.getDescriptor());
            }
            this.value = i2;
        }

        public final /* synthetic */ int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013HÁ\u0001¢\u0006\u0002\b\u0014R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "seen1", "", "value", "Lcom/revenuecat/purchases/ColorAlias;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-671NwFM", "()Ljava/lang/String;", "Ljava/lang/String;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Alias implements ColorInfo {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String value;

        @Deprecated
        public /* synthetic */ Alias(int i, String str, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, serializationConstructorMarker);
        }

        public /* synthetic */ Alias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Alias) && ColorAlias.m3740equalsimpl0(this.value, ((Alias) obj).value);
        }

        public int hashCode() {
            return ColorAlias.m3741hashCodeimpl(this.value);
        }

        public String toString() {
            return "Alias(value=" + ((Object) ColorAlias.m3742toStringimpl(this.value)) + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return ColorInfo$Alias$$serializer.INSTANCE;
            }
        }

        private Alias(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ColorInfo$Alias$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        private Alias(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        /* JADX INFO: renamed from: getValue-671NwFM, reason: not valid java name and from getter */
        public final /* synthetic */ String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "Linear", "Point", "Radial", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Linear;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Radial;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Gradient extends ColorInfo {

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Linear;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient;", "seen1", "", "degrees", "", "points", "", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(FLjava/util/List;)V", "getDegrees", "()F", "getPoints", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Linear implements Gradient {
            private final float degrees;
            private final List<Point> points;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Linear)) {
                    return false;
                }
                Linear linear = (Linear) obj;
                return Float.compare(this.degrees, linear.degrees) == 0 && Intrinsics.areEqual(this.points, linear.points);
            }

            public int hashCode() {
                return (Float.hashCode(this.degrees) * 31) + this.points.hashCode();
            }

            public String toString() {
                return "Linear(degrees=" + this.degrees + ", points=" + this.points + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Linear$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Linear;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ColorInfo$Gradient$Linear$$serializer.INSTANCE;
                }
            }

            public Linear(float f, List<Point> points) {
                Intrinsics.checkNotNullParameter(points, "points");
                this.degrees = f;
                this.points = points;
            }

            @Deprecated
            public /* synthetic */ Linear(int i, float f, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ColorInfo$Gradient$Linear$$serializer.INSTANCE.getDescriptor());
                }
                this.degrees = f;
                this.points = list;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Linear self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer[] kSerializerArr = $childSerializers;
                output.encodeFloatElement(serialDesc, 0, self.degrees);
                output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.points);
            }

            public final /* synthetic */ float getDegrees() {
                return this.degrees;
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013HÁ\u0001¢\u0006\u0002\b\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Radial;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient;", "seen1", "", "points", "", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "getPoints", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Radial implements Gradient {
            private final List<Point> points;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {new ArrayListSerializer(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Radial) && Intrinsics.areEqual(this.points, ((Radial) obj).points);
            }

            public int hashCode() {
                return this.points.hashCode();
            }

            public String toString() {
                return "Radial(points=" + this.points + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Radial$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Radial;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ColorInfo$Gradient$Radial$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Radial(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, ColorInfo$Gradient$Radial$$serializer.INSTANCE.getDescriptor());
                }
                this.points = list;
            }

            public Radial(List<Point> points) {
                Intrinsics.checkNotNullParameter(points, "points");
                this.points = points;
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB+\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0017\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point;", "", "seen1", "", "color", "percent", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IF)V", "getColor$annotations", "()V", "getColor", "()I", "getPercent", "()F", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Point {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final int color;
            private final float percent;

            public static /* synthetic */ void getColor$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point point = (Point) obj;
                return this.color == point.color && Float.compare(this.percent, point.percent) == 0;
            }

            public int hashCode() {
                return (this.color * 31) + Float.hashCode(this.percent);
            }

            public String toString() {
                return "Point(color=" + this.color + ", percent=" + this.percent + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ColorInfo$Gradient$Point$$serializer.INSTANCE;
                }
            }

            public Point(int i, float f) {
                this.color = i;
                this.percent = f;
            }

            @Deprecated
            public /* synthetic */ Point(int i, int i2, float f, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ColorInfo$Gradient$Point$$serializer.INSTANCE.getDescriptor());
                }
                this.color = i2;
                this.percent = f;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Point self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(self.color));
                output.encodeFloatElement(serialDesc, 1, self.percent);
            }

            public final /* synthetic */ int getColor() {
                return this.color;
            }

            public final /* synthetic */ float getPercent() {
                return this.percent;
            }
        }
    }
}
