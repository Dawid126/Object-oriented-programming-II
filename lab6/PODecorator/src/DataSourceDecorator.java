import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DataFormatException;

public class DataSourceDecorator implements DataSource
{
    private DataSource wrapper;

    public DataSourceDecorator(DataSource wrapper)
    {
        this.wrapper = wrapper;
    }

    @Override
    public void writeData(Data data) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException
    {
        wrapper.writeData(data);
    }

    @Override
    public Data readData() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, DataFormatException
    {
        return wrapper.readData();
    }
}
