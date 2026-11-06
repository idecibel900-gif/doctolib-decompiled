package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/DescriptionInputState;", "", b.c, "", "onDescriptionChange", "Lkotlin/Function1;", "", "enabled", "", "showDone", "onSubmit", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;)V", "getDescription", "()Ljava/lang/String;", "getEnabled", "()Z", "getOnDescriptionChange", "()Lkotlin/jvm/functions/Function1;", "getOnSubmit", "()Lkotlin/jvm/functions/Function0;", "getShowDone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DescriptionInputState {
    private final String description;
    private final boolean enabled;
    private final Function1 onDescriptionChange;
    private final Function0 onSubmit;
    private final boolean showDone;

    public static /* synthetic */ DescriptionInputState copy$default(DescriptionInputState descriptionInputState, String str, Function1 function1, boolean z, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = descriptionInputState.description;
        }
        if ((i & 2) != 0) {
            function1 = descriptionInputState.onDescriptionChange;
        }
        if ((i & 4) != 0) {
            z = descriptionInputState.enabled;
        }
        if ((i & 8) != 0) {
            z2 = descriptionInputState.showDone;
        }
        if ((i & 16) != 0) {
            function0 = descriptionInputState.onSubmit;
        }
        Function0 function2 = function0;
        boolean z3 = z;
        return descriptionInputState.copy(str, function1, z3, z2, function2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Function1 getOnDescriptionChange() {
        return this.onDescriptionChange;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowDone() {
        return this.showDone;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Function0 getOnSubmit() {
        return this.onSubmit;
    }

    public final DescriptionInputState copy(String description, Function1 onDescriptionChange, boolean enabled, boolean showDone, Function0 onSubmit) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onDescriptionChange, "onDescriptionChange");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        return new DescriptionInputState(description, onDescriptionChange, enabled, showDone, onSubmit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DescriptionInputState)) {
            return false;
        }
        DescriptionInputState descriptionInputState = (DescriptionInputState) other;
        return Intrinsics.areEqual(this.description, descriptionInputState.description) && Intrinsics.areEqual(this.onDescriptionChange, descriptionInputState.onDescriptionChange) && this.enabled == descriptionInputState.enabled && this.showDone == descriptionInputState.showDone && Intrinsics.areEqual(this.onSubmit, descriptionInputState.onSubmit);
    }

    public int hashCode() {
        return (((((((this.description.hashCode() * 31) + this.onDescriptionChange.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.showDone)) * 31) + this.onSubmit.hashCode();
    }

    public String toString() {
        return "DescriptionInputState(description=" + this.description + ", onDescriptionChange=" + this.onDescriptionChange + ", enabled=" + this.enabled + ", showDone=" + this.showDone + ", onSubmit=" + this.onSubmit + ')';
    }

    public DescriptionInputState(String description, Function1 onDescriptionChange, boolean z, boolean z2, Function0 onSubmit) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onDescriptionChange, "onDescriptionChange");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        this.description = description;
        this.onDescriptionChange = onDescriptionChange;
        this.enabled = z;
        this.showDone = z2;
        this.onSubmit = onSubmit;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Function1 getOnDescriptionChange() {
        return this.onDescriptionChange;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getShowDone() {
        return this.showDone;
    }

    public /* synthetic */ DescriptionInputState(String str, Function1 function1, boolean z, boolean z2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1, z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputState.1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4394invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4394invoke();
                return Unit.INSTANCE;
            }
        } : function0);
    }

    public final Function0 getOnSubmit() {
        return this.onSubmit;
    }
}
