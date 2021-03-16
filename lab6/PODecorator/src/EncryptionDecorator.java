import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.DataFormatException;

public class EncryptionDecorator extends DataSourceDecorator
{
    private static SecretKeySpec secretKey;

    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public EncryptionDecorator(DataSource wrapper)
    {
        super(wrapper);
    }

    @Override
    public void writeData(Data data) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, ShortBufferException, InvalidKeyException
    {
        System.out.println("Encryptor received:" + Arrays.toString(data.getData()));
        setKey("ssshhhhhhhhhhh!!!!");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        data.setData(cipher.doFinal(data.getData()));
        System.out.println("Encryptor sent:" + Arrays.toString(data.getData()));
        super.writeData(data);
    }

    @Override
    public Data readData() throws NoSuchPaddingException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException, ShortBufferException, IllegalBlockSizeException, InvalidAlgorithmParameterException, DataFormatException
    {
        Data data = super.readData();
        System.out.println("Decryptor received:" + Arrays.toString(data.getData()));
        setKey("ssshhhhhhhhhhh!!!!");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        data.setData(cipher.doFinal(data.getData()));
        System.out.println("Decryptor sent:" + Arrays.toString(data.getData()));
        return data;
    }
}
