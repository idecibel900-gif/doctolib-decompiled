package expo.modules.kotlin.types;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.exception.UnsupportedClass;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptArrayBuffer;
import expo.modules.kotlin.jni.JavaScriptFunction;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.jni.NativeArrayBuffer;
import expo.modules.kotlin.jni.worklets.Serializable;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.sharedobjects.SharedRefTypeConverter;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import expo.modules.kotlin.types.io.FileTypeConverter;
import expo.modules.kotlin.types.io.PathTypeConverter;
import expo.modules.kotlin.types.net.JavaURITypeConverter;
import expo.modules.kotlin.types.net.URLTypConverter;
import expo.modules.kotlin.types.net.UriTypeConverter;
import expo.modules.kotlin.types.worklets.SerializableTypeConverter;
import expo.modules.kotlin.types.worklets.WorkletTypeConverter;
import expo.modules.kotlin.views.ViewTypeConverter;
import j$.time.LocalDate;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public final class TypeConverterProviderImpl implements TypeConverterProvider {
    public static final TypeConverterProviderImpl INSTANCE;
    private static final Map cachedConverters;
    private static final Map cachedPrimitiveArrayConverters;
    private static final Map cachedRecordConverters;

    private TypeConverterProviderImpl() {
    }

    static {
        TypeConverterProviderImpl typeConverterProviderImpl = new TypeConverterProviderImpl();
        INSTANCE = typeConverterProviderImpl;
        cachedConverters = typeConverterProviderImpl.createCachedConverters();
        cachedPrimitiveArrayConverters = typeConverterProviderImpl.createCachedPrimitiveArrayConverters();
        cachedRecordConverters = new LinkedHashMap();
    }

    private final TypeConverter getCachedConverter(KType kType) {
        return (TypeConverter) cachedConverters.get(kType.getClassifier());
    }

    private final TypeConverter getCachedPrimitiveArrayConverter(KType kType) {
        return (TypeConverter) cachedPrimitiveArrayConverters.get(kType.getClassifier());
    }

    @Override // expo.modules.kotlin.types.TypeConverterProvider
    public TypeConverter obtainTypeConverter(KType type) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter typeConverterObtainNonNullableTypeConverter = obtainNonNullableTypeConverter(type);
        return type.isMarkedNullable() ? new NullableTypeConverter(typeConverterObtainNonNullableTypeConverter) : typeConverterObtainNonNullableTypeConverter;
    }

    public final TypeConverter obtainNonNullableTypeConverter(KType type) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter cachedConverter = getCachedConverter(type);
        if (cachedConverter != null) {
            return cachedConverter;
        }
        KClassifier classifier = type.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            throw new MissingTypeConverter(type);
        }
        Class javaClass = JvmClassMappingKt.getJavaClass(kClass);
        if (javaClass.isArray() || Object[].class.isAssignableFrom(javaClass)) {
            if (ArrayTypeConverterKt.isPrimitiveArray(type, javaClass)) {
                TypeConverter cachedPrimitiveArrayConverter = getCachedPrimitiveArrayConverter(type);
                if (cachedPrimitiveArrayConverter != null) {
                    return cachedPrimitiveArrayConverter;
                }
                throw new MissingTypeConverter(type);
            }
            return new ArrayTypeConverter(this, type);
        }
        if (List.class.isAssignableFrom(javaClass)) {
            return new ListTypeConverter(this, type);
        }
        if (Map.class.isAssignableFrom(javaClass)) {
            return new MapTypeConverter(this, type);
        }
        if (Pair.class.isAssignableFrom(javaClass)) {
            return new PairTypeConverter(this, type);
        }
        if (Set.class.isAssignableFrom(javaClass)) {
            return new SetTypeConverter(this, type);
        }
        if (javaClass.isEnum()) {
            return new EnumTypeConverter(kClass);
        }
        Map map = cachedRecordConverters;
        TypeConverter typeConverter = (TypeConverter) map.get(type);
        if (typeConverter != null) {
            return typeConverter;
        }
        if (Record.class.isAssignableFrom(javaClass)) {
            RecordTypeConverter recordTypeConverter = new RecordTypeConverter(this, type);
            map.put(type, recordTypeConverter);
            return recordTypeConverter;
        }
        if (View.class.isAssignableFrom(javaClass)) {
            return new ViewTypeConverter(type);
        }
        if (SharedRef.class.isAssignableFrom(javaClass)) {
            return new SharedRefTypeConverter(type);
        }
        if (SharedObject.class.isAssignableFrom(javaClass)) {
            return new SharedObjectTypeConverter(type);
        }
        if (JavaScriptFunction.class.isAssignableFrom(javaClass)) {
            return new JavaScriptFunctionTypeConverter(type);
        }
        if (ValueOrUndefined.class.isAssignableFrom(javaClass)) {
            return new ValueOrUndefinedTypeConverter(this, type);
        }
        TypeConverter typeConverterHandelEither = handelEither(type, javaClass);
        if (typeConverterHandelEither != null) {
            return typeConverterHandelEither;
        }
        throw new MissingTypeConverter(type);
    }

    private final TypeConverter handelEither(KType kType, Class cls) {
        if (!Either.class.isAssignableFrom(cls)) {
            return null;
        }
        if (EitherOfFour.class.isAssignableFrom(cls)) {
            return new EitherOfFourTypeConverter(this, kType);
        }
        if (EitherOfThree.class.isAssignableFrom(cls)) {
            return new EitherOfThreeTypeConverter(this, kType);
        }
        return new EitherTypeConverter(this, kType);
    }

    private final Map createCachedConverters() {
        final ExpectedType expectedType = new ExpectedType(CppType.INT);
        DynamicAwareTypeConverters dynamicAwareTypeConverters = new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Integer) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Integer.valueOf((int) value.asDouble());
            }
        };
        final ExpectedType expectedType2 = new ExpectedType(CppType.LONG);
        DynamicAwareTypeConverters dynamicAwareTypeConverters2 = new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Long) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Long.valueOf((long) value.asDouble());
            }
        };
        final ExpectedType expectedType3 = new ExpectedType(CppType.DOUBLE);
        DynamicAwareTypeConverters dynamicAwareTypeConverters3 = new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Double) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Double.valueOf(value.asDouble());
            }
        };
        final ExpectedType expectedType4 = new ExpectedType(CppType.FLOAT);
        DynamicAwareTypeConverters dynamicAwareTypeConverters4 = new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Float) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Float.valueOf((float) value.asDouble());
            }
        };
        final ExpectedType expectedType5 = new ExpectedType(CppType.BOOLEAN);
        DynamicAwareTypeConverters dynamicAwareTypeConverters5 = new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Boolean) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Boolean.valueOf(value.asBoolean());
            }
        };
        SerializableTypeConverter serializableTypeConverter = new SerializableTypeConverter();
        Pair pair = TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), dynamicAwareTypeConverters);
        Pair pair2 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.class), dynamicAwareTypeConverters);
        Pair pair3 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), dynamicAwareTypeConverters2);
        Pair pair4 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.class), dynamicAwareTypeConverters2);
        Pair pair5 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), dynamicAwareTypeConverters3);
        Pair pair6 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.class), dynamicAwareTypeConverters3);
        Pair pair7 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), dynamicAwareTypeConverters4);
        Pair pair8 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.class), dynamicAwareTypeConverters4);
        Pair pair9 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), dynamicAwareTypeConverters5);
        Pair pair10 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.class), dynamicAwareTypeConverters5);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        final ExpectedType expectedType6 = new ExpectedType(CppType.STRING);
        Pair pair11 = TuplesKt.to(orCreateKotlinClass, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$6
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (String) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType6;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                String strAsString = value.asString();
                if (strAsString != null) {
                    return strAsString;
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(String.class));
            }
        });
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ReadableArray.class);
        final ExpectedType expectedType7 = new ExpectedType(CppType.READABLE_ARRAY);
        Pair pair12 = TuplesKt.to(orCreateKotlinClass2, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$7
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (ReadableArray) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType7;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray != null) {
                    return readableArrayAsArray;
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
            }
        });
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ReadableMap.class);
        final ExpectedType expectedType8 = new ExpectedType(CppType.READABLE_MAP);
        Pair pair13 = TuplesKt.to(orCreateKotlinClass3, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$8
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (ReadableMap) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType8;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableMap readableMapAsMap = value.asMap();
                if (readableMapAsMap != null) {
                    return readableMapAsMap;
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableMap.class));
            }
        });
        Pair pair14 = TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), new ByteArrayTypeConverter());
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JavaScriptValue.class);
        final ExpectedType expectedType9 = new ExpectedType(CppType.JS_VALUE);
        Pair pair15 = TuplesKt.to(orCreateKotlinClass4, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType9;
            }
        });
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JavaScriptObject.class);
        final ExpectedType expectedType10 = new ExpectedType(CppType.JS_OBJECT);
        Pair pair16 = TuplesKt.to(orCreateKotlinClass5, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType10;
            }
        });
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(JavaScriptArrayBuffer.class);
        final ExpectedType expectedType11 = new ExpectedType(CppType.JS_ARRAY_BUFFER);
        Pair pair17 = TuplesKt.to(orCreateKotlinClass6, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType11;
            }
        });
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(NativeArrayBuffer.class);
        final ExpectedType expectedType12 = new ExpectedType(CppType.NATIVE_ARRAY_BUFFER);
        Map mapMapOf = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, TuplesKt.to(orCreateKotlinClass7, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedType12;
            }
        }), TuplesKt.to(Reflection.getOrCreateKotlinClass(Serializable.class), serializableTypeConverter), TuplesKt.to(Reflection.getOrCreateKotlinClass(Worklet.class), new WorkletTypeConverter(serializableTypeConverter)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int8Array.class), new Int8ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int16Array.class), new Int16ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int32Array.class), new Int32ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8Array.class), new Uint8ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), new Uint8ClampedArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint16Array.class), new Uint16ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint32Array.class), new Uint32ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float32Array.class), new Float32ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float64Array.class), new Float64ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(BigInt64Array.class), new BigInt64ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(BigUint64Array.class), new BigUint64ArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(TypedArray.class), new TypedArrayTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(URL.class), new URLTypConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uri.class), new UriTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(URI.class), new JavaURITypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(File.class), new FileTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Duration.class), new DurationTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Object.class), new AnyTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), new UnitTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArguments.class), new ReadableArgumentsTypeConverter()));
        return Build.VERSION.SDK_INT >= 26 ? MapsKt.plus(mapMapOf, MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(TypeConverterProviderImpl$$ExternalSyntheticApiModelOutline0.m()), new PathTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Color.class), new ColorTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(LocalDate.class), new DateTypeConverter()))) : mapMapOf;
    }

    private final Map createCachedPrimitiveArrayConverters() {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(int[].class);
        ExpectedType.Companion companion = ExpectedType.INSTANCE;
        final ExpectedType expectedTypeForPrimitiveArray = companion.forPrimitiveArray(CppType.INT);
        Pair pair = TuplesKt.to(orCreateKotlinClass, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (int[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedTypeForPrimitiveArray;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = readableArrayAsArray.getInt(i);
                }
                return iArr;
            }
        });
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(long[].class);
        final ExpectedType expectedTypeForPrimitiveArray2 = companion.forPrimitiveArray(CppType.LONG);
        Pair pair2 = TuplesKt.to(orCreateKotlinClass2, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (long[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedTypeForPrimitiveArray2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = (long) readableArrayAsArray.getDouble(i);
                }
                return jArr;
            }
        });
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(double[].class);
        final ExpectedType expectedTypeForPrimitiveArray3 = companion.forPrimitiveArray(CppType.DOUBLE);
        Pair pair3 = TuplesKt.to(orCreateKotlinClass3, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (double[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedTypeForPrimitiveArray3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = readableArrayAsArray.getDouble(i);
                }
                return dArr;
            }
        });
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(float[].class);
        final ExpectedType expectedTypeForPrimitiveArray4 = companion.forPrimitiveArray(CppType.FLOAT);
        Pair pair4 = TuplesKt.to(orCreateKotlinClass4, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (float[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedTypeForPrimitiveArray4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                float[] fArr = new float[size];
                for (int i = 0; i < size; i++) {
                    fArr[i] = (float) readableArrayAsArray.getDouble(i);
                }
                return fArr;
            }
        });
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(boolean[].class);
        final ExpectedType expectedTypeForPrimitiveArray5 = companion.forPrimitiveArray(CppType.BOOLEAN);
        return MapsKt.mapOf(pair, pair2, pair3, pair4, TuplesKt.to(orCreateKotlinClass5, new DynamicAwareTypeConverters() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext appContext, boolean z) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (boolean[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            public ExpectedType getCppRequiredTypes() {
                return expectedTypeForPrimitiveArray5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                boolean[] zArr = new boolean[size];
                for (int i = 0; i < size; i++) {
                    zArr[i] = readableArrayAsArray.getBoolean(i);
                }
                return zArr;
            }
        }));
    }
}
