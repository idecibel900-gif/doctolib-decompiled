package com.amazon.device.simplesignin.model;

/* JADX INFO: loaded from: classes3.dex */
public class Token {
    private String schema;
    private String token;

    public void setSchema(String str) {
        this.schema = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof Token;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        if (!token.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = token.getToken();
        if (token2 != null ? !token2.equals(token3) : token3 != null) {
            return false;
        }
        String schema = getSchema();
        String schema2 = token.getSchema();
        return schema != null ? schema.equals(schema2) : schema2 == null;
    }

    public int hashCode() {
        String token = getToken();
        int iHashCode = token == null ? 43 : token.hashCode();
        String schema = getSchema();
        return ((iHashCode + 59) * 59) + (schema != null ? schema.hashCode() : 43);
    }

    public String getToken() {
        return this.token;
    }

    public String getSchema() {
        return this.schema;
    }
}
