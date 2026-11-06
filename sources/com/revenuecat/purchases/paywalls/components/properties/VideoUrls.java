package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.Checksum$$serializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002'(B[\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "", "seen1", "", "width", "Lkotlin/UInt;", "height", "url", "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "urlLowRes", "checksumLowRes", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlin/UInt;Lkotlin/UInt;Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IILjava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getChecksum", "()Lcom/revenuecat/purchases/models/Checksum;", "getChecksumLowRes$annotations", "()V", "getChecksumLowRes", "getHeight-pVg5ArA", "()I", "I", "getUrl$annotations", "getUrl", "()Ljava/net/URL;", "getUrlLowRes$annotations", "getUrlLowRes", "getWidth-pVg5ArA", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoUrls {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Checksum checksum;
    private final Checksum checksumLowRes;
    private final int height;
    private final URL url;
    private final URL urlLowRes;
    private final int width;

    public /* synthetic */ VideoUrls(int i, int i2, URL url, Checksum checksum, URL url2, Checksum checksum2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, url, checksum, url2, checksum2);
    }

    @Deprecated
    public /* synthetic */ VideoUrls(int i, UInt uInt, UInt uInt2, URL url, Checksum checksum, URL url2, Checksum checksum2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, uInt2, url, checksum, url2, checksum2, serializationConstructorMarker);
    }

    public static /* synthetic */ void getChecksumLowRes$annotations() {
    }

    public static /* synthetic */ void getUrl$annotations() {
    }

    public static /* synthetic */ void getUrlLowRes$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoUrls)) {
            return false;
        }
        VideoUrls videoUrls = (VideoUrls) obj;
        return this.width == videoUrls.width && this.height == videoUrls.height && Intrinsics.areEqual(this.url, videoUrls.url) && Intrinsics.areEqual(this.checksum, videoUrls.checksum) && Intrinsics.areEqual(this.urlLowRes, videoUrls.urlLowRes) && Intrinsics.areEqual(this.checksumLowRes, videoUrls.checksumLowRes);
    }

    public int hashCode() {
        int iHashCode = ((((this.width * 31) + this.height) * 31) + this.url.hashCode()) * 31;
        Checksum checksum = this.checksum;
        int iHashCode2 = (iHashCode + (checksum == null ? 0 : checksum.hashCode())) * 31;
        URL url = this.urlLowRes;
        int iHashCode3 = (iHashCode2 + (url == null ? 0 : url.hashCode())) * 31;
        Checksum checksum2 = this.checksumLowRes;
        return iHashCode3 + (checksum2 != null ? checksum2.hashCode() : 0);
    }

    public String toString() {
        return "VideoUrls(width=" + ((Object) UInt.m5278toStringimpl(this.width)) + ", height=" + ((Object) UInt.m5278toStringimpl(this.height)) + ", url=" + this.url + ", checksum=" + this.checksum + ", urlLowRes=" + this.urlLowRes + ", checksumLowRes=" + this.checksumLowRes + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return VideoUrls$$serializer.INSTANCE;
        }
    }

    private VideoUrls(int i, int i2, URL url, Checksum checksum, URL url2, Checksum checksum2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.width = i;
        this.height = i2;
        this.url = url;
        this.checksum = checksum;
        this.urlLowRes = url2;
        this.checksumLowRes = checksum2;
    }

    private VideoUrls(int i, UInt uInt, UInt uInt2, URL url, Checksum checksum, URL url2, Checksum checksum2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, VideoUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.width = uInt.m5279unboximpl();
        this.height = uInt2.m5279unboximpl();
        this.url = url;
        if ((i & 8) == 0) {
            this.checksum = null;
        } else {
            this.checksum = checksum;
        }
        if ((i & 16) == 0) {
            this.urlLowRes = null;
        } else {
            this.urlLowRes = url2;
        }
        if ((i & 32) == 0) {
            this.checksumLowRes = null;
        } else {
            this.checksumLowRes = checksum2;
        }
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VideoUrls self, CompositeEncoder output, SerialDescriptor serialDesc) {
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 0, uIntSerializer, UInt.m5274boximpl(self.width));
        output.encodeSerializableElement(serialDesc, 1, uIntSerializer, UInt.m5274boximpl(self.height));
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, uRLSerializer, self.url);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.checksum != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Checksum$$serializer.INSTANCE, self.checksum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.urlLowRes != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, uRLSerializer, self.urlLowRes);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.checksumLowRes == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, Checksum$$serializer.INSTANCE, self.checksumLowRes);
    }

    public /* synthetic */ VideoUrls(int i, int i2, URL url, Checksum checksum, URL url2, Checksum checksum2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, url, (i3 & 8) != 0 ? null : checksum, (i3 & 16) != 0 ? null : url2, (i3 & 32) != 0 ? null : checksum2, null);
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name and from getter */
    public final /* synthetic */ int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name and from getter */
    public final /* synthetic */ int getHeight() {
        return this.height;
    }

    public final /* synthetic */ URL getUrl() {
        return this.url;
    }

    public final /* synthetic */ Checksum getChecksum() {
        return this.checksum;
    }

    public final /* synthetic */ URL getUrlLowRes() {
        return this.urlLowRes;
    }

    public final /* synthetic */ Checksum getChecksumLowRes() {
        return this.checksumLowRes;
    }
}
