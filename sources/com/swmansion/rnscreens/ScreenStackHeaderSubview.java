package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStackHeaderSubview extends FabricEnabledHeaderSubviewViewGroup {
    private boolean isReactSizeSet;
    private int reactHeight;
    private int reactWidth;
    private Type type;

    public enum Type {
        LEFT,
        CENTER,
        RIGHT,
        BACK,
        SEARCH_BAR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public ScreenStackHeaderSubview(ReactContext reactContext) {
        super(reactContext);
        this.type = Type.LEFT;
    }

    public final Type getType() {
        return this.type;
    }

    public final void setType(Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.type = type;
    }

    public final ScreenStackHeaderConfig getConfig() {
        ViewParent parent = getParent();
        CustomToolbar customToolbar = parent instanceof CustomToolbar ? (CustomToolbar) parent : null;
        if (customToolbar != null) {
            return customToolbar.getConfig();
        }
        return null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            this.reactWidth = View.MeasureSpec.getSize(i);
            this.reactHeight = View.MeasureSpec.getSize(i2);
            this.isReactSizeSet = true;
            Object parent = getParent();
            if (parent != null) {
                forceLayout();
                ((View) parent).requestLayout();
            }
        }
        setMeasuredDimension(this.reactWidth, this.reactHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.isReactSizeSet) {
                updateSubviewFrameState(i5, i6, i, i2);
            }
        }
    }
}
