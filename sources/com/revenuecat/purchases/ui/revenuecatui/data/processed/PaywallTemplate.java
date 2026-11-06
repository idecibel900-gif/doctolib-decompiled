package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TEMPLATE_1' uses external variables
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "", DiagnosticsEntry.ID_KEY, "", "configurationType", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;)V", "getConfigurationType", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;", "getId", "()Ljava/lang/String;", "TEMPLATE_1", "TEMPLATE_2", "TEMPLATE_3", "TEMPLATE_4", "TEMPLATE_5", "TEMPLATE_7", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallTemplate {
    private static final /* synthetic */ PaywallTemplate[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PaywallTemplate TEMPLATE_1;
    public static final PaywallTemplate TEMPLATE_2;
    public static final PaywallTemplate TEMPLATE_3;
    public static final PaywallTemplate TEMPLATE_4;
    public static final PaywallTemplate TEMPLATE_5;
    public static final PaywallTemplate TEMPLATE_7;
    private final PackageConfigurationType configurationType;
    private final String id;

    private static final /* synthetic */ PaywallTemplate[] $values() {
        return new PaywallTemplate[]{TEMPLATE_1, TEMPLATE_2, TEMPLATE_3, TEMPLATE_4, TEMPLATE_5, TEMPLATE_7};
    }

    public static PaywallTemplate valueOf(String str) {
        return (PaywallTemplate) Enum.valueOf(PaywallTemplate.class, str);
    }

    public static PaywallTemplate[] values() {
        return (PaywallTemplate[]) $VALUES.clone();
    }

    private PaywallTemplate(String str, int i, String str2, PackageConfigurationType packageConfigurationType) {
        super(str, i);
        this.id = str2;
        this.configurationType = packageConfigurationType;
    }

    public final PackageConfigurationType getConfigurationType() {
        return this.configurationType;
    }

    public final String getId() {
        return this.id;
    }

    static {
        PackageConfigurationType packageConfigurationType = PackageConfigurationType.SINGLE;
        TEMPLATE_1 = new PaywallTemplate("TEMPLATE_1", 0, "1", packageConfigurationType);
        PackageConfigurationType packageConfigurationType2 = PackageConfigurationType.MULTIPLE;
        TEMPLATE_2 = new PaywallTemplate("TEMPLATE_2", 1, "2", packageConfigurationType2);
        TEMPLATE_3 = new PaywallTemplate("TEMPLATE_3", 2, "3", packageConfigurationType);
        TEMPLATE_4 = new PaywallTemplate("TEMPLATE_4", 3, "4", packageConfigurationType2);
        TEMPLATE_5 = new PaywallTemplate("TEMPLATE_5", 4, "5", packageConfigurationType2);
        TEMPLATE_7 = new PaywallTemplate("TEMPLATE_7", 5, "7", PackageConfigurationType.MULTITIER);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate$Companion;", "", "()V", "fromId", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", DiagnosticsEntry.ID_KEY, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaywallTemplate fromId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            for (PaywallTemplate paywallTemplate : PaywallTemplate.values()) {
                if (Intrinsics.areEqual(paywallTemplate.getId(), id)) {
                    return paywallTemplate;
                }
            }
            return null;
        }
    }
}
