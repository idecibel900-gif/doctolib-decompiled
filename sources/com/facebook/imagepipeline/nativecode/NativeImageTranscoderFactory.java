package com.facebook.imagepipeline.nativecode;

import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeImageTranscoderFactory {
    public static final NativeImageTranscoderFactory INSTANCE = new NativeImageTranscoderFactory();

    private NativeImageTranscoderFactory() {
    }

    public static final ImageTranscoderFactory getNativeImageTranscoderFactory(int i, boolean z, boolean z2) {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Object objNewInstance = NativeJpegTranscoderFactory.class.getConstructor(cls, cls2, cls2).newInstance(Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2));
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.transcoder.ImageTranscoderFactory");
            return (ImageTranscoderFactory) objNewInstance;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e5);
        } catch (SecurityException e6) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e7);
        }
    }
}
