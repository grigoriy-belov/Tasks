package com.greg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@WebServlet(urlPatterns = "")
public class TossCoinService extends HttpServlet {

    private String responseTemplate;
    private Random random;

    @Override
    public void init() throws ServletException {
        try {
            URI templateURI = getClass().getResource("/template/demo.html").toURI();
            byte[] bytes = Files.readAllBytes(Paths.get(templateURI));
            responseTemplate = new String(bytes, StandardCharsets.UTF_8);
            random = new Random();
        } catch (IOException | URISyntaxException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        boolean result = random.nextBoolean();

        String text = result ? "Head" : "Tail";

        String responseBody = responseTemplate.replace("{result}", text);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print(responseBody);

    }
}
