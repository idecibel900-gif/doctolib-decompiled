package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerInteractionController;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {
    public static final Companion Companion = new Companion(null);
    private final SparseArray waitForRelations = new SparseArray();
    private final SparseArray simultaneousRelations = new SparseArray();
    private final SparseArray blockingRelations = new SparseArray();

    public final void dropRelationsForHandlerWithTag(int i) {
        this.waitForRelations.remove(i);
        this.simultaneousRelations.remove(i);
        this.blockingRelations.remove(i);
    }

    private final int[] convertHandlerTagsArray(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        Intrinsics.checkNotNull(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public final void configureInteractions(GestureHandler handler, ReadableMap config) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(config, "config");
        handler.setInteractionController(this);
        if (config.hasKey("waitFor")) {
            this.waitForRelations.put(handler.getTag(), convertHandlerTagsArray(config, "waitFor"));
        }
        if (config.hasKey("simultaneousHandlers")) {
            this.simultaneousRelations.put(handler.getTag(), convertHandlerTagsArray(config, "simultaneousHandlers"));
        }
        if (config.hasKey("blocksHandlers")) {
            this.blockingRelations.put(handler.getTag(), convertHandlerTagsArray(config, "blocksHandlers"));
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldWaitForHandlerFailure(GestureHandler handler, GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = (int[]) this.waitForRelations.get(handler.getTag());
        if (iArr != null) {
            for (int i : iArr) {
                if (i == otherHandler.getTag()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler handler, GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = (int[]) this.blockingRelations.get(handler.getTag());
        if (iArr != null) {
            for (int i : iArr) {
                if (i == otherHandler.getTag()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldHandlerBeCancelledBy(GestureHandler handler, GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        if (otherHandler instanceof NativeViewGestureHandler) {
            return ((NativeViewGestureHandler) otherHandler).getDisallowInterruption();
        }
        return otherHandler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRecognizeSimultaneously(GestureHandler handler, GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = (int[]) this.simultaneousRelations.get(handler.getTag());
        if (iArr != null) {
            for (int i : iArr) {
                if (i == otherHandler.getTag()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void reset() {
        this.waitForRelations.clear();
        this.simultaneousRelations.clear();
        this.blockingRelations.clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
