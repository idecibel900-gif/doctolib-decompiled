package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TransformAnimatedNode extends AnimatedNode {
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private final List transformConfigs;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.facebook.react.animated.TransformAnimatedNode$StaticTransformConfig, com.facebook.react.animated.TransformAnimatedNode$TransformConfig] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.facebook.react.animated.TransformAnimatedNode$AnimatedTransformConfig, com.facebook.react.animated.TransformAnimatedNode$TransformConfig] */
    public TransformAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        List listEmptyList;
        ?? staticTransformConfig;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableArray array = config.getArray("transforms");
        if (array == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            int size = array.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                ReadableMap map = array.getMap(i);
                if (map == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                String string = map.getString("property");
                if (Intrinsics.areEqual(map.getString("type"), "animated")) {
                    staticTransformConfig = new AnimatedTransformConfig();
                    staticTransformConfig.setProperty(string);
                    staticTransformConfig.setNodeTag(map.getInt("nodeTag"));
                } else {
                    staticTransformConfig = new StaticTransformConfig();
                    staticTransformConfig.setProperty(string);
                    staticTransformConfig.setValue(map.getDouble("value"));
                }
                arrayList.add(staticTransformConfig);
            }
            listEmptyList = arrayList;
        }
        this.transformConfigs = listEmptyList;
    }

    public final void collectViewUpdates(JavaOnlyMap propsMap) {
        double value;
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        int size = this.transformConfigs.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            TransformConfig transformConfig = (TransformConfig) this.transformConfigs.get(i);
            if (transformConfig instanceof AnimatedTransformConfig) {
                AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(((AnimatedTransformConfig) transformConfig).getNodeTag());
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped style node does not exist");
                }
                if (nodeById instanceof ValueAnimatedNode) {
                    value = ((ValueAnimatedNode) nodeById).getValue();
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + nodeById.getClass());
                }
            } else {
                Intrinsics.checkNotNull(transformConfig, "null cannot be cast to non-null type com.facebook.react.animated.TransformAnimatedNode.StaticTransformConfig");
                value = ((StaticTransformConfig) transformConfig).getValue();
            }
            arrayList.add(JavaOnlyMap.INSTANCE.of(transformConfig.getProperty(), Double.valueOf(value)));
        }
        propsMap.putArray("transform", JavaOnlyArray.INSTANCE.from(arrayList));
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "TransformAnimatedNode[" + this.tag + "]: transformConfigs: " + this.transformConfigs;
    }

    private class TransformConfig {
        private String property;

        public TransformConfig() {
        }

        public final String getProperty() {
            return this.property;
        }

        public final void setProperty(String str) {
            this.property = str;
        }
    }

    private final class AnimatedTransformConfig extends TransformConfig {
        private int nodeTag;

        public AnimatedTransformConfig() {
            super();
        }

        public final int getNodeTag() {
            return this.nodeTag;
        }

        public final void setNodeTag(int i) {
            this.nodeTag = i;
        }
    }

    private final class StaticTransformConfig extends TransformConfig {
        private double value;

        public StaticTransformConfig() {
            super();
        }

        public final double getValue() {
            return this.value;
        }

        public final void setValue(double d) {
            this.value = d;
        }
    }
}
