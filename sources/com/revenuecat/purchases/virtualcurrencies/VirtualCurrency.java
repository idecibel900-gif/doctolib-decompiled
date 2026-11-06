package com.revenuecat.purchases.virtualcurrencies;

import android.os.Parcel;
import android.os.Parcelable;
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
import kotlinx.serialization.internal.StringSerializer;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#BA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB+\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dJ\u0019\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "Landroid/os/Parcelable;", "seen1", "", "balance", "name", "", ResponseTypeValues.CODE, "serverDescription", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBalance", "()I", "getCode", "()Ljava/lang/String;", "getName", "getServerDescription$annotations", "()V", "getServerDescription", "describeContents", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrency implements Parcelable {
    private final int balance;
    private final String code;
    private final String name;
    private final String serverDescription;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<VirtualCurrency> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VirtualCurrency> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VirtualCurrency(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency[] newArray(int i) {
            return new VirtualCurrency[i];
        }
    }

    public static /* synthetic */ void getServerDescription$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VirtualCurrency)) {
            return false;
        }
        VirtualCurrency virtualCurrency = (VirtualCurrency) obj;
        return this.balance == virtualCurrency.balance && Intrinsics.areEqual(this.name, virtualCurrency.name) && Intrinsics.areEqual(this.code, virtualCurrency.code) && Intrinsics.areEqual(this.serverDescription, virtualCurrency.serverDescription);
    }

    public int hashCode() {
        int iHashCode = ((((this.balance * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.serverDescription;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VirtualCurrency(balance=" + this.balance + ", name=" + this.name + ", code=" + this.code + ", serverDescription=" + this.serverDescription + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.balance);
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.serverDescription);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return VirtualCurrency$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ VirtualCurrency(int i, int i2, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, VirtualCurrency$$serializer.INSTANCE.getDescriptor());
        }
        this.balance = i2;
        this.name = str;
        this.code = str2;
        if ((i & 8) == 0) {
            this.serverDescription = null;
        } else {
            this.serverDescription = str3;
        }
    }

    @InternalRevenueCatAPI
    public VirtualCurrency(int i, String name, String code, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(code, "code");
        this.balance = i;
        this.name = name;
        this.code = code;
        this.serverDescription = str;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VirtualCurrency self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.balance);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.code);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.serverDescription == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.serverDescription);
    }

    public /* synthetic */ VirtualCurrency(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i2 & 8) != 0 ? null : str3);
    }

    public final int getBalance() {
        return this.balance;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }
}
