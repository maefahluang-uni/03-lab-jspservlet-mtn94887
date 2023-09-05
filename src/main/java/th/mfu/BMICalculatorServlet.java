package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");

        double weight = Double.parseDouble(weightStr); 
        double height = Double.parseDouble(heightStr); 

        //TODO: calculate bmi
        int calbmi = (int)Math.round(weight/(height*height));

        //TODO: determine the built from BMI
        String builtType; 
        if (calbmi < 18.5) {
            builtType = "underweight";
        } else if (calbmi >= 18.5 && calbmi < 25) {
            builtType = "normal";
        } else if (calbmi >= 25 && calbmi < 30) {
            builtType = "overweight";
        } else if (calbmi >= 30 && calbmi < 35) {
            builtType = "obese";
        } else {
            builtType = "extremely obese";
        }

        //TODO: add bmi and built to the request's attribute
        request.setAttribute("calbmi",calbmi);
        request.setAttribute("builtType", builtType);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
    }
    
}
