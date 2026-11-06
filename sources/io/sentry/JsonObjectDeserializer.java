package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonObjectDeserializer {
    private final ArrayList tokens = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    interface NextValue {
        Object nextValue();
    }

    private interface Token {
        Object getValue();
    }

    private static final class TokenName implements Token {
        final String value;

        TokenName(String str) {
            this.value = str;
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenPrimitive implements Token {
        final Object value;

        TokenPrimitive(Object obj) {
            this.value = obj;
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenArray implements Token {
        final ArrayList value;

        private TokenArray() {
            this.value = new ArrayList();
        }

        /* synthetic */ TokenArray(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public Object getValue() {
            return this.value;
        }
    }

    private static final class TokenMap implements Token {
        final HashMap value;

        private TokenMap() {
            this.value = new HashMap();
        }

        /* synthetic */ TokenMap(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public Object getValue() {
            return this.value;
        }
    }

    public Object deserialize(JsonObjectReader jsonObjectReader) {
        parse(jsonObjectReader);
        Token currentToken = getCurrentToken();
        if (currentToken != null) {
            return currentToken.getValue();
        }
        return null;
    }

    /* JADX INFO: renamed from: io.sentry.JsonObjectDeserializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$vendor$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$io$sentry$vendor$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$sentry$vendor$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void parse(final JsonObjectReader jsonObjectReader) {
        boolean zHandleArrayOrMapEnd = false;
        while (!zHandleArrayOrMapEnd) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$io$sentry$vendor$gson$stream$JsonToken[jsonObjectReader.peek().ordinal()]) {
                case 1:
                    jsonObjectReader.beginArray();
                    pushCurrentToken(new TokenArray(anonymousClass1));
                    break;
                case 2:
                    jsonObjectReader.endArray();
                    zHandleArrayOrMapEnd = handleArrayOrMapEnd();
                    break;
                case 3:
                    jsonObjectReader.beginObject();
                    pushCurrentToken(new TokenMap(anonymousClass1));
                    break;
                case 4:
                    jsonObjectReader.endObject();
                    zHandleArrayOrMapEnd = handleArrayOrMapEnd();
                    break;
                case 5:
                    pushCurrentToken(new TokenName(jsonObjectReader.nextName()));
                    break;
                case 6:
                    zHandleArrayOrMapEnd = handlePrimitive(new NextValue() { // from class: io.sentry.JsonObjectDeserializer$$ExternalSyntheticLambda0
                        @Override // io.sentry.JsonObjectDeserializer.NextValue
                        public final Object nextValue() {
                            return jsonObjectReader.nextString();
                        }
                    });
                    break;
                case 7:
                    zHandleArrayOrMapEnd = handlePrimitive(new NextValue() { // from class: io.sentry.JsonObjectDeserializer$$ExternalSyntheticLambda1
                        @Override // io.sentry.JsonObjectDeserializer.NextValue
                        public final Object nextValue() {
                            return this.f$0.nextNumber(jsonObjectReader);
                        }
                    });
                    break;
                case 8:
                    zHandleArrayOrMapEnd = handlePrimitive(new NextValue() { // from class: io.sentry.JsonObjectDeserializer$$ExternalSyntheticLambda2
                        @Override // io.sentry.JsonObjectDeserializer.NextValue
                        public final Object nextValue() {
                            return Boolean.valueOf(jsonObjectReader.nextBoolean());
                        }
                    });
                    break;
                case 9:
                    jsonObjectReader.nextNull();
                    zHandleArrayOrMapEnd = handlePrimitive(new NextValue() { // from class: io.sentry.JsonObjectDeserializer$$ExternalSyntheticLambda3
                        @Override // io.sentry.JsonObjectDeserializer.NextValue
                        public final Object nextValue() {
                            return JsonObjectDeserializer.$r8$lambda$M1FauFi3Kg79ELFA_rj0HL0B1VM();
                        }
                    });
                    break;
                case 10:
                    zHandleArrayOrMapEnd = true;
                    break;
            }
        }
    }

    public static /* synthetic */ Object $r8$lambda$M1FauFi3Kg79ELFA_rj0HL0B1VM() {
        return null;
    }

    private boolean handleArrayOrMapEnd() {
        if (hasOneToken()) {
            return true;
        }
        Token currentToken = getCurrentToken();
        popCurrentToken();
        if (getCurrentToken() instanceof TokenName) {
            TokenName tokenName = (TokenName) getCurrentToken();
            popCurrentToken();
            TokenMap tokenMap = (TokenMap) getCurrentToken();
            if (tokenName == null || currentToken == null || tokenMap == null) {
                return false;
            }
            tokenMap.value.put(tokenName.value, currentToken.getValue());
            return false;
        }
        if (!(getCurrentToken() instanceof TokenArray)) {
            return false;
        }
        TokenArray tokenArray = (TokenArray) getCurrentToken();
        if (currentToken == null || tokenArray == null) {
            return false;
        }
        tokenArray.value.add(currentToken.getValue());
        return false;
    }

    private boolean handlePrimitive(NextValue nextValue) {
        Object objNextValue = nextValue.nextValue();
        if (getCurrentToken() == null && objNextValue != null) {
            pushCurrentToken(new TokenPrimitive(objNextValue));
            return true;
        }
        if (getCurrentToken() instanceof TokenName) {
            TokenName tokenName = (TokenName) getCurrentToken();
            popCurrentToken();
            ((TokenMap) getCurrentToken()).value.put(tokenName.value, objNextValue);
            return false;
        }
        if (!(getCurrentToken() instanceof TokenArray)) {
            return false;
        }
        ((TokenArray) getCurrentToken()).value.add(objNextValue);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object nextNumber(JsonObjectReader jsonObjectReader) {
        try {
            try {
                return Integer.valueOf(jsonObjectReader.nextInt());
            } catch (Exception unused) {
                return Double.valueOf(jsonObjectReader.nextDouble());
            }
        } catch (Exception unused2) {
            return Long.valueOf(jsonObjectReader.nextLong());
        }
    }

    private Token getCurrentToken() {
        if (this.tokens.isEmpty()) {
            return null;
        }
        ArrayList arrayList = this.tokens;
        return (Token) arrayList.get(arrayList.size() - 1);
    }

    private void pushCurrentToken(Token token) {
        this.tokens.add(token);
    }

    private void popCurrentToken() {
        if (this.tokens.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.tokens;
        arrayList.remove(arrayList.size() - 1);
    }

    private boolean hasOneToken() {
        return this.tokens.size() == 1;
    }
}
