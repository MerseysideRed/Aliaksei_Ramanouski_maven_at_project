package classwork.parsing;

import java.io.IOException;

public class MyParserRunner {
    public static void main(String[] args) throws IOException {
        MyParserClass myParserClass = new MyParserClass();

        myParserClass.toJson();
        myParserClass.fromJson();

        myParserClass.toXml();
        myParserClass.fromXml();

        myParserClass.toYaml();
        myParserClass.fromXml();
    }
}
