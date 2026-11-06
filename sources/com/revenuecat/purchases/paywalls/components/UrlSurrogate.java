package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;", "", "seen1", "", "url_lid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrl_lid-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UrlSurrogate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ButtonComponent.UrlMethod method;
    private final String url_lid;

    @Deprecated
    public /* synthetic */ UrlSurrogate(int i, String str, ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, urlMethod, serializationConstructorMarker);
    }

    public /* synthetic */ UrlSurrogate(String str, ButtonComponent.UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, urlMethod);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return UrlSurrogate$$serializer.INSTANCE;
        }
    }

    private UrlSurrogate(int i, String str, ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, UrlSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.url_lid = str;
        this.method = urlMethod;
    }

    private UrlSurrogate(String url_lid, ButtonComponent.UrlMethod method) {
        Intrinsics.checkNotNullParameter(url_lid, "url_lid");
        Intrinsics.checkNotNullParameter(method, "method");
        this.url_lid = url_lid;
        this.method = method;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(UrlSurrogate self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m3989boximpl(self.url_lid));
        output.encodeSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
    }

    public final ButtonComponent.UrlMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: getUrl_lid-z7Tp-4o, reason: not valid java name and from getter */
    public final String getUrl_lid() {
        return this.url_lid;
    }
}
