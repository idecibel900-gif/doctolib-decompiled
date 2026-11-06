package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014HÁ\u0001¢\u0006\u0002\b\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;)V", "getDark", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "getLight", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorScheme {
    private static final KSerializer[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorInfo dark;
    private final ColorInfo light;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorScheme)) {
            return false;
        }
        ColorScheme colorScheme = (ColorScheme) obj;
        return Intrinsics.areEqual(this.light, colorScheme.light) && Intrinsics.areEqual(this.dark, colorScheme.dark);
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ColorInfo colorInfo = this.dark;
        return iHashCode + (colorInfo == null ? 0 : colorInfo.hashCode());
    }

    public String toString() {
        return "ColorScheme(light=" + this.light + ", dark=" + this.dark + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return ColorScheme$$serializer.INSTANCE;
        }
    }

    static {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ColorInfo.class);
        KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(ColorInfo.Alias.class), Reflection.getOrCreateKotlinClass(ColorInfo.Gradient.Linear.class), Reflection.getOrCreateKotlinClass(ColorInfo.Gradient.Radial.class), Reflection.getOrCreateKotlinClass(ColorInfo.Hex.class)};
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = ColorInfo$Alias$$serializer.INSTANCE;
        ColorInfo$Gradient$Linear$$serializer colorInfo$Gradient$Linear$$serializer = ColorInfo$Gradient$Linear$$serializer.INSTANCE;
        ColorInfo$Gradient$Radial$$serializer colorInfo$Gradient$Radial$$serializer = ColorInfo$Gradient$Radial$$serializer.INSTANCE;
        ColorInfo$Hex$$serializer colorInfo$Hex$$serializer = ColorInfo$Hex$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", orCreateKotlinClass, kClassArr, new KSerializer[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0]), new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", Reflection.getOrCreateKotlinClass(ColorInfo.class), new KClass[]{Reflection.getOrCreateKotlinClass(ColorInfo.Alias.class), Reflection.getOrCreateKotlinClass(ColorInfo.Gradient.Linear.class), Reflection.getOrCreateKotlinClass(ColorInfo.Gradient.Radial.class), Reflection.getOrCreateKotlinClass(ColorInfo.Hex.class)}, new KSerializer[]{colorInfo$Alias$$serializer, colorInfo$Gradient$Linear$$serializer, colorInfo$Gradient$Radial$$serializer, colorInfo$Hex$$serializer}, new Annotation[0])};
    }

    @Deprecated
    public /* synthetic */ ColorScheme(int i, ColorInfo colorInfo, ColorInfo colorInfo2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ColorScheme$$serializer.INSTANCE.getDescriptor());
        }
        this.light = colorInfo;
        if ((i & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = colorInfo2;
        }
    }

    public ColorScheme(ColorInfo light, ColorInfo colorInfo) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = colorInfo;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorScheme self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.light);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.dark == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.dark);
    }

    public /* synthetic */ ColorScheme(ColorInfo colorInfo, ColorInfo colorInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorInfo, (i & 2) != 0 ? null : colorInfo2);
    }

    public final /* synthetic */ ColorInfo getLight() {
        return this.light;
    }

    public final /* synthetic */ ColorInfo getDark() {
        return this.dark;
    }
}
