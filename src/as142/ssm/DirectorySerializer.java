package as111.ssm;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class DirectorySerializer {
	
	public static void saveDirectory(Directory directory, String filePath) {
		try {
			File file = new File(filePath);
			JAXBContext jaxb = JAXBContext.newInstance(Directory.class);
			Marshaller mar = jaxb.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mar.marshal(directory, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Directory loadDirectory(String filePath) {
		try {
			File file = new File(filePath);
			JAXBContext jaxb = JAXBContext.newInstance(Directory.class);
			Unmarshaller unmar = jaxb.createUnmarshaller();
			Directory directory = (Directory) unmar.unmarshal(file);
			return directory;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}
