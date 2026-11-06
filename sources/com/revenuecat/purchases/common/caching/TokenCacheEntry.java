package com.revenuecat.purchases.common.caching;

import com.opentok.android.PublisherKit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/caching/TokenCacheEntry;", "", "seen1", "", "isAutoRenewing", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/caching/TokenCacheEntry;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TokenCacheEntry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean isAutoRenewing;

    /* JADX WARN: Multi-variable type inference failed */
    public TokenCacheEntry() {
        this((Boolean) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ TokenCacheEntry copy$default(TokenCacheEntry tokenCacheEntry, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = tokenCacheEntry.isAutoRenewing;
        }
        return tokenCacheEntry.copy(bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getIsAutoRenewing() {
        return this.isAutoRenewing;
    }

    public final TokenCacheEntry copy(Boolean isAutoRenewing) {
        return new TokenCacheEntry(isAutoRenewing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TokenCacheEntry) && Intrinsics.areEqual(this.isAutoRenewing, ((TokenCacheEntry) other).isAutoRenewing);
    }

    public int hashCode() {
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "TokenCacheEntry(isAutoRenewing=" + this.isAutoRenewing + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/caching/TokenCacheEntry$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/caching/TokenCacheEntry;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return TokenCacheEntry$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ TokenCacheEntry(int i, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.isAutoRenewing = null;
        } else {
            this.isAutoRenewing = bool;
        }
    }

    public TokenCacheEntry(Boolean bool) {
        this.isAutoRenewing = bool;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TokenCacheEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.isAutoRenewing == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.isAutoRenewing);
    }

    public /* synthetic */ TokenCacheEntry(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }
}
