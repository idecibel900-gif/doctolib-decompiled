package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TrackingAnimatedNode extends AnimatedNode {
    private final JavaOnlyMap animationConfig;
    private final int animationId;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private final int toValueNode;
    private final int valueNode;

    public TrackingAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.animationConfig = JavaOnlyMap.INSTANCE.deepClone(config.getMap("animationConfig"));
        this.animationId = config.getInt("animationId");
        this.toValueNode = config.getInt("toValue");
        this.valueNode = config.getInt("value");
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(this.toValueNode);
        ValueAnimatedNode valueAnimatedNode = nodeById instanceof ValueAnimatedNode ? (ValueAnimatedNode) nodeById : null;
        if (valueAnimatedNode != null) {
            this.animationConfig.putDouble("toValue", valueAnimatedNode.getValue());
        } else {
            this.animationConfig.putNull("toValue");
        }
        this.nativeAnimatedNodesManager.startAnimatingNode(this.animationId, this.valueNode, this.animationConfig, null);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "TrackingAnimatedNode[" + this.tag + "]: animationID: " + this.animationId + " toValueNode: " + this.toValueNode + " valueNode: " + this.valueNode + " animationConfig: " + this.animationConfig;
    }
}
