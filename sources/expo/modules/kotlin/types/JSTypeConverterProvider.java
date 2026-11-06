package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class JSTypeConverterProvider {
    public static final JSTypeConverterProvider INSTANCE = new JSTypeConverterProvider();

    public interface ContainerProvider {
        WritableArray createArray();

        WritableMap createMap();
    }

    private JSTypeConverterProvider() {
    }

    public static final class DefaultContainerProvider implements ContainerProvider {
        public static final DefaultContainerProvider INSTANCE = new DefaultContainerProvider();

        private DefaultContainerProvider() {
        }

        @Override // expo.modules.kotlin.types.JSTypeConverterProvider.ContainerProvider
        public WritableMap createMap() {
            return Arguments.createMap();
        }

        @Override // expo.modules.kotlin.types.JSTypeConverterProvider.ContainerProvider
        public WritableArray createArray() {
            return Arguments.createArray();
        }
    }

    public static /* synthetic */ Object legacyConvertToJSValue$default(JSTypeConverterProvider jSTypeConverterProvider, Object obj, ContainerProvider containerProvider, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        return jSTypeConverterProvider.legacyConvertToJSValue(obj, containerProvider);
    }

    public final Object legacyConvertToJSValue(Object obj, ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (obj == null || (obj instanceof Unit)) {
            return null;
        }
        if (obj instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) obj, containerProvider);
        }
        if (obj instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((Object[]) obj, containerProvider);
        }
        if (obj instanceof int[]) {
            return JSTypeConverterHelperKt.toJSValue((int[]) obj, containerProvider);
        }
        if (obj instanceof long[]) {
            return JSTypeConverterHelperKt.toJSValue((long[]) obj, containerProvider);
        }
        if (obj instanceof float[]) {
            return JSTypeConverterHelperKt.toJSValue((float[]) obj, containerProvider);
        }
        if (obj instanceof double[]) {
            return JSTypeConverterHelperKt.toJSValue((double[]) obj, containerProvider);
        }
        if (obj instanceof boolean[]) {
            return JSTypeConverterHelperKt.toJSValue((boolean[]) obj, containerProvider);
        }
        if (obj instanceof byte[]) {
            return FollyDynamicExtensionConverter.INSTANCE.put(obj);
        }
        if (obj instanceof Map) {
            return JSTypeConverterHelperKt.toJSValue((Map) obj, containerProvider);
        }
        if (obj instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum) obj);
        }
        if (obj instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) obj, containerProvider);
        }
        if (obj instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) obj);
        }
        if (obj instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) obj);
        }
        if (obj instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) obj);
        }
        if (obj instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) obj);
        }
        if (obj instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair) obj, containerProvider);
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof Duration) {
            return Double.valueOf(Duration.m5425toDoubleimpl(((Duration) obj).m5431unboximpl(), DurationUnit.SECONDS));
        }
        if (obj instanceof RawTypedArrayHolder) {
            return ((RawTypedArrayHolder) obj).getRawArray();
        }
        return obj instanceof Collection ? JSTypeConverterHelperKt.toJSValue((Collection) obj, containerProvider) : obj;
    }

    public static /* synthetic */ Object convertToJSValue$default(JSTypeConverterProvider jSTypeConverterProvider, Object obj, ContainerProvider containerProvider, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return jSTypeConverterProvider.convertToJSValue(obj, containerProvider, z);
    }

    public final Object convertToJSValue(Object obj, ContainerProvider containerProvider, boolean z) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (obj == null || (obj instanceof Unit)) {
            return null;
        }
        if (obj instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) obj, containerProvider);
        }
        if (obj instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((Object[]) obj, containerProvider);
        }
        if ((obj instanceof int[]) || (obj instanceof float[]) || (obj instanceof double[]) || (obj instanceof boolean[]) || (obj instanceof long[])) {
            return obj;
        }
        if (obj instanceof byte[]) {
            return FollyDynamicExtensionConverter.INSTANCE.put(obj);
        }
        if (obj instanceof Map) {
            if (z) {
                return JSTypeConverterHelperKt.toJSValueExperimental((Map) obj);
            }
            return JSTypeConverterHelperKt.toJSValue((Map) obj, containerProvider);
        }
        if (obj instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum) obj);
        }
        if (obj instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) obj, containerProvider);
        }
        if (obj instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) obj);
        }
        if (obj instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) obj);
        }
        if (obj instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) obj);
        }
        if (obj instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) obj);
        }
        if (obj instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair) obj, containerProvider);
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof Duration) {
            return Double.valueOf(Duration.m5425toDoubleimpl(((Duration) obj).m5431unboximpl(), DurationUnit.SECONDS));
        }
        if (obj instanceof RawTypedArrayHolder) {
            return ((RawTypedArrayHolder) obj).getRawArray();
        }
        if (!(obj instanceof Collection)) {
            return obj;
        }
        if (z) {
            return JSTypeConverterHelperKt.toJSValueExperimental((Collection) obj);
        }
        return JSTypeConverterHelperKt.toJSValue((Collection) obj, containerProvider);
    }
}
