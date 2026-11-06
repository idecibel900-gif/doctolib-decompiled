package com.swmansion.enriched.markdown.utils.text.view;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.TextView;
import com.swmansion.enriched.markdown.EnrichedMarkdown;
import com.swmansion.enriched.markdown.EnrichedMarkdownManager;
import com.swmansion.enriched.markdown.EnrichedMarkdownText;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.common.layout.RTLUtilsKt;
import com.swmansion.enriched.markdown.utils.text.conversion.HTMLGenerator;
import com.swmansion.enriched.markdown.utils.text.conversion.MarkdownExtractor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SelectionActionModeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUrlsTitle(SelectionMenuConfig selectionMenuConfig, int i) {
        String copyImageUrlsLabel;
        if (!selectionMenuConfig.getCopyImageUrlPluralTemplates().isEmpty() && i >= 0 && i < 101) {
            copyImageUrlsLabel = (String) selectionMenuConfig.getCopyImageUrlPluralTemplates().get(i);
        } else if (i == 1) {
            copyImageUrlsLabel = selectionMenuConfig.getCopyImageUrlLabel();
        } else {
            copyImageUrlsLabel = selectionMenuConfig.getCopyImageUrlsLabel();
        }
        return StringsKt.replace$default(copyImageUrlsLabel, "{count}", String.valueOf(i), false, 4, (Object) null);
    }

    public static /* synthetic */ ActionMode.Callback createSelectionActionModeCallback$default(TextView textView, Function0 function0, Function0 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.swmansion.enriched.markdown.utils.text.view.SelectionActionModeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsKt.emptyList();
                }
            };
        }
        if ((i & 4) != 0) {
            function1 = new Function0() { // from class: com.swmansion.enriched.markdown.utils.text.view.SelectionActionModeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SelectionActionModeKt.createSelectionActionModeCallback$lambda$1();
                }
            };
        }
        if ((i & 8) != 0) {
            function4 = new Function4() { // from class: com.swmansion.enriched.markdown.utils.text.view.SelectionActionModeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return SelectionActionModeKt.createSelectionActionModeCallback$lambda$2((String) obj2, (String) obj3, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                }
            };
        }
        return createSelectionActionModeCallback(textView, function0, function1, function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectionMenuConfig createSelectionActionModeCallback$lambda$1() {
        return new SelectionMenuConfig(false, false, null, null, null, null, null, 127, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSelectionActionModeCallback$lambda$2(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final ActionMode.Callback createSelectionActionModeCallback(final TextView textView, final Function0 getCustomItemTexts, final Function0 getSelectionMenuConfig, final Function4 onCustomItemPress) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(getCustomItemTexts, "getCustomItemTexts");
        Intrinsics.checkNotNullParameter(getSelectionMenuConfig, "getSelectionMenuConfig");
        Intrinsics.checkNotNullParameter(onCustomItemPress, "onCustomItemPress");
        return new ActionMode.Callback() { // from class: com.swmansion.enriched.markdown.utils.text.view.SelectionActionModeKt.createSelectionActionModeCallback.4
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                List listEmptyList;
                MenuItem menuItemFindItem;
                if (menu == null) {
                    return false;
                }
                menu.removeItem(1000);
                menu.removeItem(1001);
                menu.removeGroup(2001);
                SelectionMenuConfig selectionMenuConfig = (SelectionMenuConfig) getSelectionMenuConfig.invoke();
                if (selectionMenuConfig.getCopyLabel().length() > 0 && (menuItemFindItem = menu.findItem(R.id.copy)) != null) {
                    menuItemFindItem.setTitle(selectionMenuConfig.getCopyLabel());
                }
                if (selectionMenuConfig.getCopyAsMarkdown() && textView.getSelectionStart() >= 0 && textView.getSelectionEnd() > textView.getSelectionStart()) {
                    menu.add(0, 1000, 0, selectionMenuConfig.getCopyAsMarkdownLabel());
                }
                if (textView.getSelectionStart() >= 0 && textView.getSelectionEnd() > textView.getSelectionStart()) {
                    int i = 0;
                    for (Object obj : (List) getCustomItemTexts.invoke()) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        menu.add(2001, i + 2000, i, (String) obj).setShowAsAction(2);
                        i = i2;
                    }
                }
                if (selectionMenuConfig.getCopyImageUrl()) {
                    listEmptyList = SelectionActionModeKt.getImageUrlsInSelection(textView);
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                if (listEmptyList.isEmpty()) {
                    return true;
                }
                menu.add(0, 1001, 0, SelectionActionModeKt.imageUrlsTitle(selectionMenuConfig, listEmptyList.size()));
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                String string;
                if (menuItem == null) {
                    return false;
                }
                int itemId = menuItem.getItemId();
                if (itemId == 1000) {
                    SelectionActionModeKt.copyMarkdownToClipboard(textView);
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                    return true;
                }
                if (itemId == 1001) {
                    SelectionActionModeKt.copyImageUrlsToClipboard(textView);
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                    return true;
                }
                if (itemId == 16908321) {
                    SelectionActionModeKt.copyWithHTML(textView);
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                    return true;
                }
                List list = (List) getCustomItemTexts.invoke();
                int i = itemId - 2000;
                if (i < 0 || i >= list.size()) {
                    return false;
                }
                int selectionStart = textView.getSelectionStart();
                int selectionEnd = textView.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd <= selectionStart) {
                    string = "";
                } else {
                    CharSequence text = textView.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                    string = text.subSequence(selectionStart, selectionEnd).toString();
                }
                onCustomItemPress.invoke(list.get(i), string, Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd));
                if (actionMode != null) {
                    actionMode.finish();
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyWithHTML(TextView textView) {
        StyleConfig styleConfigFindParentMarkdownStyle;
        int selectionStart = textView.getSelectionStart();
        int selectionEnd = textView.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0 || selectionStart >= selectionEnd) {
            return;
        }
        CharSequence text = textView.getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return;
        }
        CharSequence charSequenceSubSequence = spannable.subSequence(selectionStart, selectionEnd);
        String string = charSequenceSubSequence.toString();
        EnrichedMarkdownText enrichedMarkdownText = textView instanceof EnrichedMarkdownText ? (EnrichedMarkdownText) textView : null;
        if (enrichedMarkdownText == null || (styleConfigFindParentMarkdownStyle = enrichedMarkdownText.getMarkdownStyle()) == null) {
            styleConfigFindParentMarkdownStyle = findParentMarkdownStyle(textView);
        }
        StyleConfig styleConfig = styleConfigFindParentMarkdownStyle;
        Object systemService = textView.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (styleConfig != null && (charSequenceSubSequence instanceof Spannable)) {
            DisplayMetrics displayMetrics = textView.getContext().getResources().getDisplayMetrics();
            Resources resources = textView.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            clipboardManager.setPrimaryClip(ClipData.newHtmlText(EnrichedMarkdownManager.NAME, string, HTMLGenerator.INSTANCE.generateHTML((Spannable) charSequenceSubSequence, styleConfig, displayMetrics.scaledDensity, displayMetrics.density, RTLUtilsKt.isLayoutRTL(resources))));
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Text", string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyMarkdownToClipboard(TextView textView) {
        String markdownForSelection = MarkdownExtractor.INSTANCE.getMarkdownForSelection(textView);
        if (markdownForSelection == null) {
            return;
        }
        Object systemService = textView.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Markdown", markdownForSelection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getImageUrlsInSelection(TextView textView) {
        int selectionStart = textView.getSelectionStart();
        int selectionEnd = textView.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0 || selectionStart >= selectionEnd) {
            return CollectionsKt.emptyList();
        }
        CharSequence text = textView.getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return CollectionsKt.emptyList();
        }
        Object[] spans = spannable.getSpans(selectionStart, selectionEnd, ImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            String imageUrl = ((ImageSpan) obj).getImageUrl();
            if (imageUrl != null) {
                arrayList.add(imageUrl);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            String str = (String) obj2;
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyImageUrlsToClipboard(TextView textView) {
        List imageUrlsInSelection = getImageUrlsInSelection(textView);
        if (imageUrlsInSelection.isEmpty()) {
            return;
        }
        Object systemService = textView.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Image URLs", CollectionsKt.joinToString$default(imageUrlsInSelection, "\n", null, null, 0, null, null, 62, null)));
    }

    private static final StyleConfig findParentMarkdownStyle(TextView textView) {
        for (ViewParent parent = textView.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof EnrichedMarkdown) {
                return ((EnrichedMarkdown) parent).getMarkdownStyle();
            }
        }
        return null;
    }
}
