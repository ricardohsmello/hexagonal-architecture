package br.com.ricas.util;

import java.util.UUID;

public class CheckUUID {

   public static boolean isUUID(String string) {
        try {
            UUID uuid = UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
