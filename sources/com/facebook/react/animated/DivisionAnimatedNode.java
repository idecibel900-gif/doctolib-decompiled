package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DivisionAnimatedNode extends ValueAnimatedNode {
    private final int[] inputNodes;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableArray array = config.getArray("input");
        if (array == null) {
            iArr = new int[0];
        } else {
            int size = array.size();
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                iArr2[i] = array.getInt(i);
            }
            iArr = iArr2;
        }
        this.inputNodes = iArr;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        int[] iArr = this.inputNodes;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(iArr[i]);
            if (nodeById != null && (nodeById instanceof ValueAnimatedNode)) {
                double d = ((ValueAnimatedNode) nodeById).nodeValue;
                if (i2 == 0) {
                    this.nodeValue = d;
                } else {
                    if (d == 0.0d) {
                        throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node with Animated ID " + this.tag);
                    }
                    this.nodeValue /= d;
                }
                i++;
                i2 = i3;
            } else {
                throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node with Animated ID " + this.tag);
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "DivisionAnimatedNode[" + this.tag + "]: input nodes: " + this.inputNodes + " - super: " + super.prettyPrint$ReactAndroid_release();
    }
}
