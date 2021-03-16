import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DataFormatException;

public interface DataSource
{
    public void writeData(Data data) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, ShortBufferException, InvalidKeyException;

    public Data readData() throws NoSuchPaddingException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException, ShortBufferException, IllegalBlockSizeException, InvalidAlgorithmParameterException, DataFormatException;
}
