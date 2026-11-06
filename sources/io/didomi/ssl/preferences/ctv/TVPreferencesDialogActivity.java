package io.didomi.ssl.preferences.ctv;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.R;
import io.didomi.ssl.a8;
import io.didomi.ssl.bd;
import io.didomi.ssl.dh;
import io.didomi.ssl.eh;
import io.didomi.ssl.f2;
import io.didomi.ssl.g8;
import io.didomi.ssl.ic;
import io.didomi.ssl.ni;
import io.didomi.ssl.o;
import io.didomi.ssl.oe;
import io.didomi.ssl.qe;
import io.didomi.ssl.sg;
import io.didomi.ssl.ug;
import io.didomi.ssl.v5;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001(\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0014R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010J\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0006\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010OR\u0016\u0010R\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010Q¨\u0006U"}, d2 = {"Lio/didomi/sdk/preferences/ctv/TVPreferencesDialogActivity;", "Lio/didomi/sdk/o;", "Lio/didomi/sdk/g8;", "Lio/didomi/sdk/bd;", "", "u", "l", "m", "E", "C", "B", "D", "A", "v", "w", "n", "o", "x", "y", "z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "c", "e", "f", "d", "onDestroy", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "saveClickListener", "agreeAllClickListener", "disagreeAllClickListener", "", "g", "Lkotlin/Lazy;", "r", "()Z", "shouldOpenVendors", "io/didomi/sdk/preferences/ctv/TVPreferencesDialogActivity$a", "h", "Lio/didomi/sdk/preferences/ctv/TVPreferencesDialogActivity$a;", "backPressedCallback", "Lio/didomi/sdk/qe;", "i", "Lio/didomi/sdk/qe;", "q", "()Lio/didomi/sdk/qe;", "setPurposesModel", "(Lio/didomi/sdk/qe;)V", "purposesModel", "Lio/didomi/sdk/ug;", "j", "Lio/didomi/sdk/ug;", "t", "()Lio/didomi/sdk/ug;", "setVendorsModel", "(Lio/didomi/sdk/ug;)V", "vendorsModel", "Lio/didomi/sdk/eh;", "k", "Lio/didomi/sdk/eh;", "s", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/a8;", "Lio/didomi/sdk/a8;", "p", "()Lio/didomi/sdk/a8;", "setNavigationManager", "(Lio/didomi/sdk/a8;)V", "navigationManager", "Lio/didomi/sdk/f2;", "Lio/didomi/sdk/f2;", "binding", "Lio/didomi/sdk/v5;", "Lio/didomi/sdk/v5;", "bindingPrimary", "Z", "lockFocus", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class TVPreferencesDialogActivity extends o implements g8, bd {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final View.OnClickListener saveClickListener = new View.OnClickListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda9
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TVPreferencesDialogActivity.c(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final View.OnClickListener agreeAllClickListener = new View.OnClickListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda10
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TVPreferencesDialogActivity.a(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final View.OnClickListener disagreeAllClickListener = new View.OnClickListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda11
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TVPreferencesDialogActivity.b(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy shouldOpenVendors = LazyKt.lazy(new b());

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final a backPressedCallback = new a();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public qe purposesModel;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public ug vendorsModel;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public a8 navigationManager;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private f2 binding;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private v5 bindingPrimary;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean lockFocus;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"io/didomi/sdk/preferences/ctv/TVPreferencesDialogActivity$a", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (TVPreferencesDialogActivity.this.getSupportFragmentManager().getFragments().size() == 1) {
                TVPreferencesDialogActivity.this.p().b();
            } else {
                TVPreferencesDialogActivity.this.getSupportFragmentManager().popBackStack();
                TVPreferencesDialogActivity.this.m();
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003b  */
        /* JADX WARN: Code duplicated, block: B:20:0x003d  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            Bundle extras;
            boolean z;
            Bundle extras2;
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 33) {
                Intent intent = TVPreferencesDialogActivity.this.getIntent();
                if (intent != null && (extras2 = intent.getExtras()) != null) {
                    obj = (ic) extras2.getSerializable("OPEN_SUBSCREEN", ic.class);
                }
                if (obj == ic.Vendors) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                Intent intent2 = TVPreferencesDialogActivity.this.getIntent();
                if (intent2 != null && (extras = intent2.getExtras()) != null) {
                    obj = extras.get("OPEN_SUBSCREEN");
                }
                if (obj == ic.Vendors) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    private final void A() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button updateAgreeButton$lambda$22 = v5Var.b;
        Intrinsics.checkNotNullExpressionValue(updateAgreeButton$lambda$22, "updateAgreeButton$lambda$22");
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(updateAgreeButton$lambda$22, i, 0, i, 0, 10, null);
        updateAgreeButton$lambda$22.setOnClickListener(this.agreeAllClickListener);
        updateAgreeButton$lambda$22.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return TVPreferencesDialogActivity.a(view, i2, keyEvent);
            }
        });
        updateAgreeButton$lambda$22.setText(q().D());
    }

    private final void B() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button updateDisagreeButton$lambda$18 = v5Var.c;
        Intrinsics.checkNotNullExpressionValue(updateDisagreeButton$lambda$18, "updateDisagreeButton$lambda$18");
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(updateDisagreeButton$lambda$18, i, 0, i, 0, 10, null);
        updateDisagreeButton$lambda$18.setOnClickListener(this.disagreeAllClickListener);
        updateDisagreeButton$lambda$18.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return TVPreferencesDialogActivity.b(view, i2, keyEvent);
            }
        });
        updateDisagreeButton$lambda$18.setText(q().R());
    }

    private final void C() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button updatePurposeTab$lambda$16 = v5Var.e;
        Intrinsics.checkNotNullExpressionValue(updatePurposeTab$lambda$16, "updatePurposeTab$lambda$16");
        ni.a(updatePurposeTab$lambda$16, R.dimen.didomi_tv_tab_padding_start, 0, R.dimen.didomi_tv_tab_padding_end, 0, 10, null);
        updatePurposeTab$lambda$16.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TVPreferencesDialogActivity.a(this.f$0, view, z);
            }
        });
        updatePurposeTab$lambda$16.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return TVPreferencesDialogActivity.a(this.f$0, view, i, keyEvent);
            }
        });
        updatePurposeTab$lambda$16.setText(q().G1());
    }

    private final void D() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button updateSaveButton$lambda$20 = v5Var.d;
        Intrinsics.checkNotNullExpressionValue(updateSaveButton$lambda$20, "updateSaveButton$lambda$20");
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(updateSaveButton$lambda$20, i, 0, i, 0, 10, null);
        updateSaveButton$lambda$20.setOnClickListener(this.saveClickListener);
        updateSaveButton$lambda$20.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return TVPreferencesDialogActivity.c(view, i2, keyEvent);
            }
        });
        updateSaveButton$lambda$20.setText(q().p0());
    }

    private final void E() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button updateVendorTab$lambda$13 = v5Var.f;
        Intrinsics.checkNotNullExpressionValue(updateVendorTab$lambda$13, "updateVendorTab$lambda$13");
        ni.a(updateVendorTab$lambda$13, R.dimen.didomi_tv_tab_padding_start, 0, R.dimen.didomi_tv_tab_padding_end, 0, 10, null);
        updateVendorTab$lambda$13.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TVPreferencesDialogActivity.b(this.f$0, view, z);
            }
        });
        updateVendorTab$lambda$13.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return TVPreferencesDialogActivity.b(this.f$0, view, i, keyEvent);
            }
        });
        updateVendorTab$lambda$13.setText(t().S0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, int i, KeyEvent keyEvent) {
        return i == 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(View view, int i, KeyEvent keyEvent) {
        return i == 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(View view, int i, KeyEvent keyEvent) {
        return i == 22;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        List fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt.lastOrNull(fragments);
        if (fragment == 0) {
            return;
        }
        if (fragment instanceof dh) {
            ((dh) fragment).a();
            return;
        }
        View view = fragment.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.setDescendantFocusability(131072);
        viewGroup.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (getSupportFragmentManager().getFragments().isEmpty()) {
            finish();
        }
    }

    private final void n() {
        this.lockFocus = true;
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        v5Var.e.setSelected(true);
        v5 v5Var2 = this.bindingPrimary;
        if (v5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var2 = null;
        }
        Button button = v5Var2.f;
        button.setEnabled(false);
        button.setSelected(false);
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.PURPOSES");
        oe oeVar = fragmentFindFragmentByTag instanceof oe ? (oe) fragmentFindFragmentByTag : null;
        if (oeVar != null) {
            oeVar.a();
        }
    }

    private final void o() {
        this.lockFocus = true;
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button button = v5Var.e;
        button.setEnabled(false);
        button.setSelected(false);
        v5 v5Var2 = this.bindingPrimary;
        if (v5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var2 = null;
        }
        v5Var2.f.setSelected(true);
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.VENDORS");
        sg sgVar = fragmentFindFragmentByTag instanceof sg ? (sg) fragmentFindFragmentByTag : null;
        if (sgVar != null) {
            sgVar.a();
        }
    }

    private final boolean r() {
        return ((Boolean) this.shouldOpenVendors.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        int i;
        int size = getSupportFragmentManager().getFragments().size();
        boolean z = size > 1;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.include_ctv_preferences_menu);
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.clearFocus();
            g();
            i = 393216;
        } else {
            h();
            i = 131072;
        }
        viewGroup.setDescendantFocusability(i);
        if (size == 1) {
            l();
        } else if (z) {
            viewGroup.post(new Runnable() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    TVPreferencesDialogActivity.b(this.f$0);
                }
            });
        }
    }

    private final void v() {
        q().Y1();
    }

    private final void w() {
        t().T0();
    }

    private final void x() {
        z();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.PURPOSES");
        if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isVisible()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ctv_preferences_primary, new oe(), "io.didomi.dialog.PURPOSES").commit();
        }
    }

    private final void y() {
        z();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.VENDORS");
        if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isVisible()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ctv_preferences_primary, new sg(), "io.didomi.dialog.VENDORS").commit();
        }
    }

    private final void z() {
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        v5Var.e.setSelected(false);
        v5Var.f.setSelected(false);
    }

    @Override // io.didomi.ssl.bd
    public void d() {
        this.lockFocus = false;
        v5 v5Var = this.bindingPrimary;
        v5 v5Var2 = null;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button button = v5Var.f;
        button.setEnabled(true);
        button.requestFocus();
        v5 v5Var3 = this.bindingPrimary;
        if (v5Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
        } else {
            v5Var2 = v5Var3;
        }
        v5Var2.e.setEnabled(true);
    }

    @Override // io.didomi.ssl.bd
    public void e() {
        finish();
    }

    @Override // io.didomi.ssl.g8
    public void f() {
        this.lockFocus = false;
        v5 v5Var = this.bindingPrimary;
        v5 v5Var2 = null;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        Button button = v5Var.e;
        button.setEnabled(true);
        button.requestFocus();
        v5 v5Var3 = this.bindingPrimary;
        if (v5Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
        } else {
            v5Var2 = v5Var3;
        }
        v5Var2.f.setEnabled(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onCreate(savedInstanceState);
        f2 f2VarA = f2.a(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(f2VarA, "inflate(layoutInflater)");
        this.binding = f2VarA;
        f2 f2Var = null;
        if (f2VarA == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            f2VarA = null;
        }
        v5 v5VarA = v5.a(f2VarA.getRoot());
        Intrinsics.checkNotNullExpressionValue(v5VarA, "bind(binding.root)");
        this.bindingPrimary = v5VarA;
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        f2 f2Var2 = this.binding;
        if (f2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            f2Var2 = null;
        }
        setContentView(f2Var2.getRoot());
        f2 f2Var3 = this.binding;
        if (f2Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            f2Var = f2Var3;
        }
        View view = f2Var.d;
        Intrinsics.checkNotNullExpressionValue(view, "binding.viewCtvPreferencesBackground");
        a(view);
        getOnBackPressedDispatcher().addCallback(this, this.backPressedCallback);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: io.didomi.sdk.preferences.ctv.TVPreferencesDialogActivity$$ExternalSyntheticLambda6
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                this.f$0.u();
            }
        });
        qe qeVarQ = q();
        qeVarQ.u1();
        qeVarQ.g1();
        qeVarQ.V0();
        qeVarQ.O0();
        C();
        E();
        A();
        D();
        B();
        if (r()) {
            d();
        } else {
            f();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        v5 v5Var = this.bindingPrimary;
        if (v5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
            v5Var = null;
        }
        v5Var.e.setOnFocusChangeListener(null);
        v5Var.f.setOnFocusChangeListener(null);
        s().h();
        this.lockFocus = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
    }

    public final a8 p() {
        a8 a8Var = this.navigationManager;
        if (a8Var != null) {
            return a8Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigationManager");
        return null;
    }

    public final qe q() {
        qe qeVar = this.purposesModel;
        if (qeVar != null) {
            return qeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purposesModel");
        return null;
    }

    public final eh s() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
        return null;
    }

    public final ug t() {
        ug ugVar = this.vendorsModel;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vendorsModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TVPreferencesDialogActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TVPreferencesDialogActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().h1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TVPreferencesDialogActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TVPreferencesDialogActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    @Override // io.didomi.ssl.g8
    public void c() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TVPreferencesDialogActivity this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.lockFocus) {
            return;
        }
        if (!z) {
            v5 v5Var = this$0.bindingPrimary;
            if (v5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
                v5Var = null;
            }
            if (!v5Var.f.isFocused()) {
                this$0.v();
                return;
            }
        }
        if (z) {
            this$0.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TVPreferencesDialogActivity this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.lockFocus) {
            return;
        }
        if (!z) {
            v5 v5Var = this$0.bindingPrimary;
            if (v5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindingPrimary");
                v5Var = null;
            }
            if (!v5Var.e.isFocused()) {
                this$0.w();
                return;
            }
        }
        if (z) {
            this$0.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(TVPreferencesDialogActivity this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 22) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            this$0.n();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(TVPreferencesDialogActivity this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 22) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            this$0.o();
        }
        return true;
    }
}
