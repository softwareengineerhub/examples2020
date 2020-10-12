package com.app.dao;

import com.app.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class XmlDataProcessor extends AbstractDataProcessor {

    @Override
    protected List<User> parse(InputStream in) {
        List<User> users = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(in);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("User");
            IntStream.range(0, nList.getLength())
                    .mapToObj(nList::item)
                    .filter(child -> child.getNodeType() == Node.ELEMENT_NODE)
                    .map(child -> (Element) child)
                    .forEach(
                            eElement -> {
                                try {
                                    User user = userFromElement(eElement);
                                    users.add(user);
                                } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                                }
                            });


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User userFromElement(Element element) throws IllegalArgumentException {

        String name = "";
        String role = "";
        String password = "";

        BiFunction<Element, String, String> itemByTag = (e, t)
                -> e.getElementsByTagName(t).item(0).getTextContent();

        try {
            name = itemByTag.apply(element,"name");
            role = itemByTag.apply(element,"role");
            password = itemByTag.apply(element,"password");

            if (!(name.isEmpty() || password.isEmpty() || role.isEmpty())) {
                return new User(name, role, password);
            } else
                throw new IllegalArgumentException(
                        String.format("Unable to create user with name=%s, role=%s, password=%s", name, role, password)
                );
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(
                    String.format("Unable to create user with name=%s, role=%s, password=%s", name, role, password));
        }
    }


}
