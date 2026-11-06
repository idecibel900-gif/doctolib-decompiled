package io.didomi.ssl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001am\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0004\u0010\u0012\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\u0014\u001a\u00020\u0003*\u00020\u0000¨\u0006\u0015"}, d2 = {"Landroid/view/View;", "Lio/didomi/sdk/a;", "accessibility", "", "a", "b", "", Constants.ScionAnalytics.PARAM_LABEL, "actionDescription", "stateDescription", "", "announceState", "announceStateLabel", "", "actionId", "collectionItemPosition", "Lio/didomi/sdk/b;", "customClassName", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/Integer;Lio/didomi/sdk/b;)V", com.amazon.a.a.o.b.c, "c", "android_release"}, k = 2, mv = {1, 8, 0})
public final class mi {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"io/didomi/sdk/mi$a", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", DiagnosticsTracker.HOST_KEY, "Landroid/view/accessibility/AccessibilityEvent;", "event", "", "onInitializeAccessibilityEvent", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "onInitializeAccessibilityNodeInfo", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends AccessibilityDelegateCompat {
        final /* synthetic */ String a;
        final /* synthetic */ View b;
        final /* synthetic */ io.didomi.ssl.b c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ Integer f;

        a(String str, View view, io.didomi.ssl.b bVar, String str2, int i, Integer num) {
            this.a = str;
            this.b = view;
            this.c = bVar;
            this.d = str2;
            this.e = i;
            this.f = num;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(event, "event");
            super.onInitializeAccessibilityEvent(host, event);
            String str = this.a;
            if (str == null || StringsKt.isBlank(str) || (this.b instanceof ImageButton)) {
                return;
            }
            List<CharSequence> text = event.getText();
            String str2 = this.a;
            text.clear();
            text.add(str2);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            io.didomi.ssl.b bVar = this.c;
            String str = this.d;
            int i = this.e;
            Integer num = this.f;
            if (bVar != null) {
                info.setClassName(bVar.getValue());
            }
            if (str != null && !StringsKt.isBlank(str)) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, str));
            }
            if (num != null) {
                info.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(num.intValue(), 1, 0, 1, false));
            } else {
                info.setCollectionItemInfo(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/mi$b", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", DiagnosticsTracker.HOST_KEY, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCollectionItemInfo(null);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"io/didomi/sdk/mi$c", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", DiagnosticsTracker.HOST_KEY, "", "action", "Landroid/os/Bundle;", "args", "", "performAccessibilityAction", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            Intrinsics.checkNotNullParameter(host, "host");
            if (action == 64) {
                host.sendAccessibilityEvent(32768);
            }
            return super.performAccessibilityAction(host, action, args);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/mi$d", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", DiagnosticsTracker.HOST_KEY, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            info.setClickable(false);
            info.setLongClickable(false);
        }
    }

    public static final void a(View view, Accessibility accessibility) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        a(view, accessibility.getLabel(), accessibility.getActionDescription(), accessibility.getStateDescription(), accessibility.getAnnounceState(), null, accessibility.getActionId(), accessibility.getCollectionItemPosition(), null, 144, null);
    }

    public static final void b(final View view, final Accessibility accessibility) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        if (Build.VERSION.SDK_INT < 30) {
            a(view, Accessibility.a(accessibility, null, null, null, true, 0, null, 55, null));
        } else {
            a(view, Accessibility.a(accessibility, null, null, null, false, 0, null, 55, null));
            view.post(new Runnable() { // from class: io.didomi.sdk.mi$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    mi.c(view, accessibility);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_updateState, Accessibility accessibility) {
        Intrinsics.checkNotNullParameter(this_updateState, "$this_updateState");
        Intrinsics.checkNotNullParameter(accessibility, "$accessibility");
        a(this_updateState, null, accessibility.getStateDescription());
    }

    public static final void c(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewCompat.setAccessibilityDelegate(view, new d());
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewCompat.setAccessibilityDelegate(view, new c());
    }

    public static /* synthetic */ void a(View view, String str, String str2, String str3, boolean z, String str4, int i, Integer num, io.didomi.ssl.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        if ((i2 & 32) != 0) {
            i = 16;
        }
        if ((i2 & 64) != 0) {
            num = null;
        }
        if ((i2 & 128) != 0) {
            bVar = null;
        }
        a(view, str, str2, str3, z, str4, i, num, bVar);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0047  */
    public static final void a(final View view, final String str, String str2, final String str3, boolean z, final String str4, int i, Integer num, io.didomi.ssl.b bVar) {
        String str5;
        io.didomi.ssl.b bVar2;
        String str6;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if ((str == null || StringsKt.isBlank(str)) && (str2 == null || StringsKt.isBlank(str2))) {
            return;
        }
        boolean z2 = str3 == null || StringsKt.isBlank(str3);
        if (Build.VERSION.SDK_INT >= 30) {
            if (str3 != null) {
                view.setStateDescription(str3);
            }
            if (str != null) {
                view.setContentDescription(str);
            }
            str6 = str;
            bVar2 = bVar;
        } else {
            if (!(view instanceof ImageButton) && z2 && (str2 == null || StringsKt.isBlank(str2))) {
                bVar2 = bVar;
                str5 = null;
            } else {
                if (str == null || str3 == null) {
                    str5 = str == null ? str3 : str;
                } else {
                    str5 = str + ", " + str3;
                }
                if (str5 == null) {
                    bVar2 = bVar;
                    str5 = null;
                } else if (view instanceof DidomiToggle) {
                    bVar2 = bVar;
                } else {
                    bVar2 = bVar;
                    if (bVar2 != io.didomi.ssl.b.c) {
                        view.setContentDescription(str5);
                    }
                }
            }
            str6 = str5;
        }
        ViewCompat.setAccessibilityDelegate(view, new a(str6, view, bVar2, str2, i, num));
        if (!z || z2) {
            return;
        }
        view.post(new Runnable() { // from class: io.didomi.sdk.mi$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                mi.a(view, str, str4, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View this_applyAccessibilityCustom, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(this_applyAccessibilityCustom, "$this_applyAccessibilityCustom");
        if (str == null) {
            str = str2;
        }
        a(this_applyAccessibilityCustom, str, str3);
    }

    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewCompat.setAccessibilityDelegate(view, new b());
    }

    public static final void a(final View view, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            str = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final AccessibilityManager accessibilityManagerA = w0.a(context);
        if (accessibilityManagerA.isEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.didomi.sdk.mi$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    mi.a(view, accessibilityManagerA, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View this_forceAnnounceForAccessibility, AccessibilityManager manager, String str, String str2) {
        AccessibilityEvent accessibilityEventObtain;
        Intrinsics.checkNotNullParameter(this_forceAnnounceForAccessibility, "$this_forceAnnounceForAccessibility");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        if (Build.VERSION.SDK_INT >= 30) {
            accessibilityEventObtain = mi$$ExternalSyntheticApiModelOutline0.m();
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain();
        }
        accessibilityEventObtain.setEventType(Http2.INITIAL_MAX_FRAME_SIZE);
        accessibilityEventObtain.setClassName(this_forceAnnounceForAccessibility.getClass().getName());
        accessibilityEventObtain.setPackageName(this_forceAnnounceForAccessibility.getContext().getPackageName());
        List<CharSequence> text = accessibilityEventObtain.getText();
        if (str != null) {
            text.add(str);
        }
        if (str2 != null) {
            text.add(str2);
        }
        manager.sendAccessibilityEvent(accessibilityEventObtain);
    }
}
