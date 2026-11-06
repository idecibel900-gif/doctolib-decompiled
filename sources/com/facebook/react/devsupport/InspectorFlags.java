package com.facebook.react.devsupport;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0087 J\t\u0010\u0006\u001a\u00020\u0005H\u0087 J\t\u0010\u0007\u001a\u00020\u0005H\u0087 J\t\u0010\b\u001a\u00020\u0005H\u0087 ¨\u0006\t"}, d2 = {"Lcom/facebook/react/devsupport/InspectorFlags;", "", "<init>", "()V", "getScreenshotCaptureEnabled", "", "getFuseboxEnabled", "getIsProfilingBuild", "getFrameRecordingEnabled", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InspectorFlags {
    public static final InspectorFlags INSTANCE = new InspectorFlags();

    @DoNotStrip
    public static final native boolean getFrameRecordingEnabled();

    @DoNotStrip
    public static final native boolean getFuseboxEnabled();

    @DoNotStrip
    public static final native boolean getIsProfilingBuild();

    @DoNotStrip
    public static final native boolean getScreenshotCaptureEnabled();

    private InspectorFlags() {
    }

    static {
        SoLoader.loadLibrary("react_devsupportjni");
    }
}
