package application.view;


	import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
		public static ArrayList<String> specs=new ArrayList<String>();
		static int i=0;
		static int j=0;
		static int h=0;
	
	    public static void xml() throws FileNotFoundException, UnsupportedEncodingException {
	        
	        try {
	        	System.out.println(CompilerController.tree);
	        	Attribut.add("Switchs");
	        	Attribut.add("IP");
	        	Attribut.add("Type");
	        	Attribut.add("Type");
	        	Attribut.add("Id");
	        	Attribut.add("matchfield");
	        	Attribut.add("number_entry");
	        	specs.add("Switch");
	        	specs.add("path_processing");
	        	specs.add("Table");
	        	//specs.add("table");
	        	//specs.add("matchfield");
	        	//specs.add("number_entry");
	        	//System.out.println(Attribut);
	        	
	        	//PrintWriter writer = new PrintWriter("constraints.xml","UTF-8");
	        	//writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"");
	        	//writer.println("<switch>");
	        	//writer.println("<path_processing constraints=\"True\" >");
	        	
	        	
	        	
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            Document doc = factory.newDocumentBuilder().newDocument();
	            Element rootElement = doc.createElement("Switchs");
	            doc.appendChild(rootElement);

	            // Get tree root...
	            TreeItem<Object> root =  CompilerController.tree.getRoot();
	           // System.out.println(root.getChildren());
	            //System.out.println(rootElement);

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
	    	if (i==3 && j<specs.size() ) {
	    	j=2;
	    	}
	        Element parentElement = doc.getOwnerDocument().createElement(specs.get(j));
	        doc.appendChild(parentElement);
	        
	    	
	        //ArrayList<String> treechild=new ArrayList<String>();
	        Iterator it=treeNode.getChildren().iterator();
	        //treechild= (ArrayList) treeNode.getChildren();
	       
	        //System.out.println(treeNode.getChildren());
	        // Apply properties to root element...
	        //System.out.println(treeNode.getValue());
	        //Iterator it=treeNode.getChildren().iterator();
	        //while (it.hasNext()) {
	        
	        Attr attrName;
	        //if (treechild.size()!=0){
	        //for (h=0 ;h < treechild.size();h++){
	        //if (i>=4) i=0;
	        if(it.hasNext()){ 
	        //System.out.println("jouj");
	        System.out.println(i);
	        if (i==0){
	        parentElement = doc.getOwnerDocument().createElement("Spec");
	        doc.appendChild(parentElement);}
	        if (i==3){
		        parentElement = doc.getOwnerDocument().createElement("Path_processing");
		        doc.appendChild(parentElement);}
	        attrName = doc.getOwnerDocument().createAttribute(Attribut.get(i));
	        attrName.setNodeValue(treeNode.getValue().toString());
	        parentElement.getAttributes().setNamedItem(attrName);
	        //j++;
	        //System.out.println("ffffffffff");
	        //i++;
	        //} 
	        i++;
	        }
	        else{
	        
	        //j=0;	
	        attrName = doc.getOwnerDocument().createAttribute(Attribut.get(i));
	        //System.out.println("ddddd");
	        //System.out.println(treeNode.getValue().toString());
	        attrName.setNodeValue(treeNode.getValue().toString());
	        parentElement.getAttributes().setNamedItem(attrName);
	        i++;
	        if (i==7){
	        	i=3;
	        	
	        }
	        //j++;
	        //System.out.println(j);
	        }
	        //Enumeration kiddies = (Enumeration) treeNode.getChildren();
	        
	        while (it.hasNext() ) {
	            //TreeNode child = (TreeNode) kiddies.nextElement();
	            TreeItem<Object> child =(TreeItem) it.next();
	            //System.out.println(child);
	            //i++;
	            //j++;
	            parseTreeNode(child, parentElement);
	            
	        }

	    }
}
