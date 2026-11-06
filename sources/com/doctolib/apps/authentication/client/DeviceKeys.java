package com.doctolib.apps.authentication.client;

import androidx.fragment.app.FragmentActivity;
import com.doctolib.apps.authentication.config.AuthConfig;
import com.doctolib.apps.authentication.internal.core.InternalAuthClient;
import com.doctolib.apps.authentication.internal.devicekey.DeviceKeyManager;
import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeys {
    private final AuthConfig config;
    private final InternalAuthClient engine;
    private final DeviceKeyManager manager;

    public DeviceKeys(DeviceKeyManager manager, InternalAuthClient engine, AuthConfig config) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(config, "config");
        this.manager = manager;
        this.engine = engine;
        this.config = config;
    }

    public final Object canUse(DeviceKeyUserAuthentication deviceKeyUserAuthentication, Continuation continuation) {
        return Boxing.boxBoolean(this.manager.canUse(deviceKeyUserAuthentication));
    }

    public final Object enrolledKey(Continuation continuation) {
        return this.manager.enrolledKey(DeviceKeySlot.DEVICE_BOUND, continuation);
    }

    public final Object enroll(DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, Continuation continuation) {
        return this.engine.deviceKeyEnroll(this.config, deviceKeyUserAuthentication, deviceKeyStorage, continuation);
    }

    public final Object reLogin(FragmentActivity fragmentActivity, Continuation continuation) {
        return this.engine.deviceKeyReLogin(this.config, fragmentActivity, continuation);
    }

    public final Object forgetDevice(Continuation continuation) {
        Object objDeviceKeyForget = this.engine.deviceKeyForget(this.config, continuation);
        return objDeviceKeyForget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeviceKeyForget : Unit.INSTANCE;
    }
}
