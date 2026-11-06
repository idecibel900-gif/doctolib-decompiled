package com.facebook.react.uimanager;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.yoga.YogaConstants;
import com.opentok.android.BaseVideoCapturer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Spacing {
    public static final Companion Companion = new Companion(null);
    private static final int[] flagsMap = {1, 2, 4, 8, 16, 32, 64, 128, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, 2048};
    private final float defaultValue;
    private boolean hasAliasesSet;
    private final float[] spacing;
    private int valueFlags;

    public Spacing(float f, float[] spacing) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        this.defaultValue = f;
        this.spacing = spacing;
    }

    public Spacing(float f) {
        this(f, Companion.newFullSpacingArray());
    }

    public final boolean set(int i, float f) {
        int i2;
        if (FloatUtil.floatsEqual(this.spacing[i], f)) {
            return false;
        }
        this.spacing[i] = f;
        if (YogaConstants.isUndefined(f)) {
            i2 = (~flagsMap[i]) & this.valueFlags;
        } else {
            i2 = flagsMap[i] | this.valueFlags;
        }
        this.valueFlags = i2;
        int[] iArr = flagsMap;
        this.hasAliasesSet = ((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (iArr[6] & i2) == 0 && (i2 & iArr[9]) == 0) ? false : true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000c  */
    public final float get(int i) {
        float f;
        if (i == 4 || i == 5) {
            f = YogaConstants.UNDEFINED;
        } else {
            switch (i) {
                case 9:
                case 10:
                case BaseVideoCapturer.RGBA /* 11 */:
                    f = YogaConstants.UNDEFINED;
                    break;
                default:
                    f = this.defaultValue;
                    break;
            }
        }
        int i2 = this.valueFlags;
        if (i2 != 0) {
            int[] iArr = flagsMap;
            if ((iArr[i] & i2) != 0) {
                return this.spacing[i];
            }
            if (this.hasAliasesSet) {
                char c = (i == 1 || i == 3) ? (char) 7 : (char) 6;
                if ((iArr[c] & i2) != 0) {
                    return this.spacing[c];
                }
                if ((i2 & iArr[8]) != 0) {
                    return this.spacing[8];
                }
            }
        }
        return f;
    }

    public final float getRaw(int i) {
        return this.spacing[i];
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] newFullSpacingArray() {
            float f = YogaConstants.UNDEFINED;
            return new float[]{f, f, f, f, f, f, f, f, f, f, f, f};
        }
    }
}
