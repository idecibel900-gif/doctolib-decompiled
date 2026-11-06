package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    WithinAppServiceBinder(IntentHandler intentHandler) {
        this.intentHandler = intentHandler;
    }

    void send(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceBinder$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                bindRequest.finish();
            }
        });
    }
}
