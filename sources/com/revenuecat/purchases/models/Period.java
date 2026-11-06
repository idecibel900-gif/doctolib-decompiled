package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/models/Period;", "Landroid/os/Parcelable;", "value", "", "unit", "Lcom/revenuecat/purchases/models/Period$Unit;", "iso8601", "", "(ILcom/revenuecat/purchases/models/Period$Unit;Ljava/lang/String;)V", "getIso8601", "()Ljava/lang/String;", "getUnit", "()Lcom/revenuecat/purchases/models/Period$Unit;", "getValue", "()I", "valueInDays", "", "getValueInDays$annotations", "()V", "getValueInDays", "()D", "valueInMonths", "getValueInMonths", "valueInWeeks", "getValueInWeeks$annotations", "getValueInWeeks", "valueInYears", "getValueInYears$annotations", "getValueInYears", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Factory", "Unit", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Period implements Parcelable {
    private final String iso8601;
    private final Unit unit;
    private final int value;

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Period> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Period> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Period(parcel.readInt(), Unit.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period[] newArray(int i) {
            return new Period[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Unit;", "", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "YEAR", "UNKNOWN", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Unit {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        UNKNOWN
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Unit.values().length];
            try {
                iArr[Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInDays$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInWeeks$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInYears$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.value == period.value && this.unit == period.unit && Intrinsics.areEqual(this.iso8601, period.iso8601);
    }

    public int hashCode() {
        return (((this.value * 31) + this.unit.hashCode()) * 31) + this.iso8601.hashCode();
    }

    public String toString() {
        return "Period(value=" + this.value + ", unit=" + this.unit + ", iso8601=" + this.iso8601 + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.value);
        parcel.writeString(this.unit.name());
        parcel.writeString(this.iso8601);
    }

    public Period(int i, Unit unit, String iso8601) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(iso8601, "iso8601");
        this.value = i;
        this.unit = unit;
        this.iso8601 = iso8601;
    }

    public final int getValue() {
        return this.value;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final String getIso8601() {
        return this.iso8601;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.models.Period$Factory, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Factory;", "", "()V", "create", "Lcom/revenuecat/purchases/models/Period;", "iso8601", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Period create(String iso8601) {
            Intrinsics.checkNotNullParameter(iso8601, "iso8601");
            Pair period = PeriodKt.toPeriod(iso8601);
            return new Period(((Number) period.getFirst()).intValue(), (Unit) period.getSecond(), iso8601);
        }
    }

    public final double getValueInDays() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return this.value;
        }
        if (i == 2) {
            return ((double) this.value) * 7.0d;
        }
        if (i == 3) {
            return ((double) this.value) * 30.0d;
        }
        if (i == 4) {
            return ((double) this.value) * 365.0d;
        }
        if (i == 5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in days: " + this.unit, null);
            return 0.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getValueInWeeks() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return ((double) this.value) / 7.0d;
        }
        if (i == 2) {
            return this.value;
        }
        if (i == 3) {
            return ((double) this.value) * 4.345238095238096d;
        }
        if (i == 4) {
            return ((double) this.value) * 52.142857142857146d;
        }
        if (i == 5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in weeks: " + this.unit, null);
            return 0.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getValueInMonths() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return ((double) this.value) / 30.0d;
        }
        if (i == 2) {
            return ((double) this.value) / 4.345238095238096d;
        }
        if (i == 3) {
            return this.value;
        }
        if (i == 4) {
            return ((double) this.value) * 12.0d;
        }
        if (i == 5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in months: " + this.unit, null);
            return 0.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getValueInYears() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return ((double) this.value) / 365.0d;
        }
        if (i == 2) {
            return ((double) this.value) / 52.142857142857146d;
        }
        if (i == 3) {
            return ((double) this.value) / 12.0d;
        }
        if (i == 4) {
            return this.value;
        }
        if (i == 5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in years: " + this.unit, null);
            return 0.0d;
        }
        throw new NoWhenBranchMatchedException();
    }
}
