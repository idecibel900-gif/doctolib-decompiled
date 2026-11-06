package org.commonmark.internal.util;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Parsing {
    public static int CODE_BLOCK_INDENT = 4;

    public static boolean isEscapable(char c) {
        switch (c) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (c) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (c) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case CodeVerifierUtil.MAX_CODE_VERIFIER_ENTROPY /* 96 */:
                                return true;
                            default:
                                switch (c) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static int columnsToNextTabStop(int i) {
        return 4 - (i % 4);
    }

    public static int find(char c, CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int findLineBreak(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\n' || cCharAt == '\r') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean isBlank(CharSequence charSequence) {
        return findNonSpace(charSequence, 0) == -1;
    }

    public static boolean hasNonSpace(CharSequence charSequence) {
        int length = charSequence.length();
        return skip(' ', charSequence, 0, length) != length;
    }

    public static boolean isLetter(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static boolean isSpaceOrTab(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i);
        return cCharAt == '\t' || cCharAt == ' ';
    }

    public static boolean isPunctuationCodePoint(int i) {
        int type = Character.getType(i);
        if (type != 29 && type != 30) {
            switch (type) {
                default:
                    if (i != 36 && i != 43 && i != 94 && i != 96 && i != 124 && i != 126) {
                        switch (i) {
                            case 60:
                            case 61:
                            case 62:
                                break;
                            default:
                                return false;
                        }
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    return true;
            }
        }
        return true;
    }

    public static boolean isWhitespaceCodePoint(int i) {
        return i == 9 || i == 10 || i == 12 || i == 13 || i == 32 || Character.getType(i) == 12;
    }

    public static CharSequence prepareLine(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 0) {
                if (sb == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                }
                sb.append((char) 65533);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static int skip(char c, CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipBackwards(char c, CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    public static int skipSpaceTab(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipSpaceTabBackwards(CharSequence charSequence, int i, int i2) {
        while (i >= i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i--;
        }
        return i2 - 1;
    }

    private static int findNonSpace(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ') {
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case BaseVideoCapturer.RGBA /* 11 */:
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    case '\r':
                        break;
                    default:
                        return i;
                }
            }
            i++;
        }
        return -1;
    }
}
