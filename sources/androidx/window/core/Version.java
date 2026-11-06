package androidx.window.core;

import com.amazon.a.a.o.c.a.b;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class Version implements Comparable {
    private static final Version CURRENT;
    public static final Companion Companion = new Companion(null);
    private static final Version UNKNOWN = new Version(0, 0, 0, "");
    private static final Version VERSION_0_1 = new Version(0, 1, 0, "");
    private static final Version VERSION_1_0;
    private final Lazy bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    public /* synthetic */ Version(int i, int i2, int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str);
    }

    private Version(int i, int i2, int i3, String str) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.description = str;
        this.bigInteger$delegate = LazyKt.lazy(new Function0() { // from class: androidx.window.core.Version$bigInteger$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BigInteger invoke() {
                return BigInteger.valueOf(this.this$0.getMajor()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getMinor())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getPatch()));
            }
        });
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public String toString() {
        String str;
        if (!StringsKt.isBlank(this.description)) {
            str = '-' + this.description;
        } else {
            str = "";
        }
        return this.major + b.a + this.minor + b.a + this.patch + str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBigInteger().compareTo(other.getBigInteger());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        public final Version parse(String str) {
            String strGroup;
            if (str != null && !StringsKt.isBlank(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i2 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i3 = Integer.parseInt(strGroup3);
                            String description = matcher.group(4) != null ? matcher.group(4) : "";
                            Intrinsics.checkNotNullExpressionValue(description, "description");
                            return new Version(i, i2, i3, description, null);
                        }
                    }
                }
            }
            return null;
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }
}
