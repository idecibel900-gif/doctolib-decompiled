package io.invertase.firebase.app;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import io.invertase.firebase.utils.ReactNativeFirebaseUtilsModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ReactNativeFirebaseAppPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public /* bridge */ /* synthetic */ NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return super.getModule(str, reactApplicationContext);
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        if (ReactNativeFirebaseApp.getApplicationContext() == null) {
            ReactNativeFirebaseApp.setApplicationContext(reactApplicationContext.getApplicationContext());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactNativeFirebaseAppModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseUtilsModule(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }
}
