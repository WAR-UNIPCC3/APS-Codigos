package Modelo;

import java.io.FileWriter; 
import org.json.simple.JSONObject;

public class GravacaoJson extends absPropriedades 
{
    public String mensagem;

    public GravacaoJson()
    {
        Executar();
    }
    @Override
    public void Executar()
    {
        this.mensagem = "";
        @SuppressWarnings("unchecked")
         
        JSONObject jsonObject = new JSONObject();
         
        FileWriter writeFile = null;
         
        jsonObject.put(null, this.getTexto());
         
        try
        {
            writeFile = new FileWriter("saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        }
        catch(Exception e)
        {
            this.mensagem = "Falha na gravação do arquivo JSON";
        } 
    }
       
}
