package application.view;


	import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.swing.tree.DefaultTreeModel;
	import javax.swing.tree.TreeModel;
	import javax.swing.tree.TreeNode;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.OutputKeys;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Node;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

	public class TreeviewXml {
		public static  ArrayList<String> Attribut=new ArrayList<String>();
		static int i=0;
	
	    public static void xml() {
	        
	        try {
	        	Attribut.add("Switchs");
	        	Attribut.add("IP");
	        	Attribut.add("Type");
	        	Attribut.add("Constraints");
	        	System.out.println(Attribut);
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            Document doc = factory.newDocumentBuilder().newDocument();
	            Element rootElement = doc.createElement("Switchs");
	            doc.appendChild(rootElement);

	            // Get tree root...
	            TreeItem<Object> root =  CompilerController.tree.getRoot();
	            System.out.println(root.getChildren());
	            System.out.println(rootElement);

	            parseTreeNode(root, rootElement);

	            // Save the document to disk...

	            Transformer tf = TransformerFactory.newInstance().newTransformer();
	            tf.setOutputProperty(OutputKeys.INDENT, "yes");
	            tf.setOutputProperty(OutputKeys.METHOD, "xml");
	            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            DOMSource domSource = new DOMSource(doc);
	            StreamResult sr = new StreamResult(new File("/home/abdel/TreeModel.xml"));
	            tf.transform(domSource, sr);

	        } catch (ParserConfigurationException | TransformerException ex) {
	            ex.printStackTrace();
	        }
	    }

	    private static void parseTreeNode(TreeItem<Object> treeNode, Node doc) {

	        Element parentElement = doc.getOwnerDocument().createElement("Specs");
	    	
	        doc.appendChild(parentElement);
	        Iterator it=treeNode.getChildren().iterator();
	        // Apply properties to root element...
	        System.out.println(treeNode.getValue());
	        //Iterator it=treeNode.getChildren().iterator();
	        //while (it.hasNext()) {
	        
	        Attr attrName;
	        if(it.hasNext()){
	        attrName = doc.getOwnerDocument().createAttribute(Attribut.get(i));
	        attrName.setNodeValue(treeNode.getValue().toString());
	        parentElement.getAttributes().setNamedItem(attrName);
	        }
	        else{attrName = doc.getOwnerDocument().createAttribute("Constraints");
	        attrName.setNodeValue(treeNode.getValue().toString());
	        parentElement.getAttributes().setNamedItem(attrName);}
	        //Enumeration kiddies = (Enumeration) treeNode.getChildren();
	        
	        while (it.hasNext()) {
	            //TreeNode child = (TreeNode) kiddies.nextElement();
	            TreeItem<Object> child =(TreeItem) it.next();
	            i++;
	            parseTreeNode(child, parentElement);
	            
	        }

	    }
}
