package se.lexicon.skovde.io;

import java.io.*;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FileIO {

    private static final FileIO INSTANCE;

    static {
        INSTANCE = new FileIO();
    }

    private FileIO (){}

    public static FileIO getInstance(){
        return INSTANCE;
    }

    public Collection<String> read(File file, Supplier<Collection<String>> collectionSupplier){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            return reader.lines()
                    .collect(Collectors.toCollection(collectionSupplier));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collectionSupplier.get();
    }

    public Collection<String> write(Collection<String> toWrite, File destination){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            for(String line : toWrite){
                writer.write(line);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return toWrite;
    }

}
