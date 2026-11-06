package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;
import io.didomi.ssl.view.mobile.DidomiToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010&¨\u0006*"}, d2 = {"Lio/didomi/sdk/ld;", "Landroidx/fragment/app/Fragment;", "", "g", "e", "c", "f", "b", "d", "h", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/qe;", "a", "Lio/didomi/sdk/qe;", "()Lio/didomi/sdk/qe;", "setModel", "(Lio/didomi/sdk/qe;)V", "model", "Lio/didomi/sdk/y2;", "Lio/didomi/sdk/y2;", "binding", "Lio/didomi/sdk/t5;", "Lio/didomi/sdk/t5;", "bindingCheckbox", "Lio/didomi/sdk/u5;", "Lio/didomi/sdk/u5;", "bindingSwitch", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ld extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public qe model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private y2 binding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private t5 bindingCheckbox;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private u5 bindingSwitch;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/ld$b", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements DidomiTVSwitch.a {
        final /* synthetic */ u5 b;
        final /* synthetic */ Purpose c;

        b(u5 u5Var, Purpose purpose) {
            this.b = u5Var;
            this.c = purpose;
        }

        @Override // io.didomi.sdk.view.ctv.DidomiTVSwitch.a
        public void a(DidomiTVSwitch didomiTVSwitch, boolean isChecked) {
            Intrinsics.checkNotNullParameter(didomiTVSwitch, "switch");
            ld.this.a().f(isChecked);
            this.b.c.setText(ld.this.a().d(this.c, isChecked));
        }
    }

    private final void b() {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right_alpha).replace(R.id.container_ctv_preferences_secondary, new hd()).addToBackStack("io.didomi.dialog.TV_PURPOSE_ADDITIONAL_INFO_FRAGMENT").commit();
    }

    private final void c() {
        u5 u5Var;
        u5 u5Var2;
        ConstraintLayout root;
        Purpose purpose = (Purpose) a().getSelectedPurpose().getValue();
        ConstraintLayout root2 = null;
        if (purpose != null) {
            if (purpose.isConsentNotEssential()) {
                u5 u5Var3 = this.bindingSwitch;
                if (u5Var3 != null) {
                    boolean z = a().getSelectedPurposeConsentState().getValue() == DidomiToggle.b.ENABLED;
                    u5Var3.d.setText(a().J());
                    u5Var3.c.setText(a().d(purpose, z));
                    final DidomiTVSwitch didomiTVSwitch = u5Var3.b;
                    didomiTVSwitch.setCallback(null);
                    didomiTVSwitch.setChecked(z);
                    didomiTVSwitch.setCallback(new b(u5Var3, purpose));
                    y2 y2Var = this.binding;
                    if (y2Var == null || (u5Var2 = y2Var.c) == null || (root = u5Var2.getRoot()) == null) {
                        return;
                    }
                    root.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ld$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ld.a(didomiTVSwitch, view);
                        }
                    });
                    return;
                }
                return;
            }
        }
        y2 y2Var2 = this.binding;
        if (y2Var2 != null && (u5Var = y2Var2.c) != null) {
            root2 = u5Var.getRoot();
        }
        if (root2 == null) {
            return;
        }
        root2.setVisibility(8);
    }

    private final void d() {
        TextView textView;
        String strI;
        int i;
        y2 y2Var = this.binding;
        if (y2Var == null || (textView = y2Var.f) == null) {
            return;
        }
        Purpose it = (Purpose) a().getSelectedPurpose().getValue();
        if (it != null) {
            qe qeVarA = a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            strI = qeVarA.i(it);
        } else {
            strI = null;
        }
        if (strI == null || StringsKt.isBlank(strI)) {
            i = 8;
        } else {
            textView.setText(strI);
            i = 0;
        }
        textView.setVisibility(i);
    }

    private final void e() {
        t5 t5Var;
        t5 t5Var2;
        ConstraintLayout root;
        final Purpose purpose = (Purpose) a().getSelectedPurpose().getValue();
        if (a().T0() || purpose == null || !purpose.isLegitimateInterestNotEssential()) {
            y2 y2Var = this.binding;
            ConstraintLayout root2 = (y2Var == null || (t5Var = y2Var.d) == null) ? null : t5Var.getRoot();
            if (root2 == null) {
                return;
            }
            root2.setVisibility(8);
            return;
        }
        final t5 t5Var3 = this.bindingCheckbox;
        if (t5Var3 != null) {
            t5Var3.b.setChecked(true ^ a().q(purpose));
            t5Var3.d.setText(a().K1());
            t5Var3.c.setText(a().e(purpose, t5Var3.b.isChecked()));
            t5Var3.b.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ld$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ld.a(t5Var3, this, purpose, view);
                }
            });
            y2 y2Var2 = this.binding;
            if (y2Var2 == null || (t5Var2 = y2Var2.d) == null || (root = t5Var2.getRoot()) == null) {
                return;
            }
            root.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ld$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ld.a(t5Var3, view);
                }
            });
        }
    }

    private final void f() {
        Button button;
        if (!a().U1()) {
            y2 y2Var = this.binding;
            if (y2Var != null) {
                Button buttonCtvPurposeDetailReadMore = y2Var.b;
                Intrinsics.checkNotNullExpressionValue(buttonCtvPurposeDetailReadMore, "buttonCtvPurposeDetailReadMore");
                buttonCtvPurposeDetailReadMore.setVisibility(8);
                return;
            }
            return;
        }
        y2 y2Var2 = this.binding;
        if (y2Var2 != null && (button = y2Var2.b) != null) {
            button.setText(a().P1());
            button.setVisibility(0);
            button.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ld$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ld.a(this.f$0, view);
                }
            });
            button.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.ld$$ExternalSyntheticLambda2
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return ld.a(this.f$0, view, i, keyEvent);
                }
            });
        }
        y2 y2Var3 = this.binding;
        View view = y2Var3 != null ? y2Var3.i : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    private final void g() {
        TextView textView;
        int i;
        ConstraintLayout root;
        u5 u5Var;
        ConstraintLayout root2;
        y2 y2Var = this.binding;
        if (y2Var == null || (textView = y2Var.g) == null) {
            return;
        }
        t5 t5Var = this.bindingCheckbox;
        if (t5Var == null || (root = t5Var.getRoot()) == null) {
            textView.setText(a().Q1());
            i = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(root, "root");
            i = 8;
            if (root.getVisibility() != 8 || (u5Var = this.bindingSwitch) == null || (root2 = u5Var.getRoot()) == null) {
                textView.setText(a().Q1());
                i = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(root2, "root");
                if (root2.getVisibility() != 8) {
                    textView.setText(a().Q1());
                    i = 0;
                }
            }
        }
        textView.setVisibility(i);
    }

    private final void h() {
        TextView textView;
        String strK;
        int i;
        y2 y2Var = this.binding;
        if (y2Var == null || (textView = y2Var.h) == null) {
            return;
        }
        Purpose it = (Purpose) a().getSelectedPurpose().getValue();
        if (it != null) {
            qe qeVarA = a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            strK = qeVarA.k(it);
        } else {
            strK = null;
        }
        if (strK == null || StringsKt.isBlank(strK)) {
            i = 8;
        } else {
            textView.setText(strK);
            i = 0;
        }
        textView.setVisibility(i);
    }

    public final qe a() {
        qe qeVar = this.model;
        if (qeVar != null) {
            return qeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        y2 y2VarA = y2.a(inflater, parent, false);
        this.binding = y2VarA;
        ConstraintLayout root = y2VarA.getRoot();
        this.bindingCheckbox = t5.a(root);
        this.bindingSwitch = u5.a(root);
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…ng.bind(it)\n            }");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        this.bindingCheckbox = null;
        this.bindingSwitch = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        h();
        d();
        f();
        c();
        e();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(t5 this_apply, ld this$0, Purpose purpose, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppCompatCheckBox appCompatCheckBox = this_apply.b;
        appCompatCheckBox.setChecked(!appCompatCheckBox.isChecked());
        this$0.a().g(this_apply.b.isChecked());
        this_apply.c.setText(this$0.a().e(purpose, this_apply.b.isChecked()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(t5 this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.b.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ld this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(ld this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 22 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.b();
        return true;
    }
}
