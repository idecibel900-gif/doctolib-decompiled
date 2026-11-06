package com.swmansion.enriched.markdown.views;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextMenuPopup {
    private static PopupWindow activePopup;
    public static final ContextMenuPopup INSTANCE = new ContextMenuPopup();
    private static float density = 1.0f;

    public enum Icon {
        COPY,
        DOCUMENT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    private ContextMenuPopup() {
    }

    public final void dismiss() {
        PopupWindow popupWindow = activePopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public static final class Builder {
        private final List items = new ArrayList();

        public final List getItems$react_native_enriched_markdown_release() {
            return this.items;
        }

        public final void item(Icon icon, String label, Function0 onClick) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.items.add(new MenuItem(icon, label, onClick));
        }
    }

    public static final class MenuItem {
        private final Icon icon;
        private final String label;
        private final Function0 onClick;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MenuItem)) {
                return false;
            }
            MenuItem menuItem = (MenuItem) obj;
            return this.icon == menuItem.icon && Intrinsics.areEqual(this.label, menuItem.label) && Intrinsics.areEqual(this.onClick, menuItem.onClick);
        }

        public int hashCode() {
            return (((this.icon.hashCode() * 31) + this.label.hashCode()) * 31) + this.onClick.hashCode();
        }

        public String toString() {
            return "MenuItem(icon=" + this.icon + ", label=" + this.label + ", onClick=" + this.onClick + ")";
        }

        public MenuItem(Icon icon, String label, Function0 onClick) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.icon = icon;
            this.label = label;
            this.onClick = onClick;
        }

        public final Icon getIcon() {
            return this.icon;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Function0 getOnClick() {
            return this.onClick;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDp(float f) {
        return MathKt.roundToInt(f * density);
    }

    public final void show(View anchor, View parent, Function1 block) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(block, "block");
        PopupWindow popupWindow = activePopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Context context = anchor.getContext();
        density = context.getResources().getDisplayMetrics().density;
        Builder builder = new Builder();
        block.invoke(builder);
        if (builder.getItems$react_native_enriched_markdown_release().isEmpty()) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ContextMenuPopup contextMenuPopup = INSTANCE;
        linearLayout.setElevation(contextMenuPopup.getDp(12.0f));
        linearLayout.setPadding(contextMenuPopup.getDp(4.0f), contextMenuPopup.getDp(12.0f), contextMenuPopup.getDp(4.0f), contextMenuPopup.getDp(12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(contextMenuPopup.getDp(14.0f));
        linearLayout.setBackground(gradientDrawable);
        int i = 0;
        for (Object obj : builder.getItems$react_native_enriched_markdown_release()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MenuItem menuItem = (MenuItem) obj;
            if (i > 0) {
                ContextMenuPopup contextMenuPopup2 = INSTANCE;
                Intrinsics.checkNotNull(context);
                linearLayout.addView(contextMenuPopup2.createDivider(context));
            }
            ContextMenuPopup contextMenuPopup3 = INSTANCE;
            Intrinsics.checkNotNull(context);
            linearLayout.addView(contextMenuPopup3.createMenuItemView(context, menuItem));
            i = i2;
        }
        PopupWindow popupWindow2 = new PopupWindow((View) linearLayout, -2, -2, true);
        popupWindow2.setElevation(INSTANCE.getDp(24.0f));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.swmansion.enriched.markdown.views.ContextMenuPopup$$ExternalSyntheticLambda0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ContextMenuPopup.activePopup = null;
            }
        });
        linearLayout.measure(0, 0);
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int width = iArr[0] + (anchor.getWidth() / 2);
        int i3 = iArr[1];
        int i4 = context.getResources().getDisplayMetrics().widthPixels;
        int dp = getDp(8.0f);
        int iCoerceIn = RangesKt.coerceIn(width - (linearLayout.getMeasuredWidth() / 2), dp, (i4 - linearLayout.getMeasuredWidth()) - dp);
        int iCoerceAtLeast = RangesKt.coerceAtLeast((i3 - linearLayout.getMeasuredHeight()) - dp, dp);
        activePopup = popupWindow2;
        popupWindow2.showAtLocation(parent, 0, iCoerceIn, iCoerceAtLeast);
    }

    private final LinearLayout createMenuItemView(Context context, final MenuItem menuItem) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ContextMenuPopup contextMenuPopup = INSTANCE;
        linearLayout.setPadding(contextMenuPopup.getDp(16.0f), 0, contextMenuPopup.getDp(16.0f), 0);
        linearLayout.setMinimumHeight(contextMenuPopup.getDp(48.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        linearLayout.setForeground(context.getDrawable(typedValue.resourceId));
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(contextMenuPopup.createIconDrawable(menuItem.getIcon()));
        imageView.setColorFilter(Color.parseColor("#333333"));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(contextMenuPopup.getDp(20.0f), contextMenuPopup.getDp(20.0f)));
        TextView textView = new TextView(context);
        textView.setText(menuItem.getLabel());
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.parseColor("#1C1C1E"));
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(contextMenuPopup.getDp(12.0f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.swmansion.enriched.markdown.views.ContextMenuPopup$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContextMenuPopup.createMenuItemView$lambda$10$lambda$9(menuItem, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMenuItemView$lambda$10$lambda$9(MenuItem menuItem, View view) {
        menuItem.getOnClick().invoke();
        INSTANCE.dismiss();
    }

    private final View createDivider(Context context) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#E5E5EA"));
        ContextMenuPopup contextMenuPopup = INSTANCE;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, RangesKt.coerceAtLeast(contextMenuPopup.getDp(1.0f), 1));
        layoutParams.setMargins(contextMenuPopup.getDp(16.0f), 0, contextMenuPopup.getDp(16.0f), 0);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private final Drawable createIconDrawable(final Icon icon) {
        return new Drawable() { // from class: com.swmansion.enriched.markdown.views.ContextMenuPopup.createIconDrawable.1
            private final CopyGlyph copyGlyph;
            private final Paint paint;

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -3;
            }

            {
                Paint paint = new Paint(1);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(ContextMenuPopup.density * 1.5f);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setColor(Color.parseColor("#333333"));
                this.paint = paint;
                this.copyGlyph = new CopyGlyph();
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                float fWidth = getBounds().width() / 24.0f;
                if (icon == Icon.COPY) {
                    this.copyGlyph.draw(canvas, getBounds().width(), this.paint);
                    return;
                }
                float f = 2.5f * fWidth;
                canvas.drawRoundRect(new RectF(5 * fWidth, 3 * fWidth, 19 * fWidth, 21 * fWidth), f, f, this.paint);
                float f2 = fWidth * 8.5f;
                float f3 = 9 * fWidth;
                float f4 = fWidth * 15.5f;
                canvas.drawLine(f2, f3, f4, f3, this.paint);
                float f5 = fWidth * 12.5f;
                canvas.drawLine(f2, f5, f4, f5, this.paint);
                float f6 = 16 * fWidth;
                canvas.drawLine(f2, f6, 13 * fWidth, f6, this.paint);
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicWidth() {
                return ContextMenuPopup.INSTANCE.getDp(24.0f);
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicHeight() {
                return ContextMenuPopup.INSTANCE.getDp(24.0f);
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
                this.paint.setAlpha(i);
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
                this.paint.setColorFilter(colorFilter);
            }
        };
    }
}
