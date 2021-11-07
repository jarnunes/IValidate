package com.ivalidate.model.base;

import org.apache.commons.lang3.math.NumberUtils;
import com.ivalidate.model.utils.ClearIdentity;

public class ValidateBase {

    private static boolean isSequence(String identity) {
        identity = ClearIdentity.clear(identity);
        int counter = 0;
        try {
            int aux = Integer.parseInt(String.valueOf(identity.charAt(0)));
            for (int i = 0; i < identity.length(); i++) {
                if (aux == Integer.parseInt(String.valueOf(identity.charAt(i)))) counter++;
            }
            return counter == identity.length();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isNumeric(String identity) {
        return NumberUtils.isParsable(identity);
    }

    public static boolean isValidBase(String identity) {
        if (isSequence(identity)) return false;

        return isNumeric(ClearIdentity.clear(identity));
    }
}
