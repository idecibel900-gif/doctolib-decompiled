package com.facebook.react.animated;

import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public class ValueAnimatedNode extends AnimatedNode {
    public double nodeValue;
    public double offset;
    private AnimatedNodeValueListener valueListener;

    public Object getAnimatedObject() {
        return null;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.nodeValue = readableMap != null ? readableMap.getDouble("value") : Double.NaN;
        this.offset = readableMap != null ? readableMap.getDouble(b.as) : 0.0d;
    }

    public /* synthetic */ ValueAnimatedNode(ReadableMap readableMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : readableMap);
    }

    public final double getValue() {
        if (Double.isNaN(this.offset + this.nodeValue)) {
            update$ReactAndroid_release();
        }
        return this.offset + this.nodeValue;
    }

    public final void flattenOffset() {
        this.nodeValue += this.offset;
        this.offset = 0.0d;
    }

    public final void extractOffset() {
        this.offset += this.nodeValue;
        this.nodeValue = 0.0d;
    }

    public final void onValueUpdate() {
        AnimatedNodeValueListener animatedNodeValueListener = this.valueListener;
        if (animatedNodeValueListener != null) {
            double value = getValue();
            double d = this.offset;
            animatedNodeValueListener.onValueUpdate(value - d, d);
        }
    }

    public final void setValueListener(AnimatedNodeValueListener animatedNodeValueListener) {
        this.valueListener = animatedNodeValueListener;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "ValueAnimatedNode[" + this.tag + "]: value: " + this.nodeValue + " offset: " + this.offset;
    }
}
