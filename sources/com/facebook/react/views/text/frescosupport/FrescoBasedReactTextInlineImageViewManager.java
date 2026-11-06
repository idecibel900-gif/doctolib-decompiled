package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = FrescoBasedReactTextInlineImageViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB3\b\u0007\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\u0006\u001a\u0016\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/views/text/frescosupport/FrescoBasedReactTextInlineImageViewManager;", "Lcom/facebook/react/uimanager/BaseViewManager;", "Landroid/view/View;", "Lcom/facebook/react/views/text/frescosupport/FrescoBasedReactTextInlineImageShadowNode;", "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "draweeControllerBuilder", "", "callerContext", "<init>", "(Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;Ljava/lang/Object;)V", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "context", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Landroid/view/View;", "createShadowNodeInstance", "()Lcom/facebook/react/views/text/frescosupport/FrescoBasedReactTextInlineImageShadowNode;", "Ljava/lang/Class;", "getShadowNodeClass", "()Ljava/lang/Class;", "root", "extraData", "", "updateExtraData", "(Landroid/view/View;Ljava/lang/Object;)V", "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;", "Ljava/lang/Object;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrescoBasedReactTextInlineImageViewManager extends BaseViewManager<View, FrescoBasedReactTextInlineImageShadowNode> {
    public static final String REACT_CLASS = "RCTTextInlineImage";
    private final Object callerContext;
    private final AbstractDraweeControllerBuilder draweeControllerBuilder;

    /* JADX WARN: Multi-variable type inference failed */
    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(abstractDraweeControllerBuilder, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(View root, Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    public /* synthetic */ FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : abstractDraweeControllerBuilder, (i & 2) != 0 ? null : obj);
    }

    public FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.draweeControllerBuilder = abstractDraweeControllerBuilder;
        this.callerContext = obj;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected View createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public FrescoBasedReactTextInlineImageShadowNode createShadowNodeInstance() {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilderNewDraweeControllerBuilder = this.draweeControllerBuilder;
        if (abstractDraweeControllerBuilderNewDraweeControllerBuilder == null) {
            abstractDraweeControllerBuilderNewDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        }
        Intrinsics.checkNotNull(abstractDraweeControllerBuilderNewDraweeControllerBuilder);
        return new FrescoBasedReactTextInlineImageShadowNode(abstractDraweeControllerBuilderNewDraweeControllerBuilder, this.callerContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<FrescoBasedReactTextInlineImageShadowNode> getShadowNodeClass() {
        return FrescoBasedReactTextInlineImageShadowNode.class;
    }
}
