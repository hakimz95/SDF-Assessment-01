package task02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        String hostname = "68.183.239.26";
        int port = 80;

        try {
            //Connect to the assigned server at port 80
            Socket soc = new Socket(hostname, port);
            System.out.println("Connected to server");

            OutputStream os = soc.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            InputStream is = soc.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            System.out.println("Testing if it hangs");
            try {
                String [] response = ois.readUTF().split(" ");
                String requestId = response[0];
                String numList = response[1];
                System.out.println(requestId.trim());
                System.out.println(numList);
                String [] stringList = numList.split(",");
                System.out.println(Arrays.toString(stringList));

                int num = stringList.length;
                int [] numArray = new int [num];
                for (int i = 0 ; i < num; i++) {
                    numArray[i] = Integer.parseInt(stringList[i]);
                }

                double[] doubles = Arrays.stream(numArray).asDoubleStream().toArray();
                double total = 0;

                for (int i = 0; i < doubles.length; i++) {
                    total = total + doubles[i];
                }

                double average = total/doubles.length;
                float averageInput = (float) average;

                System.out.printf("The average is: %.3f \n", average);

                oos.writeUTF(requestId);
                oos.writeUTF("Abdul Hakim Bin Abdul Ranie");
                oos.writeUTF("abdhakim119@gmail.com");
                oos.writeFloat(averageInput);
                oos.flush();

                boolean b = ois.readBoolean();
                System.out.println("boolean : " + b);

                if (b == true) {
                    soc.close();
                    System.out.println("SUCCESS");
                }
                else {
                    System.out.println("FAILED");
                    System.out.println("Error:");
                    System.out.println(ois.readUTF());
                }

            }
            catch (IOException e){
                e.printStackTrace();
            }

            os.close();
            is.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
