package org.example;

import java.util.Random;

public class RandomOtpGenerator implements OtpGenerator {
    private final Random random = new Random();

    @Override
    public String generateOtp() {
        int otp = 100000 + random.nextInt(900000); // ensures 6-digit
        return String.valueOf(otp);
    }
}
