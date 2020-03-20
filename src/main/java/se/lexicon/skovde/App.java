package se.lexicon.skovde;

import se.lexicon.skovde.io.FileIO;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Collection<String> fromFile = FileIO.getInstance().read(new File("storage/strings.txt"), TreeSet::new);

        fromFile.forEach(System.out::println);

    }
}
