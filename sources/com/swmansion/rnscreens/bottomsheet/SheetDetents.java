package com.swmansion.rnscreens.bottomsheet;

import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContentWrapper;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SheetDetents {
    public static final Companion Companion = new Companion(null);
    private final List rawDetents;

    public SheetDetents(List rawDetents) {
        Intrinsics.checkNotNullParameter(rawDetents, "rawDetents");
        this.rawDetents = CollectionsKt.toList(rawDetents);
        if (rawDetents.isEmpty()) {
            throw new IllegalArgumentException("[RNScreens] At least one detent must be provided.");
        }
        if (rawDetents.size() > 3) {
            throw new IllegalArgumentException("[RNScreens] Maximum of 3 detents supported.");
        }
        if (rawDetents.size() == 1) {
            double dDoubleValue = ((Number) rawDetents.get(0)).doubleValue();
            if ((0.0d > dDoubleValue || dDoubleValue > 1.0d) && dDoubleValue != -1.0d) {
                throw new IllegalArgumentException(("[RNScreens] Detent value must be within 0.0 and 1.0, or SHEET_FIT_TO_CONTENTS should be defined, got " + dDoubleValue + ".").toString());
            }
            return;
        }
        List list = rawDetents;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            double dDoubleValue2 = ((Number) it.next()).doubleValue();
            if (0.0d > dDoubleValue2 || dDoubleValue2 > 1.0d) {
                throw new IllegalArgumentException(("[RNScreens] Detent values must be within 0.0 and 1.0, got " + dDoubleValue2 + ".").toString());
            }
        }
        if (!Intrinsics.areEqual(rawDetents, CollectionsKt.sorted(list))) {
            throw new IllegalArgumentException("[RNScreens] Detents must be sorted in ascending order.");
        }
    }

    public final int getCount$react_native_screens_release() {
        return this.rawDetents.size();
    }

    public final double at$react_native_screens_release(int i) {
        return ((Number) this.rawDetents.get(i)).doubleValue();
    }

    public final double shortest$react_native_screens_release() {
        return ((Number) CollectionsKt.first(this.rawDetents)).doubleValue();
    }

    public final double highest$react_native_screens_release() {
        return ((Number) CollectionsKt.last(this.rawDetents)).doubleValue();
    }

    public final int heightAt$react_native_screens_release(int i, int i2) {
        double dAt$react_native_screens_release = at$react_native_screens_release(i);
        if (dAt$react_native_screens_release == -1.0d) {
            throw new IllegalArgumentException("[RNScreens] FIT_TO_CONTENTS is not supported by heightAt.");
        }
        return (int) (dAt$react_native_screens_release * ((double) i2));
    }

    public final int firstHeight$react_native_screens_release(int i) {
        return heightAt$react_native_screens_release(0, i);
    }

    public final int maxAllowedHeight$react_native_screens_release(int i) {
        return heightAt$react_native_screens_release(getCount$react_native_screens_release() - 1, i);
    }

    public final int maxAllowedHeightForFitToContents$react_native_screens_release(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        ScreenContentWrapper contentWrapper = screen.getContentWrapper();
        if (contentWrapper == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(contentWrapper.getHeight());
        if (!SheetUtilsKt.isLaidOutOrHasCachedLayout(contentWrapper)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    public final float halfExpandedRatio$react_native_screens_release() {
        if (getCount$react_native_screens_release() < 3) {
            throw new IllegalStateException("[RNScreens] At least 3 detents required for halfExpandedRatio.");
        }
        return (float) (at$react_native_screens_release(1) / at$react_native_screens_release(2));
    }

    public final int expandedOffsetFromTop$react_native_screens_release(int i, int i2, boolean z) {
        if (getCount$react_native_screens_release() < 3) {
            throw new IllegalStateException("[RNScreens] At least 3 detents required for expandedOffsetFromTop.");
        }
        int iAt$react_native_screens_release = (int) ((((double) 1) - at$react_native_screens_release(2)) * ((double) i));
        if (z) {
            i2 = 0;
        }
        return iAt$react_native_screens_release + i2;
    }

    public final int sheetStateFromIndex$react_native_screens_release(int i) {
        return SheetUtils.INSTANCE.sheetStateFromDetentIndex(i, getCount$react_native_screens_release());
    }

    public final int indexFromSheetState$react_native_screens_release(int i) {
        return SheetUtils.INSTANCE.detentIndexFromSheetState(i, getCount$react_native_screens_release());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
