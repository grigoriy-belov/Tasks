package com.greg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@WebServlet(urlPatterns = "/ip")
public class UserInfoService extends HttpServlet {

    private ConcurrentMap<String, String> clientInfo;

    @Override
    public void init() {
            clientInfo = new ConcurrentHashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String remoteHost = req.getRemoteHost();
        String userAgent = req.getHeader("User-Agent");

        clientInfo.putIfAbsent(remoteHost, userAgent);

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>IP</title>");
        out.println("</head>");
        out.println("<body>");

        for (Map.Entry<String, String> entry : clientInfo.entrySet()) {
            out.println("<p><b>" + entry.getKey() + " :: " + entry.getValue() +"</b><p>");
        }

        out.println("<body>");
        out.println("</html>");

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
