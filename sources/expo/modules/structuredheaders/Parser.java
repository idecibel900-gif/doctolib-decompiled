package expo.modules.structuredheaders;

import android.util.Base64;
import com.amazon.a.a.o.b.f;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class Parser {
    private static char EOD = 65535;
    private final CharBuffer input;
    private final List startPositions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Parser(String str) {
        this(Collections.singletonList(str));
        Objects.requireNonNull(str, "input must not be null");
    }

    public Parser(Iterable iterable) {
        List arrayList = Collections.EMPTY_LIST;
        Objects.requireNonNull(iterable, "fieldLines must not be null");
        Iterator it = iterable.iterator();
        String strCheckASCII = null;
        StringBuilder sb = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (strCheckASCII == null) {
                strCheckASCII = checkASCII(str);
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                    sb.append(strCheckASCII);
                }
                arrayList = arrayList.size() == 0 ? new ArrayList() : arrayList;
                arrayList.add(Integer.valueOf(sb.length()));
                sb.append(f.a);
                sb.append(checkASCII(str));
            }
        }
        if (strCheckASCII == null && sb == null) {
            throw new ParseException("Empty input", "", 0);
        }
        this.input = CharBuffer.wrap(sb != null ? sb : strCheckASCII);
        this.startPositions = arrayList;
    }

    private static String checkASCII(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 0 || cCharAt > 127) {
                throw new ParseException(String.format("Invalid character in field line at position %d: '%c' (0x%04x) (input: %s)", Integer.valueOf(i), Character.valueOf(cCharAt), Integer.valueOf(cCharAt), str), str, i);
            }
        }
        return str;
    }

    private NumberItem internalParseBareIntegerOrDecimal() {
        int i;
        StringBuilder sb = new StringBuilder(20);
        if (checkNextChar('-')) {
            advance();
            i = -1;
        } else {
            i = 1;
        }
        if (!checkNextChar("0123456789")) {
            throw complaint("Illegal start for Integer or Decimal: '" + ((Object) this.input) + "'");
        }
        boolean z = false;
        boolean z2 = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (Utils.isDigit(cPeek)) {
                sb.append(cPeek);
                advance();
            } else if (z2 || cPeek != '.') {
                z = true;
            } else {
                if (sb.length() > 12) {
                    throw complaint("Illegal position for decimal point in Decimal after '" + ((Object) sb) + "'");
                }
                sb.append(cPeek);
                advance();
                z2 = true;
            }
            if (sb.length() > (z2 ? 16 : 15)) {
                backout();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z2 ? "Decimal" : "Integer");
                sb2.append(" too long: ");
                sb2.append(sb.length());
                sb2.append(" characters");
                throw complaint(sb2.toString());
            }
        }
        if (!z2) {
            return IntegerItem.valueOf(((long) i) * Long.parseLong(sb.toString()));
        }
        int iIndexOf = sb.indexOf(".");
        int length = (sb.length() - iIndexOf) - 1;
        if (length < 1) {
            backout();
            throw complaint("Decimal must not end in '.'");
        }
        if (length == 1) {
            sb.append("00");
        } else if (length == 2) {
            sb.append("0");
        } else if (length > 3) {
            backout();
            throw complaint("Maximum number of fractional digits is 3, found: " + length + ", in: " + ((Object) sb));
        }
        sb.deleteCharAt(iIndexOf);
        return DecimalItem.valueOf(((long) i) * Long.parseLong(sb.toString()));
    }

    private StringItem internalParseBareString() {
        if (getOrEOD() != '\"') {
            throw complaint("String must start with double quote: '" + ((Object) this.input) + "'");
        }
        StringBuilder sb = new StringBuilder(length());
        while (hasRemaining()) {
            if (this.startPositions.contains(Integer.valueOf(position()))) {
                throw complaint("String crosses field line boundary at position " + position());
            }
            char c = get();
            if (c == '\\') {
                char orEOD = getOrEOD();
                if (orEOD == EOD) {
                    throw complaint("Incomplete escape sequence at position " + position());
                }
                if (orEOD != '\"' && orEOD != '\\') {
                    backout();
                    throw complaint("Invalid escape sequence character '" + orEOD + "' at position " + position());
                }
                sb.append(orEOD);
            } else {
                if (c == '\"') {
                    return StringItem.valueOf(sb.toString());
                }
                if (c < ' ' || c >= 127) {
                    throw complaint("Invalid character in String at position " + position());
                }
                sb.append(c);
            }
        }
        throw complaint("Closing DQUOTE missing");
    }

    private TokenItem internalParseBareToken() {
        char orEOD = getOrEOD();
        if (orEOD != '*' && !Utils.isAlpha(orEOD)) {
            throw complaint("Token must start with ALPHA or *: '" + ((Object) this.input) + "'");
        }
        StringBuilder sb = new StringBuilder(length());
        sb.append(orEOD);
        boolean z = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (cPeek <= ' ' || cPeek >= 127 || "\"(),;<=>?@[\\]{}".indexOf(cPeek) >= 0) {
                z = true;
            } else {
                advance();
                sb.append(cPeek);
            }
        }
        return TokenItem.valueOf(sb.toString());
    }

    private static boolean isBase64Char(char c) {
        return Utils.isAlpha(c) || Utils.isDigit(c) || c == '+' || c == '/' || c == '=';
    }

    private ByteSequenceItem internalParseBareByteSequence() {
        if (getOrEOD() != ':') {
            throw complaint("Byte Sequence must start with colon: " + ((Object) this.input));
        }
        StringBuilder sb = new StringBuilder(length());
        boolean z = false;
        while (hasRemaining() && !z) {
            char c = get();
            if (c == ':') {
                z = true;
            } else {
                if (!isBase64Char(c)) {
                    throw complaint("Invalid Byte Sequence Character '" + c + "' at position " + position());
                }
                sb.append(c);
            }
        }
        if (!z) {
            throw complaint("Byte Sequence must end with COLON: '" + ((Object) sb) + "'");
        }
        try {
            return ByteSequenceItem.valueOf(Base64.decode(sb.toString(), 0));
        } catch (IllegalArgumentException e) {
            throw complaint(e.getMessage(), e);
        }
    }

    private BooleanItem internalParseBareBoolean() {
        char orEOD = getOrEOD();
        if (orEOD == EOD) {
            throw complaint("Missing data in Boolean");
        }
        if (orEOD != '?') {
            backout();
            throw complaint(String.format("Boolean must start with question mark, got '%c'", Character.valueOf(orEOD)));
        }
        char orEOD2 = getOrEOD();
        if (orEOD2 == EOD) {
            throw complaint("Missing data in Boolean");
        }
        if (orEOD2 != '0' && orEOD2 != '1') {
            backout();
            throw complaint(String.format("Expected '0' or '1' in Boolean, found '%c'", Character.valueOf(orEOD2)));
        }
        return BooleanItem.valueOf(orEOD2 == '1');
    }

    private String internalParseKey() {
        char orEOD = getOrEOD();
        if (orEOD == EOD) {
            throw complaint("Missing data in Key");
        }
        if (orEOD != '*' && !Utils.isLcAlpha(orEOD)) {
            backout();
            throw complaint("Key must start with LCALPHA or '*': " + format(orEOD));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(orEOD);
        boolean z = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (Utils.isLcAlpha(cPeek) || Utils.isDigit(cPeek) || cPeek == '_' || cPeek == '-' || cPeek == '.' || cPeek == '*') {
                sb.append(cPeek);
                advance();
            } else {
                z = true;
            }
        }
        return sb.toString();
    }

    private Parameters internalParseParameters() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        while (hasRemaining() && !z) {
            if (peek() != ';') {
                z = true;
            } else {
                advance();
                removeLeadingSP();
                String strInternalParseKey = internalParseKey();
                Item itemValueOf = BooleanItem.valueOf(true);
                if (peek() == '=') {
                    advance();
                    itemValueOf = internalParseBareItem();
                }
                linkedHashMap.put(strInternalParseKey, itemValueOf);
            }
        }
        return Parameters.valueOf(linkedHashMap);
    }

    private Item internalParseBareItem() {
        if (!hasRemaining()) {
            throw complaint("Empty string found when parsing Bare Item");
        }
        char cPeek = peek();
        if (Utils.isDigit(cPeek) || cPeek == '-') {
            return internalParseBareIntegerOrDecimal();
        }
        if (cPeek == '\"') {
            return internalParseBareString();
        }
        if (cPeek == '?') {
            return internalParseBareBoolean();
        }
        if (cPeek == '*' || Utils.isAlpha(cPeek)) {
            return internalParseBareToken();
        }
        if (cPeek == ':') {
            return internalParseBareByteSequence();
        }
        throw complaint("Unexpected start character in Bare Item: " + format(cPeek));
    }

    private Item internalParseItem() {
        return internalParseBareItem().withParams(internalParseParameters());
    }

    private ListElement internalParseItemOrInnerList() {
        return peek() == '(' ? internalParseInnerList() : internalParseItem();
    }

    private List internalParseBareInnerList() {
        if (getOrEOD() != '(') {
            throw complaint("Inner List must start with '(': " + ((Object) this.input));
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (hasRemaining() && !z) {
            removeLeadingSP();
            if (peek() == ')') {
                advance();
                z = true;
            } else {
                arrayList.add(internalParseItem());
                char cPeek = peek();
                if (cPeek == EOD) {
                    throw complaint("Missing data in Inner List");
                }
                if (cPeek != ' ' && cPeek != ')') {
                    throw complaint("Expected SP or ')' in Inner List, got: " + format(cPeek));
                }
            }
        }
        if (z) {
            return arrayList;
        }
        throw complaint("Inner List must end with ')': " + ((Object) this.input));
    }

    private InnerList internalParseInnerList() {
        List listInternalParseBareInnerList = internalParseBareInnerList();
        return InnerList.valueOf(listInternalParseBareInnerList).withParams(internalParseParameters());
    }

    private Dictionary internalParseDictionary() {
        ListElement listElementWithParams;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        while (hasRemaining() && !z) {
            String strInternalParseKey = internalParseKey();
            if (peek() == '=') {
                advance();
                listElementWithParams = internalParseItemOrInnerList();
            } else {
                listElementWithParams = BooleanItem.valueOf(true).withParams(internalParseParameters());
            }
            linkedHashMap.put(strInternalParseKey, listElementWithParams);
            removeLeadingOWS();
            if (hasRemaining()) {
                char c = get();
                if (c != ',') {
                    backout();
                    throw complaint("Expected COMMA in Dictionary, found: " + format(c));
                }
                removeLeadingOWS();
                if (!hasRemaining()) {
                    throw complaint("Found trailing COMMA in Dictionary");
                }
            } else {
                z = true;
            }
        }
        return Dictionary.valueOf(linkedHashMap);
    }

    public Dictionary parseDictionary() {
        removeLeadingSP();
        Dictionary dictionaryInternalParseDictionary = internalParseDictionary();
        removeLeadingSP();
        assertEmpty("Extra characters in string parsed as Dictionary");
        return dictionaryInternalParseDictionary;
    }

    private void assertEmpty(String str) {
        if (hasRemaining()) {
            throw complaint(String.format(str, Integer.valueOf(position()), this.input));
        }
    }

    private void advance() {
        CharBuffer charBuffer = this.input;
        charBuffer.position(charBuffer.position() + 1);
    }

    private void backout() {
        CharBuffer charBuffer = this.input;
        charBuffer.position(charBuffer.position() - 1);
    }

    private boolean checkNextChar(char c) {
        return hasRemaining() && this.input.charAt(0) == c;
    }

    private boolean checkNextChar(String str) {
        return hasRemaining() && str.indexOf(this.input.charAt(0)) >= 0;
    }

    private char get() {
        return this.input.get();
    }

    private char getOrEOD() {
        return hasRemaining() ? get() : EOD;
    }

    private boolean hasRemaining() {
        return this.input.hasRemaining();
    }

    private int length() {
        return this.input.length();
    }

    private char peek() {
        return hasRemaining() ? this.input.charAt(0) : EOD;
    }

    private int position() {
        return this.input.position();
    }

    private void removeLeadingSP() {
        while (checkNextChar(' ')) {
            advance();
        }
    }

    private void removeLeadingOWS() {
        while (checkNextChar(" \t")) {
            advance();
        }
    }

    private ParseException complaint(String str) {
        return new ParseException(str, this.input);
    }

    private ParseException complaint(String str, Throwable th) {
        return new ParseException(str, this.input, th);
    }

    private static String format(char c) {
        String str;
        if (c == '\t') {
            str = "HTAB";
        } else {
            str = "'" + c + "'";
        }
        return String.format("%s (\\u%04x)", str, Integer.valueOf(c));
    }
}
