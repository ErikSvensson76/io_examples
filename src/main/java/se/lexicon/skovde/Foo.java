package se.lexicon.skovde;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Foo {

    public <R,T> Collection<R> foo(Function<T, R> mapper, Collection<T> collection, Supplier<Collection<R>> supplier){
        return collection.stream()
                .map(mapper)
                .collect(Collectors.toCollection(supplier));
    }

}
