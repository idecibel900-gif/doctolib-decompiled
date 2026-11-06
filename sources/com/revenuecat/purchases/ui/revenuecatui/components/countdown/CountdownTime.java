package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import com.opentok.android.PublisherKit;
import io.didomi.ssl.config.app.SyncConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\tR\u0017\u0010\u0011\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\t¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "", "days", "", "hours", "minutes", "seconds", "(IIII)V", "getDays", "()I", "getHours", "getMinutes", "getSeconds", "totalHours", "getTotalHours$annotations", "()V", "getTotalHours", "totalMinutes", "getTotalMinutes$annotations", "getTotalMinutes", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CountdownTime {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CountdownTime ZERO = new CountdownTime(0, 0, 0, 0);
    private final int days;
    private final int hours;
    private final int minutes;
    private final int seconds;

    public static /* synthetic */ CountdownTime copy$default(CountdownTime countdownTime, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = countdownTime.days;
        }
        if ((i5 & 2) != 0) {
            i2 = countdownTime.hours;
        }
        if ((i5 & 4) != 0) {
            i3 = countdownTime.minutes;
        }
        if ((i5 & 8) != 0) {
            i4 = countdownTime.seconds;
        }
        return countdownTime.copy(i, i2, i3, i4);
    }

    public static /* synthetic */ void getTotalHours$annotations() {
    }

    public static /* synthetic */ void getTotalMinutes$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDays() {
        return this.days;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHours() {
        return this.hours;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMinutes() {
        return this.minutes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSeconds() {
        return this.seconds;
    }

    public final CountdownTime copy(int days, int hours, int minutes, int seconds) {
        return new CountdownTime(days, hours, minutes, seconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountdownTime)) {
            return false;
        }
        CountdownTime countdownTime = (CountdownTime) other;
        return this.days == countdownTime.days && this.hours == countdownTime.hours && this.minutes == countdownTime.minutes && this.seconds == countdownTime.seconds;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.days) * 31) + Integer.hashCode(this.hours)) * 31) + Integer.hashCode(this.minutes)) * 31) + Integer.hashCode(this.seconds);
    }

    public String toString() {
        return "CountdownTime(days=" + this.days + ", hours=" + this.hours + ", minutes=" + this.minutes + ", seconds=" + this.seconds + ')';
    }

    public CountdownTime(int i, int i2, int i3, int i4) {
        this.days = i;
        this.hours = i2;
        this.minutes = i3;
        this.seconds = i4;
    }

    public final int getDays() {
        return this.days;
    }

    public final int getHours() {
        return this.hours;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getTotalHours() {
        return (this.days * 24) + this.hours;
    }

    public final int getTotalMinutes() {
        return (this.days * 1440) + (this.hours * 60) + this.minutes;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime$Companion;", "", "()V", "ZERO", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "getZERO", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "fromInterval", "interval", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CountdownTime getZERO() {
            return CountdownTime.ZERO;
        }

        public final CountdownTime fromInterval(long interval) {
            long jMax = Math.max(0L, interval / ((long) 1000));
            long j = SyncConfiguration.DEFAULT_FREQUENCY;
            long j2 = 3600;
            long j3 = 60;
            return new CountdownTime((int) (jMax / j), (int) ((jMax % j) / j2), (int) ((jMax % j2) / j3), (int) (jMax % j3));
        }
    }
}
