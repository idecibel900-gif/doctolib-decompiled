package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"MILLIS_IN_SECOND", "", "SECONDS_IN_DAY", "SECONDS_IN_HOUR", "SECONDS_IN_MINUTE", "rememberCountdownState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownState;", "targetDate", "Ljava/util/Date;", "(Ljava/util/Date;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownState;", "revenuecatui_defaultsBc8Release", "countdownTime", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "isCountingEnabled", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class CountdownComponentStateKt {
    private static final int MILLIS_IN_SECOND = 1000;
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static final CountdownState rememberCountdownState(Date targetDate, Composer composer, int i) {
        Date date;
        Intrinsics.checkNotNullParameter(targetDate, "targetDate");
        composer.startReplaceGroup(280932820);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(280932820, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.countdown.rememberCountdownState (CountdownComponentState.kt:57)");
        }
        composer.startReplaceGroup(-392681169);
        boolean zChanged = composer.changed(targetDate);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = Long.valueOf(targetDate.getTime() - new Date().getTime());
            composer.updateRememberedValue(objRememberedValue);
        }
        long jLongValue = ((Number) objRememberedValue).longValue();
        composer.endReplaceGroup();
        composer.startReplaceGroup(-392678500);
        boolean zChanged2 = composer.changed(targetDate);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(jLongValue <= 0 ? CountdownTime.INSTANCE.getZERO() : CountdownTime.INSTANCE.fromInterval(jLongValue), null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-392672454);
        Object objRememberedValue3 = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        MutableState mutableState2 = (MutableState) objRememberedValue3;
        composer.endReplaceGroup();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        composer.startReplaceGroup(-392667923);
        boolean zChangedInstance = composer.changedInstance(lifecycleOwner) | composer.changedInstance(targetDate) | composer.changed(mutableState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
            date = targetDate;
            Object countdownComponentStateKt$rememberCountdownState$1$1 = new CountdownComponentStateKt$rememberCountdownState$1$1(date, lifecycleOwner, mutableState2, mutableState, null);
            composer.updateRememberedValue(countdownComponentStateKt$rememberCountdownState$1$1);
            objRememberedValue4 = countdownComponentStateKt$rememberCountdownState$1$1;
        } else {
            date = targetDate;
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(date, (Function2) objRememberedValue4, composer, i & 14);
        CountdownState countdownState = new CountdownState(rememberCountdownState$lambda$2(mutableState), Intrinsics.areEqual(rememberCountdownState$lambda$2(mutableState), CountdownTime.INSTANCE.getZERO()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return countdownState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberCountdownState$lambda$6(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final CountdownTime rememberCountdownState$lambda$2(MutableState mutableState) {
        return (CountdownTime) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberCountdownState$lambda$5(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }
}
