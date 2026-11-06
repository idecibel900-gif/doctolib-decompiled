package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidAccessibilityManager(Context context) {
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.platform.AccessibilityManager
    public long calculateRecommendedTimeoutMillis(long j, boolean z, boolean z2, boolean z3) {
        int i;
        int i2 = z;
        if (j < 2147483647L) {
            if (z2) {
                i = (z ? 1 : 0) | 2;
            }
            if (z3) {
                i2 = i;
                i2 = (i2 == true ? 1 : 0) | 4;
            }
            i2 = i;
            if (Build.VERSION.SDK_INT >= 29) {
                int recommendedTimeoutMillis = Api29Impl.INSTANCE.getRecommendedTimeoutMillis(this.accessibilityManager, (int) j, i2);
                if (recommendedTimeoutMillis == Integer.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                return recommendedTimeoutMillis;
            }
            if (z3 && this.accessibilityManager.isTouchExplorationEnabled()) {
                return Long.MAX_VALUE;
            }
        }
        return j;
    }
}
