import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.*;

public class CompressionDecorator extends DataSourceDecorator
{
    public CompressionDecorator(DataSource wrapper)
    {
        super(wrapper);
    }

    @Override
    public void writeData(Data data) throws IOException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, ShortBufferException, InvalidAlgorithmParameterException
    {
        System.out.println("Compressor received: " + Arrays.toString(data.getData()));
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.getData().length);
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getData());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        data.setData(compressed);
        System.out.println("Compressor sent: " + Arrays.toString(data.getData()));
        super.writeData(data);
    }

    @Override
    public Data readData() throws IOException, NoSuchAlgorithmException, DataFormatException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, ShortBufferException, IllegalBlockSizeException
    {
        Data data = super.readData();
        System.out.println("Decompressor received: " + Arrays.toString(data.getData()));
        ByteArrayInputStream bis = new ByteArrayInputStream(data.getData());
        GZIPInputStream gis = new GZIPInputStream(bis);
        data.setData(gis.readAllBytes());
        gis.close();
        bis.close();
        System.out.println("Decompressor sent: " + Arrays.toString(data.getData()));
        return data;
    }
}
