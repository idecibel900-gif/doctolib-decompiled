package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0003R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "", "<init>", "()V", "", "backgroundBlur", "Lkotlin/Function0;", "", "content", "onDismiss", "show", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "hide", "<set-?>", "backgroundBlur$delegate", "Landroidx/compose/runtime/MutableState;", "getBackgroundBlur", "()Z", "setBackgroundBlur", "(Z)V", "content$delegate", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "visible$delegate", "getVisible", "setVisible", "visible", "Lkotlin/jvm/functions/Function0;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleSheetState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: backgroundBlur$delegate, reason: from kotlin metadata */
    private final MutableState backgroundBlur;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private Function0 onDismiss;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final MutableState visible;

    public SimpleSheetState() {
        Boolean bool = Boolean.FALSE;
        this.backgroundBlur = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE.m4230getLambda1$revenuecatui_defaultsBc8Release(), null, 2, null);
        this.visible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }

    private final void setBackgroundBlur(boolean z) {
        this.backgroundBlur.setValue(Boolean.valueOf(z));
    }

    public final /* synthetic */ boolean getBackgroundBlur() {
        return ((Boolean) this.backgroundBlur.getValue()).booleanValue();
    }

    private final void setContent(Function2 function2) {
        this.content.setValue(function2);
    }

    public final /* synthetic */ Function2 getContent() {
        return (Function2) this.content.getValue();
    }

    private final void setVisible(boolean z) {
        this.visible.setValue(Boolean.valueOf(z));
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public static /* synthetic */ void show$default(SimpleSheetState simpleSheetState, boolean z, Function2 function2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        simpleSheetState.show(z, function2, function0);
    }

    public final void show(boolean backgroundBlur, Function2 content, Function0 onDismiss) {
        Intrinsics.checkNotNullParameter(content, "content");
        setBackgroundBlur(backgroundBlur);
        setContent(content);
        this.onDismiss = onDismiss;
        setVisible(true);
    }

    public final void hide() {
        setBackgroundBlur(false);
        setVisible(false);
        Function0 function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismiss = null;
    }
}
