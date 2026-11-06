package expo.modules.kotlin.jni;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.ValueOrUndefined;
import java.util.List;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class CppType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CppType[] $VALUES;
    public static final CppType ANY;
    public static final CppType ARRAY;
    public static final CppType BOOLEAN;
    public static final CppType FLOAT;
    public static final CppType INT;
    public static final CppType JS_ARRAY_BUFFER;
    public static final CppType JS_FUNCTION;
    public static final CppType JS_OBJECT;
    public static final CppType JS_VALUE;
    public static final CppType LIST;
    public static final CppType LONG;
    public static final CppType MAP;
    public static final CppType NATIVE_ARRAY_BUFFER;
    public static final CppType NULLABLE;
    public static final CppType PRIMITIVE_ARRAY;
    public static final CppType READABLE_ARRAY;
    public static final CppType READABLE_MAP;
    public static final CppType SERIALIZABLE;
    public static final CppType SHARED_OBJECT_ID;
    public static final CppType STRING;
    public static final CppType TYPED_ARRAY;
    public static final CppType UINT8_TYPED_ARRAY;
    public static final CppType VALUE_OR_UNDEFINED;
    public static final CppType VIEW_TAG;
    private final KClass clazz;
    private final int value;
    public static final CppType NONE = new CppType("NONE", 0, Reflection.getOrCreateKotlinClass(Void.class), 0);
    public static final CppType DOUBLE = new CppType("DOUBLE", 1, Reflection.getOrCreateKotlinClass(Double.TYPE), 0, 2, null);

    private static final /* synthetic */ CppType[] $values() {
        return new CppType[]{NONE, DOUBLE, INT, LONG, FLOAT, BOOLEAN, STRING, JS_OBJECT, JS_VALUE, READABLE_ARRAY, READABLE_MAP, UINT8_TYPED_ARRAY, TYPED_ARRAY, PRIMITIVE_ARRAY, ARRAY, LIST, MAP, VIEW_TAG, SHARED_OBJECT_ID, JS_FUNCTION, ANY, NULLABLE, VALUE_OR_UNDEFINED, JS_ARRAY_BUFFER, NATIVE_ARRAY_BUFFER, SERIALIZABLE};
    }

    private CppType(String str, int i, KClass kClass, int i2) {
        super(str, i);
        this.clazz = kClass;
        this.value = i2;
    }

    /* synthetic */ CppType(String str, int i, KClass kClass, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, kClass, (i3 & 2) != 0 ? CppTypeKt.nextValue() : i2);
    }

    public final KClass getClazz() {
        return this.clazz;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Class cls = Integer.TYPE;
        INT = new CppType("INT", 2, Reflection.getOrCreateKotlinClass(cls), 0, 2, null);
        LONG = new CppType("LONG", 3, Reflection.getOrCreateKotlinClass(Long.TYPE), 0, 2, null);
        FLOAT = new CppType("FLOAT", 4, Reflection.getOrCreateKotlinClass(Float.TYPE), 0, 2, null);
        DefaultConstructorMarker defaultConstructorMarker = null;
        BOOLEAN = new CppType("BOOLEAN", 5, Reflection.getOrCreateKotlinClass(Boolean.TYPE), 0, 2, defaultConstructorMarker);
        STRING = new CppType("STRING", 6, Reflection.getOrCreateKotlinClass(String.class), 0, 2, null);
        JS_OBJECT = new CppType("JS_OBJECT", 7, Reflection.getOrCreateKotlinClass(JavaScriptObject.class), 0, 2, null);
        JS_VALUE = new CppType("JS_VALUE", 8, Reflection.getOrCreateKotlinClass(JavaScriptValue.class), 0, 2, null);
        READABLE_ARRAY = new CppType("READABLE_ARRAY", 9, Reflection.getOrCreateKotlinClass(ReadableArray.class), 0, 2, null);
        READABLE_MAP = new CppType("READABLE_MAP", 10, Reflection.getOrCreateKotlinClass(ReadableMap.class), 0, 2, null);
        UINT8_TYPED_ARRAY = new CppType("UINT8_TYPED_ARRAY", 11, Reflection.getOrCreateKotlinClass(byte[].class), 0, 2, null);
        TYPED_ARRAY = new CppType("TYPED_ARRAY", 12, Reflection.getOrCreateKotlinClass(TypedArray.class), 0, 2, null);
        PRIMITIVE_ARRAY = new CppType("PRIMITIVE_ARRAY", 13, Reflection.getOrCreateKotlinClass(Object[].class), 0, 2, defaultConstructorMarker);
        ARRAY = new CppType("ARRAY", 14, Reflection.getOrCreateKotlinClass(Object[].class), 0, 2, null);
        LIST = new CppType("LIST", 15, Reflection.getOrCreateKotlinClass(List.class), 0, 2, null);
        MAP = new CppType("MAP", 16, Reflection.getOrCreateKotlinClass(Map.class), 0, 2, null);
        VIEW_TAG = new CppType("VIEW_TAG", 17, Reflection.getOrCreateKotlinClass(cls), 0, 2, null);
        SHARED_OBJECT_ID = new CppType("SHARED_OBJECT_ID", 18, Reflection.getOrCreateKotlinClass(cls), 0, 2, null);
        JS_FUNCTION = new CppType("JS_FUNCTION", 19, Reflection.getOrCreateKotlinClass(JavaScriptFunction.class), 0, 2, null);
        ANY = new CppType("ANY", 20, Reflection.getOrCreateKotlinClass(Object.class), 0, 2, null);
        NULLABLE = new CppType("NULLABLE", 21, Reflection.getOrCreateKotlinClass(Object.class), 0, 2, null);
        VALUE_OR_UNDEFINED = new CppType("VALUE_OR_UNDEFINED", 22, Reflection.getOrCreateKotlinClass(ValueOrUndefined.class), 0, 2, null);
        JS_ARRAY_BUFFER = new CppType("JS_ARRAY_BUFFER", 23, Reflection.getOrCreateKotlinClass(JavaScriptArrayBuffer.class), 0, 2, null);
        NATIVE_ARRAY_BUFFER = new CppType("NATIVE_ARRAY_BUFFER", 24, Reflection.getOrCreateKotlinClass(NativeArrayBuffer.class), 0, 2, null);
        SERIALIZABLE = new CppType("SERIALIZABLE", 25, Reflection.getOrCreateKotlinClass(Worklet.class), 0, 2, null);
        CppType[] cppTypeArr$values = $values();
        $VALUES = cppTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cppTypeArr$values);
    }

    public static CppType valueOf(String str) {
        return (CppType) Enum.valueOf(CppType.class, str);
    }

    public static CppType[] values() {
        return (CppType[]) $VALUES.clone();
    }
}
