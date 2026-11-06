package com.swmansion.enriched.markdown;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerDelegate;
import com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.swmansion.enriched.markdown.spoiler.SpoilerOverlay;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.common.MarkdownViewManagerUtilsKt;
import com.swmansion.enriched.markdown.utils.text.interaction.TaskListTapUtils;
import com.swmansion.enriched.markdown.utils.text.interaction.TaskListToggleUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = EnrichedMarkdownTextManager.NAME)
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0007\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0017J!\u0010\"\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\u001c\u0010'\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0017J\u001a\u0010)\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020!H\u0017J\u001a\u0010+\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020-H\u0017J\u001a\u0010.\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020!H\u0017J\u001a\u00100\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u00020!H\u0017J\u001a\u00102\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u00103\u001a\u00020!H\u0017J\u001c\u00104\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u00105\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u00106\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\nH\u0017J\u001a\u00107\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u00108\u001a\u00020!H\u0017J\u001c\u00109\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\u001eH\u0017J\u001c\u0010;\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010<\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010=\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u00105\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010>\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010?H\u0017J\u001c\u0010@\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010?H\u0017J\u001c\u0010A\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u001eH\u0017J\u001c\u0010B\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u001eH\u0017J0\u0010C\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$H\u0016J\\\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001e2\u0006\u0010N\u001a\u00020-2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010P2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/swmansion/enriched/markdown/EnrichedMarkdownTextManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/swmansion/enriched/markdown/EnrichedMarkdownText;", "Lcom/facebook/react/viewmanagers/EnrichedMarkdownTextManagerInterface;", "<init>", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onAfterUpdateTransaction", "", "view", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onDropViewInstance", "getExportedCustomDirectEventTypeConstants", "", "setMarkdown", "markdown", "setMarkdownStyle", "style", "Lcom/facebook/react/bridge/ReadableMap;", "setSelectable", "selectable", "", "setSelectionColor", "value", "", "(Lcom/swmansion/enriched/markdown/EnrichedMarkdownText;Ljava/lang/Integer;)V", "setSelectionHandleColor", "setMd4cFlags", "flags", "setAllowFontScaling", "allowFontScaling", "setMaxFontSizeMultiplier", "maxFontSizeMultiplier", "", "setAllowTrailingMargin", "allowTrailingMargin", "setEnableLinkPreview", "enableLinkPreview", "setEnableTaskListItemToggle", "enableTaskListItemToggle", "setLineBreakStrategyIOS", "strategy", "setWritingDirection", "setStreamingAnimation", "streamingAnimation", "setStreamingConfig", "config", "setSpoilerOverlay", "mode", "setTextBreakStrategy", "setContextMenuItems", "Lcom/facebook/react/bridge/ReadableArray;", "setImageRequestHeaders", "setSelectionMenuConfig", "setAccessibilityLabels", "setPadding", "left", "top", "right", "bottom", "measure", "", "context", "Landroid/content/Context;", "localData", "state", "width", "widthMode", "Lcom/facebook/yoga/YogaMeasureMode;", "height", "heightMode", "attachmentsPositions", "", "Companion", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrichedMarkdownTextManager extends SimpleViewManager<EnrichedMarkdownText> implements EnrichedMarkdownTextManagerInterface {
    public static final String NAME = "EnrichedMarkdownText";
    private final ViewManagerDelegate mDelegate = new EnrichedMarkdownTextManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = true, name = "enableLinkPreview")
    public void setEnableLinkPreview(EnrichedMarkdownText view, boolean enableLinkPreview) {
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "lineBreakStrategyIOS")
    public void setLineBreakStrategyIOS(EnrichedMarkdownText view, String strategy) {
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "streamingConfig")
    public void setStreamingConfig(EnrichedMarkdownText view, ReadableMap config) {
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "writingDirection")
    public void setWritingDirection(EnrichedMarkdownText view, String value) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    /* JADX INFO: renamed from: getDelegate, reason: from getter */
    protected ViewManagerDelegate getMDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public EnrichedMarkdownText createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        final EnrichedMarkdownText enrichedMarkdownText = new EnrichedMarkdownText(reactContext, null, 0, 6, null);
        enrichedMarkdownText.setOnContextMenuItemPressCallback(new Function4() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownTextManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EnrichedMarkdownTextManager.createViewInstance$lambda$0(enrichedMarkdownText, (String) obj, (String) obj2, ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
            }
        });
        enrichedMarkdownText.setOnLinkPressCallback(new Function1() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownTextManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnrichedMarkdownTextManager.createViewInstance$lambda$1(enrichedMarkdownText, (String) obj);
            }
        });
        enrichedMarkdownText.setOnLinkLongPressCallback(new Function1() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownTextManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnrichedMarkdownTextManager.createViewInstance$lambda$2(enrichedMarkdownText, (String) obj);
            }
        });
        enrichedMarkdownText.setOnTaskListItemPressCallback(new Function3() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownTextManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EnrichedMarkdownTextManager.createViewInstance$lambda$3(enrichedMarkdownText, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (String) obj3);
            }
        });
        return enrichedMarkdownText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createViewInstance$lambda$0(EnrichedMarkdownText enrichedMarkdownText, String itemText, String selectedText, int i, int i2) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        MarkdownViewManagerUtilsKt.emitContextMenuItemPress(enrichedMarkdownText, itemText, selectedText, i, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createViewInstance$lambda$1(EnrichedMarkdownText enrichedMarkdownText, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MarkdownViewManagerUtilsKt.emitLinkPress(enrichedMarkdownText, url);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createViewInstance$lambda$2(EnrichedMarkdownText enrichedMarkdownText, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MarkdownViewManagerUtilsKt.emitLinkLongPress(enrichedMarkdownText, url);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createViewInstance$lambda$3(EnrichedMarkdownText enrichedMarkdownText, int i, boolean z, String itemText) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        boolean z2 = !z;
        StyleConfig markdownStyle = enrichedMarkdownText.getMarkdownStyle();
        if (markdownStyle != null && TaskListTapUtils.INSTANCE.updateTaskListItemCheckedState(enrichedMarkdownText, i, z2, markdownStyle)) {
            MarkdownViewManagerUtilsKt.emitTaskListItemPress(enrichedMarkdownText, i, z2, itemText);
            return Unit.INSTANCE;
        }
        enrichedMarkdownText.setMarkdownContent(TaskListToggleUtils.INSTANCE.toggleAtIndex(enrichedMarkdownText.getCurrentMarkdown(), i, z2));
        MarkdownViewManagerUtilsKt.emitTaskListItemPress(enrichedMarkdownText, i, z2, itemText);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(EnrichedMarkdownText view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.commitProps();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(EnrichedMarkdownText view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(EnrichedMarkdownText view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance(view);
        MeasurementStore measurementStore = MeasurementStore.INSTANCE;
        measurementStore.clearFontScalingSettings(view.getId());
        measurementStore.clearBreakStrategy(view.getId());
        view.getLayoutManager().releaseMeasurementStore();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MarkdownViewManagerUtilsKt.markdownEventTypeConstants();
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "markdown")
    public void setMarkdown(EnrichedMarkdownText view, String markdown) {
        if (view != null) {
            if (markdown == null) {
                markdown = "";
            }
            view.setMarkdownContent(markdown);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "markdownStyle")
    public void setMarkdownStyle(EnrichedMarkdownText view, ReadableMap style) {
        if (view != null) {
            view.setMarkdownStyle(style);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = true, name = "selectable")
    public void setSelectable(EnrichedMarkdownText view, boolean selectable) {
        if (view != null) {
            view.setIsSelectable(selectable);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    public void setSelectionColor(EnrichedMarkdownText view, Integer value) {
        if (view != null) {
            view.setSelectionColor(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    public void setSelectionHandleColor(EnrichedMarkdownText view, Integer value) {
        if (view != null) {
            view.setSelectionHandleColor(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "md4cFlags")
    public void setMd4cFlags(EnrichedMarkdownText view, ReadableMap flags) {
        if (view != null) {
            view.setMd4cFlags(MarkdownViewManagerUtilsKt.parseMd4cFlags(flags));
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(EnrichedMarkdownText view, boolean allowFontScaling) {
        if (view != null) {
            view.setAllowFontScaling(allowFontScaling);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultFloat = 0.0f, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(EnrichedMarkdownText view, float maxFontSizeMultiplier) {
        if (view != null) {
            view.setMaxFontSizeMultiplier(maxFontSizeMultiplier);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = false, name = "allowTrailingMargin")
    public void setAllowTrailingMargin(EnrichedMarkdownText view, boolean allowTrailingMargin) {
        if (view != null) {
            view.setAllowTrailingMargin(allowTrailingMargin);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = true, name = "enableTaskListItemToggle")
    public void setEnableTaskListItemToggle(EnrichedMarkdownText view, boolean enableTaskListItemToggle) {
        if (view != null) {
            view.setEnableTaskListItemToggle(enableTaskListItemToggle);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(defaultBoolean = false, name = "streamingAnimation")
    public void setStreamingAnimation(EnrichedMarkdownText view, boolean streamingAnimation) {
        if (view != null) {
            view.setStreamingAnimation(streamingAnimation);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "spoilerOverlay")
    public void setSpoilerOverlay(EnrichedMarkdownText view, String mode) {
        if (view != null) {
            view.setSpoilerOverlay(SpoilerOverlay.Companion.fromString(mode));
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(EnrichedMarkdownText view, String strategy) {
        if (view != null) {
            if (strategy == null) {
                strategy = "highQuality";
            }
            view.setTextBreakStrategy(strategy);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "contextMenuItems")
    public void setContextMenuItems(EnrichedMarkdownText view, ReadableArray value) {
        if (view == null) {
            return;
        }
        view.setContextMenuItems(MarkdownViewManagerUtilsKt.parseContextMenuItems(value));
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "imageRequestHeaders")
    public void setImageRequestHeaders(EnrichedMarkdownText view, ReadableArray value) {
        if (view == null) {
            return;
        }
        view.setImageRequestHeaders(MarkdownViewManagerUtilsKt.parseImageRequestHeaders(value));
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "selectionMenuConfig")
    public void setSelectionMenuConfig(EnrichedMarkdownText view, ReadableMap value) {
        if (view == null) {
            return;
        }
        view.setSelectionMenuConfig(MarkdownViewManagerUtilsKt.parseSelectionMenuConfig(value));
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextManagerInterface
    @ReactProp(name = "accessibilityLabels")
    public void setAccessibilityLabels(EnrichedMarkdownText view, ReadableMap value) {
        if (view == null) {
            return;
        }
        view.setAccessibilityLabels(MarkdownViewManagerUtilsKt.parseAccessibilityLabels(value));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(EnrichedMarkdownText view, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setPadding(view, left, top, right, bottom);
        view.setPadding(left, top, right, bottom);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap localData, ReadableMap props, ReadableMap state, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode, float[] attachmentsPositions) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MeasurementStore.INSTANCE.getMeasureById(context, localData != null ? Integer.valueOf(localData.getInt("viewTag")) : null, width, height, heightMode, props, (64 & 64) != 0 ? false : false);
    }
}
