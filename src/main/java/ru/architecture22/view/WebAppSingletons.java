package ru.architecture22.view;

import ru.architecture22.view.rest.ReaderApi;
import ru.architecture22.view.rest.WriterApi;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class WebAppSingletons extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public WebAppSingletons() {
        singletons.add(new ReaderApi());
        singletons.add(new WriterApi());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}