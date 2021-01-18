package signInViaSSO;

import org.jboss.aerogear.security.otp.Totp;

public class TOTPGenerator {

	public static String getTwoFactorCode() {
		Totp totp = new Totp("zo4sdheptxczc3jac6arh2n352yj6ksn"); // 2FA secret key
		String twoFactorCode = totp.now(); // Generated 2FA code here
		return twoFactorCode;
	}
}
