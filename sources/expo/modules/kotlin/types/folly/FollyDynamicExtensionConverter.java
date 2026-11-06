package expo.modules.kotlin.types.folly;

import android.util.ArrayMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/types/folly/FollyDynamicExtensionConverter;", "", "<init>", "()V", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FollyDynamicExtensionConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayMap instanceMap = new ArrayMap();
    private static int nextId;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized String put(Object any) {
            int i;
            Intrinsics.checkNotNullParameter(any, "any");
            i = FollyDynamicExtensionConverter.nextId;
            FollyDynamicExtensionConverter.nextId = i + 1;
            FollyDynamicExtensionConverter.instanceMap.put(Integer.valueOf(i), any);
            return "__expo_dynamic_extension__#" + i;
        }

        public final synchronized Object get(String payload) {
            String strSubstring;
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!StringsKt.startsWith$default(payload, "__expo_dynamic_extension__#", false, 2, (Object) null)) {
                throw new InvalidDynamicExtensionFormatException();
            }
            strSubstring = payload.substring(27);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return FollyDynamicExtensionConverter.instanceMap.remove(Integer.valueOf(Integer.parseInt(strSubstring)));
        }
    }

    public static final synchronized String put(Object obj) {
        return INSTANCE.put(obj);
    }

    public static final synchronized Object get(String str) {
        return INSTANCE.get(str);
    }
}
