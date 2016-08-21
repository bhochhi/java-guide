package xmltohash;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class MainClass {

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File(MainClass.class.getResource("employees.xml").getPath());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Node root = doc.getDocumentElement();
			root.normalize();
			ParseXML parser = new ParseXML();
			Map<String, String> xmlHash = parser.getHashMap(root);

			for (Map.Entry<String, String> entry : xmlHash.entrySet()) {
				System.out.println(entry.getKey() + " ---> " + entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
