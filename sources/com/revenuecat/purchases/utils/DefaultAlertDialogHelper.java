package com.revenuecat.purchases.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.amazon.a.a.o.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jb\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/utils/DefaultAlertDialogHelper;", "Lcom/revenuecat/purchases/utils/AlertDialogHelper;", "()V", "showDialog", "", "activity", "Landroid/app/Activity;", b.S, "", "message", "positiveButtonText", "negativeButtonText", "neutralButtonText", "onPositiveButtonClicked", "Lkotlin/Function0;", "onNegativeButtonClicked", "onNeutralButtonClicked", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAlertDialogHelper implements AlertDialogHelper {
    @Override // com.revenuecat.purchases.utils.AlertDialogHelper
    public void showDialog(Activity activity, String title, String message, String positiveButtonText, String negativeButtonText, String neutralButtonText, final Function0 onPositiveButtonClicked, final Function0 onNegativeButtonClicked, final Function0 onNeutralButtonClicked) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(positiveButtonText, "positiveButtonText");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        Intrinsics.checkNotNullParameter(neutralButtonText, "neutralButtonText");
        Intrinsics.checkNotNullParameter(onPositiveButtonClicked, "onPositiveButtonClicked");
        Intrinsics.checkNotNullParameter(onNegativeButtonClicked, "onNegativeButtonClicked");
        Intrinsics.checkNotNullParameter(onNeutralButtonClicked, "onNeutralButtonClicked");
        new AlertDialog.Builder(activity).setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.DefaultAlertDialogHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DefaultAlertDialogHelper.showDialog$lambda$0(onPositiveButtonClicked, dialogInterface, i);
            }
        }).setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.DefaultAlertDialogHelper$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DefaultAlertDialogHelper.showDialog$lambda$1(onNegativeButtonClicked, dialogInterface, i);
            }
        }).setNeutralButton(neutralButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.DefaultAlertDialogHelper$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DefaultAlertDialogHelper.showDialog$lambda$2(onNeutralButtonClicked, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.revenuecat.purchases.utils.DefaultAlertDialogHelper$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                onNeutralButtonClicked.invoke();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(Function0 function0, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(Function0 function0, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(Function0 function0, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        function0.invoke();
    }
}
