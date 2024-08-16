package classwork.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MyParserClass {

    ObjectMapper objectMapper = new ObjectMapper();

    public void toJson() throws IOException {
        Recipe recipe = new Recipe("Salad", Arrays.asList(new Ingredient("Tomato", 2), new Ingredient("Cucumber", 1)), 3);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/temp/recipe.json"), recipe);
        String string = objectMapper.writeValueAsString(recipe);
    }

    public void fromJson() throws IOException {
        Recipe recipe = objectMapper
                .readValue(new File("src/test/resources/temp/recipe.json"), Recipe.class);
        System.out.println(recipe);
    }

    public void toYaml() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(
                        new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)),
                3);
        YAMLMapper xmlMapper = new YAMLMapper();
        xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/temp/recipe.yaml"), recipe);
        String xml = xmlMapper.writeValueAsString(recipe);
    }

    public void fromYaml() throws IOException {
        YAMLMapper xmlMapper = new YAMLMapper();
        Recipe recipe = xmlMapper
                .readValue(new File("src/test/resources/temp/recipe.yaml"), Recipe.class);
        System.out.println(recipe);
    }

    public void toXml() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(
                        new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)),
                3);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/temp/recipe.xml"), recipe);
        String xml = xmlMapper.writeValueAsString(recipe);
    }

    public void fromXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Recipe recipe = xmlMapper
                .readValue(new File("src/test/resources/temp/recipe.xml"), Recipe.class);
        System.out.println(recipe);
    }
}
