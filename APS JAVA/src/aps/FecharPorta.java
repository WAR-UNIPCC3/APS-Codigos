package aps;

import gnu.io.SerialPort;
import java.io.InputStream;

public class FecharPorta extends absPropriedades
{

    public FecharPorta(String Porta, int baudrate, int timeout)
    {
        super(Porta, baudrate, timeout);
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
