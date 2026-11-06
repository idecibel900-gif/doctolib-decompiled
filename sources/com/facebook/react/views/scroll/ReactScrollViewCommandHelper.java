package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactScrollViewCommandHelper {
    public static final Companion Companion = new Companion(null);

    public interface ScrollCommandHandler {
        void flashScrollIndicators(Object obj);

        void scrollTo(Object obj, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(Object obj, ScrollToEndCommandData scrollToEndCommandData);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map getCommandsMap() {
            return MapsKt.hashMapOf(TuplesKt.to("scrollTo", 1), TuplesKt.to("scrollToEnd", 2), TuplesKt.to("flashScrollIndicators", 3));
        }

        public final void receiveCommand(ScrollCommandHandler viewManager, Object obj, int i, ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            if (obj == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (i == 1) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollTo(viewManager, obj, readableArray);
                return;
            }
            if (i == 2) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollToEnd(viewManager, obj, readableArray);
            } else {
                if (i == 3) {
                    viewManager.flashScrollIndicators(obj);
                    return;
                }
                throw new IllegalArgumentException("Unsupported command " + i + " received by " + viewManager.getClass().getSimpleName() + ".");
            }
        }

        public final void receiveCommand(ScrollCommandHandler viewManager, Object obj, String commandType, ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            Intrinsics.checkNotNullParameter(commandType, "commandType");
            if (obj == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int iHashCode = commandType.hashCode();
            if (iHashCode != -402165208) {
                if (iHashCode != 28425985) {
                    if (iHashCode == 2055114131 && commandType.equals("scrollToEnd")) {
                        if (readableArray == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        scrollToEnd(viewManager, obj, readableArray);
                        return;
                    }
                } else if (commandType.equals("flashScrollIndicators")) {
                    viewManager.flashScrollIndicators(obj);
                    return;
                }
            } else if (commandType.equals("scrollTo")) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollTo(viewManager, obj, readableArray);
                return;
            }
            throw new IllegalArgumentException("Unsupported command " + commandType + " received by " + viewManager.getClass().getSimpleName() + ".");
        }

        private final void scrollTo(ScrollCommandHandler scrollCommandHandler, Object obj, ReadableArray readableArray) {
            scrollCommandHandler.scrollTo(obj, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
        }

        private final void scrollToEnd(ScrollCommandHandler scrollCommandHandler, Object obj, ReadableArray readableArray) {
            scrollCommandHandler.scrollToEnd(obj, new ScrollToEndCommandData(readableArray.getBoolean(0)));
        }
    }

    public static final class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        public ScrollToCommandData(int i, int i2, boolean z) {
            this.mDestX = i;
            this.mDestY = i2;
            this.mAnimated = z;
        }
    }

    public static final class ScrollToEndCommandData {
        public final boolean mAnimated;

        public ScrollToEndCommandData(boolean z) {
            this.mAnimated = z;
        }
    }
}
