/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearXML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Lloves
 */
public class XmlMain {

    public static void main(String[] args) {

       try{
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = factory.newDocumentBuilder();
           DOMImplementation implementation = builder.getDOMImplementation();
           
           
           
           Document documento = implementation.createDocument(null, "concesionario", null);
           documento.setXmlVersion("1.0");
           
           Element coches = documento.createElement("coches");
           Element coche = documento.createElement("coche");
           
           
          
           Element matricula = documento.createElement("matricula");
           Text textMatricula = documento.createTextNode("1111AAAA");
           matricula.appendChild(textMatricula);
           coche.appendChild(matricula);
           
           
           
           Element marca = documento.createElement("marca");
           Text textMarca = documento.createTextNode("AUDI");
           marca.appendChild(textMarca);
           coche.appendChild(marca);
           
           
           
           Element precio = documento.createElement("precio");
           Text textPrecio = documento.createTextNode("50.000$");
           precio.appendChild(textPrecio);
           coche.appendChild(precio);
           
           
           coches.appendChild(coche);
           
           
           documento.getDocumentElement().appendChild(coches);
           
           
           
           
           
           DOMSource source = new DOMSource(documento);
           Result result = new StreamResult(new File("concesionario.xml"));
           
           Transformer transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           
           
       }catch(Exception ex){
           System.err.println("error");
       }

  
    
    
    
    
    
    
    
    
    
    
    }
}
