package io.didomi.ssl;

import android.app.Dialog;
import android.content.Context;
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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001#\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b=\u0010>J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\"\u001a\u00020\u0007R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b\n\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lio/didomi/sdk/sg;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lio/didomi/sdk/dh;", "Lio/didomi/sdk/Vendor;", "vendor", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "consentStatus", "", "a", "legIntState", "b", "e", "Landroid/content/Context;", "context", "onAttach", "", "getTheme", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "dismiss", "onDetach", "onDestroyView", "d", "io/didomi/sdk/sg$f", "Lio/didomi/sdk/sg$f;", "vendorListCallback", "Lio/didomi/sdk/ug;", "Lio/didomi/sdk/ug;", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/eh;", "c", "Lio/didomi/sdk/eh;", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/g3;", "Lio/didomi/sdk/g3;", "binding", "Lio/didomi/sdk/bd;", "Lio/didomi/sdk/bd;", "listener", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", "g", "android_release"}, k = 1, mv = {1, 8, 0})
public final class sg extends AppCompatDialogFragment implements dh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final f vendorListCallback = new f();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private g3 binding;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private bd listener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Job job;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        b() {
            super(1);
        }

        public final void a(boolean z) {
            if (z) {
                return;
            }
            sg.this.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function1 {
        final /* synthetic */ RecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView recyclerView) {
            super(1);
            this.a = recyclerView;
        }

        public final Boolean a(int i) {
            RecyclerView.Adapter adapter = this.a.getAdapter();
            return Boolean.valueOf(adapter != null && adapter.getItemViewType(i) == 2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "kotlin.jvm.PlatformType", "consentState", "", "a", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function1 {
        d() {
            super(1);
        }

        public final void a(DidomiToggle.b bVar) {
            Vendor vendor;
            if (sg.this.b().getIgnoreVendorDataChanges() || (vendor = (Vendor) sg.this.b().getSelectedVendor().getValue()) == null || !sg.this.b().F(vendor) || bVar == null) {
                return;
            }
            sg.this.a(vendor, bVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((DidomiToggle.b) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "kotlin.jvm.PlatformType", "legIntState", "", "a", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function1 {
        e() {
            super(1);
        }

        public final void a(DidomiToggle.b bVar) {
            Vendor vendor;
            if (sg.this.b().getIgnoreVendorDataChanges() || (vendor = (Vendor) sg.this.b().getSelectedVendor().getValue()) == null || !sg.this.b().G(vendor) || bVar == null) {
                return;
            }
            sg.this.b(vendor, bVar);
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
        g3 g3Var = this.binding;
        RecyclerView.Adapter adapter = (g3Var == null || (recyclerView = g3Var.b) == null) ? null : recyclerView.getAdapter();
        mg mgVar = adapter instanceof mg ? (mg) adapter : null;
        if (mgVar != null) {
            mgVar.a(b().A0());
        }
    }

    public final void d() {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right).add(R.id.container_ctv_preferences_secondary, new uf()).addToBackStack("TVVendorDetailFragment").commit();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        bd bdVar = this.listener;
        if (bdVar != null) {
            bdVar.e();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.Didomi_Theme_TVDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
        KeyEventDispatcher.Component activity = getActivity();
        this.listener = activity instanceof bd ? (bd) activity : null;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCancelable(false);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        }
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…), 0, 0, 0, 0))\n        }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        g3 g3VarA = g3.a(inflater, parent, false);
        this.binding = g3VarA;
        FrameLayout root = g3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        g3 g3Var = this.binding;
        if (g3Var != null && (recyclerView = g3Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
        this.binding = null;
        ug ugVarB = b();
        ugVarB.getSelectedVendorConsentState().removeObservers(getViewLifecycleOwner());
        ugVarB.getSelectedVendorLegIntState().removeObservers(getViewLifecycleOwner());
        ugVarB.d(0);
        ugVarB.e(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.job = c6.a(this, c().a(), new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        g3 g3Var = this.binding;
        if (g3Var != null && (recyclerView = g3Var.b) != null) {
            recyclerView.setAdapter(new mg(this.vendorListCallback, b().L0()));
            recyclerView.setItemAnimator(null);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            recyclerView.setLayoutManager(new CenterLayoutManager(context, 1, false));
            recyclerView.addItemDecoration(new g6(recyclerView, false, new c(recyclerView), 2, null));
            recyclerView.setHasFixedSize(true);
        }
        ug ugVarB = b();
        b().U0();
        MutableLiveData selectedVendorConsentState = ugVarB.getSelectedVendorConsentState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final d dVar = new d();
        selectedVendorConsentState.observe(viewLifecycleOwner, new Observer() { // from class: io.didomi.sdk.sg$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                sg.a(dVar, obj);
            }
        });
        MutableLiveData selectedVendorLegIntState = ugVarB.getSelectedVendorLegIntState();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final e eVar = new e();
        selectedVendorLegIntState.observe(viewLifecycleOwner2, new Observer() { // from class: io.didomi.sdk.sg$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                sg.b(eVar, obj);
            }
        });
    }

    public final eh c() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final ug b() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"io/didomi/sdk/sg$f", "Lio/didomi/sdk/mg$a;", "", "isChecked", "", "a", "Lio/didomi/sdk/Vendor;", "vendor", "", "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class f implements mg.a {
        f() {
        }

        @Override // io.didomi.sdk.mg.a
        public void a(boolean isChecked) {
            RecyclerView recyclerView;
            sg.this.b().b(isChecked);
            g3 g3Var = sg.this.binding;
            RecyclerView.Adapter adapter = (g3Var == null || (recyclerView = g3Var.b) == null) ? null : recyclerView.getAdapter();
            mg mgVar = adapter instanceof mg ? (mg) adapter : null;
            if (mgVar != null) {
                mgVar.a(sg.this.b().z0());
            }
        }

        @Override // io.didomi.sdk.mg.a
        public void a(Vendor vendor) {
            Intrinsics.checkNotNullParameter(vendor, "vendor");
            ug ugVarB = sg.this.b();
            ugVarB.C(vendor);
            ugVarB.A(vendor);
            sg.this.d();
        }

        @Override // io.didomi.sdk.mg.a
        public void a(Vendor vendor, boolean isChecked) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(vendor, "vendor");
            sg.this.b().c(vendor, isChecked ? DidomiToggle.b.ENABLED : DidomiToggle.b.DISABLED);
            g3 g3Var = sg.this.binding;
            RecyclerView.Adapter adapter = (g3Var == null || (recyclerView = g3Var.b) == null) ? null : recyclerView.getAdapter();
            mg mgVar = adapter instanceof mg ? (mg) adapter : null;
            if (mgVar != null) {
                mgVar.a(sg.this.b().L(vendor));
            }
            sg.this.e();
        }

        @Override // io.didomi.sdk.mg.a
        public void a() {
            bd bdVar = sg.this.listener;
            if (bdVar != null) {
                bdVar.d();
            }
        }

        @Override // io.didomi.sdk.mg.a
        public void a(final int position) {
            sg.this.b().e(position);
            FragmentActivity fragmentActivityRequireActivity = sg.this.requireActivity();
            final sg sgVar = sg.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: io.didomi.sdk.sg$f$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    sg.f.a(sgVar, position);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(sg this$0, int i) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            g3 g3Var = this$0.binding;
            if (g3Var == null || (recyclerView = g3Var.b) == null) {
                return;
            }
            if (i <= 4) {
                i = 0;
            }
            recyclerView.smoothScrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // io.didomi.ssl.dh
    public void a() {
        final g3 g3Var = this.binding;
        if (g3Var != null) {
            g3Var.getRoot().postDelayed(new Runnable() { // from class: io.didomi.sdk.sg$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    sg.a(g3Var, this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Vendor vendor, DidomiToggle.b legIntState) {
        RecyclerView recyclerView;
        b().b(vendor, legIntState);
        g3 g3Var = this.binding;
        RecyclerView.Adapter adapter = (g3Var == null || (recyclerView = g3Var.b) == null) ? null : recyclerView.getAdapter();
        mg mgVar = adapter instanceof mg ? (mg) adapter : null;
        if (mgVar != null) {
            mgVar.a(b().L(vendor));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(g3 this_apply, sg this$0) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this_apply.b.getAdapter();
        mg mgVar = adapter instanceof mg ? (mg) adapter : null;
        if (mgVar != null) {
            mgVar.a(this$0.b().getFocusedPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Vendor vendor, DidomiToggle.b consentStatus) {
        RecyclerView recyclerView;
        b().a(vendor, consentStatus);
        g3 g3Var = this.binding;
        RecyclerView.Adapter adapter = (g3Var == null || (recyclerView = g3Var.b) == null) ? null : recyclerView.getAdapter();
        mg mgVar = adapter instanceof mg ? (mg) adapter : null;
        if (mgVar != null) {
            mgVar.a(b().L(vendor));
        }
        e();
    }
}
