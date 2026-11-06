package io.didomi.ssl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import io.didomi.ssl.view.ctv.CenterLayoutManager;
import io.didomi.ssl.view.mobile.DidomiToggle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001<\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0007\u0010'\u001a\u0004\b\r\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lio/didomi/sdk/oe;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lio/didomi/sdk/dh;", "", "d", "Lio/didomi/sdk/m1;", "dataProcessing", "a", "Lio/didomi/sdk/Purpose;", "purpose", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "consentStatus", "legIntState", "b", "e", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "Landroid/content/DialogInterface;", "dialog", "onCancel", "dismiss", "onDetach", "onDestroyView", "Lio/didomi/sdk/qe;", "Lio/didomi/sdk/qe;", "()Lio/didomi/sdk/qe;", "setModel", "(Lio/didomi/sdk/qe;)V", "model", "Lio/didomi/sdk/eh;", "Lio/didomi/sdk/eh;", "c", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/a3;", "Lio/didomi/sdk/a3;", "binding", "Lio/didomi/sdk/g8;", "Lio/didomi/sdk/g8;", "listener", "Lio/didomi/sdk/v8;", "Lio/didomi/sdk/v8;", "dismissHelper", "io/didomi/sdk/oe$e", "f", "Lio/didomi/sdk/oe$e;", "purposeListAdapterCallback", "<init>", "()V", "g", "android_release"}, k = 1, mv = {1, 8, 0})
public final class oe extends AppCompatDialogFragment implements dh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public qe model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private a3 binding;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private g8 listener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final e purposeListAdapterCallback = new e();

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        final /* synthetic */ RecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView recyclerView) {
            super(1);
            this.a = recyclerView;
        }

        public final Boolean a(int i) {
            RecyclerView.Adapter adapter = this.a.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.adapter.TVPurposeListAdapter");
            return Boolean.valueOf(((rd) adapter).getItemViewType(i) == 2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function1 {
        c() {
            super(1);
        }

        public final void a(DidomiToggle.b bVar) {
            Purpose purpose = (Purpose) oe.this.b().getSelectedPurpose().getValue();
            if (purpose == null || bVar == null) {
                return;
            }
            oe.this.a(purpose, bVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((DidomiToggle.b) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function1 {
        d() {
            super(1);
        }

        public final void a(DidomiToggle.b bVar) {
            Purpose purpose = (Purpose) oe.this.b().getSelectedPurpose().getValue();
            if (purpose == null || !oe.this.b().w(purpose) || bVar == null) {
                return;
            }
            oe.this.b(purpose, bVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((DidomiToggle.b) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        RecyclerView recyclerView;
        a3 a3Var = this.binding;
        RecyclerView.Adapter adapter = (a3Var == null || (recyclerView = a3Var.b) == null) ? null : recyclerView.getAdapter();
        rd rdVar = adapter instanceof rd ? (rd) adapter : null;
        if (rdVar != null) {
            rdVar.a(b().I1());
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        g8 g8Var = this.listener;
        if (g8Var != null) {
            g8Var.c();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
        KeyEventDispatcher.Component activity = getActivity();
        this.listener = activity instanceof g8 ? (g8) activity : null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        b().i1();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext(), R.style.Didomi_Theme_TVDialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        a3 a3VarA = a3.a(inflater, parent, false);
        this.binding = a3VarA;
        FrameLayout root = a3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        a3 a3Var = this.binding;
        if (a3Var != null && (recyclerView = a3Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
        this.binding = null;
        qe qeVarB = b();
        qeVarB.getSelectedPurposeConsentState().removeObservers(getViewLifecycleOwner());
        qeVarB.getSelectedPurposeLegIntState().removeObservers(getViewLifecycleOwner());
        qeVarB.b(-1);
        qeVarB.c(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.dismissHelper.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.dismissHelper.a(this, c());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        a3 a3Var = this.binding;
        if (a3Var != null) {
            RecyclerView recyclerView = a3Var.b;
            recyclerView.setAdapter(new rd(this.purposeListAdapterCallback, b().M1()));
            recyclerView.setItemAnimator(null);
            Context context = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            recyclerView.setLayoutManager(new CenterLayoutManager(context, 1, false));
            Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
            recyclerView.addItemDecoration(new g6(recyclerView, false, new b(recyclerView), 2, null));
            recyclerView.setHasFixedSize(true);
        }
        qe qeVarB = b();
        qeVarB.k1();
        MutableLiveData selectedPurposeConsentState = qeVarB.getSelectedPurposeConsentState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final c cVar = new c();
        selectedPurposeConsentState.observe(viewLifecycleOwner, new Observer() { // from class: io.didomi.sdk.oe$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                oe.a(cVar, obj);
            }
        });
        MutableLiveData selectedPurposeLegIntState = qeVarB.getSelectedPurposeLegIntState();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final d dVar = new d();
        selectedPurposeLegIntState.observe(viewLifecycleOwner2, new Observer() { // from class: io.didomi.sdk.oe$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                oe.b(dVar, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right).add(R.id.container_ctv_preferences_secondary, new ld()).addToBackStack("io.didomi.dialog.DETAIL").commit();
    }

    public final eh c() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
        return null;
    }

    public final qe b() {
        qe qeVar = this.model;
        if (qeVar != null) {
            return qeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"io/didomi/sdk/oe$e", "Lio/didomi/sdk/rd$a;", "Lio/didomi/sdk/Purpose;", "purpose", "", "a", "", "isChecked", "", "index", "Lio/didomi/sdk/m1;", "dataProcessing", "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class e implements rd.a {
        e() {
        }

        @Override // io.didomi.sdk.rd.a
        public void a(Purpose purpose) {
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            qe qeVarB = oe.this.b();
            qeVarB.u(purpose);
            qeVarB.o(purpose);
            oe.this.d();
        }

        @Override // io.didomi.sdk.rd.a
        public void a(Purpose purpose, boolean isChecked) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            oe.this.b().a(purpose, isChecked);
            a3 a3Var = oe.this.binding;
            RecyclerView.Adapter adapter = (a3Var == null || (recyclerView = a3Var.b) == null) ? null : recyclerView.getAdapter();
            rd rdVar = adapter instanceof rd ? (rd) adapter : null;
            if (rdVar != null) {
                rdVar.a(oe.this.b().y(purpose));
            }
            oe.this.e();
        }

        @Override // io.didomi.sdk.rd.a
        public void a(boolean isChecked) {
            RecyclerView recyclerView;
            oe.this.b().e(isChecked);
            a3 a3Var = oe.this.binding;
            RecyclerView.Adapter adapter = (a3Var == null || (recyclerView = a3Var.b) == null) ? null : recyclerView.getAdapter();
            rd rdVar = adapter instanceof rd ? (rd) adapter : null;
            if (rdVar != null) {
                rdVar.a(oe.this.b().J1());
            }
        }

        @Override // io.didomi.sdk.rd.a
        public void a(int index, m1 dataProcessing) {
            Intrinsics.checkNotNullParameter(dataProcessing, "dataProcessing");
            oe.this.b().b(index);
            oe.this.a(dataProcessing);
        }

        @Override // io.didomi.sdk.rd.a
        public void a() {
            g8 g8Var = oe.this.listener;
            if (g8Var != null) {
                g8Var.f();
            }
        }

        @Override // io.didomi.sdk.rd.a
        public void a(final int position) {
            oe.this.b().c(position);
            FragmentActivity fragmentActivityRequireActivity = oe.this.requireActivity();
            final oe oeVar = oe.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: io.didomi.sdk.oe$e$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    oe.e.a(oeVar, position);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(oe this$0, int i) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a3 a3Var = this$0.binding;
            if (a3Var == null || (recyclerView = a3Var.b) == null) {
                return;
            }
            if (i <= 4) {
                i = 0;
            }
            recyclerView.smoothScrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Purpose purpose, DidomiToggle.b legIntState) {
        RecyclerView recyclerView;
        b().d(purpose, legIntState);
        a3 a3Var = this.binding;
        RecyclerView.Adapter adapter = (a3Var == null || (recyclerView = a3Var.b) == null) ? null : recyclerView.getAdapter();
        rd rdVar = adapter instanceof rd ? (rd) adapter : null;
        if (rdVar != null) {
            rdVar.a(b().y(purpose));
        }
    }

    @Override // io.didomi.ssl.dh
    public void a() {
        final a3 a3Var = this.binding;
        if (a3Var != null) {
            a3Var.getRoot().postDelayed(new Runnable() { // from class: io.didomi.sdk.oe$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    oe.a(a3Var, this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a3 this_apply, oe this$0) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this_apply.b.getAdapter();
        rd rdVar = adapter instanceof rd ? (rd) adapter : null;
        if (rdVar != null) {
            rdVar.a(this$0.b().getFocusedPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(m1 dataProcessing) {
        getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right).add(R.id.container_ctv_preferences_secondary, rc.INSTANCE.a(dataProcessing), "io.didomi.dialog.ADDITIONAL_DATA_PROCESSING_DETAIL").addToBackStack("io.didomi.dialog.ADDITIONAL_DATA_PROCESSING_DETAIL").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Purpose purpose, DidomiToggle.b consentStatus) {
        RecyclerView recyclerView;
        b().a(purpose, consentStatus);
        a3 a3Var = this.binding;
        RecyclerView.Adapter adapter = (a3Var == null || (recyclerView = a3Var.b) == null) ? null : recyclerView.getAdapter();
        rd rdVar = adapter instanceof rd ? (rd) adapter : null;
        if (rdVar != null) {
            rdVar.a(b().y(purpose));
        }
        e();
    }
}
