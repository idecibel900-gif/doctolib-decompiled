package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DiffClampAnimatedNode extends ValueAnimatedNode {
    private final int inputNodeTag;
    private double lastValue;
    private final double maxValue;
    private final double minValue;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffClampAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.inputNodeTag = config.getInt("input");
        this.minValue = config.getDouble("min");
        this.maxValue = config.getDouble("max");
        this.nodeValue = this.lastValue;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        double inputNodeValue = getInputNodeValue();
        double d = inputNodeValue - this.lastValue;
        this.lastValue = inputNodeValue;
        this.nodeValue = Math.min(Math.max(this.nodeValue + d, this.minValue), this.maxValue);
    }

    private final double getInputNodeValue() {
        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(this.inputNodeTag);
        if (nodeById == null || !(nodeById instanceof ValueAnimatedNode)) {
            throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
        }
        return ((ValueAnimatedNode) nodeById).getValue();
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "DiffClampAnimatedNode[" + this.tag + "]: InputNodeTag: " + this.inputNodeTag + " min: " + this.minValue + " max: " + this.maxValue + " lastValue: " + this.lastValue + " super: " + super.prettyPrint$ReactAndroid_release();
    }
}
