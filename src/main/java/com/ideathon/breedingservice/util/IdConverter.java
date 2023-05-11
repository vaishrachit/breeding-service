package com.ideathon.breedingservice.util;

import java.util.UUID;

import org.bson.types.Binary;

public class IdConverter {

    /**
     * Convert a UUID object to a Binary with a subtype 0x04
     */
    public static Binary toStandardBinaryUUID(java.util.UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();

        byte[] uuidBytes = new byte[16];

        for (int i = 15; i >= 8; i--) {
            uuidBytes[i] = (byte) (lsb & 0xFFL);
            lsb >>= 8;
        }

        for (int i = 7; i >= 0; i--) {
            uuidBytes[i] = (byte) (msb & 0xFFL);
            msb >>= 8;
        }

        return new Binary((byte) 0x04, uuidBytes);
    }

    /**
     * Convert a Binary with a subtype 0x04 to a UUID object
     */
    public static UUID fromStandardBinaryUUID(Binary binary) {
        long msb = 0;
        long lsb = 0;
        byte[] uuidBytes = binary.getData();

        for (int i = 8; i < 16; i++) {
            lsb <<= 8;
            lsb |= uuidBytes[i] & 0xFFL;
        }

        for (int i = 0; i < 8; i++) {
            msb <<= 8;
            msb |= uuidBytes[i] & 0xFFL;
        }

        return new UUID(msb, lsb);
    }


}
