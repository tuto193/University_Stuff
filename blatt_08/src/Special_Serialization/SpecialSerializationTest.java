package Special_Serialization;

import java.io.*;
import test.Assert;

public class SpecialSerializationTest {
    public static void main( String[] args ) {
        int tSize = 50;
        HashFunction function = new DefaultHashFunction();
        OpenHashSet test = new OpenHashSet( tSize, function );

        for( int i = 0; i < tSize; i++ ) {
            String add = "" + i;
            test.insert(add);
        }

        // Serialization

        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("OpenMe.ser") ) ) {
            out.writeObject(test);
        } catch( FileNotFoundException e ) {
            e.printStackTrace();
        } catch( IOException e ) {
            e.printStackTrace();
        }

        // Deserialization
        try( ObjectInputStream in = new ObjectInputStream( new FileInputStream( "OpenMe.ser" ) ) ) {
            OpenHashSet readMe = (OpenHashSet) in.readObject();
            // Check that the opened file/OpenHashSet,
            // the same one is as the one that we saved
            Assert.assertEquals(readMe, test);
        } catch( FileNotFoundException e ) {
            e.printStackTrace();
        } catch( IOException e ) {
            e.printStackTrace();
        } catch( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}