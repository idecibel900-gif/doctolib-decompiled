package expo.modules.kotlin.runtime;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Runtime {
    public abstract AppContext getAppContext();

    public abstract ClassRegistry getClassRegistry$expo_modules_core_release();

    public abstract JNIDeallocator getDeallocator();

    public abstract JSIContext getJsiContext();

    public abstract SharedObjectRegistry getSharedObjectRegistry$expo_modules_core_release();
}
