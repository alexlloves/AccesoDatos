/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Lloves
 */
public class XmlListas {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

   
        String[] niños = {"Alex", "David", "Manuel"};
        Integer[] notas = {7, 8, 10};
        Double[] altura = {1.70, 1.90, 2.20};

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document document = implementation.createDocument(null, "guarderia", null);
        document.setXmlVersion("1.0");

        Element nodoElemento = document.createElement("niños");

        for (int i = 0; i < niños.length; i++) {
            Element niño = document.createElement("niño");
            Text t1 = document.createTextNode(niños[i]);
            niño.appendChild(t1);

            Element nota = document.createElement("nota");
            Text t2 = document.createTextNode(Integer.toString(notas[i]));
            nota.appendChild(t2);
            niño.appendChild(nota);

            Element altu = document.createElement("altura");
            Text t3 = document.createTextNode(Double.toString(altura[i]));
            altu.appendChild(t3);
            niño.appendChild(altu);
            
            nodoElemento.appendChild(niño);
        }
        
        document.getDocumentElement().appendChild(nodoElemento);

        DOMSource source = new DOMSource(document);
        Result result = new StreamResult(new File("guarderia.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

    }
}
