package com.gdsc;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculateAge")
public class AgeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        it's id in <input>
        String dobStr = req.getParameter("dob");
        String currentDateStr = req.getParameter("currentDate");

        if (dobStr == null || dobStr.isEmpty() || currentDateStr == null || currentDateStr.isEmpty()) {
            out.println("<html><body>");
            out.println("<h2>Calculate Age</h2>");
            out.println("<h3>Result</h3>");
            out.println("<p>Error: Please provide both dates.</p>");
            out.println("</body></html>");
            return;
        }

        LocalDate dob = LocalDate.parse(dobStr);
        LocalDate currentDate = LocalDate.parse(currentDateStr);

        Period period = Period.between(dob, currentDate);
        long totalDays = ChronoUnit.DAYS.between(dob, currentDate);
        long totalHours = ChronoUnit.HOURS.between(dob.atStartOfDay(), currentDate.atStartOfDay());
        long totalMinutes = ChronoUnit.MINUTES.between(dob.atStartOfDay(), currentDate.atStartOfDay());
        long totalSeconds = ChronoUnit.SECONDS.between(dob.atStartOfDay(), currentDate.atStartOfDay());

        out.println("<html><body>");
        out.println("<h2>Calculate Age</h2>");
        out.println("<h3>Result</h3>");
        out.println("<p>Age: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days</p>");
        out.println("<p>or " + totalDays + " days</p>");
        out.println("<p>or " + totalHours + " hours</p>");
        out.println("<p>or " + totalMinutes + " minutes</p>");
        out.println("<p>or " + totalSeconds + " seconds</p>");
        out.println("</body></html>");

	}
	
}
