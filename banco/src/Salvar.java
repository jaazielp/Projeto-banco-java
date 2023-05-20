import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Salvar {
    private static File arquivo = new File("src/log/log");

    public static void salvarArquivo(Object obj) {
        try {
            arquivo.getParentFile().mkdirs();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));

            out.writeObject(obj);
            System.out.println("Deu boom!");

        } catch (Exception e) {
            System.out.println("falha ao salvar o arquivo");
        }

    }

    public static Object lerArquivo(){
        try {
            if(arquivo.exists() && arquivo.isFile()){
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
                System.out.println("Deu boom!");
                return in.readObject(); 
            }

        } catch (Exception e) {
            System.out.println("Falha ao ler o arquivo");
        }

        return null;
    }
}