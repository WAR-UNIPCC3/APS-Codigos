package aps;
import aps.LerDados;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class SendPHP extends absPropriedades
{

    public SendPHP()
    {
	//Cria um Objeto JSON
        JSONObject jsonObject = new JSONObject();
        LerDados escrita = new LerDados();
        {
            this.Dadoslidos = escrita.Dadoslidos;
        }
		
	FileWriter writeFile = null;

	try{
		writeFile = new FileWriter("C:\\Users\\wthia\\Desktop\\Ciencia da Computação - UNIP\\APS\\APS 3\\saida.json");
		//Escreve no arquivo conteudo do Objeto JSON
		writeFile.write(jsonObject.toJSONString());
		writeFile.close();
            }
	catch(IOException e)
            {
                e.printStackTrace();
            }
                //Imprimne na Tela o Objeto JSON para vizualização
                System.out.println(jsonObject);
    
    }
    @Override
    public void Executar()
    {
    }
}