package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014HÁ\u0001¢\u0006\u0002\b\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;)V", "getDark", "()Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "getLight", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThemeVideoUrls {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final VideoUrls dark;
    private final VideoUrls light;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThemeVideoUrls)) {
            return false;
        }
        ThemeVideoUrls themeVideoUrls = (ThemeVideoUrls) obj;
        return Intrinsics.areEqual(this.light, themeVideoUrls.light) && Intrinsics.areEqual(this.dark, themeVideoUrls.dark);
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        VideoUrls videoUrls = this.dark;
        return iHashCode + (videoUrls == null ? 0 : videoUrls.hashCode());
    }

    public String toString() {
        return "ThemeVideoUrls(light=" + this.light + ", dark=" + this.dark + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return ThemeVideoUrls$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ ThemeVideoUrls(int i, VideoUrls videoUrls, VideoUrls videoUrls2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ThemeVideoUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.light = videoUrls;
        this.dark = videoUrls2;
    }

    public ThemeVideoUrls(VideoUrls light, VideoUrls videoUrls) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = videoUrls;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ThemeVideoUrls self, CompositeEncoder output, SerialDescriptor serialDesc) {
        VideoUrls$$serializer videoUrls$$serializer = VideoUrls$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 0, videoUrls$$serializer, self.light);
        output.encodeNullableSerializableElement(serialDesc, 1, videoUrls$$serializer, self.dark);
    }

    public final /* synthetic */ VideoUrls getLight() {
        return this.light;
    }

    public final /* synthetic */ VideoUrls getDark() {
        return this.dark;
    }
}
