package expo.modules.kotlin;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReadableTypeExtensionsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final KClass toKClass(ReadableType readableType) {
        Class cls;
        Intrinsics.checkNotNullParameter(readableType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[readableType.ordinal()]) {
            case 1:
                cls = Object.class;
                break;
            case 2:
                cls = Boolean.TYPE;
                break;
            case 3:
                cls = Number.class;
                break;
            case 4:
                cls = String.class;
                break;
            case 5:
                cls = ReadableMap.class;
                break;
            case 6:
                cls = ReadableArray.class;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }
}
