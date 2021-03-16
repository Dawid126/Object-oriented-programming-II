import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileDataSource implements DataSource
{
    String filename;

    public FileDataSource(String filename)
    {
        this.filename = filename;
    }

    @Override
    public void writeData(Data data) throws IOException
    {
        Files.write(Paths.get(filename), data.getData());
    }

    @Override
    public Data readData() throws IOException
    {
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        Data data = new Data(bytes);
        return data;
    }
}
