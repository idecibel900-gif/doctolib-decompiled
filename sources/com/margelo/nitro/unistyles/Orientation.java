package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/margelo/nitro/unistyles/Orientation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PORTRAIT", "LANDSCAPE", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum Orientation {
    PORTRAIT(0),
    LANDSCAPE(1);


    @DoNotStrip
    @Keep
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    Orientation(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
