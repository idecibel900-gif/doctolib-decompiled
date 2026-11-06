package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1 function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo478mapZmokQxo(KeyEvent keyEvent) {
                if (((Boolean) function1.invoke(androidx.compose.ui.input.key.KeyEvent.m1711boximpl(keyEvent))).booleanValue() && KeyEvent_androidKt.m1727isShiftPressedZmokQxo(keyEvent)) {
                    if (Key.m1695equalsimpl0(KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m520getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (((Boolean) function1.invoke(androidx.compose.ui.input.key.KeyEvent.m1711boximpl(keyEvent))).booleanValue()) {
                    long jM1722getKeyZmokQxo = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m500getCEK5gGoQ()) ? true : Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m510getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m517getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m518getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m497getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m519getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m520getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m1726isCtrlPressedZmokQxo(keyEvent)) {
                    return null;
                }
                if (KeyEvent_androidKt.m1727isShiftPressedZmokQxo(keyEvent)) {
                    long jM1722getKeyZmokQxo2 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m505getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m506getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m507getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m504getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m514getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m513getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m512getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m511getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m510getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM1722getKeyZmokQxo3 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m505getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m506getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m507getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m504getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m514getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m513getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m512getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m511getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m508getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m499getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m503getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m515getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m502getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m501getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m516getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m1726isCtrlPressedZmokQxo(((androidx.compose.ui.input.key.KeyEvent) obj).m1716unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo478mapZmokQxo(KeyEvent keyEvent) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m1727isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m1726isCtrlPressedZmokQxo(keyEvent)) {
                    long jM1722getKeyZmokQxo = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m505getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m506getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m507getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m504getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m1726isCtrlPressedZmokQxo(keyEvent)) {
                    long jM1722getKeyZmokQxo2 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m505getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m506getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m507getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m504getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m509getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m503getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m499getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m498getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m1727isShiftPressedZmokQxo(keyEvent)) {
                    long jM1722getKeyZmokQxo3 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m512getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo3, mappedKeys3.m511getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m1725isAltPressedZmokQxo(keyEvent)) {
                    long jM1722getKeyZmokQxo4 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo4, mappedKeys4.m499getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo4, mappedKeys4.m503getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo478mapZmokQxo(keyEvent) : keyCommand;
            }
        };
    }
}
