package expo.modules.kotlin;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DynamicExtenstionsKt {

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
                iArr[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Object unwrap(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[dynamic.getType().ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(dynamic.asBoolean());
            case 3:
                return Double.valueOf(dynamic.asDouble());
            case 4:
                return dynamic.asString();
            case 5:
                return dynamic.asArray();
            case 6:
                return dynamic.asMap();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
