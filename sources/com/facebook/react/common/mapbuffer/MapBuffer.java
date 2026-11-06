package com.facebook.react.common.mapbuffer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes3.dex */
public interface MapBuffer extends Iterable, KMappedMarker {
    public static final Companion Companion = Companion.$$INSTANCE;

    public enum DataType {
        BOOL,
        INT,
        DOUBLE,
        STRING,
        MAP,
        LONG;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public interface Entry {
        boolean getBooleanValue();

        double getDoubleValue();

        int getIntValue();

        int getKey();

        long getLongValue();

        MapBuffer getMapBufferValue();

        String getStringValue();

        DataType getType();
    }

    boolean contains(int i);

    boolean getBoolean(int i);

    int getCount();

    double getDouble(int i);

    int getInt(int i);

    MapBuffer getMapBuffer(int i);

    String getString(int i);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IntRange KEY_RANGE = new IntRange(0, Settings.DEFAULT_INITIAL_WINDOW_SIZE);

        private Companion() {
        }

        public final IntRange getKEY_RANGE$ReactAndroid_release() {
            return KEY_RANGE;
        }
    }
}
