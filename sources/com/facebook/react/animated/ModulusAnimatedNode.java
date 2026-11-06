package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModulusAnimatedNode extends ValueAnimatedNode {
    private final int inputNode;
    private final double modulus;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModulusAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.inputNode = config.getInt("input");
        this.modulus = config.getDouble("modulus");
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(this.inputNode);
        if (nodeById instanceof ValueAnimatedNode) {
            double value = ((ValueAnimatedNode) nodeById).getValue();
            double d = this.modulus;
            this.nodeValue = ((value % d) + d) % d;
            return;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "NativeAnimatedNodesManager[" + this.tag + "] inputNode: " + this.inputNode + " modulus: " + this.modulus + " super: " + super.prettyPrint$ReactAndroid_release();
    }
}
