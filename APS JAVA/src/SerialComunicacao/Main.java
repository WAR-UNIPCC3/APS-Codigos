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

    public Main(int baudrate, int timeout, String Porta)
    {
        super(baudrate, timeout, Porta);
    }
    

    public Main(SerialPort porta)
    {
        super(porta);
    }

    public Main(String Dadoslidos)
    {
        super(Dadoslidos);
        Executar();
    }

    @Override
    public void Executar()
    {
        System.out.println(this.Dadoslidos);
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

