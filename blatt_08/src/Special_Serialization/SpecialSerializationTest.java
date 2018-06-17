package Special_Serialization;

import java.io.*;
import test.Assert;

public class SpecialSerializationTest {
    public static void main( String[] args ) {
        int tSize = 10;
        HashFunction function = new DefaultHashFunction();
        OpenHashSet test = new OpenHashSet( tSize, function );

        for( int i = 0; i < tSize; i++ ) {
            String add = "" + i;
            test.insert(add);
        }

        // Serialization

        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("OpenMe.ser") ) ) {
            System.out.println("Writing o");
            out.writeObject(test);
            out.close();
        } catch( FileNotFoundException e ) {
            e.printStackTrace();
        } catch( IOException e ) {
            e.printStackTrace();
        }

        System.out.println("O has been written");
        // Deserialization
        try( ObjectInputStream in = new ObjectInputStream( new FileInputStream( "OpenMe.ser" ) ) ) {
            System.out.println("Reading o");
            OpenHashSet readMe = (OpenHashSet) in.readObject();
            // Check that the opened file/OpenHashSet,
            // the same one is as the one that we saved
            Assert.assertEquals(readMe, test);
            in.close();
        } catch( FileNotFoundException e ) {
            e.printStackTrace();
        } catch( IOException e ) {
            e.printStackTrace();
        } catch( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        System.out.println("O has been read");
    }
}