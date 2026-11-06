package com.revenuecat.purchases.ui.revenuecatui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.revenuecat.purchases.ui.revenuecatui.PaywallMode, still in use, count: 1, list:
  (r0v0 com.revenuecat.purchases.ui.revenuecatui.PaywallMode) from 0x002c: SPUT (r0v0 com.revenuecat.purchases.ui.revenuecatui.PaywallMode) (LINE:10) com.revenuecat.purchases.ui.revenuecatui.PaywallMode.default com.revenuecat.purchases.ui.revenuecatui.PaywallMode
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "", "(Ljava/lang/String;I)V", "FULL_SCREEN", "FOOTER", "FOOTER_CONDENSED", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallMode {
    FULL_SCREEN,
    FOOTER,
    FOOTER_CONDENSED;


    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final PaywallMode f54default = new PaywallMode();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static PaywallMode valueOf(String str) {
        return (PaywallMode) Enum.valueOf(PaywallMode.class, str);
    }

    public static PaywallMode[] values() {
        return (PaywallMode[]) $VALUES.clone();
    }

    private PaywallMode() {
        super(str, i);
    }

    static {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode$Companion;", "", "()V", "default", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "footerMode", "condensed", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaywallMode getDefault() {
            return PaywallMode.f54default;
        }

        public final PaywallMode footerMode(boolean condensed) {
            return condensed ? PaywallMode.FOOTER_CONDENSED : PaywallMode.FOOTER;
        }
    }
}
