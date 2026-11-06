package com.revenuecat.purchases.paywalls.components.common;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00032\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background;", "", "Color", "Companion", "Image", "Unknown", "Video", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Color;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Image;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Background {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return BackgroundDeserializer.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "seen1", "", "type", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Unknown implements Background {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String type;

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.type;
            }
            return unknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Unknown copy(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Unknown(type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && Intrinsics.areEqual(this.type, ((Unknown) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Unknown(type=" + this.type + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Background$Unknown$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Unknown(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, Background$Unknown$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
        }

        public Unknown(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Color;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "seen1", "", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Color implements Background {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ColorScheme value;

        public static /* synthetic */ Color copy$default(Color color, ColorScheme colorScheme, int i, Object obj) {
            if ((i & 1) != 0) {
                colorScheme = color.value;
            }
            return color.copy(colorScheme);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ColorScheme getValue() {
            return this.value;
        }

        public final Color copy(ColorScheme value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Color(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Color) && Intrinsics.areEqual(this.value, ((Color) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Color(value=" + this.value + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Color$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Color;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Background$Color$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Color(int i, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, Background$Color$$serializer.INSTANCE.getDescriptor());
            }
            this.value = colorScheme;
        }

        public Color(ColorScheme value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final /* synthetic */ ColorScheme getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Image;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "seen1", "", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "colorOverlay", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "getColorOverlay$annotations", "()V", "getColorOverlay", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFitMode$annotations", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Image implements Background {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ColorScheme colorOverlay;
        private final FitMode fitMode;
        private final ThemeImageUrls value;

        public static /* synthetic */ Image copy$default(Image image, ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i, Object obj) {
            if ((i & 1) != 0) {
                themeImageUrls = image.value;
            }
            if ((i & 2) != 0) {
                fitMode = image.fitMode;
            }
            if ((i & 4) != 0) {
                colorScheme = image.colorOverlay;
            }
            return image.copy(themeImageUrls, fitMode, colorScheme);
        }

        public static /* synthetic */ void getColorOverlay$annotations() {
        }

        public static /* synthetic */ void getFitMode$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThemeImageUrls getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FitMode getFitMode() {
            return this.fitMode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }

        public final Image copy(ThemeImageUrls value, FitMode fitMode, ColorScheme colorOverlay) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            return new Image(value, fitMode, colorOverlay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return Intrinsics.areEqual(this.value, image.value) && this.fitMode == image.fitMode && Intrinsics.areEqual(this.colorOverlay, image.colorOverlay);
        }

        public int hashCode() {
            int iHashCode = ((this.value.hashCode() * 31) + this.fitMode.hashCode()) * 31;
            ColorScheme colorScheme = this.colorOverlay;
            return iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode());
        }

        public String toString() {
            return "Image(value=" + this.value + ", fitMode=" + this.fitMode + ", colorOverlay=" + this.colorOverlay + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Image$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Image;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Background$Image$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Image(int i, ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, Background$Image$$serializer.INSTANCE.getDescriptor());
            }
            this.value = themeImageUrls;
            if ((i & 2) == 0) {
                this.fitMode = FitMode.FILL;
            } else {
                this.fitMode = fitMode;
            }
            if ((i & 4) == 0) {
                this.colorOverlay = null;
            } else {
                this.colorOverlay = colorScheme;
            }
        }

        public Image(ThemeImageUrls value, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            this.value = value;
            this.fitMode = fitMode;
            this.colorOverlay = colorScheme;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Image self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, ThemeImageUrls$$serializer.INSTANCE, self.value);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fitMode != FitMode.FILL) {
                output.encodeSerializableElement(serialDesc, 1, FitModeDeserializer.INSTANCE, self.fitMode);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.colorOverlay == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, ColorScheme$$serializer.INSTANCE, self.colorOverlay);
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public /* synthetic */ Image(ThemeImageUrls themeImageUrls, FitMode fitMode, ColorScheme colorScheme, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(themeImageUrls, (i & 2) != 0 ? FitMode.FILL : fitMode, (i & 4) != 0 ? null : colorScheme);
        }

        public final /* synthetic */ FitMode getFitMode() {
            return this.fitMode;
        }

        public final /* synthetic */ ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "seen1", "", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "fallbackImage", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "loop", "", "muteAudio", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "colorOverlay", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;ZZLcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;ZZLcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "getColorOverlay$annotations", "()V", "getColorOverlay", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFallbackImage$annotations", "getFallbackImage", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getFitMode$annotations", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getLoop", "()Z", "getMuteAudio$annotations", "getMuteAudio", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Video implements Background {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ColorScheme colorOverlay;
        private final ThemeImageUrls fallbackImage;
        private final FitMode fitMode;
        private final boolean loop;
        private final boolean muteAudio;
        private final ThemeVideoUrls value;

        public static /* synthetic */ Video copy$default(Video video, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z, boolean z2, FitMode fitMode, ColorScheme colorScheme, int i, Object obj) {
            if ((i & 1) != 0) {
                themeVideoUrls = video.value;
            }
            if ((i & 2) != 0) {
                themeImageUrls = video.fallbackImage;
            }
            if ((i & 4) != 0) {
                z = video.loop;
            }
            if ((i & 8) != 0) {
                z2 = video.muteAudio;
            }
            if ((i & 16) != 0) {
                fitMode = video.fitMode;
            }
            if ((i & 32) != 0) {
                colorScheme = video.colorOverlay;
            }
            FitMode fitMode2 = fitMode;
            ColorScheme colorScheme2 = colorScheme;
            return video.copy(themeVideoUrls, themeImageUrls, z, z2, fitMode2, colorScheme2);
        }

        public static /* synthetic */ void getColorOverlay$annotations() {
        }

        public static /* synthetic */ void getFallbackImage$annotations() {
        }

        public static /* synthetic */ void getFitMode$annotations() {
        }

        public static /* synthetic */ void getMuteAudio$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThemeVideoUrls getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getLoop() {
            return this.loop;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getMuteAudio() {
            return this.muteAudio;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FitMode getFitMode() {
            return this.fitMode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }

        public final Video copy(ThemeVideoUrls value, ThemeImageUrls fallbackImage, boolean loop, boolean muteAudio, FitMode fitMode, ColorScheme colorOverlay) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            return new Video(value, fallbackImage, loop, muteAudio, fitMode, colorOverlay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.value, video.value) && Intrinsics.areEqual(this.fallbackImage, video.fallbackImage) && this.loop == video.loop && this.muteAudio == video.muteAudio && this.fitMode == video.fitMode && Intrinsics.areEqual(this.colorOverlay, video.colorOverlay);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.value.hashCode() * 31) + this.fallbackImage.hashCode()) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.fitMode.hashCode()) * 31;
            ColorScheme colorScheme = this.colorOverlay;
            return iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode());
        }

        public String toString() {
            return "Video(value=" + this.value + ", fallbackImage=" + this.fallbackImage + ", loop=" + this.loop + ", muteAudio=" + this.muteAudio + ", fitMode=" + this.fitMode + ", colorOverlay=" + this.colorOverlay + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/Background$Video$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return Background$Video$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Video(int i, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z, boolean z2, FitMode fitMode, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, Background$Video$$serializer.INSTANCE.getDescriptor());
            }
            this.value = themeVideoUrls;
            this.fallbackImage = themeImageUrls;
            this.loop = z;
            this.muteAudio = z2;
            if ((i & 16) == 0) {
                this.fitMode = FitMode.FILL;
            } else {
                this.fitMode = fitMode;
            }
            if ((i & 32) == 0) {
                this.colorOverlay = null;
            } else {
                this.colorOverlay = colorScheme;
            }
        }

        public Video(ThemeVideoUrls value, ThemeImageUrls fallbackImage, boolean z, boolean z2, FitMode fitMode, ColorScheme colorScheme) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            this.value = value;
            this.fallbackImage = fallbackImage;
            this.loop = z;
            this.muteAudio = z2;
            this.fitMode = fitMode;
            this.colorOverlay = colorScheme;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Video self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, ThemeVideoUrls$$serializer.INSTANCE, self.value);
            output.encodeSerializableElement(serialDesc, 1, ThemeImageUrls$$serializer.INSTANCE, self.fallbackImage);
            output.encodeBooleanElement(serialDesc, 2, self.loop);
            output.encodeBooleanElement(serialDesc, 3, self.muteAudio);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fitMode != FitMode.FILL) {
                output.encodeSerializableElement(serialDesc, 4, FitModeDeserializer.INSTANCE, self.fitMode);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.colorOverlay == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, ColorScheme$$serializer.INSTANCE, self.colorOverlay);
        }

        public final /* synthetic */ ThemeVideoUrls getValue() {
            return this.value;
        }

        public final /* synthetic */ ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        public final /* synthetic */ boolean getLoop() {
            return this.loop;
        }

        public final /* synthetic */ boolean getMuteAudio() {
            return this.muteAudio;
        }

        public /* synthetic */ Video(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z, boolean z2, FitMode fitMode, ColorScheme colorScheme, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(themeVideoUrls, themeImageUrls, z, z2, (i & 16) != 0 ? FitMode.FILL : fitMode, (i & 32) != 0 ? null : colorScheme);
        }

        public final /* synthetic */ FitMode getFitMode() {
            return this.fitMode;
        }

        public final /* synthetic */ ColorScheme getColorOverlay() {
            return this.colorOverlay;
        }
    }
}
