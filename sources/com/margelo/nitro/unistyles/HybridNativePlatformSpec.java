package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.margelo.nitro.core.HybridObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 =2\u00020\u0001:\u0002>=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001cH'¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010\"\u001a\u00020!H'¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0012H'¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020!H'¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020!H'¢\u0006\u0004\b*\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020!H'¢\u0006\u0004\b,\u0010)J\u000f\u0010.\u001a\u00020-H'¢\u0006\u0004\b.\u0010/J/\u00103\u001a\u00020\u00062\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020201\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000600H&¢\u0006\u0004\b3\u00104J#\u00106\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000605H&¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H'¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0019H\u0016¢\u0006\u0004\b9\u0010\u001bJ\u000f\u0010;\u001a\u00020:H\u0014¢\u0006\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec;", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "()V", "Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime;", "callback", "", "registerPlatformListener_cxx", "(Lcom/margelo/nitro/unistyles/Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime;)V", "Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime;", "registerImeListener_cxx", "(Lcom/margelo/nitro/unistyles/Func_void_UnistylesNativeMiniRuntime;)V", "Lcom/margelo/nitro/unistyles/Insets;", "getInsets", "()Lcom/margelo/nitro/unistyles/Insets;", "Lcom/margelo/nitro/unistyles/ColorScheme;", "getColorScheme", "()Lcom/margelo/nitro/unistyles/ColorScheme;", "", "getFontScale", "()D", "getPixelRatio", "Lcom/margelo/nitro/unistyles/Orientation;", "getOrientation", "()Lcom/margelo/nitro/unistyles/Orientation;", "", "getContentSizeCategory", "()Ljava/lang/String;", "Lcom/margelo/nitro/unistyles/Dimensions;", "getScreenDimensions", "()Lcom/margelo/nitro/unistyles/Dimensions;", "getStatusBarDimensions", "getNavigationBarDimensions", "", "getPrefersRtlDirection", "()Z", "color", "setRootViewBackgroundColor", "(D)V", "isHidden", "setNavigationBarHidden", "(Z)V", "setStatusBarHidden", "isEnabled", "setImmersiveMode", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "getMiniRuntime", "()Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "Lkotlin/Function2;", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "registerPlatformListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "registerImeListener", "(Lkotlin/jvm/functions/Function1;)V", "unregisterPlatformListeners", "toString", "Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec$CxxPart;", "createCxxPart", "()Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec$CxxPart;", "Companion", "CxxPart", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridNativePlatformSpec extends HybridObject {
    protected static final String TAG = "HybridNativePlatformSpec";

    @DoNotStrip
    @Keep
    public abstract ColorScheme getColorScheme();

    @DoNotStrip
    @Keep
    public abstract String getContentSizeCategory();

    @DoNotStrip
    @Keep
    public abstract double getFontScale();

    @DoNotStrip
    @Keep
    public abstract Insets getInsets();

    @DoNotStrip
    @Keep
    /* JADX INFO: renamed from: getMiniRuntime */
    public abstract UnistylesNativeMiniRuntime get_miniRuntime();

    @DoNotStrip
    @Keep
    public abstract Dimensions getNavigationBarDimensions();

    @DoNotStrip
    @Keep
    public abstract Orientation getOrientation();

    @DoNotStrip
    @Keep
    public abstract double getPixelRatio();

    @DoNotStrip
    @Keep
    public abstract boolean getPrefersRtlDirection();

    @DoNotStrip
    @Keep
    public abstract Dimensions getScreenDimensions();

    @DoNotStrip
    @Keep
    public abstract Dimensions getStatusBarDimensions();

    public abstract void registerImeListener(Function1 callback);

    public abstract void registerPlatformListener(Function2 callback);

    @DoNotStrip
    @Keep
    public abstract void setImmersiveMode(boolean isEnabled);

    @DoNotStrip
    @Keep
    public abstract void setNavigationBarHidden(boolean isHidden);

    @DoNotStrip
    @Keep
    public abstract void setRootViewBackgroundColor(double color);

    @DoNotStrip
    @Keep
    public abstract void setStatusBarHidden(boolean isHidden);

    @DoNotStrip
    @Keep
    public abstract void unregisterPlatformListeners();

    @DoNotStrip
    @Keep
    private final void registerPlatformListener_cxx(Func_void_std__vector_UnistyleDependency__UnistylesNativeMiniRuntime callback) {
        registerPlatformListener(callback);
        Unit unit = Unit.INSTANCE;
    }

    @DoNotStrip
    @Keep
    private final void registerImeListener_cxx(Func_void_UnistylesNativeMiniRuntime callback) {
        registerImeListener(callback);
        Unit unit = Unit.INSTANCE;
    }

    @Override // com.margelo.nitro.core.HybridObject
    public String toString() {
        return "[HybridObject NativePlatform]";
    }

    @DoNotStrip
    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0094 ¨\u0006\b"}, d2 = {"Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec$CxxPart;", "Lcom/margelo/nitro/core/HybridObject$CxxPart;", "javaPart", "Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec;", "<init>", "(Lcom/margelo/nitro/unistyles/HybridNativePlatformSpec;)V", "initHybrid", "Lcom/facebook/jni/HybridData;", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    protected static class CxxPart extends HybridObject.CxxPart {
        @Override // com.margelo.nitro.core.HybridObject.CxxPart
        protected native HybridData initHybrid();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CxxPart(HybridNativePlatformSpec javaPart) {
            super(javaPart);
            Intrinsics.checkNotNullParameter(javaPart, "javaPart");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.margelo.nitro.core.HybridObject
    public CxxPart createCxxPart() {
        return new CxxPart(this);
    }
}
