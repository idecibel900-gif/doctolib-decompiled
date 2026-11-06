package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/margelo/nitro/unistyles/UnistyleDependency;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "THEME", "THEMENAME", "ADAPTIVETHEMES", "BREAKPOINTS", "VARIANTS", "COLORSCHEME", "DIMENSIONS", "ORIENTATION", "CONTENTSIZECATEGORY", "INSETS", "PIXELRATIO", "FONTSCALE", "STATUSBAR", "NAVIGATIONBAR", "IME", "RTL", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum UnistyleDependency {
    THEME(0),
    THEMENAME(1),
    ADAPTIVETHEMES(2),
    BREAKPOINTS(3),
    VARIANTS(4),
    COLORSCHEME(5),
    DIMENSIONS(6),
    ORIENTATION(7),
    CONTENTSIZECATEGORY(8),
    INSETS(9),
    PIXELRATIO(10),
    FONTSCALE(11),
    STATUSBAR(12),
    NAVIGATIONBAR(13),
    IME(14),
    RTL(15);


    @DoNotStrip
    @Keep
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    UnistyleDependency(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
