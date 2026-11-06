package com.facebook.react.animated;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.view.ColorUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorAnimatedNode extends AnimatedNode implements AnimatedNodeWithUpdateableConfig {
    public static final Companion Companion = new Companion(null);
    private int aNodeId;
    private int bNodeId;
    private int gNodeId;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private ReadableMap nativeColor;
    private boolean nativeColorApplied;
    private int rNodeId;
    private final ReactApplicationContext reactApplicationContext;

    public ColorAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.reactApplicationContext = reactApplicationContext;
        onUpdateConfig(config);
    }

    public final int getColor() {
        tryApplyNativeColor();
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        return ColorUtil.normalize(valueAnimatedNode != null ? valueAnimatedNode.nodeValue : 0.0d, valueAnimatedNode2 != null ? valueAnimatedNode2.nodeValue : 0.0d, valueAnimatedNode3 != null ? valueAnimatedNode3.nodeValue : 0.0d, valueAnimatedNode4 != null ? valueAnimatedNode4.nodeValue : 0.0d);
    }

    @Override // com.facebook.react.animated.AnimatedNodeWithUpdateableConfig
    public void onUpdateConfig(ReadableMap readableMap) {
        if (readableMap != null) {
            this.rNodeId = readableMap.getInt("r");
            this.gNodeId = readableMap.getInt("g");
            this.bNodeId = readableMap.getInt("b");
            this.aNodeId = readableMap.getInt("a");
            this.nativeColor = readableMap.getMap("nativeColor");
            this.nativeColorApplied = false;
            tryApplyNativeColor();
            return;
        }
        this.rNodeId = 0;
        this.gNodeId = 0;
        this.bNodeId = 0;
        this.aNodeId = 0;
        this.nativeColor = null;
        this.nativeColorApplied = false;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "ColorAnimatedNode[" + this.tag + "]: r: " + this.rNodeId + "  g: " + this.gNodeId + " b: " + this.bNodeId + " a: " + this.aNodeId;
    }

    private final void tryApplyNativeColor() {
        Context context;
        Integer color;
        if (this.nativeColor == null || this.nativeColorApplied || (context = getContext()) == null || (color = ColorPropConverter.getColor(this.nativeColor, context)) == null) {
            return;
        }
        int iIntValue = color.intValue();
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        if (valueAnimatedNode != null) {
            valueAnimatedNode.nodeValue = Color.red(iIntValue);
        }
        if (valueAnimatedNode2 != null) {
            valueAnimatedNode2.nodeValue = Color.green(iIntValue);
        }
        if (valueAnimatedNode3 != null) {
            valueAnimatedNode3.nodeValue = Color.blue(iIntValue);
        }
        if (valueAnimatedNode4 != null) {
            valueAnimatedNode4.nodeValue = ((double) Color.alpha(iIntValue)) / 255.0d;
        }
        this.nativeColorApplied = true;
    }

    private final Context getContext() {
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        return currentActivity != null ? currentActivity : Companion.getContextHelper(this);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context getContextHelper(AnimatedNode animatedNode) {
            List list = animatedNode.children;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    AnimatedNode animatedNode2 = (AnimatedNode) it.next();
                    if (animatedNode2 instanceof PropsAnimatedNode) {
                        View connectedView = ((PropsAnimatedNode) animatedNode2).getConnectedView();
                        if (connectedView != null) {
                            return connectedView.getContext();
                        }
                        return null;
                    }
                    return ColorAnimatedNode.Companion.getContextHelper(animatedNode2);
                }
            }
            return null;
        }
    }
}
