package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class StyleAnimatedNode extends AnimatedNode {
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private final Map propMapping;

    public StyleAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableMap map = config.getMap("style");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map != null ? map.keySetIterator() : null;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        while (readableMapKeySetIteratorKeySetIterator != null && readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            mapCreateMapBuilder.put(strNextKey, Integer.valueOf(map.getInt(strNextKey)));
        }
        this.propMapping = MapsKt.build(mapCreateMapBuilder);
    }

    public final void collectViewUpdates(JavaOnlyMap propsMap) {
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        for (Map.Entry entry : this.propMapping.entrySet()) {
            String str = (String) entry.getKey();
            AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(((Number) entry.getValue()).intValue());
            if (nodeById == null) {
                throw new IllegalArgumentException("Mapped style node does not exist");
            }
            if (nodeById instanceof TransformAnimatedNode) {
                ((TransformAnimatedNode) nodeById).collectViewUpdates(propsMap);
            } else if (nodeById instanceof ValueAnimatedNode) {
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                Object animatedObject = valueAnimatedNode.getAnimatedObject();
                if (animatedObject instanceof Integer) {
                    propsMap.putInt(str, ((Number) animatedObject).intValue());
                } else if (animatedObject instanceof String) {
                    propsMap.putString(str, (String) animatedObject);
                } else {
                    propsMap.putDouble(str, valueAnimatedNode.getValue());
                }
            } else if (nodeById instanceof ColorAnimatedNode) {
                propsMap.putInt(str, ((ColorAnimatedNode) nodeById).getColor());
            } else if (nodeById instanceof ObjectAnimatedNode) {
                ((ObjectAnimatedNode) nodeById).collectViewUpdates(str, propsMap);
            } else {
                throw new IllegalArgumentException("Unsupported type of node used in property node " + nodeById.getClass());
            }
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "StyleAnimatedNode[" + this.tag + "] mPropMapping: " + this.propMapping;
    }
}
