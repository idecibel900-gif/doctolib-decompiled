package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface WindowMetricsCalculator {
    public static final Companion Companion = Companion.$$INSTANCE;

    WindowMetrics computeCurrentWindowMetrics(Activity activity);

    WindowMetrics computeCurrentWindowMetrics(Context context);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static Function1 decorator = new Function1() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$decorator$1
            @Override // kotlin.jvm.functions.Function1
            public final WindowMetricsCalculator invoke(WindowMetricsCalculator it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        };

        private Companion() {
        }

        public final WindowMetricsCalculator getOrCreate() {
            return (WindowMetricsCalculator) decorator.invoke(WindowMetricsCalculatorCompat.INSTANCE);
        }
    }
}
