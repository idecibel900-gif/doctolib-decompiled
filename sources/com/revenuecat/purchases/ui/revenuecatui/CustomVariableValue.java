package com.revenuecat.purchases.ui.revenuecatui;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b'\u0018\u0000 \b2\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "()V", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "Boolean", "Companion", "Number", "String", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CustomVariableValue implements Parcelable {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$String;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class String extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<String> CREATOR = new Creator();
        private final java.lang.String value;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<String> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new String(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String[] newArray(int i) {
                return new String[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.value);
        }

        public String(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            return (other instanceof String) && Intrinsics.areEqual(this.value, ((String) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "CustomVariableValue.String(value=" + this.value + ')';
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Number;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(I)V", "", "(J)V", "", "(F)V", "", "(D)V", "getValue", "()D", "describeContents", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Number extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Number> CREATOR = new Creator();
        private final double value;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Number> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Number(parcel.readDouble());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number[] newArray(int i) {
                return new Number[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeDouble(this.value);
        }

        public Number(double d) {
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }

        public Number(int i) {
            this(i);
        }

        public Number(long j) {
            this(j);
        }

        public Number(float f) {
            this(f);
        }

        public boolean equals(Object other) {
            return (other instanceof Number) && this.value == ((Number) other).value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Number(value=" + this.value + ')';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Boolean;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "Landroid/os/Parcelable;", "value", "", "(Z)V", "getValue", "()Z", "describeContents", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Boolean extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Boolean> CREATOR = new Creator();
        private final boolean value;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Boolean> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Boolean(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean[] newArray(int i) {
                return new Boolean[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.value ? 1 : 0);
        }

        public Boolean(boolean z) {
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            return (other instanceof Boolean) && this.value == ((Boolean) other).value;
        }

        public int hashCode() {
            return java.lang.Boolean.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Boolean(value=" + this.value + ')';
        }
    }

    public final java.lang.String getStringValue() {
        if (this instanceof String) {
            return ((String) this).getValue();
        }
        if (this instanceof Number) {
            Number number = (Number) this;
            if (number.getValue() % 1.0d == 0.0d) {
                return java.lang.String.valueOf((long) number.getValue());
            }
            return java.lang.String.valueOf(number.getValue());
        }
        if (this instanceof Boolean) {
            return java.lang.String.valueOf(((Boolean) this).getValue());
        }
        throw new IllegalStateException("Unknown CustomVariableValue type");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "value", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomVariableValue from(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof java.lang.String) {
                return new String((java.lang.String) value);
            }
            if (value instanceof Integer) {
                return new Number(((java.lang.Number) value).intValue());
            }
            if (value instanceof Long) {
                return new Number(((java.lang.Number) value).longValue());
            }
            if (value instanceof Double) {
                return new Number(((java.lang.Number) value).doubleValue());
            }
            if (value instanceof Float) {
                return new Number(((java.lang.Number) value).floatValue());
            }
            if (value instanceof java.lang.Boolean) {
                return new Boolean(((java.lang.Boolean) value).booleanValue());
            }
            throw new IllegalArgumentException("Unsupported custom variable type: " + Reflection.getOrCreateKotlinClass(value.getClass()).getSimpleName() + ". Supported types are: String, Int, Long, Double, Float, Boolean.");
        }
    }
}
