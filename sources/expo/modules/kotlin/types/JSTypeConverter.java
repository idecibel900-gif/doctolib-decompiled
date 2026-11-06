package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface JSTypeConverter {
    Object convertToJS(Object obj);

    expo.modules.kotlin.jni.ReturnType getReturnType();

    public static final class PassThroughConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            return obj;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    public static final class BundleConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Bundle bundle = (Bundle) obj;
            if (bundle != null) {
                return JSTypeConverterHelperKt.toJSValue(bundle, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_MAP;
        }
    }

    public static final class ArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr != null) {
                return JSTypeConverterHelperKt.toJSValue(objArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_ARRAY;
        }
    }

    public static final class IntArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            int[] iArr = (int[]) obj;
            if (iArr != null) {
                return JSTypeConverterHelperKt.toJSValue(iArr, (JSTypeConverterProvider.ContainerProvider) JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.INT_ARRAY;
        }
    }

    public static final class FloatArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            float[] fArr = (float[]) obj;
            if (fArr != null) {
                return JSTypeConverterHelperKt.toJSValue(fArr, (JSTypeConverterProvider.ContainerProvider) JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.FLOAT_ARRAY;
        }
    }

    public static final class DoubleArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            double[] dArr = (double[]) obj;
            if (dArr != null) {
                return JSTypeConverterHelperKt.toJSValue(dArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.DOUBLE_ARRAY;
        }
    }

    public static final class BooleanArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            if (zArr != null) {
                return JSTypeConverterHelperKt.toJSValue(zArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.BOOLEAN_ARRAY;
        }
    }

    public static final class ByteArrayConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            byte[] bArr = (byte[]) obj;
            if (bArr != null) {
                return FollyDynamicExtensionConverter.INSTANCE.put(bArr);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    public static final class MapConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Map map = (Map) obj;
            if (map != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(map);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }

    public static final class EnumConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Enum r1 = (Enum) obj;
            if (r1 != null) {
                return JSTypeConverterHelperKt.toJSValue(r1);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    public static final class RecordConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Record record = (Record) obj;
            if (record != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(record);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }

    public static final class URIConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            URI uri = (URI) obj;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    public static final class URLConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            URL url = (URL) obj;
            if (url != null) {
                return JSTypeConverterHelperKt.toJSValue(url);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    public static final class AndroidUriConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Uri uri = (Uri) obj;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    public static final class FileConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            File file = (File) obj;
            if (file != null) {
                return JSTypeConverterHelperKt.toJSValue(file);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    public static final class PairConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Pair pair = (Pair) obj;
            if (pair != null) {
                return JSTypeConverterHelperKt.toJSValue(pair, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_ARRAY;
        }
    }

    public static final class LongConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Long l = (Long) obj;
            if (l != null) {
                return Double.valueOf(l.longValue());
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.LONG;
        }
    }

    public static final class DurationConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Duration duration = (Duration) obj;
            if (duration != null) {
                return Double.valueOf(Duration.m5425toDoubleimpl(duration.m5431unboximpl(), DurationUnit.SECONDS));
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.DOUBLE;
        }
    }

    public static final class RawTypedArrayHolderConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            RawTypedArrayHolder rawTypedArrayHolder = (RawTypedArrayHolder) obj;
            if (rawTypedArrayHolder != null) {
                return rawTypedArrayHolder.getRawArray();
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.JS_TYPED_ARRAY;
        }
    }

    public static final class CollectionConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            Collection collection = (Collection) obj;
            if (collection != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(collection);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.COLLECTION;
        }
    }

    public static final class AnyConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            return JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, true, 2, null);
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    public static final class FormattedRecordConverter implements JSTypeConverter {
        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object obj) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }
}
