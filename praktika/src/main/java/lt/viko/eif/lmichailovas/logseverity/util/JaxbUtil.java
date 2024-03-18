/**
 * The JaxbUtil class provides utility methods for XML serialization and deserialization using JAXB.
 */
package lt.viko.eif.lmichailovas.logseverity.util;

import lt.viko.eif.lmichailovas.logseverity.model.Account;
import lt.viko.eif.lmichailovas.logseverity.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

public class JaxbUtil {

    /**
     * Converts an object to XML format and writes it to a file named "logs.xml".
     * @param object The object to be converted to XML.
     * @param <T> Type of the object.
     * @throws RuntimeException if any error occurs during the serialization process.
     */
    public static <T> void convertToXML(T object){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance( object.getClass() );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            jaxbMarshaller.marshal( object, new File( "logs.xml" ) );
            jaxbMarshaller.marshal( object, System.out );
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Unmarshals XML data from a file and converts it to an object.
     * @param object The type of object to unmarshal to.
     * @param file1 The path to the XML file to be unmarshalled.
     * @param <T> Type of the object.
     * @throws JAXBException if any error occurs during the deserialization process.
     */
    public static <T> void Unmarshaling(T object, String file1) throws JAXBException {
        File file = new File(file1);
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object1 = (T) jaxbUnmarshaller.unmarshal(file);
        System.out.println(object1);
    }
}