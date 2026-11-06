package expo.modules.kotlin.exception;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0017\u0018\u0000 \u00102\u00060\u0001j\u0002`\u0002:\u0001\u0010B\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB%\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\nB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/exception/CodedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", ResponseTypeValues.CODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "()V", "providedCode", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CodedException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String providedCode;

    public /* synthetic */ CodedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public CodedException(String str, Throwable th) {
        super(str, th);
    }

    public final String getCode() {
        String str = this.providedCode;
        return str == null ? INSTANCE.inferCode(getClass()) : str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CodedException(String code, String str, Throwable th) {
        this(str, th);
        Intrinsics.checkNotNullParameter(code, "code");
        this.providedCode = code;
    }

    public CodedException() {
        this(null, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String inferCode(Class clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            String strReplace = new Regex("(.)([A-Z])").replace(new Regex("(Exception)$").replace(clazz.getSimpleName(), ""), "$1_$2");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String upperCase = strReplace.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return "ERR_" + upperCase;
        }
    }
}
