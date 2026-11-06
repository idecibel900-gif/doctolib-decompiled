package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.formatters.FormattedRecord;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public final class ReturnType {
    private final JSTypeConverter converter;
    private final KClass klass;

    public ReturnType(KClass klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
        JSTypeConverter passThroughConverter = Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Unit.class)) ? new JSTypeConverter.PassThroughConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Bundle.class)) ? new JSTypeConverter.BundleConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(int[].class)) ? new JSTypeConverter.IntArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(float[].class)) ? new JSTypeConverter.FloatArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(double[].class)) ? new JSTypeConverter.DoubleArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(boolean[].class)) ? new JSTypeConverter.BooleanArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(byte[].class)) ? new JSTypeConverter.ByteArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(URI.class)) ? new JSTypeConverter.URIConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(URL.class)) ? new JSTypeConverter.URLConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Uri.class)) ? new JSTypeConverter.AndroidUriConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(File.class)) ? new JSTypeConverter.FileConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Pair.class)) ? new JSTypeConverter.PairConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Long.TYPE)) ? new JSTypeConverter.LongConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Duration.class)) ? new JSTypeConverter.DurationConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Object.class)) ? new JSTypeConverter.AnyConverter() : null;
        this.converter = passThroughConverter == null ? Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.MapConverter() : Enum.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.EnumConverter() : Record.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.RecordConverter() : FormattedRecord.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.FormattedRecordConverter() : RawTypedArrayHolder.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.RawTypedArrayHolderConverter() : Object[].class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.ArrayConverter() : Collection.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new JSTypeConverter.CollectionConverter() : new JSTypeConverter.PassThroughConverter() : passThroughConverter;
    }

    public final Object convertToJS(Object obj) {
        return this.converter.convertToJS(obj);
    }

    public final expo.modules.kotlin.jni.ReturnType getCppType() {
        return this.converter.getReturnType();
    }
}
