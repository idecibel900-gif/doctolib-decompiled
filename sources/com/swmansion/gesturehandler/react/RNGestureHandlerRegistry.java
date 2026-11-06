package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    private final SparseArray handlers = new SparseArray();
    private final SparseArray attachedTo = new SparseArray();
    private final SparseArray handlersForView = new SparseArray();

    public final synchronized void registerHandler(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.put(handler.getTag(), handler);
    }

    public final synchronized GestureHandler getHandler(int i) {
        return (GestureHandler) this.handlers.get(i);
    }

    public final synchronized boolean attachHandlerToView(int i, int i2, int i3) {
        boolean z;
        GestureHandler gestureHandler = (GestureHandler) this.handlers.get(i);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            gestureHandler.setActionType(i3);
            registerHandlerForViewWithTag(i2, gestureHandler);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private final synchronized void registerHandlerForViewWithTag(int i, GestureHandler gestureHandler) {
        try {
            if (this.attachedTo.get(gestureHandler.getTag()) != null) {
                throw new IllegalStateException(("Handler " + gestureHandler + " already attached").toString());
            }
            this.attachedTo.put(gestureHandler.getTag(), Integer.valueOf(i));
            Object obj = this.handlersForView.get(i);
            if (obj == null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(gestureHandler);
                this.handlersForView.put(i, arrayList);
            } else {
                synchronized (obj) {
                    ((ArrayList) obj).add(gestureHandler);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void detachHandler(final GestureHandler gestureHandler) {
        try {
            Integer num = (Integer) this.attachedTo.get(gestureHandler.getTag());
            if (num != null) {
                this.attachedTo.remove(gestureHandler.getTag());
                ArrayList arrayList = (ArrayList) this.handlersForView.get(num.intValue());
                if (arrayList != null) {
                    synchronized (arrayList) {
                        arrayList.remove(gestureHandler);
                    }
                    if (arrayList.size() == 0) {
                        this.handlersForView.remove(num.intValue());
                    }
                }
            }
            if (gestureHandler.getView() != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        gestureHandler.cancel();
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void dropHandler(int i) {
        GestureHandler gestureHandler = (GestureHandler) this.handlers.get(i);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            this.handlers.remove(i);
        }
    }

    public final synchronized void dropAllHandlers() {
        this.handlers.clear();
        this.attachedTo.clear();
        this.handlersForView.clear();
    }

    public final synchronized ArrayList getHandlersForViewWithTag(int i) {
        return (ArrayList) this.handlersForView.get(i);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerRegistry
    public synchronized ArrayList getHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return getHandlersForViewWithTag(view.getId());
    }
}
