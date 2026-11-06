package com.th3rdwave.safeareacontext;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.viewmanagers.RNCSafeAreaProviderManagerDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = SafeAreaProviderManager.REACT_CLASS)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\b\u001a\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00000\u00000\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00110\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00000\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaProviderManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/th3rdwave/safeareacontext/SafeAreaProvider;", "", "<init>", "()V", "Lcom/facebook/react/viewmanagers/RNCSafeAreaProviderManagerDelegate;", "kotlin.jvm.PlatformType", "getDelegate", "()Lcom/facebook/react/viewmanagers/RNCSafeAreaProviderManagerDelegate;", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "context", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/th3rdwave/safeareacontext/SafeAreaProvider;", "", "getExportedCustomDirectEventTypeConstants", "()Ljava/util/Map;", "reactContext", "view", "", "addEventEmitters", "(Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/th3rdwave/safeareacontext/SafeAreaProvider;)V", "mDelegate", "Lcom/facebook/react/viewmanagers/RNCSafeAreaProviderManagerDelegate;", "Companion", "react-native-safe-area-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> implements ViewManagerWithGeneratedInterface {
    public static final String REACT_CLASS = "RNCSafeAreaProvider";
    private final RNCSafeAreaProviderManagerDelegate mDelegate;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    public SafeAreaProviderManager() {
        super(null, 1, null);
        this.mDelegate = new RNCSafeAreaProviderManagerDelegate(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    /* JADX INFO: renamed from: getDelegate, reason: from getter */
    public RNCSafeAreaProviderManagerDelegate getMDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public SafeAreaProvider createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SafeAreaProvider(context);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to("topInsetsChange", MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onInsetsChange"))));
    }

    /* JADX INFO: renamed from: com.th3rdwave.safeareacontext.SafeAreaProviderManager$addEventEmitters$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, SafeAreaProviderManagerKt.class, "handleOnInsetsChange", "handleOnInsetsChange(Lcom/th3rdwave/safeareacontext/SafeAreaProvider;Lcom/th3rdwave/safeareacontext/EdgeInsets;Lcom/th3rdwave/safeareacontext/Rect;)V", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SafeAreaProvider) obj, (EdgeInsets) obj2, (Rect) obj3);
            return Unit.INSTANCE;
        }

        public final void invoke(SafeAreaProvider p0, EdgeInsets p1, Rect p2) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            SafeAreaProviderManagerKt.handleOnInsetsChange(p0, p1, p2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, SafeAreaProvider view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.setOnInsetsChangeHandler(AnonymousClass1.INSTANCE);
    }
}
