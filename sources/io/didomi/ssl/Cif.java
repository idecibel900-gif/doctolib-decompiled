package io.didomi.ssl;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import io.didomi.ssl.vendors.ctv.model.TVDataProcessingLegalType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.if, reason: invalid class name */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\nH&J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0004R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0018\u0010#\"\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b!\u0010*\"\u0004\b\u0018\u0010+R$\u00101\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010.\u001a\u0004\b(\u0010/\"\u0004\b\u0018\u00100¨\u00064"}, d2 = {"Lio/didomi/sdk/if;", "Landroidx/fragment/app/Fragment;", "", "l", "h", "j", "f", "g", "k", "i", "Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;", "d", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "consentView", "a", "Lio/didomi/sdk/ug;", "Lio/didomi/sdk/ug;", "e", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/d3;", "b", "Lio/didomi/sdk/d3;", "()Lio/didomi/sdk/d3;", "setBinding", "(Lio/didomi/sdk/d3;)V", "binding", "Lio/didomi/sdk/t5;", "c", "Lio/didomi/sdk/t5;", "()Lio/didomi/sdk/t5;", "(Lio/didomi/sdk/t5;)V", "bindingCheckbox", "Lio/didomi/sdk/u5;", "Lio/didomi/sdk/u5;", "()Lio/didomi/sdk/u5;", "(Lio/didomi/sdk/u5;)V", "bindingSwitch", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class Cif extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private d3 binding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private t5 bindingCheckbox;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private u5 bindingSwitch;

    private final void f() {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right_alpha).replace(R.id.container_ctv_preferences_secondary, ye.INSTANCE.a(d())).addToBackStack("io.didomi.dialog.TV_VENDOR_ADDITIONAL_INFO_FRAGMENT").commit();
    }

    private final void h() {
        d3 d3Var = this.binding;
        TextView textView = d3Var != null ? d3Var.f : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(e().v0() ? 0 : 8);
    }

    private final void j() {
        Button button;
        d3 d3Var = this.binding;
        if (d3Var == null || (button = d3Var.b) == null) {
            return;
        }
        if (e().y0()) {
            button.setVisibility(8);
            return;
        }
        button.setText(e().Q0());
        button.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.if$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Cif.a(this.f$0, view);
            }
        });
        button.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.if$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return Cif.a(this.f$0, view, i, keyEvent);
            }
        });
    }

    private final void l() {
        d3 d3Var = this.binding;
        TextView textView = d3Var != null ? d3Var.i : null;
        if (textView == null) {
            return;
        }
        textView.setText(e().w0());
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    protected final d3 getBinding() {
        return this.binding;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    protected final t5 getBindingCheckbox() {
        return this.bindingCheckbox;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    protected final u5 getBindingSwitch() {
        return this.bindingSwitch;
    }

    public abstract TVDataProcessingLegalType d();

    public final ug e() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    public abstract void g();

    public abstract void i();

    public abstract void k();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        d3 d3VarA = d3.a(inflater, parent, false);
        this.binding = d3VarA;
        ConstraintLayout root = d3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
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
        l();
        h();
        k();
        i();
        j();
        g();
    }

    protected final void a(t5 t5Var) {
        this.bindingCheckbox = t5Var;
    }

    protected final void a(u5 u5Var) {
        this.bindingSwitch = u5Var;
    }

    protected final void a(final View consentView) {
        Intrinsics.checkNotNullParameter(consentView, "consentView");
        final d3 d3Var = this.binding;
        if (d3Var != null) {
            Button buttonCtvVendorDataReadMore = d3Var.b;
            Intrinsics.checkNotNullExpressionValue(buttonCtvVendorDataReadMore, "buttonCtvVendorDataReadMore");
            if (buttonCtvVendorDataReadMore.getVisibility() == 8) {
                return;
            }
            d3Var.getRoot().post(new Runnable() { // from class: io.didomi.sdk.if$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Cif.a(consentView, d3Var);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View consentView, d3 this_apply) {
        Intrinsics.checkNotNullParameter(consentView, "$consentView");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewGroup.LayoutParams layoutParams = consentView.getLayoutParams();
        layoutParams.width = this_apply.c.getMeasuredWidth() / 2;
        consentView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this_apply.b.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        this_apply.b.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cif this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Cif this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 23 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.f();
        return true;
    }
}
