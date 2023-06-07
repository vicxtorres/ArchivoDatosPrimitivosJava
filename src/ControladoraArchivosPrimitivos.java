import java.io.*;

public class ControladoraArchivosPrimitivos
{

    public static void grabarDatos() //con output
    {
        FileOutputStream fileOutputStream = null; //el file va a grabar efectivamente los bytes
        DataOutputStream dataOutputStream = null;

        try
        {
            fileOutputStream = new FileOutputStream("datosPrimitivos.data");
            dataOutputStream = new DataOutputStream(fileOutputStream); //relaciono el Data con el File

            //a la hora de levantar el archivo, hay que acordarse del orden en que ingresaron los datos
            for(int i=0; i<5; i++)
            {
                dataOutputStream.writeInt(i); //guardo indice
                dataOutputStream.writeUTF("registro #"+ (i+1)); //guardo registro
                dataOutputStream.writeBoolean(true);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        finally
        {
            try {
                if (fileOutputStream!=null)
                {
                    fileOutputStream.close(); //tmb lanza exception por eso el try-catch
                    dataOutputStream.close();
                }
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage()); //sout para ver si anda, no va aca
            }
        }
    }


    public static void leerDatos () //con input
    {
        FileInputStream fileInputStream=null;
        DataInputStream dataInputStream=null;

        try
        {
            fileInputStream = new FileInputStream("datosPrimitivos.data");
            dataInputStream = new DataInputStream(fileInputStream);

            //si conocemos la cantidad de registros guardados usamos el for
            //sino la mayoria de las veces hacemos lo siguiente:

            while(true) //lee hasta que se rompa
            {
                int unEntero = dataInputStream.readInt(); //guardo data en una variable
                String unString = dataInputStream.readUTF();
                Boolean unBoolean = dataInputStream.readBoolean();

                System.out.println(unEntero +" "+ unString +" "+ unBoolean);
            }
        }
        catch (EOFException ex)
        {
            System.out.println("Fin del archivo");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        finally
        {
            try {
                if (dataInputStream!=null)
                {
                    dataInputStream.close(); //tmb lanza exception por eso el try-catch
                    dataInputStream.close();
                }
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage()); //sout para ver si anda, no va aca
            }
        }
    }
}

