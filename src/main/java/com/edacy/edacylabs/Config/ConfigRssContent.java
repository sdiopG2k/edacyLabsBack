package com.edacy.edacylabs.Config;

import com.edacy.edacylabs.Service.ItemService;
import com.edacy.edacylabs.entities.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ConfigRssContent implements CommandLineRunner {

    private final ItemService itemService;

    public ConfigRssContent(ItemService itemService) throws ParserConfigurationException {
        this.itemService = itemService;
    }
    private  List<Item> getItemListFromUrl() throws ParserConfigurationException, IOException, SAXException {
        log.info("Get Docuemnt Builder");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        log.info("Build Document");
        Document document = builder.parse(String.valueOf(new UriTemplate("https://www.lemonde.fr/rss/en_continu.xml")));

        log.info("Normalize the XML Structure; It's just too important !!");
        document.getDocumentElement().normalize();

        log.info("Here comes the root node");
        Element root = document.getDocumentElement();

        log.info("Get all items");
        NodeList nList = document.getElementsByTagName("item");

        List<Item> itemList = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                log.info("Print each item's detail");
                Element eElement = (Element) node;
                Item item = Item.builder()
                        .title(eElement.getElementsByTagName("title").item(0).getTextContent())
                        .description(eElement.getElementsByTagName("description").item(0).getTextContent())
                        .pubDate(eElement.getElementsByTagName("pubDate").item(0).getTextContent())
                        .link(eElement.getElementsByTagName("link").item(0).getTextContent())
                        .mediaContent(eElement.getElementsByTagName("media:content").item(0).getAttributes().getNamedItem("url").getTextContent())
                        .build();
                //itemService.saveItem(item);
                itemList.add(item);

            }
        }
        return itemService.saveAllItem(itemList);
    }

    @Override
    public void run(String... args) throws Exception {
        getItemListFromUrl();
    }
}
