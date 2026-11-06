package com.facebook.react.uimanager;

import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaValue;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactShadowNode {
    void addChildAt(ReactShadowNode reactShadowNode, int i);

    void addNativeChildAt(ReactShadowNode reactShadowNode, int i);

    void calculateLayout();

    void calculateLayout(float f, float f2);

    Iterable calculateLayoutOnChildren();

    void dirty();

    void dispatchUpdates(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    boolean dispatchUpdatesWillChangeLayout(float f, float f2);

    void dispose();

    ReactShadowNode getChildAt(int i);

    int getChildCount();

    Integer getHeightMeasureSpec();

    YogaDirection getLayoutDirection();

    float getLayoutHeight();

    ReactShadowNode getLayoutParent();

    float getLayoutWidth();

    float getLayoutX();

    float getLayoutY();

    int getNativeChildCount();

    NativeKind getNativeKind();

    int getNativeOffsetForChild(ReactShadowNode reactShadowNode);

    ReactShadowNode getNativeParent();

    ReactShadowNode getParent();

    int getReactTag();

    int getRootTag();

    int getScreenHeight();

    int getScreenWidth();

    int getScreenX();

    int getScreenY();

    YogaValue getStyleHeight();

    YogaValue getStyleWidth();

    ThemedReactContext getThemedContext();

    String getViewClass();

    Integer getWidthMeasureSpec();

    boolean hasUpdates();

    int indexOf(ReactShadowNode reactShadowNode);

    int indexOfNativeChild(ReactShadowNode reactShadowNode);

    boolean isDescendantOf(ReactShadowNode reactShadowNode);

    boolean isLayoutOnly();

    boolean isVirtual();

    void markUpdateSeen();

    void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer);

    void removeAllNativeChildren();

    void removeAndDisposeAllChildren();

    ReactShadowNode removeChildAt(int i);

    ReactShadowNode removeNativeChildAt(int i);

    void setIsLayoutOnly(boolean z);

    void setLayoutDirection(YogaDirection yogaDirection);

    void setLayoutParent(ReactShadowNode reactShadowNode);

    void setLocalData(Object obj);

    void setMeasureSpecs(int i, int i2);

    void setPadding(int i, float f);

    void setReactTag(int i);

    void setRootTag(int i);

    void setStyleHeight(float f);

    void setStyleWidth(float f);

    void setThemedContext(ThemedReactContext themedReactContext);

    void setViewClassName(String str);

    boolean shouldNotifyOnLayout();

    void updateProperties(ReactStylesDiffMap reactStylesDiffMap);
}
