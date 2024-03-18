package org.example;


    import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "TimeServlet", urlPatterns = {"/time", "/timezone"})

    public class TimeServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String timezone = request.getParameter("timezone");
            ZoneId zoneId = timezone != null ? ZoneId.of(timezone) : ZoneId.of("Africa/Harare");
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);

            out.println("<html><body>");
            out.println("<h1>Time: " + zonedDateTime.format(DateTimeFormatter
                    .ofPattern("yyyy-MM-dd HH:mm:ss z")) + "</h1>");
            out.println("</body></html>");
        }
    }
