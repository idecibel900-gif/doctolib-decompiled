package com.swmansion.worklets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;

/* JADX INFO: loaded from: classes4.dex */
public class JSCallInvokerResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static CallInvokerHolderImpl getJSCallInvokerHolder(ReactApplicationContext reactApplicationContext) {
        try {
            try {
                return (CallInvokerHolderImpl) reactApplicationContext.getClass().getMethod("getJSCallInvokerHolder", null).invoke(reactApplicationContext, null);
            } catch (Exception e) {
                throw new RuntimeException("Failed to get JSCallInvokerHolder", e);
            }
        } catch (Exception unused) {
            Object objInvoke = reactApplicationContext.getClass().getMethod("getCatalystInstance", null).invoke(reactApplicationContext, null);
            return (CallInvokerHolderImpl) objInvoke.getClass().getMethod("getJSCallInvokerHolder", null).invoke(objInvoke, null);
        }
    }
}
