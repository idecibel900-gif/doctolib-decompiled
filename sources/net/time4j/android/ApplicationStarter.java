package net.time4j.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.a.a.o.b;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.android.spi.AndroidResourceLoader;
import net.time4j.base.ResourceLoader;
import net.time4j.format.DisplayMode;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ApplicationStarter {
    private static final AtomicBoolean PREPARED = new AtomicBoolean(false);
    private static final AtomicBoolean REGISTERED = new AtomicBoolean(false);

    /* JADX WARN: Multi-variable type inference failed */
    public static void initialize(Context context, boolean z) {
        StdPrefetch stdPrefetch = null;
        Object[] objArr = 0;
        if (z) {
            stdPrefetch = new StdPrefetch();
        }
        initialize(context, stdPrefetch);
    }

    public static void initialize(Context context, Runnable runnable) {
        System.nanoTime();
        prepareAssets(context, null);
        registerReceiver(context.getApplicationContext());
        Objects.toString(PlainDate.of(2021, 3, 27).at(PlainTime.midnightAtStartOfDay()).toDate());
        if (runnable != null) {
            Executors.defaultThreadFactory().newThread(runnable).start();
        }
        System.nanoTime();
    }

    public static void prepareAssets(Context context, AssetLocation assetLocation) {
        if (PREPARED.getAndSet(true)) {
            return;
        }
        System.setProperty("net.time4j.base.ResourceLoader", "net.time4j.android.spi.AndroidResourceLoader");
        ((AndroidResourceLoader) ResourceLoader.getInstance()).init(context, assetLocation);
    }

    public static void registerReceiver(Context context) {
        if (context == null || REGISTERED.getAndSet(true)) {
            return;
        }
        System.setProperty("net.time4j.allow.system.tz.override", b.af);
        context.registerReceiver(new TimezoneChangedReceiver(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
    }

    private static class TimezoneChangedReceiver extends BroadcastReceiver {
        private TimezoneChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Timezone.Cache.refresh();
            Timezone.ofSystem().getID().canonical();
            intent.getStringExtra("time-zone");
        }
    }

    private static class StdPrefetch implements Runnable {
        private StdPrefetch() {
        }

        @Override // java.lang.Runnable
        public void run() {
            System.nanoTime();
            TZID tzidOfTotalSeconds = ZonalOffset.ofTotalSeconds(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000);
            Locale locale = Locale.getDefault();
            try {
                Moment momentCurrentMoment = SystemClock.currentMoment();
                tzidOfTotalSeconds = Timezone.ofSystem().getID();
                tzidOfTotalSeconds.canonical();
                locale.toString();
                DisplayMode displayMode = DisplayMode.FULL;
                ChronoFormatter.ofMomentStyle(displayMode, displayMode, locale, tzidOfTotalSeconds).format(momentCurrentMoment);
                System.nanoTime();
            } catch (Throwable th) {
                tzidOfTotalSeconds.canonical();
                Objects.toString(locale);
                throw new IllegalStateException(th);
            }
        }
    }
}
