package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002()B]\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\u0010J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0019¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "defaultValue", "", "name", "", "thumbColorOn", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "thumbColorOff", "trackColorOn", "trackColorOff", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "getDefaultValue$annotations", "()V", "getDefaultValue", "()Z", "getName", "()Ljava/lang/String;", "getThumbColorOff$annotations", "getThumbColorOff", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getThumbColorOn$annotations", "getThumbColorOn", "getTrackColorOff$annotations", "getTrackColorOff", "getTrackColorOn$annotations", "getTrackColorOn", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabControlToggleComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean defaultValue;
    private final String name;
    private final ColorScheme thumbColorOff;
    private final ColorScheme thumbColorOn;
    private final ColorScheme trackColorOff;
    private final ColorScheme trackColorOn;

    public static /* synthetic */ void getDefaultValue$annotations() {
    }

    public static /* synthetic */ void getThumbColorOff$annotations() {
    }

    public static /* synthetic */ void getThumbColorOn$annotations() {
    }

    public static /* synthetic */ void getTrackColorOff$annotations() {
    }

    public static /* synthetic */ void getTrackColorOn$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlToggleComponent)) {
            return false;
        }
        TabControlToggleComponent tabControlToggleComponent = (TabControlToggleComponent) obj;
        return this.defaultValue == tabControlToggleComponent.defaultValue && Intrinsics.areEqual(this.name, tabControlToggleComponent.name) && Intrinsics.areEqual(this.thumbColorOn, tabControlToggleComponent.thumbColorOn) && Intrinsics.areEqual(this.thumbColorOff, tabControlToggleComponent.thumbColorOff) && Intrinsics.areEqual(this.trackColorOn, tabControlToggleComponent.trackColorOn) && Intrinsics.areEqual(this.trackColorOff, tabControlToggleComponent.trackColorOff);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.defaultValue) * 31;
        String str = this.name;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.thumbColorOn.hashCode()) * 31) + this.thumbColorOff.hashCode()) * 31) + this.trackColorOn.hashCode()) * 31) + this.trackColorOff.hashCode();
    }

    public String toString() {
        return "TabControlToggleComponent(defaultValue=" + this.defaultValue + ", name=" + this.name + ", thumbColorOn=" + this.thumbColorOn + ", thumbColorOff=" + this.thumbColorOff + ", trackColorOn=" + this.trackColorOn + ", trackColorOff=" + this.trackColorOff + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return TabControlToggleComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ TabControlToggleComponent(int i, boolean z, String str, ColorScheme colorScheme, ColorScheme colorScheme2, ColorScheme colorScheme3, ColorScheme colorScheme4, SerializationConstructorMarker serializationConstructorMarker) {
        if (61 != (i & 61)) {
            PluginExceptionsKt.throwMissingFieldException(i, 61, TabControlToggleComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.defaultValue = z;
        if ((i & 2) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        this.thumbColorOn = colorScheme;
        this.thumbColorOff = colorScheme2;
        this.trackColorOn = colorScheme3;
        this.trackColorOff = colorScheme4;
    }

    public TabControlToggleComponent(boolean z, String str, ColorScheme thumbColorOn, ColorScheme thumbColorOff, ColorScheme trackColorOn, ColorScheme trackColorOff) {
        Intrinsics.checkNotNullParameter(thumbColorOn, "thumbColorOn");
        Intrinsics.checkNotNullParameter(thumbColorOff, "thumbColorOff");
        Intrinsics.checkNotNullParameter(trackColorOn, "trackColorOn");
        Intrinsics.checkNotNullParameter(trackColorOff, "trackColorOff");
        this.defaultValue = z;
        this.name = str;
        this.thumbColorOn = thumbColorOn;
        this.thumbColorOff = thumbColorOff;
        this.trackColorOn = trackColorOn;
        this.trackColorOff = trackColorOff;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TabControlToggleComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.defaultValue);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, colorScheme$$serializer, self.thumbColorOn);
        output.encodeSerializableElement(serialDesc, 3, colorScheme$$serializer, self.thumbColorOff);
        output.encodeSerializableElement(serialDesc, 4, colorScheme$$serializer, self.trackColorOn);
        output.encodeSerializableElement(serialDesc, 5, colorScheme$$serializer, self.trackColorOff);
    }

    public /* synthetic */ TabControlToggleComponent(boolean z, String str, ColorScheme colorScheme, ColorScheme colorScheme2, ColorScheme colorScheme3, ColorScheme colorScheme4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, colorScheme, colorScheme2, colorScheme3, colorScheme4);
    }

    public final /* synthetic */ boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ ColorScheme getThumbColorOn() {
        return this.thumbColorOn;
    }

    public final /* synthetic */ ColorScheme getThumbColorOff() {
        return this.thumbColorOff;
    }

    public final /* synthetic */ ColorScheme getTrackColorOn() {
        return this.trackColorOn;
    }

    public final /* synthetic */ ColorScheme getTrackColorOff() {
        return this.trackColorOff;
    }
}
