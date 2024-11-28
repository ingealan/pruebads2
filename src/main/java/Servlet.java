
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

//Anotacion
@WebServlet({"/calculoservlet"})
public class Servlet extends HttpServlet {
    //Generamos un metodo para calcular si un numero es primo
    //Tomamos como parametro el numero a iterar
    public boolean primo(int numerop) {
        boolean primo = true;
        for (int i = 2; i < numerop; i++) {
            if (numerop % i == 0) {
                //Retornamos un valor falso en el caso que no sea primo
                return primo = false;
            }
        }
        //Retornamos un true en el caso que sea primo
        return primo;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n1 = Integer.parseInt(req.getParameter("primernum"));
        int n2 = Integer.parseInt(req.getParameter("segunum"));
        int cont=0;

        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Lista de productos</title>");
            out.println("<style>");
            out.println("/* Estilos generales */");
            out.println("body { font-family: 'Arial', sans-serif; background: #2c3e50; color: #ecf0f1; margin: 0; padding: 0; text-align: center; }");
            out.println("h1 { font-size: 48px; margin-top: 50px; color: #ecf0f1; text-shadow: 3px 3px 5px rgba(0, 0, 0, 0.3); }");
            out.println("a { text-decoration: none; font-size: 22px; color: #3498db; padding: 15px 30px; border-radius: 30px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); transition: all 0.3s ease; }");
            out.println("a:hover { background-color: #3498db; color: #ecf0f1; transform: scale(1.1); box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); }");
            out.println("table { margin-top: 30px; width: 80%; margin-left: auto; margin-right: auto; border-collapse: collapse; background-color: #34495e; }");
            out.println("th, td { padding: 15px; text-align: center; border: 1px solid #ddd; color: #ecf0f1; }");
            out.println("th { background-color: #3498db; }");
            out.println("td { background-color: #2c3e50; }");
            out.println("body { background: linear-gradient(to right, #2980b9, #8e44ad, #16a085); background-size: 400% 400%; animation: gradientAnimation 10s ease infinite; }");
            out.println("@keyframes gradientAnimation { 0% { background-position: 0% 50%; } 50% { background-position: 100% 50%; } 100% { background-position: 0% 50%; } }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            //Bucle para iterar en el rango
            for (int i = n1; i < n2; i++) {
                //Envia el numero iterado al metodo que verifica si es primo o no
                if (primo(i)) {
                    out.println("<p>" + i + "</p>");
                    cont++;
                }
            }
            //Imprime los datos
            out.println("<p>Cantidad de numeros primos :"+cont+"</p>");
            out.println("<p>El rango comienza en el numero :"+n1+"</p>");
            out.println("<p>El rango termina en el numero :"+n2+"</p>");

            out.println("</body>");
            out.println("</html>");
        }

    }
}
