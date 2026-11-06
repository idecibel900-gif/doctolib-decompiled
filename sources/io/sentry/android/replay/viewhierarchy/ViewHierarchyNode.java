package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import io.sentry.SentryMaskingOptions;
import io.sentry.android.replay.R$id;
import io.sentry.android.replay.util.AndroidTextLayout;
import io.sentry.android.replay.util.TextLayout;
import io.sentry.android.replay.util.ViewsKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ViewHierarchyNode {
    private List children;
    private final int distance;
    private final float elevation;
    private final int height;
    private boolean isImportantForContentCapture;
    private final boolean isVisible;
    private final ViewHierarchyNode parent;
    private final boolean shouldMask;
    private final Rect visibleRect;
    private final int width;
    private final float x;
    private final float y;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ ViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect);
    }

    private ViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
        this.x = f;
        this.y = f2;
        this.width = i;
        this.height = i2;
        this.elevation = f3;
        this.distance = i3;
        this.parent = viewHierarchyNode;
        this.shouldMask = z;
        this.isImportantForContentCapture = z2;
        this.isVisible = z3;
        this.visibleRect = rect;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final boolean getShouldMask() {
        return this.shouldMask;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final Rect getVisibleRect() {
        return this.visibleRect;
    }

    public final void setChildren(List list) {
        this.children = list;
    }

    public static final class GenericViewHierarchyNode extends ViewHierarchyNode {
        public GenericViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect, null);
        }
    }

    public static final class TextViewHierarchyNode extends ViewHierarchyNode {
        private final Integer dominantColor;
        private final TextLayout layout;
        private final int paddingLeft;
        private final int paddingTop;

        public /* synthetic */ TextViewHierarchyNode(TextLayout textLayout, Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? null : textLayout, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? 0 : i2, f, f2, i3, i4, f3, i5, (i6 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : viewHierarchyNode, (i6 & 2048) != 0 ? false : z, (i6 & 4096) != 0 ? false : z2, (i6 & 8192) != 0 ? false : z3, (i6 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : rect);
        }

        public final TextLayout getLayout() {
            return this.layout;
        }

        public final Integer getDominantColor() {
            return this.dominantColor;
        }

        public final int getPaddingLeft() {
            return this.paddingLeft;
        }

        public final int getPaddingTop() {
            return this.paddingTop;
        }

        public TextViewHierarchyNode(TextLayout textLayout, Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i3, i4, f3, i5, viewHierarchyNode, z, z2, z3, rect, null);
            this.layout = textLayout;
            this.dominantColor = num;
            this.paddingLeft = i;
            this.paddingTop = i2;
        }
    }

    public static final class ImageViewHierarchyNode extends ViewHierarchyNode {
        public ImageViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect, null);
        }
    }

    public static final class SurfaceViewHierarchyNode extends ViewHierarchyNode {
        private final WeakReference surfaceViewRef;

        public final WeakReference getSurfaceViewRef() {
            return this.surfaceViewRef;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurfaceViewHierarchyNode(WeakReference surfaceViewRef, float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect, null);
            Intrinsics.checkNotNullParameter(surfaceViewRef, "surfaceViewRef");
            this.surfaceViewRef = surfaceViewRef;
        }
    }

    public final void setImportantForCaptureToAncestors(boolean z) {
        for (ViewHierarchyNode viewHierarchyNode = this.parent; viewHierarchyNode != null; viewHierarchyNode = viewHierarchyNode.parent) {
            viewHierarchyNode.isImportantForContentCapture = z;
        }
    }

    public final void traverse(Function1 callback) {
        List list;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!((Boolean) callback.invoke(this)).booleanValue() || (list = this.children) == null) {
            return;
        }
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewHierarchyNode) it.next()).traverse(callback);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final boolean isAssignableFrom(Class cls, Set set) {
            while (cls != null) {
                if (set.contains(cls.getName())) {
                    return true;
                }
                cls = cls.getSuperclass();
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0028  */
        /* JADX WARN: Code duplicated, block: B:17:0x003a  */
        /* JADX WARN: Code duplicated, block: B:19:0x0042  */
        /* JADX WARN: Code duplicated, block: B:20:0x0045  */
        /* JADX WARN: Code duplicated, block: B:22:0x0048  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:31:0x006e  */
        /* JADX WARN: Code duplicated, block: B:33:0x0074  */
        /* JADX WARN: Code duplicated, block: B:37:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x009d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x009e  */
        private final boolean shouldMask(View view, SentryMaskingOptions sentryMaskingOptions) {
            Object tag;
            String str;
            Class<?> cls;
            Set unmaskViewClasses;
            ViewParent parent;
            String lowerCase;
            Object tag2 = view.getTag();
            String str2 = tag2 instanceof String ? (String) tag2 : null;
            if (str2 != null) {
                String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (lowerCase2 == null || !StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "sentry-unmask", false, 2, (Object) null)) {
                    if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "unmask")) {
                        tag = view.getTag();
                        if (tag instanceof String) {
                            str = (String) tag;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            lowerCase = str.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (lowerCase != null || !StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "sentry-mask", false, 2, (Object) null)) {
                                if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "mask")) {
                                    if (!isMaskContainer(view, sentryMaskingOptions) && view.getParent() != null) {
                                        parent = view.getParent();
                                        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                                        if (isUnmaskContainer(parent, sentryMaskingOptions)) {
                                            return false;
                                        }
                                    }
                                    cls = view.getClass();
                                    unmaskViewClasses = sentryMaskingOptions.getUnmaskViewClasses();
                                    Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "getUnmaskViewClasses(...)");
                                    if (isAssignableFrom(cls, unmaskViewClasses)) {
                                        return false;
                                    }
                                    Class<?> cls2 = view.getClass();
                                    Set maskViewClasses = sentryMaskingOptions.getMaskViewClasses();
                                    Intrinsics.checkNotNullExpressionValue(maskViewClasses, "getMaskViewClasses(...)");
                                    return isAssignableFrom(cls2, maskViewClasses);
                                }
                            }
                        } else if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "mask")) {
                            if (!isMaskContainer(view, sentryMaskingOptions)) {
                                parent = view.getParent();
                                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                                if (isUnmaskContainer(parent, sentryMaskingOptions)) {
                                    return false;
                                }
                            }
                            cls = view.getClass();
                            unmaskViewClasses = sentryMaskingOptions.getUnmaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "getUnmaskViewClasses(...)");
                            if (isAssignableFrom(cls, unmaskViewClasses)) {
                                return false;
                            }
                            Class<?> cls3 = view.getClass();
                            Set maskViewClasses2 = sentryMaskingOptions.getMaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(maskViewClasses2, "getMaskViewClasses(...)");
                            return isAssignableFrom(cls3, maskViewClasses2);
                        }
                        sentryMaskingOptions.trackCustomMasking();
                        return true;
                    }
                }
            } else if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "unmask")) {
                tag = view.getTag();
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = null;
                }
                if (str != null) {
                    lowerCase = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (lowerCase != null) {
                        if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "mask")) {
                            if (!isMaskContainer(view, sentryMaskingOptions)) {
                                parent = view.getParent();
                                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                                if (isUnmaskContainer(parent, sentryMaskingOptions)) {
                                    return false;
                                }
                            }
                            cls = view.getClass();
                            unmaskViewClasses = sentryMaskingOptions.getUnmaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "getUnmaskViewClasses(...)");
                            if (isAssignableFrom(cls, unmaskViewClasses)) {
                                return false;
                            }
                            Class<?> cls4 = view.getClass();
                            Set maskViewClasses3 = sentryMaskingOptions.getMaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(maskViewClasses3, "getMaskViewClasses(...)");
                            return isAssignableFrom(cls4, maskViewClasses3);
                        }
                    } else if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "mask")) {
                        if (!isMaskContainer(view, sentryMaskingOptions)) {
                            parent = view.getParent();
                            Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                            if (isUnmaskContainer(parent, sentryMaskingOptions)) {
                                return false;
                            }
                        }
                        cls = view.getClass();
                        unmaskViewClasses = sentryMaskingOptions.getUnmaskViewClasses();
                        Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "getUnmaskViewClasses(...)");
                        if (isAssignableFrom(cls, unmaskViewClasses)) {
                            return false;
                        }
                        Class<?> cls5 = view.getClass();
                        Set maskViewClasses4 = sentryMaskingOptions.getMaskViewClasses();
                        Intrinsics.checkNotNullExpressionValue(maskViewClasses4, "getMaskViewClasses(...)");
                        return isAssignableFrom(cls5, maskViewClasses4);
                    }
                } else if (!Intrinsics.areEqual(view.getTag(R$id.sentry_privacy), "mask")) {
                    if (!isMaskContainer(view, sentryMaskingOptions)) {
                        parent = view.getParent();
                        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                        if (isUnmaskContainer(parent, sentryMaskingOptions)) {
                            return false;
                        }
                    }
                    cls = view.getClass();
                    unmaskViewClasses = sentryMaskingOptions.getUnmaskViewClasses();
                    Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "getUnmaskViewClasses(...)");
                    if (isAssignableFrom(cls, unmaskViewClasses)) {
                        return false;
                    }
                    Class<?> cls6 = view.getClass();
                    Set maskViewClasses5 = sentryMaskingOptions.getMaskViewClasses();
                    Intrinsics.checkNotNullExpressionValue(maskViewClasses5, "getMaskViewClasses(...)");
                    return isAssignableFrom(cls6, maskViewClasses5);
                }
                sentryMaskingOptions.trackCustomMasking();
                return true;
            }
            sentryMaskingOptions.trackCustomMasking();
            return false;
        }

        private final boolean isUnmaskContainer(ViewParent viewParent, SentryMaskingOptions sentryMaskingOptions) {
            String unmaskViewContainerClass = sentryMaskingOptions.getUnmaskViewContainerClass();
            if (unmaskViewContainerClass == null) {
                return false;
            }
            return Intrinsics.areEqual(viewParent.getClass().getName(), unmaskViewContainerClass);
        }

        private final boolean isMaskContainer(View view, SentryMaskingOptions sentryMaskingOptions) {
            String maskViewContainerClass = sentryMaskingOptions.getMaskViewContainerClass();
            if (maskViewContainerClass == null) {
                return false;
            }
            return Intrinsics.areEqual(view.getClass().getName(), maskViewContainerClass);
        }

        public final ViewHierarchyNode fromView(View view, ViewHierarchyNode viewHierarchyNode, int i, SentryMaskingOptions options) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(options, "options");
            Pair pairIsVisibleToUser = ViewsKt.isVisibleToUser(view);
            boolean zBooleanValue = ((Boolean) pairIsVisibleToUser.getFirst()).booleanValue();
            Rect rect = (Rect) pairIsVisibleToUser.getSecond();
            boolean z = zBooleanValue && shouldMask(view, options);
            if (view instanceof TextView) {
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                TextView textView = (TextView) view;
                Layout layout = textView.getLayout();
                AndroidTextLayout androidTextLayout = layout != null ? new AndroidTextLayout(layout) : null;
                int opaque = ViewsKt.toOpaque(textView.getCurrentTextColor());
                int totalPaddingLeft = textView.getTotalPaddingLeft();
                int totalPaddingTopSafe = ViewsKt.getTotalPaddingTopSafe(textView);
                float x = textView.getX();
                float y = textView.getY();
                int width = textView.getWidth();
                float elevation = 0.0f;
                int height = textView.getHeight();
                if (viewHierarchyNode != null) {
                    elevation = viewHierarchyNode.getElevation();
                }
                return new TextViewHierarchyNode(androidTextLayout, Integer.valueOf(opaque), totalPaddingLeft, totalPaddingTopSafe, x, y, width, height, elevation + textView.getElevation(), i, viewHierarchyNode, z, true, zBooleanValue, rect);
            }
            if (view instanceof ImageView) {
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                ImageView imageView = (ImageView) view;
                return new ImageViewHierarchyNode(imageView.getX(), imageView.getY(), imageView.getWidth(), imageView.getHeight(), (viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f) + imageView.getElevation(), i, viewHierarchyNode, z && (drawable = imageView.getDrawable()) != null && ViewsKt.isMaskable(drawable), true, zBooleanValue, rect);
            }
            if (view instanceof SurfaceView) {
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                SurfaceView surfaceView = (SurfaceView) view;
                return new SurfaceViewHierarchyNode(new WeakReference(view), surfaceView.getX(), surfaceView.getY(), surfaceView.getWidth(), surfaceView.getHeight(), surfaceView.getElevation() + (viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f), i, viewHierarchyNode, z, true, zBooleanValue, rect);
            }
            return new GenericViewHierarchyNode(view.getX(), view.getY(), view.getWidth(), view.getHeight(), (viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f) + view.getElevation(), i, viewHierarchyNode, z, false, zBooleanValue, rect);
        }
    }
}
