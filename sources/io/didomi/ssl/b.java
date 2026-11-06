package io.didomi.ssl;

import android.widget.Button;
import android.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\r\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0005j\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/b;", "", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/CharSequence;)V", "c", "android_release"}, k = 1, mv = {1, 8, 0})
public final class b {
    public static final b b;
    public static final b c;
    private static final /* synthetic */ b[] d;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CharSequence value;

    static {
        String name = Button.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Button::class.java.name");
        b = new b("BUTTON", 0, name);
        String name2 = Switch.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "Switch::class.java.name");
        c = new b("SWITCH", 1, name2);
        d = a();
    }

    private b(String str, int i, CharSequence charSequence) {
        super(str, i);
        this.value = charSequence;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{b, c};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final CharSequence getValue() {
        return this.value;
    }
}
