import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcola")
public class CalculatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operazione = request.getParameter("operazione");
        int result=0;
        switch (operazione) {
            case "addizione":
                result=Integer.parseInt(request.getParameter("numero1"))+Integer.parseInt(request.getParameter("numero2"));
                break;
            case "sottrazione":
                result=Integer.parseInt(request.getParameter("numero1"))-Integer.parseInt(request.getParameter("numero2"));
                break;
            case "moltiplicazione":
                result=Integer.parseInt(request.getParameter("numero1"))*Integer.parseInt(request.getParameter("numero2"));
                break;
            case "divisione":
                result=Integer.parseInt(request.getParameter("numero1"))/Integer.parseInt(request.getParameter("numero2"));
                break;
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Risultato</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Risultato: "+result+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
