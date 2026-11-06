package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimatedVisibilityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 AnimatedEnterExitImpl$lambda$2(State state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$4(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x007e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x0087  */
    /* JADX WARN: Code duplicated, block: B:54:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:82:0x010b  */
    /* JADX WARN: Code duplicated, block: B:84:0x010e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0111  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118  */
    /* JADX WARN: Code duplicated, block: B:91:0x014e  */
    /* JADX WARN: Code duplicated, block: B:95:0x015b  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3 function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        String str2;
        int i9;
        Function3 function4;
        int i10;
        Modifier modifier3;
        EnterTransition enterTransitionPlus;
        ExitTransition exitTransitionPlus;
        String str3;
        final String str4;
        final Modifier modifier4;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2088733774);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    enterTransition2 = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransition2)) {
                        i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 2048;
                        } else {
                            i7 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            str2 = str;
                            if (composerStartRestartGroup.changed(str2)) {
                                i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            i3 |= 196608;
                            function4 = function3;
                        } else {
                            function4 = function3;
                            if ((i & 196608) == 0) {
                                if (composerStartRestartGroup.changedInstance(function4)) {
                                    i10 = 131072;
                                } else {
                                    i10 = 65536;
                                }
                                i3 |= i10;
                            }
                        }
                        if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                            } else {
                                enterTransitionPlus = enterTransition2;
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                            }
                            int i12 = i3 << 3;
                            Modifier modifier5 = modifier3;
                            EnterTransition enterTransition4 = enterTransitionPlus;
                            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Boolean) obj).booleanValue());
                                }
                            }, modifier5, enterTransition4, exitTransitionPlus, function4, composerStartRestartGroup, (i12 & 57344) | (i12 & 896) | 48 | (i12 & 7168) | (i3 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str4 = str3;
                            modifier4 = modifier5;
                            enterTransition3 = enterTransition4;
                            exitTransition3 = exitTransitionPlus;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            enterTransition3 = enterTransition2;
                            exitTransition3 = exitTransition2;
                            str4 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i13 = i3 << 3;
                        Modifier modifier6 = modifier3;
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier6, enterTransition5, exitTransitionPlus, function4, composerStartRestartGroup, (i13 & 57344) | (i13 & 896) | 48 | (i13 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier6;
                        enterTransition3 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i14 = i3 << 3;
                        Modifier modifier7 = modifier3;
                        EnterTransition enterTransition6 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier7, enterTransition6, exitTransitionPlus, function4, composerStartRestartGroup, (i14 & 57344) | (i14 & 896) | 48 | (i14 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier7;
                        enterTransition3 = enterTransition6;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i15 = i3 << 3;
                        Modifier modifier8 = modifier3;
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier8, enterTransition7, exitTransitionPlus, function4, composerStartRestartGroup, (i15 & 57344) | (i15 & 896) | 48 | (i15 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier8;
                        enterTransition3 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i16 = i3 << 3;
                        Modifier modifier9 = modifier3;
                        EnterTransition enterTransition8 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier9, enterTransition8, exitTransitionPlus, function4, composerStartRestartGroup, (i16 & 57344) | (i16 & 896) | 48 | (i16 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier9;
                        enterTransition3 = enterTransition8;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i17 = i3 << 3;
                    Modifier modifier10 = modifier3;
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier10, enterTransition9, exitTransitionPlus, function4, composerStartRestartGroup, (i17 & 57344) | (i17 & 896) | 48 | (i17 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier10;
                    enterTransition3 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i18 = i3 << 3;
                    Modifier modifier11 = modifier3;
                    EnterTransition enterTransition10 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier11, enterTransition10, exitTransitionPlus, function4, composerStartRestartGroup, (i18 & 57344) | (i18 & 896) | 48 | (i18 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier11;
                    enterTransition3 = enterTransition10;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i19 = i3 << 3;
                        Modifier modifier12 = modifier3;
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier12, enterTransition11, exitTransitionPlus, function4, composerStartRestartGroup, (i19 & 57344) | (i19 & 896) | 48 | (i19 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier12;
                        enterTransition3 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i110 = i3 << 3;
                        Modifier modifier13 = modifier3;
                        EnterTransition enterTransition12 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier13, enterTransition12, exitTransitionPlus, function4, composerStartRestartGroup, (i110 & 57344) | (i110 & 896) | 48 | (i110 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier13;
                        enterTransition3 = enterTransition12;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i111 = i3 << 3;
                    Modifier modifier14 = modifier3;
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier14, enterTransition13, exitTransitionPlus, function4, composerStartRestartGroup, (i111 & 57344) | (i111 & 896) | 48 | (i111 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier14;
                    enterTransition3 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i112 = i3 << 3;
                    Modifier modifier15 = modifier3;
                    EnterTransition enterTransition14 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier15, enterTransition14, exitTransitionPlus, function4, composerStartRestartGroup, (i112 & 57344) | (i112 & 896) | 48 | (i112 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier15;
                    enterTransition3 = enterTransition14;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i113 = i3 << 3;
                    Modifier modifier16 = modifier3;
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier16, enterTransition15, exitTransitionPlus, function4, composerStartRestartGroup, (i113 & 57344) | (i113 & 896) | 48 | (i113 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier16;
                    enterTransition3 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i114 = i3 << 3;
                    Modifier modifier17 = modifier3;
                    EnterTransition enterTransition16 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier17, enterTransition16, exitTransitionPlus, function4, composerStartRestartGroup, (i114 & 57344) | (i114 & 896) | 48 | (i114 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier17;
                    enterTransition3 = enterTransition16;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i115 = i3 << 3;
                Modifier modifier18 = modifier3;
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier18, enterTransition17, exitTransitionPlus, function4, composerStartRestartGroup, (i115 & 57344) | (i115 & 896) | 48 | (i115 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier18;
                enterTransition3 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i116 = i3 << 3;
                Modifier modifier19 = modifier3;
                EnterTransition enterTransition18 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier19, enterTransition18, exitTransitionPlus, function4, composerStartRestartGroup, (i116 & 57344) | (i116 & 896) | 48 | (i116 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier19;
                enterTransition3 = enterTransition18;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                enterTransition2 = enterTransition;
                if (composerStartRestartGroup.changed(enterTransition2)) {
                    i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i117 = i3 << 3;
                        Modifier modifier110 = modifier3;
                        EnterTransition enterTransition19 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier110, enterTransition19, exitTransitionPlus, function4, composerStartRestartGroup, (i117 & 57344) | (i117 & 896) | 48 | (i117 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier110;
                        enterTransition3 = enterTransition19;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                        }
                        int i118 = i3 << 3;
                        Modifier modifier111 = modifier3;
                        EnterTransition enterTransition110 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier111, enterTransition110, exitTransitionPlus, function4, composerStartRestartGroup, (i118 & 57344) | (i118 & 896) | 48 | (i118 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier111;
                        enterTransition3 = enterTransition110;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i119) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i119 = i3 << 3;
                    Modifier modifier112 = modifier3;
                    EnterTransition enterTransition111 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier112, enterTransition111, exitTransitionPlus, function4, composerStartRestartGroup, (i119 & 57344) | (i119 & 896) | 48 | (i119 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier112;
                    enterTransition3 = enterTransition111;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i1110 = i3 << 3;
                    Modifier modifier113 = modifier3;
                    EnterTransition enterTransition112 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier113, enterTransition112, exitTransitionPlus, function4, composerStartRestartGroup, (i1110 & 57344) | (i1110 & 896) | 48 | (i1110 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier113;
                    enterTransition3 = enterTransition112;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i1111 = i3 << 3;
                    Modifier modifier114 = modifier3;
                    EnterTransition enterTransition113 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier114, enterTransition113, exitTransitionPlus, function4, composerStartRestartGroup, (i1111 & 57344) | (i1111 & 896) | 48 | (i1111 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier114;
                    enterTransition3 = enterTransition113;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i1112 = i3 << 3;
                    Modifier modifier115 = modifier3;
                    EnterTransition enterTransition114 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier115, enterTransition114, exitTransitionPlus, function4, composerStartRestartGroup, (i1112 & 57344) | (i1112 & 896) | 48 | (i1112 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier115;
                    enterTransition3 = enterTransition114;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1113) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i1113 = i3 << 3;
                Modifier modifier116 = modifier3;
                EnterTransition enterTransition115 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier116, enterTransition115, exitTransitionPlus, function4, composerStartRestartGroup, (i1113 & 57344) | (i1113 & 896) | 48 | (i1113 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier116;
                enterTransition3 = enterTransition115;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i1114 = i3 << 3;
                Modifier modifier117 = modifier3;
                EnterTransition enterTransition116 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier117, enterTransition116, exitTransitionPlus, function4, composerStartRestartGroup, (i1114 & 57344) | (i1114 & 896) | 48 | (i1114 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier117;
                enterTransition3 = enterTransition116;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1115) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 2048;
                } else {
                    i7 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i1115 = i3 << 3;
                    Modifier modifier118 = modifier3;
                    EnterTransition enterTransition117 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier118, enterTransition117, exitTransitionPlus, function4, composerStartRestartGroup, (i1115 & 57344) | (i1115 & 896) | 48 | (i1115 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier118;
                    enterTransition3 = enterTransition117;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                    }
                    int i1116 = i3 << 3;
                    Modifier modifier119 = modifier3;
                    EnterTransition enterTransition118 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier119, enterTransition118, exitTransitionPlus, function4, composerStartRestartGroup, (i1116 & 57344) | (i1116 & 896) | 48 | (i1116 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier119;
                    enterTransition3 = enterTransition118;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1117) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i1117 = i3 << 3;
                Modifier modifier1110 = modifier3;
                EnterTransition enterTransition119 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1110, enterTransition119, exitTransitionPlus, function4, composerStartRestartGroup, (i1117 & 57344) | (i1117 & 896) | 48 | (i1117 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1110;
                enterTransition3 = enterTransition119;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i1118 = i3 << 3;
                Modifier modifier1111 = modifier3;
                EnterTransition enterTransition1110 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1111, enterTransition1110, exitTransitionPlus, function4, composerStartRestartGroup, (i1118 & 57344) | (i1118 & 896) | 48 | (i1118 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1111;
                enterTransition3 = enterTransition1110;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1119) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i9 = Http2.INITIAL_MAX_FRAME_SIZE;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                i3 |= 196608;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i1119 = i3 << 3;
                Modifier modifier1112 = modifier3;
                EnterTransition enterTransition1111 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1112, enterTransition1111, exitTransitionPlus, function4, composerStartRestartGroup, (i1119 & 57344) | (i1119 & 896) | 48 | (i1119 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1112;
                enterTransition3 = enterTransition1111;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                int i11110 = i3 << 3;
                Modifier modifier1113 = modifier3;
                EnterTransition enterTransition1112 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1113, enterTransition1112, exitTransitionPlus, function4, composerStartRestartGroup, (i11110 & 57344) | (i11110 & 896) | 48 | (i11110 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1113;
                enterTransition3 = enterTransition1112;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        str2 = str;
        if ((i2 & 32) != 0) {
            i3 |= 196608;
            function4 = function3;
        } else {
            function4 = function3;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
        }
        if ((74899 & i3) == 74898) {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            } else {
                enterTransitionPlus = enterTransition2;
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
            }
            int i11111 = i3 << 3;
            Modifier modifier1114 = modifier3;
            EnterTransition enterTransition1113 = enterTransitionPlus;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Boolean) obj).booleanValue());
                }
            }, modifier1114, enterTransition1113, exitTransitionPlus, function4, composerStartRestartGroup, (i11111 & 57344) | (i11111 & 896) | 48 | (i11111 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str3;
            modifier4 = modifier1114;
            enterTransition3 = enterTransition1113;
            exitTransition3 = exitTransitionPlus;
        } else {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            } else {
                enterTransitionPlus = enterTransition2;
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
            }
            int i11112 = i3 << 3;
            Modifier modifier1115 = modifier3;
            EnterTransition enterTransition1114 = enterTransitionPlus;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Boolean) obj).booleanValue());
                }
            }, modifier1115, enterTransition1114, exitTransitionPlus, function4, composerStartRestartGroup, (i11112 & 57344) | (i11112 & 896) | 48 | (i11112 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str3;
            modifier4 = modifier1115;
            enterTransition3 = enterTransition1114;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11113) {
                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier4, enterTransition3, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0050  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0062  */
    /* JADX WARN: Code duplicated, block: B:39:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0091  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x009e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x0109  */
    /* JADX WARN: Code duplicated, block: B:83:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x010f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0116  */
    /* JADX WARN: Code duplicated, block: B:90:0x014c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0159  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final ColumnScope columnScope, boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3 function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransitionPlus;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        String str2;
        int i9;
        Function3 function4;
        int i10;
        Modifier modifier3;
        ExitTransition exitTransitionPlus;
        String str3;
        final String str4;
        final Modifier modifier4;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1766503102);
        if ((i2 & 1) != 0) {
            i3 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i3 = i;
            }
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                        i5 = 2048;
                    } else {
                        i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            str2 = str;
                            if (composerStartRestartGroup.changed(str2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                            function4 = function3;
                        } else {
                            function4 = function3;
                            if ((i & 1572864) == 0) {
                                if (composerStartRestartGroup.changedInstance(function4)) {
                                    i10 = 1048576;
                                } else {
                                    i10 = 524288;
                                }
                                i3 |= i10;
                            }
                        }
                        if ((599185 & i3) == 599184 || !composerStartRestartGroup.getSkipping()) {
                            if (i11 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                            }
                            int i12 = i3 >> 3;
                            Modifier modifier5 = modifier3;
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i12 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Boolean) obj).booleanValue());
                                }
                            }, modifier5, enterTransition3, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i12));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str4 = str3;
                            modifier4 = modifier5;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str4 = str2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    str2 = str;
                    if ((i2 & 32) != 0) {
                        i3 |= 1572864;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((599185 & i3) == 599184) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i13 = i3 >> 3;
                        Modifier modifier6 = modifier3;
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i13 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier6, enterTransition4, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i13));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier6;
                        enterTransition2 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i14 = i3 >> 3;
                        Modifier modifier7 = modifier3;
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i14 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier7, enterTransition5, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier7;
                        enterTransition2 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 1572864;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((599185 & i3) == 599184) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i15 = i3 >> 3;
                        Modifier modifier8 = modifier3;
                        EnterTransition enterTransition6 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i15 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier8, enterTransition6, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i15));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier8;
                        enterTransition2 = enterTransition6;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i16 = i3 >> 3;
                        Modifier modifier9 = modifier3;
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i16 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier9, enterTransition7, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i16));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier9;
                        enterTransition2 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i17 = i3 >> 3;
                    Modifier modifier10 = modifier3;
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i17 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier10, enterTransition8, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i17));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier10;
                    enterTransition2 = enterTransition8;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i18 = i3 >> 3;
                    Modifier modifier11 = modifier3;
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i18 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier11, enterTransition9, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i18));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier11;
                    enterTransition2 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 1572864;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((599185 & i3) == 599184) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i19 = i3 >> 3;
                        Modifier modifier12 = modifier3;
                        EnterTransition enterTransition10 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i19 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier12, enterTransition10, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i19));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier12;
                        enterTransition2 = enterTransition10;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i110 = i3 >> 3;
                        Modifier modifier13 = modifier3;
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i110 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier13, enterTransition11, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i110));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier13;
                        enterTransition2 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i111 = i3 >> 3;
                    Modifier modifier14 = modifier3;
                    EnterTransition enterTransition12 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i111 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier14, enterTransition12, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier14;
                    enterTransition2 = enterTransition12;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i112 = i3 >> 3;
                    Modifier modifier15 = modifier3;
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i112 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier15, enterTransition13, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier15;
                    enterTransition2 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i113 = i3 >> 3;
                    Modifier modifier16 = modifier3;
                    EnterTransition enterTransition14 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i113 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier16, enterTransition14, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i113));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier16;
                    enterTransition2 = enterTransition14;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i114 = i3 >> 3;
                    Modifier modifier17 = modifier3;
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i114 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier17, enterTransition15, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i114));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier17;
                    enterTransition2 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 1572864;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((599185 & i3) == 599184) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i115 = i3 >> 3;
                Modifier modifier18 = modifier3;
                EnterTransition enterTransition16 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i115 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier18, enterTransition16, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i115));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier18;
                enterTransition2 = enterTransition16;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i116 = i3 >> 3;
                Modifier modifier19 = modifier3;
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i116 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier19, enterTransition17, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i116));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier19;
                enterTransition2 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransitionPlus = enterTransition;
                if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                    i5 = 2048;
                } else {
                    i5 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 1572864;
                        function4 = function3;
                    } else {
                        function4 = function3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((599185 & i3) == 599184) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i117 = i3 >> 3;
                        Modifier modifier110 = modifier3;
                        EnterTransition enterTransition18 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i117 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier110, enterTransition18, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i117));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier110;
                        enterTransition2 = enterTransition18;
                        exitTransition3 = exitTransitionPlus;
                    } else {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                        }
                        int i118 = i3 >> 3;
                        Modifier modifier111 = modifier3;
                        EnterTransition enterTransition19 = enterTransitionPlus;
                        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i118 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return invoke(((Boolean) obj).booleanValue());
                            }
                        }, modifier111, enterTransition19, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i118));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str4 = str3;
                        modifier4 = modifier111;
                        enterTransition2 = enterTransition19;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i119) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                str2 = str;
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i119 = i3 >> 3;
                    Modifier modifier112 = modifier3;
                    EnterTransition enterTransition110 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i119 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier112, enterTransition110, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i119));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier112;
                    enterTransition2 = enterTransition110;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i1110 = i3 >> 3;
                    Modifier modifier113 = modifier3;
                    EnterTransition enterTransition111 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1110 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier113, enterTransition111, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1110));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier113;
                    enterTransition2 = enterTransition111;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i1111 = i3 >> 3;
                    Modifier modifier114 = modifier3;
                    EnterTransition enterTransition112 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1111 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier114, enterTransition112, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier114;
                    enterTransition2 = enterTransition112;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i1112 = i3 >> 3;
                    Modifier modifier115 = modifier3;
                    EnterTransition enterTransition113 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1112 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier115, enterTransition113, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier115;
                    enterTransition2 = enterTransition113;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1113) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 1572864;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((599185 & i3) == 599184) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i1113 = i3 >> 3;
                Modifier modifier116 = modifier3;
                EnterTransition enterTransition114 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1113 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier116, enterTransition114, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1113));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier116;
                enterTransition2 = enterTransition114;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i1114 = i3 >> 3;
                Modifier modifier117 = modifier3;
                EnterTransition enterTransition115 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1114 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier117, enterTransition115, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1114));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier117;
                enterTransition2 = enterTransition115;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1115) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = Http2.INITIAL_MAX_FRAME_SIZE;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 1572864;
                    function4 = function3;
                } else {
                    function4 = function3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                }
                if ((599185 & i3) == 599184) {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i1115 = i3 >> 3;
                    Modifier modifier118 = modifier3;
                    EnterTransition enterTransition116 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1115 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier118, enterTransition116, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1115));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier118;
                    enterTransition2 = enterTransition116;
                    exitTransition3 = exitTransitionPlus;
                } else {
                    if (i11 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                    }
                    int i1116 = i3 >> 3;
                    Modifier modifier119 = modifier3;
                    EnterTransition enterTransition117 = enterTransitionPlus;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1116 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke(((Boolean) obj).booleanValue());
                        }
                    }, modifier119, enterTransition117, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1116));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier4 = modifier119;
                    enterTransition2 = enterTransition117;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1117) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            str2 = str;
            if ((i2 & 32) != 0) {
                i3 |= 1572864;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((599185 & i3) == 599184) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i1117 = i3 >> 3;
                Modifier modifier1110 = modifier3;
                EnterTransition enterTransition118 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1117 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1110, enterTransition118, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1117));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1110;
                enterTransition2 = enterTransition118;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i1118 = i3 >> 3;
                Modifier modifier1111 = modifier3;
                EnterTransition enterTransition119 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1118 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1111, enterTransition119, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1118));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1111;
                enterTransition2 = enterTransition119;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1119) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                i3 |= 1572864;
                function4 = function3;
            } else {
                function4 = function3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
            }
            if ((599185 & i3) == 599184) {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i1119 = i3 >> 3;
                Modifier modifier1112 = modifier3;
                EnterTransition enterTransition1110 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i1119 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1112, enterTransition1110, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i1119));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1112;
                enterTransition2 = enterTransition1110;
                exitTransition3 = exitTransitionPlus;
            } else {
                if (i11 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                int i11110 = i3 >> 3;
                Modifier modifier1113 = modifier3;
                EnterTransition enterTransition1111 = enterTransitionPlus;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i11110 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Boolean) obj).booleanValue());
                    }
                }, modifier1113, enterTransition1111, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i11110));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                modifier4 = modifier1113;
                enterTransition2 = enterTransition1111;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        str2 = str;
        if ((i2 & 32) != 0) {
            i3 |= 1572864;
            function4 = function3;
        } else {
            function4 = function3;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
        }
        if ((599185 & i3) == 599184) {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
            }
            int i11111 = i3 >> 3;
            Modifier modifier1114 = modifier3;
            EnterTransition enterTransition1112 = enterTransitionPlus;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i11111 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Boolean) obj).booleanValue());
                }
            }, modifier1114, enterTransition1112, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i11111));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str3;
            modifier4 = modifier1114;
            enterTransition2 = enterTransition1112;
            exitTransition3 = exitTransitionPlus;
        } else {
            if (i11 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
            }
            int i11112 = i3 >> 3;
            Modifier modifier1115 = modifier3;
            EnterTransition enterTransition1113 = enterTransitionPlus;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i11112 & 14) | ((i3 >> 12) & 112), 0), new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Boolean) obj).booleanValue());
                }
            }, modifier1115, enterTransition1113, exitTransitionPlus, function4, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i11112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str3;
            modifier4 = modifier1115;
            enterTransition2 = enterTransition1113;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11113) {
                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, z2, modifier4, enterTransition2, exitTransition3, str4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void AnimatedVisibilityImpl(final Transition transition, final Function1 function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3 function3, Composer composer, final int i) {
        int i2;
        ExitTransition exitTransition2;
        Composer composerStartRestartGroup = composer.startRestartGroup(429978603);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
        }
        if ((i & 24576) == 0) {
            exitTransition2 = exitTransition;
            i2 |= composerStartRestartGroup.changed(exitTransition2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i & 196608) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:693)");
            }
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m35invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m2536unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m35invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long jIntSize;
                        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !((Boolean) function1.invoke(transition.getTargetState())).booleanValue()) {
                            jIntSize = IntSize.Companion.m2613getZeroYbymL2g();
                        } else {
                            jIntSize = IntSizeKt.IntSize(placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight());
                        }
                        return MeasureScope.layout$default(measureScope, IntSize.m2609getWidthimpl(jIntSize), IntSize.m2608getHeightimpl(jIntSize), null, new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier, (Function3) objRememberedValue), enterTransition, exitTransition2, new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.2
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                    return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                }
            }, null, function3, composerStartRestartGroup, i3 | i4 | 196608 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void AnimatedEnterExitImpl(Transition transition, Function1 function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function2 function2, OnLookaheadMeasured onLookaheadMeasured, Function3 function3, Composer composer, int i, int i2) {
        int i3;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        final OnLookaheadMeasured onLookaheadMeasured2;
        Composer composer2;
        Modifier modifierLayout;
        OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured;
        Composer composerStartRestartGroup = composer.startRestartGroup(-891967166);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            enterTransition2 = enterTransition;
        } else {
            enterTransition2 = enterTransition;
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(enterTransition2) ? 2048 : IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
            }
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
            exitTransition2 = exitTransition;
        } else {
            exitTransition2 = exitTransition;
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changed(exitTransition2) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i4 = i2 & 64;
        int i5 = 1572864;
        if (i4 != 0) {
            i3 |= i5;
        } else if ((i & 1572864) == 0) {
            i5 = (i & 2097152) == 0 ? composerStartRestartGroup.changed(onLookaheadMeasured3) : composerStartRestartGroup.changedInstance(onLookaheadMeasured3) ? 1048576 : 524288;
            i3 |= i5;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i6 = i3;
        if ((4793491 & i6) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            onLookaheadMeasured2 = onLookaheadMeasured3;
            composer2 = composerStartRestartGroup;
        } else {
            if (i4 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891967166, i6, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:737)");
            }
            if (((Boolean) function1.invoke(transition.getTargetState())).booleanValue() || ((Boolean) function1.invoke(transition.getCurrentState())).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                composerStartRestartGroup.startReplaceGroup(1787977937);
                int i7 = i6 & 14;
                int i8 = i7 | 48;
                int i9 = i8 & 14;
                boolean z = ((i9 ^ 6) > 4 && composerStartRestartGroup.changed(transition)) || (i8 & 6) == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = transition.getCurrentState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                if (transition.isSeeking()) {
                    objRememberedValue = transition.getCurrentState();
                }
                composerStartRestartGroup.startReplaceGroup(-466616829);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                }
                int i10 = i6 & WebSocketProtocol.PAYLOAD_SHORT;
                EnterExitState enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, composerStartRestartGroup, i10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Object targetState = transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-466616829);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                }
                EnterExitState enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, targetState, composerStartRestartGroup, i10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                onLookaheadMeasured2 = onLookaheadMeasured3;
                Transition transitionCreateChildTransitionInternal = TransitionKt.createChildTransitionInternal(transition, enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2, "EnterExitTransition", composerStartRestartGroup, i9 | 3072);
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i6 >> 15) & 14);
                Object objInvoke = function2.invoke(transitionCreateChildTransitionInternal.getCurrentState(), transitionCreateChildTransitionInternal.getTargetState());
                boolean zChanged = composerStartRestartGroup.changed(transitionCreateChildTransitionInternal) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(transitionCreateChildTransitionInternal, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                State stateProduceState = SnapshotStateKt.produceState(objInvoke, (Function2) objRememberedValue2, composerStartRestartGroup, 0);
                if (getExitFinished(transitionCreateChildTransitionInternal) && AnimatedEnterExitImpl$lambda$4(stateProduceState)) {
                    composerStartRestartGroup.startReplaceGroup(1790256282);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1788869559);
                    boolean z2 = i7 == 4;
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                        objRememberedValue3 = new AnimatedVisibilityScopeImpl(transitionCreateChildTransitionInternal);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue3;
                    int i11 = i6 >> 6;
                    Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transitionCreateChildTransitionInternal, enterTransition2, exitTransition2, null, "Built-in", composerStartRestartGroup, (i11 & 896) | (i11 & 112) | 24576, 4);
                    composer2 = composerStartRestartGroup;
                    if (onLookaheadMeasured2 != null) {
                        composer2.startReplaceGroup(1789227361);
                        Modifier.Companion companion = Modifier.Companion;
                        boolean z3 = (3670016 & i6) == 1048576 || ((i6 & 2097152) != 0 && composer2.changedInstance(onLookaheadMeasured2));
                        Object objRememberedValue4 = composer2.rememberedValue();
                        if (z3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                            objRememberedValue4 = new Function3(onLookaheadMeasured2) { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return m34invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m2536unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m34invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
                                    if (measureScope.isLookingAhead()) {
                                        IntSizeKt.IntSize(placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight());
                                        throw null;
                                    }
                                    return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        modifierLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue4);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1581766416);
                        composer2.endReplaceGroup();
                        modifierLayout = Modifier.Companion;
                    }
                    Modifier modifierThen = modifier.then(modifierCreateModifier.then(modifierLayout));
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue5;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    Function0 constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM1086constructorimpl = Updater.m1086constructorimpl(composer2);
                    Updater.m1088setimpl(composerM1086constructorimpl, animatedEnterExitMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1088setimpl(composerM1086constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM1086constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1086constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM1086constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM1086constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1088setimpl(composerM1086constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i6 >> 18) & 112));
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1790262234);
                composerStartRestartGroup.endReplaceGroup();
                onLookaheadMeasured2 = onLookaheadMeasured3;
                composer2 = composerStartRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2(function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured2, function3, i, i2) { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
                final /* synthetic */ int $$changed;
                final /* synthetic */ int $$default;
                final /* synthetic */ Function3 $content;
                final /* synthetic */ EnterTransition $enter;
                final /* synthetic */ ExitTransition $exit;
                final /* synthetic */ Modifier $modifier;
                final /* synthetic */ Function2 $shouldDisposeBlock;
                final /* synthetic */ Function1 $visible;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$content = function3;
                    this.$$changed = i;
                    this.$$default = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i12) {
                    AnimatedVisibilityKt.AnimatedEnterExitImpl(this.$transition, this.$visible, this.$modifier, this.$enter, this.$exit, this.$shouldDisposeBlock, null, this.$content, composer3, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition transition) {
        Object currentState = transition.getCurrentState();
        EnterExitState enterExitState = EnterExitState.PostExit;
        return currentState == enterExitState && transition.getTargetState() == enterExitState;
    }

    private static final EnterExitState targetEnterExit(Transition transition, Function1 function1, Object obj, Composer composer, int i) {
        EnterExitState enterExitState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:855)");
        }
        composer.startMovableGroup(-902048200, transition);
        if (transition.isSeeking()) {
            composer.startReplaceGroup(2101296683);
            composer.endReplaceGroup();
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) function1.invoke(transition.getCurrentState())).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceGroup(2101530516);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            if (((Boolean) function1.invoke(transition.getCurrentState())).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return enterExitState;
    }
}
