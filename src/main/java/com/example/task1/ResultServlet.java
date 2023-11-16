package com.example.task1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Результаты опроса</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Результаты опроса:</h2>");


        String answer1 = request.getParameter("question1");
        String answer2 = request.getParameter("question2");


        out.println("<p>Ответ на вопрос 1: " + answer1 + "</p>");
        out.println("<p>Ответ на вопрос 2: " + answer2 + "</p>");


        HttpSession session = request.getSession();


        Map<String, Integer> statistics = (Map<String, Integer>) session.getAttribute("statistics");
        if (statistics == null) {
            statistics = new HashMap<>();
            session.setAttribute("statistics", statistics);
        }


        updateStatistics(statistics, answer1);
        updateStatistics(statistics, answer2);


        out.println("<h3>Статистика выборов в текущей сессии:</h3>");
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            out.println("<p>" + entry.getKey() + ": " + entry.getValue() + " раз</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }


    private void updateStatistics(Map<String, Integer> statistics, String answer) {
            statistics.put(answer, statistics.getOrDefault(answer, 0) + 1);
    }
}
