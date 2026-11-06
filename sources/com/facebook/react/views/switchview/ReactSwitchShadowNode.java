package com.facebook.react.views.switchview;

import android.view.View;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    public static final Companion Companion = new Companion(null);
    private int height;
    private boolean measured;
    private int width;

    public ReactSwitchShadowNode() {
        initMeasureFunction();
    }

    private final void initMeasureFunction() {
        setMeasureFunction(this);
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public long measure(YogaNode node, float f, YogaMeasureMode widthMode, float f2, YogaMeasureMode heightMode) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        if (!this.measured) {
            ThemedReactContext themedContext = getThemedContext();
            Intrinsics.checkNotNullExpressionValue(themedContext, "getThemedContext(...)");
            ReactSwitch reactSwitch = new ReactSwitch(themedContext);
            reactSwitch.setShowText(false);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            reactSwitch.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.width = reactSwitch.getMeasuredWidth();
            this.height = reactSwitch.getMeasuredHeight();
            this.measured = true;
        }
        return YogaMeasureOutput.make(this.width, this.height);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("ReactSwitchShadowNode", LegacyArchitectureLogLevel.ERROR);
    }
}
