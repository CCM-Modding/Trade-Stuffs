/**
 * CCM Modding, ModJam
 */
package ccm.trade_stuffs.utils.helper.java;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * EncryptionHelper
 */
final class EncryptionHelper
{
    private static final String ALGO     = "AES";
    private static final byte[] keyValue = new byte[] { 'T',
            'h',
            'e',
            'B',
            'e',
            's',
            't',
            'S',
            'e',
            'c',
            'r',
            'e',
            't',
            'K',
            'e',
            'y'                         };

    public static String encrypt(final String Data) throws Exception
    {
        final Key key = generateKey();
        final Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        final byte[] encVal = c.doFinal(Data.getBytes());
        final String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(final String encryptedData) throws Exception
    {
        final Key key = generateKey();
        final Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        final byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        final byte[] decValue = c.doFinal(decordedValue);
        final String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception
    {
        final Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}