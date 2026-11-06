package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.trace.model.SpanEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSpanEventMapper implements ContextAwareMapper {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.TV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeviceType.DESKTOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeviceType.GAMING_CONSOLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeviceType.BOT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DeviceType.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected final SpanEvent.Usr resolveUserInfo(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new SpanEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
    }

    protected final SpanEvent.Device resolveDeviceInfo(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return new SpanEvent.Device(resolveDeviceType(deviceInfo.getDeviceType()), deviceInfo.getDeviceName(), deviceInfo.getDeviceModel(), deviceInfo.getDeviceBrand(), deviceInfo.getArchitecture());
    }

    protected final SpanEvent.Network resolveNetworkInfo(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        SpanEvent.SimCarrier simCarrierResolveSimCarrier = resolveSimCarrier(networkInfo);
        Long strength = networkInfo.getStrength();
        String string = strength != null ? strength.toString() : null;
        Long downKbps = networkInfo.getDownKbps();
        String string2 = downKbps != null ? downKbps.toString() : null;
        Long upKbps = networkInfo.getUpKbps();
        return new SpanEvent.Network(new SpanEvent.Client(simCarrierResolveSimCarrier, string, string2, upKbps != null ? upKbps.toString() : null, networkInfo.getConnectivity().toString()));
    }

    protected final SpanEvent.Os resolveOsInfo(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return new SpanEvent.Os(deviceInfo.getOsName(), deviceInfo.getOsVersion(), null, deviceInfo.getOsMajorVersion(), 4, null);
    }

    private final SpanEvent.SimCarrier resolveSimCarrier(NetworkInfo networkInfo) {
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        return new SpanEvent.SimCarrier(carrierId != null ? carrierId.toString() : null, networkInfo.getCarrierName());
    }

    private final SpanEvent.Type resolveDeviceType(DeviceType deviceType) {
        switch (WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()]) {
            case 1:
                return SpanEvent.Type.MOBILE;
            case 2:
                return SpanEvent.Type.TABLET;
            case 3:
                return SpanEvent.Type.TV;
            case 4:
                return SpanEvent.Type.DESKTOP;
            case 5:
                return SpanEvent.Type.GAMING_CONSOLE;
            case 6:
                return SpanEvent.Type.BOT;
            case 7:
                return SpanEvent.Type.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
