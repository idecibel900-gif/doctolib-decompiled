package com.unistyles;

import com.margelo.nitro.unistyles.Dimensions;
import com.margelo.nitro.unistyles.Insets;
import com.margelo.nitro.unistyles.UnistyleDependency;
import com.margelo.nitro.unistyles.UnistylesNativeMiniRuntime;
import com.opentok.android.PublisherKit;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"isEqualTo", "", "Lcom/margelo/nitro/unistyles/Dimensions;", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "Lcom/margelo/nitro/unistyles/Insets;", "diffMiniRuntimes", "", "Lcom/margelo/nitro/unistyles/UnistyleDependency;", "Lcom/unistyles/NativePlatformAndroid;", "lhs", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "rhs", "(Lcom/unistyles/NativePlatformAndroid;Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;)[Lcom/margelo/nitro/unistyles/UnistyleDependency;", "react-native-unistyles_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EquatableKt {
    public static final boolean isEqualTo(Dimensions dimensions, Dimensions other) {
        Intrinsics.checkNotNullParameter(dimensions, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return dimensions.getWidth() == other.getWidth() && dimensions.getHeight() == other.getHeight();
    }

    public static final boolean isEqualTo(Insets insets, Insets other) {
        Intrinsics.checkNotNullParameter(insets, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return insets.getTop() == other.getTop() && insets.getBottom() == other.getBottom() && insets.getLeft() == other.getLeft() && insets.getRight() == other.getRight();
    }

    public static final UnistyleDependency[] diffMiniRuntimes(NativePlatformAndroid nativePlatformAndroid, UnistylesNativeMiniRuntime lhs, UnistylesNativeMiniRuntime rhs) {
        Intrinsics.checkNotNullParameter(nativePlatformAndroid, "<this>");
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        ArrayList arrayList = new ArrayList();
        if (lhs.getColorScheme() != rhs.getColorScheme()) {
            arrayList.add(UnistyleDependency.COLORSCHEME);
        }
        if (!isEqualTo(lhs.getScreen(), rhs.getScreen())) {
            arrayList.add(UnistyleDependency.DIMENSIONS);
        }
        if (lhs.getScreen().getWidth() != rhs.getScreen().getWidth()) {
            arrayList.add(UnistyleDependency.BREAKPOINTS);
        }
        if (lhs.isPortrait() != rhs.isPortrait()) {
            arrayList.add(UnistyleDependency.ORIENTATION);
        }
        if (!Intrinsics.areEqual(lhs.getContentSizeCategory(), rhs.getContentSizeCategory())) {
            arrayList.add(UnistyleDependency.CONTENTSIZECATEGORY);
        }
        if (!isEqualTo(lhs.getInsets(), rhs.getInsets())) {
            arrayList.add(UnistyleDependency.INSETS);
        }
        if (lhs.getFontScale() != rhs.getFontScale()) {
            arrayList.add(UnistyleDependency.FONTSCALE);
        }
        if (!isEqualTo(lhs.getStatusBar(), rhs.getStatusBar())) {
            arrayList.add(UnistyleDependency.STATUSBAR);
        }
        if (!isEqualTo(lhs.getNavigationBar(), rhs.getNavigationBar())) {
            arrayList.add(UnistyleDependency.NAVIGATIONBAR);
        }
        if (lhs.getRtl() != rhs.getRtl()) {
            arrayList.add(UnistyleDependency.RTL);
        }
        return (UnistyleDependency[]) arrayList.toArray(new UnistyleDependency[0]);
    }
}
