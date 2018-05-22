package SerialComunicacao;

import aps.FecharPorta;
import aps.LerDados;
import aps.Porta;
import aps.absPropriedades;
import gnu.io.SerialPort;
import java.io.InputStream;

public class Main extends absPropriedades
{
    
    /**
     * @param args the command line arguments
     */
    public Main()
    {
        
    }
    public Main(String Porta, int baudrate, int timeout)
    {
        super(Porta, baudrate, timeout);
    }

    public Main(SerialPort porta)
    {
        super(porta);
    }


    @Override
    public void Executar()
    {
        
    }
    
    public static void main(String[] args) 
    {
        
    }
    public String obterPorta()
    {
        return Porta;
    }
    
    public int obterBaudrate()
    {
        return baudrate;
    }
   
} 

