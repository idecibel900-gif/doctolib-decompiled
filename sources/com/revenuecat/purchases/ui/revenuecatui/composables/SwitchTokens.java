package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0019\u0010$\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0011\u0010&\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0019\u0010,\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0019\u0010.\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0011\u00100\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0019\u00102\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010 R\u0011\u00104\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0019\u00108\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b9\u0010 R\u0011\u0010:\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchTokens;", "", "()V", "DisabledSelectedHandleColor", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ColorSchemeKeyTokens;", "getDisabledSelectedHandleColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/ColorSchemeKeyTokens;", "DisabledSelectedHandleOpacity", "", "DisabledSelectedIconColor", "getDisabledSelectedIconColor", "DisabledSelectedIconOpacity", "DisabledSelectedTrackColor", "getDisabledSelectedTrackColor", "DisabledTrackOpacity", "DisabledUnselectedHandleColor", "getDisabledUnselectedHandleColor", "DisabledUnselectedHandleOpacity", "DisabledUnselectedIconColor", "getDisabledUnselectedIconColor", "DisabledUnselectedIconOpacity", "DisabledUnselectedTrackColor", "getDisabledUnselectedTrackColor", "DisabledUnselectedTrackOutlineColor", "getDisabledUnselectedTrackOutlineColor", "HandleShape", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ShapeKeyTokens;", "getHandleShape", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/ShapeKeyTokens;", "PressedHandleWidth", "Landroidx/compose/ui/unit/Dp;", "getPressedHandleWidth-D9Ej5fM", "()F", "F", "SelectedHandleColor", "getSelectedHandleColor", "SelectedHandleWidth", "getSelectedHandleWidth-D9Ej5fM", "SelectedIconColor", "getSelectedIconColor", "SelectedTrackColor", "getSelectedTrackColor", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "TrackHeight", "getTrackHeight-D9Ej5fM", "TrackOutlineWidth", "getTrackOutlineWidth-D9Ej5fM", "TrackShape", "getTrackShape", "TrackWidth", "getTrackWidth-D9Ej5fM", "UnselectedFocusTrackOutlineColor", "getUnselectedFocusTrackOutlineColor", "UnselectedHandleColor", "getUnselectedHandleColor", "UnselectedHandleWidth", "getUnselectedHandleWidth-D9Ej5fM", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedTrackColor", "getUnselectedTrackColor", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SwitchTokens {
    public static final float DisabledSelectedHandleOpacity = 1.0f;
    private static final ColorSchemeKeyTokens DisabledSelectedIconColor;
    public static final float DisabledSelectedIconOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledSelectedTrackColor;
    public static final float DisabledTrackOpacity = 0.12f;
    private static final ColorSchemeKeyTokens DisabledUnselectedHandleColor;
    public static final float DisabledUnselectedHandleOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledUnselectedIconColor;
    public static final float DisabledUnselectedIconOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledUnselectedTrackColor;
    private static final ColorSchemeKeyTokens DisabledUnselectedTrackOutlineColor;
    private static final ShapeKeyTokens HandleShape;
    private static final float PressedHandleWidth;
    private static final ColorSchemeKeyTokens SelectedHandleColor;
    private static final float SelectedHandleWidth;
    private static final ColorSchemeKeyTokens SelectedIconColor;
    private static final ColorSchemeKeyTokens SelectedTrackColor;
    private static final float StateLayerSize;
    private static final float TrackHeight;
    private static final float TrackOutlineWidth;
    private static final ShapeKeyTokens TrackShape;
    private static final float TrackWidth;
    private static final ColorSchemeKeyTokens UnselectedFocusTrackOutlineColor;
    private static final ColorSchemeKeyTokens UnselectedHandleColor;
    private static final float UnselectedHandleWidth;
    private static final ColorSchemeKeyTokens UnselectedIconColor;
    private static final ColorSchemeKeyTokens UnselectedTrackColor;
    public static final SwitchTokens INSTANCE = new SwitchTokens();
    private static final ColorSchemeKeyTokens DisabledSelectedHandleColor = ColorSchemeKeyTokens.Surface;

    private SwitchTokens() {
    }

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        DisabledSelectedIconColor = colorSchemeKeyTokens;
        DisabledSelectedTrackColor = colorSchemeKeyTokens;
        DisabledUnselectedHandleColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.SurfaceContainerHighest;
        DisabledUnselectedIconColor = colorSchemeKeyTokens2;
        DisabledUnselectedTrackColor = colorSchemeKeyTokens2;
        DisabledUnselectedTrackOutlineColor = colorSchemeKeyTokens;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        HandleShape = shapeKeyTokens;
        PressedHandleWidth = Dp.m2551constructorimpl((float) 28.0d);
        SelectedHandleColor = ColorSchemeKeyTokens.OnPrimary;
        SelectedHandleWidth = Dp.m2551constructorimpl((float) 24.0d);
        SelectedIconColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        SelectedTrackColor = ColorSchemeKeyTokens.Primary;
        StateLayerSize = Dp.m2551constructorimpl((float) 40.0d);
        TrackHeight = Dp.m2551constructorimpl((float) 32.0d);
        TrackOutlineWidth = Dp.m2551constructorimpl((float) 2.0d);
        TrackShape = shapeKeyTokens;
        TrackWidth = Dp.m2551constructorimpl((float) 52.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.Outline;
        UnselectedFocusTrackOutlineColor = colorSchemeKeyTokens3;
        UnselectedHandleColor = colorSchemeKeyTokens3;
        UnselectedHandleWidth = Dp.m2551constructorimpl((float) 16.0d);
        UnselectedIconColor = colorSchemeKeyTokens2;
        UnselectedTrackColor = colorSchemeKeyTokens2;
    }

    public final ColorSchemeKeyTokens getDisabledSelectedHandleColor() {
        return DisabledSelectedHandleColor;
    }

    public final ColorSchemeKeyTokens getDisabledSelectedIconColor() {
        return DisabledSelectedIconColor;
    }

    public final ColorSchemeKeyTokens getDisabledSelectedTrackColor() {
        return DisabledSelectedTrackColor;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedHandleColor() {
        return DisabledUnselectedHandleColor;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedIconColor() {
        return DisabledUnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedTrackColor() {
        return DisabledUnselectedTrackColor;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedTrackOutlineColor() {
        return DisabledUnselectedTrackOutlineColor;
    }

    public final ShapeKeyTokens getHandleShape() {
        return HandleShape;
    }

    /* JADX INFO: renamed from: getPressedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m4288getPressedHandleWidthD9Ej5fM() {
        return PressedHandleWidth;
    }

    public final ColorSchemeKeyTokens getSelectedHandleColor() {
        return SelectedHandleColor;
    }

    /* JADX INFO: renamed from: getSelectedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m4289getSelectedHandleWidthD9Ej5fM() {
        return SelectedHandleWidth;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedTrackColor() {
        return SelectedTrackColor;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m4290getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    /* JADX INFO: renamed from: getTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m4291getTrackHeightD9Ej5fM() {
        return TrackHeight;
    }

    /* JADX INFO: renamed from: getTrackOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m4292getTrackOutlineWidthD9Ej5fM() {
        return TrackOutlineWidth;
    }

    public final ShapeKeyTokens getTrackShape() {
        return TrackShape;
    }

    /* JADX INFO: renamed from: getTrackWidth-D9Ej5fM, reason: not valid java name */
    public final float m4293getTrackWidthD9Ej5fM() {
        return TrackWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusTrackOutlineColor() {
        return UnselectedFocusTrackOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHandleColor() {
        return UnselectedHandleColor;
    }

    /* JADX INFO: renamed from: getUnselectedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m4294getUnselectedHandleWidthD9Ej5fM() {
        return UnselectedHandleWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return UnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedTrackColor() {
        return UnselectedTrackColor;
    }
}
