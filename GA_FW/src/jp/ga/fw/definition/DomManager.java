package jp.ga.fw.definition;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jp.ga.fw.dta.GaConfigValues;

public class DomManager {
	@SuppressWarnings("unchecked")
	public void load(String filePath) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		Path path = Paths.get(filePath);
		String content = molding(Files.readString(path)); // xml�t�@�C���̓��e�𐬌`���Ċi�[
		System.out.println(content);
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(new ByteArrayInputStream(content.getBytes()));

		Element root = document.getDocumentElement();

		List<List<Object>> rootChild = nodeCheck(root);

		for (List<Object> node : rootChild) {
			System.out.println(">>" + node);
			if (node.get(0).equals("Genetic")) {
				GeneticNodeProcess((List<Node>) node.get(2));
			}
		}

	}

	/**
	 * �m�[�h�`�F�b�N �m�[�h�̎q�v�f���`�F�b�N���A�z��Ɋi�[���� �z�� �v�f�P�F�^�O�� �v�f�Q�F�������F�����l �v�f�R�F�l
	 * 
	 * @param element
	 * @return
	 */
	private List<List<Object>> nodeCheck(Element element) {

		List<List<Object>> resp = new ArrayList<>();
		NodeList nodes = element.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			List<Object> nodeValues = new ArrayList<>();
			Node node = nodes.item(i);
			// �^�O���擾
			String tagName = node.getNodeName();
			nodeValues.add(tagName);

			// �����l�擾
			Map<String, String> attMap = new HashMap<>();

			NamedNodeMap attributes = node.getAttributes();
			for (int j = 0; j < attributes.getLength(); j++) {
				Node attribute = attributes.item(j);
				attMap.put(attribute.getNodeName(), attribute.getNodeValue());
			}

			nodeValues.add(attMap);

			// �q�v�f�擾
			NodeList children = node.getChildNodes();
			List<Node> childrenList = new ArrayList<>();
			for (int j = 0; j < children.getLength(); j++) {
				Node n = children.item(j);
				childrenList.add(n);
			}
			nodeValues.add(childrenList);

			resp.add(nodeValues);
		}
		return resp;
	}

	/**
	 * xml�̓��e����TAB�A���s���폜���ĕԂ� return ���`��xml������
	 */
	private String molding(String xmlStr) {
		return xmlStr.replaceAll("<!--[\\s\\S]*?-->", "").replaceAll("	", "").replaceAll("\n", "").replaceAll("\r", "")
				.replaceAll("(?<=>)[ +](?=<)", "").replaceAll("(?<=>)[	+](?=<)", "");
	}

	/**
	 * GeneticNode�̏ꍇ�̏���
	 * 
	 * @param node
	 */
	private void GeneticNodeProcess(List<Node> node) {
		GaConfigValues config = GaConfigValues.getInstance();
		for (Node n : node) {

			NamedNodeMap att = n.getAttributes();
			
			if (n.getNodeName().equals("Logic")) {
				String type = att.getNamedItem("type").getNodeValue();
				String incidence = null;
				if(Objects.nonNull(att.getNamedItem("incidence"))) {
					incidence = att.getNamedItem("incidence").getNodeValue() ;
				}
				String classPath = n.getFirstChild().getFirstChild().getNodeValue();
				
				if (type.equals("Init")) {
					config.setClassPathInit(classPath);
				}
				
				if (type.equals("Selection")) {
					config.setIncidenceSelection(Double.valueOf(incidence));
					config.setClassPathSelection(classPath);
				}

				if (type.equals("CrossOver")) {
					config.setIncidenceCrossOver(Double.valueOf(incidence));
					config.setClassPathCrossOver(classPath);
				}

				if (type.equals("Mutation")) {
					config.setIncidenceMutation(Double.valueOf(incidence));
					config.setClassPathMutation(classPath);
				}
				
				
			}
			if (n.getNodeName().equals("Num")) {
				config.setNum(Integer.valueOf(n.getFirstChild().getNodeValue()));
			}
		}
	}
}
