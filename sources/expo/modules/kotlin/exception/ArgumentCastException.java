package expo.modules.kotlin.exception;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class ArgumentCastException extends DecoratedException {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgumentCastException(KType argDesiredType, int i, String providedType, CodedException cause) {
        super("The " + Companion.formatOrdinalNumber(i + 1) + " argument cannot be cast to type " + argDesiredType + " (received " + providedType + ")", cause);
        Intrinsics.checkNotNullParameter(argDesiredType, "argDesiredType");
        Intrinsics.checkNotNullParameter(providedType, "providedType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatOrdinalNumber(int i) {
            int i2 = i % 100;
            String str = "th";
            if (11 > i2 || i2 >= 14) {
                int i3 = i % 10;
                if (i3 == 1) {
                    str = "st";
                } else if (i3 == 2) {
                    str = "nd";
                } else if (i3 == 3) {
                    str = "rd";
                }
            }
            return i + str;
        }
    }
}
