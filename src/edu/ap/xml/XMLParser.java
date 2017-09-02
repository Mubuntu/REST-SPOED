package edu.ap.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {

	private  String INPUTFILE = "C:\\Users\\Public\\TI\\REST-SPOED\\registraties.txt";

	/**
	 * Get all races from the xml file and return them in html format
	 */
	public  String getRegistraties() {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>Registraties</h2>";

			NodeList races = doc.getElementsByTagName("registratie");

			for (int i = 0; i < races.getLength(); i++) {
				Node nNode = races.item(i);
				Element eElement = (Element) nNode;

				result += "<br/><b>interventie : </b>" + eElement.getAttribute("interventie");
				result += "<br/><b>diagnose : </b>" + eElement.getAttribute("diagnose");
				result += "<br/>";
			}

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Get the race with race_id and return them in html format
	 */
	public String getRegistratie(String registratie_id) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>Registratie</h2>";

			NodeList races = doc.getElementsByTagName("registratie");

			for (int i = 0; i < races.getLength(); i++) {

				Node nNode = races.item(i);
				Element eElement = (Element) nNode;

				if (eElement.getAttribute("id").equalsIgnoreCase(registratie_id)) {
					result += "<br/><b>interventie : </b>" + eElement.getAttribute("interventie");
					result += "<br/><b>diagnose : </b>" + eElement.getAttribute("diagnose");
					result += "<br/>";
				}
			}

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Get all runners for the race with race_id and return them in valid html
	 * format
	 */
	public  String getPatients(String registratie_id) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>Registratie</h2>";

			NodeList registraties = doc.getElementsByTagName("registratie");

			for (int i = 0; i < registraties.getLength(); i++) {

				Node registratie = registraties.item(i);
				Element eElement = (Element) registratie;

				if (eElement.getAttribute("id").equalsIgnoreCase(registratie_id)) {
					NodeList runners = eElement.getElementsByTagName("patient");
					for (int j = 0; j < runners.getLength(); j++) {
						Node runner = runners.item(j);
						Element eElement2 = (Element) runner;
						result += "<br/><b>First Name : </b>" + eElement2.getAttribute("first_name");
						result += "<br/><b>Last Name : </b>" + eElement2.getAttribute("last_name");
						result += "<br/><b>geboortedatum : </b>" + eElement2.getAttribute("geboortedatum");
					}
				}
			}

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Delete the rqce with race_id and return all races in valid format
	 */
	public String deleteRegistratie(String registratie_id) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList races = doc.getElementsByTagName("registratie");

			for (int i = 0; i < races.getLength(); i++) {

				Node nNode = races.item(i);
				Element eElement = (Element) nNode;

				if (eElement.getAttribute("id").equalsIgnoreCase(registratie_id)) {
					eElement.getParentNode().removeChild(eElement);
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new StringWriter());
					transformer.transform(source, result);
				}
			}

			return this.getRegistraties();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Add a race and return all races in html format
	 */
	public String addRegistratie(String xml) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// set validating false to enable copying
		// node from one document to another
		dbFactory.setValidating(false);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
			Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
			Element element = (Element) doc2.getDocumentElement();
			// imports a node from doc2 document to doc1, without altering
			// or removing the source node from the original document
			Node copiedNode = doc1.importNode(element, true);
			// adds the node to the end of the list of children of this node
			doc1.getDocumentElement().appendChild(copiedNode);

			/*
			 * FileWriter fw = new FileWriter(INPUTFILE);
			 * fw.write(doc1.toString()); fw.close();
			 */
			// write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);

			return this.getRegistraties();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Add a runner to race with race_id and return all races in html format
	 */
	public  String addPatient(String registratie_id, String xml) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// set validating false to enable copying
		// node from one document to another
		dbFactory.setValidating(false);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
			Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
			Element element = (Element) doc2.getDocumentElement();
			// imports a node from doc2 document to doc1, without altering
			// or removing the source node from the original document
			Node copiedNode = doc1.importNode(element, true);
			// adds the node to the end of the list of children of this node
			doc1.getElementById(registratie_id).appendChild(copiedNode);
			/*
			 * FileWriter fw = new FileWriter(INPUTFILE);
			 * fw.write(doc1.toString()); fw.close();
			 */
			// write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);

			return this.getRegistraties();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
//	public static void main(String[] args) {
//		String string = getPatients("1");
//		String s2 = getRegistraties();
//		String s3 = "<patient> </patient>";
//		
//		System.out.println(string);
//		System.out.println(s2);
//	}
}
