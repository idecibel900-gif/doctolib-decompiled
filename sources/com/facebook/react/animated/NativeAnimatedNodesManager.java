package com.facebook.react.animated;

import android.util.SparseArray;
import com.amazon.device.iap.internal.c.b;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final Companion Companion = new Companion(null);
    private int animatedGraphBFSColor;
    private boolean eventListenerInitializedForFabric;
    private boolean eventListenerInitializedForNonFabric;
    private final ReactApplicationContext reactApplicationContext;
    private boolean warnedAboutGraphTraversal;
    private final SparseArray animatedNodes = new SparseArray();
    private final SparseArray activeAnimations = new SparseArray();
    private final SparseArray updatedNodes = new SparseArray();
    private final List eventDrivers = new ArrayList();
    private final List runUpdateNodeList = new LinkedList();

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.reactApplicationContext = reactApplicationContext;
    }

    public final void initializeEventListenerForUIManagerType(int i) {
        boolean z;
        if (i == 2) {
            z = this.eventListenerInitializedForFabric;
        } else {
            z = this.eventListenerInitializedForNonFabric;
        }
        if (z) {
            return;
        }
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext == null) {
            throw new IllegalStateException("Required value was null.");
        }
        UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, i);
        if (uIManager != null) {
            uIManager.getEventDispatcher().addListener(this);
            if (i == 2) {
                this.eventListenerInitializedForFabric = true;
            } else {
                this.eventListenerInitializedForNonFabric = true;
            }
        }
    }

    public final AnimatedNode getNodeById(int i) {
        return (AnimatedNode) this.animatedNodes.get(i);
    }

    public final boolean hasActiveAnimations() {
        return this.activeAnimations.size() > 0 || this.updatedNodes.size() > 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void createAnimatedNode(int i, ReadableMap config) {
        AnimatedNode subtractionAnimatedNode;
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.animatedNodes.get(i) != null) {
            throw new JSApplicationIllegalArgumentException("createAnimatedNode: Animated node [" + i + "] already exists");
        }
        String string = config.getString("type");
        if (string != null) {
            switch (string.hashCode()) {
                case -1774341004:
                    if (string.equals("subtraction")) {
                        subtractionAnimatedNode = new SubtractionAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case -1226589444:
                    if (string.equals("addition")) {
                        subtractionAnimatedNode = new AdditionAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case -1023368385:
                    if (string.equals("object")) {
                        subtractionAnimatedNode = new ObjectAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
                        if (reactApplicationContext == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        subtractionAnimatedNode = new ColorAnimatedNode(config, this, reactApplicationContext);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 106940784:
                    if (string.equals("props")) {
                        subtractionAnimatedNode = new PropsAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 109780401:
                    if (string.equals("style")) {
                        subtractionAnimatedNode = new StyleAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 111972721:
                    if (string.equals("value")) {
                        subtractionAnimatedNode = new ValueAnimatedNode(config);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 364720301:
                    if (string.equals("division")) {
                        subtractionAnimatedNode = new DivisionAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 559331748:
                    if (string.equals("interpolation")) {
                        subtractionAnimatedNode = new InterpolationAnimatedNode(config);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 668845958:
                    if (string.equals("multiplication")) {
                        subtractionAnimatedNode = new MultiplicationAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 1052666732:
                    if (string.equals("transform")) {
                        subtractionAnimatedNode = new TransformAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 1227434359:
                    if (string.equals("modulus")) {
                        subtractionAnimatedNode = new ModulusAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 1270488759:
                    if (string.equals("tracking")) {
                        subtractionAnimatedNode = new TrackingAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
                case 1300649942:
                    if (string.equals("diffclamp")) {
                        subtractionAnimatedNode = new DiffClampAnimatedNode(config, this);
                        subtractionAnimatedNode.tag = i;
                        this.animatedNodes.put(i, subtractionAnimatedNode);
                        this.updatedNodes.put(i, subtractionAnimatedNode);
                        return;
                    }
                    break;
            }
        }
        throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateAnimatedNodeConfig(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == 0) {
            throw new JSApplicationIllegalArgumentException("updateAnimatedNode: Animated node [" + i + "] does not exist");
        }
        if (animatedNode instanceof AnimatedNodeWithUpdateableConfig) {
            stopAnimationsForNode(animatedNode);
            ((AnimatedNodeWithUpdateableConfig) animatedNode).onUpdateConfig(readableMap);
            this.updatedNodes.put(i, animatedNode);
        }
    }

    public final void dropAnimatedNode(int i) {
        this.animatedNodes.remove(i);
        this.updatedNodes.remove(i);
    }

    public final void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public final void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(null);
    }

    public final void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).nodeValue = d;
        this.updatedNodes.put(i, animatedNode);
    }

    public final void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).offset = d;
        this.updatedNodes.put(i, animatedNode);
    }

    public final void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("flattenAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public final void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("extractAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public final void startAnimatingNode(int i, int i2, ReadableMap animationConfig, Callback callback) {
        AnimationDriver frameBasedAnimationDriver;
        Intrinsics.checkNotNullParameter(animationConfig, "animationConfig");
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] does not exist");
        }
        if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] should be of type " + ValueAnimatedNode.class.getName());
        }
        AnimationDriver animationDriver = (AnimationDriver) this.activeAnimations.get(i);
        if (animationDriver != null) {
            animationDriver.resetConfig(animationConfig);
            return;
        }
        String string = animationConfig.getString("type");
        if (string != null) {
            int iHashCode = string.hashCode();
            if (iHashCode != -1266514778) {
                if (iHashCode != -895679987) {
                    if (iHashCode == 95459258 && string.equals("decay")) {
                        frameBasedAnimationDriver = new DecayAnimation(animationConfig);
                        frameBasedAnimationDriver.id = i;
                        frameBasedAnimationDriver.endCallback = callback;
                        frameBasedAnimationDriver.animatedValue = (ValueAnimatedNode) animatedNode;
                        this.activeAnimations.put(i, frameBasedAnimationDriver);
                        return;
                    }
                } else if (string.equals("spring")) {
                    frameBasedAnimationDriver = new SpringAnimation(animationConfig);
                    frameBasedAnimationDriver.id = i;
                    frameBasedAnimationDriver.endCallback = callback;
                    frameBasedAnimationDriver.animatedValue = (ValueAnimatedNode) animatedNode;
                    this.activeAnimations.put(i, frameBasedAnimationDriver);
                    return;
                }
            } else if (string.equals("frames")) {
                frameBasedAnimationDriver = new FrameBasedAnimationDriver(animationConfig);
                frameBasedAnimationDriver.id = i;
                frameBasedAnimationDriver.endCallback = callback;
                frameBasedAnimationDriver.animatedValue = (ValueAnimatedNode) animatedNode;
                this.activeAnimations.put(i, frameBasedAnimationDriver);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("startAnimatingNode: Unsupported animation type [" + i2 + "]: " + string);
    }

    private final void stopAnimationsForNode(AnimatedNode animatedNode) {
        ReactApplicationContext reactApplicationContext;
        WritableArray writableArrayCreateArray = null;
        int i = 0;
        while (i < this.activeAnimations.size()) {
            AnimationDriver animationDriver = (AnimationDriver) this.activeAnimations.valueAt(i);
            if (Intrinsics.areEqual(animatedNode, animationDriver.animatedValue)) {
                ValueAnimatedNode valueAnimatedNode = animationDriver.animatedValue;
                if (valueAnimatedNode == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (animationDriver.endCallback != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                    readableMapBuilder.put("finished", false);
                    readableMapBuilder.put("value", valueAnimatedNode.nodeValue);
                    readableMapBuilder.put(b.as, valueAnimatedNode.offset);
                    Callback callback = animationDriver.endCallback;
                    if (callback != null) {
                        callback.invoke(writableMapCreateMap);
                    }
                } else if (this.reactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
                    readableMapBuilder2.put("animationId", animationDriver.id);
                    readableMapBuilder2.put("finished", false);
                    readableMapBuilder2.put("value", valueAnimatedNode.nodeValue);
                    readableMapBuilder2.put(b.as, valueAnimatedNode.offset);
                    if (writableArrayCreateArray == null) {
                        writableArrayCreateArray = Arguments.createArray();
                    }
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                }
                this.activeAnimations.removeAt(i);
                i--;
            }
            i++;
        }
        if (writableArrayCreateArray == null || (reactApplicationContext = this.reactApplicationContext) == null) {
            return;
        }
        reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
    }

    public final void stopAnimation(int i) {
        WritableArray writableArrayCreateArray;
        ReactApplicationContext reactApplicationContext;
        int size = this.activeAnimations.size();
        int i2 = 0;
        while (true) {
            writableArrayCreateArray = null;
            if (i2 >= size) {
                break;
            }
            AnimationDriver animationDriver = (AnimationDriver) this.activeAnimations.valueAt(i2);
            if (animationDriver.id == i) {
                if (animationDriver.endCallback != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                    readableMapBuilder.put("finished", false);
                    ValueAnimatedNode valueAnimatedNode = animationDriver.animatedValue;
                    if (valueAnimatedNode == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    readableMapBuilder.put("value", valueAnimatedNode.nodeValue);
                    ValueAnimatedNode valueAnimatedNode2 = animationDriver.animatedValue;
                    if (valueAnimatedNode2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    readableMapBuilder.put(b.as, valueAnimatedNode2.offset);
                    Callback callback = animationDriver.endCallback;
                    if (callback == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    callback.invoke(writableMapCreateMap);
                } else if (this.reactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
                    readableMapBuilder2.put("animationId", animationDriver.id);
                    readableMapBuilder2.put("finished", false);
                    ValueAnimatedNode valueAnimatedNode3 = animationDriver.animatedValue;
                    if (valueAnimatedNode3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    readableMapBuilder2.put("value", valueAnimatedNode3.nodeValue);
                    ValueAnimatedNode valueAnimatedNode4 = animationDriver.animatedValue;
                    if (valueAnimatedNode4 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    readableMapBuilder2.put(b.as, valueAnimatedNode4.offset);
                    writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                }
                this.activeAnimations.removeAt(i2);
                break;
            }
            i2++;
        }
        if (writableArrayCreateArray == null || (reactApplicationContext = this.reactApplicationContext) == null) {
            return;
        }
        reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
    }

    public final void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
        }
        AnimatedNode animatedNode2 = (AnimatedNode) this.animatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        animatedNode.addChild$ReactAndroid_release(animatedNode2);
        this.updatedNodes.put(i2, animatedNode2);
    }

    public final void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
        }
        AnimatedNode animatedNode2 = (AnimatedNode) this.animatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        animatedNode.removeChild$ReactAndroid_release(animatedNode2);
        this.updatedNodes.put(i2, animatedNode2);
    }

    public final void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node with tag [" + i + "] does not exist");
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext == null) {
            throw new IllegalStateException(("connectAnimatedNodeToView: Animated node could not be connected, no ReactApplicationContext: " + i2).toString());
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i2);
        if (uIManagerForReactTag == null) {
            ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException("connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i2));
            return;
        }
        ((PropsAnimatedNode) animatedNode).connectToView(i2, uIManagerForReactTag);
        this.updatedNodes.put(i, animatedNode);
    }

    public final void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node with tag [" + i + "] does not exist");
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
        ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
    }

    public final void getValue(int i, Callback callback) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("getValue: Animated node with tag [" + i + "] does not exist or is not a 'value' node");
        }
        double value = ((ValueAnimatedNode) animatedNode).getValue();
        if (callback != null) {
            callback.invoke(Double.valueOf(value));
            return;
        }
        if (this.reactApplicationContext == null) {
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("tag", i);
        readableMapBuilder.put("value", value);
        this.reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleGetValue", writableMapCreateMap);
    }

    public final void restoreDefaultValues(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i);
        if (animatedNode == null) {
            return;
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view [?] should be of type " + PropsAnimatedNode.class.getName());
        }
        ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
    }

    public final void addAnimatedEventToView(int i, String eventHandlerName, ReadableMap eventMapping) {
        Intrinsics.checkNotNullParameter(eventHandlerName, "eventHandlerName");
        Intrinsics.checkNotNullParameter(eventMapping, "eventMapping");
        int i2 = eventMapping.getInt("animatedValueTag");
        AnimatedNode animatedNode = (AnimatedNode) this.animatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node with tag [" + i2 + "] does not exist");
        }
        if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node on view [" + i + "] connected to event handler (" + eventHandlerName + ") should be of type " + ValueAnimatedNode.class.getName());
        }
        ReadableArray array = eventMapping.getArray("nativeEventPath");
        if (array == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ArrayList arrayList = new ArrayList(array.size());
        int size = array.size();
        for (int i3 = 0; i3 < size; i3++) {
            String string = array.getString(i3);
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(string);
        }
        String strNormalizeEventName = normalizeEventName(eventHandlerName);
        this.eventDrivers.add(new EventAnimationDriver(strNormalizeEventName, i, arrayList, (ValueAnimatedNode) animatedNode));
        if (Intrinsics.areEqual(strNormalizeEventName, "topScroll")) {
            addAnimatedEventToView(i, "topScrollEnded", eventMapping);
        }
    }

    public final void removeAnimatedEventFromView(int i, String eventHandlerName, int i2) {
        Object next;
        Intrinsics.checkNotNullParameter(eventHandlerName, "eventHandlerName");
        String strNormalizeEventName = normalizeEventName(eventHandlerName);
        Iterator it = this.eventDrivers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            EventAnimationDriver eventAnimationDriver = (EventAnimationDriver) next;
            if (Intrinsics.areEqual(strNormalizeEventName, eventAnimationDriver.eventName) && i == eventAnimationDriver.viewTag && i2 == eventAnimationDriver.valueNode.tag) {
                break;
            }
        }
        EventAnimationDriver eventAnimationDriver2 = (EventAnimationDriver) next;
        if (eventAnimationDriver2 != null) {
            this.eventDrivers.remove(eventAnimationDriver2);
        }
        if (Intrinsics.areEqual(strNormalizeEventName, "topScroll")) {
            removeAnimatedEventFromView(i, "topScrollEnded", i2);
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(final Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.animated.NativeAnimatedNodesManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.handleEvent(event);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleEvent(Event event) {
        if (this.eventDrivers.isEmpty()) {
            return;
        }
        Event.EventAnimationDriverMatchSpec eventAnimationDriverMatchSpec = event.getEventAnimationDriverMatchSpec();
        boolean z = false;
        for (EventAnimationDriver eventAnimationDriver : this.eventDrivers) {
            if (eventAnimationDriverMatchSpec != null && eventAnimationDriverMatchSpec.match(eventAnimationDriver.viewTag, eventAnimationDriver.eventName)) {
                stopAnimationsForNode(eventAnimationDriver.valueNode);
                event.dispatchModern(eventAnimationDriver);
                this.runUpdateNodeList.add(eventAnimationDriver.valueNode);
                z = true;
            }
        }
        if (z) {
            updateNodes(this.runUpdateNodeList);
            this.runUpdateNodeList.clear();
        }
    }

    public final void runUpdates(long j) {
        ReactApplicationContext reactApplicationContext;
        UiThreadUtil.assertOnUiThread();
        int size = this.updatedNodes.size();
        for (int i = 0; i < size; i++) {
            AnimatedNode animatedNode = (AnimatedNode) this.updatedNodes.valueAt(i);
            List list = this.runUpdateNodeList;
            Intrinsics.checkNotNull(animatedNode);
            list.add(animatedNode);
        }
        this.updatedNodes.clear();
        int size2 = this.activeAnimations.size();
        boolean z = false;
        for (int i2 = 0; i2 < size2; i2++) {
            AnimationDriver animationDriver = (AnimationDriver) this.activeAnimations.valueAt(i2);
            animationDriver.runAnimationStep(j);
            ValueAnimatedNode valueAnimatedNode = animationDriver.animatedValue;
            if (valueAnimatedNode != null) {
                this.runUpdateNodeList.add(valueAnimatedNode);
            }
            if (animationDriver.hasFinished) {
                z = true;
            }
        }
        updateNodes(this.runUpdateNodeList);
        this.runUpdateNodeList.clear();
        if (z) {
            WritableArray writableArrayCreateArray = null;
            for (int size3 = this.activeAnimations.size() - 1; -1 < size3; size3--) {
                AnimationDriver animationDriver2 = (AnimationDriver) this.activeAnimations.valueAt(size3);
                if (animationDriver2.hasFinished) {
                    ValueAnimatedNode valueAnimatedNode2 = animationDriver2.animatedValue;
                    if (valueAnimatedNode2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    if (animationDriver2.endCallback != null) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                        readableMapBuilder.put("finished", true);
                        readableMapBuilder.put("value", valueAnimatedNode2.nodeValue);
                        readableMapBuilder.put(b.as, valueAnimatedNode2.offset);
                        Callback callback = animationDriver2.endCallback;
                        if (callback != null) {
                            callback.invoke(writableMapCreateMap);
                        }
                    } else if (this.reactApplicationContext != null) {
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
                        readableMapBuilder2.put("animationId", animationDriver2.id);
                        readableMapBuilder2.put("finished", true);
                        readableMapBuilder2.put("value", valueAnimatedNode2.nodeValue);
                        readableMapBuilder2.put(b.as, valueAnimatedNode2.offset);
                        if (writableArrayCreateArray == null) {
                            writableArrayCreateArray = Arguments.createArray();
                        }
                        writableArrayCreateArray.pushMap(writableMapCreateMap2);
                    }
                    this.activeAnimations.removeAt(size3);
                }
            }
            if (writableArrayCreateArray == null || (reactApplicationContext = this.reactApplicationContext) == null) {
                return;
            }
            reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
        }
    }

    public final Set getTagsOfConnectedNodes$ReactAndroid_release(int i, String eventName) {
        int i2;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        HashSet hashSet = new HashSet();
        for (EventAnimationDriver eventAnimationDriver : this.eventDrivers) {
            if (Intrinsics.areEqual(eventName, eventAnimationDriver.eventName) && i == (i2 = eventAnimationDriver.viewTag)) {
                hashSet.add(Integer.valueOf(i2));
                List list = eventAnimationDriver.valueNode.children;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(((AnimatedNode) it.next()).tag));
                    }
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b3 A[Catch: JSApplicationCausedNativeException -> 0x00ad, TRY_LEAVE, TryCatch #0 {JSApplicationCausedNativeException -> 0x00ad, blocks: (B:39:0x00a9, B:42:0x00af, B:44:0x00b3), top: B:82:0x00a9 }] */
    private final void updateNodes(List list) {
        List<AnimatedNode> list2;
        List<AnimatedNode> list3;
        int i = this.animatedGraphBFSColor;
        int i2 = i + 1;
        this.animatedGraphBFSColor = i2;
        if (i2 == 0) {
            this.animatedGraphBFSColor = i + 2;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AnimatedNode animatedNode = (AnimatedNode) it.next();
            int i4 = animatedNode.BFSColor;
            int i5 = this.animatedGraphBFSColor;
            if (i4 != i5) {
                animatedNode.BFSColor = i5;
                i3++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode2 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode2 != null && (list3 = animatedNode2.children) != null) {
                for (AnimatedNode animatedNode3 : list3) {
                    animatedNode3.activeIncomingNodes++;
                    int i6 = animatedNode3.BFSColor;
                    int i7 = this.animatedGraphBFSColor;
                    if (i6 != i7) {
                        animatedNode3.BFSColor = i7;
                        i3++;
                        arrayDeque.add(animatedNode3);
                    }
                }
            }
        }
        int i8 = this.animatedGraphBFSColor;
        int i9 = i8 + 1;
        this.animatedGraphBFSColor = i9;
        if (i9 == 0) {
            this.animatedGraphBFSColor = i8 + 2;
        }
        Iterator it2 = list.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            AnimatedNode animatedNode4 = (AnimatedNode) it2.next();
            if (animatedNode4.activeIncomingNodes == 0) {
                int i11 = animatedNode4.BFSColor;
                int i12 = this.animatedGraphBFSColor;
                if (i11 != i12) {
                    animatedNode4.BFSColor = i12;
                    i10++;
                    arrayDeque.add(animatedNode4);
                }
            }
        }
        int i13 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode5 != null) {
                try {
                    animatedNode5.update$ReactAndroid_release();
                    if (animatedNode5 instanceof PropsAnimatedNode) {
                        ((PropsAnimatedNode) animatedNode5).updateView();
                    }
                } catch (JSApplicationCausedNativeException e) {
                    FLog.e("NativeAnimatedNodesManager", "Native animation workaround, frame lost as result of race condition", e);
                }
            } else if (animatedNode5 instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode5).updateView();
            }
            if (animatedNode5 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode5).onValueUpdate();
            }
            if (animatedNode5 != null && (list2 = animatedNode5.children) != null) {
                for (AnimatedNode animatedNode6 : list2) {
                    int i14 = animatedNode6.activeIncomingNodes - 1;
                    animatedNode6.activeIncomingNodes = i14;
                    int i15 = animatedNode6.BFSColor;
                    int i16 = this.animatedGraphBFSColor;
                    if (i15 != i16 && i14 == 0) {
                        animatedNode6.BFSColor = i16;
                        i10++;
                        arrayDeque.add(animatedNode6);
                    } else if (i15 == i16) {
                        i13++;
                    }
                }
            }
        }
        if (i3 != i10) {
            if (this.warnedAboutGraphTraversal) {
                return;
            }
            this.warnedAboutGraphTraversal = true;
            FLog.e("NativeAnimatedNodesManager", "Detected animation cycle or disconnected graph. ");
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                FLog.e("NativeAnimatedNodesManager", ((AnimatedNode) it3.next()).prettyPrintWithChildren$ReactAndroid_release());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + (i13 > 0 ? "cycles (" + i13 + ")" : "disconnected regions") + ", there are " + i3 + " but toposort visited only " + i10);
            boolean z = this.eventListenerInitializedForFabric;
            if (z && i13 == 0) {
                ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException(illegalStateException));
                return;
            } else {
                if (z) {
                    ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException(illegalStateException));
                    return;
                }
                throw illegalStateException;
            }
        }
        this.warnedAboutGraphTraversal = false;
    }

    private final String normalizeEventName(String str) {
        if (!StringsKt.startsWith$default(str, "on", false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return "top" + strSubstring;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
