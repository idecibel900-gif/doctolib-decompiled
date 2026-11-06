package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface FirebaseInstanceIdInternal {

    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(String str, String str2) throws IOException;

    String getId();

    String getToken();

    Task<String> getTokenTask();
}
