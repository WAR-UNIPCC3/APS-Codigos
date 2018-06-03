package aps;

import gnu.io.SerialPort;
import java.io.InputStream;

public class FecharPorta extends absPropriedades
{

    public FecharPorta(int baudrate, int timeout, String Porta)
    {
        super(baudrate, timeout, Porta);
    }

    public FecharPorta(SerialPort porta)
    {
        super(porta);
        Executar();
    }

    @Override
    public void Executar()
    {
        try
        {
            porta.close();
        }
        catch (Exception e)
        {
        }
    }
    
}
