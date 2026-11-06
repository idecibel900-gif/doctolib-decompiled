package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "maxClientId", "", "getMaxClientId$room_runtime", "()I", "setMaxClientId$room_runtime", "(I)V", "clientNames", "", "", "getClientNames$room_runtime", "()Ljava/util/Map;", "callbackList", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallbackList$room_runtime", "()Landroid/os/RemoteCallbackList;", "binder", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiInstanceInvalidationService extends Service {
    private int maxClientId;
    private final Map clientNames = new LinkedHashMap();
    private final RemoteCallbackList callbackList = new RemoteCallbackList() { // from class: androidx.room.MultiInstanceInvalidationService$callbackList$1
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.this$0.getClientNames().remove((Integer) cookie);
        }
    };
    private final IMultiInstanceInvalidationService.Stub binder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String str) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            int i = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList callbackList = this.this$0.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (callbackList) {
                try {
                    multiInstanceInvalidationService.setMaxClientId$room_runtime(multiInstanceInvalidationService.getMaxClientId() + 1);
                    int maxClientId = multiInstanceInvalidationService.getMaxClientId();
                    if (multiInstanceInvalidationService.getCallbackList().register(callback, Integer.valueOf(maxClientId))) {
                        multiInstanceInvalidationService.getClientNames().put(Integer.valueOf(maxClientId), str);
                        i = maxClientId;
                    } else {
                        multiInstanceInvalidationService.setMaxClientId$room_runtime(multiInstanceInvalidationService.getMaxClientId() - 1);
                        multiInstanceInvalidationService.getMaxClientId();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int i) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            RemoteCallbackList callbackList = this.this$0.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (callbackList) {
                multiInstanceInvalidationService.getCallbackList().unregister(callback);
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i, String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            RemoteCallbackList callbackList = this.this$0.getCallbackList();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (callbackList) {
                try {
                    String str = (String) multiInstanceInvalidationService.getClientNames().get(Integer.valueOf(i));
                    if (str == null) {
                        return;
                    }
                    int iBeginBroadcast = multiInstanceInvalidationService.getCallbackList().beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        try {
                            Object broadcastCookie = multiInstanceInvalidationService.getCallbackList().getBroadcastCookie(i2);
                            Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                            Integer num = (Integer) broadcastCookie;
                            int iIntValue = num.intValue();
                            String str2 = (String) multiInstanceInvalidationService.getClientNames().get(num);
                            if (i != iIntValue && Intrinsics.areEqual(str, str2)) {
                                try {
                                    ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.getCallbackList().getBroadcastItem(i2)).onInvalidation(tables);
                                    Unit unit = Unit.INSTANCE;
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                            throw th;
                        }
                    }
                    multiInstanceInvalidationService.getCallbackList().finishBroadcast();
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* JADX INFO: renamed from: getMaxClientId$room_runtime, reason: from getter */
    public final int getMaxClientId() {
        return this.maxClientId;
    }

    public final void setMaxClientId$room_runtime(int i) {
        this.maxClientId = i;
    }

    /* JADX INFO: renamed from: getClientNames$room_runtime, reason: from getter */
    public final Map getClientNames() {
        return this.clientNames;
    }

    /* JADX INFO: renamed from: getCallbackList$room_runtime, reason: from getter */
    public final RemoteCallbackList getCallbackList() {
        return this.callbackList;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.binder;
    }
}
