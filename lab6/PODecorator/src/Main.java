import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.DataFormatException;

public class Main
{
    public static void main(String[] args) throws IOException, NoSuchPaddingException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, ShortBufferException, InvalidKeyException, DataFormatException
    {
        Data data = new Data("javaJestSuper".getBytes("UTF-8"));
        writeData(data, "test.txt");
        data = readData("test.txt");

        String text = new String(data.getData(), "UTF-8");
        System.out.println(text);
    }

    public static void writeData(Data data, String filename) throws IOException, NoSuchPaddingException, ShortBufferException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
    {
        DataSource dataSource = new EncryptionDecorator(new CompressionDecorator(new FileDataSource(filename)));
        dataSource.writeData(data);
    }

    public static Data readData(String filename) throws IOException, NoSuchPaddingException, ShortBufferException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, DataFormatException
    {
        DataSource dataSource = new EncryptionDecorator(new CompressionDecorator(new FileDataSource(filename)));
        return dataSource.readData();
    }
}
