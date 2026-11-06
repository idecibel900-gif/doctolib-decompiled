package com.revenuecat.purchases.common.diagnostics;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;", "", "context", "Landroid/content/Context;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "sharedPreferences", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lkotlin/Lazy;)V", "clearConsecutiveNumberOfErrors", "", "increaseConsecutiveNumberOfErrors", "", "resetDiagnosticsStatus", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsHelper {
    public static final String CONSECUTIVE_FAILURES_COUNT_KEY = "consecutive_failures_count";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final Lazy sharedPreferences;

    public DiagnosticsHelper(Context context, DiagnosticsFileHelper diagnosticsFileHelper, Lazy sharedPreferences) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.sharedPreferences = sharedPreferences;
    }

    public /* synthetic */ DiagnosticsHelper(final Context context, DiagnosticsFileHelper diagnosticsFileHelper, Lazy lazy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, diagnosticsFileHelper, (i & 4) != 0 ? LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsHelper.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return DiagnosticsHelper.INSTANCE.initializeSharedPreferences(context);
            }
        }) : lazy);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper$Companion;", "", "()V", "CONSECUTIVE_FAILURES_COUNT_KEY", "", "getCONSECUTIVE_FAILURES_COUNT_KEY$annotations", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCONSECUTIVE_FAILURES_COUNT_KEY$annotations() {
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com_revenuecat_purchases_" + context.getPackageName() + "_preferences_diagnostics", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }

    public final void resetDiagnosticsStatus() {
        clearConsecutiveNumberOfErrors();
        this.diagnosticsFileHelper.deleteFile();
    }

    public final void clearConsecutiveNumberOfErrors() {
        ((SharedPreferences) this.sharedPreferences.getValue()).edit().remove(CONSECUTIVE_FAILURES_COUNT_KEY).apply();
    }

    public final int increaseConsecutiveNumberOfErrors() {
        int i = ((SharedPreferences) this.sharedPreferences.getValue()).getInt(CONSECUTIVE_FAILURES_COUNT_KEY, 0) + 1;
        ((SharedPreferences) this.sharedPreferences.getValue()).edit().putInt(CONSECUTIVE_FAILURES_COUNT_KEY, i).apply();
        return i;
    }
}
