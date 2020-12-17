import com.example.ProjetJEE.Article;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.HashMap;

@WebListener()
public class ListenerArticle implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public ListenerArticle() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashMap<Long,Article> listeArticle = new HashMap<>();
        Article article = new Article(987456131, "pdffra98", "Pot de fleur ", 20, 550);
        listeArticle.put(article.getCodeBarre(),article);

        Article article2 = new Article(456987123, "bafra45", "Barquette de fraises", 3, 550);
        listeArticle.put(article2.getCodeBarre(),article2);

        Article article3 = new Article(714896574, "balcfra71", "Mug", 7, 2000);
        listeArticle.put(article3.getCodeBarre(),article3);

        context.setAttribute("listeArticle",listeArticle);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session= se.getSession();
        boolean isConnected;
        isConnected = false;
        session.setAttribute("isConnected",isConnected);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
