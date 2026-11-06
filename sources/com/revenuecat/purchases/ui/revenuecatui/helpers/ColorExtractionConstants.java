package com.revenuecat.purchases.ui.revenuecatui.helpers;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ColorExtractionConstants;", "", "()V", "ALPHA_CHANNEL_SHIFT", "", "COLOR_COMPONENT_MASK", "COLOR_QUANTIZATION_DIVISOR", "GREEN_CHANNEL_SHIFT", "MAXIMUM_BRIGHTNESS_THRESHOLD", "MAX_PIXEL_SAMPLES", "MINIMUM_ALPHA_THRESHOLD", "MINIMUM_BRIGHTNESS_THRESHOLD", "MINIMUM_COLOR_DISTANCE", "", "MINIMUM_DISTANCE_FROM_BLACK_WHITE", "RED_CHANNEL_SHIFT", "RGB_NORMALIZATION_DIVISOR", "WCAG_BLUE_LUMINANCE_WEIGHT", "WCAG_COMPONENT_THRESHOLD", "", "WCAG_CONTRAST_OFFSET", "WCAG_GAMMA_EXPONENT", "WCAG_GAMMA_OFFSET", "WCAG_GAMMA_SCALE", "WCAG_GREEN_LUMINANCE_WEIGHT", "WCAG_LINEAR_COMPONENT_DIVISOR", "WCAG_RED_LUMINANCE_WEIGHT", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorExtractionConstants {
    public static final int $stable = 0;
    public static final int ALPHA_CHANNEL_SHIFT = 24;
    public static final int COLOR_COMPONENT_MASK = 255;
    public static final int COLOR_QUANTIZATION_DIVISOR = 16;
    public static final int GREEN_CHANNEL_SHIFT = 8;
    public static final ColorExtractionConstants INSTANCE = new ColorExtractionConstants();
    public static final int MAXIMUM_BRIGHTNESS_THRESHOLD = 700;
    public static final int MAX_PIXEL_SAMPLES = 10000;
    public static final int MINIMUM_ALPHA_THRESHOLD = 128;
    public static final int MINIMUM_BRIGHTNESS_THRESHOLD = 50;
    public static final double MINIMUM_COLOR_DISTANCE = 0.25d;
    public static final double MINIMUM_DISTANCE_FROM_BLACK_WHITE = 0.3d;
    public static final int RED_CHANNEL_SHIFT = 16;
    public static final double RGB_NORMALIZATION_DIVISOR = 255.0d;
    public static final double WCAG_BLUE_LUMINANCE_WEIGHT = 0.0722d;
    public static final float WCAG_COMPONENT_THRESHOLD = 0.03928f;
    public static final double WCAG_CONTRAST_OFFSET = 0.05d;
    public static final double WCAG_GAMMA_EXPONENT = 2.4d;
    public static final double WCAG_GAMMA_OFFSET = 0.055d;
    public static final double WCAG_GAMMA_SCALE = 1.055d;
    public static final double WCAG_GREEN_LUMINANCE_WEIGHT = 0.7152d;
    public static final double WCAG_LINEAR_COMPONENT_DIVISOR = 12.92d;
    public static final double WCAG_RED_LUMINANCE_WEIGHT = 0.2126d;

    private ColorExtractionConstants() {
    }
}
