package ru.architecture22.view;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

/**
 * Консольное приложение.
 */
public class WebAppServer {

    public static void main(String[] argv) {
        startWebServer();
    }

    /**
     * Запускает web-сервер. По окончании работы требуется ручная остановка процесса.
     */
    private static void startWebServer() {
        Undertow.Builder builder = Undertow.builder()
                .addHttpListener(8188, "0.0.0.0");

        UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);
        server.deploy(WebAppSingletons.class);

        System.out.println("Сервер запущен: http://127.0.0.1:8188/reader/");
    }
}