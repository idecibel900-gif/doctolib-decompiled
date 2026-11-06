package com.facebook.fresco.ui.common;

import com.amazon.device.simplesignin.a.a.a;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum ImageLoadStatus {
    UNKNOWN(-1),
    REQUESTED(0),
    INTERMEDIATE_AVAILABLE(2),
    SUCCESS(3),
    ERROR(5),
    EMPTY_EVENT(7),
    RELEASED(8);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);
    private static final ImageLoadStatus[] VALUES = values();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageLoadStatus.values().length];
            try {
                iArr[ImageLoadStatus.REQUESTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageLoadStatus.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageLoadStatus.INTERMEDIATE_AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageLoadStatus.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageLoadStatus.RELEASED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    ImageLoadStatus(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "requested";
        }
        if (i == 2) {
            return a.s;
        }
        if (i == 3) {
            return "intermediate_available";
        }
        if (i == 4) {
            return "error";
        }
        if (i == 5) {
            return "released";
        }
        return "unknown";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
