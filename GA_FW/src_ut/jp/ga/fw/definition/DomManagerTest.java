package jp.ga.fw.definition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import jp.ga.fw.dta.GaConfigValues;

public class DomManagerTest {
	String FILE_PATH= "C:\\Users\\nori\\Desktop\\Nori'sData\\Documents\\Java\\Eclipse\\workspace\\GeneticAlgorithmsFW\\GA_FW\\ut\\dat\\GaConfig.xml";
	
	/**
	 * ファクトリーメソッドテスト01
	 * 期待値　GaConfigValuesのインスタンスが返ってくること
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void testCase01() throws NoSuchMethodException, SecurityException, SAXException, IOException, ParserConfigurationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Path path = Paths.get(FILE_PATH);
		String content = Files.readString(path);	
		content =content.replaceAll("<!--[\\s\\S]*?-->", "").
				replace("	", "").replace("\n", "").replace("\r", "").replaceAll("(?<=>)[ +](?=<)", "");
		System.out.println(content);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new ByteArrayInputStream(content.getBytes()));
		Element root = document.getDocumentElement();
		
		Class<?> domManager = DomManager.class;
		DomManager dom = new  DomManager();
		Method nodeCheck = domManager.getDeclaredMethod("nodeCheck", Element.class);
		nodeCheck.setAccessible(true);
		
		List<List<Object>> res = (List<List<Object>>) nodeCheck.invoke(dom, root);

		assertEquals("Logic", res.get(0).get(0));
		assertEquals("test", ((Map<String,String>) res.get(0).get(1)).get("id"));
		assertEquals("TEST", ((Node) res.get(0).get(2)).getNodeValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCase02() throws NoSuchMethodException, SecurityException, SAXException, IOException, ParserConfigurationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Path path = Paths.get(FILE_PATH);
		String content = Files.readString(path);	
		content =content.replaceAll("<!--[\\s\\S]*?-->", "").
				replace("	", "").replace("\n", "").replace("\r", "").replaceAll("(?<=>)[ +](?=<)", "");
		System.out.println(content);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new ByteArrayInputStream(content.getBytes()));
		Element root = document.getDocumentElement();
		
		Class<?> domManager = DomManager.class;
		DomManager dom = new  DomManager();
		Method nodeCheck = domManager.getDeclaredMethod("nodeCheck", Element.class);
		nodeCheck.setAccessible(true);
		
		List<List<Object>> res = (List<List<Object>>) nodeCheck.invoke(dom, root);
		Node node = (Node) res.get(1).get(2);
		assertEquals("TEST2", node.getFirstChild().getNodeValue());
		
	}
	

	@Test
	public void testCase03() throws Exception{		
		String file = "C:\\Users\\nori\\Desktop\\Nori'sData\\Documents\\Java\\Eclipse\\workspace\\GeneticAlgorithmsFW\\GA_FW\\dat\\GaConfig.xml";
		DomManager dm = new DomManager();
		dm.load(file);
		GaConfigValues config = GaConfigValues.getInstance();
		assertEquals(Double.valueOf(0.1), config.getIncidenceCrossOver());
		assertEquals(Double.valueOf(1), config.getIncidenceSelection());
		assertEquals(Double.valueOf(0.1), config.getIncidenceMutation());
		assertEquals(Integer.valueOf(5), config.getNum());
	}
}
