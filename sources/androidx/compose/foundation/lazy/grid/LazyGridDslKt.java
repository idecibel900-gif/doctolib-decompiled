package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridDslKt {
    /* JADX WARN: Code duplicated, block: B:102:0x0117  */
    /* JADX WARN: Code duplicated, block: B:104:0x011c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0120  */
    /* JADX WARN: Code duplicated, block: B:108:0x0128  */
    /* JADX WARN: Code duplicated, block: B:109:0x012b  */
    /* JADX WARN: Code duplicated, block: B:113:0x013b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0153  */
    /* JADX WARN: Code duplicated, block: B:119:0x0160  */
    /* JADX WARN: Code duplicated, block: B:133:0x0188 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:137:0x0194  */
    /* JADX WARN: Code duplicated, block: B:139:0x019e  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:154:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:157:0x01db  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:164:0x0247  */
    /* JADX WARN: Code duplicated, block: B:168:0x025e  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0060  */
    /* JADX WARN: Code duplicated, block: B:39:0x0065  */
    /* JADX WARN: Code duplicated, block: B:41:0x0069  */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:44:0x0074  */
    /* JADX WARN: Code duplicated, block: B:48:0x007b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0080  */
    /* JADX WARN: Code duplicated, block: B:52:0x0084  */
    /* JADX WARN: Code duplicated, block: B:54:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x008f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0098  */
    /* JADX WARN: Code duplicated, block: B:61:0x009c  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00db  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0100  */
    /* JADX WARN: Code duplicated, block: B:97:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x010d  */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        LazyGridState lazyGridStateRememberLazyGridState;
        int i4;
        PaddingValues paddingValuesM305PaddingValues0680j_4;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        int i9;
        Arrangement.Horizontal start;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z4;
        FlingBehavior flingBehavior2;
        boolean z5;
        FlingBehavior flingBehavior3;
        boolean z6;
        Arrangement arrangement;
        Arrangement.Vertical bottom;
        Composer composer2;
        final Modifier modifier3;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z7;
        final FlingBehavior flingBehavior4;
        final boolean z8;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1485410512);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                    int i15 = composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
                    i3 |= i15;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                i3 |= i15;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    paddingValuesM305PaddingValues0680j_4 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValuesM305PaddingValues0680j_4)) {
                        i5 = 2048;
                    } else {
                        i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & 196608) == 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            int i16 = composerStartRestartGroup.changed(vertical2) ? 131072 : 65536;
                            i3 |= i16;
                        } else {
                            vertical2 = vertical;
                        }
                        i3 |= i16;
                    } else {
                        vertical2 = vertical;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        i9 = 196608;
                        start = horizontal;
                    } else {
                        i9 = 196608;
                        start = horizontal;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(start)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                    if (i11 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(z2)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i3 |= i12;
                        }
                        if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changedInstance(function1)) {
                                    i13 = 536870912;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            if ((i3 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i14 != 0) {
                                        modifier2 = Modifier.Companion;
                                    }
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    }
                                    if (i4 != 0) {
                                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                    }
                                    z4 = i6 == 0 ? z3 : false;
                                    if ((i2 & 32) != 0) {
                                        arrangement = Arrangement.INSTANCE;
                                        if (z4) {
                                            bottom = arrangement.getBottom();
                                        } else {
                                            bottom = arrangement.getTop();
                                        }
                                        i3 &= -458753;
                                        vertical2 = bottom;
                                    }
                                    if (i8 != 0) {
                                        start = Arrangement.INSTANCE.getStart();
                                    }
                                    if ((i2 & 128) != 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                    }
                                    if (i11 != 0) {
                                        flingBehavior3 = flingBehavior2;
                                        z6 = z4;
                                        z5 = true;
                                    } else {
                                        z5 = z2;
                                        flingBehavior3 = flingBehavior2;
                                        z6 = z4;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    flingBehavior3 = flingBehavior;
                                    z5 = z2;
                                    z6 = z3;
                                }
                                Arrangement.Horizontal horizontal3 = start;
                                Arrangement.Vertical vertical4 = vertical2;
                                Modifier modifier4 = modifier2;
                                LazyGridState lazyGridState3 = lazyGridStateRememberLazyGridState;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                                }
                                int i17 = i3 >> 3;
                                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums = rememberColumnWidthSums(gridCells, horizontal3, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17 & 896));
                                int i18 = (i17 & 14) | i9 | (i17 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i17) | (i17 & 29360128);
                                int i19 = i3 << 9;
                                composer2 = composerStartRestartGroup;
                                PaddingValues paddingValues3 = paddingValuesM305PaddingValues0680j_4;
                                LazyGridKt.LazyGrid(modifier4, lazyGridState3, lazyGridSlotsProviderRememberColumnWidthSums, paddingValues3, z6, true, flingBehavior3, z5, vertical4, horizontal3, function1, composer2, i18 | (234881024 & i19) | (i19 & 1879048192), (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                lazyGridState2 = lazyGridState3;
                                paddingValues2 = paddingValues3;
                                z7 = z6;
                                flingBehavior4 = flingBehavior3;
                                z8 = z5;
                                vertical3 = vertical4;
                                horizontal2 = horizontal3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z8 = z2;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier2;
                                lazyGridState2 = lazyGridStateRememberLazyGridState;
                                paddingValues2 = paddingValuesM305PaddingValues0680j_4;
                                z7 = z3;
                                horizontal2 = start;
                                vertical3 = vertical2;
                                flingBehavior4 = flingBehavior;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i20) {
                                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        if ((i3 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal4 = start;
                            Arrangement.Vertical vertical5 = vertical2;
                            Modifier modifier5 = modifier2;
                            LazyGridState lazyGridState4 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i110 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums2 = rememberColumnWidthSums(gridCells, horizontal4, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i110 & 896));
                            int i111 = (i110 & 14) | i9 | (i110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i110) | (i110 & 29360128);
                            int i112 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues4 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier5, lazyGridState4, lazyGridSlotsProviderRememberColumnWidthSums2, paddingValues4, z6, true, flingBehavior3, z5, vertical5, horizontal4, function1, composer2, i111 | (234881024 & i112) | (i112 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier5;
                            lazyGridState2 = lazyGridState4;
                            paddingValues2 = paddingValues4;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical5;
                            horizontal2 = horizontal4;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal5 = start;
                            Arrangement.Vertical vertical6 = vertical2;
                            Modifier modifier6 = modifier2;
                            LazyGridState lazyGridState5 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i113 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums3 = rememberColumnWidthSums(gridCells, horizontal5, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i113 & 896));
                            int i114 = (i113 & 14) | i9 | (i113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i113) | (i113 & 29360128);
                            int i115 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues5 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier6, lazyGridState5, lazyGridSlotsProviderRememberColumnWidthSums3, paddingValues5, z6, true, flingBehavior3, z5, vertical6, horizontal5, function1, composer2, i114 | (234881024 & i115) | (i115 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier6;
                            lazyGridState2 = lazyGridState5;
                            paddingValues2 = paddingValues5;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical6;
                            horizontal2 = horizontal5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i13 = 536870912;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal6 = start;
                            Arrangement.Vertical vertical7 = vertical2;
                            Modifier modifier7 = modifier2;
                            LazyGridState lazyGridState6 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i116 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums4 = rememberColumnWidthSums(gridCells, horizontal6, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i116 & 896));
                            int i117 = (i116 & 14) | i9 | (i116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i116) | (i116 & 29360128);
                            int i118 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues6 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier7, lazyGridState6, lazyGridSlotsProviderRememberColumnWidthSums4, paddingValues6, z6, true, flingBehavior3, z5, vertical7, horizontal6, function1, composer2, i117 | (234881024 & i118) | (i118 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier7;
                            lazyGridState2 = lazyGridState6;
                            paddingValues2 = paddingValues6;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical7;
                            horizontal2 = horizontal6;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal7 = start;
                            Arrangement.Vertical vertical8 = vertical2;
                            Modifier modifier8 = modifier2;
                            LazyGridState lazyGridState7 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i119 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums5 = rememberColumnWidthSums(gridCells, horizontal7, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i119 & 896));
                            int i1110 = (i119 & 14) | i9 | (i119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i119) | (i119 & 29360128);
                            int i1111 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues7 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier8, lazyGridState7, lazyGridSlotsProviderRememberColumnWidthSums5, paddingValues7, z6, true, flingBehavior3, z5, vertical8, horizontal7, function1, composer2, i1110 | (234881024 & i1111) | (i1111 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier8;
                            lazyGridState2 = lazyGridState7;
                            paddingValues2 = paddingValues7;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical8;
                            horizontal2 = horizontal7;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal8 = start;
                        Arrangement.Vertical vertical9 = vertical2;
                        Modifier modifier9 = modifier2;
                        LazyGridState lazyGridState8 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1112 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums6 = rememberColumnWidthSums(gridCells, horizontal8, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1112 & 896));
                        int i1113 = (i1112 & 14) | i9 | (i1112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1112) | (i1112 & 29360128);
                        int i1114 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues8 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier9, lazyGridState8, lazyGridSlotsProviderRememberColumnWidthSums6, paddingValues8, z6, true, flingBehavior3, z5, vertical9, horizontal8, function1, composer2, i1113 | (234881024 & i1114) | (i1114 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier9;
                        lazyGridState2 = lazyGridState8;
                        paddingValues2 = paddingValues8;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical9;
                        horizontal2 = horizontal8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal9 = start;
                        Arrangement.Vertical vertical10 = vertical2;
                        Modifier modifier10 = modifier2;
                        LazyGridState lazyGridState9 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1115 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums7 = rememberColumnWidthSums(gridCells, horizontal9, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1115 & 896));
                        int i1116 = (i1115 & 14) | i9 | (i1115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1115) | (i1115 & 29360128);
                        int i1117 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues9 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier10, lazyGridState9, lazyGridSlotsProviderRememberColumnWidthSums7, paddingValues9, z6, true, flingBehavior3, z5, vertical10, horizontal9, function1, composer2, i1116 | (234881024 & i1117) | (i1117 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier10;
                        lazyGridState2 = lazyGridState9;
                        paddingValues2 = paddingValues9;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical10;
                        horizontal2 = horizontal9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                z3 = z;
                if ((i & 196608) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i16;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    i9 = 196608;
                    start = horizontal;
                } else {
                    i9 = 196608;
                    start = horizontal;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(start)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i3 |= i12;
                    }
                    if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i13 = 536870912;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal10 = start;
                            Arrangement.Vertical vertical11 = vertical2;
                            Modifier modifier11 = modifier2;
                            LazyGridState lazyGridState10 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i1118 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums8 = rememberColumnWidthSums(gridCells, horizontal10, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1118 & 896));
                            int i1119 = (i1118 & 14) | i9 | (i1118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1118) | (i1118 & 29360128);
                            int i11110 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues10 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier11, lazyGridState10, lazyGridSlotsProviderRememberColumnWidthSums8, paddingValues10, z6, true, flingBehavior3, z5, vertical11, horizontal10, function1, composer2, i1119 | (234881024 & i11110) | (i11110 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier11;
                            lazyGridState2 = lazyGridState10;
                            paddingValues2 = paddingValues10;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical11;
                            horizontal2 = horizontal10;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal11 = start;
                            Arrangement.Vertical vertical12 = vertical2;
                            Modifier modifier12 = modifier2;
                            LazyGridState lazyGridState11 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i11111 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums9 = rememberColumnWidthSums(gridCells, horizontal11, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111 & 896));
                            int i11112 = (i11111 & 14) | i9 | (i11111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111) | (i11111 & 29360128);
                            int i11113 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues11 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier12, lazyGridState11, lazyGridSlotsProviderRememberColumnWidthSums9, paddingValues11, z6, true, flingBehavior3, z5, vertical12, horizontal11, function1, composer2, i11112 | (234881024 & i11113) | (i11113 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier12;
                            lazyGridState2 = lazyGridState11;
                            paddingValues2 = paddingValues11;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical12;
                            horizontal2 = horizontal11;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal12 = start;
                        Arrangement.Vertical vertical13 = vertical2;
                        Modifier modifier13 = modifier2;
                        LazyGridState lazyGridState12 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11114 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums10 = rememberColumnWidthSums(gridCells, horizontal12, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11114 & 896));
                        int i11115 = (i11114 & 14) | i9 | (i11114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11114) | (i11114 & 29360128);
                        int i11116 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues12 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier13, lazyGridState12, lazyGridSlotsProviderRememberColumnWidthSums10, paddingValues12, z6, true, flingBehavior3, z5, vertical13, horizontal12, function1, composer2, i11115 | (234881024 & i11116) | (i11116 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier13;
                        lazyGridState2 = lazyGridState12;
                        paddingValues2 = paddingValues12;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical13;
                        horizontal2 = horizontal12;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal13 = start;
                        Arrangement.Vertical vertical14 = vertical2;
                        Modifier modifier14 = modifier2;
                        LazyGridState lazyGridState13 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11117 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11 = rememberColumnWidthSums(gridCells, horizontal13, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11117 & 896));
                        int i11118 = (i11117 & 14) | i9 | (i11117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11117) | (i11117 & 29360128);
                        int i11119 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues13 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier14, lazyGridState13, lazyGridSlotsProviderRememberColumnWidthSums11, paddingValues13, z6, true, flingBehavior3, z5, vertical14, horizontal13, function1, composer2, i11118 | (234881024 & i11119) | (i11119 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier14;
                        lazyGridState2 = lazyGridState13;
                        paddingValues2 = paddingValues13;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical14;
                        horizontal2 = horizontal13;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal14 = start;
                        Arrangement.Vertical vertical15 = vertical2;
                        Modifier modifier15 = modifier2;
                        LazyGridState lazyGridState14 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111110 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums12 = rememberColumnWidthSums(gridCells, horizontal14, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111110 & 896));
                        int i111111 = (i111110 & 14) | i9 | (i111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111110) | (i111110 & 29360128);
                        int i111112 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues14 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier15, lazyGridState14, lazyGridSlotsProviderRememberColumnWidthSums12, paddingValues14, z6, true, flingBehavior3, z5, vertical15, horizontal14, function1, composer2, i111111 | (234881024 & i111112) | (i111112 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier15;
                        lazyGridState2 = lazyGridState14;
                        paddingValues2 = paddingValues14;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical15;
                        horizontal2 = horizontal14;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal15 = start;
                        Arrangement.Vertical vertical16 = vertical2;
                        Modifier modifier16 = modifier2;
                        LazyGridState lazyGridState15 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111113 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums13 = rememberColumnWidthSums(gridCells, horizontal15, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111113 & 896));
                        int i111114 = (i111113 & 14) | i9 | (i111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111113) | (i111113 & 29360128);
                        int i111115 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues15 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier16, lazyGridState15, lazyGridSlotsProviderRememberColumnWidthSums13, paddingValues15, z6, true, flingBehavior3, z5, vertical16, horizontal15, function1, composer2, i111114 | (234881024 & i111115) | (i111115 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier16;
                        lazyGridState2 = lazyGridState15;
                        paddingValues2 = paddingValues15;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical16;
                        horizontal2 = horizontal15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal16 = start;
                    Arrangement.Vertical vertical17 = vertical2;
                    Modifier modifier17 = modifier2;
                    LazyGridState lazyGridState16 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111116 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums14 = rememberColumnWidthSums(gridCells, horizontal16, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111116 & 896));
                    int i111117 = (i111116 & 14) | i9 | (i111116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111116) | (i111116 & 29360128);
                    int i111118 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues16 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier17, lazyGridState16, lazyGridSlotsProviderRememberColumnWidthSums14, paddingValues16, z6, true, flingBehavior3, z5, vertical17, horizontal16, function1, composer2, i111117 | (234881024 & i111118) | (i111118 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier17;
                    lazyGridState2 = lazyGridState16;
                    paddingValues2 = paddingValues16;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical17;
                    horizontal2 = horizontal16;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal17 = start;
                    Arrangement.Vertical vertical18 = vertical2;
                    Modifier modifier18 = modifier2;
                    LazyGridState lazyGridState17 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111119 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums15 = rememberColumnWidthSums(gridCells, horizontal17, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111119 & 896));
                    int i1111110 = (i111119 & 14) | i9 | (i111119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111119) | (i111119 & 29360128);
                    int i1111111 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues17 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier18, lazyGridState17, lazyGridSlotsProviderRememberColumnWidthSums15, paddingValues17, z6, true, flingBehavior3, z5, vertical18, horizontal17, function1, composer2, i1111110 | (234881024 & i1111111) | (i1111111 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier18;
                    lazyGridState2 = lazyGridState17;
                    paddingValues2 = paddingValues17;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical18;
                    horizontal2 = horizontal17;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            paddingValuesM305PaddingValues0680j_4 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 196608) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i16;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    i9 = 196608;
                    start = horizontal;
                } else {
                    i9 = 196608;
                    start = horizontal;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(start)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i3 |= i12;
                    }
                    if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i13 = 536870912;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal18 = start;
                            Arrangement.Vertical vertical19 = vertical2;
                            Modifier modifier19 = modifier2;
                            LazyGridState lazyGridState18 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i1111112 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums16 = rememberColumnWidthSums(gridCells, horizontal18, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111112 & 896));
                            int i1111113 = (i1111112 & 14) | i9 | (i1111112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111112) | (i1111112 & 29360128);
                            int i1111114 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues18 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier19, lazyGridState18, lazyGridSlotsProviderRememberColumnWidthSums16, paddingValues18, z6, true, flingBehavior3, z5, vertical19, horizontal18, function1, composer2, i1111113 | (234881024 & i1111114) | (i1111114 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier19;
                            lazyGridState2 = lazyGridState18;
                            paddingValues2 = paddingValues18;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical19;
                            horizontal2 = horizontal18;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal19 = start;
                            Arrangement.Vertical vertical110 = vertical2;
                            Modifier modifier110 = modifier2;
                            LazyGridState lazyGridState19 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i1111115 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums17 = rememberColumnWidthSums(gridCells, horizontal19, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111115 & 896));
                            int i1111116 = (i1111115 & 14) | i9 | (i1111115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111115) | (i1111115 & 29360128);
                            int i1111117 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues19 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier110, lazyGridState19, lazyGridSlotsProviderRememberColumnWidthSums17, paddingValues19, z6, true, flingBehavior3, z5, vertical110, horizontal19, function1, composer2, i1111116 | (234881024 & i1111117) | (i1111117 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier110;
                            lazyGridState2 = lazyGridState19;
                            paddingValues2 = paddingValues19;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical110;
                            horizontal2 = horizontal19;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal110 = start;
                        Arrangement.Vertical vertical111 = vertical2;
                        Modifier modifier111 = modifier2;
                        LazyGridState lazyGridState110 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1111118 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums18 = rememberColumnWidthSums(gridCells, horizontal110, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111118 & 896));
                        int i1111119 = (i1111118 & 14) | i9 | (i1111118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111118) | (i1111118 & 29360128);
                        int i11111110 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues110 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier111, lazyGridState110, lazyGridSlotsProviderRememberColumnWidthSums18, paddingValues110, z6, true, flingBehavior3, z5, vertical111, horizontal110, function1, composer2, i1111119 | (234881024 & i11111110) | (i11111110 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111;
                        lazyGridState2 = lazyGridState110;
                        paddingValues2 = paddingValues110;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical111;
                        horizontal2 = horizontal110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal111 = start;
                        Arrangement.Vertical vertical112 = vertical2;
                        Modifier modifier112 = modifier2;
                        LazyGridState lazyGridState111 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111111 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums19 = rememberColumnWidthSums(gridCells, horizontal111, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111 & 896));
                        int i11111112 = (i11111111 & 14) | i9 | (i11111111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111) | (i11111111 & 29360128);
                        int i11111113 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues111 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier112, lazyGridState111, lazyGridSlotsProviderRememberColumnWidthSums19, paddingValues111, z6, true, flingBehavior3, z5, vertical112, horizontal111, function1, composer2, i11111112 | (234881024 & i11111113) | (i11111113 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier112;
                        lazyGridState2 = lazyGridState111;
                        paddingValues2 = paddingValues111;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical112;
                        horizontal2 = horizontal111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal112 = start;
                        Arrangement.Vertical vertical113 = vertical2;
                        Modifier modifier113 = modifier2;
                        LazyGridState lazyGridState112 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111114 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums110 = rememberColumnWidthSums(gridCells, horizontal112, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111114 & 896));
                        int i11111115 = (i11111114 & 14) | i9 | (i11111114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111114) | (i11111114 & 29360128);
                        int i11111116 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues112 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier113, lazyGridState112, lazyGridSlotsProviderRememberColumnWidthSums110, paddingValues112, z6, true, flingBehavior3, z5, vertical113, horizontal112, function1, composer2, i11111115 | (234881024 & i11111116) | (i11111116 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier113;
                        lazyGridState2 = lazyGridState112;
                        paddingValues2 = paddingValues112;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical113;
                        horizontal2 = horizontal112;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal113 = start;
                        Arrangement.Vertical vertical114 = vertical2;
                        Modifier modifier114 = modifier2;
                        LazyGridState lazyGridState113 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111117 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111 = rememberColumnWidthSums(gridCells, horizontal113, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111117 & 896));
                        int i11111118 = (i11111117 & 14) | i9 | (i11111117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111117) | (i11111117 & 29360128);
                        int i11111119 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues113 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier114, lazyGridState113, lazyGridSlotsProviderRememberColumnWidthSums111, paddingValues113, z6, true, flingBehavior3, z5, vertical114, horizontal113, function1, composer2, i11111118 | (234881024 & i11111119) | (i11111119 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier114;
                        lazyGridState2 = lazyGridState113;
                        paddingValues2 = paddingValues113;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical114;
                        horizontal2 = horizontal113;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal114 = start;
                    Arrangement.Vertical vertical115 = vertical2;
                    Modifier modifier115 = modifier2;
                    LazyGridState lazyGridState114 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111110 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums112 = rememberColumnWidthSums(gridCells, horizontal114, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111110 & 896));
                    int i111111111 = (i111111110 & 14) | i9 | (i111111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111110) | (i111111110 & 29360128);
                    int i111111112 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues114 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier115, lazyGridState114, lazyGridSlotsProviderRememberColumnWidthSums112, paddingValues114, z6, true, flingBehavior3, z5, vertical115, horizontal114, function1, composer2, i111111111 | (234881024 & i111111112) | (i111111112 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier115;
                    lazyGridState2 = lazyGridState114;
                    paddingValues2 = paddingValues114;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical115;
                    horizontal2 = horizontal114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal115 = start;
                    Arrangement.Vertical vertical116 = vertical2;
                    Modifier modifier116 = modifier2;
                    LazyGridState lazyGridState115 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111113 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums113 = rememberColumnWidthSums(gridCells, horizontal115, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111113 & 896));
                    int i111111114 = (i111111113 & 14) | i9 | (i111111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111113) | (i111111113 & 29360128);
                    int i111111115 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues115 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier116, lazyGridState115, lazyGridSlotsProviderRememberColumnWidthSums113, paddingValues115, z6, true, flingBehavior3, z5, vertical116, horizontal115, function1, composer2, i111111114 | (234881024 & i111111115) | (i111111115 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier116;
                    lazyGridState2 = lazyGridState115;
                    paddingValues2 = paddingValues115;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical116;
                    horizontal2 = horizontal115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            z3 = z;
            if ((i & 196608) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i16;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                i9 = 196608;
                start = horizontal;
            } else {
                i9 = 196608;
                start = horizontal;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                }
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal116 = start;
                        Arrangement.Vertical vertical117 = vertical2;
                        Modifier modifier117 = modifier2;
                        LazyGridState lazyGridState116 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111111116 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums114 = rememberColumnWidthSums(gridCells, horizontal116, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111116 & 896));
                        int i111111117 = (i111111116 & 14) | i9 | (i111111116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111116) | (i111111116 & 29360128);
                        int i111111118 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues116 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier117, lazyGridState116, lazyGridSlotsProviderRememberColumnWidthSums114, paddingValues116, z6, true, flingBehavior3, z5, vertical117, horizontal116, function1, composer2, i111111117 | (234881024 & i111111118) | (i111111118 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier117;
                        lazyGridState2 = lazyGridState116;
                        paddingValues2 = paddingValues116;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical117;
                        horizontal2 = horizontal116;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal117 = start;
                        Arrangement.Vertical vertical118 = vertical2;
                        Modifier modifier118 = modifier2;
                        LazyGridState lazyGridState117 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111111119 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums115 = rememberColumnWidthSums(gridCells, horizontal117, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111119 & 896));
                        int i1111111110 = (i111111119 & 14) | i9 | (i111111119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111119) | (i111111119 & 29360128);
                        int i1111111111 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues117 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier118, lazyGridState117, lazyGridSlotsProviderRememberColumnWidthSums115, paddingValues117, z6, true, flingBehavior3, z5, vertical118, horizontal117, function1, composer2, i1111111110 | (234881024 & i1111111111) | (i1111111111 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier118;
                        lazyGridState2 = lazyGridState117;
                        paddingValues2 = paddingValues117;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical118;
                        horizontal2 = horizontal117;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal118 = start;
                    Arrangement.Vertical vertical119 = vertical2;
                    Modifier modifier119 = modifier2;
                    LazyGridState lazyGridState118 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111112 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums116 = rememberColumnWidthSums(gridCells, horizontal118, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111112 & 896));
                    int i1111111113 = (i1111111112 & 14) | i9 | (i1111111112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111112) | (i1111111112 & 29360128);
                    int i1111111114 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues118 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier119, lazyGridState118, lazyGridSlotsProviderRememberColumnWidthSums116, paddingValues118, z6, true, flingBehavior3, z5, vertical119, horizontal118, function1, composer2, i1111111113 | (234881024 & i1111111114) | (i1111111114 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier119;
                    lazyGridState2 = lazyGridState118;
                    paddingValues2 = paddingValues118;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical119;
                    horizontal2 = horizontal118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal119 = start;
                    Arrangement.Vertical vertical1110 = vertical2;
                    Modifier modifier1110 = modifier2;
                    LazyGridState lazyGridState119 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111115 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums117 = rememberColumnWidthSums(gridCells, horizontal119, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111115 & 896));
                    int i1111111116 = (i1111111115 & 14) | i9 | (i1111111115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111115) | (i1111111115 & 29360128);
                    int i1111111117 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues119 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier1110, lazyGridState119, lazyGridSlotsProviderRememberColumnWidthSums117, paddingValues119, z6, true, flingBehavior3, z5, vertical1110, horizontal119, function1, composer2, i1111111116 | (234881024 & i1111111117) | (i1111111117 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1110;
                    lazyGridState2 = lazyGridState119;
                    paddingValues2 = paddingValues119;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical1110;
                    horizontal2 = horizontal119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal1110 = start;
                    Arrangement.Vertical vertical1111 = vertical2;
                    Modifier modifier1111 = modifier2;
                    LazyGridState lazyGridState1110 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111118 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums118 = rememberColumnWidthSums(gridCells, horizontal1110, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111118 & 896));
                    int i1111111119 = (i1111111118 & 14) | i9 | (i1111111118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111118) | (i1111111118 & 29360128);
                    int i11111111110 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues1110 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier1111, lazyGridState1110, lazyGridSlotsProviderRememberColumnWidthSums118, paddingValues1110, z6, true, flingBehavior3, z5, vertical1111, horizontal1110, function1, composer2, i1111111119 | (234881024 & i11111111110) | (i11111111110 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111;
                    lazyGridState2 = lazyGridState1110;
                    paddingValues2 = paddingValues1110;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical1111;
                    horizontal2 = horizontal1110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal1111 = start;
                    Arrangement.Vertical vertical1112 = vertical2;
                    Modifier modifier1112 = modifier2;
                    LazyGridState lazyGridState1111 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i11111111111 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums119 = rememberColumnWidthSums(gridCells, horizontal1111, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111 & 896));
                    int i11111111112 = (i11111111111 & 14) | i9 | (i11111111111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111) | (i11111111111 & 29360128);
                    int i11111111113 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues1111 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier1112, lazyGridState1111, lazyGridSlotsProviderRememberColumnWidthSums119, paddingValues1111, z6, true, flingBehavior3, z5, vertical1112, horizontal1111, function1, composer2, i11111111112 | (234881024 & i11111111113) | (i11111111113 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1112;
                    lazyGridState2 = lazyGridState1111;
                    paddingValues2 = paddingValues1111;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical1112;
                    horizontal2 = horizontal1111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1112 = start;
                Arrangement.Vertical vertical1113 = vertical2;
                Modifier modifier1113 = modifier2;
                LazyGridState lazyGridState1112 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i11111111114 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1110 = rememberColumnWidthSums(gridCells, horizontal1112, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111114 & 896));
                int i11111111115 = (i11111111114 & 14) | i9 | (i11111111114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111114) | (i11111111114 & 29360128);
                int i11111111116 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1112 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1113, lazyGridState1112, lazyGridSlotsProviderRememberColumnWidthSums1110, paddingValues1112, z6, true, flingBehavior3, z5, vertical1113, horizontal1112, function1, composer2, i11111111115 | (234881024 & i11111111116) | (i11111111116 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1113;
                lazyGridState2 = lazyGridState1112;
                paddingValues2 = paddingValues1112;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1113;
                horizontal2 = horizontal1112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1113 = start;
                Arrangement.Vertical vertical1114 = vertical2;
                Modifier modifier1114 = modifier2;
                LazyGridState lazyGridState1113 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i11111111117 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1111 = rememberColumnWidthSums(gridCells, horizontal1113, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111117 & 896));
                int i11111111118 = (i11111111117 & 14) | i9 | (i11111111117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111117) | (i11111111117 & 29360128);
                int i11111111119 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1113 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1114, lazyGridState1113, lazyGridSlotsProviderRememberColumnWidthSums1111, paddingValues1113, z6, true, flingBehavior3, z5, vertical1114, horizontal1113, function1, composer2, i11111111118 | (234881024 & i11111111119) | (i11111111119 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1114;
                lazyGridState2 = lazyGridState1113;
                paddingValues2 = paddingValues1113;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1114;
                horizontal2 = horizontal1113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                lazyGridStateRememberLazyGridState = lazyGridState;
                if (composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState)) {
                }
                i3 |= i15;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i3 |= i15;
        } else {
            lazyGridStateRememberLazyGridState = lazyGridState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                paddingValuesM305PaddingValues0680j_4 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValuesM305PaddingValues0680j_4)) {
                    i5 = 2048;
                } else {
                    i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 196608) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i16;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    i9 = 196608;
                    start = horizontal;
                } else {
                    i9 = 196608;
                    start = horizontal;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(start)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i3 |= i12;
                    }
                    if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i13 = 536870912;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal1114 = start;
                            Arrangement.Vertical vertical1115 = vertical2;
                            Modifier modifier1115 = modifier2;
                            LazyGridState lazyGridState1114 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i111111111110 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1112 = rememberColumnWidthSums(gridCells, horizontal1114, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111110 & 896));
                            int i111111111111 = (i111111111110 & 14) | i9 | (i111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111110) | (i111111111110 & 29360128);
                            int i111111111112 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues1114 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier1115, lazyGridState1114, lazyGridSlotsProviderRememberColumnWidthSums1112, paddingValues1114, z6, true, flingBehavior3, z5, vertical1115, horizontal1114, function1, composer2, i111111111111 | (234881024 & i111111111112) | (i111111111112 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1115;
                            lazyGridState2 = lazyGridState1114;
                            paddingValues2 = paddingValues1114;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical1115;
                            horizontal2 = horizontal1114;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            } else {
                                if (i14 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                }
                                if (i4 != 0) {
                                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getTop();
                                    } else {
                                        bottom = arrangement.getBottom();
                                    }
                                    i3 &= -458753;
                                    vertical2 = bottom;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    z6 = z4;
                                }
                            }
                            Arrangement.Horizontal horizontal1115 = start;
                            Arrangement.Vertical vertical1116 = vertical2;
                            Modifier modifier1116 = modifier2;
                            LazyGridState lazyGridState1115 = lazyGridStateRememberLazyGridState;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i111111111113 = i3 >> 3;
                            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1113 = rememberColumnWidthSums(gridCells, horizontal1115, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111113 & 896));
                            int i111111111114 = (i111111111113 & 14) | i9 | (i111111111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111113) | (i111111111113 & 29360128);
                            int i111111111115 = i3 << 9;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues1115 = paddingValuesM305PaddingValues0680j_4;
                            LazyGridKt.LazyGrid(modifier1116, lazyGridState1115, lazyGridSlotsProviderRememberColumnWidthSums1113, paddingValues1115, z6, true, flingBehavior3, z5, vertical1116, horizontal1115, function1, composer2, i111111111114 | (234881024 & i111111111115) | (i111111111115 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1116;
                            lazyGridState2 = lazyGridState1115;
                            paddingValues2 = paddingValues1115;
                            z7 = z6;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                            vertical3 = vertical1116;
                            horizontal2 = horizontal1115;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal1116 = start;
                        Arrangement.Vertical vertical1117 = vertical2;
                        Modifier modifier1117 = modifier2;
                        LazyGridState lazyGridState1116 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111111111116 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1114 = rememberColumnWidthSums(gridCells, horizontal1116, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111116 & 896));
                        int i111111111117 = (i111111111116 & 14) | i9 | (i111111111116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111116) | (i111111111116 & 29360128);
                        int i111111111118 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues1116 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier1117, lazyGridState1116, lazyGridSlotsProviderRememberColumnWidthSums1114, paddingValues1116, z6, true, flingBehavior3, z5, vertical1117, horizontal1116, function1, composer2, i111111111117 | (234881024 & i111111111118) | (i111111111118 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1117;
                        lazyGridState2 = lazyGridState1116;
                        paddingValues2 = paddingValues1116;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical1117;
                        horizontal2 = horizontal1116;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal1117 = start;
                        Arrangement.Vertical vertical1118 = vertical2;
                        Modifier modifier1118 = modifier2;
                        LazyGridState lazyGridState1117 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i111111111119 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1115 = rememberColumnWidthSums(gridCells, horizontal1117, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111119 & 896));
                        int i1111111111110 = (i111111111119 & 14) | i9 | (i111111111119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111119) | (i111111111119 & 29360128);
                        int i1111111111111 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues1117 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier1118, lazyGridState1117, lazyGridSlotsProviderRememberColumnWidthSums1115, paddingValues1117, z6, true, flingBehavior3, z5, vertical1118, horizontal1117, function1, composer2, i1111111111110 | (234881024 & i1111111111111) | (i1111111111111 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1118;
                        lazyGridState2 = lazyGridState1117;
                        paddingValues2 = paddingValues1117;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical1118;
                        horizontal2 = horizontal1117;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal1118 = start;
                        Arrangement.Vertical vertical1119 = vertical2;
                        Modifier modifier1119 = modifier2;
                        LazyGridState lazyGridState1118 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1111111111112 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1116 = rememberColumnWidthSums(gridCells, horizontal1118, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111112 & 896));
                        int i1111111111113 = (i1111111111112 & 14) | i9 | (i1111111111112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111112) | (i1111111111112 & 29360128);
                        int i1111111111114 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues1118 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier1119, lazyGridState1118, lazyGridSlotsProviderRememberColumnWidthSums1116, paddingValues1118, z6, true, flingBehavior3, z5, vertical1119, horizontal1118, function1, composer2, i1111111111113 | (234881024 & i1111111111114) | (i1111111111114 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1119;
                        lazyGridState2 = lazyGridState1118;
                        paddingValues2 = paddingValues1118;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical1119;
                        horizontal2 = horizontal1118;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal1119 = start;
                        Arrangement.Vertical vertical11110 = vertical2;
                        Modifier modifier11110 = modifier2;
                        LazyGridState lazyGridState1119 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1111111111115 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1117 = rememberColumnWidthSums(gridCells, horizontal1119, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111115 & 896));
                        int i1111111111116 = (i1111111111115 & 14) | i9 | (i1111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111115) | (i1111111111115 & 29360128);
                        int i1111111111117 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues1119 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier11110, lazyGridState1119, lazyGridSlotsProviderRememberColumnWidthSums1117, paddingValues1119, z6, true, flingBehavior3, z5, vertical11110, horizontal1119, function1, composer2, i1111111111116 | (234881024 & i1111111111117) | (i1111111111117 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11110;
                        lazyGridState2 = lazyGridState1119;
                        paddingValues2 = paddingValues1119;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical11110;
                        horizontal2 = horizontal1119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11110 = start;
                    Arrangement.Vertical vertical11111 = vertical2;
                    Modifier modifier11111 = modifier2;
                    LazyGridState lazyGridState11110 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111111118 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1118 = rememberColumnWidthSums(gridCells, horizontal11110, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111118 & 896));
                    int i1111111111119 = (i1111111111118 & 14) | i9 | (i1111111111118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111118) | (i1111111111118 & 29360128);
                    int i11111111111110 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11110 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11111, lazyGridState11110, lazyGridSlotsProviderRememberColumnWidthSums1118, paddingValues11110, z6, true, flingBehavior3, z5, vertical11111, horizontal11110, function1, composer2, i1111111111119 | (234881024 & i11111111111110) | (i11111111111110 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11111;
                    lazyGridState2 = lazyGridState11110;
                    paddingValues2 = paddingValues11110;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11111;
                    horizontal2 = horizontal11110;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11111 = start;
                    Arrangement.Vertical vertical11112 = vertical2;
                    Modifier modifier11112 = modifier2;
                    LazyGridState lazyGridState11111 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i11111111111111 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1119 = rememberColumnWidthSums(gridCells, horizontal11111, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111 & 896));
                    int i11111111111112 = (i11111111111111 & 14) | i9 | (i11111111111111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111) | (i11111111111111 & 29360128);
                    int i11111111111113 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11111 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11112, lazyGridState11111, lazyGridSlotsProviderRememberColumnWidthSums1119, paddingValues11111, z6, true, flingBehavior3, z5, vertical11112, horizontal11111, function1, composer2, i11111111111112 | (234881024 & i11111111111113) | (i11111111111113 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11112;
                    lazyGridState2 = lazyGridState11111;
                    paddingValues2 = paddingValues11111;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11112;
                    horizontal2 = horizontal11111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            z3 = z;
            if ((i & 196608) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i16;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                i9 = 196608;
                start = horizontal;
            } else {
                i9 = 196608;
                start = horizontal;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                }
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal11112 = start;
                        Arrangement.Vertical vertical11113 = vertical2;
                        Modifier modifier11113 = modifier2;
                        LazyGridState lazyGridState11112 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111111111114 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11110 = rememberColumnWidthSums(gridCells, horizontal11112, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111114 & 896));
                        int i11111111111115 = (i11111111111114 & 14) | i9 | (i11111111111114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111114) | (i11111111111114 & 29360128);
                        int i11111111111116 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues11112 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier11113, lazyGridState11112, lazyGridSlotsProviderRememberColumnWidthSums11110, paddingValues11112, z6, true, flingBehavior3, z5, vertical11113, horizontal11112, function1, composer2, i11111111111115 | (234881024 & i11111111111116) | (i11111111111116 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11113;
                        lazyGridState2 = lazyGridState11112;
                        paddingValues2 = paddingValues11112;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical11113;
                        horizontal2 = horizontal11112;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal11113 = start;
                        Arrangement.Vertical vertical11114 = vertical2;
                        Modifier modifier11114 = modifier2;
                        LazyGridState lazyGridState11113 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111111111117 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11111 = rememberColumnWidthSums(gridCells, horizontal11113, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111117 & 896));
                        int i11111111111118 = (i11111111111117 & 14) | i9 | (i11111111111117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111117) | (i11111111111117 & 29360128);
                        int i11111111111119 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues11113 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier11114, lazyGridState11113, lazyGridSlotsProviderRememberColumnWidthSums11111, paddingValues11113, z6, true, flingBehavior3, z5, vertical11114, horizontal11113, function1, composer2, i11111111111118 | (234881024 & i11111111111119) | (i11111111111119 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11114;
                        lazyGridState2 = lazyGridState11113;
                        paddingValues2 = paddingValues11113;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical11114;
                        horizontal2 = horizontal11113;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11114 = start;
                    Arrangement.Vertical vertical11115 = vertical2;
                    Modifier modifier11115 = modifier2;
                    LazyGridState lazyGridState11114 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111110 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11112 = rememberColumnWidthSums(gridCells, horizontal11114, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111110 & 896));
                    int i111111111111111 = (i111111111111110 & 14) | i9 | (i111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111110) | (i111111111111110 & 29360128);
                    int i111111111111112 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11114 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11115, lazyGridState11114, lazyGridSlotsProviderRememberColumnWidthSums11112, paddingValues11114, z6, true, flingBehavior3, z5, vertical11115, horizontal11114, function1, composer2, i111111111111111 | (234881024 & i111111111111112) | (i111111111111112 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11115;
                    lazyGridState2 = lazyGridState11114;
                    paddingValues2 = paddingValues11114;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11115;
                    horizontal2 = horizontal11114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11115 = start;
                    Arrangement.Vertical vertical11116 = vertical2;
                    Modifier modifier11116 = modifier2;
                    LazyGridState lazyGridState11115 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111113 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11113 = rememberColumnWidthSums(gridCells, horizontal11115, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111113 & 896));
                    int i111111111111114 = (i111111111111113 & 14) | i9 | (i111111111111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111113) | (i111111111111113 & 29360128);
                    int i111111111111115 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11115 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11116, lazyGridState11115, lazyGridSlotsProviderRememberColumnWidthSums11113, paddingValues11115, z6, true, flingBehavior3, z5, vertical11116, horizontal11115, function1, composer2, i111111111111114 | (234881024 & i111111111111115) | (i111111111111115 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11116;
                    lazyGridState2 = lazyGridState11115;
                    paddingValues2 = paddingValues11115;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11116;
                    horizontal2 = horizontal11115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11116 = start;
                    Arrangement.Vertical vertical11117 = vertical2;
                    Modifier modifier11117 = modifier2;
                    LazyGridState lazyGridState11116 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111116 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11114 = rememberColumnWidthSums(gridCells, horizontal11116, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111116 & 896));
                    int i111111111111117 = (i111111111111116 & 14) | i9 | (i111111111111116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111116) | (i111111111111116 & 29360128);
                    int i111111111111118 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11116 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11117, lazyGridState11116, lazyGridSlotsProviderRememberColumnWidthSums11114, paddingValues11116, z6, true, flingBehavior3, z5, vertical11117, horizontal11116, function1, composer2, i111111111111117 | (234881024 & i111111111111118) | (i111111111111118 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11117;
                    lazyGridState2 = lazyGridState11116;
                    paddingValues2 = paddingValues11116;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11117;
                    horizontal2 = horizontal11116;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal11117 = start;
                    Arrangement.Vertical vertical11118 = vertical2;
                    Modifier modifier11118 = modifier2;
                    LazyGridState lazyGridState11117 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111119 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11115 = rememberColumnWidthSums(gridCells, horizontal11117, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111119 & 896));
                    int i1111111111111110 = (i111111111111119 & 14) | i9 | (i111111111111119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111119) | (i111111111111119 & 29360128);
                    int i1111111111111111 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues11117 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier11118, lazyGridState11117, lazyGridSlotsProviderRememberColumnWidthSums11115, paddingValues11117, z6, true, flingBehavior3, z5, vertical11118, horizontal11117, function1, composer2, i1111111111111110 | (234881024 & i1111111111111111) | (i1111111111111111 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11118;
                    lazyGridState2 = lazyGridState11117;
                    paddingValues2 = paddingValues11117;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical11118;
                    horizontal2 = horizontal11117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal11118 = start;
                Arrangement.Vertical vertical11119 = vertical2;
                Modifier modifier11119 = modifier2;
                LazyGridState lazyGridState11118 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i1111111111111112 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11116 = rememberColumnWidthSums(gridCells, horizontal11118, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111112 & 896));
                int i1111111111111113 = (i1111111111111112 & 14) | i9 | (i1111111111111112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111112) | (i1111111111111112 & 29360128);
                int i1111111111111114 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues11118 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier11119, lazyGridState11118, lazyGridSlotsProviderRememberColumnWidthSums11116, paddingValues11118, z6, true, flingBehavior3, z5, vertical11119, horizontal11118, function1, composer2, i1111111111111113 | (234881024 & i1111111111111114) | (i1111111111111114 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11119;
                lazyGridState2 = lazyGridState11118;
                paddingValues2 = paddingValues11118;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical11119;
                horizontal2 = horizontal11118;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal11119 = start;
                Arrangement.Vertical vertical111110 = vertical2;
                Modifier modifier111110 = modifier2;
                LazyGridState lazyGridState11119 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i1111111111111115 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11117 = rememberColumnWidthSums(gridCells, horizontal11119, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111115 & 896));
                int i1111111111111116 = (i1111111111111115 & 14) | i9 | (i1111111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111115) | (i1111111111111115 & 29360128);
                int i1111111111111117 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues11119 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier111110, lazyGridState11119, lazyGridSlotsProviderRememberColumnWidthSums11117, paddingValues11119, z6, true, flingBehavior3, z5, vertical111110, horizontal11119, function1, composer2, i1111111111111116 | (234881024 & i1111111111111117) | (i1111111111111117 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111110;
                lazyGridState2 = lazyGridState11119;
                paddingValues2 = paddingValues11119;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical111110;
                horizontal2 = horizontal11119;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        paddingValuesM305PaddingValues0680j_4 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & 196608) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i16;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i16;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                i9 = 196608;
                start = horizontal;
            } else {
                i9 = 196608;
                start = horizontal;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i3 |= i12;
                }
                if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = 536870912;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal111110 = start;
                        Arrangement.Vertical vertical111111 = vertical2;
                        Modifier modifier111111 = modifier2;
                        LazyGridState lazyGridState111110 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i1111111111111118 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11118 = rememberColumnWidthSums(gridCells, horizontal111110, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111118 & 896));
                        int i1111111111111119 = (i1111111111111118 & 14) | i9 | (i1111111111111118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111118) | (i1111111111111118 & 29360128);
                        int i11111111111111110 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues111110 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier111111, lazyGridState111110, lazyGridSlotsProviderRememberColumnWidthSums11118, paddingValues111110, z6, true, flingBehavior3, z5, vertical111111, horizontal111110, function1, composer2, i1111111111111119 | (234881024 & i11111111111111110) | (i11111111111111110 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111111;
                        lazyGridState2 = lazyGridState111110;
                        paddingValues2 = paddingValues111110;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical111111;
                        horizontal2 = horizontal111110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            }
                            if (i4 != 0) {
                                paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                                vertical2 = bottom;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i11 != 0) {
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                                z5 = true;
                            } else {
                                z5 = z2;
                                flingBehavior3 = flingBehavior2;
                                z6 = z4;
                            }
                        }
                        Arrangement.Horizontal horizontal111111 = start;
                        Arrangement.Vertical vertical111112 = vertical2;
                        Modifier modifier111112 = modifier2;
                        LazyGridState lazyGridState111111 = lazyGridStateRememberLazyGridState;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                        }
                        int i11111111111111111 = i3 >> 3;
                        LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums11119 = rememberColumnWidthSums(gridCells, horizontal111111, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111111 & 896));
                        int i11111111111111112 = (i11111111111111111 & 14) | i9 | (i11111111111111111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111111) | (i11111111111111111 & 29360128);
                        int i11111111111111113 = i3 << 9;
                        composer2 = composerStartRestartGroup;
                        PaddingValues paddingValues111111 = paddingValuesM305PaddingValues0680j_4;
                        LazyGridKt.LazyGrid(modifier111112, lazyGridState111111, lazyGridSlotsProviderRememberColumnWidthSums11119, paddingValues111111, z6, true, flingBehavior3, z5, vertical111112, horizontal111111, function1, composer2, i11111111111111112 | (234881024 & i11111111111111113) | (i11111111111111113 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111112;
                        lazyGridState2 = lazyGridState111111;
                        paddingValues2 = paddingValues111111;
                        z7 = z6;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                        vertical3 = vertical111112;
                        horizontal2 = horizontal111111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111112 = start;
                    Arrangement.Vertical vertical111113 = vertical2;
                    Modifier modifier111113 = modifier2;
                    LazyGridState lazyGridState111112 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i11111111111111114 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111110 = rememberColumnWidthSums(gridCells, horizontal111112, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111114 & 896));
                    int i11111111111111115 = (i11111111111111114 & 14) | i9 | (i11111111111111114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111114) | (i11111111111111114 & 29360128);
                    int i11111111111111116 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111112 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier111113, lazyGridState111112, lazyGridSlotsProviderRememberColumnWidthSums111110, paddingValues111112, z6, true, flingBehavior3, z5, vertical111113, horizontal111112, function1, composer2, i11111111111111115 | (234881024 & i11111111111111116) | (i11111111111111116 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111113;
                    lazyGridState2 = lazyGridState111112;
                    paddingValues2 = paddingValues111112;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical111113;
                    horizontal2 = horizontal111112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111113 = start;
                    Arrangement.Vertical vertical111114 = vertical2;
                    Modifier modifier111114 = modifier2;
                    LazyGridState lazyGridState111113 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i11111111111111117 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111111 = rememberColumnWidthSums(gridCells, horizontal111113, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111117 & 896));
                    int i11111111111111118 = (i11111111111111117 & 14) | i9 | (i11111111111111117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111117) | (i11111111111111117 & 29360128);
                    int i11111111111111119 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111113 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier111114, lazyGridState111113, lazyGridSlotsProviderRememberColumnWidthSums111111, paddingValues111113, z6, true, flingBehavior3, z5, vertical111114, horizontal111113, function1, composer2, i11111111111111118 | (234881024 & i11111111111111119) | (i11111111111111119 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111114;
                    lazyGridState2 = lazyGridState111113;
                    paddingValues2 = paddingValues111113;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical111114;
                    horizontal2 = horizontal111113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111114 = start;
                    Arrangement.Vertical vertical111115 = vertical2;
                    Modifier modifier111115 = modifier2;
                    LazyGridState lazyGridState111114 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111111110 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111112 = rememberColumnWidthSums(gridCells, horizontal111114, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111110 & 896));
                    int i111111111111111111 = (i111111111111111110 & 14) | i9 | (i111111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111110) | (i111111111111111110 & 29360128);
                    int i111111111111111112 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111114 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier111115, lazyGridState111114, lazyGridSlotsProviderRememberColumnWidthSums111112, paddingValues111114, z6, true, flingBehavior3, z5, vertical111115, horizontal111114, function1, composer2, i111111111111111111 | (234881024 & i111111111111111112) | (i111111111111111112 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111115;
                    lazyGridState2 = lazyGridState111114;
                    paddingValues2 = paddingValues111114;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical111115;
                    horizontal2 = horizontal111114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111115 = start;
                    Arrangement.Vertical vertical111116 = vertical2;
                    Modifier modifier111116 = modifier2;
                    LazyGridState lazyGridState111115 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i111111111111111113 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111113 = rememberColumnWidthSums(gridCells, horizontal111115, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111113 & 896));
                    int i111111111111111114 = (i111111111111111113 & 14) | i9 | (i111111111111111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111113) | (i111111111111111113 & 29360128);
                    int i111111111111111115 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111115 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier111116, lazyGridState111115, lazyGridSlotsProviderRememberColumnWidthSums111113, paddingValues111115, z6, true, flingBehavior3, z5, vertical111116, horizontal111115, function1, composer2, i111111111111111114 | (234881024 & i111111111111111115) | (i111111111111111115 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111116;
                    lazyGridState2 = lazyGridState111115;
                    paddingValues2 = paddingValues111115;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical111116;
                    horizontal2 = horizontal111115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal111116 = start;
                Arrangement.Vertical vertical111117 = vertical2;
                Modifier modifier111117 = modifier2;
                LazyGridState lazyGridState111116 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i111111111111111116 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111114 = rememberColumnWidthSums(gridCells, horizontal111116, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111116 & 896));
                int i111111111111111117 = (i111111111111111116 & 14) | i9 | (i111111111111111116 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111116) | (i111111111111111116 & 29360128);
                int i111111111111111118 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues111116 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier111117, lazyGridState111116, lazyGridSlotsProviderRememberColumnWidthSums111114, paddingValues111116, z6, true, flingBehavior3, z5, vertical111117, horizontal111116, function1, composer2, i111111111111111117 | (234881024 & i111111111111111118) | (i111111111111111118 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111117;
                lazyGridState2 = lazyGridState111116;
                paddingValues2 = paddingValues111116;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical111117;
                horizontal2 = horizontal111116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal111117 = start;
                Arrangement.Vertical vertical111118 = vertical2;
                Modifier modifier111118 = modifier2;
                LazyGridState lazyGridState111117 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i111111111111111119 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111115 = rememberColumnWidthSums(gridCells, horizontal111117, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111119 & 896));
                int i1111111111111111110 = (i111111111111111119 & 14) | i9 | (i111111111111111119 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111119) | (i111111111111111119 & 29360128);
                int i1111111111111111111 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues111117 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier111118, lazyGridState111117, lazyGridSlotsProviderRememberColumnWidthSums111115, paddingValues111117, z6, true, flingBehavior3, z5, vertical111118, horizontal111117, function1, composer2, i1111111111111111110 | (234881024 & i1111111111111111111) | (i1111111111111111111 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111118;
                lazyGridState2 = lazyGridState111117;
                paddingValues2 = paddingValues111117;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical111118;
                horizontal2 = horizontal111117;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        z3 = z;
        if ((i & 196608) == 0) {
            if ((i2 & 32) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i16;
            } else {
                vertical2 = vertical;
            }
            i3 |= i16;
        } else {
            vertical2 = vertical;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            i9 = 196608;
            start = horizontal;
        } else {
            i9 = 196608;
            start = horizontal;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(start)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
        }
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i11 = i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
        if (i11 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i3 |= i12;
            }
            if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111118 = start;
                    Arrangement.Vertical vertical111119 = vertical2;
                    Modifier modifier111119 = modifier2;
                    LazyGridState lazyGridState111118 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111111111111112 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111116 = rememberColumnWidthSums(gridCells, horizontal111118, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111111112 & 896));
                    int i1111111111111111113 = (i1111111111111111112 & 14) | i9 | (i1111111111111111112 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111111112) | (i1111111111111111112 & 29360128);
                    int i1111111111111111114 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111118 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier111119, lazyGridState111118, lazyGridSlotsProviderRememberColumnWidthSums111116, paddingValues111118, z6, true, flingBehavior3, z5, vertical111119, horizontal111118, function1, composer2, i1111111111111111113 | (234881024 & i1111111111111111114) | (i1111111111111111114 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111119;
                    lazyGridState2 = lazyGridState111118;
                    paddingValues2 = paddingValues111118;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical111119;
                    horizontal2 = horizontal111118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        }
                        if (i4 != 0) {
                            paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                            vertical2 = bottom;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i11 != 0) {
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                            z5 = true;
                        } else {
                            z5 = z2;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                    }
                    Arrangement.Horizontal horizontal111119 = start;
                    Arrangement.Vertical vertical1111110 = vertical2;
                    Modifier modifier1111110 = modifier2;
                    LazyGridState lazyGridState111119 = lazyGridStateRememberLazyGridState;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                    }
                    int i1111111111111111115 = i3 >> 3;
                    LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111117 = rememberColumnWidthSums(gridCells, horizontal111119, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111111115 & 896));
                    int i1111111111111111116 = (i1111111111111111115 & 14) | i9 | (i1111111111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111111115) | (i1111111111111111115 & 29360128);
                    int i1111111111111111117 = i3 << 9;
                    composer2 = composerStartRestartGroup;
                    PaddingValues paddingValues111119 = paddingValuesM305PaddingValues0680j_4;
                    LazyGridKt.LazyGrid(modifier1111110, lazyGridState111119, lazyGridSlotsProviderRememberColumnWidthSums111117, paddingValues111119, z6, true, flingBehavior3, z5, vertical1111110, horizontal111119, function1, composer2, i1111111111111111116 | (234881024 & i1111111111111111117) | (i1111111111111111117 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111110;
                    lazyGridState2 = lazyGridState111119;
                    paddingValues2 = paddingValues111119;
                    z7 = z6;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                    vertical3 = vertical1111110;
                    horizontal2 = horizontal111119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1111110 = start;
                Arrangement.Vertical vertical1111111 = vertical2;
                Modifier modifier1111111 = modifier2;
                LazyGridState lazyGridState1111110 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i1111111111111111118 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111118 = rememberColumnWidthSums(gridCells, horizontal1111110, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111111118 & 896));
                int i1111111111111111119 = (i1111111111111111118 & 14) | i9 | (i1111111111111111118 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i1111111111111111118) | (i1111111111111111118 & 29360128);
                int i11111111111111111110 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1111110 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1111111, lazyGridState1111110, lazyGridSlotsProviderRememberColumnWidthSums111118, paddingValues1111110, z6, true, flingBehavior3, z5, vertical1111111, horizontal1111110, function1, composer2, i1111111111111111119 | (234881024 & i11111111111111111110) | (i11111111111111111110 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111111;
                lazyGridState2 = lazyGridState1111110;
                paddingValues2 = paddingValues1111110;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1111111;
                horizontal2 = horizontal1111110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1111111 = start;
                Arrangement.Vertical vertical1111112 = vertical2;
                Modifier modifier1111112 = modifier2;
                LazyGridState lazyGridState1111111 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i11111111111111111111 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums111119 = rememberColumnWidthSums(gridCells, horizontal1111111, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111111111 & 896));
                int i11111111111111111112 = (i11111111111111111111 & 14) | i9 | (i11111111111111111111 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111111111) | (i11111111111111111111 & 29360128);
                int i11111111111111111113 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1111111 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1111112, lazyGridState1111111, lazyGridSlotsProviderRememberColumnWidthSums111119, paddingValues1111111, z6, true, flingBehavior3, z5, vertical1111112, horizontal1111111, function1, composer2, i11111111111111111112 | (234881024 & i11111111111111111113) | (i11111111111111111113 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111112;
                lazyGridState2 = lazyGridState1111111;
                paddingValues2 = paddingValues1111111;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1111112;
                horizontal2 = horizontal1111111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i13 = 536870912;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1111112 = start;
                Arrangement.Vertical vertical1111113 = vertical2;
                Modifier modifier1111113 = modifier2;
                LazyGridState lazyGridState1111112 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i11111111111111111114 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1111110 = rememberColumnWidthSums(gridCells, horizontal1111112, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111111114 & 896));
                int i11111111111111111115 = (i11111111111111111114 & 14) | i9 | (i11111111111111111114 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111111114) | (i11111111111111111114 & 29360128);
                int i11111111111111111116 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1111112 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1111113, lazyGridState1111112, lazyGridSlotsProviderRememberColumnWidthSums1111110, paddingValues1111112, z6, true, flingBehavior3, z5, vertical1111113, horizontal1111112, function1, composer2, i11111111111111111115 | (234881024 & i11111111111111111116) | (i11111111111111111116 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111113;
                lazyGridState2 = lazyGridState1111112;
                paddingValues2 = paddingValues1111112;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1111113;
                horizontal2 = horizontal1111112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    }
                    if (i4 != 0) {
                        paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                        vertical2 = bottom;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i11 != 0) {
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                        z5 = true;
                    } else {
                        z5 = z2;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                }
                Arrangement.Horizontal horizontal1111113 = start;
                Arrangement.Vertical vertical1111114 = vertical2;
                Modifier modifier1111114 = modifier2;
                LazyGridState lazyGridState1111113 = lazyGridStateRememberLazyGridState;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                int i11111111111111111117 = i3 >> 3;
                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1111111 = rememberColumnWidthSums(gridCells, horizontal1111113, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111111117 & 896));
                int i11111111111111111118 = (i11111111111111111117 & 14) | i9 | (i11111111111111111117 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i11111111111111111117) | (i11111111111111111117 & 29360128);
                int i11111111111111111119 = i3 << 9;
                composer2 = composerStartRestartGroup;
                PaddingValues paddingValues1111113 = paddingValuesM305PaddingValues0680j_4;
                LazyGridKt.LazyGrid(modifier1111114, lazyGridState1111113, lazyGridSlotsProviderRememberColumnWidthSums1111111, paddingValues1111113, z6, true, flingBehavior3, z5, vertical1111114, horizontal1111113, function1, composer2, i11111111111111111118 | (234881024 & i11111111111111111119) | (i11111111111111111119 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111114;
                lazyGridState2 = lazyGridState1111113;
                paddingValues2 = paddingValues1111113;
                z7 = z6;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
                vertical3 = vertical1111114;
                horizontal2 = horizontal1111113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 805306368;
        if ((i3 & 306783379) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                }
                if (i4 != 0) {
                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                    vertical2 = bottom;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i11 != 0) {
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                    z5 = true;
                } else {
                    z5 = z2;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                }
                if (i4 != 0) {
                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                    vertical2 = bottom;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i11 != 0) {
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                    z5 = true;
                } else {
                    z5 = z2;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
            }
            Arrangement.Horizontal horizontal1111114 = start;
            Arrangement.Vertical vertical1111115 = vertical2;
            Modifier modifier1111115 = modifier2;
            LazyGridState lazyGridState1111114 = lazyGridStateRememberLazyGridState;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
            }
            int i111111111111111111110 = i3 >> 3;
            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1111112 = rememberColumnWidthSums(gridCells, horizontal1111114, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111111110 & 896));
            int i111111111111111111111 = (i111111111111111111110 & 14) | i9 | (i111111111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111111110) | (i111111111111111111110 & 29360128);
            int i111111111111111111112 = i3 << 9;
            composer2 = composerStartRestartGroup;
            PaddingValues paddingValues1111114 = paddingValuesM305PaddingValues0680j_4;
            LazyGridKt.LazyGrid(modifier1111115, lazyGridState1111114, lazyGridSlotsProviderRememberColumnWidthSums1111112, paddingValues1111114, z6, true, flingBehavior3, z5, vertical1111115, horizontal1111114, function1, composer2, i111111111111111111111 | (234881024 & i111111111111111111112) | (i111111111111111111112 & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier1111115;
            lazyGridState2 = lazyGridState1111114;
            paddingValues2 = paddingValues1111114;
            z7 = z6;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
            vertical3 = vertical1111115;
            horizontal2 = horizontal1111114;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                }
                if (i4 != 0) {
                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                    vertical2 = bottom;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i11 != 0) {
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                    z5 = true;
                } else {
                    z5 = z2;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                }
                if (i4 != 0) {
                    paddingValuesM305PaddingValues0680j_4 = PaddingKt.m305PaddingValues0680j_4(Dp.m2551constructorimpl(0));
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                    vertical2 = bottom;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i11 != 0) {
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                    z5 = true;
                } else {
                    z5 = z2;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
            }
            Arrangement.Horizontal horizontal1111115 = start;
            Arrangement.Vertical vertical1111116 = vertical2;
            Modifier modifier1111116 = modifier2;
            LazyGridState lazyGridState1111115 = lazyGridStateRememberLazyGridState;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
            }
            int i111111111111111111113 = i3 >> 3;
            LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums1111113 = rememberColumnWidthSums(gridCells, horizontal1111115, paddingValuesM305PaddingValues0680j_4, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111111111113 & 896));
            int i111111111111111111114 = (i111111111111111111113 & 14) | i9 | (i111111111111111111113 & 112) | (i3 & 7168) | (57344 & i3) | (3670016 & i111111111111111111113) | (i111111111111111111113 & 29360128);
            int i111111111111111111115 = i3 << 9;
            composer2 = composerStartRestartGroup;
            PaddingValues paddingValues1111115 = paddingValuesM305PaddingValues0680j_4;
            LazyGridKt.LazyGrid(modifier1111116, lazyGridState1111115, lazyGridSlotsProviderRememberColumnWidthSums1111113, paddingValues1111115, z6, true, flingBehavior3, z5, vertical1111116, horizontal1111115, function1, composer2, i111111111111111111114 | (234881024 & i111111111111111111115) | (i111111111111111111115 & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier1111116;
            lazyGridState2 = lazyGridState1111115;
            paddingValues2 = paddingValues1111115;
            z7 = z6;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
            vertical3 = vertical1111116;
            horizontal2 = horizontal1111115;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z7, vertical3, horizontal2, flingBehavior4, z8, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new GridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return m387invoke0kLqBqw((Density) obj, ((Constraints) obj2).m2536unboximpl());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m387invoke0kLqBqw(Density density, long j) {
                    if (Constraints.m2530getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
                    }
                    PaddingValues paddingValues2 = paddingValues;
                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                    int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j) - density.mo225roundToPx0680j_4(Dp.m2551constructorimpl(PaddingKt.calculateStartPadding(paddingValues2, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues, layoutDirection)));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, iM2530getMaxWidthimpl, density.mo225roundToPx0680j_4(horizontal2.mo280getSpacingD9Ej5fM())));
                    int[] iArr = new int[intArray.length];
                    horizontal2.arrange(density, iM2530getMaxWidthimpl, intArray, layoutDirection, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }
}
