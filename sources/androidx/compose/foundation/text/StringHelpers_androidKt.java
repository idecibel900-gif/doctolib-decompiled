package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringHelpers_androidKt {
    public static final int findPrecedingBreak(String str, int i) {
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            Integer numValueOf = Integer.valueOf(emojiCompatIfLoaded.getEmojiStart(str, Math.max(0, i - 1)));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final int findFollowingBreak(String str, int i) {
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            Integer numValueOf = Integer.valueOf(emojiCompatIfLoaded.getEmojiEnd(str, i));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i);
    }

    private static final EmojiCompat getEmojiCompatIfLoaded() {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() == 1) {
                return emojiCompat;
            }
        }
        return null;
    }
}
