package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectAnimatedNode extends AnimatedNode {
    public static final Companion Companion = new Companion(null);
    private final JavaOnlyMap configClone;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ObjectAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.configClone = JavaOnlyMap.INSTANCE.deepClone(config);
    }

    public final void collectViewUpdates(String propKey, JavaOnlyMap propsMap) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        ReadableType type = this.configClone.getType("value");
        if (type == ReadableType.Map) {
            propsMap.putMap(propKey, collectViewUpdatesHelper(this.configClone.getMap("value")));
        } else {
            if (type == ReadableType.Array) {
                propsMap.putArray(propKey, collectViewUpdatesHelper(this.configClone.getArray("value")));
                return;
            }
            throw new IllegalArgumentException("Invalid value type for ObjectAnimatedNode");
        }
    }

    private final JavaOnlyArray collectViewUpdatesHelper(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()]) {
                case 1:
                    javaOnlyArray.pushNull();
                    break;
                case 2:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case 3:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i));
                    break;
                case 4:
                    javaOnlyArray.pushString(readableArray.getString(i));
                    break;
                case 5:
                    ReadableMap map = readableArray.getMap(i);
                    if (map != null && map.hasKey("nodeTag") && map.getType("nodeTag") == ReadableType.Number) {
                        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(map.getInt("nodeTag"));
                        if (nodeById == null) {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                        if (nodeById instanceof ValueAnimatedNode) {
                            ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                            Object animatedObject = valueAnimatedNode.getAnimatedObject();
                            if (animatedObject instanceof Integer) {
                                javaOnlyArray.pushInt(((Number) animatedObject).intValue());
                            } else if (animatedObject instanceof String) {
                                javaOnlyArray.pushString((String) animatedObject);
                            } else {
                                javaOnlyArray.pushDouble(valueAnimatedNode.getValue());
                            }
                        } else if (nodeById instanceof ColorAnimatedNode) {
                            javaOnlyArray.pushInt(((ColorAnimatedNode) nodeById).getColor());
                        }
                    } else {
                        javaOnlyArray.pushMap(collectViewUpdatesHelper(readableArray.getMap(i)));
                    }
                    break;
                case 6:
                    javaOnlyArray.pushArray(collectViewUpdatesHelper(readableArray.getArray(i)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return javaOnlyArray;
    }

    private final JavaOnlyMap collectViewUpdatesHelper(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    javaOnlyMap.putNull(strNextKey);
                    break;
                case 2:
                    javaOnlyMap.putBoolean(strNextKey, readableMap.getBoolean(strNextKey));
                    break;
                case 3:
                    javaOnlyMap.putDouble(strNextKey, readableMap.getDouble(strNextKey));
                    break;
                case 4:
                    javaOnlyMap.putString(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    ReadableMap map = readableMap.getMap(strNextKey);
                    if (map != null && map.hasKey("nodeTag") && map.getType("nodeTag") == ReadableType.Number) {
                        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(map.getInt("nodeTag"));
                        if (nodeById == null) {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                        if (nodeById instanceof ValueAnimatedNode) {
                            ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                            Object animatedObject = valueAnimatedNode.getAnimatedObject();
                            if (animatedObject instanceof Integer) {
                                javaOnlyMap.putInt(strNextKey, ((Number) animatedObject).intValue());
                            } else if (animatedObject instanceof String) {
                                javaOnlyMap.putString(strNextKey, (String) animatedObject);
                            } else {
                                javaOnlyMap.putDouble(strNextKey, valueAnimatedNode.getValue());
                            }
                        } else if (nodeById instanceof ColorAnimatedNode) {
                            javaOnlyMap.putInt(strNextKey, ((ColorAnimatedNode) nodeById).getColor());
                        }
                    } else {
                        javaOnlyMap.putMap(strNextKey, collectViewUpdatesHelper(map));
                    }
                    break;
                case 6:
                    javaOnlyMap.putArray(strNextKey, collectViewUpdatesHelper(readableMap.getArray(strNextKey)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return javaOnlyMap;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "ObjectAnimatedNode[" + this.tag + "]: mConfig: " + this.configClone;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
