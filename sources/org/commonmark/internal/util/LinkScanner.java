package org.commonmark.internal.util;

import org.commonmark.internal.inline.Scanner;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LinkScanner {
    public static boolean scanLinkLabelContent(Scanner scanner) {
        while (scanner.hasNext()) {
            switch (scanner.peek()) {
                case '[':
                    return false;
                case '\\':
                    scanner.next();
                    if (Parsing.isEscapable(scanner.peek())) {
                        scanner.next();
                    }
                    break;
                case ']':
                    return true;
                default:
                    scanner.next();
                    break;
            }
        }
        return true;
    }

    public static boolean scanLinkDestination(Scanner scanner) {
        char cPeek;
        if (!scanner.hasNext()) {
            return false;
        }
        if (scanner.next('<')) {
            while (scanner.hasNext() && (cPeek = scanner.peek()) != '\n' && cPeek != '<') {
                if (cPeek == '>') {
                    scanner.next();
                    return true;
                }
                if (cPeek == '\\') {
                    scanner.next();
                    if (Parsing.isEscapable(scanner.peek())) {
                        scanner.next();
                    }
                } else {
                    scanner.next();
                }
            }
            return false;
        }
        return scanLinkDestinationWithBalancedParens(scanner);
    }

    public static boolean scanLinkTitle(Scanner scanner) {
        if (!scanner.hasNext()) {
            return false;
        }
        char cPeek = scanner.peek();
        char c = '\"';
        if (cPeek != '\"') {
            c = '\'';
            if (cPeek != '\'') {
                if (cPeek != '(') {
                    return false;
                }
                c = ')';
            }
        }
        scanner.next();
        if (!scanLinkTitleContent(scanner, c) || !scanner.hasNext()) {
            return false;
        }
        scanner.next();
        return true;
    }

    public static boolean scanLinkTitleContent(Scanner scanner, char c) {
        while (scanner.hasNext()) {
            char cPeek = scanner.peek();
            if (cPeek == '\\') {
                scanner.next();
                if (Parsing.isEscapable(scanner.peek())) {
                    scanner.next();
                }
            } else {
                if (cPeek == c) {
                    return true;
                }
                if (c == ')' && cPeek == '(') {
                    return false;
                }
                scanner.next();
            }
        }
        return true;
    }

    private static boolean scanLinkDestinationWithBalancedParens(Scanner scanner) {
        int i = 0;
        boolean z = true;
        while (scanner.hasNext()) {
            char cPeek = scanner.peek();
            if (cPeek == ' ') {
                return !z;
            }
            if (cPeek == '\\') {
                scanner.next();
                if (Parsing.isEscapable(scanner.peek())) {
                    scanner.next();
                }
            } else if (cPeek == '(') {
                i++;
                if (i > 32) {
                    return false;
                }
                scanner.next();
            } else if (cPeek != ')') {
                if (Character.isISOControl(cPeek)) {
                    return !z;
                }
                scanner.next();
            } else {
                if (i == 0) {
                    return true;
                }
                i--;
                scanner.next();
            }
            z = false;
        }
        return true;
    }
}
